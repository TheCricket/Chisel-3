package chisel.client.ctm;

import chisel.client.ctm.logic.CTMData;
import chisel.core.variant.Variant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.DynamicBlockStateModel;
import org.jspecify.annotations.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractConnectedTextureBlockStateModel implements DynamicBlockStateModel {

    protected final Set<Direction> connectedFaces;
    protected final Set<Direction> unculledFaces;
    protected final boolean renderOverlayOnAllFaces;
    protected final Map<Direction, BakedQuad[]> baseQuads;
    protected final TextureAtlasSprite particle;
    protected final Variant variant;

    private final Map<CTMData, ConnectedTextureBlockModelPart> parts = new ConcurrentHashMap<>();

    protected AbstractConnectedTextureBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads, TextureAtlasSprite particle, Variant variant) {
        this.connectedFaces = connectedFaces;
        this.unculledFaces = unculledFaces;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.baseQuads = baseQuads;
        this.particle = particle;
        this.variant = variant;
    }

    @Override
    public @NonNull Object createGeometryKey(@NonNull BlockAndTintGetter level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull RandomSource random) {
        return computeCTMData(level, pos, random);
    }

    @Override
    public void collectParts(@NonNull BlockAndTintGetter level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull RandomSource random, @NonNull List<BlockStateModelPart> parts) {
        CTMData data = computeCTMData(level, pos, random);
        parts.add(this.parts.computeIfAbsent(data, this::createPart));
    }

    protected abstract CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos, RandomSource random);

    protected abstract ConnectedTextureBlockModelPart createPart(CTMData data);

    protected boolean shouldConnectSide(BlockAndTintGetter level, BlockPos pos, Direction face, Direction side) {
        return level.getBlockState(pos.relative(side)).is(variant.getBlock());
    }

    protected boolean isCornerBlockPresent(BlockAndTintGetter level, BlockPos pos, Direction face, Direction side1, Direction side2) {
        return level.getBlockState(pos.relative(side1).relative(side2)).is(variant.getBlock());
    }

    @Override
    public Material.Baked particleMaterial() {
        return new Material.Baked(particle, false);
    }

    @Override
    public int materialFlags() {
        return 0; // Will be computed in parts
    }
}
