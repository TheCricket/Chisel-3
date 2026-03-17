package chisel.registry.blocks;

import chisel.util.ChiselBlocksProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ChiselModdedBlocks extends ChiselBlocksProvider {
    public static DeferredBlock<Block> BRONZE_BAD_GREGGY;
    public static DeferredBlock<Block> BRONZE_BOLTED;
    public static DeferredBlock<Block> BRONZE_CAUTION;
    public static DeferredBlock<Block> BRONZE_CRATE;
    public static DeferredBlock<Block> BRONZE_MACHINE;
    public static DeferredBlock<Block> BRONZE_SCAFFOLD;
    public static DeferredBlock<Block> BRONZE_THERMAL;

    public static DeferredBlock<Block> COBALT_BAD_GREGGY;
    public static DeferredBlock<Block> COBALT_BOLTED;
    public static DeferredBlock<Block> COBALT_CAUTION;
    public static DeferredBlock<Block> COBALT_CRATE;
    public static DeferredBlock<Block> COBALT_MACHINE;
    public static DeferredBlock<Block> COBALT_SCAFFOLD;
    public static DeferredBlock<Block> COBALT_THERMAL;

    public static DeferredBlock<Block> ELECTRUM_BAD_GREGGY;
    public static DeferredBlock<Block> ELECTRUM_BOLTED;
    public static DeferredBlock<Block> ELECTRUM_CAUTION;
    public static DeferredBlock<Block> ELECTRUM_CRATE;
    public static DeferredBlock<Block> ELECTRUM_MACHINE;
    public static DeferredBlock<Block> ELECTRUM_SCAFFOLD;
    public static DeferredBlock<Block> ELECTRUM_THERMAL;

    public static DeferredBlock<Block> INVAR_BAD_GREGGY;
    public static DeferredBlock<Block> INVAR_BOLTED;
    public static DeferredBlock<Block> INVAR_CAUTION;
    public static DeferredBlock<Block> INVAR_CRATE;
    public static DeferredBlock<Block> INVAR_MACHINE;
    public static DeferredBlock<Block> INVAR_SCAFFOLD;
    public static DeferredBlock<Block> INVAR_THERMAL;

    public static DeferredBlock<Block> LEAD_BAD_GREGGY;
    public static DeferredBlock<Block> LEAD_BOLTED;
    public static DeferredBlock<Block> LEAD_CAUTION;
    public static DeferredBlock<Block> LEAD_CRATE;
    public static DeferredBlock<Block> LEAD_MACHINE;
    public static DeferredBlock<Block> LEAD_SCAFFOLD;
    public static DeferredBlock<Block> LEAD_THERMAL;

    public static DeferredBlock<Block> NICKEL_BAD_GREGGY;
    public static DeferredBlock<Block> NICKEL_BOLTED;
    public static DeferredBlock<Block> NICKEL_CAUTION;
    public static DeferredBlock<Block> NICKEL_CRATE;
    public static DeferredBlock<Block> NICKEL_MACHINE;
    public static DeferredBlock<Block> NICKEL_SCAFFOLD;
    public static DeferredBlock<Block> NICKEL_THERMAL;

    public static DeferredBlock<Block> PLATINUM_BAD_GREGGY;
    public static DeferredBlock<Block> PLATINUM_BOLTED;
    public static DeferredBlock<Block> PLATINUM_CAUTION;
    public static DeferredBlock<Block> PLATINUM_CRATE;
    public static DeferredBlock<Block> PLATINUM_MACHINE;
    public static DeferredBlock<Block> PLATINUM_SCAFFOLD;
    public static DeferredBlock<Block> PLATINUM_THERMAL;

    public static DeferredBlock<Block> SILVER_BAD_GREGGY;
    public static DeferredBlock<Block> SILVER_BOLTED;
    public static DeferredBlock<Block> SILVER_CAUTION;
    public static DeferredBlock<Block> SILVER_CRATE;
    public static DeferredBlock<Block> SILVER_MACHINE;
    public static DeferredBlock<Block> SILVER_SCAFFOLD;
    public static DeferredBlock<Block> SILVER_THERMAL;

    public static DeferredBlock<Block> STEEL_BAD_GREGGY;
    public static DeferredBlock<Block> STEEL_BOLTED;
    public static DeferredBlock<Block> STEEL_CAUTION;
    public static DeferredBlock<Block> STEEL_CRATE;
    public static DeferredBlock<Block> STEEL_MACHINE;
    public static DeferredBlock<Block> STEEL_SCAFFOLD;
    public static DeferredBlock<Block> STEEL_THERMAL;

    public static DeferredBlock<Block> TIN_BAD_GREGGY;
    public static DeferredBlock<Block> TIN_BOLTED;
    public static DeferredBlock<Block> TIN_CAUTION;
    public static DeferredBlock<Block> TIN_CRATE;
    public static DeferredBlock<Block> TIN_MACHINE;
    public static DeferredBlock<Block> TIN_SCAFFOLD;
    public static DeferredBlock<Block> TIN_THERMAL;

    public static DeferredBlock<Block> URANIUM_BAD_GREGGY;
    public static DeferredBlock<Block> URANIUM_BOLTED;
    public static DeferredBlock<Block> URANIUM_CAUTION;
    public static DeferredBlock<Block> URANIUM_CRATE;
    public static DeferredBlock<Block> URANIUM_MACHINE;
    public static DeferredBlock<Block> URANIUM_SCAFFOLD;
    public static DeferredBlock<Block> URANIUM_THERMAL;

    @Override
    public void registerBlocks() {
        BRONZE_BAD_GREGGY = register("bronze_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_BOLTED = register("bronze_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_CAUTION = register("bronze_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_CRATE = register("bronze_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_MACHINE = register("bronze_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_SCAFFOLD = register("bronze_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_THERMAL = register("bronze_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        COBALT_BAD_GREGGY = register("cobalt_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_BOLTED = register("cobalt_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_CAUTION = register("cobalt_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_CRATE = register("cobalt_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_MACHINE = register("cobalt_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_SCAFFOLD = register("cobalt_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        COBALT_THERMAL = register("cobalt_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        ELECTRUM_BAD_GREGGY = register("electrum_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_BOLTED = register("electrum_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_CAUTION = register("electrum_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_CRATE = register("electrum_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_MACHINE = register("electrum_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_SCAFFOLD = register("electrum_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        ELECTRUM_THERMAL = register("electrum_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        INVAR_BAD_GREGGY = register("invar_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_BOLTED = register("invar_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_CAUTION = register("invar_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_CRATE = register("invar_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_MACHINE = register("invar_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_SCAFFOLD = register("invar_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        INVAR_THERMAL = register("invar_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        LEAD_BAD_GREGGY = register("lead_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_BOLTED = register("lead_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_CAUTION = register("lead_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_CRATE = register("lead_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_MACHINE = register("lead_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_SCAFFOLD = register("lead_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_THERMAL = register("lead_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        NICKEL_BAD_GREGGY = register("nickel_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_BOLTED = register("nickel_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_CAUTION = register("nickel_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_CRATE = register("nickel_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_MACHINE = register("nickel_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_SCAFFOLD = register("nickel_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        NICKEL_THERMAL = register("nickel_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        PLATINUM_BAD_GREGGY = register("platinum_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_BOLTED = register("platinum_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_CAUTION = register("platinum_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_CRATE = register("platinum_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_MACHINE = register("platinum_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_SCAFFOLD = register("platinum_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        PLATINUM_THERMAL = register("platinum_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        SILVER_BAD_GREGGY = register("silver_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_BOLTED = register("silver_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_CAUTION = register("silver_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_CRATE = register("silver_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_MACHINE = register("silver_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_SCAFFOLD = register("silver_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_THERMAL = register("silver_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        STEEL_BAD_GREGGY = register("steel_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_BOLTED = register("steel_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_CAUTION = register("steel_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_CRATE = register("steel_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_MACHINE = register("steel_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_SCAFFOLD = register("steel_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_THERMAL = register("steel_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        TIN_BAD_GREGGY = register("tin_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_BOLTED = register("tin_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_CAUTION = register("tin_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_CRATE = register("tin_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_MACHINE = register("tin_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_SCAFFOLD = register("tin_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_THERMAL = register("tin_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        URANIUM_BAD_GREGGY = register("uranium_bad_greggy", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_BOLTED = register("uranium_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_CAUTION = register("uranium_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_CRATE = register("uranium_crate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_MACHINE = register("uranium_machine", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_SCAFFOLD = register("uranium_scaffold", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_THERMAL = register("uranium_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    }
}
