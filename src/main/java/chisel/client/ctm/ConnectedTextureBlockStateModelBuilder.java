package chisel.client.ctm;

import chisel.core.variant.Variant;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder;
import net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.HashSet;
import java.util.Set;

public class ConnectedTextureBlockStateModelBuilder extends CustomBlockStateModelBuilder {

    private Identifier modelLocation;
    private Pair<Vector3f, Vector3f> element = Pair.of(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16));
    private final Set<Direction> connectedFaces = new HashSet<>();
    private boolean renderOverlayOnAllFaces = false;
    private Variant variant;
    private int baseTintIndex = -1;
    private int baseEmissivity = 0;
    private int tintIndex = -1;
    private int emissivity = 0;

    @Override
    public @NonNull ConnectedTextureBlockStateModelBuilder with(@NonNull VariantMutator variantMutator) {
        return this;
    }

    @Override
    public @NonNull ConnectedTextureBlockStateModelBuilder with(@NonNull UnbakedMutator unbakedMutator) {
        var result = new ConnectedTextureBlockStateModelBuilder();

        result.modelLocation = this.modelLocation;
        result.element = this.element;
        result.connectedFaces.addAll(this.connectedFaces);
        result.renderOverlayOnAllFaces = this.renderOverlayOnAllFaces;
        result.variant = this.variant;
        result.baseTintIndex = this.baseTintIndex;
        result.baseEmissivity = this.baseEmissivity;
        result.tintIndex = this.tintIndex;
        result.emissivity = this.emissivity;

        return result;
    }

    public ConnectedTextureBlockStateModelBuilder modelLocation(Identifier modelLocation) {
        this.modelLocation = modelLocation;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder element(Vector3f min, Vector3f max) {
        this.element = Pair.of(min, max);
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder connectedFace(Direction direction) {
        this.connectedFaces.add(direction);
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder renderOverlayOnAllFaces(boolean renderOverlayOnAllFaces) {
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder variant(Variant variant) {
        this.variant = variant;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder baseTintIndex(int baseTintIndex) {
        this.baseTintIndex = baseTintIndex;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder baseEmissivity(int baseEmissivity) {
        this.baseEmissivity = baseEmissivity;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder tintIndex(int tintIndex) {
        this.tintIndex = tintIndex;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder emissivity(int emissivity) {
        this.emissivity = emissivity;
        return this;
    }

    @Override
    public @NonNull UnbakedConnectedTextureBlockStateModel toUnbaked() {
        return new UnbakedConnectedTextureBlockStateModel(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
    }
}
