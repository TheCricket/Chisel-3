package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IronFamily extends ChiselBlock {
    public IronFamily(BlockBehaviour.Properties props) {
        family = builder("iron")
                .addVariant(Blocks.IRON_BLOCK)
                .addVariant("iron_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("iron_bolted", props)
                .addVariant("iron_caution", props, VariantModelType.CONNECTED)
                .addVariant("iron_crate", props, VariantModelType.CONNECTED)
                .addVariant("iron_machine", props)
                .addVariant("iron_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("iron_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_125", props)
                .addVariant("iron_bordered", props, VariantModelType.CONNECTED)
                .addVariant("iron_brick", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_coin_heads", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_coin_tails", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_crate_dark", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_crate_light", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_gears", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_ingots_large", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_ingots_small", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_moon", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_moon_obsidian", props)
                .addVariant("iron_moon_obsidian_purple", props)
                .addVariant("iron_plates", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_rivets", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_shipping", props, VariantModelType.CONNECTED)
                .addVariant("iron_simple", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("iron_vents", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("iron_bad_greggy"), "Iron", "Bad Greggy");
        lang.addBlock(getVariant("iron_bolted"), "Iron", "Bolted");
        lang.addBlock(getVariant("iron_caution"), "Iron", "Caution");
        lang.addBlock(getVariant("iron_crate"), "Iron", "Crate");
        lang.addBlock(getVariant("iron_machine"), "Iron", "Machine");
        lang.addBlock(getVariant("iron_scaffold"), "Iron", "Scaffold");
        lang.addBlock(getVariant("iron_thermal"), "Iron", "Thermal");
        lang.addBlock(getVariant("iron_125"), "Iron", "125");
        lang.addBlock(getVariant("iron_bordered"), "Iron", "Bordered");
        lang.addBlock(getVariant("iron_brick"), "Iron", "Brick");
        lang.addBlock(getVariant("iron_coin_heads"), "Iron", "Coin (Heads)");
        lang.addBlock(getVariant("iron_coin_tails"), "Iron", "Coin (Tails)");
        lang.addBlock(getVariant("iron_crate_dark"), "Iron", "Dark Crate");
        lang.addBlock(getVariant("iron_crate_light"), "Iron", "Light Crate");
        lang.addBlock(getVariant("iron_gears"), "Iron", "Gears");
        lang.addBlock(getVariant("iron_ingots_large"), "Iron", "Large Ingots");
        lang.addBlock(getVariant("iron_ingots_small"), "Iron", "Small Ingots");
        lang.addBlock(getVariant("iron_moon"), "Iron", "Moon");
        lang.addBlock(getVariant("iron_moon_obsidian"), "Iron", "Obsidian Moon");
        lang.addBlock(getVariant("iron_moon_obsidian_purple"), "Iron", "Purple Obsidian Moon");
        lang.addBlock(getVariant("iron_plates"), "Iron", "Plates");
        lang.addBlock(getVariant("iron_rivets"), "Iron", "Rivets");
        lang.addBlock(getVariant("iron_shipping"), "Iron", "Shipping Crate");
        lang.addBlock(getVariant("iron_simple"), "Iron", "Simple");
        lang.addBlock(getVariant("iron_vents"), "Iron", "Vents");
    }
}
