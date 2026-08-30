package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.Variant;
import net.minecraft.client.resources.model.sprite.Material;

public final class VariantTextures {

    private VariantTextures() {
    }

    public static Material get(Variant variant) {
        return new Material(Chisel.prefix(getTexturePath(variant)));
    }

    public static Material get(Variant variant, String suffix) {
        return new Material(Chisel.prefix("%s-%s".formatted(getTexturePath(variant), suffix)));
    }

    public static String getTexturePath(Variant variant) {
        var familyName = variant.getFamily().getFamilyName();
        var variantName = variant.getName();

        if (variantName.startsWith("waxed_")) {
            familyName = familyName.substring(6);
            variantName = variantName.substring(6);
        }

        return "block/%s/%s".formatted(familyName, variantName);
    }
}
