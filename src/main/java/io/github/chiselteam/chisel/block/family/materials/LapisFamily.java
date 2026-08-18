package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LapisFamily extends ChiselFamily {
    public LapisFamily(BlockBehaviour.Properties props) {
        family = builder("lapis")
                .addVariant(Blocks.LAPIS_BLOCK)
                .addVariant("lapis_chunky", props)
                .addVariant("lapis_dark", props)
                .addVariant("lapis_masonry", props)
                .addVariant("lapis_ornate", props)
                .addVariant("lapis_ornate_layer", props)
                .addVariant("lapis_panel", props)
                .addVariant("lapis_smooth", props)
                .addVariant("lapis_tile", props)
                .addVariant("lapis_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lapis_chunky"), "Block of Lapis Lazuli", "Chunky Lapis Block");
        lang.addBlock(getVariant("lapis_dark"), "Block of Lapis Lazuli", "Dark Lapis Block");
        lang.addBlock(getVariant("lapis_masonry"), "Block of Lapis Lazuli", "Masonry");
        lang.addBlock(getVariant("lapis_ornate"), "Block of Lapis Lazuli", "Ornate Lapis Block");
        lang.addBlock(getVariant("lapis_ornate_layer"), "Block of Lapis Lazuli", "Lapis with Ornate Layer");
        lang.addBlock(getVariant("lapis_panel"), "Block of Lapis Lazuli", "Lapis Panel");
        lang.addBlock(getVariant("lapis_smooth"), "Block of Lapis Lazuli", "Smooth Lapis");
        lang.addBlock(getVariant("lapis_tile"), "Block of Lapis Lazuli", "Lapis Tile");
        lang.addBlock(getVariant("lapis_zelda"), "Block of Lapis Lazuli", "Zelda Lapis Block");
    }
}

