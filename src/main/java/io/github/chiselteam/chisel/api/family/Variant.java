package io.github.chiselteam.chisel.api.family;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import io.github.chiselteam.chisel.api.model.VariantModelHandlers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Supplier;

import static io.github.chiselteam.chisel.api.model.ChiselModelHandlers.CUBE_ALL;

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

    private VariantFamily family;
    private Variant dropsAs;

    private boolean inTab = true;
    private boolean eldritch = false;

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelHandler modelType, boolean shouldGenerateModel) {
        this.name = name;
        this.block = block;
        this.family = family;
        this.modelType = modelType;
        this.shouldGenerateModel = shouldGenerateModel;
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelHandler modelType) {
        this(name, block, family, modelType, true);
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family) {
        this(name, block, family, CUBE_ALL, true);
    }

    public Variant(Block block, VariantFamily family) {
        this(block.getDescriptionId(), () -> block, family, CUBE_ALL, false);
    }

    public String getName() {
        return name;
    }

    public Block getBlock() {
        return block.get();
    }

    public VariantFamily getFamily() {
        return family;
    }

    @ApiStatus.Internal
    public void setFamily(VariantFamily family) {
        this.family = family;
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

    public boolean isInTab() {
        return inTab;
    }

    @ApiStatus.Internal
    public Variant setInTab(boolean inTab) {
        this.inTab = inTab;
        return this;
    }

    public boolean isEldritch() {
        return eldritch;
    }

    @ApiStatus.Internal
    public void withEldritch() {
        eldritch = true;
    }

    public Variant getDropsAs() {
        return dropsAs;
    }

    @ApiStatus.Internal
    public Variant dropsAs(Variant variant) {
        dropsAs = variant;
        return this;
    }

    public String getTranslationKey() {
        return getBlock().getDescriptionId();
    }

    public String getDescriptionKey() {
        return "%s.desc".formatted(getBlock().getDescriptionId());
    }
}
