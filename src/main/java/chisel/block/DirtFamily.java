package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DirtFamily extends ChiselBlock {
    public DirtFamily(BlockBehaviour.Properties props) {
        family = builder("dirt")
                .addVariant(Blocks.DIRT)
                .addVariant("dirt_bricks", props, VariantModelType.CTMV)
                .addVariant("dirt_bricks_arranged", props)
                .addVariant("dirt_bricks_disarray", props)
                .addVariant("dirt_bricks_large", props)
                .addVariant("dirt_chunky", props)
                .addVariant("dirt_cobble", props)
                .addVariant("dirt_happy", props)
                .addVariant("dirt_horizontal", props, VariantModelType.CTMH)
                .addVariant("dirt_layers", props)
                .addVariant("dirt_netherbricks", props)
                .addVariant("dirt_plate", props)
                .addVariant("dirt_reinforced", props, VariantModelType.CONNECTED)
                .addVariant("dirt_reinforced_cobble", props, VariantModelType.CONNECTED)
                .addVariant("dirt_vert", props, VariantModelType.CTMV)
                .addVariant("dirt_vertical", props, VariantModelType.CTMV)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("dirt_bricks"), "Dirt", "Dirt Bricks");
        lang.addBlock(getVariant("dirt_bricks_arranged"), "Dirt", "Dirt Bricks");
        lang.addBlock(getVariant("dirt_bricks_disarray"), "Dirt", "Dirt Bricks in Disarray");
        lang.addBlock(getVariant("dirt_bricks_large"), "Dirt", "Large Dirt Bricks");
        lang.addBlock(getVariant("dirt_chunky"), "Dirt", "Crumbling Dirt");
        lang.addBlock(getVariant("dirt_cobble"), "Dirt", "Cobble-Dirt");
        lang.addBlock(getVariant("dirt_happy"), "Dirt", "Happy Dirt");
        lang.addBlock(getVariant("dirt_horizontal"), "Dirt", "Horizontal Dirt");
        lang.addBlock(getVariant("dirt_layers"), "Dirt", "Dirt Layers");
        lang.addBlock(getVariant("dirt_netherbricks"), "Dirt", "Dirt Bricks Imitating Nether Brick Design");
        lang.addBlock(getVariant("dirt_plate"), "Dirt", "Farmland");
        lang.addBlock(getVariant("dirt_reinforced"), "Dirt", "Reinforced Dirt");
        lang.addBlock(getVariant("dirt_reinforced_cobble"), "Dirt", "Reinforced Cobble-Dirt");
        lang.addBlock(getVariant("dirt_vert"), "Dirt", "Vertical Dirt");
        lang.addBlock(getVariant("dirt_vertical"), "Dirt", "Vertical Dirt");
    }
}

