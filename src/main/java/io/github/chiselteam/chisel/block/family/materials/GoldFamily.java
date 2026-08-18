package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class GoldFamily extends ChiselFamily {
    public GoldFamily(BlockBehaviour.Properties props) {
        family = builder("gold")
                .addVariant(Blocks.GOLD_BLOCK)
                .addVariant("gold_125", props)
                .addVariant("gold_adv", props)
                .addVariant("gold_bad_greggy", props, CONNECTED)
                .addVariant("gold_brick", props, TBS)
                .addVariant("gold_caution", props)
                .addVariant("gold_cart", props, TBS)
                .addVariant("gold_coin_heads", props, TBS)
                .addVariant("gold_coin_tails", props, TBS)
                .addVariant("gold_crate_dark", props, TBS)
                .addVariant("gold_crate_light", props, TBS)
                .addVariant("gold_egregious", props, CONNECTED)
                .addVariant("gold_ingots_large", props, TBS)
                .addVariant("gold_ingots_small", props, TBS)
                .addVariant("gold_machine", props)
                .addVariant("gold_plates", props, TBS)
                .addVariant("gold_rivets", props, TBS)
                .addVariant("gold_scaffold", props, CONNECTED)
                .addVariant("gold_shipping", props)
                .addVariant("gold_simple", props, TBS)
                .addVariant("gold_star_decor", props, TBS)
                .addVariant("gold_star_obsidian", props, TBS)
                .addVariant("gold_star_obsidian_purple", props, TBS)
                .addVariant("gold_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("gold_125"), "Block of Gold", "125");
        lang.addBlock(getVariant("gold_adv"), "Block of Gold", "Advanced");
        lang.addBlock(getVariant("gold_bad_greggy"), "Block of Gold", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("gold_brick"), "Block of Gold", "Golden Bricks");
        lang.addBlock(getVariant("gold_caution"), "Block of Gold", "Caution Stripes");
        lang.addBlock(getVariant("gold_cart"), "Block of Gold", "Gold Cart");
        lang.addBlock(getVariant("gold_coin_heads"), "Block of Gold", "Golden Coin Stack Heads-up");
        lang.addBlock(getVariant("gold_coin_tails"), "Block of Gold", "Golden Coin Stack Heads-down");
        lang.addBlock(getVariant("gold_crate_dark"), "Block of Gold", "Dark Gold Crate");
        lang.addBlock(getVariant("gold_crate_light"), "Block of Gold", "Light Gold Crate");
        lang.addBlock(getVariant("gold_egregious"), "Block of Gold", "Egregiously Bordered Block");
        lang.addBlock(getVariant("gold_ingots_large"), "Block of Gold", "Large Golden Ingots");
        lang.addBlock(getVariant("gold_ingots_small"), "Block of Gold", "Small Golden Ingots");
        lang.addBlock(getVariant("gold_machine"), "Block of Gold", "Machine");
        lang.addBlock(getVariant("gold_plates"), "Block of Gold", "Golden Plates");
        lang.addBlock(getVariant("gold_rivets"), "Block of Gold", "Gold Plates with Rivets");
        lang.addBlock(getVariant("gold_scaffold"), "Block of Gold", "Scaffold");
        lang.addBlock(getVariant("gold_shipping"), "Block of Gold", "Shipping Crate");
        lang.addBlock(getVariant("gold_simple"), "Block of Gold", "Simple Gold Block");
        lang.addBlock(getVariant("gold_star_decor"), "Block of Gold", "Gold Block with Star Decoration");
        lang.addBlock(getVariant("gold_star_obsidian"), "Block of Gold", "Golden Star in Obsidian");
        lang.addBlock(getVariant("gold_star_obsidian_purple"), "Block of Gold", "Golden Star in Purple Obsidian");
        lang.addBlock(getVariant("gold_thermal"), "Block of Gold", "Thermal");
    }
}

