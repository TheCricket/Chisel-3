package chisel.block.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseTorchBlock;
import org.jspecify.annotations.NonNull;

public class NoParticleTorchBlock extends BaseTorchBlock {

    public static final MapCodec<NoParticleTorchBlock> CODEC = simpleCodec(NoParticleTorchBlock::new);

    public NoParticleTorchBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull MapCodec<? extends BaseTorchBlock> codec() {
        return CODEC;
    }
}
