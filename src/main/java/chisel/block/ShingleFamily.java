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
        lang.addBlock(getVariant("shingles_1"), "Shingles", "Red Diagonal");
        lang.addBlock(getVariant("shingles_2"), "Shingles", "Red Tiny Squares");
        lang.addBlock(getVariant("shingles_3"), "Shingles", "Red Big Squares");
        lang.addBlock(getVariant("shingles_4"), "Shingles", "Black Diagonal");
        lang.addBlock(getVariant("shingles_5"), "Shingles", "Black Tiny Squares");
        lang.addBlock(getVariant("shingles_6"), "Shingles", "Black Big Squares");
    }
}