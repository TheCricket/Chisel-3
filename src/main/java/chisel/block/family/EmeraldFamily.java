package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EmeraldFamily extends ChiselFamily {
    public EmeraldFamily(BlockBehaviour.Properties props) {
        family = builder("emerald")
                .addVariant(Blocks.EMERALD_BLOCK)
                .addVariant("emerald_bismuth", props)
                .addVariant("emerald_blocks_small", props)
                .addVariant("emerald_blocks_small_ornate", props)
                .addVariant("emerald_cell", props)
                .addVariant("emerald_chunk", props)
                .addVariant("emerald_circle", props)
                .addVariant("emerald_masonry", props)
                .addVariant("emerald_ornate", props)
                .addVariant("emerald_ornate_layer", props)
                .addVariant("emerald_panel", props)
                .addVariant("emerald_panel_classic", props)
                .addVariant("emerald_prismatic", props)
                .addVariant("emerald_smooth", props)
                .addVariant("emerald_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("emerald_bismuth"), "Emerald Block", "Emerald Bismuth");
        lang.addBlock(getVariant("emerald_blocks_small"), "Emerald Block", "Small Emerald Blocks");
        lang.addBlock(getVariant("emerald_blocks_small_ornate"), "Emerald Block", "Small Ornate Emerald Blocks");
        lang.addBlock(getVariant("emerald_cell"), "Emerald Block", "Emerald Cell");
        lang.addBlock(getVariant("emerald_chunk"), "Emerald Block", "Emerald Chunk");
        lang.addBlock(getVariant("emerald_circle"), "Emerald Block", "Circle");
        lang.addBlock(getVariant("emerald_masonry"), "Emerald Block", "Masonry");
        lang.addBlock(getVariant("emerald_ornate"), "Emerald Block", "Ornate Emerald Block");
        lang.addBlock(getVariant("emerald_ornate_layer"), "Emerald Block", "Emerald with Ornate Layer");
        lang.addBlock(getVariant("emerald_panel"), "Emerald Block", "Emerald Panel");
        lang.addBlock(getVariant("emerald_panel_classic"), "Emerald Block", "Classic emerald Panel");
        lang.addBlock(getVariant("emerald_prismatic"), "Emerald Block", "Prismatic");
        lang.addBlock(getVariant("emerald_smooth"), "Emerald Block", "Smooth Emerald");
        lang.addBlock(getVariant("emerald_zelda"), "Emerald Block", "Zelda Emerald Block");
    }
}