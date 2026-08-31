package io.github.chiselteam.chisel.mode.building;

import com.mojang.serialization.Codec;
import io.github.chiselteam.chisel.registry.ChiselBuildingModes;
import io.github.chiselteam.chisel.util.BuildingShapes;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChiselBuildingMode {

    protected List<BlockPos> positions;
    private BlockPos lastCenteredOrigin;
    private int lastLength;
    private int lastWidth;
    private int lastHeight;
    private boolean cacheValid;

    public static final Codec<ChiselBuildingMode> CODEC = Identifier.CODEC.xmap(
            id -> ChiselBuildingModes.REGISTRY.getOptional(id).orElseGet(() -> new ChiselBuildingMode(id)),
            ChiselBuildingMode::getRegistryName
    );

    public static final StreamCodec<ByteBuf, ChiselBuildingMode> STREAM_CODEC = Identifier.STREAM_CODEC.map(
            id -> ChiselBuildingModes.REGISTRY.getOptional(id).orElseGet(() -> new ChiselBuildingMode(id)),
            ChiselBuildingMode::getRegistryName
    );

    private final Identifier registryName;

    public ChiselBuildingMode(Identifier registryName) {
        this.registryName = registryName;
        positions = new ArrayList<>();
        cacheValid = false;
    }

    public Component getDescription() {
        return Component.translatable("chisel.building_mode." + registryName.toString());
    }

    /**
     * Returns the ghost-block positions for this mode, centred around {@code origin} (which is
     * normally the {@code BuildersGuide} block position). Subclasses implement {@link #generate}
     * using a local box {@code [0, width) x [0, height) x [0, length)}; this method translates
     * that box so it is centred on {@code origin} before delegating.
     */
    public final List<BlockPos> getGhostBlocks(BlockPos origin, int length, int width, int height) {
        // Local +x -> world +X, local +y -> world +Y, local +z -> world -Z (see BuildingShapes).
        // To center the local box on origin, shift the origin passed to generate by the negative
        // half-extents in each corresponding world axis.
        BlockPos centered = new BlockPos(
                origin.getX() - (width  - 1) / 2,
                origin.getY() - (height - 1) / 2,
                origin.getZ() + (length - 1) / 2
        );
        // Only (re)generate if parameters changed or we don't have a valid cache yet.
        if (!cacheValid
                || lastCenteredOrigin == null
                || !lastCenteredOrigin.equals(centered)
                || lastLength != length
                || lastWidth  != width
                || lastHeight != height) {
            this.positions = new ArrayList<>(generate(centered, length, width, height));
            // Sort positions to achieve a more uniform placement order:
            // 1) Expand outward in Chebyshev-distance "shells" from the true center (origin).
            // 2) Within the same shell, use a 3D Morton (Z-order) curve over local box coords
            //    to keep spatial locality and distribute placements evenly across the volume.
            final int centerX = origin.getX();
            final int centerY = origin.getY();
            final int centerZ = origin.getZ();
            final int cornerX = centered.getX();
            final int cornerY = centered.getY();
            final int cornerZ = centered.getZ();
            positions.sort((a, b) -> {
                int adx = Math.abs(a.getX() - centerX);
                int ady = Math.abs(a.getY() - centerY);
                int adz = Math.abs(a.getZ() - centerZ);
                int bdx = Math.abs(b.getX() - centerX);
                int bdy = Math.abs(b.getY() - centerY);
                int bdz = Math.abs(b.getZ() - centerZ);
                int alayer = Math.max(Math.max(adx, ady), adz);
                int blayer = Math.max(Math.max(bdx, bdy), bdz);
                if (alayer != blayer) return Integer.compare(alayer, blayer);

                int alx = a.getX() - cornerX;
                int aly = a.getY() - cornerY;
                int alz = cornerZ - a.getZ();
                int blx = b.getX() - cornerX;
                int bly = b.getY() - cornerY;
                int blz = cornerZ - b.getZ();
                long amorton = morton3D(alx, aly, alz);
                long bmorton = morton3D(blx, bly, blz);
                return Long.compare(amorton, bmorton);
            });
            this.lastCenteredOrigin = centered;
            this.lastLength = length;
            this.lastWidth = width;
            this.lastHeight = height;
            this.cacheValid = true;
        }
        return positions;
    }

    /**
     * Produces the ghost-block positions for this mode, treating {@code origin} as the corner
     * of a local {@code [0, width) x [0, height) x [0, length)} bounding box (via
     * {@link BuildingShapes#local}). Centering is handled by
     * {@link #getGhostBlocks}; implementations must not apply their own centering.
     */
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        return Collections.singletonList(origin);
    }

    public void placeBlock(Level level, Block block) {
        if(level.isClientSide()) return;

        // Skip any positions that are already occupied; ghosts should only exist for empty spots.
        while (!positions.isEmpty()) {
            BlockPos next = positions.getFirst();
            if (!level.isEmptyBlock(next)) {
                // Prune occupied spot from the queue and continue.
                positions.removeFirst();
                continue;
            }
            level.setBlockAndUpdate(next, block.defaultBlockState());
            positions.removeFirst();
            break;
        }
    }

    protected void addBlock(int x, int y, int z) {
        addBlock(new BlockPos(x, y, z));
    }

    protected void addBlock(BlockPos pos) {
        positions.add(pos);
    }

    public Identifier getRegistryName() {
        return registryName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ChiselBuildingMode that = (ChiselBuildingMode) obj;
        return registryName.equals(that.registryName);
    }

    @Override
    public String toString() {
        return registryName.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName);
    }

    // Morton (Z-order) utilities for 3D ordering within a layer.
    private static long morton3D(int x, int y, int z) {
        // We expect x,y,z to be small non-negative (local box coords). Interleave up to 21 bits.
        return splitBy3(x) | (splitBy3(y) << 1) | (splitBy3(z) << 2);
    }

    private static long splitBy3(int v) {
        long x = ((long) v) & 0x1fffffL;           // 21 bits
        x = (x | (x << 32)) & 0x1f00000000ffffL;
        x = (x | (x << 16)) & 0x1f0000ff0000ffL;
        x = (x | (x << 8))  & 0x100f00f00f00f00fL;
        x = (x | (x << 4))  & 0x10c30c30c30c30c3L;
        x = (x | (x << 2))  & 0x1249249249249249L;
        return x;
    }
}
