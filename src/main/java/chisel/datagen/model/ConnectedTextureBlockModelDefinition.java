package chisel.datagen.model;

import chisel.Chisel;
import chisel.client.ctm.UnbakedConnectedTextureBlockStateModel;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.neoforged.neoforge.client.model.block.CustomBlockModelDefinition;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public record ConnectedTextureBlockModelDefinition(UnbakedConnectedTextureBlockStateModel model) implements CustomBlockModelDefinition {
    public static final Identifier ID = Chisel.prefix("ctm_definition_loader");
    public static final MapCodec<ConnectedTextureBlockModelDefinition> CODEC = UnbakedConnectedTextureBlockStateModel.CODEC.xmap(ConnectedTextureBlockModelDefinition::new, ConnectedTextureBlockModelDefinition::model);

    @Override
    public @NonNull Map<BlockState, BlockStateModel.UnbakedRoot> instantiate(StateDefinition<Block, BlockState> states, @NonNull Supplier<String> sourceSupplier) {
        Map<BlockState, BlockStateModel.UnbakedRoot> result = new HashMap<>();
        var unbakedRoot = model.asRoot();
        states.getPossibleStates().forEach(state -> result.put(state, unbakedRoot));

        return result;
    }

    @Override
    public @NonNull MapCodec<? extends CustomBlockModelDefinition> codec() {
        return CODEC;
    }
}
