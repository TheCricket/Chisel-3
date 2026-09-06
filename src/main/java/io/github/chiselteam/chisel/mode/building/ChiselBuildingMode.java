package io.github.chiselteam.chisel.mode.building;

import com.mojang.serialization.Codec;
import io.github.chiselteam.chisel.registry.ChiselBuildingModes;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChiselBuildingMode {

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
    }

    public Component getDescription() {
        return Component.translatable("chisel.building_mode." + registryName.toString());
    }

    public final List<BlockPos> getGhostBlocks(BlockPos origin, int length, int width, int height) {
        var centered = new BlockPos(
                origin.getX() - (width  - 1) / 2,
                origin.getY() - (height - 1) / 2,
                origin.getZ() + (length - 1) / 2
        );

        var positions = new ArrayList<>(generate(centered, length, width, height));
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
        return List.copyOf(positions);
    }

    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        return Collections.singletonList(origin);
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

    private static long morton3D(int x, int y, int z) {
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
