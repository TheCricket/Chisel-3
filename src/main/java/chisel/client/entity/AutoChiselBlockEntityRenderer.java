package chisel.client.entity;

import chisel.Chisel;
import chisel.block.entity.AutoChiselBlockEntity;
import chisel.client.entity.state.AutoChiselBlockEntityRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
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

import java.util.logging.Logger;

public class AutoChiselBlockEntityRenderer implements BlockEntityRenderer<AutoChiselBlockEntity, AutoChiselBlockEntityRenderState> {

    private final ItemModelResolver itemModelResolver;

    private final int STACK_UPGRADE = 0;
    private final int AUTOMATION_UPGRADE = 1;
    private final int REVERSION_UPGRADE = 2;
    private final int SPEED_UPGRADE = 3;


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

        Logger.getLogger(Chisel.MODID).info(autoChisel.getItem(AutoChiselBlockEntity.TEMPLATE_SLOT).toString());
        itemModelResolver.updateForTopItem(state.block, block, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[STACK_UPGRADE], stackUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[AUTOMATION_UPGRADE], automationUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[REVERSION_UPGRADE], reversionUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.upgrades[SPEED_UPGRADE], speedUpgrade, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
        itemModelResolver.updateForTopItem(state.chisel, chisel, ItemDisplayContext.FIXED, autoChisel.getLevel(), null, 0);
    }

    @Override
    public void submit(@NonNull AutoChiselBlockEntityRenderState state, @NonNull PoseStack pose, @NonNull SubmitNodeCollector submit, @NonNull CameraRenderState camera) {
        pose.pushPose();
        state.block.submit(pose, submit, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        pose.popPose();
    }
}
