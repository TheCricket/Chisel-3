package io.github.chiselteam.chisel.datagen.model.generator.special.lavastone;

import io.github.chiselteam.chisel.datagen.model.VariantTextures;

import io.github.chiselteam.chisel.datagen.model.generator.ctm.MultiLayerTBSModelGenerator;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluids;

public class LavastoneTBSModelGenerator extends MultiLayerTBSModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant, "side"))
                .put(TextureSlot.TOP, VariantTextures.get(variant, "top"))
                .put(TextureSlot.BOTTOM, VariantTextures.get(variant, "bottom"))
                .put(TextureSlot.SIDE, VariantTextures.get(variant, "side"))
                .put(TextureSlot.LAYER1, VariantTextures.get(variant, "side"))
                .put(TextureSlot.LAYER0, new Material(BuiltInRegistries.FLUID.getKey(Fluids.LAVA.getSource()).withPrefix("block/").withSuffix("_still")));
    }
}
