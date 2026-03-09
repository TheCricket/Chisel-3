package chisel.registry;

import chisel.Chisel;
import chisel.registry.blocks.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chisel.MODID);

    private static final ChiselMetalBlocks metalBlocks = new ChiselMetalBlocks();
    private static final ChiselModdedBlocks moddedBlocks = new ChiselModdedBlocks();
    private static final ChiselOtherBlocks otherBlocks = new ChiselOtherBlocks();
    private static final ChiselWoodBlocks woodBlocks = new ChiselWoodBlocks();
    private static final ChiselStoneBlocks stoneBlocks = new ChiselStoneBlocks();
    private static final ChiselStainedGlassBlocks stainedGlassBlocks = new ChiselStainedGlassBlocks();

    public static void registerBlocks(IEventBus bus) {
        metalBlocks.registerBlocks();
        moddedBlocks.registerBlocks();
        otherBlocks.registerBlocks();
        woodBlocks.registerBlocks();
        stoneBlocks.registerBlocks();
        stainedGlassBlocks.registerBlocks();
        BLOCKS.register(bus);
    }
}
