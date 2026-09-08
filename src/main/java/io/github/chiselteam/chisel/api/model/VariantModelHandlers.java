package io.github.chiselteam.chisel.api.model;

import com.mojang.serialization.Codec;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@org.jetbrains.annotations.ApiStatus.Internal
public class VariantModelHandlers {
    private static final Map<String, VariantModelHandler> HANDLERS = new HashMap<>();

    public static final Codec<VariantModelHandler> CODEC = Codec.STRING.xmap(
            name -> HANDLERS.getOrDefault(name, ChiselModelHandlers.CUBE_ALL),
            VariantModelHandler::getSerializedName
    );

    public static void register(VariantModelHandler handler) {
        HANDLERS.put(handler.getSerializedName(), handler);
    }

    public static Optional<VariantModelHandler> get(String name) {
        return Optional.ofNullable(HANDLERS.get(name));
    }
}
