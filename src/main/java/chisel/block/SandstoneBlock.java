package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SandstoneBlock extends ChiselBlock {
    public SandstoneBlock(BlockBehaviour.Properties props) {
        family = builder("sandstone")
                .addVariant(Blocks.SANDSTONE)
                .addVariant("sandstone_base", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_block", props)
                .addVariant("sandstone_blocks", props)
                .addVariant("sandstone_brick_flat", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_capstone", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_cobble_solid", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_column", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_creeper", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_faded", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_horizontal_tiles", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("sandstone_scribbles_0", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_1", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_2", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_3", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_4", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_5", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_6", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_7", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_8", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_9", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_10", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_11", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_12", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_13", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_14", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_scribbles_15", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_small", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_smooth", props)
                .addVariant("sandstone_smooth_base", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_smooth_cap", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_smooth_flat", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_smooth_glyph", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_smooth_small", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sandstone_base"), "Sandstone", "Base");
        lang.addBlock(getVariant("sandstone_block"), "Sandstone", "Block");
        lang.addBlock(getVariant("sandstone_blocks"), "Sandstone", "Blocks");
        lang.addBlock(getVariant("sandstone_brick_flat"), "Sandstone", "Flat Brick");
        lang.addBlock(getVariant("sandstone_capstone"), "Sandstone", "Capstone");
        lang.addBlock(getVariant("sandstone_cobble_solid"), "Sandstone", "Solid Cobble");
        lang.addBlock(getVariant("sandstone_column"), "Sandstone", "Column");
        lang.addBlock(getVariant("sandstone_creeper"), "Sandstone", "Creeper");
        lang.addBlock(getVariant("sandstone_faded"), "Sandstone", "Faded");
        lang.addBlock(getVariant("sandstone_horizontal_tiles"), "Sandstone", "Horizontal Tiles");
        lang.addBlock(getVariant("sandstone_mosaic"), "Sandstone", "Mosaic");
        lang.addBlock(getVariant("sandstone_scribbles_0"), "Sandstone", "Scribbles 0");
        lang.addBlock(getVariant("sandstone_scribbles_1"), "Sandstone", "Scribbles 1");
        lang.addBlock(getVariant("sandstone_scribbles_2"), "Sandstone", "Scribbles 2");
        lang.addBlock(getVariant("sandstone_scribbles_3"), "Sandstone", "Scribbles 3");
        lang.addBlock(getVariant("sandstone_scribbles_4"), "Sandstone", "Scribbles 4");
        lang.addBlock(getVariant("sandstone_scribbles_5"), "Sandstone", "Scribbles 5");
        lang.addBlock(getVariant("sandstone_scribbles_6"), "Sandstone", "Scribbles 6");
        lang.addBlock(getVariant("sandstone_scribbles_7"), "Sandstone", "Scribbles 7");
        lang.addBlock(getVariant("sandstone_scribbles_8"), "Sandstone", "Scribbles 8");
        lang.addBlock(getVariant("sandstone_scribbles_9"), "Sandstone", "Scribbles 9");
        lang.addBlock(getVariant("sandstone_scribbles_10"), "Sandstone", "Scribbles 10");
        lang.addBlock(getVariant("sandstone_scribbles_11"), "Sandstone", "Scribbles 11");
        lang.addBlock(getVariant("sandstone_scribbles_12"), "Sandstone", "Scribbles 12");
        lang.addBlock(getVariant("sandstone_scribbles_13"), "Sandstone", "Scribbles 13");
        lang.addBlock(getVariant("sandstone_scribbles_14"), "Sandstone", "Scribbles 14");
        lang.addBlock(getVariant("sandstone_scribbles_15"), "Sandstone", "Scribbles 15");
        lang.addBlock(getVariant("sandstone_small"), "Sandstone", "Small");
        lang.addBlock(getVariant("sandstone_smooth"), "Sandstone", "Smooth");
        lang.addBlock(getVariant("sandstone_smooth_base"), "Sandstone", "Smooth Base");
        lang.addBlock(getVariant("sandstone_smooth_cap"), "Sandstone", "Smooth Cap");
        lang.addBlock(getVariant("sandstone_smooth_flat"), "Sandstone", "Smooth Flat");
        lang.addBlock(getVariant("sandstone_smooth_glyph"), "Sandstone", "Smooth Glyph");
        lang.addBlock(getVariant("sandstone_smooth_small"), "Sandstone", "Smooth Small");
    }
}

