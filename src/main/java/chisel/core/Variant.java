package chisel.core;
import chisel.Chisel;
import chisel.registry.VariantModels;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Variant extends VariantModels {

    public static final Codec<Variant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(Variant::getName),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(v -> v.getBlock().get()),
            VariantModelType.CODEC.fieldOf("model_type").forGetter(Variant::getModelType)
    ).apply(instance, (name, block, modelType) -> new Variant(name, () -> block, null, modelType)));

    private final String name;
    private final Supplier<Block> block;
    private final VariantModelType modelType;
    private VariantFamily family;

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelType modelType) {
        this.name = name;
        this.block = block;
        this.family = family;
        this.modelType = modelType;
    }

    public void setFamily(VariantFamily family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public Supplier<Block> getBlock() {
        return block;
    }

    public VariantModelType getModelType() {
        return modelType;
    }

    public Material getMaterial() {
        return new Material(Chisel.prefix("block/%s/%s".formatted(family.getPrefix(), name)));
    }

    public Material getMaterial(String suffix) {
        return new Material(Chisel.prefix("block/%s/%s-%s".formatted(family.getPrefix(), name, suffix)));
    }

    public void registerModel(BlockModelGenerators blockModels) {

        switch (modelType) {
            case CUBE_ALL -> CUBE_ALL.generate(this, blockModels);
            case PILLAR -> PILLAR.generate(this, blockModels);
            case BOOKSHELF -> BOOKSHELF.generate(this, blockModels);
            case TOP_BOTTOM_SIDE -> TOP_BOTTOM_SIDE.generate(this, blockModels);
            case TOP_BOTTOM_SIDE_CONNECTED_VERTICALLY -> TOP_BOTTOM_SIDE_CTMV.generate(this, blockModels);
            case CONNECTED -> CTM.generate(this, blockModels);
            case CONNECTED_VERTICALLY -> CTMV.generate(this, blockModels);
            case CONNECTED_HORIZONTALLY -> CTMH.generate(this, blockModels);
            case MULTI_LAYER -> MULTI_LAYER.generate(this, blockModels);
            case MULTI_LAYER_WATER -> LAVASTONE.generate(this, blockModels);
            case MULTI_LAYER_LAVA -> LAVASTONE.generate(this, blockModels);
            case MULTI_LAYER_CONNECTED -> MULTI_LAYER_CTM.generate(this, blockModels);
            case CARPET -> CARPET.generate(this, blockModels);
            case GLASS_PANE -> GLASS_PANE.generate(this, blockModels);
        }
    }

    public String getTranslationKey() {
        return "%s.desc".formatted(block.get().getDescriptionId());
    }
}
