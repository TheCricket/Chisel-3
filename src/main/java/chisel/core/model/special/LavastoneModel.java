package chisel.core.model.special;

import chisel.core.model.MultiLayerModel;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluids;

public class LavastoneModel extends MultiLayerModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.LAYER1, new Material(BuiltInRegistries.FLUID.getKey(Fluids.LAVA.getSource()).withPrefix("block/").withSuffix("_still")))
                .put(TextureSlot.LAYER0, variant.getMaterial());
    }
}
