package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.ctm.api.strategy.CTMKind;

public class CTMVariantModelHandler extends AbstractVariantModelHandler {
    private final boolean fluidOffset;

    public CTMVariantModelHandler(String name) {
        this(name, false);
    }

    public CTMVariantModelHandler(String name, boolean fluidOffset) {
        super(name);
        this.fluidOffset = fluidOffset;
    }

    @Override
    public boolean ctmFluidOffset() {
        return fluidOffset;
    }

    @Override
    public CTMKind ctmKind() {
        return CTMKind.STANDARD;
    }
}

