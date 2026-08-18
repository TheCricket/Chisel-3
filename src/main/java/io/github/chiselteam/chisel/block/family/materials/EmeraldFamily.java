package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
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
        lang.addBlock(getVariant("emerald_bismuth"), "Block of Emerald", "Emerald Bismuth");
        lang.addBlock(getVariant("emerald_blocks_small"), "Block of Emerald", "Small Emerald Blocks");
        lang.addBlock(getVariant("emerald_blocks_small_ornate"), "Block of Emerald", "Small Ornate Emerald Blocks");
        lang.addBlock(getVariant("emerald_cell"), "Block of Emerald", "Emerald Cell");
        lang.addBlock(getVariant("emerald_chunk"), "Block of Emerald", "Emerald Chunk");
        lang.addBlock(getVariant("emerald_circle"), "Block of Emerald", "Circle");
        lang.addBlock(getVariant("emerald_masonry"), "Block of Emerald", "Masonry");
        lang.addBlock(getVariant("emerald_ornate"), "Block of Emerald", "Ornate Emerald Block");
        lang.addBlock(getVariant("emerald_ornate_layer"), "Block of Emerald", "Emerald with Ornate Layer");
        lang.addBlock(getVariant("emerald_panel"), "Block of Emerald", "Emerald Panel");
        lang.addBlock(getVariant("emerald_panel_classic"), "Block of Emerald", "Classic emerald Panel");
        lang.addBlock(getVariant("emerald_prismatic"), "Block of Emerald", "Prismatic");
        lang.addBlock(getVariant("emerald_smooth"), "Block of Emerald", "Smooth Emerald");
        lang.addBlock(getVariant("emerald_zelda"), "Block of Emerald", "Zelda Emerald Block");
    }
}