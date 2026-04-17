package chisel.client.ctm.unbaked;

import chisel.client.ctm.AbstractUnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.baked.StandardCTMBlockStateModel;
import chisel.client.ctm.UnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.logic.CTMLogic;
import chisel.core.variant.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quadrant;
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
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.*;

public class StandardUnbakedCTMModel extends AbstractUnbakedConnectedTextureBlockStateModel {

    public StandardUnbakedCTMModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        super(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
    }

    @Override
    public com.mojang.serialization.MapCodec<? extends net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel> codec() {
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
        Material overlayMaterial = textureSlots.getMaterial("overlay_texture");
        Material overlayConnectedMaterial = textureSlots.getMaterial("overlay_connected");
        Material particleMaterial = textureSlots.getMaterial("particle");

        Material layer0Material = textureSlots.getMaterial("layer0");
        Material layer1Material = textureSlots.getMaterial("layer1");

        Material.Baked bakedBase = (baseMaterial != null ? baker.materials().get(baseMaterial, model) : (layer0Material != null ? baker.materials().get(layer0Material, model) : null));
        Material.Baked bakedOverlay = overlayMaterial != null ? baker.materials().get(overlayMaterial, model) : (layer1Material != null ? baker.materials().get(layer1Material, model) : null);
        Material.Baked bakedOverlayConnected = overlayConnectedMaterial != null ? baker.materials().get(overlayConnectedMaterial, model) : (layer1Material != null ? baker.materials().get(layer1Material, model) : null);
        Material.Baked bakedParticle = particleMaterial != null ? baker.materials().get(particleMaterial, model) : (bakedBase != null ? bakedBase : bakedOverlay);

        Map<Direction, BakedQuad[]> baseQuads = new EnumMap<>(Direction.class);
        Map<Direction, BakedQuad[][]> connectedQuads = new EnumMap<>(Direction.class);
        Set<Direction> unculledFaces = new HashSet<>();

        Vector3f from = element.getFirst();
        Vector3f to = element.getSecond();
        int center = 8;

        for (Direction face : Direction.values()) {
            Direction cull = getCullface(face, from, to);
            Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

            List<BakedQuad> baseQuadList = new ArrayList<>();
            BakedQuad[][] connQuads = new BakedQuad[4][CTMLogic.values().length];

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

                if (bakedOverlay != null && bakedOverlayConnected != null) {
                    Material.Baked[] sprites = {bakedOverlay, bakedOverlayConnected};
                    for (CTMLogic logic : CTMLogic.values()) {
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(qUvs), Quadrant.R0);
                        if (connFace.cullForDirection() == null) {
                            unculledFaces.add(face);
                        }
                        connQuads[c][logic.ordinal()] = FaceBakery.bakeQuad(baker, qFrom, qTo,
                                connFace, logic.chooseMaterial(sprites), face, state, null, true, emissivity);
                    }
                }
            }

            if (!baseQuadList.isEmpty()) {
                baseQuads.put(face, baseQuadList.toArray(new BakedQuad[0]));
            }
            connectedQuads.put(face, connQuads);
        }

        return new StandardCTMBlockStateModel(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, connectedQuads, bakedParticle != null ? bakedParticle.sprite() : null, variant);
    }
}
