package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ShingleFamily extends ChiselBlock {
    public ShingleFamily(BlockBehaviour.Properties props) {
        family = builder("shingles")
                .addVariant("shingles_1", props, VariantModelType.V4)
                .addVariant("shingles_2", props, VariantModelType.V4)
                .addVariant("shingles_3", props, VariantModelType.V4)
                .addVariant("shingles_4", props, VariantModelType.V4)
                .addVariant("shingles_5", props, VariantModelType.V4)
                .addVariant("shingles_6", props, VariantModelType.V4)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("shingles_1"), "Shingle", "1");
        lang.addBlock(getVariant("shingles_2"), "Shingle", "2");
        lang.addBlock(getVariant("shingles_3"), "Shingle", "3");
        lang.addBlock(getVariant("shingles_4"), "Shingle", "4");
        lang.addBlock(getVariant("shingles_5"), "Shingle", "5");
        lang.addBlock(getVariant("shingles_6"), "Shingle", "6");
    }
}