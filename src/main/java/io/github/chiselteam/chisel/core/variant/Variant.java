package io.github.chiselteam.chisel.core.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.Chisel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CUBE_ALL;

public class Variant {

    public static final Codec<Variant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(Variant::getName),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(Variant::getBlock),
            VariantModelHandlers.CODEC.optionalFieldOf("model_type", CUBE_ALL).forGetter(Variant::getModelType)
    ).apply(instance, (name, block, modelType) -> new Variant(name, () -> block, null, modelType, false)));

    private final String name;
    private final Supplier<Block> block;
    private final VariantModelHandler modelType;
    private final boolean shouldGenerateModel;
    public boolean isInTab = true;
    private boolean eldritch = false;
    private VariantFamily family;

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelHandler modelType, boolean shouldGenerateModel) {
        this.name = name;
        this.block = block;
        this.family = family;
        this.modelType = modelType;
        this.shouldGenerateModel = shouldGenerateModel;
    }

    public Variant(Block block, VariantFamily family) {
        this(block.getDescriptionId(), () -> block, family, CUBE_ALL, false);
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family) {
        this(name, block, family, CUBE_ALL, true);
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelHandler modelType) {
        this(name, block, family, modelType, true);
    }

    public VariantFamily getFamily() {
        return family;
    }

    public void setFamily(VariantFamily family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public Block getBlock() {
        return block.get();
    }

    public VariantModelHandler getModelType() {
        return modelType;
    }

    public VariantModelHandler getModelHandler() {
        return modelType;
    }

    public boolean shouldGenerateModel() {
        return shouldGenerateModel;
    }

    public Material getMaterial() {
        String familyName = family.getFamilyName();
        String nameForTexture = name;
        if (name.startsWith("waxed_")) {
            familyName = family.getFamilyName().substring(6);
            nameForTexture = name.substring(6);
        }
        return new Material(Chisel.prefix("block/%s/%s".formatted(familyName, nameForTexture)));
    }

    public Material getMaterial(String suffix) {
        String familyName = family.getFamilyName();
        String nameForTexture = name;
        if (name.startsWith("waxed_")) {
            familyName = family.getFamilyName().substring(6);
            nameForTexture = name.substring(6);
        }
        return new Material(Chisel.prefix("block/%s/%s-%s".formatted(familyName, nameForTexture, suffix)));
    }

    public void registerModel(BlockModelGenerators blockModels) {
        modelType.generate(this, blockModels);
    }

    public String getTranslationKey() {
        return "%s.desc".formatted(block.get().getDescriptionId());
    }

    public boolean isEldritch() {
        return eldritch;
    }

    public Variant withEldritch() {
        this.eldritch = true;
        return this;
    }
}