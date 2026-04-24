package chisel.block.entity;

import chisel.registry.ChiselBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AutoChiselBlockEntity extends BlockEntity {

    public AutoChiselBlockEntity(BlockPos pos, BlockState state) {
        super(ChiselBlockEntities.AUTO_CHISEL.get(), pos, state);
    }
}
