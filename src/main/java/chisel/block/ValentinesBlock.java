package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ValentinesBlock extends ChiselBlock {
    public ValentinesBlock(BlockBehaviour.Properties props) {
        family = builder("valentines")
                .addVariant("valentines_block", props)
                .addVariant("valentines_bricks", props)
                .addVariant("valentines_bumpy", props)
                .addVariant("valentines_cobble", props)
                .addVariant("valentines_companion", props)
                .addVariant("valentines_empty", props)
                .addVariant("valentines_fire", props)
                .addVariant("valentines_heart", props)
                .addVariant("valentines_heart_gray", props)
                .addVariant("valentines_tile", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("valentines_block"), "Valentine's Block", "Block");
        lang.addBlock(getVariant("valentines_bricks"), "Valentine's Block", "Bricks");
        lang.addBlock(getVariant("valentines_bumpy"), "Valentine's Block", "Bumpy");
        lang.addBlock(getVariant("valentines_cobble"), "Valentine's Block", "Cobble");
        lang.addBlock(getVariant("valentines_companion"), "Valentine's Block", "Companion");
        lang.addBlock(getVariant("valentines_empty"), "Valentine's Block", "Empty");
        lang.addBlock(getVariant("valentines_fire"), "Valentine's Block", "Fire");
        lang.addBlock(getVariant("valentines_heart"), "Valentine's Block", "Heart");
        lang.addBlock(getVariant("valentines_heart_gray"), "Valentine's Block", "Heart Gray");
        lang.addBlock(getVariant("valentines_tile"), "Valentine's Block", "Tile");
    }
}

