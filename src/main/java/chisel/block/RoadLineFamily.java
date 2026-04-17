package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.block.util.RoadlineBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RoadLineFamily extends ChiselBlock {
    public RoadLineFamily(BlockBehaviour.Properties props) {
        family = builder("road_line")
                .addVariant("road_line_double_white_center", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_double_white_long", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_double_white_side", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_double_yellow_center", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_double_yellow_long", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_double_yellow_side", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_white_center", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_white_long", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_white_side", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_yellow_center", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_yellow_long", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .addVariant("road_line_yellow_side", RoadlineBlock::new, () -> props, VariantModelType.ROAD_LINES)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("road_line_double_white_center"), "Road Lines", "Double White");
        lang.addBlock(getVariant("road_line_double_white_long"), "Road Lines", "Double White");
        lang.addBlock(getVariant("road_line_double_white_side"), "Road Lines", "Double White");
        lang.addBlock(getVariant("road_line_double_yellow_center"), "Road Lines", "Double Yellow");
        lang.addBlock(getVariant("road_line_double_yellow_long"), "Road Lines", "Double Yellow");
        lang.addBlock(getVariant("road_line_double_yellow_side"), "Road Lines", "Double Yellow");
        lang.addBlock(getVariant("road_line_white_center"), "Road Lines", "White");
        lang.addBlock(getVariant("road_line_white_long"), "Road Lines", "White");
        lang.addBlock(getVariant("road_line_white_side"), "Road Lines", "White");
        lang.addBlock(getVariant("road_line_yellow_center"), "Road Lines", "Yellow");
        lang.addBlock(getVariant("road_line_yellow_long"), "Road Lines", "Yellow");
        lang.addBlock(getVariant("road_line_yellow_side"), "Road Lines", "Yellow");
    }
}

