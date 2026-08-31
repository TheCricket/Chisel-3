package io.github.chiselteam.chisel.client.gui.preview;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.QuadInstance;
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
import org.joml.Quaternionf;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreviewPIP extends PictureInPictureRenderer<PreviewPIPState> {

    @SuppressWarnings("FieldCanBeLocal")
    private final long ANSWER_TO_LIFE_THE_UNIVERSE_AND_EVERYTHING = 42L;

    public PreviewPIP(MultiBufferSource.BufferSource bufferSource) {
        super(bufferSource);
    }

    @Override
    public @NonNull Class<PreviewPIPState> getRenderStateClass() {
        return PreviewPIPState.class;
    }

    @Override
    protected float getTranslateY(int height, int guiScale) {
        return height / 2.0F;

    }

    @Override
    protected void renderToTexture(@NonNull PreviewPIPState state, @NonNull PoseStack pose) {
        var block = state.blockState();

        float scale = 30 * state.zoom() * state.previewScale();
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateX((float) Math.toDegrees(180 + state.rotX())).rotateY((float) Math.toDegrees(state.rotY())));
        pose.translate(-state.centerX(), -state.centerY(), -0.5F);

        var modelSet = Minecraft.getInstance().getModelManager().getBlockStateModelSet();
        var model = modelSet.get(block);
        var getter = new PreviewGetter(block, state.positions());
        var random = RandomSource.create();
        var quads = new QuadInstance();

        for(int[] position : state.positions()) {
            pose.pushPose();
            var pos = new BlockPos(position[0], position[1], position[2]);
            pose.translate(pos.getX(), pos.getY(), pos.getZ());
            random.setSeed(ANSWER_TO_LIFE_THE_UNIVERSE_AND_EVERYTHING);
            List<BlockStateModelPart> parts = new ArrayList<>();
            model.collectParts(getter, pos, block, random, parts);

            parts.forEach(part -> {
                Arrays.stream(Direction.values()).forEach(side -> {
                    var neighborPos = pos.relative(side);
                    var neighborState = getter.getBlockState(neighborPos);

                    if(!block.skipRendering(neighborState, side)) {
                        bakeQuads(side, part, quads, pose, bufferSource);
                    }
                });

                bakeQuads(null, part, quads, pose, bufferSource);
            });
            pose.popPose();
        }
    }

    private void bakeQuads(Direction side, BlockStateModelPart part, QuadInstance quads, PoseStack pose, MultiBufferSource.BufferSource bufferSource) {
        part.getQuads(side).forEach(quad -> {
            quads.setColor(-1);
            quads.setLightCoords(15728880);
            var buffer = bufferSource.getBuffer(getRenderTypeForLayer(quad.materialInfo().layer()));
            buffer.putBakedQuad(pose.last(), quad, quads);
        });
    }

    private RenderType getRenderTypeForLayer(ChunkSectionLayer layer) {
        return switch(layer) {
            case SOLID -> RenderTypes.solidMovingBlock();
            case CUTOUT -> RenderTypes.cutoutMovingBlock();
            case TRANSLUCENT -> RenderTypes.translucentMovingBlock();
        };
    }

    @Override
    protected @NonNull String getTextureLabel() {
        return "Block preview";
    }
}
