package io.github.chiselteam.chisel.api.family;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VariantFamily {

    public static final Codec<VariantFamily> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("family_name").forGetter(f -> f.familyName),
            Variant.CODEC.listOf().fieldOf("variants").forGetter(f -> f.variants),
            Codec.STRING.optionalFieldOf("recipe_unlocked_by").forGetter(f -> Optional.ofNullable(f.recipeUnlockedBy)),
            TagKey.codec(Registries.BLOCK).optionalFieldOf("tag").forGetter(f -> Optional.ofNullable(f.tag))
    ).apply(instance, (familyName, variants, unlockedBy, tag) -> {
        VariantFamily family = new VariantFamily(familyName);
        unlockedBy.ifPresent(u -> family.recipeUnlockedBy = u);
        tag.ifPresent(t -> family.tag = t);
        for (Variant v : variants) {
            if (v != null) {
                v.setFamily(family);
                family.variants.add(v);
            }
        }
        return family;
    }));

    private final String familyName;
    private final List<Variant> variants = new ArrayList<>();
    private final List<Variant> hiddenVariants = new ArrayList<>();

    private VariantFamily waxedFamily;
    private TagKey<Block> tag;
    private String recipeUnlockedBy;

    public VariantFamily(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<Variant> getVariants() {
        return Collections.unmodifiableList(variants);
    }

    public List<Variant> getHiddenVariants() {
        return Collections.unmodifiableList(hiddenVariants);
    }

    public List<Variant> getAllVariants() {
        List<Variant> all = new ArrayList<>(variants.size() + hiddenVariants.size());
        if (Minecraft.getInstance().level instanceof ClientLevel level) {
            for (var holder : level.registryAccess().lookupOrThrow(Registries.BLOCK).getTagOrEmpty(tag)) {
                all.add(new Variant(holder.value(), this));
            }
        }
        all.addAll(variants);
        all.addAll(hiddenVariants);
        return List.copyOf(all);
    }

    @ApiStatus.Internal
    public void addVariant(Variant variant) {
        variant.setFamily(this);
        variants.add(variant);
    }

    @ApiStatus.Internal
    public void addHiddenVariant(Variant variant) {
        variant.setFamily(this);
        hiddenVariants.add(variant);
    }

    public boolean isBlockInFamily(Block block) {
        return getAllVariants().stream()
                .anyMatch(variant -> variant.getBlock() == block);
    }

    public Variant getVariant(String name) {
        Variant variant = getAllVariants().stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (variant != null) return variant;
        if (waxedFamily != null) return waxedFamily.getVariant(name);

        return null;
    }

    public VariantFamily getWaxedFamily() {
        return waxedFamily;
    }

    @ApiStatus.Internal
    public void setWaxedFamily(VariantFamily waxedFamily) {
        if (waxedFamily == this)
            throw new IllegalArgumentException("Family '" + familyName + "' cannot be its own waxed family");
        this.waxedFamily = waxedFamily;
    }

    public TagKey<Block> getTag() {
        return tag;
    }

    @ApiStatus.Internal
    public void setTag(TagKey<Block> tag) {
        this.tag = tag;
    }

    public String getRecipeUnlockedBy() {
        return recipeUnlockedBy;
    }

    @ApiStatus.Internal
    public void setRecipeUnlockedBy(String recipeUnlockedBy) {
        this.recipeUnlockedBy = recipeUnlockedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariantFamily that = (VariantFamily) o;
        return familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return familyName.hashCode();
    }
}
