package chisel.entity;

import chisel.Chisel;
import chisel.core.projectile.BallOMossData;
import chisel.datagen.ChiselBallOMossRegistry;
import chisel.registry.ChiselEntities;
import chisel.registry.ChiselItems;
import chisel.registry.ChiselSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;

import java.util.*;

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
        Block mossBlock = getMossBlock(level().getBlockState(pos), level().registryAccess());
        if(mossBlock != null) {
            level().setBlockAndUpdate(pos, mossBlock.defaultBlockState());
        }
    }

    private Block getMossBlock(BlockState block, RegistryAccess registryAccess) {
        List<BallOMossData> dataList = new ArrayList<>();

        Registry<BallOMossData> registry = Objects.requireNonNull(registryAccess
                .lookup(ChiselBallOMossRegistry.KEY)
                .orElseThrow(() -> new IllegalStateException("Ball o' moss registry is not available on the server"))
        );

        for (Map.Entry<ResourceKey<BallOMossData>, BallOMossData> e : registry.entrySet()) {
            dataList.add(e.getValue());
        }

        for(BallOMossData data : dataList) {
            if(data.getInput().right().isPresent()) {
                TagKey<Block> tag = data.getInput().right().get();
                if(block.is(tag)) {
                    return BuiltInRegistries.BLOCK.getValue(data.getMossBlock());
                }
            } else {
                Block input = BuiltInRegistries.BLOCK.getValue(data.getInput().left().get());
                if(block.is(input)) {
                    return BuiltInRegistries.BLOCK.getValue(data.getMossBlock());
                }
            }
        }

        return null;
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return ChiselItems.BALL_O_MOSS.get();
    }
}
