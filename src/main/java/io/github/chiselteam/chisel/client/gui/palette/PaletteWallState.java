package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public record PaletteWallState(Map<BlockPos, BlockState> blocks, float rotationX, float rotationY, float zoom,
                               float panX, float panY, int x0, int y0, int x1,
                               int y1) implements PictureInPictureRenderState {
    public PaletteWallState {
        blocks = Map.copyOf(blocks);
    }

    @Override
    public float scale() {
        return 1F;
    }

    @Override
    public @NonNull Matrix3x2f pose() {
        return PictureInPictureRenderState.IDENTITY_POSE;
    }

    @Override
    public @NonNull ScreenRectangle scissorArea() {
        return new ScreenRectangle(x0, y0, x1 - x0, y1 - y0);
    }

    @Override
    public @Nullable ScreenRectangle bounds() {
        return PictureInPictureRenderState.getBounds(x0, y0, x1, y1, scissorArea());
    }
}
