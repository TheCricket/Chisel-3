package chisel.api;

import chisel.Chisel;
import net.minecraft.client.renderer.block.model.Material;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class Variant {

    private final String name;
    private final Supplier<Block> block;
    private final boolean canConnect;

    public Variant(String name, Supplier<Block> block, boolean canConnect) {
        this.name = name;
        this.block = block;
        this.canConnect = canConnect;
    }

    public String getName() {
        return name;
    }

    public boolean hasConnectedTextures() {
        return canConnect;
    }

    public Supplier<Block> getBlock() {
        return block;
    }

    public Material getMaterial(VariantFamily family) {
        return new Material(Chisel.prefix("block/%s/%s".formatted(family.getPrefix(), name)));
    }
}
