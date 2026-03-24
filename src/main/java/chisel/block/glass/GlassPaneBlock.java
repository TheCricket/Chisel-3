package chisel.block.glass;

import chisel.Chisel;
import chisel.block.ChiselBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class GlassPaneBlock extends ChiselBlock {
    public GlassPaneBlock(BlockBehaviour.Properties props) {
        

        family = builder("glass_pane")
                .addVariant(Blocks.GLASS_PANE)
                .addVariant("glass_pane_borderless", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_borderless")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_bubble", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_bubble")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_chinese", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_chinese_gold", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese_gold")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_japanese_tiles", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese_tiles")))), () -> props, VariantModelType.GLASS_PANE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glass_pane_borderless"), "Glass Pane", "Borderless");
        lang.addBlock(getVariant("glass_pane_bubble"), "Glass Pane", "Bubble");
        lang.addBlock(getVariant("glass_pane_chinese"), "Glass Pane", "Chinese");
        lang.addBlock(getVariant("glass_pane_chinese_gold"), "Glass Pane", "Chinese Gold");
        lang.addBlock(getVariant("glass_pane_japanese_tiles"), "Glass Pane", "Japanese Tiles");
    }
}

