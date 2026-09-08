package io.github.chiselteam.chisel.client.gui.palette;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.QuadInstance;
import io.github.chiselteam.chisel.client.gui.preview.PreviewGetter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaletteWallRenderer extends PictureInPictureRenderer<PaletteWallState> {

    private static final long MODEL_SEED = 42L;

    public PaletteWallRenderer(MultiBufferSource.BufferSource bufferSource) {
        super(bufferSource);
    }

    @Override
    public @NonNull Class<PaletteWallState> getRenderStateClass() {
        return PaletteWallState.class;
    }

    @Override
    protected float getTranslateY(int height, int guiScale) {
        return height / 2.0F;

    }

    @Override
    protected void renderToTexture(@NonNull PaletteWallState state, @NonNull PoseStack pose) {
        pose.translate(state.panX(), state.panY(), 0);
        float scale = state.zoom() * Math.min((state.x1() - state.x0()) / 9F, (state.y1() - state.y0()) / 6F);
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateX((float) Math.PI + state.rotationX()).rotateY(state.rotationY()));
        pose.translate(-PaletteWall.COLUMNS / 2F, -PaletteWall.ROWS / 2F, -0.5F);

        var modelSet = Minecraft.getInstance().getModelManager().getBlockStateModelSet();
        var getter = new PreviewGetter(Blocks.AIR.defaultBlockState(), new int[0][]) {
            @Override
            public @NonNull BlockState getBlockState(@NonNull BlockPos pos) {
                return state.blocks().getOrDefault(pos, Blocks.AIR.defaultBlockState());
            }
        };
        var random = RandomSource.create();
        var quads = new QuadInstance();

        for (var cell : state.blocks().entrySet()) {
            pose.pushPose();
            var pos = cell.getKey();
            var block = cell.getValue();
            var model = modelSet.get(block);
            pose.translate(pos.getX(), pos.getY(), pos.getZ());
            random.setSeed(MODEL_SEED);
            List<BlockStateModelPart> parts = new ArrayList<>();
            model.collectParts(getter, pos, block, random, parts);

            parts.forEach(part -> {
                Arrays.stream(Direction.values()).forEach(side -> {
                    var neighborPos = pos.relative(side);
                    var neighborState = getter.getBlockState(neighborPos);

                    if (!block.skipRendering(neighborState, side)) {
                        bakeQuads(side, part, quads, pose, block, getter, pos);
                    }
                });

                bakeQuads(null, part, quads, pose, block, getter, pos);
            });
            pose.popPose();
        }
    }

    private void bakeQuads(Direction side, BlockStateModelPart part, QuadInstance quads, PoseStack pose, BlockState block, PreviewGetter getter, BlockPos pos) {
        part.getQuads(side).forEach(quad -> {
            quads.setColor(-1);
            int tintIndex = quad.materialInfo().tintIndex();
            if (tintIndex >= 0) {
                var tint = Minecraft.getInstance().getBlockColors().getTintSource(block, tintIndex);
                if (tint != null) quads.multiplyColor(tint.colorInWorld(block, getter, pos));
            }
            quads.setLightCoords(15728880);
            var buffer = bufferSource.getBuffer(getRenderTypeForLayer(quad.materialInfo().layer()));
            buffer.putBakedQuad(pose.last(), quad, quads);
        });
    }

    private RenderType getRenderTypeForLayer(ChunkSectionLayer layer) {
        return switch (layer) {
            case SOLID -> RenderTypes.solidMovingBlock();
            case CUTOUT -> RenderTypes.cutoutMovingBlock();
            case TRANSLUCENT -> RenderTypes.translucentMovingBlock();
        };
    }

    @Override
    protected @NonNull String getTextureLabel() {
        return "Palette wall preview";
    }
}
