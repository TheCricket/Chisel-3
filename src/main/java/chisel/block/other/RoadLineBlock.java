package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RoadLineBlock extends ChiselBlock {
    public RoadLineBlock(BlockBehaviour.Properties props) {
        

        family = builder("road_line")
                .addVariant("road_line_0", props)
                .addVariant("road_line_1", props)
                .addVariant("road_line_2", props)
                .addVariant("road_line_3", props)
                .addVariant("road_line_4", props)
                .addVariant("road_line_5", props)
                .addVariant("road_line_6", props)
                .addVariant("road_line_7", props)
                .addVariant("road_line_8", props)
                .addVariant("road_line_9", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("road_line_0"), "Road Line", "Type 0");
        lang.addBlock(getVariant("road_line_1"), "Road Line", "Type 1");
        lang.addBlock(getVariant("road_line_2"), "Road Line", "Type 2");
        lang.addBlock(getVariant("road_line_3"), "Road Line", "Type 3");
        lang.addBlock(getVariant("road_line_4"), "Road Line", "Type 4");
        lang.addBlock(getVariant("road_line_5"), "Road Line", "Type 5");
        lang.addBlock(getVariant("road_line_6"), "Road Line", "Type 6");
        lang.addBlock(getVariant("road_line_7"), "Road Line", "Type 7");
        lang.addBlock(getVariant("road_line_8"), "Road Line", "Type 8");
        lang.addBlock(getVariant("road_line_9"), "Road Line", "Type 9");
    }
}

