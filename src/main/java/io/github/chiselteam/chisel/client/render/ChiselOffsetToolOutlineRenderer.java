package io.github.chiselteam.chisel.client.render;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.chisel.registry.ChiselItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ShapeRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.BlockOutlineRenderState;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ARGB;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.CustomBlockOutlineRenderer;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.awt.geom.Line2D;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static net.minecraft.core.Direction.*;

public class ChiselOffsetToolOutlineRenderer implements CustomBlockOutlineRenderer {

    private static final float LINE_WIDTH = 3.0F;

    @SuppressWarnings("FieldCanBeLocal")
    private final int HIGH_CONTRAST_COLOR = -11010079;
    private final int LOW_CONTRAST_COLOR = ARGB.black(102);
    private final BlockHitResult hit;
    private final Vec3 cameraRelativePos;

    public ChiselOffsetToolOutlineRenderer(BlockHitResult hit, Vec3 cameraRelativePos) {
        this.hit = hit;
        this.cameraRelativePos = cameraRelativePos;
    }

    @Override
    public boolean render(@NonNull BlockOutlineRenderState state, MultiBufferSource.@NonNull BufferSource bufferSource, @NonNull PoseStack pose, boolean translucentPass, @NonNull LevelRenderState levelState) {
        ClientLevel level = Minecraft.getInstance().level;
        BlockPos pos = state.pos();
        if (level == null) return false;
        Player player = Minecraft.getInstance().player;
        if (player == null) return false;
        if (!canOffset(player, InteractionHand.MAIN_HAND, pos, level) && !canOffset(player, InteractionHand.OFF_HAND, pos, level)) {
            return false;
        }

        VertexConsumer buffer = bufferSource.getBuffer(RenderTypes.lines());
        Vec3 vec = hit.getLocation();
        int outlineColor = state.highContrast() ? HIGH_CONTRAST_COLOR : LOW_CONTRAST_COLOR;
        int triangleColor = ARGB.color(0xAA, 0xFF, 0xFF, 0xFF);
        Direction face = hit.getDirection();

        // Bias each face slightly outward to prevent z-fighting with the block surface.
        float x = (float) (Math.max(0, face.getStepX()) + (0.01 * face.getStepX()));
        float y = (float) (Math.max(0, face.getStepY()) + (0.01 * face.getStepY()));
        float z = (float) (Math.max(0, face.getStepZ()) + (0.01 * face.getStepZ()));

        pose.pushPose();
        pose.translate(cameraRelativePos.x, cameraRelativePos.y, cameraRelativePos.z);
        PoseStack.Pose last = pose.last();

        // --- Draw the X (two diagonals across the hit face) ---
        if (face.getStepX() != 0) {
            drawLine(buffer, last, outlineColor, x, 0, 0, x, 1, 1);
            drawLine(buffer, last, outlineColor, x, 1, 0, x, 0, 1);
        } else if (face.getStepY() != 0) {
            drawLine(buffer, last, outlineColor, 0, y, 0, 1, y, 1);
            drawLine(buffer, last, outlineColor, 1, y, 0, 0, y, 1);
        } else {
            drawLine(buffer, last, outlineColor, 0, 0, z, 1, 1, z);
            drawLine(buffer, last, outlineColor, 1, 0, z, 0, 1, z);
        }

        // --- Draw the triangle pointing toward the offset direction ---
        Direction moveDir = getMoveDir(face, vec.x() - pos.getX(), vec.y() - pos.getY(), vec.z() - pos.getZ());
        float clampedX = Math.max(0, moveDir.getStepX());
        float clampedY = Math.max(0, moveDir.getStepY());
        float clampedZ = Math.max(0, moveDir.getStepZ());
        boolean isX = moveDir.getStepX() != 0;
        boolean isY = moveDir.getStepY() != 0;
        boolean isZ = moveDir.getStepZ() != 0;

        // Center of face, plus the two corners of the edge in the move direction.
        float cx, cy, cz, ax, ay, az, bx, by, bz;
        if (face.getStepX() != 0) {
            cx = x;
            cy = 0.5F;
            cz = 0.5F;
            ax = x;
            ay = isY ? clampedY : 0;
            az = isZ ? clampedZ : 0;
            bx = x;
            by = isY ? clampedY : 1;
            bz = isZ ? clampedZ : 1;
        } else if (face.getStepY() != 0) {
            cx = 0.5F;
            cy = y;
            cz = 0.5F;
            ax = isX ? clampedX : 0;
            ay = y;
            az = isZ ? clampedZ : 0;
            bx = isX ? clampedX : 1;
            by = y;
            bz = isZ ? clampedZ : 1;
        } else {
            cx = 0.5F;
            cy = 0.5F;
            cz = z;
            ax = isX ? clampedX : 0;
            ay = isY ? clampedY : 0;
            az = z;
            bx = isX ? clampedX : 1;
            by = isY ? clampedY : 1;
            bz = z;
        }
        VertexConsumer triBuffer = bufferSource.getBuffer(RenderTypes.debugTriangleFan());
        triBuffer.addVertex(last, cx, cy, cz).setColor(triangleColor);
        triBuffer.addVertex(last, ax, ay, az).setColor(triangleColor);
        triBuffer.addVertex(last, bx, by, bz).setColor(triangleColor);

        pose.popPose();
        return false;
    }

