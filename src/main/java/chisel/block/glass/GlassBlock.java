package chisel.block.glass;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class GlassBlock extends ChiselBlock {
    public GlassBlock(BlockBehaviour.Properties props) {
        

        family = builder("glass")
                .addVariant(Blocks.GLASS)
                .addVariant("glass_borderless", props)
                .addVariant("glass_bubble", props)
                .addVariant("glass_chinese", props)
                .addVariant("glass_chinese_2", props)
                .addVariant("glass_chrono", props)
                .addVariant("glass_dungeon", props)
                .addVariant("glass_edge", props)
                .addVariant("glass_edge_steel", props)
                .addVariant("glass_fence", props)
                .addVariant("glass_grid_thick", props)
                .addVariant("glass_grid_thin", props)
                .addVariant("glass_japanese", props)
                .addVariant("glass_japanese_2", props)
                .addVariant("glass_light", props)
                .addVariant("glass_ornate", props)
                .addVariant("glass_ornate_old", props)
                .addVariant("glass_screen", props)
                .addVariant("glass_shale", props)
                .addVariant("glass_steel", props)
                .addVariant("glass_stone", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glass_borderless"), "Glass", "Borderless");
        lang.addBlock(getVariant("glass_bubble"), "Glass", "Bubble");
        lang.addBlock(getVariant("glass_chinese"), "Glass", "Chinese");
        lang.addBlock(getVariant("glass_chinese_2"), "Glass", "Chinese 2");
        lang.addBlock(getVariant("glass_chrono"), "Glass", "Chrono");
        lang.addBlock(getVariant("glass_dungeon"), "Glass", "Dungeon");
        lang.addBlock(getVariant("glass_edge"), "Glass", "Edge");
        lang.addBlock(getVariant("glass_edge_steel"), "Glass", "Steel Edge");
        lang.addBlock(getVariant("glass_fence"), "Glass", "Fence");
        lang.addBlock(getVariant("glass_grid_thick"), "Glass", "Thick Grid");
        lang.addBlock(getVariant("glass_grid_thin"), "Glass", "Thin Grid");
        lang.addBlock(getVariant("glass_japanese"), "Glass", "Japanese");
        lang.addBlock(getVariant("glass_japanese_2"), "Glass", "Japanese 2");
        lang.addBlock(getVariant("glass_light"), "Glass", "Light");
        lang.addBlock(getVariant("glass_ornate"), "Glass", "Ornate");
        lang.addBlock(getVariant("glass_ornate_old"), "Glass", "Old Ornate");
        lang.addBlock(getVariant("glass_screen"), "Glass", "Screen");
        lang.addBlock(getVariant("glass_shale"), "Glass", "Shale");
        lang.addBlock(getVariant("glass_steel"), "Glass", "Steel");
        lang.addBlock(getVariant("glass_stone"), "Glass", "Stone");
    }
}

