package io.github.chiselteam.chisel.events.client;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.mode.ChiselMode;
import io.github.chiselteam.chisel.network.ChiselModeChangePacket;
import io.github.chiselteam.chisel.registry.ChiselDataComponents;
import io.github.chiselteam.chisel.registry.ChiselItemAbilities;
import io.github.chiselteam.chisel.registry.ChiselKeyMappings;
import io.github.chiselteam.chisel.registry.ChiselModes;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;

import java.util.List;
import java.util.Objects;

@EventBusSubscriber(modid = Chisel.MODID)
public class ChiselModeSelectionHandler {

    private static final long ANIMATION_DURATION = 120_000_000L;
    private static boolean selecting;
    private static boolean changed;
    private static InteractionHand hand;
    private static ChiselMode originalMode, selectedMode;
    private static int selectedIndex;
    private static List<ChiselMode> modes;
    private static long animationStart;
    private static int animationDirection;

    @SubscribeEvent
    public static void onMouseScroll(InputEvent.MouseScrollingEvent event) {
        if(!selecting) return;
        if(event.getScrollDeltaY() == 0) return;

        List<ChiselMode> modes = getModes();
        if(modes.isEmpty()) return;

        int direction = event.getScrollDeltaY() > 0 ? -1 : 1;
        selectedIndex = Math.floorMod(selectedIndex + direction, modes.size());
        selectedMode = modes.get(selectedIndex);
        changed = !selectedMode.equals(originalMode);
        animationDirection = direction;
        animationStart = System.nanoTime();

        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        if(player == null) {
            cancelSelection();
            return;
        }

        if(!selecting) {
            if(!ChiselKeyMappings.MODE_SELECT.isDown()) return;
            if(minecraft.screen != null) return;

            InteractionHand chiselHand = findChiselHand(player);
            if(chiselHand == null) return;

            beginSelection(player, chiselHand);
            return;
        }

        if(!isValidChisel(player.getItemInHand(hand))) {
            cancelSelection();
            return;
        }

        if(minecraft.screen != null) {
            cancelSelection();
            return;
        }

        if(!ChiselKeyMappings.MODE_SELECT.isDown()) {
            commitSelection(player);
        }
    }

    private static void beginSelection(Player player, InteractionHand chiselHand) {
        ItemStack chisel = player.getItemInHand(chiselHand);
        List<ChiselMode> modes = getModes();
        if(modes.isEmpty()) return;

        ChiselMode currentMode = chisel.getOrDefault(ChiselDataComponents.CHISEL_MODE, ChiselModes.SINGLE.value());
        int index = modes.indexOf(currentMode);
        if(index < 0) index = 0;

        selecting = true;
        changed = false;
        hand = chiselHand;
        originalMode = currentMode;
        selectedMode = modes.get(index);
        selectedIndex = index;
    }

    private static void commitSelection(Player player) {
        if(!selecting) return;
        if(changed && selectedMode != null) {
            ItemStack chisel = player.getItemInHand(hand);
            chisel.set(ChiselDataComponents.CHISEL_MODE, selectedMode);

            Objects.requireNonNull(Minecraft.getInstance().getConnection()).send(new ChiselModeChangePacket(hand, selectedMode));
        }

        clearSelection();
    }

    private static void cancelSelection() {
        if(!selecting) return;
        clearSelection();
    }

    private static void clearSelection() {
        selecting = false;
        changed = false;
        hand = null;
        originalMode = null;
        selectedMode = null;
        selectedIndex = 0;
        animationStart = 0;
        animationDirection = 0;
    }

    private static InteractionHand findChiselHand(Player player) {
        if (isValidChisel(player.getMainHandItem())) return InteractionHand.MAIN_HAND;
        if (isValidChisel(player.getOffhandItem())) return InteractionHand.OFF_HAND;
        return null;
    }

    private static boolean isValidChisel(ItemStack stack) {
        return !stack.isEmpty() && stack.canPerformAction(ChiselItemAbilities.CHISEL);
    }

    private static List<ChiselMode> getModes() {
        if(modes == null) modes = List.copyOf(ChiselModes.REGISTRY.stream().toList());
        return modes;
    }

    public static boolean isSelecting() {
        return selecting;
    }

    public static ChiselMode getSelectedMode() {
        return selectedMode;
    }

    public static int getSelectedIndex() {
        return selectedIndex;
    }

    public static List<ChiselMode> getAvailableModes() {
        return getModes();
    }

    public static float getAnimationProgress() {
        if(animationStart == 0) return 1.0F;

        float progress = (float) (System.nanoTime() - animationStart) / ANIMATION_DURATION;
        if(progress >= 1.0F) {
            animationStart = 0;
            return 1.0F;
        }

        return progress;
    }

    public static int getAnimationDirection() {
        return animationDirection;
    }
}
