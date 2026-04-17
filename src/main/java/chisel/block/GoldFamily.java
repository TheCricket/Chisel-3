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
                .addVariant("gold_brick", props, VariantModelType.TBS)
                .addVariant("gold_caution", props)
                .addVariant("gold_cart", props, VariantModelType.TBS)
                .addVariant("gold_coin_heads", props, VariantModelType.TBS)
                .addVariant("gold_coin_tails", props, VariantModelType.TBS)
                .addVariant("gold_crate_dark", props, VariantModelType.TBS)
                .addVariant("gold_crate_light", props, VariantModelType.TBS)
                .addVariant("gold_egregious", props, VariantModelType.CONNECTED)
                .addVariant("gold_ingots_large", props, VariantModelType.TBS)
                .addVariant("gold_ingots_small", props, VariantModelType.TBS)
                .addVariant("gold_machine", props)
                .addVariant("gold_plates", props, VariantModelType.TBS)
                .addVariant("gold_rivets", props, VariantModelType.TBS)
                .addVariant("gold_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("gold_shipping", props)
                .addVariant("gold_simple", props, VariantModelType.TBS)
                .addVariant("gold_star_decor", props, VariantModelType.TBS)
                .addVariant("gold_star_obsidian", props, VariantModelType.TBS)
                .addVariant("gold_star_obsidian_purple", props, VariantModelType.TBS)
                .addVariant("gold_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("gold_125"), "Gold", "125");
        lang.addBlock(getVariant("gold_adv"), "Gold", "Advanced");
        lang.addBlock(getVariant("gold_bad_greggy"), "Gold", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("gold_brick"), "Gold", "Golden Bricks");
        lang.addBlock(getVariant("gold_caution"), "Gold", "Caution Stripes");
        lang.addBlock(getVariant("gold_cart"), "Gold", "Gold Cart");
        lang.addBlock(getVariant("gold_coin_heads"), "Gold", "Golden Coin Stack Heads-up");
        lang.addBlock(getVariant("gold_coin_tails"), "Gold", "Golden Coin Stack Heads-down");
        lang.addBlock(getVariant("gold_crate_dark"), "Gold", "Dark Gold Crate");
        lang.addBlock(getVariant("gold_crate_light"), "Gold", "Light Gold Crate");
        lang.addBlock(getVariant("gold_egregious"), "Gold", "Egregiously Bordered Block");
        lang.addBlock(getVariant("gold_ingots_large"), "Gold", "Large Golden Ingots");
        lang.addBlock(getVariant("gold_ingots_small"), "Gold", "Small Golden Ingots");
        lang.addBlock(getVariant("gold_machine"), "Gold", "Machine");
        lang.addBlock(getVariant("gold_plates"), "Gold", "Golden Plates");
        lang.addBlock(getVariant("gold_rivets"), "Gold", "Gold Plates with Rivets");
        lang.addBlock(getVariant("gold_scaffold"), "Gold", "Scaffold");
        lang.addBlock(getVariant("gold_shipping"), "Gold", "Shipping Crate");
        lang.addBlock(getVariant("gold_simple"), "Gold", "Simple Gold Block");
        lang.addBlock(getVariant("gold_star_decor"), "Gold", "Gold Block with Star Decoration");
        lang.addBlock(getVariant("gold_star_obsidian"), "Gold", "Golden Star in Obsidian");
        lang.addBlock(getVariant("gold_star_obsidian_purple"), "Gold", "Golden Star in Purple Obsidian");
        lang.addBlock(getVariant("gold_thermal"), "Gold", "Thermal");
    }
}