    /**
     * Emits a single line segment in the style of {@link ShapeRenderer#renderShape}:
     * the per-vertex normal is the normalized line direction, and a line width is applied so the
     * line shader can extrude the segment correctly.
     */
    private static void drawLine(VertexConsumer buffer, PoseStack.Pose pose, int color,
                                 float x1, float y1, float z1,
                                 float x2, float y2, float z2) {
        Vector3f normal = new Vector3f(x2 - x1, y2 - y1, z2 - z1).normalize();
        buffer.addVertex(pose, x1, y1, z1).setColor(color).setNormal(pose, normal).setLineWidth(LINE_WIDTH);
        buffer.addVertex(pose, x2, y2, z2).setColor(color).setNormal(pose, normal).setLineWidth(LINE_WIDTH);
    }

    private static boolean canOffset(Player player, InteractionHand hand, BlockPos pos, Level level) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getItem() == ChiselItems.OFFSET_TOOL.get()) {
            BlockState state = level.getBlockState(pos);
            VariantFamily family = VariantFamilyLookup.getFamilyForBlock(state.getBlock(), level.registryAccess());
            if(family == null) return false;

            AtomicBoolean checkVariant = new AtomicBoolean(false);

            family.getVariants().forEach(variant -> {
                if(state.is(variant.getBlock())) {
                    if(variant.getModelHandler().multiblockSize() > 0 && !variant.getModelHandler().usesRandomTexture()) checkVariant.set(true);
                }
            });

            return checkVariant.get();
        }
        return false;
    }

    public Direction getMoveDir(Direction face, double x, double y, double z) {
        Map<Double, Direction> map = Maps.newHashMap();
        if (face.getStepX() != 0) {
            fillMap(map, z, y, DOWN, UP, NORTH, SOUTH);
        } else if (face.getStepY() != 0) {
            fillMap(map, x, z, NORTH, SOUTH, WEST, EAST);
        } else if (face.getStepZ() != 0) {
            fillMap(map, x, y, DOWN, UP, WEST, EAST);
        }
        List<Double> keys = Lists.newArrayList(map.keySet());
        Collections.sort(keys);
        return map.get(keys.getFirst());
    }

    private void fillMap(Map<Double, Direction> map, double x, double y, Direction... dirs) {
        map.put(Line2D.ptLineDistSq(0, 0, 1, 0, x, y), dirs[0]);
        map.put(Line2D.ptLineDistSq(0, 1, 1, 1, x, y), dirs[1]);
        map.put(Line2D.ptLineDistSq(0, 0, 0, 1, x, y), dirs[2]);
        map.put(Line2D.ptLineDistSq(1, 0, 1, 1, x, y), dirs[3]);
    }
}
