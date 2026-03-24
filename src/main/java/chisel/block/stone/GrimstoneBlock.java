package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class GrimstoneBlock extends ChiselBlock {
    public GrimstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("grimstone")
                .addVariant("grimstone_raw", props)
                .addVariant("grimstone_blocks", props)
                .addVariant("grimstone_blocks_rough", props)
                .addVariant("grimstone_bricks", props)
                .addVariant("grimstone_bricks_large", props)
                .addVariant("grimstone_chiseled", props)
                .addVariant("grimstone_construction", props)
                .addVariant("grimstone_flaky", props)
                .addVariant("grimstone_plate", props)
                .addVariant("grimstone_plate_smooth", props)
                .addVariant("grimstone_platform", props)
                .addVariant("grimstone_platform_tiles", props)
                .addVariant("grimstone_smooth", props)
                .addVariant("grimstone_symbol", props)
                .addVariant("grimstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("grimstone_raw"), "Grimstone", "Raw");
        lang.addBlock(getVariant("grimstone_blocks"), "Grimstone", "Blocks");
        lang.addBlock(getVariant("grimstone_blocks_rough"), "Grimstone", "Rough Blocks");
        lang.addBlock(getVariant("grimstone_bricks"), "Grimstone", "Bricks");
        lang.addBlock(getVariant("grimstone_bricks_large"), "Grimstone", "Large Bricks");
        lang.addBlock(getVariant("grimstone_chiseled"), "Grimstone", "Chiseled");
        lang.addBlock(getVariant("grimstone_construction"), "Grimstone", "Construction");
        lang.addBlock(getVariant("grimstone_flaky"), "Grimstone", "Flaky");
        lang.addBlock(getVariant("grimstone_plate"), "Grimstone", "Plate");
        lang.addBlock(getVariant("grimstone_plate_smooth"), "Grimstone", "Smooth Plate");
        lang.addBlock(getVariant("grimstone_platform"), "Grimstone", "Platform");
        lang.addBlock(getVariant("grimstone_platform_tiles"), "Grimstone", "Platform Tiles");
        lang.addBlock(getVariant("grimstone_smooth"), "Grimstone", "Smooth");
        lang.addBlock(getVariant("grimstone_symbol"), "Grimstone", "Symbol");
        lang.addBlock(getVariant("grimstone_tiles"), "Grimstone", "Tiles");
    }
}

