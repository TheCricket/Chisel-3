package io.github.chiselteam.chisel.event;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.chisel.item.ChiselItem;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import io.github.chiselteam.chisel.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.NbtOps;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

@EventBusSubscriber(modid = Chisel.MODID)
public class LeftClickBlockEventHandler {

    private static final LoadingCache<Player, Long> LAST_CHISEL_TIME = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .weakKeys()
            .build(new CacheLoader<>() {
                public @NonNull Long load(@NonNull Player key) {
                    return 0L;
                }
            });

    @SubscribeEvent
    public static void onHitBlock(PlayerInteractEvent.LeftClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();

        ItemStack stack = event.getItemStack();
        if(stack.canPerformAction(ChiselItemAbilities.CHISEL)) {
            BlockState state = level.getBlockState(pos);
            VariantFamily family = VariantFamilyLookup.getFamilyForBlock(state.getBlock(), level.registryAccess());

            if(family != null) {
                if (family.getFamilyName().equals("torch")) {
                    return;
                }

                long time = level.getGameTime();
                if (LAST_CHISEL_TIME.getUnchecked(player) > time - 4) {
                    event.setCanceled(true);
                    return;
                }
                LAST_CHISEL_TIME.put(player, time);

                ChiselMode mode = stack.getOrDefault(ChiselDataComponents.CHISEL_MODE, ChiselModes.SINGLE.value());

                CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
                if (customData != null && customData.copyTag().contains("chiselItem")) {
                    ItemStack innerStack = ItemStack.CODEC.parse(NbtOps.INSTANCE, customData.copyTag().get("chiselItem")).result().orElse(ItemStack.EMPTY);
                    if (!innerStack.isEmpty() && innerStack.getItem() instanceof BlockItem blockItem) {
                        if (family.isBlockInFamily(blockItem.getBlock())) {
                            List<BlockPos> affected = mode.getAffectedBlocks(level, player, pos, event.getFace(), state);
                            BlockState nextState = blockItem.getBlock().defaultBlockState();
                            for (BlockPos p : affected) {
                                chiselBlock(level, player, hand, p, nextState, stack);
                            }
                            if (!affected.isEmpty()) {
                                playEffects(level, player, pos, nextState);
                            }
                        }
                    }
                } else {
                    mode.onLeftClick(level, player, hand, pos, event.getFace(), state, stack);
                }
                event.setCanceled(true);
            }
        }
    }

    private static void chiselBlock(Level level, Player player, InteractionHand hand, BlockPos pos, BlockState state, ItemStack chisel) {
        level.setBlockAndUpdate(pos, state);
        ChiselItem.hurtAndBreak(chisel, 1, player, hand);
    }

    private static void playEffects(Level level, Player player, BlockPos hitPos, BlockState state) {
        level.addDestroyBlockEffect(hitPos, state);
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                state.is(ChiselTags.WOOD) ? ChiselSounds.WOOD.value() : ChiselSounds.FALLBACK.value(),
                SoundSource.PLAYERS);
    }
}
