package chisel.client.ctm;

import chisel.Chisel;
import chisel.client.ctm.logic.CTMLogic;
import chisel.client.ctm.logic.CTMLogic2x2;
import chisel.client.ctm.logic.CTMLogic3x3;
import chisel.client.ctm.logic.CTMLogic4x4;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModelType;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quadrant;
import com.mojang.math.Transformation;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

public class UnbakedConnectedTextureBlockStateModel implements CustomUnbakedBlockStateModel {

    public static final Identifier ID = Chisel.prefix("connected_texture_model");

    private final Identifier modelLocation;
    private final Pair<Vector3f, Vector3f> element;
    private final Set<Direction> connectedFaces;
    private final boolean renderOverlayOnAllFaces;
    private final Variant variant;
    private final int baseTintIndex;
    private final int baseEmissivity;
    private final int tintIndex;
    private final int emissivity;

    private BlockStateModel baked;

    private Material.Baked bakedBase;
    private Material.Baked bakedOverlay;
    private Material.Baked bakedOverlayConnected;
    private Material.Baked bakedParticle;

    private Material.Baked bakedOverlayTop;
    private Material.Baked bakedOverlayBottom;
    private Material.Baked bakedOverlaySide;

    private Material.Baked bakedOverlayTopConnected;
    private Material.Baked bakedOverlayBottomConnected;
    private Material.Baked bakedOverlaySideConnected;
    private Material.Baked bakedOverlay2x2;
    private Material.Baked bakedOverlay3x3;
    private Material.Baked bakedOverlay4x4;

    public UnbakedConnectedTextureBlockStateModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        this.modelLocation = modelLocation;
        this.element = element;
        this.connectedFaces = connectedFaces;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.variant = variant;
        this.baseTintIndex = baseTintIndex;
        this.baseEmissivity = baseEmissivity;
        this.tintIndex = tintIndex;
        this.emissivity = emissivity;
    }

    private static final Codec<Vector3f> VECTOR3F_CODEC = Codec.FLOAT.listOf().comapFlatMap(
            list -> list.size() == 3 ? DataResult.success(new Vector3f(list.get(0), list.get(1), list.get(2))) : DataResult.error(() -> "Vector3f must have 3 components"),
            vec -> List.of(vec.x(), vec.y(), vec.z())
    );

    private static final MapCodec<Pair<Vector3f, Vector3f>> ELEMENT_CODEC = RecordCodecBuilder.mapCodec(j -> j.group(
            VECTOR3F_CODEC.fieldOf("min").forGetter(Pair::getFirst),
            VECTOR3F_CODEC.fieldOf("max").forGetter(Pair::getSecond)
    ).apply(j, Pair::of));

    public static final MapCodec<UnbakedConnectedTextureBlockStateModel> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Identifier.CODEC.fieldOf("model_location").forGetter(m -> m.modelLocation),
                    ELEMENT_CODEC.fieldOf("element").forGetter(m -> m.element),
                    Direction.CODEC.listOf().fieldOf("connected_faces").forGetter(m -> m.connectedFaces.stream().toList().stream().sorted().toList()),
                    Codec.BOOL.optionalFieldOf("render_overlay_on_all_faces", false).forGetter(m -> m.renderOverlayOnAllFaces),
                    Variant.CODEC.fieldOf("variant").forGetter(m -> m.variant),
                    Codec.INT.optionalFieldOf("base_tint_index", -1).forGetter(m -> m.baseTintIndex),
                    Codec.INT.optionalFieldOf("base_emissivity", 0).forGetter(m -> m.baseEmissivity),
                    Codec.INT.optionalFieldOf("tint_index", -1).forGetter(m -> m.tintIndex),
                    Codec.INT.optionalFieldOf("emissivity", 0).forGetter(m -> m.emissivity)
            ).apply(instance, (Identifier modelLocation, Pair<Vector3f, Vector3f> element, List<Direction> connectedFaces, Boolean renderOverlayOnAllFaces, Variant variant, Integer baseTintIndex, Integer baseEmissivity, Integer tintIndex, Integer emissivity) ->
                    new UnbakedConnectedTextureBlockStateModel(modelLocation, element, Set.copyOf(connectedFaces), renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity))
    );

    @Override
    public @NonNull MapCodec<? extends CustomUnbakedBlockStateModel> codec() {
        return CODEC;
    }

    /**
     * Bakes the model into a BlockStateModel that can be used for rendering.
     * This method is called during the model baking phase and pre-bakes all possible CTM states
     * for each quadrant of each face to allow for efficient dynamic selection at runtime.
     */
    @Override
    public @NonNull BlockStateModel bake(@NonNull ModelBaker baker) {
        synchronized (this) {
            if (baked != null) return baked;

            ResolvedModel model = baker.getModel(modelLocation);
            ModelState state = SimpleModelState.DEFAULT.asModelState();
            Transformation rootTransform = model.getTopAdditionalProperties().getOrDefault(NeoForgeModelProperties.TRANSFORM, Transformation.IDENTITY);
            if (!rootTransform.isIdentity()) {
                state = UnbakedElementsHelper.composeRootTransformIntoModelState(state, rootTransform);
            }

            // Pre-bake materials to sprites
            bakeMaterials(model, baker);

            Map<Direction, BakedQuad[]> baseQuads = new EnumMap<>(Direction.class);
            Map<Direction, BakedQuad[][]> connectedQuads = new EnumMap<>(Direction.class);
            Map<Direction, BakedQuad[]> multiblock2x2Quads = new EnumMap<>(Direction.class);
            Map<Direction, BakedQuad[]> multiblock3x3Quads = new EnumMap<>(Direction.class);
            Map<Direction, BakedQuad[]> multiblock4x4Quads = new EnumMap<>(Direction.class);
            Set<Direction> unculledFaces = new HashSet<>();

            Vector3f from = element.getFirst();
            Vector3f to = element.getSecond();
            int center = 8; // Midpoint of a standard 16x16 block

            // Iterate over each face of the block
            for (Direction face : Direction.values()) {
                Direction cull = getCullface(face, from, to);
                // Directions forming the plane of the current face, used for quadrant slicing
                Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

                List<BakedQuad> baseQuadList = new ArrayList<>();
                // Store baked quads for each of the 4 quadrants and each of the 5 CTM logic states
                BakedQuad[][] connQuads = new BakedQuad[4][CTMLogic.values().length];
                BakedQuad[] faceMultiblock2x2Quads = new BakedQuad[CTMLogic2x2.values().length];
                BakedQuad[] faceMultiblock3x3Quads = new BakedQuad[CTMLogic3x3.values().length];
                BakedQuad[] faceMultiblock4x4Quads = new BakedQuad[CTMLogic4x4.values().length];

                // Slicing the face into 4 quadrants
                for (int c = 0; c < 4; c++) {
                    // Calculate the 3D corner point for the quadrant
                    Vec3i corner = face.getUnitVec3i().offset(planeDirections[c].getUnitVec3i()).offset(planeDirections[(c + 1) % 4].getUnitVec3i()).offset(1, 1, 1).multiply(8);

                    // Determine the sub-box (qFrom to qTo) for the current quadrant
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

                    // Get texture UVs for this quadrant's portion of the face
                    CuboidFace.UVs qUvs = getRelativeUVs(face, qFrom, qTo);

                    // Bake the base layer if present
                    if (bakedBase != null) {
                        CuboidFace baseFace = new CuboidFace(cull, baseTintIndex, "", CTMLogic.NONE.remapUVs(qUvs), Quadrant.R0);
                        baseQuadList.add(FaceBakery.bakeQuad(baker, qFrom, qTo, baseFace, bakedBase, face, state, null, true, baseEmissivity));
                    }

                    // Determine which overlay and connected textures to use for this face
                    Material.Baked currentOverlay = switch (face) {
                        case UP -> bakedOverlayTop;
                        case DOWN -> bakedOverlayBottom;
                        default -> bakedOverlaySide;
                    };
                    Material.Baked currentConnected = switch (face) {
                        case UP -> bakedOverlayTopConnected;
                        case DOWN -> bakedOverlayBottomConnected;
                        default -> bakedOverlaySideConnected;
                    };

                    // Bake all possible CTM states for the overlay layer
                    if (currentOverlay != null && currentConnected != null) {
                        Material.Baked[] sprites = {currentOverlay, currentConnected};
                        for (CTMLogic logic : CTMLogic.values()) {
                            // Remap UVs based on the CTM logic (pointing to the correct sub-texture)
                            CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(qUvs), Quadrant.R0);
                            if (connFace.cullForDirection() == null) {
                                unculledFaces.add(face);
                            }
                            connQuads[c][logic.ordinal()] = FaceBakery.bakeQuad(baker, qFrom, qTo, connFace, logic.chooseMaterial(sprites), face, state, null, true, emissivity);
                        }
                    }
                }

                // Bake 2x2 multiblock states for the entire face if applicable
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_2X2 && bakedOverlay2x2 != null) {
                    CuboidFace.UVs faceUvs = getRelativeUVs(face, from, to);
                    for (CTMLogic2x2 logic : CTMLogic2x2.values()) {
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(faceUvs), Quadrant.R0);
                        if (connFace.cullForDirection() == null) {
                            unculledFaces.add(face);
                        }
                        faceMultiblock2x2Quads[logic.ordinal()] = FaceBakery.bakeQuad(baker, from, to, connFace, bakedOverlay2x2, face, state, null, true, emissivity);
                    }
                }

                // Bake 3x3 multiblock states for the entire face if applicable
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_3X3 && bakedOverlay3x3 != null) {
                    CuboidFace.UVs faceUvs = getRelativeUVs(face, from, to);
                    for (CTMLogic3x3 logic : CTMLogic3x3.values()) {
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(faceUvs), Quadrant.R0);
                        if (connFace.cullForDirection() == null) {
                            unculledFaces.add(face);
                        }
                        faceMultiblock3x3Quads[logic.ordinal()] = FaceBakery.bakeQuad(baker, from, to, connFace, bakedOverlay3x3, face, state, null, true, emissivity);
                    }
                }

                // Bake 4x4 multiblock states for the entire face if applicable
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_4X4 && bakedOverlay4x4 != null) {
                    CuboidFace.UVs faceUvs = getRelativeUVs(face, from, to);
                    for (CTMLogic4x4 logic : CTMLogic4x4.values()) {
                        CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(faceUvs), Quadrant.R0);
                        if (connFace.cullForDirection() == null) {
                            unculledFaces.add(face);
                        }
                        faceMultiblock4x4Quads[logic.ordinal()] = FaceBakery.bakeQuad(baker, from, to, connFace, bakedOverlay4x4, face, state, null, true, emissivity);
                    }
                }

                if (!baseQuadList.isEmpty()) {
                    baseQuads.put(face, baseQuadList.toArray(new BakedQuad[0]));
                }
                connectedQuads.put(face, connQuads);
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_2X2) {
                    multiblock2x2Quads.put(face, faceMultiblock2x2Quads);
                }
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_3X3) {
                    multiblock3x3Quads.put(face, faceMultiblock3x3Quads);
                }
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_4X4) {
                    multiblock4x4Quads.put(face, faceMultiblock4x4Quads);
                }
            }

            this.baked = new ConnectedTextureBlockStateModel(
                    connectedFaces,
                    unculledFaces,
                    renderOverlayOnAllFaces,
                    baseQuads,
                    connectedQuads,
                    multiblock2x2Quads,
                    multiblock3x3Quads,
                    multiblock4x4Quads,
                    bakedParticle != null ? bakedParticle.sprite() : null,
                    variant
            );
            return baked;
        }
    }

    /**
     * Resolves and bakes the textures for all possible CTM face variations.
     * Uses top/bottom/side specific textures if provided, falling back to general overlay textures.
     */
    private void bakeMaterials(ResolvedModel model, ModelBaker baker) {
        TextureSlots textureSlots = model.getTopTextureSlots();
        Material baseTexture = textureSlots.getMaterial("base_texture");
        Material overlayTexture = textureSlots.getMaterial("overlay_texture");
        Material overlayConnectedTexture = textureSlots.getMaterial("overlay_connected");
        Material particleTexture = textureSlots.getMaterial("particle");

        Material overlayTop = textureSlots.getMaterial("overlay_top");
        Material overlayBottom = textureSlots.getMaterial("overlay_bottom");
        Material overlaySide = textureSlots.getMaterial("overlay_side");

        Material overlayConnectedTop = textureSlots.getMaterial("overlay_top_connected");
        Material overlayConnectedBottom = textureSlots.getMaterial("overlay_bottom_connected");
        Material overlayConnectedSide = textureSlots.getMaterial("overlay_side_connected");
        Material overlay2x2 = textureSlots.getMaterial("overlay_2x2");
        Material overlay3x3 = textureSlots.getMaterial("overlay_3x3");
        Material overlay4x4 = textureSlots.getMaterial("overlay_4x4");

        bakedBase = baseTexture != null ? baker.materials().get(baseTexture, model) : null;
        bakedOverlay = overlayTexture != null ? baker.materials().get(overlayTexture, model) : null;
        bakedOverlayConnected = overlayConnectedTexture != null ? baker.materials().get(overlayConnectedTexture, model) : null;
        bakedParticle = particleTexture != null ? baker.materials().get(particleTexture, model) : null;

        bakedOverlayTop = overlayTop != null ? baker.materials().get(overlayTop, model) : bakedOverlay;
        bakedOverlayBottom = overlayBottom != null ? baker.materials().get(overlayBottom, model) : bakedOverlay;
        bakedOverlaySide = overlaySide != null ? baker.materials().get(overlaySide, model) : bakedOverlay;

        bakedOverlayTopConnected = overlayConnectedTop != null ? baker.materials().get(overlayConnectedTop, model) : (overlayConnectedTexture != null ? bakedOverlayConnected : null);
        bakedOverlayBottomConnected = overlayConnectedBottom != null ? baker.materials().get(overlayConnectedBottom, model) : (overlayConnectedTexture != null ? bakedOverlayConnected : null);
        bakedOverlaySideConnected = overlayConnectedSide != null ? baker.materials().get(overlayConnectedSide, model) : (overlayConnectedTexture != null ? bakedOverlayConnected : null);
        bakedOverlay2x2 = overlay2x2 != null ? baker.materials().get(overlay2x2, model) : null;
        bakedOverlay3x3 = overlay3x3 != null ? baker.materials().get(overlay3x3, model) : null;
        bakedOverlay4x4 = overlay4x4 != null ? baker.materials().get(overlay4x4, model) : null;

        if (bakedParticle == null) bakedParticle = bakedBase;
        if (bakedParticle == null) bakedParticle = bakedOverlay;
    }

    /**
     * Determines which face should be culled based on the direction and the element's boundaries.
     */
    private Direction getCullface(Direction direction, Vector3f from, Vector3f to) {
        boolean cull = switch (direction) {
            case DOWN -> from.y() == 0.0F;
            case UP -> to.y() == 16.0F;
            case NORTH -> from.z() == 0.0F;
            case SOUTH -> to.z() == 16.0F;
            case WEST -> from.x() == 0.0F;
            case EAST -> to.x() == 16.0F;
        };
        return cull ? direction : null;
    }

    /**
     * Maps the 3D coordinates of a quadrant to 2D UV coordinates for a specific face.
     */
    private CuboidFace.UVs getRelativeUVs(Direction face, Vector3f from, Vector3f to) {
        float u0, v0, u1, v1;
        switch (face) {
            case UP -> {
                u0 = from.x();
                v0 = from.z();
                u1 = to.x();
                v1 = to.z();
            }
            case DOWN -> {
                u0 = from.x();
                v0 = 16 - to.z();
                u1 = to.x();
                v1 = 16 - from.z();
            }
            case NORTH -> {
                u0 = 16 - to.x();
                v0 = 16 - to.y();
                u1 = 16 - from.x();
                v1 = 16 - from.y();
            }
            case SOUTH -> {
                u0 = from.x();
                v0 = 16 - to.y();
                u1 = to.x();
                v1 = 16 - from.y();
            }
            case WEST -> {
                u0 = from.z();
                v0 = 16 - to.y();
                u1 = to.z();
                v1 = 16 - from.y();
            }
            case EAST -> {
                u0 = 16 - to.z();
                v0 = 16 - to.y();
                u1 = 16 - from.z();
                v1 = 16 - from.y();
            }
            default -> {
                u0 = 0;
                v0 = 0;
                u1 = 16;
                v1 = 16;
            }
        }
        return new CuboidFace.UVs(Math.clamp(u0, 0, 16), Math.clamp(v0, 0, 16), Math.clamp(u1, 0, 16), Math.clamp(v1, 0, 16));
    }

    @Override
    public void resolveDependencies(@NonNull Resolver resolver) {
        resolver.markDependency(modelLocation);
    }
}
