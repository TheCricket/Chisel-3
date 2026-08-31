package io.github.chiselteam.chisel.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.overlay.EdgeKey;
import io.github.chiselteam.chisel.client.overlay.OutlineEdge;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import io.github.chiselteam.chisel.registry.ChiselDataComponents;
import io.github.chiselteam.chisel.registry.ChiselItemAbilities;
import io.github.chiselteam.chisel.registry.ChiselModes;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ExtractBlockOutlineRenderStateEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.joml.Matrix4f;

import java.util.*;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class RenderLevelStageEventHandler {
    private static BlockPos cachedTarget;
    private static Direction cachedDirection;
    private static ChiselMode cachedMode;
    private static List<BlockPos> cachedAffectedBlocks = List.of();
    private static List<OutlineEdge> cachedEdges = List.of();

    @SubscribeEvent
    public static void renderChiselLines(RenderLevelStageEvent.AfterTranslucentBlocks event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player == null) return;

        ItemStack chisel = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!chisel.canPerformAction(ChiselItemAbilities.CHISEL)) {
            clearChiselOutline();
            return;
        }

        if (!(minecraft.hitResult instanceof BlockHitResult blockHitResult)) {
            clearChiselOutline();
            return;
        }

        updateChiselOutline(player.level(), player, chisel, blockHitResult);
        if (cachedTarget == null || cachedEdges.isEmpty()) return;

        Camera camera = minecraft.getEntityRenderDispatcher().camera;
        if (camera == null) return;

        Vec3 cameraPos = camera.position();
        PoseStack poseStack = event.getPoseStack();

        poseStack.pushPose();
        poseStack.translate(
                cachedTarget.getX() - cameraPos.x,
                cachedTarget.getY() - cameraPos.y,
                cachedTarget.getZ() - cameraPos.z
        );

        Matrix4f matrix = poseStack.last().pose();
        VertexConsumer builder = minecraft.renderBuffers().bufferSource().getBuffer(RenderTypes.lines());

        for (OutlineEdge edge : cachedEdges) {
            builder.addVertex(matrix, edge.x1(), edge.y1(), edge.z1())
                    .setColor(255, 255, 255, 255)
                    .setNormal(edge.normalX(), edge.normalY(), edge.normalZ())
                    .setLineWidth(2.0F);

            builder.addVertex(matrix, edge.x2(), edge.y2(), edge.z2())
                    .setColor(255, 255, 255, 255)
                    .setNormal(edge.normalX(), edge.normalY(), edge.normalZ())
                    .setLineWidth(2.0F);
        }

        poseStack.popPose();
    }

    @SubscribeEvent
    public static void cancelVanillaBlockOutline(ExtractBlockOutlineRenderStateEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player == null) return;

        ItemStack chisel = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!chisel.canPerformAction(ChiselItemAbilities.CHISEL)) return;
        if (cachedTarget == null || cachedEdges.isEmpty()) return;

        event.setCanceled(true);
    }

    private static void updateChiselOutline(Level level, LocalPlayer player, ItemStack chisel, BlockHitResult hitResult) {
        BlockPos target = hitResult.getBlockPos();
        Direction direction = hitResult.getDirection();
        ChiselMode mode = chisel.getOrDefault(ChiselDataComponents.CHISEL_MODE, ChiselModes.SINGLE.value());

        BlockState targetedState = level.getBlockState(target);
        if (targetedState.isAir()) {
            clearChiselOutline();
            return;
        }

        List<BlockPos> affectedBlocks = mode.getAffectedBlocks(level, player, target, direction, targetedState);
        if (affectedBlocks.isEmpty()) {
            clearChiselOutline();
            return;
        }

        if (target.equals(cachedTarget)
                && direction == cachedDirection
                && mode == cachedMode
                && affectedBlocks.equals(cachedAffectedBlocks)) return;

        List<OutlineEdge> edges = createBlockOutlineEdges(affectedBlocks, target);
        if (edges.isEmpty()) {
            clearChiselOutline();
            return;
        }

        cachedTarget = target.immutable();
        cachedDirection = direction;
        cachedMode = mode;
        cachedAffectedBlocks = List.copyOf(affectedBlocks);
        cachedEdges = edges;
    }

    private static List<OutlineEdge> createBlockOutlineEdges(List<BlockPos> affectedBlocks, BlockPos origin) {
        Set<Long> selectedBlocks = new HashSet<>(affectedBlocks.size() * 2);
        for (BlockPos pos : affectedBlocks) selectedBlocks.add(pos.asLong());

        Map<EdgeKey, OutlineEdge> edges = new LinkedHashMap<>();

        for (BlockPos pos : affectedBlocks) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            addXEdgeIfVisible(edges, selectedBlocks, origin, x, y, z);
            addXEdgeIfVisible(edges, selectedBlocks, origin, x, y + 1, z);
            addXEdgeIfVisible(edges, selectedBlocks, origin, x, y, z + 1);
            addXEdgeIfVisible(edges, selectedBlocks, origin, x, y + 1, z + 1);

            addYEdgeIfVisible(edges, selectedBlocks, origin, x, y, z);
            addYEdgeIfVisible(edges, selectedBlocks, origin, x + 1, y, z);
            addYEdgeIfVisible(edges, selectedBlocks, origin, x, y, z + 1);
            addYEdgeIfVisible(edges, selectedBlocks, origin, x + 1, y, z + 1);

            addZEdgeIfVisible(edges, selectedBlocks, origin, x, y, z);
            addZEdgeIfVisible(edges, selectedBlocks, origin, x + 1, y, z);
            addZEdgeIfVisible(edges, selectedBlocks, origin, x, y + 1, z);
            addZEdgeIfVisible(edges, selectedBlocks, origin, x + 1, y + 1, z);
        }

        return List.copyOf(edges.values());
    }

    private static void addXEdgeIfVisible(Map<EdgeKey, OutlineEdge> edges, Set<Long> blocks, BlockPos origin, int x, int y, int z) {
        boolean northDown = contains(blocks, x, y - 1, z - 1);
        boolean northUp = contains(blocks, x, y, z - 1);
        boolean southUp = contains(blocks, x, y, z);
        boolean southDown = contains(blocks, x, y - 1, z);

        if (!isVisibleBoundaryEdge(northDown, northUp, southUp, southDown)) return;

        addEdge(
                edges,
                x - origin.getX(),
                y - origin.getY(),
                z - origin.getZ(),
                x + 1 - origin.getX(),
                y - origin.getY(),
                z - origin.getZ()
        );
    }

    private static void addYEdgeIfVisible(Map<EdgeKey, OutlineEdge> edges, Set<Long> blocks, BlockPos origin, int x, int y, int z) {
        boolean northWest = contains(blocks, x - 1, y, z - 1);
        boolean northEast = contains(blocks, x, y, z - 1);
        boolean southEast = contains(blocks, x, y, z);
        boolean southWest = contains(blocks, x - 1, y, z);

        if (!isVisibleBoundaryEdge(northWest, northEast, southEast, southWest)) return;

        addEdge(
                edges,
                x - origin.getX(),
                y - origin.getY(),
                z - origin.getZ(),
                x - origin.getX(),
                y + 1 - origin.getY(),
                z - origin.getZ()
        );
    }

    private static void addZEdgeIfVisible(Map<EdgeKey, OutlineEdge> edges, Set<Long> blocks, BlockPos origin, int x, int y, int z) {
        boolean westDown = contains(blocks, x - 1, y - 1, z);
        boolean westUp = contains(blocks, x - 1, y, z);
        boolean eastUp = contains(blocks, x, y, z);
        boolean eastDown = contains(blocks, x, y - 1, z);

        if (!isVisibleBoundaryEdge(westDown, westUp, eastUp, eastDown)) return;

        addEdge(
                edges,
                x - origin.getX(),
                y - origin.getY(),
                z - origin.getZ(),
                x - origin.getX(),
                y - origin.getY(),
                z + 1 - origin.getZ()
        );
    }

    private static boolean isVisibleBoundaryEdge(boolean westDown, boolean westUp, boolean eastUp, boolean eastDown) {
        int occupied = 0;
        if (westDown) occupied++;
        if (westUp) occupied++;
        if (eastUp) occupied++;
        if (eastDown) occupied++;

        if (occupied == 0 || occupied == 4) return false;
        if (occupied == 1 || occupied == 3) return true;

        return westDown && eastUp || westUp && eastDown;
    }

    private static boolean contains(Set<Long> blocks, int x, int y, int z) {
        return blocks.contains(BlockPos.asLong(x, y, z));
    }

    private static void addEdge(Map<EdgeKey, OutlineEdge> edges, int x1, int y1, int z1, int x2, int y2, int z2) {
        EdgeKey key = EdgeKey.create(x1, y1, z1, x2, y2, z2);
        edges.computeIfAbsent(key, ignored -> OutlineEdge.create(x1, y1, z1, x2, y2, z2));
    }

    private static void clearChiselOutline() {
        if (cachedTarget == null && cachedEdges.isEmpty()) return;

        cachedTarget = null;
        cachedDirection = null;
        cachedMode = null;
        cachedAffectedBlocks = List.of();
        cachedEdges = List.of();
    }
}
