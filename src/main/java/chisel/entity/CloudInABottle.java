package chisel.entity;

import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselEntities;
import chisel.registry.ChiselItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;

public class CloudInABottle extends ThrowableItemProjectile {
    public CloudInABottle(EntityType<? extends CloudInABottle> type, Level level) {
        super(type, level);
    }

    public CloudInABottle(Level level, double x, double y, double z, ItemStack stack) {
        super(ChiselEntities.CLOUD_IN_A_BOTTLE.get(), x, y, z, level, stack);
    }

    public CloudInABottle(ServerLevel serverLevel, LivingEntity livingEntity, ItemStack stack) {
        super(ChiselEntities.CLOUD_IN_A_BOTTLE.get(), livingEntity, serverLevel, stack);
    }

    @Override
    protected void onHitBlock(@NonNull BlockHitResult result) {
        super.onHitBlock(result);
        generate(result.getBlockPos(), 40);
        level().playSound(null, result.getBlockPos(), SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL);
        remove(RemovalReason.KILLED);
    }

    public boolean generate(BlockPos pos, int numberOfBlocks) {
        int X[] = new int[9];
        int Y[] = new int[9];
        int Z[] = new int[9];

        for (int dir = 0; dir < 9; dir++) {
            X[dir] = 0;
            Y[dir] = 0;
            Z[dir] = 0;
        }

        int count = 0;

        while (count < numberOfBlocks) {
            for (int dir = 0; dir < 9; dir++) {
                if (count >= numberOfBlocks) {
                    break;
                }

                int dx = dir % 3 - 1;
                int dz = dir / 3 - 1;

                if (dx == 0 && dz == 0) {
                    continue;
                }

                X[dir] += random.nextInt(3) - 1 + dx;
                Y[dir] += random.nextInt(2) * (random.nextInt(3) - 1);
                Z[dir] += random.nextInt(3) - 1 + dz;

                int nx = X[dir];
                int ny = Y[dir];
                int nz = Z[dir];

                for (int c = nx; c < nx + random.nextInt(4) + 1; c++) {
                    for (int d = ny; d < ny + random.nextInt(1) + 2; d++) {
                        for (int e = nz; e < nz + random.nextInt(4) + 1; e++) {
                            BlockPos positionToLook = pos.offset(c, d, e);

                            if (level().getBlockState(positionToLook).isAir() && Math.abs(c - nx) + Math.abs(d - ny) + Math.abs(e - nz) < 4 + random.nextInt(2)) {
                                level().setBlockAndUpdate(positionToLook, ChiselBlocks.CLOUD.getVariant("cloud_normal").get().defaultBlockState());
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return ChiselItems.CLOUD_IN_A_BOTTLE.get();
    }
}
