package io.github.chiselteam.chisel.entity;

import io.github.chiselteam.chisel.network.MossDeltaPacket;
import io.github.chiselteam.chisel.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jspecify.annotations.NonNull;

public class BallOMoss extends ThrowableItemProjectile {
    public BallOMoss(EntityType<? extends BallOMoss> type, Level level) {
        super(type, level);
    }

    public BallOMoss(Level level, double x, double y, double z, ItemStack stack) {
        super(ChiselEntities.BALL_O_MOSS.get(), x, y, z, level, stack);
    }

    public BallOMoss(ServerLevel serverLevel, LivingEntity livingEntity, ItemStack stack) {
        super(ChiselEntities.BALL_O_MOSS.get(), livingEntity, serverLevel, stack);
    }

    @Override
    protected void onHitBlock(@NonNull BlockHitResult result) {
        super.onHitBlock(result);
        BlockPos pos = result.getBlockPos();
        level().playSound(null, pos, ChiselSounds.SQUASH.value(), SoundSource.NEUTRAL);
        int falloff = 3;
        for(int x = -5; x < 5; x++) {
            for(int y = -5; y < 5; y++) {
                for(int z = -5; z < 5; z++) {
                    double dist = (x < 0 ? -x : x) + (y < 0 ? -y : y) + (z < 0 ? -z : z);

                    if (!(dist < falloff || getRandom().nextInt(15 - falloff) >= dist * 2))
                        continue;

                    BlockPos check = pos.offset(x, y, z);
                    if(!level().getBlockState(check).isAir())
                        turnToMoss(check);
                }
            }
        }
        remove(RemovalReason.KILLED);
    }

    private void turnToMoss(BlockPos pos) {
        if (!(level() instanceof ServerLevel serverLevel)) return;
        BlockState state = serverLevel.getBlockState(pos);
        if (state.getRenderShape() != RenderShape.MODEL || !Block.isShapeFullBlock(state.getOcclusionShape())) return;
        if (serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK).getOrThrow(ChiselTags.CANT_BE_MOSSED).stream().anyMatch(holder -> holder.is(state.getBlock().builtInRegistryHolder().getKey())))
            return;
        var moss = serverLevel.getData(ChiselAttachments.MOSS);
        int texture = serverLevel.getRandom().nextInt(10) + 1;
        if (moss.add(pos, texture)) {
            serverLevel.setData(ChiselAttachments.MOSS, moss);
            PacketDistributor.sendToPlayersTrackingChunk(serverLevel, serverLevel.getChunkAt(pos).getPos(), new MossDeltaPacket(pos, true, texture));
        }
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return ChiselItems.BALL_O_MOSS.get();
    }
}
