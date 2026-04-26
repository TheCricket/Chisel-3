package chisel.client.entity;

import chisel.block.entity.AutoChiselBlockEntity;
import chisel.client.entity.state.AutoChiselBlockEntityRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class AutoChiselBlockEntityRenderer implements BlockEntityRenderer<AutoChiselBlockEntity, AutoChiselBlockEntityRenderState> {

    private final ItemModelResolver itemModelResolver;
    private final int LIGHT_COORDS = 15728850;

    public AutoChiselBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        itemModelResolver = context.itemModelResolver();
    }

    @Override
    public @NonNull AutoChiselBlockEntityRenderState createRenderState() {
        return new AutoChiselBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(@NonNull AutoChiselBlockEntity autoChisel, @NonNull AutoChiselBlockEntityRenderState state, float partialTicks, @NonNull Vec3 camera, @Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(autoChisel, state, partialTicks, camera, breakProgress);
        ItemStack block = autoChisel.getItem(AutoChiselBlockEntity.TEMPLATE_SLOT);
        ItemStack stackUpgrade = autoChisel.getItem(AutoChiselBlockEntity.STACK_UPGRADE_SLOT);
        ItemStack automationUpgrade = autoChisel.getItem(AutoChiselBlockEntity.AUTOMATION_UPGRADE_SLOT);
        ItemStack reversionUpgrade = autoChisel.getItem(AutoChiselBlockEntity.REVERSION_UPGRADE_SLOT);
        ItemStack speedUpgrade = autoChisel.getItem(AutoChiselBlockEntity.SPEED_UPGRADE_SLOT);
        ItemStack chisel = autoChisel.getItem(AutoChiselBlockEntity.CHISEL_SLOT);

        itemModelResolver.updateForTopItem(state.block, block, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[0], stackUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[1], automationUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[2], reversionUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[3], speedUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.chisel, chisel, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
    }

    @Override
    public void submit(@NonNull AutoChiselBlockEntityRenderState state, @NonNull PoseStack pose, @NonNull SubmitNodeCollector submit, @NonNull CameraRenderState camera) {
        submitBlock(pose, submit, state);
        submitChisel(pose, submit, state);
        submitUpgrades(pose, submit, state);
    }

    private void submitBlock(PoseStack pose, SubmitNodeCollector submit, AutoChiselBlockEntityRenderState state) {
        pose.pushPose();
        pose.scale(0.75F, 0.75F, 0.75F);
        pose.translate(0.65, 1.0, 0.65);
        state.block.submit(pose, submit, LIGHT_COORDS, OverlayTexture.NO_OVERLAY, 0);
        pose.popPose();
    }

    private void submitUpgrades(PoseStack pose, SubmitNodeCollector submit, AutoChiselBlockEntityRenderState state) {
        for (int c = 0; c < state.upgrades.length; c++) {
            pose.pushPose();
            pose.translate(0.05F, 0.67F, 0.2F + (c * 0.2F));
            pose.rotateAround(Axis.YP.rotationDegrees(90), 0, 1, 0);
            pose.scale(0.1F, 0.1F, 0.1F);
            state.upgrades[c].submit(pose, submit, LIGHT_COORDS, OverlayTexture.NO_OVERLAY, 0);
            pose.popPose();
        }
    }

    private void submitChisel(PoseStack pose, SubmitNodeCollector submit, AutoChiselBlockEntityRenderState state) {
        pose.pushPose();
        pose.translate(0.5F, 0.625F, 0.5F);
        pose.rotateAround(Axis.XP.rotationDegrees(90), 1, 0, 0);
        pose.rotateAround(Axis.ZP.rotationDegrees(180), 0, 0, 1);
        state.chisel.submit(pose, submit, LIGHT_COORDS, OverlayTexture.NO_OVERLAY, 0);
        pose.popPose();
    }
}
