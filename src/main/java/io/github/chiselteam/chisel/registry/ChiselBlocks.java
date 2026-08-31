package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.AutoChiselBlock;
import io.github.chiselteam.chisel.block.BuildersGuideBlock;
import io.github.chiselteam.chisel.block.ConnectedTextureBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Function;
import java.util.function.Supplier;

public class ChiselBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chisel.MODID);

    public static final DeferredBlock<Block> AUTO_CHISEL = BLOCKS.registerBlock("auto_chisel", AutoChiselBlock::new, () -> Properties.of()
            .sound(SoundType.METAL)
            .strength(2.5F)
            .noOcclusion()
            .requiresCorrectToolForDrops());

    public static final DeferredBlock<Block> BUILDERS_GUIDE = BLOCKS.registerBlock("builders_guide", BuildersGuideBlock::new, () -> Properties.of()
            .sound(SoundType.METAL)
            .strength(2.5F)
            .requiresCorrectToolForDrops());

    private ChiselBlocks() {
    }

    @ApiStatus.Internal
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    @ApiStatus.Internal
    public static DeferredBlock<Block> register(String name, Properties properties) {
        return BLOCKS.registerBlock(name, ConnectedTextureBlock::new, () -> properties);
    }

    @ApiStatus.Internal
    public static DeferredBlock<Block> register(String name, Function<Properties, ? extends Block> func, Supplier<Properties> properties) {
        return BLOCKS.registerBlock(name, func, properties);
    }
}
