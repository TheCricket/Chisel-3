package io.github.chiselteam.chisel.events.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.moss.ClientMossData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent;
import org.joml.Matrix4f;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public final class MossOverlayRenderer {
    private static final float E = 0.002F;

    private MossOverlayRenderer() {
    }

    @SubscribeEvent
    public static void submit(SubmitCustomGeometryEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) return;
        Vec3 camera = minecraft.gameRenderer.getMainCamera().position();

        for (BlockPos pos : ClientMossData.positions()) {
            if (!minecraft.level.hasChunkAt(pos) || pos.distToCenterSqr(camera) > 128 * 128) continue;
            var state = minecraft.level.getBlockState(pos);

            for (Direction face : Direction.values()) {
                BlockPos neighbor = pos.relative(face);
                if (!Block.shouldRenderFace(minecraft.level, pos, state, minecraft.level.getBlockState(neighbor), face))
                    continue;
                int light = LevelRenderer.getLightCoords(minecraft.level, neighbor);
                PoseStack pose = event.getPoseStack();
                pose.pushPose();
                pose.translate(pos.getX() - camera.x, pos.getY() - camera.y, pos.getZ() - camera.z);
                event.getSubmitNodeCollector().submitCustomGeometry(pose,
                        RenderTypes.entityTranslucent(Chisel.prefix("textures/misc/moss_overlay.png")),
                        (entry, consumer) -> emitFace(entry.pose(), consumer, face, light));
                pose.popPose();
            }
        }
    }

    private static void emitFace(Matrix4f matrix, VertexConsumer out, Direction face, int light) {
        float n = -E, p = 1 + E;
        switch (face) {
            case DOWN -> quad(matrix, out, n, n, n, p, n, n, p, n, p, n, n, p, face, light);
            case UP -> quad(matrix, out, n, p, p, p, p, p, p, p, n, n, p, n, face, light);
            case NORTH -> quad(matrix, out, p, n, n, n, n, n, n, p, n, p, p, n, face, light);
            case SOUTH -> quad(matrix, out, n, n, p, p, n, p, p, p, p, n, p, p, face, light);
            case WEST -> quad(matrix, out, n, n, n, n, n, p, n, p, p, n, p, n, face, light);
            case EAST -> quad(matrix, out, p, n, p, p, n, n, p, p, n, p, p, p, face, light);
        }
    }

    private static void quad(Matrix4f matrix, VertexConsumer out, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, Direction face, int light) {
        vertex(matrix, out, x1, y1, z1, 0, 1, face, light);
        vertex(matrix, out, x2, y2, z2, 1, 1, face, light);
        vertex(matrix, out, x3, y3, z3, 1, 0, face, light);
        vertex(matrix, out, x4, y4, z4, 0, 0, face, light);
    }

    private static void vertex(Matrix4f matrix, VertexConsumer out, float x, float y, float z, float u, float v, Direction face, int light) {
        out
                .addVertex(matrix, x, y, z)
                .setColor(255, 255, 255, 220)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(face.getStepX(), face.getStepY(), face.getStepZ());
    }
}
