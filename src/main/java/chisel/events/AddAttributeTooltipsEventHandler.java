package chisel.events;

import chisel.Chisel;
import chisel.registry.ChiselVariants;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddAttributeTooltipsEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class AddAttributeTooltipsEventHandler {

    @SubscribeEvent
    public static void addTooltips(AddAttributeTooltipsEvent event) {
        ChiselVariants.getVariantFamilies().forEach(family -> family.getVariants().forEach(v -> {
            if (event.getStack().is(v.getBlock().asItem())) {
                event.addTooltipLines(Component.translatable(v.getTranslationKey()).withStyle(ChatFormatting.GRAY));
            }
        }));
    }
}
