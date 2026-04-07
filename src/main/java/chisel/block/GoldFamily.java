package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GoldFamily extends ChiselBlock {
    public GoldFamily(BlockBehaviour.Properties props) {
        family = builder("gold")
                .addVariant(Blocks.GOLD_BLOCK)
                .addVariant("gold_125", props)
                .addVariant("gold_adv", props)
                .addVariant("gold_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("gold_brick", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_caution", props)
                .addVariant("gold_cart", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_coin_heads", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_coin_tails", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_crate_dark", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_crate_light", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_egregious", props, VariantModelType.CONNECTED)
                .addVariant("gold_ingots_large", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_ingots_small", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_machine", props)
                .addVariant("gold_plates", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_rivets", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("gold_shipping", props)
                .addVariant("gold_simple", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_star_decor", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_star_obsidian", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_star_obsidian_purple", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("gold_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("gold_125"), "Gold", "125");
        lang.addBlock(getVariant("gold_adv"), "Gold", "Advanced");
        lang.addBlock(getVariant("gold_bad_greggy"), "Gold", "Bad Greggy");
        lang.addBlock(getVariant("gold_brick"), "Gold", "Brick");
        lang.addBlock(getVariant("gold_caution"), "Gold", "Caution");
        lang.addBlock(getVariant("gold_cart"), "Gold", "Cart");
        lang.addBlock(getVariant("gold_coin_heads"), "Gold", "Coin (Heads)");
        lang.addBlock(getVariant("gold_coin_tails"), "Gold", "Coin (Tails)");
        lang.addBlock(getVariant("gold_crate_dark"), "Gold", "Dark Crate");
        lang.addBlock(getVariant("gold_egregious"), "Gold", "Egregious");
        lang.addBlock(getVariant("gold_ingots_large"), "Gold", "Large Ingots");
        lang.addBlock(getVariant("gold_ingots_small"), "Gold", "Small Ingots");
        lang.addBlock(getVariant("gold_machine"), "Gold", "Machine");
        lang.addBlock(getVariant("gold_plates"), "Gold", "Plates");
        lang.addBlock(getVariant("gold_rivets"), "Gold", "Rivets");
        lang.addBlock(getVariant("gold_scaffold"), "Gold", "Scaffold");
        lang.addBlock(getVariant("gold_shipping"), "Gold", "Shipping Crate");
        lang.addBlock(getVariant("gold_simple"), "Gold", "Simple");
        lang.addBlock(getVariant("gold_star_decor"), "Gold", "Star Decor");
        lang.addBlock(getVariant("gold_star_obsidian"), "Gold", "Obsidian Star");
        lang.addBlock(getVariant("gold_star_obsidian_purple"), "Gold", "Purple Obsidian Star");
        lang.addBlock(getVariant("gold_thermal"), "Gold", "Thermal");
    }
}

