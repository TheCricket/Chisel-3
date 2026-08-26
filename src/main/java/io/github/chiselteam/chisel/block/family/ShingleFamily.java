package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ShingleFamily extends ChiselFamily {
    public ShingleFamily(BlockBehaviour.Properties props) {
        family = builder("shingles")
                .addVariant("shingles_1", props, V4)
                .addVariant("shingles_2", props, V4)
                .addVariant("shingles_3", props, V4)
                .addVariant("shingles_4", props, V4)
                .addVariant("shingles_5", props, V4)
                .addVariant("shingles_6", props, V4)
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