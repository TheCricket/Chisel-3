package io.github.chiselteam.chisel.core.mode;
import io.github.chiselteam.chisel.registry.ChiselStats;
import io.github.chiselteam.chisel.item.ChiselItem;
import com.mojang.serialization.Codec;
import io.github.chiselteam.chisel.registry.ChiselModes;
import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.datagen.ChiselBlockTags;
import io.github.chiselteam.chisel.registry.ChiselSounds;
import io.github.chiselteam.chisel.util.VariantFinder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChiselMode {

    public static final Codec<ChiselMode> CODEC = Identifier.CODEC.xmap(
            id -> ChiselModes.REGISTRY.getOptional(id).orElseGet(() -> new ChiselMode(id))
            , ChiselMode::registryName
    );

    public static final StreamCodec<ByteBuf, ChiselMode> STREAM_CODEC = Identifier.STREAM_CODEC.map(
            id -> ChiselModes.REGISTRY.getOptional(id).orElseGet(() -> new ChiselMode(id))
            , ChiselMode::registryName
    );

    private final Identifier registryName;

    public ChiselMode(Identifier registryName) {
        this.registryName = registryName;
    }

    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        return Collections.singletonList(pos);
    }

    public Component getDescription() {
        return Component.translatable("chisel.mode.%s".formatted(registryName.getPath()));
    }

    public void onLeftClick(Level level, Player player, InteractionHand hand, BlockPos pos, Direction side, BlockState state, ItemStack chisel) {
        List<BlockPos> affected = getAffectedBlocks(level, player, pos, side, state);
        VariantFamily family = VariantFinder.getFamilyForBlock(state.getBlock(), level.registryAccess());
        if (family == null) return;

        List<Variant> variants = family.getAllVariants(level.registryAccess());
        for (int c = 0; c < variants.size(); c++) {
            if (state.is(variants.get(c).getBlock())) {
                BlockState nextState;
                if (c == variants.size() - 1) {
                    nextState = variants.getFirst().getBlock().defaultBlockState();
                } else {
                    nextState = variants.get(c + 1).getBlock().defaultBlockState();
                }
                for (BlockPos p : affected) {
                    chiselBlock(level, player, hand, p, nextState, chisel);
                }
                break;
            }
        }
    }

    protected void chiselBlock(Level level, Player player, InteractionHand hand, BlockPos pos, BlockState state, ItemStack chisel) {
        level.setBlockAndUpdate(pos, state);
        level.addDestroyBlockEffect(pos, state);
        level.playSound(null, pos, state.is(ChiselBlockTags.WOOD) ? ChiselSounds.WOOD.value() : ChiselSounds.FALLBACK.value(), SoundSource.BLOCKS);
        player.awardStat(ChiselStats.BLOCKS_CHISELED.get());
        ChiselItem.hurtAndBreak(chisel, 1, player, hand);
    }

    protected boolean isSameBlock(Level level, BlockState base, BlockState test) {
        return VariantFinder.getFamilyForBlock(base.getBlock(), level.registryAccess()).isBlockInFamily(test.getBlock());
    }

    @Override
    public @NonNull String toString() {
        return registryName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiselMode that = (ChiselMode) o;
        return registryName.equals(that.registryName);
    }

    public Identifier registryName() {
        return registryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName);
    }
}
