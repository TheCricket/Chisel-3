package chisel.block.family;

import chisel.Chisel;
import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlassPaneFamily extends ChiselFamily {
    public GlassPaneFamily(BlockBehaviour.Properties props) {
        family = builder("glass_pane")
                .addVariant(Blocks.GLASS_PANE)
                .addVariant("glass_pane_borderless", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_borderless")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_bubble", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_bubble")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_chinese", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_chinese_gold", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese_gold")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_japanese", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_japanese2", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese2")))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("glass_pane_streak", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_streak")))), () -> props, VariantModelType.GLASS_PANE)
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

