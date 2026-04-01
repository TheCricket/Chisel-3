package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LapisBlock extends ChiselBlock {
    public LapisBlock(BlockBehaviour.Properties props) {
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
        lang.addBlock(getVariant("lapis_chunky"), "Lapis Lazuli Block", "Chunky");
        lang.addBlock(getVariant("lapis_dark"), "Lapis Lazuli Block", "Dark");
        lang.addBlock(getVariant("lapis_masonry"), "Lapis Lazuli Block", "Masonry");
        lang.addBlock(getVariant("lapis_ornate"), "Lapis Lazuli Block", "Ornate");
        lang.addBlock(getVariant("lapis_ornate_layer"), "Lapis Lazuli Block", "Ornate Layer");
        lang.addBlock(getVariant("lapis_panel"), "Lapis Lazuli Block", "Panel");
        lang.addBlock(getVariant("lapis_smooth"), "Lapis Lazuli Block", "Smooth");
        lang.addBlock(getVariant("lapis_tile"), "Lapis Lazuli Block", "Tile");
        lang.addBlock(getVariant("lapis_zelda"), "Lapis Lazuli Block", "Zelda");
    }
}

