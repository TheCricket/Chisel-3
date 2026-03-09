package chisel.util;

import chisel.block.ConnectedTextureBlock;
import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ChiselBlocksProvider {

    public abstract void registerBlocks();

    protected static DeferredBlock<Block> register(String name, BlockBehaviour.Properties props) {
        DeferredBlock<Block> block = ChiselBlocks.BLOCKS.registerBlock(name, ConnectedTextureBlock::new, () -> props);
        ChiselItems.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }

    protected static DeferredBlock<Block> register(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties) {
        DeferredBlock<Block> block = ChiselBlocks.BLOCKS.registerBlock(name, func, properties);
        ChiselItems.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }
}
