package chisel.entity;

import chisel.core.projectile.SmashingRockData;
import chisel.datagen.ChiselSmashingRockRegistry;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SmashingRock extends ThrowableItemProjectile {
    public SmashingRock(EntityType<? extends SmashingRock> type, Level level) {
        super(type, level);
    }

    public SmashingRock(Level level, double x, double y, double z, ItemStack stack) {
        super(ChiselEntities.SMASHING_ROCK.get(), x, y, z, level, stack);
    }

    public SmashingRock(ServerLevel serverLevel, LivingEntity livingEntity, ItemStack stack) {
        super(ChiselEntities.SMASHING_ROCK.get(), livingEntity, serverLevel, stack);
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
                        smash(check);
                }
            }
        }
        remove(RemovalReason.KILLED);
    }

    private void smash(BlockPos pos) {
        Block smashed = getSmashedBlock(level().getBlockState(pos), level().registryAccess());
        if(smashed != null) {
            level().setBlockAndUpdate(pos, smashed.defaultBlockState());
        }
    }

    private Block getSmashedBlock(BlockState block, RegistryAccess registryAccess) {
        List<SmashingRockData> dataList = new ArrayList<>();

        Registry<SmashingRockData> registry = Objects.requireNonNull(registryAccess
                .lookup(ChiselSmashingRockRegistry.KEY)
                .orElseThrow(() -> new IllegalStateException("Smashing rock registry is not available on the server"))
        );

        for (Map.Entry<ResourceKey<SmashingRockData>, SmashingRockData> e : registry.entrySet()) {
            dataList.add(e.getValue());
        }

        for(SmashingRockData data : dataList) {
            if(data.getInput().right().isPresent()) {
                TagKey<Block> tag = data.getInput().right().get();
                if(block.is(tag)) {
                    return BuiltInRegistries.BLOCK.getValue(data.getSmashedBlock());
                }
            } else {
                Block input = BuiltInRegistries.BLOCK.getValue(data.getInput().left().get());
                if(block.is(input)) {
                    return BuiltInRegistries.BLOCK.getValue(data.getSmashedBlock());
                }
            }
        }

        return null;
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return ChiselItems.SMASHING_ROCK.get();
    }
}
