package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class HolystoneFamily extends ChiselBlock {
        public HolystoneFamily(BlockBehaviour.Properties props) {
            family = builder("holystone")
                    .addVariant("holystone_blocks", props)
                    .addVariant("holystone_blocks_rough", props)
                    .addVariant("holystone_bricks", props)
                    .addVariant("holystone_bricks_large", props)
                    .addVariant("holystone_chiseled", props, VariantModelType.TBS)
                    .addVariant("holystone_construction", props)
                    .addVariant("holystone_love", props)
                    .addVariant("holystone_plate", props)
                    .addVariant("holystone_plate_smooth", props)
                    .addVariant("holystone_platform", props, VariantModelType.TBS)
                    .addVariant("holystone_platform_tiles", props, VariantModelType.TBS)
                    .addVariant("holystone_raw", props)
                    .addVariant("holystone_smooth", props)
                    .addVariant("holystone_tiles", props)
                    .family();
        }

        @Override
        public void addTranslations(LangHelper lang) {
            lang.addBlock(getVariant("holystone_blocks"), "Holystone", "Holystone Blocks");
            lang.addBlock(getVariant("holystone_blocks_rough"), "Holystone", "Rough Holystone Blocks");
            lang.addBlock(getVariant("holystone_bricks"), "Holystone", "Holystone Bricks");
            lang.addBlock(getVariant("holystone_bricks_large"), "Holystone", "Large Holystone Bricks");
            lang.addBlock(getVariant("holystone_chiseled"), "Holystone", "Chiseled Holystone");
            lang.addBlock(getVariant("holystone_construction"), "Holystone", "Fancy Holystone Construction");
            lang.addBlock(getVariant("holystone_love"), "Holystone", "Mysterious Holystone Symbol");
            lang.addBlock(getVariant("holystone_plate"), "Holystone", "Holystone Plate");
            lang.addBlock(getVariant("holystone_plate_smooth"), "Holystone", "Smooth Holystone Plate");
            lang.addBlock(getVariant("holystone_platform"), "Holystone", "Holystone Platform");
            lang.addBlock(getVariant("holystone_platform_tiles"), "Holystone", "Holystone Platform Tiles");
            lang.addBlock(getVariant("holystone_raw"), "Holystone", "Holystone");
            lang.addBlock(getVariant("holystone_smooth"), "Holystone", "Smooth Holystone");
            lang.addBlock(getVariant("holystone_tiles"), "Holystone", "Fancy Holystone Tiles");
        }
    }