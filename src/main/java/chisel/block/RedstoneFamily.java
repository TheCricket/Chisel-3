package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RedstoneFamily extends ChiselBlock {
    public RedstoneFamily(BlockBehaviour.Properties props) {
        family = builder("redstone")
                .addVariant(Blocks.REDSTONE_BLOCK)
                .addVariant("redstone_bricks", props)
                .addVariant("redstone_bricks_chaotic", props)
                .addVariant("redstone_bricks_small", props)
                .addVariant("redstone_chiseled", props, VariantModelType.TBS)
                .addVariant("redstone_chunk", props)
                .addVariant("redstone_circuit", props)
                .addVariant("redstone_circuit_supaplex", props)
                .addVariant("redstone_ere", props)
                .addVariant("redstone_greek", props)
                .addVariant("redstone_large", props, VariantModelType.CONNECTED)
                .addVariant("redstone_pillar", props, VariantModelType.TBS)
                .addVariant("redstone_skulls", props)
                .addVariant("redstone_small", props)
                .addVariant("redstone_smooth", props)
                .addVariant("redstone_solid", props)
                .addVariant("redstone_tiles", props)
                .addVariant("redstone_tiles_ornate", props)
                .addVariant("redstone_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("redstone_bricks"), "Redstone Block", "Redstone Bricks");
        lang.addBlock(getVariant("redstone_bricks_chaotic"), "Redstone Block", "Chaotic Redstone Bricks");
        lang.addBlock(getVariant("redstone_bricks_small"), "Redstone Block", "Small Redstone Bricks");
        lang.addBlock(getVariant("redstone_chiseled"), "Redstone Block", "Chiseled Redstone");
        lang.addBlock(getVariant("redstone_chunk"), "Redstone Block", "Chunk");
        lang.addBlock(getVariant("redstone_circuit"), "Redstone Block", "Redstone Circuit");
        lang.addBlock(getVariant("redstone_circuit_supaplex"), "Redstone Block", "Redstone Supaplex Circuit");
        lang.addBlock(getVariant("redstone_ere"), "Redstone Block", "Ere");
        lang.addBlock(getVariant("redstone_greek"), "Redstone Block", "Redstone Greek Decoration");
        lang.addBlock(getVariant("redstone_large"), "Redstone Block", "Large Redstone Block");
        lang.addBlock(getVariant("redstone_pillar"), "Redstone Block", "Redstone Pillar");
        lang.addBlock(getVariant("redstone_skulls"), "Redstone Block", "Redstone Skulls");
        lang.addBlock(getVariant("redstone_small"), "Redstone Block", "Small Redstone Block");
        lang.addBlock(getVariant("redstone_smooth"), "Redstone Block", "Smooth Redstone");
        lang.addBlock(getVariant("redstone_solid"), "Redstone Block", "Solid");
        lang.addBlock(getVariant("redstone_tiles"), "Redstone Block", "Redstone Tiles");
        lang.addBlock(getVariant("redstone_tiles_ornate"), "Redstone Block", "Ornate Redstone Tiles");
        lang.addBlock(getVariant("redstone_zelda"), "Redstone Block", "Redstone Zelda Block");
    }
}

