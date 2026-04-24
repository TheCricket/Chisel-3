package chisel.registry;

import chisel.Chisel;
import chisel.block.entity.AutoChiselBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ChiselBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Chisel.MODID);
    public static final Supplier<BlockEntityType<AutoChiselBlockEntity>> AUTO_CHISEL = BLOCK_ENTITIES.register("auto_chisel", () -> new BlockEntityType<>(AutoChiselBlockEntity::new, false, ChiselBlocks.AUTO_CHISEL.get()));
}
