package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IronFamily extends ChiselFamily {
    public IronFamily(BlockBehaviour.Properties props) {
        family = builder("iron")
                .addVariant(Blocks.IRON_BLOCK)
                .addVariant("iron_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("iron_bolted", props)
                .addVariant("iron_caution", props, VariantModelType.CONNECTED)
                .addVariant("iron_crate", props, VariantModelType.CONNECTED)
                .addVariant("iron_machine", props)
                .addVariant("iron_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("iron_thermal", props, VariantModelType.TBS)
                .addVariant("iron_125", props)
                .addVariant("iron_bordered", props, VariantModelType.CONNECTED)
                .addVariant("iron_brick", props, VariantModelType.TBS)
                .addVariant("iron_coin_heads", props, VariantModelType.TBS)
                .addVariant("iron_coin_tails", props, VariantModelType.TBS)
                .addVariant("iron_crate_dark", props, VariantModelType.TBS)
                .addVariant("iron_crate_light", props, VariantModelType.TBS)
                .addVariant("iron_gears", props, VariantModelType.TBS)
                .addVariant("iron_ingots_large", props, VariantModelType.TBS)
                .addVariant("iron_ingots_small", props, VariantModelType.TBS)
                .addVariant("iron_moon", props, VariantModelType.TBS)
                .addVariant("iron_moon_obsidian", props)
                .addVariant("iron_moon_obsidian_purple", props)
                .addVariant("iron_plates", props, VariantModelType.TBS)
                .addVariant("iron_rivets", props, VariantModelType.TBS)
                .addVariant("iron_shipping", props, VariantModelType.CONNECTED)
                .addVariant("iron_simple", props, VariantModelType.TBS)
                .addVariant("iron_vents", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("iron_bad_greggy"), "Iron", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("iron_bolted"), "Iron", "Fancy Bolted Plating");
        lang.addBlock(getVariant("iron_caution"), "Iron", "Caution Stripes");
        lang.addBlock(getVariant("iron_crate"), "Iron", "Shipping Crate");
        lang.addBlock(getVariant("iron_machine"), "Iron", "Machine");
        lang.addBlock(getVariant("iron_scaffold"), "Iron", "Scaffold");
        lang.addBlock(getVariant("iron_thermal"), "Iron", "Thermal");
        lang.addBlock(getVariant("iron_125"), "Iron", "125");
        lang.addBlock(getVariant("iron_bordered"), "Iron", "Egregiously Bordered Block");
        lang.addBlock(getVariant("iron_brick"), "Iron", "Iron Bricks");
        lang.addBlock(getVariant("iron_coin_heads"), "Iron", "Iron Coin Stack Heads-up");
        lang.addBlock(getVariant("iron_coin_tails"), "Iron", "Iron Coin Stack Heads-down");
        lang.addBlock(getVariant("iron_crate_dark"), "Iron", "Dark Iron Crate");
        lang.addBlock(getVariant("iron_crate_light"), "Iron", "Light Iron Crate");
        lang.addBlock(getVariant("iron_gears"), "Iron", "Iron Gears");
        lang.addBlock(getVariant("iron_ingots_large"), "Iron", "Large Iron Ingots");
        lang.addBlock(getVariant("iron_ingots_small"), "Iron", "Small Iron Ingots");
        lang.addBlock(getVariant("iron_moon"), "Iron", "Iron Block with Moon Decoration");
        lang.addBlock(getVariant("iron_moon_obsidian"), "Iron", "Iron Moon in Obsidian");
        lang.addBlock(getVariant("iron_moon_obsidian_purple"), "Iron", "Iron Moon in Purple Obsidian");
        lang.addBlock(getVariant("iron_plates"), "Iron", "Iron Plates");
        lang.addBlock(getVariant("iron_rivets"), "Iron", "Iron Plates with Rivets");
        lang.addBlock(getVariant("iron_shipping"), "Iron", "Shipping Crate");
        lang.addBlock(getVariant("iron_simple"), "Iron", "Simple Iron Block");
        lang.addBlock(getVariant("iron_vents"), "Iron", "Iron Vents");
    }
}
