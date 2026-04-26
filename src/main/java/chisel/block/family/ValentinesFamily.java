package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ValentinesFamily extends ChiselFamily {
    public ValentinesFamily(BlockBehaviour.Properties props) {
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
        lang.addBlock(getVariant("valentines_block"), "Valentine's Block", "Pink Chunk");
        lang.addBlock(getVariant("valentines_bricks"), "Valentine's Block", "Valentines Bricks");
        lang.addBlock(getVariant("valentines_bumpy"), "Valentine's Block", "Pink Dotted");
        lang.addBlock(getVariant("valentines_cobble"), "Valentine's Block", "Pink Cobble");
        lang.addBlock(getVariant("valentines_companion"), "Valentine's Block", "If it speaks, I wouldn't touch it");
        lang.addBlock(getVariant("valentines_empty"), "Valentine's Block", "Pink Panel");
        lang.addBlock(getVariant("valentines_fire"), "Valentine's Block", "There's a flame in my heart");
        lang.addBlock(getVariant("valentines_heart"), "Valentine's Block", "Pink Heart in stone");
        lang.addBlock(getVariant("valentines_heart_gray"), "Valentine's Block", "Heart in stone");
        lang.addBlock(getVariant("valentines_tile"), "Valentine's Block", "Pink Tinted Heart in stone");
    }
}

