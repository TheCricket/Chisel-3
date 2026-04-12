package chisel.core.variant;

import chisel.Chisel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Supplier;

import static chisel.core.variant.VariantModelType.*;

public class Variant extends VariantModels {

    public static final Codec<Variant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(Variant::getName),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(Variant::getBlock),
            VariantModelType.CODEC.fieldOf("model_type").forGetter(Variant::getModelType)
    ).apply(instance, (name, block, modelType) -> new Variant(name, () -> block, null, modelType)));

    private static final Set<VariantModelType> MODEL_TYPES = Collections.unmodifiableSet(EnumSet.of(
                    CONNECTED,
                    CONNECTED_TBS,
                    CONNECTED_VERTICALLY,
                    CONNECTED_HORIZONTALLY,
                    MULTI_LAYER_CONNECTED,
                    MULTI_LAYER_CONNECTED_TINTED,
                    MULTI_LAYER_CONNECTED_GLOW,
                    VariantModelType.MULTIBLOCK_2X2,
                    VariantModelType.MULTIBLOCK_3X3,
                    VariantModelType.MULTIBLOCK_4X4
            )
    );

    private final String name;
    private final Supplier<Block> block;
    private final VariantModelType modelType;
    private final boolean shouldGenerateModel;
    public boolean isInTab = true;
    private VariantFamily family;

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelType modelType, boolean shouldGenerateModel) {
        this.name = name;
        this.block = block;
        this.family = family;
        this.modelType = modelType;
        this.shouldGenerateModel = shouldGenerateModel;
    }

    public Variant(Block block, VariantFamily family) {
        this(block.getDescriptionId(), () -> block, family, VariantModelType.CUBE_ALL, false);
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family) {
        this(name, block, family, VariantModelType.CUBE_ALL, true);
    }

    public Variant(String name, Supplier<Block> block, VariantFamily family, VariantModelType modelType) {
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

    public boolean isCTM() {
        return MODEL_TYPES.contains(modelType);
    }

    public VariantModelType getModelType() {
        return modelType;
    }

    public boolean shouldGenerateModel() {
        return shouldGenerateModel;
    }

    public Material getMaterial() {
        return new Material(Chisel.prefix("block/%s/%s".formatted(family.getFamilyName(), name)));
    }

    public Material getMaterial(String suffix) {
        return new Material(Chisel.prefix("block/%s/%s-%s".formatted(family.getFamilyName(), name, suffix)));
    }

    public void registerModel(BlockModelGenerators blockModels) {
        switch (modelType) {
            case CUBE_ALL -> CUBE_ALL.generate(this, blockModels);
            case PILLAR -> PILLAR.generate(this, blockModels);
            case BOOKSHELF -> BOOKSHELF.generate(this, blockModels);
            case TOP_BOTTOM_SIDE -> TOP_BOTTOM_SIDE.generate(this, blockModels);
            case TOP_BOTTOM_SIDE_CONNECTED_VERTICALLY -> TOP_BOTTOM_SIDE_CTMV.generate(this, blockModels);
            case CONNECTED -> CTM.generate(this, blockModels);
            case CONNECTED_TBS -> CTM_TBS.generate(this, blockModels);
            case CONNECTED_VERTICALLY -> CTMV.generate(this, blockModels);
            case CONNECTED_HORIZONTALLY -> CTMH.generate(this, blockModels);
            case MULTI_LAYER -> MULTI_LAYER.generate(this, blockModels);
            case MULTI_LAYER_TBS -> MULTI_LAYER_TBS.generate(this, blockModels);
            case MULTI_LAYER_TBS_TINTED -> MULTI_LAYER_TBS_TINTED.generate(this, blockModels);
            case MULTI_LAYER_WATER -> WATERSTONE.generate(this, blockModels);
            case MULTI_LAYER_LAVA -> LAVASTONE.generate(this, blockModels);
            case MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE -> LAVASTONE_TOP_BOTTOM_SIDE.generate(this, blockModels);
            case MULTI_LAYER_CONNECTED_TINTED -> MULTI_LAYER_CTM_TINTED.generate(this, blockModels);
            case MULTI_LAYER_CONNECTED -> MULTI_LAYER_CTM.generate(this, blockModels);
            case MULTI_LAYER_CONNECTED_GLOW -> MULTI_LAYER_CTM_GLOW.generate(this, blockModels);
            case CARPET -> CARPET.generate(this, blockModels);
            case IRON_BARS -> IRON_BARS.generate(this, blockModels);
            case GLASS_PANE -> GLASS_PANE.generate(this, blockModels);
            case MOSSY -> MOSSY.generate(this, blockModels);
            case MOSSY_TOP_BOTTOM_SIDE -> MOSSY_TOP_BOTTOM_SIDE.generate(this, blockModels);
            case PUMPKIN -> PUMPKIN.generate(this, blockModels);
            case TORCH -> TORCH.generate(this, blockModels);
            case WALL_TORCH -> WALL_TORCH.generate(this, blockModels);
            case ROAD_LINES -> ROAD_LINES.generate(this, blockModels);
            case MULTIBLOCK_2X2 -> MULTIBLOCK_2X2.generate(this, blockModels);
            case MULTIBLOCK_3X3 -> MULTIBLOCK_3X3.generate(this, blockModels);
            case MULTIBLOCK_4X4 -> MULTIBLOCK_4X4.generate(this, blockModels);
        }
    }

    public String getTranslationKey() {
        return "%s.desc".formatted(block.get().getDescriptionId());
    }
}