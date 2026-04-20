package chisel.block.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jspecify.annotations.NonNull;

public class SparklyConnectedTextureBlock extends ConnectedTextureBlock{

    private final DeferredHolder<ParticleType<?>, SimpleParticleType> particle;

    public SparklyConnectedTextureBlock(Properties properties, DeferredHolder<ParticleType<?>, SimpleParticleType> particle) {
        super(properties);
        this.particle = particle;
    }

    @Override
    public void animateTick(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull RandomSource random) {
        super.animateTick(state, level, pos, random);

        if(random.nextInt(4) == 0) {

            float f = 0.15F;
            AABB bounds = state.getShape(level, pos).bounds();

            double x = pos.getX() + random.nextDouble() * (bounds.maxX - bounds.minX - f * 2.0F) + f + bounds.minX;
            double y = pos.getY() + random.nextDouble() * (bounds.maxY - bounds.minY - f * 2.0F) + f + bounds.minY;
            double z = pos.getZ() + random.nextDouble() * (bounds.maxZ - bounds.minZ - f * 2.0F) + f + bounds.minZ;

            int dx = 0;
            int dy = 0;
            int dz = 0;

            switch (random.nextInt(6)) {
                case 0:
                    y = pos.getY() + bounds.minY - f;
                    dy = -1;
                    break;
                case 1:
                    y = pos.getY() + bounds.maxY + f;
                    dy = 1;
                    break;
                case 2:
                    z = pos.getZ() + bounds.minZ - f;
                    dz = -1;
                    break;
                case 3:
                    z = pos.getZ() + bounds.maxZ + f;
                    dz = 1;
                    break;
                case 4:
                    x = pos.getX() + bounds.minX - f;
                    dx = -1;
                    break;
                case 5:
                    x = pos.getX() + bounds.maxX + f;
                    dx = 1;
                    break;
            }

            if (level.getBlockState(pos.offset(dx, dy, dz)).isSolidRender()) {
                return;
            }

            level.addParticle(particle.get(), x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}
