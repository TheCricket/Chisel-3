package chisel.events;

import chisel.Chisel;
import chisel.datagen.VariantFamilies;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddAttributeTooltipsEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class AddAttributeTooltipsEventHandler {

    @SubscribeEvent
    public static void addTooltips(AddAttributeTooltipsEvent event) {
        VariantFamilies.getAllFamilies().forEach(family -> family.getVariants().forEach(variant -> {
            if(event.getStack().is(variant.getBlock().get().asItem())) {
                event.addTooltipLines(Component.translatable(variant.getTranslationKey()).withStyle(ChatFormatting.GRAY));
            }
        }));
    }
}
