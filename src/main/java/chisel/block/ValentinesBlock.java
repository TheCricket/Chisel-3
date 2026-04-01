package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ValentinesBlock extends ChiselBlock {
    public ValentinesBlock(BlockBehaviour.Properties props) {
        family = builder("valentines")
                .addVariant("valentines_dots", props)
                .addVariant("valentines_flower", props)
                .addVariant("valentines_heart", props)
                .addVariant("valentines_ornate", props)
                .addVariant("valentines_panel", props)
                .addVariant("valentines_rose", props)
                .addVariant("valentines_tiles", props)
                .addVariant("valentines_wall", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("valentines_dots"), "Valentine's Block", "Dots");
        lang.addBlock(getVariant("valentines_flower"), "Valentine's Block", "Flower");
        lang.addBlock(getVariant("valentines_heart"), "Valentine's Block", "Heart");
        lang.addBlock(getVariant("valentines_ornate"), "Valentine's Block", "Ornate");
        lang.addBlock(getVariant("valentines_panel"), "Valentine's Block", "Panel");
        lang.addBlock(getVariant("valentines_rose"), "Valentine's Block", "Rose");
        lang.addBlock(getVariant("valentines_tiles"), "Valentine's Block", "Tiles");
        lang.addBlock(getVariant("valentines_wall"), "Valentine's Block", "Wall");
    }
}

