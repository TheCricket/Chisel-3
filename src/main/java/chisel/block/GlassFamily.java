package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlassFamily extends ChiselBlock {
    public GlassFamily(BlockBehaviour.Properties props) {
        family = builder("glass")
                .addVariant(Blocks.GLASS)
                .addVariant("glass_borderless", props, VariantModelType.CONNECTED)
                .addVariant("glass_bubble", props, VariantModelType.CONNECTED)
                .addVariant("glass_chinese", props)
                .addVariant("glass_chinese_2", props)
                .addVariant("glass_chrono", props, VariantModelType.CONNECTED)
                .addVariant("glass_dungeon", props)
                .addVariant("glass_edge", props)
                .addVariant("glass_edge_steel", props)
                .addVariant("glass_fence", props)
                .addVariant("glass_grid_thick", props)
                .addVariant("glass_grid_thin", props)
                .addVariant("glass_japanese", props)
                .addVariant("glass_japanese_2", props)
                .addVariant("glass_light", props, VariantModelType.CONNECTED)
                .addVariant("glass_ornate", props, VariantModelType.CONNECTED)
                .addVariant("glass_ornate_old", props)
                .addVariant("glass_screen", props)
                .addVariant("glass_shale", props, VariantModelType.CONNECTED)
                .addVariant("glass_steel", props, VariantModelType.CONNECTED)
                .addVariant("glass_stone", props, VariantModelType.CONNECTED)
                .addVariant("glass_streak", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glass_borderless"), "Glass", "Borderless Glass");
        lang.addBlock(getVariant("glass_bubble"), "Glass", "Bubble Glass");
        lang.addBlock(getVariant("glass_chinese"), "Glass", "Chinese Glass");
        lang.addBlock(getVariant("glass_chinese_2"), "Glass", "Chinese Glass");
        lang.addBlock(getVariant("glass_chrono"), "Glass", "Chrono");
        lang.addBlock(getVariant("glass_dungeon"), "Glass", "Dungeon Glass");
        lang.addBlock(getVariant("glass_edge"), "Glass", "Edge");
        lang.addBlock(getVariant("glass_edge_steel"), "Glass", "Steel Edge");
        lang.addBlock(getVariant("glass_fence"), "Glass", "Modern Iron Fence");
        lang.addBlock(getVariant("glass_grid_thick"), "Glass", "Thick Grid Glass");
        lang.addBlock(getVariant("glass_grid_thin"), "Glass", "Thin Grid Glass");
        lang.addBlock(getVariant("glass_japanese"), "Glass", "Japanese Glass");
        lang.addBlock(getVariant("glass_japanese_2"), "Glass", "Japanese Glass");
        lang.addBlock(getVariant("glass_light"), "Glass", "Light Glass");
        lang.addBlock(getVariant("glass_ornate"), "Glass", "Ornate Steel Glass");
        lang.addBlock(getVariant("glass_ornate_old"), "Glass", "Old Ornate");
        lang.addBlock(getVariant("glass_screen"), "Glass", "Screen");
        lang.addBlock(getVariant("glass_shale"), "Glass", "Shale Glass");
        lang.addBlock(getVariant("glass_steel"), "Glass", "Steel Frame Glass");
        lang.addBlock(getVariant("glass_stone"), "Glass", "Stone Frame Glass");
        lang.addBlock(getVariant("glass_streak"), "Glass", "Streak Glass");
    }
}

