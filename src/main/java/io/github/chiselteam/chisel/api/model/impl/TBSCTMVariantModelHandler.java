package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.ctm.api.strategy.CTMKind;

public class TBSCTMVariantModelHandler extends AbstractVariantModelHandler {
    public TBSCTMVariantModelHandler(String name) {
        super(name);
    }

    @Override
    public CTMKind ctmKind() {
        return CTMKind.TBS;
    }
}

