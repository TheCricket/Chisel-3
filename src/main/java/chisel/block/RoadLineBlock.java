package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RoadLineBlock extends ChiselBlock {
    public RoadLineBlock(BlockBehaviour.Properties props) {
        family = builder("road_line")
                .addVariant("road_line_double_white_center", props)
                .addVariant("road_line_double_white_long", props)
                .addVariant("road_line_double_white_side", props)
                .addVariant("road_line_double_yellow_center", props)
                .addVariant("road_line_double_yellow_long", props)
                .addVariant("road_line_double_yellow_side", props)
                .addVariant("road_line_white_center", props)
                .addVariant("road_line_white_long", props)
                .addVariant("road_line_white_side", props)
                .addVariant("road_line_yellow_center", props)
                .addVariant("road_line_yellow_long", props)
                .addVariant("road_line_yellow_side", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("road_line_double_white_center"), "Road Line", "Double White Center");
        lang.addBlock(getVariant("road_line_double_white_long"), "Road Line", "Double White Long");
        lang.addBlock(getVariant("road_line_double_white_side"), "Road Line", "Double White Side");
        lang.addBlock(getVariant("road_line_double_yellow_center"), "Road Line", "Double Yellow Center");
        lang.addBlock(getVariant("road_line_double_yellow_long"), "Road Line", "Double Yellow Long");
        lang.addBlock(getVariant("road_line_double_yellow_side"), "Road Line", "Double Yellow Side");
        lang.addBlock(getVariant("road_line_white_center"), "Road Line", "White Center");
        lang.addBlock(getVariant("road_line_white_long"), "Road Line", "White Long");
        lang.addBlock(getVariant("road_line_white_side"), "Road Line", "White Side");
        lang.addBlock(getVariant("road_line_yellow_center"), "Road Line", "Yellow Center");
        lang.addBlock(getVariant("road_line_yellow_long"), "Road Line", "Yellow Long");
        lang.addBlock(getVariant("road_line_yellow_side"), "Road Line", "Yellow Side");
    }
}

