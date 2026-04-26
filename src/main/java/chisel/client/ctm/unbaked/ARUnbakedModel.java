package chisel.client.ctm.unbaked;

import chisel.client.ctm.AbstractUnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.baked.ARCTMBlockStateModel;
import chisel.client.ctm.UnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.logic.CTMLogic;
import chisel.core.variant.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quadrant;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.client.renderer.block.dispatch.Variant.SimpleModelState;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ResolvedModel;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.client.resources.model.cuboid.FaceBakery;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.TextureSlots;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.NeoForgeModelProperties;
import net.neoforged.neoforge.client.model.UnbakedElementsHelper;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.*;

public class ARUnbakedModel extends AbstractUnbakedConnectedTextureBlockStateModel {

    public ARUnbakedModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        super(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
    }

    @Override
    public @NonNull MapCodec<? extends CustomUnbakedBlockStateModel> codec() {
        return UnbakedConnectedTextureBlockStateModel.CODEC;
    }

    @Override
    public @NonNull BlockStateModel bake(@NonNull ModelBaker baker) {
        ResolvedModel model = baker.getModel(modelLocation);
        ModelState state = SimpleModelState.DEFAULT.asModelState();
        com.mojang.math.Transformation rootTransform = model.getTopAdditionalProperties().getOrDefault(NeoForgeModelProperties.TRANSFORM, com.mojang.math.Transformation.IDENTITY);
        if (!rootTransform.isIdentity()) {
            state = UnbakedElementsHelper.composeRootTransformIntoModelState(state, rootTransform);
        }

        TextureSlots textureSlots = model.getTopTextureSlots();
        Material baseMaterial = textureSlots.getMaterial("base_texture");
        if (baseMaterial == null) {
            baseMaterial = textureSlots.getMaterial("layer0");
        }
        
        // For AR, we expect a 2x2 overlay texture
        Material overlayARMaterial = textureSlots.getMaterial("overlay_2x2");
        if (overlayARMaterial == null) {
            overlayARMaterial = textureSlots.getMaterial("overlay_texture");
        }
        if (overlayARMaterial == null) {
            overlayARMaterial = textureSlots.getMaterial("layer1");
        }
        Material particleMaterial = textureSlots.getMaterial("particle");

        Material.Baked bakedBase = (baseMaterial != null ? baker.materials().get(baseMaterial, model) : null);
        Material.Baked bakedOverlay = overlayARMaterial != null ? baker.materials().get(overlayARMaterial, model) : null;
        Material.Baked bakedParticle = particleMaterial != null ? baker.materials().get(particleMaterial, model) : (bakedBase != null ? bakedBase : bakedOverlay);

        Map<Direction, BakedQuad[]> baseQuads = new EnumMap<>(Direction.class);
        Map<Direction, BakedQuad[][]> connectedQuads = new EnumMap<>(Direction.class);
        Set<Direction> unculledFaces = new HashSet<>();

        Vector3f from = element.getFirst();
        Vector3f to = element.getSecond();
        int center = 8;

        // AR uses 4 textures in a 2x2 grid
        // We'll repurpose CTMLogicHorizontal/Vertical UV remapping or just manual remapping
        // TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT (0,0, 16,0, 0,16, 16,16)
        int[][] arUVs = {{0, 0}, {16, 0}, {0, 16}, {16, 16}};

        for (Direction face : Direction.values()) {
            Direction cull = getCullface(face, from, to);
            Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

            List<BakedQuad> baseQuadList = new ArrayList<>();
            // connQuads[corner][texture_index]
            BakedQuad[][] connQuads = new BakedQuad[4][4];

            for (int c = 0; c < 4; c++) {
                Vec3i corner = face.getUnitVec3i().offset(planeDirections[c].getUnitVec3i()).offset(planeDirections[(c + 1) % 4].getUnitVec3i()).offset(1, 1, 1).multiply(8);

                Vector3f qFrom = new Vector3f(
                        Math.clamp(Math.min(center - (16 - to.x()), (float) corner.getX() + from.x()), 0, 16),
                        Math.clamp(Math.min(center - (16 - to.y()), (float) corner.getY() + from.y()), 0, 16),
                        Math.clamp(Math.min(center - (16 - to.z()), (float) corner.getZ() + from.z()), 0, 16)
                );
                Vector3f qTo = new Vector3f(
                        to.x() < center ? to.x() : Math.max(center, (float) corner.getX() - (16 - to.x())),
                        to.y() < center ? to.y() : Math.max(center, (float) corner.getY() - (16 - to.y())),
                        to.z() < center ? to.z() : Math.max(center, (float) corner.getZ() - (16 - to.z()))
                );

                CuboidFace.UVs qUvs = getRelativeUVs(face, qFrom, qTo);

                if (bakedBase != null) {
                    CuboidFace baseFace = new CuboidFace(cull, baseTintIndex, "", CTMLogic.NONE.remapUVs(qUvs), Quadrant.R0);
                    baseQuadList.add(FaceBakery.bakeQuad(baker, qFrom, qTo, baseFace, bakedBase, face, state, null, true, baseEmissivity));
                }

                if (bakedOverlay != null) {
                    for (int i = 0; i < 4; i++) {
                        int u = arUVs[i][0];
                        int v = arUVs[i][1];
                        CuboidFace.UVs arUvs = new CuboidFace.UVs(
                                (u + qUvs.minU()) / 2.0f,
                                (v + qUvs.minV()) / 2.0f,
                                (u + qUvs.maxU()) / 2.0f,
                                (v + qUvs.maxV()) / 2.0f
                        );
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", arUvs, Quadrant.R0);
                        if (connFace.cullForDirection() == null) {
                            unculledFaces.add(face);
                        }
                        connQuads[c][i] = FaceBakery.bakeQuad(baker, qFrom, qTo,
                                connFace, bakedOverlay, face, state, null, true, emissivity);
                    }
                }
            }

            if (!baseQuadList.isEmpty()) {
                baseQuads.put(face, baseQuadList.toArray(new BakedQuad[0]));
            }
            connectedQuads.put(face, connQuads);
        }

        return new ARCTMBlockStateModel(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, connectedQuads, bakedParticle != null ? bakedParticle.sprite() : null, variant);
    }
}
