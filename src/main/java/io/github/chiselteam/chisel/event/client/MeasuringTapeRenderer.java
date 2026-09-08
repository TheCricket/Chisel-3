package io.github.chiselteam.chisel.event.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.overlay.OutlineEdge;
import io.github.chiselteam.chisel.item.MeasuringTapeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.joml.Matrix4f;

import java.util.List;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class MeasuringTapeRenderer {

    private static final List<OutlineEdge> BLOCK_OUTLINE = List.of(
            // Bottom face
            OutlineEdge.create(0, 0, 0, 1, 0, 0),
            OutlineEdge.create(1, 0, 0, 1, 0, 1),
            OutlineEdge.create(1, 0, 1, 0, 0, 1),
            OutlineEdge.create(0, 0, 1, 0, 0, 0),

            // Top face
            OutlineEdge.create(0, 1, 0, 1, 1, 0),
            OutlineEdge.create(1, 1, 0, 1, 1, 1),
            OutlineEdge.create(1, 1, 1, 0, 1, 1),
            OutlineEdge.create(0, 1, 1, 0, 1, 0),

            // Vertical edges
            OutlineEdge.create(0, 0, 0, 0, 1, 0),
            OutlineEdge.create(1, 0, 0, 1, 1, 0),
            OutlineEdge.create(1, 0, 1, 1, 1, 1),
            OutlineEdge.create(0, 0, 1, 0, 1, 1)
    );

    @SubscribeEvent
    public static void render(RenderLevelStageEvent.AfterTranslucentBlocks event) {
        var minecraft = Minecraft.getInstance();
        var player = minecraft.player;

        if (player == null) return;

        var measuringTape = player.getMainHandItem();
        if (!(measuringTape.getItem() instanceof MeasuringTapeItem)) return;

        MeasuringTapeItem.getFirstPosition(measuringTape).ifPresent(pos -> renderOutline(event, pos, 255, 0, 0));
        MeasuringTapeItem.getSecondPosition(measuringTape).ifPresent(pos -> renderOutline(event, pos, 255, 255, 255));
        MeasuringTapeItem.getMiddlePosition(measuringTape).ifPresent(pos -> renderOutline(event, pos, 0, 255, 255));
    }

    private static void renderOutline(RenderLevelStageEvent.AfterTranslucentBlocks event, BlockPos pos, int r, int g, int b) {
        var minecraft = Minecraft.getInstance();
        var cam = minecraft.getEntityRenderDispatcher().camera;
        if (cam == null) return;
        var camPos = cam.position();

        var pose = event.getPoseStack();
        pose.pushPose();
        pose.translate(pos.getX() - camPos.x, pos.getY() - camPos.y, pos.getZ() - camPos.z);

        var matrix = pose.last().pose();
        var consumer = minecraft.renderBuffers().bufferSource().getBuffer(RenderTypes.lines());

        for (OutlineEdge edge : BLOCK_OUTLINE) {
            drawEdge(consumer, matrix, edge, r, g, b);
        }

        pose.popPose();
    }

    private static void drawEdge(VertexConsumer consumer, Matrix4f matrix, OutlineEdge edge, int r, int g, int b) {
        consumer.addVertex(matrix, edge.x1(), edge.y1(), edge.z1())
                .setColor(r, g, b, 255)
                .setNormal(edge.normalX(), edge.normalY(), edge.normalZ())
                .setLineWidth(3.0F);

        consumer.addVertex(matrix, edge.x2(), edge.y2(), edge.z2())
                .setColor(r, g, b, 255)
                .setNormal(edge.normalX(), edge.normalY(), edge.normalZ())
                .setLineWidth(3.0F);
    }
}
