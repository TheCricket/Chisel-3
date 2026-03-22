package chisel.item;

import chisel.menu.ChiselMenu;
import chisel.registry.ChiselItemAbilities;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ItemAbility;
import org.jspecify.annotations.NonNull;

public class ChiselItem extends Item {

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canPerformAction(@NonNull ItemInstance stack, @NonNull ItemAbility itemAbility) {
        if(itemAbility == ChiselItemAbilities.CHISEL) return true;
        return super.canPerformAction(stack, itemAbility);
    }

    @Override
    public @NonNull InteractionResult use(Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if (!level.isClientSide()) {
            player.startUsingItem(hand);
            player.openMenu(new SimpleMenuProvider(
                    (id, inv, _) -> new ChiselMenu(id, inv, new FriendlyByteBuf(Unpooled.buffer().setBoolean(0, hand == InteractionHand.MAIN_HAND))),
                    Component.translatable("container.chisel")
            ));
        }
        return InteractionResult.SUCCESS;
    }
}
