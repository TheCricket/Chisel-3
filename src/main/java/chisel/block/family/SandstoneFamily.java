package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SandstoneFamily extends ChiselFamily {
    public SandstoneFamily(BlockBehaviour.Properties props) {
        family = builder("sandstone")
                .addVariant(Blocks.SANDSTONE)
                .addVariant("sandstone_base", props, VariantModelType.TBS)
                .addVariant("sandstone_block", props)
                .addVariant("sandstone_blocks", props)
                .addVariant("sandstone_brick_flat", props, VariantModelType.TBS)
                .addVariant("sandstone_capstone", props, VariantModelType.TBS)
                .addVariant("sandstone_cobble_solid", props, VariantModelType.TBS)
                .addVariant("sandstone_column", props, VariantModelType.TBS)
                .addVariant("sandstone_creeper", props, VariantModelType.TBS)
                .addVariant("sandstone_faded", props, VariantModelType.TBS)
                .addVariant("sandstone_horizontal_tiles", props, VariantModelType.TBS)
                .addVariant("sandstone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("sandstone_scribbles_0", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_1", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_2", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_3", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_4", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_5", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_6", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_7", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_8", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_9", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_10", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_11", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_12", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_13", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_14", props, VariantModelType.TBS)
                .addVariant("sandstone_scribbles_15", props, VariantModelType.TBS)
                .addVariant("sandstone_small", props, VariantModelType.TBS)
                .addVariant("sandstone_smooth", props)
                .addVariant("sandstone_smooth_base", props, VariantModelType.TBS)
                .addVariant("sandstone_smooth_cap", props, VariantModelType.TBS)
                .addVariant("sandstone_smooth_flat", props, VariantModelType.TBS)
                .addVariant("sandstone_smooth_glyph", props, VariantModelType.TBS)
                .addVariant("sandstone_smooth_small", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sandstone_base"), "Sandstone", "Stacked Sandstone Tiles");
        lang.addBlock(getVariant("sandstone_block"), "Sandstone", "Sandstone Block");
        lang.addBlock(getVariant("sandstone_blocks"), "Sandstone", "Small Sandstone Blocks");
        lang.addBlock(getVariant("sandstone_brick_flat"), "Sandstone", "Flat Brick");
        lang.addBlock(getVariant("sandstone_capstone"), "Sandstone", "Sandstone Pillar Capstone");
        lang.addBlock(getVariant("sandstone_cobble_solid"), "Sandstone", "Sandcobble");
        lang.addBlock(getVariant("sandstone_column"), "Sandstone", "Sandstone Pillar");
        lang.addBlock(getVariant("sandstone_creeper"), "Sandstone", "Sandstone Creeper");
        lang.addBlock(getVariant("sandstone_faded"), "Sandstone", "Faded Sandstone");
        lang.addBlock(getVariant("sandstone_horizontal_tiles"), "Sandstone", "Horizontal Tiles");
        lang.addBlock(getVariant("sandstone_mosaic"), "Sandstone", "Sandstone Mosaic");
        for (int i = 0; i <= 15; i++) {
            lang.addBlock(getVariant("sandstone_scribbles_" + i), "Sandstone", "Sandstone Scribbles");
        }
        lang.addBlock(getVariant("sandstone_small"), "Sandstone", "Small Sandstone Pillar");
        lang.addBlock(getVariant("sandstone_smooth"), "Sandstone", "Smooth");
        lang.addBlock(getVariant("sandstone_smooth_base"), "Sandstone", "Smooth Sandstone Pillar Base");
        lang.addBlock(getVariant("sandstone_smooth_cap"), "Sandstone", "Smooth Sandstone Pillar Capstone");
        lang.addBlock(getVariant("sandstone_smooth_flat"), "Sandstone", "Smooth & Flat Sandstone");
        lang.addBlock(getVariant("sandstone_smooth_glyph"), "Sandstone", "Sandstone Glyphs");
        lang.addBlock(getVariant("sandstone_smooth_small"), "Sandstone", "Small Smooth Sandstone Pillar");
    }
}

