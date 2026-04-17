package chisel.client;

import chisel.events.client.AddLayersEventHandler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
        if(state.isCrouching) pose.rotateAround(Axis.XP.rotation(28.64789F), 1.0F, 0.0F, 0.0F);
        pose.rotateAround(Axis.XP.rotationDegrees(180), 1, 0, 0);
        pose.rotateAround(Axis.YP.rotationDegrees(90), 0, 1, 0);
        pose.translate(-0.25F, -0.85F, state.chestEquipment != ItemStack.EMPTY ? 0.28F : 0.2F);
        pose.scale(0.5F, 0.5F, 0.5F);

        getParentModel().body.translateAndRotate(pose);
        item.submit(pose, submit, lightCoords, OverlayTexture.NO_OVERLAY, 0);
        pose.popPose();
    }
}
