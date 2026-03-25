package chisel.client.ctm;

import chisel.Chisel;
import chisel.core.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quadrant;
import com.mojang.math.Transformation;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ResolvedModel;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.client.resources.model.cuboid.CuboidModelElement;
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
import net.minecraft.client.renderer.block.dispatch.Variant.SimpleModelState;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.*;

public record UnbakedConnectedTextureBlockStateModel(ConnectedTextureBlockModelPart.Unbaked unbakedPart) implements CustomUnbakedBlockStateModel {

    public static final Identifier ID = Chisel.prefix("connected_texture_model");

    public static final MapCodec<UnbakedConnectedTextureBlockStateModel> CODEC = ConnectedTextureBlockModelPart.Unbaked.CODEC.xmap(UnbakedConnectedTextureBlockStateModel::new, UnbakedConnectedTextureBlockStateModel::unbakedPart);

    private static final CuboidModelElement[][] baseElements = new CuboidModelElement[6][4];
    private static final CuboidModelElement[][][] connectedElements = new CuboidModelElement[6][4][5];
    private static boolean initialized = false;

    public UnbakedConnectedTextureBlockStateModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOnDisabledFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        this(new ConnectedTextureBlockModelPart.Unbaked(modelLocation, element, connectedFaces, renderOnDisabledFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity));
    }

    private void ensureInitialized() {
        if (initialized) return;
        synchronized (UnbakedConnectedTextureBlockStateModel.class) {
            if (initialized) return;

            int center = 8;
            for (Direction face : Direction.values()) {
                Direction cull = getCullface(face, unbakedPart.element().getFirst(), unbakedPart.element().getSecond());
                Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

                for (int c = 0; c < 4; c++) {
                    Vec3i corner = face.getUnitVec3i().offset(planeDirections[c].getUnitVec3i()).offset(planeDirections[(c + 1) % 4].getUnitVec3i()).offset(1, 1, 1).multiply(8);
                    CuboidModelElement modifiedElement = new CuboidModelElement(
                            new Vector3f(
                                    Math.clamp(Math.min(center - (16 - unbakedPart.element().getSecond().x()), corner.getX() + unbakedPart.element().getFirst().x()), 0, 16),
                                    Math.clamp(Math.min(center - (16 - unbakedPart.element().getSecond().y()), corner.getY() + unbakedPart.element().getFirst().y()), 0, 16),
                                    Math.clamp(Math.min(center - (16 - unbakedPart.element().getSecond().z()), corner.getZ() + unbakedPart.element().getFirst().z()), 0, 16)),
                            new Vector3f(
                                    unbakedPart.element().getSecond().x() < center ? unbakedPart.element().getSecond().x() : Math.max(center, corner.getX() - (16 - unbakedPart.element().getSecond().x())),
                                    unbakedPart.element().getSecond().y() < center ? unbakedPart.element().getSecond().y() : Math.max(center, corner.getY() - (16 - unbakedPart.element().getSecond().y())),
                                    unbakedPart.element().getSecond().z() < center ? unbakedPart.element().getSecond().z() : Math.max(center, corner.getZ() - (16 - unbakedPart.element().getSecond().z()))),
                            Map.of(), null, true, 0);

                    float u0 = 0, v0 = 0, u1 = 16, v1 = 16;
                    switch (face) {
                        case UP, DOWN -> {
                            u0 = corner.getX() + unbakedPart.element().getFirst().x();
                            v0 = corner.getZ() + unbakedPart.element().getFirst().z();
                            u1 = corner.getX() + unbakedPart.element().getSecond().x();
                            v1 = corner.getZ() + unbakedPart.element().getSecond().z();
                        }
                        case NORTH, SOUTH -> {
                            u0 = corner.getX() + unbakedPart.element().getFirst().x();
                            v0 = corner.getY() + unbakedPart.element().getFirst().y();
                            u1 = corner.getX() + unbakedPart.element().getSecond().x();
                            v1 = corner.getY() + unbakedPart.element().getSecond().y();
                        }
                        case WEST, EAST -> {
                            u0 = corner.getZ() + unbakedPart.element().getFirst().z();
                            v0 = corner.getY() + unbakedPart.element().getFirst().y();
                            u1 = corner.getZ() + unbakedPart.element().getSecond().z();
                            v1 = corner.getY() + unbakedPart.element().getSecond().y();
                        }
                    }
                    CuboidFace.UVs uvs = new CuboidFace.UVs(
                            (float) Math.clamp(u0, 0, 16),
                            (float) Math.clamp(v0, 0, 16),
                            (float) Math.clamp(u1, 0, 16),
                            (float) Math.clamp(v1, 0, 16)
                    );
                    CuboidFace.UVs baseUvs = CTMLogic.NONE.remapUVs(uvs);
                    baseElements[face.get3DDataValue()][c] = new CuboidModelElement(modifiedElement.from(), modifiedElement.to(), Map.of(face, new CuboidFace(cull, unbakedPart.baseTintIndex(), "", baseUvs, Quadrant.R0)), null, true, unbakedPart.baseEmissivity());

                    for (CTMLogic logic : CTMLogic.values()) {
                        CuboidFace.UVs remappedUvs = logic.remapUVs(uvs);
                        connectedElements[face.get3DDataValue()][c][logic.ordinal()] = new CuboidModelElement(modifiedElement.from(), modifiedElement.to(), Map.of(face, new CuboidFace(cull, unbakedPart.tintIndex(), "", remappedUvs, Quadrant.R0)), null, true, unbakedPart.emissivity());
                    }
                }
            }
            initialized = true;
        }
    }

    private Direction getCullface(Direction direction, Vector3f from, Vector3f to) {
        boolean cull = switch (direction) {
            case DOWN -> from.y() == 0.0F;
            case UP -> to.y() == 16.0F;
            case NORTH -> from.x() == 0.0F;
            case SOUTH -> to.x() == 16.0F;
            case WEST -> from.z() == 0.0F;
            case EAST -> to.z() == 16.0F;
        };

        return cull ? direction : null;
    }

    @Override
    public @NonNull MapCodec<? extends CustomUnbakedBlockStateModel> codec() {
        return CODEC;
    }

    @Override
    public @NonNull BlockStateModel bake(@NonNull ModelBaker baker) {
        ensureInitialized();
        ResolvedModel model = baker.getModel(unbakedPart.modelLocation());
        if (model == null) {
            return null;
        }
        ModelState state = SimpleModelState.DEFAULT.asModelState();
        Transformation rootTransform = model.getTopAdditionalProperties().getOrDefault(NeoForgeModelProperties.TRANSFORM, Transformation.IDENTITY);
        if (!rootTransform.isIdentity())
            state = UnbakedElementsHelper.composeRootTransformIntoModelState(state, rootTransform);

        Map<Direction, BakedQuad[]> baseQuads = new HashMap<>();
        Set<Direction> unculledFaces = new HashSet<>();

        TextureSlots textureSlots = model.getTopTextureSlots();
        Material baseTexture = textureSlots.getMaterial("base_texture");
        Material overlayTexture = textureSlots.getMaterial("overlay_texture");
        Material overlayConnectedTexture = textureSlots.getMaterial("overlay_connected");
        Material particleTexture = textureSlots.getMaterial("particle");

        if (baseTexture != null) {

            for (Direction dir : Direction.values()) {
                List<BakedQuad> quadList = new ArrayList<>();

                for (CuboidModelElement element : baseElements[dir.get3DDataValue()]) {
                    Material.Baked bakedBase = baker.materials().get(baseTexture, model);
                    if (bakedBase != null) {
                        quadList.add(FaceBakery.bakeQuad(baker, element.from(), element.to(), element.faces().get(dir), bakedBase, dir, state, element.rotation(), element.shade(), element.lightEmission()));
                    }
                }
                baseQuads.put(dir, quadList.toArray(new BakedQuad[0]));
            }
        }
        Material.Baked[] sprites = new Material.Baked[3];
        Material.Baked bakedOverlay = overlayTexture != null ? baker.materials().get(overlayTexture, model) : null;
        Material.Baked bakedOverlayConnected = overlayConnectedTexture != null ? baker.materials().get(overlayConnectedTexture, model) : null;
        Material.Baked bakedParticle = particleTexture != null ? baker.materials().get(particleTexture, model) : null;

        if (bakedParticle == null) {
            sprites[0] = bakedOverlay;
            sprites[1] = bakedOverlayConnected;
            sprites[2] = bakedOverlay;
        } else {
            sprites[0] = bakedOverlay;
            sprites[1] = bakedOverlayConnected;
            sprites[2] = bakedParticle;
        }

        if (sprites[0] == null || sprites[1] == null || sprites[2] == null) {
            return null;
        }

        Map<Direction, BakedQuad[][]> connectedQuads = new HashMap<>();

        for (Direction dir : Direction.values()) {
            BakedQuad[][] dirQuads = new BakedQuad[4][5];
            for (int quad = 0; quad < 4; quad++) {
                for (int type = 0; type < 5; type++) {
                    CuboidModelElement element = connectedElements[dir.get3DDataValue()][quad][type];
                    CuboidFace face = element.faces().get(dir);
                    if (face.cullForDirection() == null) unculledFaces.add(dir);

                    dirQuads[quad][type] = FaceBakery.bakeQuad(baker, element.from(), element.to(), face, CTMLogic.values()[type].chooseMaterial(sprites), dir, state, element.rotation(), element.shade(), element.lightEmission());
                }
            }
            connectedQuads.put(dir, dirQuads);
        }

        return new ConnectedTextureBlockStateModel(unbakedPart.connectedFaces(), unculledFaces, unbakedPart.renderOverlayOnAllFaces(), baseQuads, connectedQuads, sprites[2].sprite(), unbakedPart.variant());
    }

    @Override
    public void resolveDependencies(@NonNull Resolver resolver) {
        unbakedPart.resolveDependencies(resolver);
    }

    public Variant getVariant() {
        return unbakedPart.variant();
    }
}
