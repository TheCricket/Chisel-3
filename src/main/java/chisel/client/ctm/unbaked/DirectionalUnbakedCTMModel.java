package chisel.client.ctm.unbaked;

import chisel.client.ctm.AbstractUnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.baked.DirectionalCTMBlockStateModel;
import chisel.client.ctm.UnbakedConnectedTextureBlockStateModel;
import chisel.client.ctm.logic.CTMLogic;
import chisel.client.ctm.logic.CTMLogicHorizontal;
import chisel.client.ctm.logic.CTMLogicVertical;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModelType;
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

public class DirectionalUnbakedCTMModel extends AbstractUnbakedConnectedTextureBlockStateModel {

    public DirectionalUnbakedCTMModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
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
        Material particleMaterial = textureSlots.getMaterial("particle");
        Material overlayTopMaterial = textureSlots.getMaterial("overlay_top");
        Material overlayBottomMaterial = textureSlots.getMaterial("overlay_bottom");
        Material overlaySideMaterial = textureSlots.getMaterial("overlay_side");
        Material overlayHorizontalMaterial = textureSlots.getMaterial("overlay_horizontal");
        Material overlayVerticalMaterial = textureSlots.getMaterial("overlay_vertical");

        Material layer0Material = textureSlots.getMaterial("layer0");
        Material layer1Material = textureSlots.getMaterial("layer1");

        Material.Baked bakedBase = (baseMaterial != null ? baker.materials().get(baseMaterial, model) : (layer0Material != null ? baker.materials().get(layer0Material, model) : null));
        Material.Baked bakedOverlay = overlayMaterial != null ? baker.materials().get(overlayMaterial, model) : (layer1Material != null ? baker.materials().get(layer1Material, model) : null);
        Material.Baked bakedParticle = particleMaterial != null ? baker.materials().get(particleMaterial, model) : (bakedBase != null ? bakedBase : bakedOverlay);

        Material.Baked bakedOverlayTop = overlayTopMaterial != null ? baker.materials().get(overlayTopMaterial, model) : bakedOverlay;
        Material.Baked bakedOverlayBottom = overlayBottomMaterial != null ? baker.materials().get(overlayBottomMaterial, model) : bakedOverlay;
        Material.Baked bakedOverlaySide = overlaySideMaterial != null ? baker.materials().get(overlaySideMaterial, model) : bakedOverlay;
        Material.Baked bakedOverlayHorizontal = overlayHorizontalMaterial != null ? baker.materials().get(overlayHorizontalMaterial, model) : null;
        Material.Baked bakedOverlayVertical = overlayVerticalMaterial != null ? baker.materials().get(overlayVerticalMaterial, model) : null;

        Map<Direction, BakedQuad[]> baseQuads = new EnumMap<>(Direction.class);
        Map<Direction, BakedQuad[]> horizontalQuads = new EnumMap<>(Direction.class);
        Map<Direction, BakedQuad[]> verticalQuads = new EnumMap<>(Direction.class);
        Set<Direction> unculledFaces = new HashSet<>();

        Vector3f from = element.getFirst();
        Vector3f to = element.getSecond();
        int center = 8;

        for (Direction face : Direction.values()) {
            Direction cull = getCullface(face, from, to);
            Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

            List<BakedQuad> baseQuadList = new ArrayList<>();
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

                if (bakedBase != null) {
                    CuboidFace.UVs qUvs = getRelativeUVs(face, qFrom, qTo);
                    CuboidFace baseFace = new CuboidFace(cull, baseTintIndex, "", CTMLogic.NONE.remapUVs(qUvs), Quadrant.R0);
                    Vector3f offsetFrom = new Vector3f(qFrom);
                    Vector3f offsetTo = new Vector3f(qTo);
                    baseQuadList.add(FaceBakery.bakeQuad(baker, offsetFrom, offsetTo, baseFace, bakedBase, face, state, null, true, baseEmissivity));
                }
            }
            if (!baseQuadList.isEmpty()) {
                baseQuads.put(face, baseQuadList.toArray(new BakedQuad[0]));
            }

            CuboidFace.UVs faceUvs = getRelativeUVs(face, from, to);

            if ((variant.getModelType() == VariantModelType.CTMH || variant.getModelType() == VariantModelType.BOOKSHELF) && bakedOverlayHorizontal != null) {
                BakedQuad[] quads = new BakedQuad[CTMLogicHorizontal.values().length];
                Vector3f qFrom = from;
                Vector3f qTo = to;
                if (variant.getModelType() == VariantModelType.BOOKSHELF && bakedBase != null) {
                    float offset = 0.05f;
                    qFrom = new Vector3f(from).add(face == Direction.WEST ? -offset : 0, face == Direction.DOWN ? -offset : 0, face == Direction.NORTH ? -offset : 0);
                    qTo = new Vector3f(to).add(face == Direction.EAST ? offset : 0, face == Direction.UP ? offset : 0, face == Direction.SOUTH ? offset : 0);
                }
                for (CTMLogicHorizontal logic : CTMLogicHorizontal.values()) {
                    CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(faceUvs), Quadrant.R0);
                    if (connFace.cullForDirection() == null) unculledFaces.add(face);
                    quads[logic.ordinal()] = FaceBakery.bakeQuad(baker, qFrom, qTo, connFace, bakedOverlayHorizontal, face, state, null, true, emissivity);
                }
                horizontalQuads.put(face, quads);
            }

            if (variant.getModelType() == VariantModelType.CTMV) {
                Material.Baked bakedOverlayV = switch (face) {
                    case UP -> bakedOverlayTop;
                    case DOWN -> bakedOverlayBottom;
                    default -> bakedOverlayVertical != null ? bakedOverlayVertical : bakedOverlaySide;
                };
                if (bakedOverlayV != null) {
                    BakedQuad[] quads = new BakedQuad[CTMLogicVertical.values().length];
                    for (CTMLogicVertical logic : CTMLogicVertical.values()) {
                        CuboidFace.UVs remappedUVs = face.getAxis().isHorizontal() ? logic.remapUVs(faceUvs) : faceUvs;
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", remappedUVs, Quadrant.R0);
                        if (connFace.cullForDirection() == null) unculledFaces.add(face);
                        quads[logic.ordinal()] = FaceBakery.bakeQuad(baker, from, to, connFace, bakedOverlayV, face, state, null, true, emissivity);
                    }
                    verticalQuads.put(face, quads);
                }
            }
        }

        return new DirectionalCTMBlockStateModel(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, horizontalQuads, verticalQuads, bakedParticle != null ? bakedParticle.sprite() : null, variant);
    }
}
