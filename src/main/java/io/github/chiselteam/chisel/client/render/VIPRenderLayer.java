package io.github.chiselteam.chisel.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.chiselteam.chisel.event.client.AddLayersEventHandler;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class VIPRenderLayer extends RenderLayer<AvatarRenderState, PlayerModel> {

    public VIPRenderLayer(RenderLayerParent<AvatarRenderState, PlayerModel> renderer) {
        super(renderer);
    }

    @Override
    public void submit(@NonNull PoseStack pose, @NonNull SubmitNodeCollector submit, int lightCoords, @NonNull AvatarRenderState state, float yRot, float xRot) {
        if(state.isInvisible || state.isSpectator) return;

        ItemStackRenderState item = state.getRenderData(AddLayersEventHandler.VIP_ITEM);
        if(item == null) return;

        pose.pushPose();
        getParentModel().body.translateAndRotate(pose);
        pose.mulPose(Axis.XP.rotationDegrees(180.0F));
        pose.mulPose(Axis.YP.rotationDegrees(90.0F));
        boolean armor = state.legsEquipment != ItemStack.EMPTY;
        pose.translate(-0.125F, -0.85F, armor ? 0.2F : 0.28F);
        pose.scale(0.5F, 0.5F, 0.5F);

        item.submit(pose, submit, lightCoords, OverlayTexture.NO_OVERLAY, 0);
        pose.popPose();
    }
}
