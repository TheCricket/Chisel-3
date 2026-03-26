package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DirtBlock extends ChiselBlock {
    public DirtBlock(BlockBehaviour.Properties props) {
        

        family = builder("dirt")
                .addVariant(Blocks.DIRT)
                .addVariant("dirt_braid", props)
                .addVariant("dirt_chaotic", props)
                .addVariant("dirt_circular", props)
                .addVariant("dirt_cuts", props)
                .addVariant("dirt_dent", props)
                .addVariant("dirt_french", props)
                .addVariant("dirt_french_2", props)
                .addVariant("dirt_layers", props)
                .addVariant("dirt_bricks_arranged", props)
                .addVariant("dirt_chunky", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("dirt_braid"), "Dirt", "Braid");
        lang.addBlock(getVariant("dirt_chaotic"), "Dirt", "Chaotic");
        lang.addBlock(getVariant("dirt_circular"), "Dirt", "Circular");
        lang.addBlock(getVariant("dirt_cuts"), "Dirt", "Cuts");
        lang.addBlock(getVariant("dirt_dent"), "Dirt", "Dent");
        lang.addBlock(getVariant("dirt_french"), "Dirt", "French");
        lang.addBlock(getVariant("dirt_french_2"), "Dirt", "French 2");
        lang.addBlock(getVariant("dirt_layers"), "Dirt", "Layers");
        lang.addBlock(getVariant("dirt_bricks_arranged"), "Dirt", "Arranged Bricks");
        lang.addBlock(getVariant("dirt_chunky"), "Dirt", "Chunky");
    }
}

