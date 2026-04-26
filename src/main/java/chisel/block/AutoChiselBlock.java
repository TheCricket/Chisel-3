package chisel.block;

import chisel.block.entity.AutoChiselBlockEntity;
import chisel.inventory.menu.AutoChiselMenu;
import chisel.registry.ChiselStats;
import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import chisel.registry.ChiselBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class AutoChiselBlock extends BaseEntityBlock {

    public static final MapCodec<AutoChiselBlock> CODEC = simpleCodec(AutoChiselBlock::new);
    private static final VoxelShape COLLISION_SHAPE = Shapes.or(
            box(0, 0, 0, 16, 10, 16),
            box(0, 10, 0, 1, 16, 16),
            box(15, 10, 0, 16, 16, 16),
            box(0, 10, 0, 16, 16, 1),
            box(0, 10, 15, 16, 16, 16),
            box(0, 15, 0, 16, 16, 16)
    );

    private static final VoxelShape SELECTION_SHAPE = box(0, 0, 0, 16, 16, 16);

    public AutoChiselBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NonNull BlockPos pos, @NonNull BlockState state) {
        return new AutoChiselBlockEntity(pos, state);
    }

    @Override
    protected @NonNull VoxelShape getCollisionShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return SELECTION_SHAPE;
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            player.openMenu(state.getMenuProvider(level, pos), pos);
            player.awardStat(ChiselStats.INTERACT_WITH_AUTO_CHISEL.get());
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected @Nullable MenuProvider getMenuProvider(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AutoChiselBlockEntity autoChisel) {
            return new SimpleMenuProvider((id, inv, _) -> new AutoChiselMenu(id, inv, autoChisel, autoChisel.getData()), Component.translatable("container.auto_chisel"));
        }
        return super.getMenuProvider(state, level, pos);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NonNull BlockState state, @NonNull BlockEntityType<T> type) {
        return createTickerHelper(type, ChiselBlockEntities.AUTO_CHISEL.get(), AutoChiselBlockEntity::tick);
    }
}
