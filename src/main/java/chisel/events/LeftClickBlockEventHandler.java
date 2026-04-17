package chisel.events;

import chisel.Chisel;
import chisel.core.variant.VariantFamily;
import chisel.datagen.ChiselBlockTags;
import chisel.registry.ChiselItemAbilities;
import chisel.registry.ChiselSounds;
import chisel.util.VariantFinder;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
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
            VariantFamily family = VariantFinder.getFamilyForBlock(state.getBlock(), level.registryAccess());

            if(family != null) {
                CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
                if (customData != null) {
                    ItemStack innerStack = customData.copyTag().contains("chiselItem")
                            ? ItemStack.CODEC.parse(NbtOps.INSTANCE, customData.copyTag().get("chiselItem")).result().orElse(ItemStack.EMPTY)
                            : ItemStack.EMPTY;
                    checkIfStoringItem(level, player, hand, pos, family, innerStack, stack);
                } else {
                    chiselNextVariant(level, player, hand, family, pos, state, stack);
                }
            }
        }
    }

    private static void checkIfStoringItem(Level level, Player player, InteractionHand hand, BlockPos pos, VariantFamily family, ItemStack innerStack, ItemStack chisel) {
        if (!innerStack.isEmpty()) {
            if(innerStack.getItem() instanceof BlockItem blockItem) {
                if(family.isBlockInFamily(blockItem.getBlock())) {
                    chiselBlock(level, player, hand, pos, blockItem.getBlock().defaultBlockState(), chisel);
                }
            }
        }
    }

    private static void chiselNextVariant(Level level, Player player, InteractionHand hand, VariantFamily family, BlockPos pos, BlockState state, ItemStack chisel) {
        long time = level.getGameTime();

        if (LAST_CHISEL_TIME.getUnchecked(player) > time - 4)
            return;
        LAST_CHISEL_TIME.put(player, time);

        for (int c = 0; c < family.getVariants().size(); c++) {
            if (state.is(family.getVariants().get(c).getBlock())) {
                if (c == family.getVariants().size() - 1) {
                    chiselBlock(level, player, hand, pos, family.getVariants().getFirst().getBlock().defaultBlockState(), chisel);
                } else {
                    chiselBlock(level, player, hand, pos, family.getVariants().get(c + 1).getBlock().defaultBlockState(), chisel);
                }
            }
        }
    }

    private static void chiselBlock(Level level, Player player, InteractionHand hand, BlockPos pos, BlockState state, ItemStack chisel) {
        level.setBlockAndUpdate(pos, state);
        level.addDestroyBlockEffect(pos, state);
        level.playSound(null, pos, state.is(ChiselBlockTags.WOOD) ? ChiselSounds.WOOD.value() : ChiselSounds.FALLBACK.value(), SoundSource.BLOCKS);
        chisel.hurtAndBreak(1, player, hand);
    }
}
