package chisel.client.ctm;

import chisel.Chisel;
import chisel.core.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.math.Transformation;
import com.mojang.math.Quadrant;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.client.renderer.block.dispatch.Variant.SimpleModelState;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ResolvedModel;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.client.resources.model.cuboid.CuboidRotation;
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
                    Direction.CODEC.listOf().fieldOf("connected_faces").forGetter(m -> m.connectedFaces.stream().toList()),
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

            TextureSlots textureSlots = model.getTopTextureSlots();
            Material baseTexture = textureSlots.getMaterial("base_texture");
            Material overlayTexture = textureSlots.getMaterial("overlay_texture");
            Material overlayConnectedTexture = textureSlots.getMaterial("overlay_connected");
            Material particleTexture = textureSlots.getMaterial("particle");

            Material.Baked bakedBase = baseTexture != null ? baker.materials().get(baseTexture, model) : null;
            Material.Baked bakedOverlay = overlayTexture != null ? baker.materials().get(overlayTexture, model) : null;
            Material.Baked bakedOverlayConnected = overlayConnectedTexture != null ? baker.materials().get(overlayConnectedTexture, model) : null;
            Material.Baked bakedParticle = particleTexture != null ? baker.materials().get(particleTexture, model) : null;

            if (bakedParticle == null) bakedParticle = bakedBase;
            if (bakedParticle == null) bakedParticle = bakedOverlay;

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

                    // Base quads
                    if (bakedBase != null) {
                        CuboidFace baseFace = new CuboidFace(cull, baseTintIndex, "", CTMLogic.NONE.remapUVs(qUvs), Quadrant.R0);
                        baseQuadList.add(FaceBakery.bakeQuad(baker, qFrom, qTo, baseFace, bakedBase, face, state, (CuboidRotation) null, true, baseEmissivity));
                    }

                    // Connected quads
                    if (bakedOverlay != null && bakedOverlayConnected != null) {
                        Material.Baked[] sprites = {bakedOverlay, bakedOverlayConnected};
                        for (CTMLogic logic : CTMLogic.values()) {
                            CuboidFace connFace = new CuboidFace(cull, tintIndex, "", logic.remapUVs(qUvs), Quadrant.R0);
                            if (connFace.cullForDirection() == null) {
                                unculledFaces.add(face);
                            }
                            connQuads[c][logic.ordinal()] = FaceBakery.bakeQuad(baker, qFrom, qTo, connFace, logic.chooseMaterial(sprites), face, state, (CuboidRotation) null, true, emissivity);
                        }
                    }
                }
                if (!baseQuadList.isEmpty()) {
                    baseQuads.put(face, baseQuadList.toArray(new BakedQuad[0]));
                }
                connectedQuads.put(face, connQuads);
            }

            this.baked = new ConnectedTextureBlockStateModel(
                    connectedFaces,
                    unculledFaces,
                    renderOverlayOnAllFaces,
                    baseQuads,
                    connectedQuads,
                    bakedParticle != null ? bakedParticle.sprite() : null,
                    variant
            );
            return baked;
        }
    }

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
