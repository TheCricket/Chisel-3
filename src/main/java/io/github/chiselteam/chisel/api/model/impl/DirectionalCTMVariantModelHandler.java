package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.ctm.api.strategy.CTMKind;

public class DirectionalCTMVariantModelHandler extends AbstractVariantModelHandler {
    private final boolean bookshelf;

    public DirectionalCTMVariantModelHandler(String name, boolean bookshelf) {
        super(name);
        this.bookshelf = bookshelf;
    }

    @Override
    public CTMKind ctmKind() {
        if (bookshelf) {
            return CTMKind.BOOKSHELF;
        }
        return switch (name) {
            case "ctmh" -> CTMKind.CTMH;
            case "ctmv" -> CTMKind.CTMV;
            default -> CTMKind.BOOKSHELF;
        };
    }
}

