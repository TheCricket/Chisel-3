package chisel.core;
import chisel.Chisel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.renderer.block.model.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

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

    private Variant(String name, Block block, VariantModelType modelType) {
        this(name, () -> block, null, modelType);
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
            case CUBE_ALL -> registerBlockModel(this, blockModels);
            case PILLAR -> registerPillarModel(this, blockModels);
            case BOOKSHELF -> registerBookshelfModel(this, blockModels);
            case TOP_BOTTOM_SIDE -> registerBTSModel(this, blockModels);
            case TOP_BOTTOM_SIDE_CONNECTED_VERTICALLY -> registerTopBottomSideConnectedVertically(this, blockModels);
            case CONNECTED -> registerConnectedTextureModel(this, blockModels);
            case CONNECTED_VERTICALLY -> registerConnectedTextureVerticalModel(this, blockModels);
            case CONNECTED_HORIZONTALLY -> registerConnectedTextureHorizontalModel(this, blockModels);
            case MULTI_LAYER -> registerMultiLayer(this, blockModels);
            case MULTI_LAYER_WATER -> registerMultiLayer(this, Fluids.WATER, blockModels);
            case MULTI_LAYER_LAVA -> registerMultiLayer(this, Fluids.LAVA, blockModels);
            case CARPET -> registerCarpetModel(this, blockModels);
        }
    }

    public String getTranslationKey() {
        return "%s.desc".formatted(block.get().getDescriptionId());
    }
}
