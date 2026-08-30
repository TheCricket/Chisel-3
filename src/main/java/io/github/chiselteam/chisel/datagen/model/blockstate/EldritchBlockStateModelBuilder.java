package io.github.chiselteam.chisel.datagen.model.blockstate;

import io.github.chiselteam.ctm.client.unbaked.UnbakedEldritchBlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder;
import net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator;
import org.jspecify.annotations.NonNull;

/// Datagen-side builder for [UnbakedEldritchBlockStateModel]. Wraps any
/// inner [BlockStateModel.Unbaked] model with the eldritch UV-perturbation
/// effect.
public class EldritchBlockStateModelBuilder extends CustomBlockStateModelBuilder {

    private BlockStateModel.Unbaked inner;

    public EldritchBlockStateModelBuilder inner(BlockStateModel.Unbaked inner) {
        this.inner = inner;
        return this;
    }

    @Override
    public @NonNull EldritchBlockStateModelBuilder with(@NonNull VariantMutator variantMutator) {
        return this;
    }

    @Override
    public @NonNull EldritchBlockStateModelBuilder with(@NonNull UnbakedMutator unbakedMutator) {
        var result = new EldritchBlockStateModelBuilder();
        result.inner = this.inner;
        return result;
    }

    @Override
    public @NonNull UnbakedEldritchBlockStateModel toUnbaked() {
        return new UnbakedEldritchBlockStateModel(inner);
    }
}

