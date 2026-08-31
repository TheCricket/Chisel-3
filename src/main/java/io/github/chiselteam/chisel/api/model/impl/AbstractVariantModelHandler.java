package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import org.jspecify.annotations.NonNull;

public abstract class AbstractVariantModelHandler implements VariantModelHandler {
    protected final String name;

    protected AbstractVariantModelHandler(String name) {
        this.name = name;
    }

    @Override
    public @NonNull String getSerializedName() {
        return name;
    }
}