package chisel.core;

import chisel.Chisel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.renderer.block.model.Material;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Variant extends VariantModels {

    private final String name;
    private final Supplier<Block> block;
    public boolean isConnected = false;
    public boolean isPillar = false;
    public boolean isBookshelf = false;
    public boolean isBTS = false;
    private final VariantFamily family;

    public Variant(String name, Supplier<Block> block, VariantFamily family) {
        this.name = name;
        this.block = block;
        this.family = family;
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

    public void registerModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        if(isBTS) {
            registerBTSModel(this, blockModels);
        } else if(isBookshelf) {
            registerBookshelf(this, blockModels);
        } else {
            registerBlockModel(this, blockModels);
        }
    }
}
