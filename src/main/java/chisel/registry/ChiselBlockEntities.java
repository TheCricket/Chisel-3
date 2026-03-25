package chisel.registry;

import chisel.Chisel;
import chisel.block.ConnectedTextureBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ChiselBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Chisel.MODID);

    public static Supplier<BlockEntityType<ConnectedTextureBlockEntity>> CONNECTED_TEXTURE_BLOCK_ENTITY;

    public static void register(IEventBus bus) {
        CONNECTED_TEXTURE_BLOCK_ENTITY = BLOCK_ENTITIES.register("connected_texture_block_entity", () -> {
            Set<Block> connectedTextureBlocks = new HashSet<>();
            ChiselBlocks.getBlocks().forEach(family -> family.getFamily().getVariants().forEach(variant -> {
                if(variant.isCTM()) connectedTextureBlocks.add(variant.getBlock());
            }));
            return new BlockEntityType<>(ConnectedTextureBlockEntity::new, connectedTextureBlocks);
        });

        BLOCK_ENTITIES.register(bus);
    }
}
