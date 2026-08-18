package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class IronFamily extends ChiselFamily {
    public IronFamily(BlockBehaviour.Properties props) {
        family = builder("iron")
                .addVariant(Blocks.IRON_BLOCK)
                .addVariant("iron_bad_greggy", props, CONNECTED)
                .addVariant("iron_bolted", props)
                .addVariant("iron_caution", props, CONNECTED)
                .addVariant("iron_crate", props, CONNECTED)
                .addVariant("iron_machine", props)
                .addVariant("iron_scaffold", props, CONNECTED)
                .addVariant("iron_thermal", props, TBS)
                .addVariant("iron_125", props)
                .addVariant("iron_bordered", props, CONNECTED)
                .addVariant("iron_brick", props, TBS)
                .addVariant("iron_coin_heads", props, TBS)
                .addVariant("iron_coin_tails", props, TBS)
                .addVariant("iron_crate_dark", props, TBS)
                .addVariant("iron_crate_light", props, TBS)
                .addVariant("iron_gears", props, TBS)
                .addVariant("iron_ingots_large", props, TBS)
                .addVariant("iron_ingots_small", props, TBS)
                .addVariant("iron_moon", props, TBS)
                .addVariant("iron_moon_obsidian", props)
                .addVariant("iron_moon_obsidian_purple", props)
                .addVariant("iron_plates", props, TBS)
                .addVariant("iron_rivets", props, TBS)
                .addVariant("iron_shipping", props, CONNECTED)
                .addVariant("iron_simple", props, TBS)
                .addVariant("iron_vents", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("iron_bad_greggy"), "Block of Iron", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("iron_bolted"), "Block of Iron", "Fancy Bolted Plating");
        lang.addBlock(getVariant("iron_caution"), "Block of Iron", "Caution Stripes");
        lang.addBlock(getVariant("iron_crate"), "Block of Iron", "Shipping Crate");
        lang.addBlock(getVariant("iron_machine"), "Block of Iron", "Machine");
        lang.addBlock(getVariant("iron_scaffold"), "Block of Iron", "Scaffold");
        lang.addBlock(getVariant("iron_thermal"), "Block of Iron", "Thermal");
        lang.addBlock(getVariant("iron_125"), "Block of Iron", "125");
        lang.addBlock(getVariant("iron_bordered"), "Block of Iron", "Egregiously Bordered Block");
        lang.addBlock(getVariant("iron_brick"), "Block of Iron", "Iron Bricks");
        lang.addBlock(getVariant("iron_coin_heads"), "Block of Iron", "Iron Coin Stack Heads-up");
        lang.addBlock(getVariant("iron_coin_tails"), "Block of Iron", "Iron Coin Stack Heads-down");
        lang.addBlock(getVariant("iron_crate_dark"), "Block of Iron", "Dark Iron Crate");
        lang.addBlock(getVariant("iron_crate_light"), "Block of Iron", "Light Iron Crate");
        lang.addBlock(getVariant("iron_gears"), "Block of Iron", "Iron Gears");
        lang.addBlock(getVariant("iron_ingots_large"), "Block of Iron", "Large Iron Ingots");
        lang.addBlock(getVariant("iron_ingots_small"), "Block of Iron", "Small Iron Ingots");
        lang.addBlock(getVariant("iron_moon"), "Block of Iron", "Iron Block with Moon Decoration");
        lang.addBlock(getVariant("iron_moon_obsidian"), "Block of Iron", "Iron Moon in Obsidian");
        lang.addBlock(getVariant("iron_moon_obsidian_purple"), "Block of Iron", "Iron Moon in Purple Obsidian");
        lang.addBlock(getVariant("iron_plates"), "Block of Iron", "Iron Plates");
        lang.addBlock(getVariant("iron_rivets"), "Block of Iron", "Iron Plates with Rivets");
        lang.addBlock(getVariant("iron_shipping"), "Block of Iron", "Shipping Crate");
        lang.addBlock(getVariant("iron_simple"), "Block of Iron", "Simple Iron Block");
        lang.addBlock(getVariant("iron_vents"), "Block of Iron", "Iron Vents");
    }
}
