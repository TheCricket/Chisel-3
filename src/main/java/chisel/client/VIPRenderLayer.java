package chisel.client;

import chisel.registry.ChiselItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VIPRenderLayer extends RenderLayer<AvatarRenderState, PlayerModel> {

    public static final Map<UUID, ItemLike> VIPS = new HashMap<>();

    public VIPRenderLayer(RenderLayerParent<AvatarRenderState, PlayerModel> renderer) {
        super(renderer);
        VIPS.put(UUID.fromString("a7529984-8cb2-4fb9-b799-97980f770101"), ChiselItems.CHISEL_OBSIDIAN);
        VIPS.put(UUID.fromString("d1af5f04-c4cc-486f-b187-fcb0a745bda6"), ChiselItems.CHISEL_IRON);

    }

    @Override
    public void submit(@NonNull PoseStack pose, @NonNull SubmitNodeCollector submit, int lightCoords, @NonNull AvatarRenderState state, float yRot, float xRot) {
        if(state.isInvisible || state.isSpectator) return;

        ClientLevel level = Minecraft.getInstance().level;
        if(level == null) return;

        Entity entity = level.getEntity(state.id);
        if(!(entity instanceof Player player)) return;
        if(!shouldRenderBadge(player)) return;

        ItemLike item = VIPS.get(player.getUUID());

        pose.pushPose();
        getParentModel().body.translateAndRotate(pose);
        //TODO: Finish this
        pose.popPose();
    }

    private boolean shouldRenderBadge(Player player) {
        return VIPS.containsKey(player.getUUID());
    }
}
