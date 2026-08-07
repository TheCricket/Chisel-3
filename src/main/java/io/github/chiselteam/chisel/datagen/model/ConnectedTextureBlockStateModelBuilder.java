package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.datagen.model.predicates.CopperConnectionPredicates;
import io.github.chiselteam.ctm.api.datagen.CTMModelBuilder;
import io.github.chiselteam.ctm.api.strategy.CTMKind;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

import java.util.HashSet;
import java.util.Set;

public class ConnectedTextureBlockStateModelBuilder {

    private Identifier modelLocation;
    private final Set<Direction> connectedFaces = new HashSet<>();
    private boolean renderOverlayOnAllFaces;
    private Variant variant;
    private int baseTintIndex = -1;
    private int baseEmissivity;
    private int tintIndex = -1;
    private int emissivity;
    private boolean eldritch;
    private Vector3f elementMin = new Vector3f(0, 0, 0);
    private Vector3f elementMax = new Vector3f(16, 16, 16);

    public ConnectedTextureBlockStateModelBuilder modelLocation(Identifier modelLocation) {
        this.modelLocation = modelLocation;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder element(Vector3f min, Vector3f max) {
        this.elementMin = min;
        this.elementMax = max;
        return this;
    }

    public ConnectedTextureBlockStateModelBuilder connectedFace(Direction direction) {
        connectedFaces.add(direction);
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

    public ConnectedTextureBlockStateModelBuilder eldritch(boolean eldritch) {
        this.eldritch = eldritch;
        return this;
    }

    public CTMModelBuilder toCTMBuilder() {
        CTMKind kind = variant.getModelHandler().ctmKind();
        if (kind == null) throw new IllegalStateException("Variant %s is not a connected-texture variant".formatted(variant.getName()));

        CTMModelBuilder builder = CTMModelBuilder.of(variant.getBlock(), kind, modelLocation)
                .element(elementMin, elementMax)
                .renderOverlayOnAllFaces(renderOverlayOnAllFaces)
                .baseTintIndex(baseTintIndex)
                .baseEmissivity(baseEmissivity)
                .tintIndex(tintIndex)
                .emissivity(emissivity)
                .eldritch(eldritch)
                .waterOffset(variant.getModelHandler().ctmFluidOffset())
                .connectionPredicate(CopperConnectionPredicates.forVariant(variant));

        connectedFaces.forEach(builder::connectedFace);
        return builder;
    }
}