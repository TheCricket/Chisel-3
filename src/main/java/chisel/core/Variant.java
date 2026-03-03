package chisel.core;

import chisel.Chisel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.renderer.block.model.Material;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Variant extends VariantModels {

    private final String name;
    private final Supplier<Block> block;
    private final VariantModelType modelType;
    private final VariantFamily family;

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelType modelType) {
        this.name = name;
        this.block = block;
        this.family = family;
        this.modelType = modelType;
    }

    public String getName() {
        return name;
    }

    public Supplier<Block> getBlock() {
        return block;
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
            case MULTI_LAYER -> registerMultiLayer(this, blockModels);
        }
    }

    public String getTranslationKey() {
        return "%s.desc".formatted(block.get().getDescriptionId());
    }
}
