package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ChiselIronBarsBlock;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.GLASS_PANE;

public class GlassPaneFamily extends ChiselFamily {
    public GlassPaneFamily(BlockBehaviour.Properties props) {
        family = builder("glass_pane")
                .addVariant(Blocks.GLASS_PANE)
                .addVariant("glass_pane_borderless", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_borderless")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_bubble", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_bubble")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_chinese", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_chinese_gold", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese_gold")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_japanese", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_japanese2", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese2")))), () -> props, GLASS_PANE)
                .addVariant("glass_pane_streak", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_streak")))), () -> props, GLASS_PANE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glass_pane_borderless"), "Glass Pane", "Borderless Glass Pane");
        lang.addBlock(getVariant("glass_pane_bubble"), "Glass Pane", "Bubble Glass Pane");
        lang.addBlock(getVariant("glass_pane_chinese"), "Glass Pane", "Chinese Glass Pane");
        lang.addBlock(getVariant("glass_pane_chinese_gold"), "Glass Pane", "Chinese Glass Pane with Golden Frame");
        lang.addBlock(getVariant("glass_pane_japanese"), "Glass Pane", "Japanese Glass Pane");
        lang.addBlock(getVariant("glass_pane_japanese2"), "Glass Pane", "Ornate Japanese Glass Pane");
        lang.addBlock(getVariant("glass_pane_streak"), "Glass Pane", "Streak Glass Pane");
    }
}

