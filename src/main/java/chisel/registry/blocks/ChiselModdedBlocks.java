package chisel.registry.blocks;

import chisel.util.ChiselBlocksProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ChiselModdedBlocks extends ChiselBlocksProvider {
    public static DeferredBlock<Block> BRONZE_CAUTION;
    public static DeferredBlock<Block> BRONZE_SHIPPING;
    public static DeferredBlock<Block> BRONZE_THERMAL;
    public static DeferredBlock<Block> BRONZE_125;
    public static DeferredBlock<Block> BRONZE_BORDERED;
    public static DeferredBlock<Block> BRONZE_BOLTED;

    public static DeferredBlock<Block> LEAD_CAUTION;
    public static DeferredBlock<Block> LEAD_SHIPPING;
    public static DeferredBlock<Block> LEAD_THERMAL;
    public static DeferredBlock<Block> LEAD_125;
    public static DeferredBlock<Block> LEAD_BORDERED;
    public static DeferredBlock<Block> LEAD_BOLTED;

    public static DeferredBlock<Block> SILVER_CAUTION;
    public static DeferredBlock<Block> SILVER_SHIPPING;
    public static DeferredBlock<Block> SILVER_THERMAL;
    public static DeferredBlock<Block> SILVER_125;
    public static DeferredBlock<Block> SILVER_BORDERED;
    public static DeferredBlock<Block> SILVER_BOLTED;

    public static DeferredBlock<Block> STEEL_CAUTION;
    public static DeferredBlock<Block> STEEL_SHIPPING;
    public static DeferredBlock<Block> STEEL_THERMAL;
    public static DeferredBlock<Block> STEEL_125;
    public static DeferredBlock<Block> STEEL_BORDERED;
    public static DeferredBlock<Block> STEEL_BOLTED;

    public static DeferredBlock<Block> TIN_CAUTION;
    public static DeferredBlock<Block> TIN_SHIPPING;
    public static DeferredBlock<Block> TIN_THERMAL;
    public static DeferredBlock<Block> TIN_125;
    public static DeferredBlock<Block> TIN_BORDERED;
    public static DeferredBlock<Block> TIN_BOLTED;

    public static DeferredBlock<Block> URANIUM_CAUTION;
    public static DeferredBlock<Block> URANIUM_SHIPPING;
    public static DeferredBlock<Block> URANIUM_THERMAL;
    public static DeferredBlock<Block> URANIUM_125;
    public static DeferredBlock<Block> URANIUM_BORDERED;
    public static DeferredBlock<Block> URANIUM_BOLTED;

    @Override
    public void registerBlocks() {
        BRONZE_CAUTION = register("bronze_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_SHIPPING = register("bronze_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_THERMAL = register("bronze_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_125 = register("bronze_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_BORDERED = register("bronze_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        BRONZE_BOLTED = register("bronze_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        LEAD_CAUTION = register("lead_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_SHIPPING = register("lead_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_THERMAL = register("lead_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_125 = register("lead_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_BORDERED = register("lead_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        LEAD_BOLTED = register("lead_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        SILVER_CAUTION = register("silver_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_SHIPPING = register("silver_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_THERMAL = register("silver_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_125 = register("silver_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_BORDERED = register("silver_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        SILVER_BOLTED = register("silver_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        STEEL_CAUTION = register("steel_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_SHIPPING = register("steel_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_THERMAL = register("steel_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_125 = register("steel_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_BORDERED = register("steel_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        STEEL_BOLTED = register("steel_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        TIN_CAUTION = register("tin_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_SHIPPING = register("tin_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_THERMAL = register("tin_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_125 = register("tin_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_BORDERED = register("tin_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        TIN_BOLTED = register("tin_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

        URANIUM_CAUTION = register("uranium_caution", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_SHIPPING = register("uranium_shipping", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_THERMAL = register("uranium_thermal", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_125 = register("uranium_125", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_BORDERED = register("uranium_bordered", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
        URANIUM_BOLTED = register("uranium_bolted", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    }
}
