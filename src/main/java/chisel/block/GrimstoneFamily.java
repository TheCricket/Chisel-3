package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GrimstoneFamily extends ChiselBlock {
    public GrimstoneFamily(BlockBehaviour.Properties props) {
        family = builder("grimstone")
                .addVariant("grimstone_blocks", props)
                .addVariant("grimstone_blocks_rough", props)
                .addVariant("grimstone_bricks", props)
                .addVariant("grimstone_bricks_large", props)
                .addVariant("grimstone_chiseled", props, VariantModelType.TBS)
                .addVariant("grimstone_chunks", props)
                .addVariant("grimstone_construction", props)
                .addVariant("grimstone_flaky", props)
                .addVariant("grimstone_hate", props)
                .addVariant("grimstone_plate", props)
                .addVariant("grimstone_plate_smooth", props)
                .addVariant("grimstone_platform", props, VariantModelType.TBS)
                .addVariant("grimstone_platform_tiles", props, VariantModelType.TBS)
                .addVariant("grimstone_raw", props)
                .addVariant("grimstone_smooth", props)
                .addVariant("grimstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("grimstone_blocks"), "Grimstone", "Grimstone Blocks");
        lang.addBlock(getVariant("grimstone_blocks_rough"), "Grimstone", "Rough Grimstone Blocks");
        lang.addBlock(getVariant("grimstone_bricks"), "Grimstone", "Grimstone Bricks");
        lang.addBlock(getVariant("grimstone_bricks_large"), "Grimstone", "Large Grimstone Bricks");
        lang.addBlock(getVariant("grimstone_chiseled"), "Grimstone", "Chiseled Grimstone");
        lang.addBlock(getVariant("grimstone_chunks"), "Grimstone", "Grimstone");
        lang.addBlock(getVariant("grimstone_construction"), "Grimstone", "Fancy Grimstone Construction");
        lang.addBlock(getVariant("grimstone_flaky"), "Grimstone", "Flaky Grimstone");
        lang.addBlock(getVariant("grimstone_hate"), "Grimstone", "Mysterious Grimstone Symbol");
        lang.addBlock(getVariant("grimstone_plate"), "Grimstone", "Grimstone Plate");
        lang.addBlock(getVariant("grimstone_plate_smooth"), "Grimstone", "Smooth Grimstone Plate");
        lang.addBlock(getVariant("grimstone_platform"), "Grimstone", "Grimstone Platform");
        lang.addBlock(getVariant("grimstone_platform_tiles"), "Grimstone", "Grimstone Platform Tiles");
        lang.addBlock(getVariant("grimstone_raw"), "Grimstone", "Grimstone");
        lang.addBlock(getVariant("grimstone_smooth"), "Grimstone", "Smooth Grimstone");
        lang.addBlock(getVariant("grimstone_tiles"), "Grimstone", "Fancy Grimstone Tiles");
    }
}

