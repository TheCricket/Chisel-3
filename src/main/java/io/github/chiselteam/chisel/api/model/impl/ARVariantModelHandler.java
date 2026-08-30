package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.ctm.api.strategy.CTMKind;

public class ARVariantModelHandler extends AbstractVariantModelHandler {
    private final boolean fluidOffset;

    public ARVariantModelHandler(String name) {
        this(name, false);
    }

    public ARVariantModelHandler(String name, boolean fluidOffset) {
        super(name);
        this.fluidOffset = fluidOffset;
    }

    @Override
    public boolean ctmFluidOffset() {
        return fluidOffset;
    }

    @Override
    public CTMKind ctmKind() {
        return CTMKind.AR;
    }
}

