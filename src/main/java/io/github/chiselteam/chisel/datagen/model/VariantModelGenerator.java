package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.chisel.api.family.Variant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;

public abstract class VariantModelGenerator {
    public BlockModelGenerators blockModels;
    public Variant variant;

    public abstract TextureMapping getTextureMapping();

    public void generate(Variant variant, BlockModelGenerators blockModels) {
        this.variant = variant;
        this.blockModels = blockModels;
    }

    protected Block getBlock() {
        return variant.getBlock();
    }
}
