package io.github.chiselteam.chisel.api.model;

import io.github.chiselteam.ctm.api.strategy.CTMKind;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public interface VariantModelHandler extends StringRepresentable {
    @Override
    @NonNull String getSerializedName();

    /**
     * Side length of the multiblock tiling for multiblock-CTM handlers (2/3/4), or 0 otherwise.
     */
    default int multiblockSize() {
        return 0;
    }

    /**
     * Whether this handler is one of the random-tile multiblock CTM variants (R4/R9/R16).
     */
    default boolean usesRandomTexture() {
        return false;
    }

    /**
     * The CTM shape this handler maps to, or {@code null} if this handler is not a connected-texture handler.
     */
    default @Nullable CTMKind ctmKind() {
        return null;
    }

    /**
     * Whether the CTM-library multiblock overlay should be nudged outward (used by the waterstone-style overlays).
     */
    default boolean ctmFluidOffset() {
        return false;
    }

    default String name() {
        return getSerializedName();
    }
}

