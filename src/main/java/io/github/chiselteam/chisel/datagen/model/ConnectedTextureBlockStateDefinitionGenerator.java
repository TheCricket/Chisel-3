package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.ctm.api.datagen.CTMBlockStateGenerator;
import io.github.chiselteam.ctm.api.datagen.CTMModelBuilder;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelDispatcher;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public class ConnectedTextureBlockStateDefinitionGenerator implements BlockModelDefinitionGenerator {

    private final Block block;
    private final ConnectedTextureBlockStateModelBuilder builder;

    private ConnectedTextureBlockStateDefinitionGenerator(Block block, ConnectedTextureBlockStateModelBuilder builder) {
        this.block = block;
        this.builder = builder;
    }

    public static ConnectedTextureBlockStateDefinitionGenerator dispatch(Block block, ConnectedTextureBlockStateModelBuilder builder) {
        return new ConnectedTextureBlockStateDefinitionGenerator(block, builder);
    }

    @Override
    public @NonNull Block block() {
        return block;
    }

    @Override
    public @NonNull BlockStateModelDispatcher create() {
        return CTMBlockStateGenerator.of(block, builder.toCTMBuilder()).create();
    }
}
