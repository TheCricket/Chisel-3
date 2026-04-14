package chisel.client.ctm;

import chisel.core.variant.Variant;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public abstract class AbstractUnbakedConnectedTextureBlockStateModel implements CustomUnbakedBlockStateModel {

    protected final Identifier modelLocation;
    protected final Pair<Vector3f, Vector3f> element;
    protected final Set<Direction> connectedFaces;
    protected final boolean renderOverlayOnAllFaces;
    protected final Variant variant;
    protected final int baseTintIndex;
    protected final int baseEmissivity;
    protected final int tintIndex;
    protected final int emissivity;

    protected AbstractUnbakedConnectedTextureBlockStateModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
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

    @Override
    public void resolveDependencies(ResolvableModel.Resolver resolver) {
        resolver.markDependency(modelLocation);
    }

    public abstract @NonNull BlockStateModel bake(@NonNull ModelBaker baker);

    protected Direction getCullface(Direction direction, Vector3f from, Vector3f to) {
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

    protected CuboidFace.UVs getRelativeUVs(Direction face, Vector3f from, Vector3f to) {
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
}
