package io.github.chiselteam.chisel.api.model.impl;

import io.github.chiselteam.ctm.api.strategy.CTMKind;

public class MultiblockCTMVariantModelHandler extends AbstractVariantModelHandler {
    private final boolean random;
    private final int size;
    private final boolean fluidLayer;

    public MultiblockCTMVariantModelHandler(String name, boolean random, int size, boolean fluidLayer) {
        super(name);
        this.random = random;
        this.size = size;
        this.fluidLayer = fluidLayer;
    }

    @Override
    public boolean usesRandomTexture() {
        return random;
    }

    @Override
    public int multiblockSize() {
        return size;
    }

    @Override
    public boolean ctmFluidOffset() {
        return fluidLayer;
    }

    @Override
    public CTMKind ctmKind() {
        // Names like "v4", "v9", "v16", "r4", "r9", "r16" map directly.
        return switch (name) {
            case "v4" -> CTMKind.V4;
            case "v9" -> CTMKind.V9;
            case "v16" -> CTMKind.V16;
            case "r4" -> CTMKind.R4;
            case "r9" -> CTMKind.R9;
            case "r16" -> CTMKind.R16;
            default -> switch (size) {
                case 2 -> CTMKind.MULTIBLOCK_2X2;
                case 3 -> CTMKind.MULTIBLOCK_3X3;
                case 4 -> CTMKind.MULTIBLOCK_4X4;
                default -> throw new IllegalStateException("Unexpected multiblock size: " + size);
            };
        };
    }
}