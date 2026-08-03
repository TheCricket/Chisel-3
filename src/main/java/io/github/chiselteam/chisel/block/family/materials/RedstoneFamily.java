package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ChiselPoweredBlock;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class RedstoneFamily extends ChiselFamily {
    public RedstoneFamily(BlockBehaviour.Properties props) {
        family = builder("redstone")
                .addVariant("redstone_bricks", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_bricks_chaotic", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_bricks_small", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_chiseled", ChiselPoweredBlock::new, () -> props, TBS)
                .addVariant("redstone_chunk", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_circuit", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_circuit_supaplex", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_ere", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_greek", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_large", ChiselPoweredBlock::new, () -> props, CONNECTED)
                .addVariant("redstone_pillar", ChiselPoweredBlock::new, () -> props, TBS)
                .addVariant("redstone_skulls", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_small", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_smooth", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_solid", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_tiles", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_tiles_ornate", ChiselPoweredBlock::new, () -> props)
                .addVariant("redstone_zelda", ChiselPoweredBlock::new, () -> props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("redstone_bricks"), "Block of Redstone", "Redstone Bricks");
        lang.addBlock(getVariant("redstone_bricks_chaotic"), "Block of Redstone", "Chaotic Redstone Bricks");
        lang.addBlock(getVariant("redstone_bricks_small"), "Block of Redstone", "Small Redstone Bricks");
        lang.addBlock(getVariant("redstone_chiseled"), "Block of Redstone", "Chiseled Redstone");
        lang.addBlock(getVariant("redstone_chunk"), "Block of Redstone", "Chunk");
        lang.addBlock(getVariant("redstone_circuit"), "Block of Redstone", "Redstone Circuit");
        lang.addBlock(getVariant("redstone_circuit_supaplex"), "Block of Redstone", "Redstone Supaplex Circuit");
        lang.addBlock(getVariant("redstone_ere"), "Block of Redstone", "Ere");
        lang.addBlock(getVariant("redstone_greek"), "Block of Redstone", "Redstone Greek Decoration");
        lang.addBlock(getVariant("redstone_large"), "Block of Redstone", "Large Redstone Block");
        lang.addBlock(getVariant("redstone_pillar"), "Block of Redstone", "Redstone Pillar");
        lang.addBlock(getVariant("redstone_skulls"), "Block of Redstone", "Redstone Skulls");
        lang.addBlock(getVariant("redstone_small"), "Block of Redstone", "Small Redstone Block");
        lang.addBlock(getVariant("redstone_smooth"), "Block of Redstone", "Smooth Redstone");
        lang.addBlock(getVariant("redstone_solid"), "Block of Redstone", "Solid");
        lang.addBlock(getVariant("redstone_tiles"), "Block of Redstone", "Redstone Tiles");
        lang.addBlock(getVariant("redstone_tiles_ornate"), "Block of Redstone", "Ornate Redstone Tiles");
        lang.addBlock(getVariant("redstone_zelda"), "Block of Redstone", "Redstone Zelda Block");
    }
}

