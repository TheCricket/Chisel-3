package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ThaumiumFamily extends ChiselFamily {
    public ThaumiumFamily(BlockBehaviour.Properties props) {
        family = builder("thaumium")
                .addVariant("thaumium_bevel", props)
                .addVariant("thaumium_block", props)
                .addVariant("thaumium_bricks", props, CONNECTED)
                .addVariant("thaumium_chunks", props)
                .addVariant("thaumium_lattice", props)
                .addVariant("thaumium_ornate", props)
                .addVariant("thaumium_planks", props, CONNECTED)
                .addVariant("thaumium_runes_purple", props, V9)
                .addVariant("thaumium_runes", props, V9)
                .addVariant("thaumium_small", props)
                .addVariant("thaumium_totem", props, R4)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("thaumium_bevel"), "Thaumium", "Bevel");
        lang.addBlock(getVariant("thaumium_block"), "Thaumium", "Block");
        lang.addBlock(getVariant("thaumium_bricks"), "Thaumium", "Bricks");
        lang.addBlock(getVariant("thaumium_chunks"), "Thaumium", "Chunks");
        lang.addBlock(getVariant("thaumium_lattice"), "Thaumium", "Lattice");
        lang.addBlock(getVariant("thaumium_ornate"), "Thaumium", "Ornate");
        lang.addBlock(getVariant("thaumium_planks"), "Thaumium", "Planks");
        lang.addBlock(getVariant("thaumium_runes_purple"), "Thaumium", "Purple Runes");
        lang.addBlock(getVariant("thaumium_runes"), "Thaumium", "Runes");
        lang.addBlock(getVariant("thaumium_small"), "Thaumium", "Small");
        lang.addBlock(getVariant("thaumium_totem"), "Thaumium", "Totem");
    }
}
