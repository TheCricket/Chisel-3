package io.github.chiselteam.chisel.events.client;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.VIPRenderLayer;
import io.github.chiselteam.chisel.registry.ChiselItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.renderstate.AvatarRenderStateModifier;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class AddLayersEventHandler {

    public static final ContextKey<ItemStackRenderState> VIP_ITEM = new ContextKey<>(Chisel.prefix("vip_item"));

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerModelType type : event.getSkins()) {
            AvatarRenderer<AbstractClientPlayer> playerRenderer = event.getPlayerRenderer(type);
            if (playerRenderer != null) {
                playerRenderer.addLayer(new VIPRenderLayer(playerRenderer));
            }
        }
    }

    @SubscribeEvent
    public static void registerRenderStateModifiers(RegisterRenderStateModifiersEvent event) {
        Map<UUID, ItemLike> VIPS = new HashMap<>();
        // Devs
        VIPS.put(UUID.fromString("a7529984-8cb2-4fb9-b799-97980f770101"), ChiselItems.CHISEL_OBSIDIAN); // Cricket

        // Artists
        VIPS.put(UUID.fromString("e350ef68-2feb-4127-b0ce-611e5304685a"), ChiselItems.CHISEL_DIAMOND); // Cebularz
        VIPS.put(UUID.fromString("5399b615-3440-4c66-939d-ab1375952ac3"), ChiselItems.CHISEL_DIAMOND); // Drullkus
        VIPS.put(UUID.fromString("735d1fe0-0d75-4cee-86a1-bc11b62ca48a"), ChiselItems.CHISEL_DIAMOND); // RPorotos

        // Gallery
        VIPS.put(UUID.fromString("ba1dd62a-00ac-4c18-bb91-1e02ed4b65d8"), ChiselItems.CHISEL_DIAMOND); // Buddy610

        // Community
        VIPS.put(UUID.fromString("d1af5f04-c4cc-486f-b187-fcb0a745bda6"), ChiselItems.CHISEL_IRON); // BeanxxBot
        VIPS.put(UUID.fromString("ba6efe89-0b84-4c5d-9f0e-b42edef10d6a"), ChiselItems.CHISEL_IRON); // NightRhyme45747
        VIPS.put(UUID.fromString("8131ab4b-4b9e-4f50-9fee-7c2e47f2e29c"), ChiselItems.CHISEL_IRON); // Splurkz


        event.registerAvatarEntityModifier(new AvatarRenderStateModifier() {
            @Override
            public <T extends Avatar & ClientAvatarEntity> void accept(@NonNull T avatar, @NonNull AvatarRenderState state) {
                ItemLike item = VIPS.get(avatar.getUUID());
                if(item == null) return;

                ItemStackRenderState stack = new ItemStackRenderState();
                Minecraft.getInstance().getItemModelResolver().updateForTopItem(stack, item.asItem().getDefaultInstance(), ItemDisplayContext.FIXED, null, null, 0);

                state.setRenderData(VIP_ITEM, stack);
            }
        });
    }
}
