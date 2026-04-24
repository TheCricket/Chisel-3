package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.util.LangHelper;
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
        lang.addBlock(getVariant("lapis_chunky"), "Lapis Block", "Chunky Lapis Block");
        lang.addBlock(getVariant("lapis_dark"), "Lapis Block", "Dark Lapis Block");
        lang.addBlock(getVariant("lapis_masonry"), "Lapis Block", "Masonry");
        lang.addBlock(getVariant("lapis_ornate"), "Lapis Block", "Ornate Lapis Block");
        lang.addBlock(getVariant("lapis_ornate_layer"), "Lapis Block", "Lapis with Ornate Layer");
        lang.addBlock(getVariant("lapis_panel"), "Lapis Block", "Lapis Panel");
        lang.addBlock(getVariant("lapis_smooth"), "Lapis Block", "Smooth Lapis");
        lang.addBlock(getVariant("lapis_tile"), "Lapis Block", "Lapis Tile");
        lang.addBlock(getVariant("lapis_zelda"), "Lapis Block", "Zelda Lapis Block");
    }
}

