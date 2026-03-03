package chisel.core;

import chisel.Chisel;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class VariantModels {

    private final ModelTemplate CUBE_MULTI_PASS = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass")), Optional.empty(), TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.PARTICLE);

    protected void registerBlockModel(Variant variant, BlockModelGenerators blockModels) {
        blockModels.createTrivialBlock(
                variant.getBlock().get(),
                TexturedModel.CUBE.updateTexture(
                        map -> map.put(TextureSlot.ALL, variant.getMaterial())
                ));
    }

    protected void registerPillarModel(Variant variant, BlockModelGenerators blockModels) {
        blockModels.createTrivialBlock(
                variant.getBlock().get(),
                TexturedModel.COLUMN.updateTexture(
                        map -> map.put(TextureSlot.SIDE, variant.getMaterial("side")).put(TextureSlot.END, variant.getMaterial("end"))
                ));
    }

    protected void registerBookshelfModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();
        TextureMapping textures = TextureMapping.column(variant.getMaterial(), variant.getMaterial("top"));
        MultiVariant model = plainVariant(ModelTemplates.CUBE_COLUMN.create(block, textures, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(block, model));
    }

    protected void registerBTSModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();
        TextureMapping textures = (new TextureMapping())
                .put(TextureSlot.TOP, variant.getMaterial("top"))
                .put(TextureSlot.BOTTOM, variant.getMaterial("bottom"))
                .put(TextureSlot.SIDE, variant.getMaterial("side"));
        MultiVariant model = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP_INNER_FACES.create(block, textures, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(block, model));
    }

    protected void registerConnectedTextureModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();

        MultiVariant base = plainVariant(TexturedModel.CUBE.create(block, blockModels.modelOutput));
        MultiVariant c1 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c1", getC1Textures(variant), blockModels.modelOutput));
        MultiVariant c2 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c2", getC2Textures(variant), blockModels.modelOutput));
        MultiVariant c2angle = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c2angle", getC2AngleTextures(variant), blockModels.modelOutput));
        MultiVariant c3angle = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c3angle", getC3AngleTextures(variant), blockModels.modelOutput));
        MultiVariant c3t1 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c3t1", getC3t1Textures(variant), blockModels.modelOutput));
        MultiVariant c3t2 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c3t2", getC3t2Textures(variant), blockModels.modelOutput));
        MultiVariant c4angle = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c4angle", getC4AngleTextures(variant), blockModels.modelOutput));
        MultiVariant c4x = plainVariant(TexturedModel.CUBE.updateTexture(map -> map.put(TextureSlot.ALL, variant.getMaterial("news"))).createWithSuffix(block, "_news", blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(block)
                        .with(condition(), base)
                        .with(condition().term(ConnectedTextureBlock.UP, true), c1)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.SOUTH, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.WEST, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true), c2angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.WEST, true), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.WEST, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.SOUTH, true), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true), c2)
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.WEST, true), c3t1)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c3t1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c3t1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c3t2)
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true), c3t2.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c3angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c3angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true), c4x.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true), c4angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x)
        );
    }

    protected void registerTopBottomSideConnectedVertically(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();

        MultiVariant base = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP_INNER_FACES.create(block, (new TextureMapping()).put(TextureSlot.TOP, variant.getMaterial("top")).put(TextureSlot.BOTTOM, variant.getMaterial("bottom")).put(TextureSlot.SIDE, variant.getMaterial("side")), blockModels.modelOutput));
        MultiVariant c1 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c1", getC1Textures(variant).put(TextureSlot.UP, variant.getMaterial("top")).put(TextureSlot.DOWN, variant.getMaterial("bottom")), blockModels.modelOutput));
        MultiVariant c2 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c2", getC2Textures(variant).put(TextureSlot.UP, variant.getMaterial("top")).put(TextureSlot.DOWN, variant.getMaterial("bottom")), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(block)
                        .with(base)
                        .with(condition().term(ConnectedTextureBlock.UP, true), c1)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true), c2)
        );
    }

    protected void registerConnectedTextureVerticalModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();

        MultiVariant base = plainVariant(ModelTemplates.CUBE_ALL.create(block, (new TextureMapping()).put(TextureSlot.ALL, variant.getMaterial()), blockModels.modelOutput));
        MultiVariant c1 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c1", getC1Textures(variant).put(TextureSlot.UP, variant.getMaterial()).put(TextureSlot.DOWN, variant.getMaterial()), blockModels.modelOutput));
        MultiVariant c2 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c2", getC2Textures(variant).put(TextureSlot.UP, variant.getMaterial()).put(TextureSlot.DOWN, variant.getMaterial()), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(block)
                        .with(base)
                        .with(condition().term(ConnectedTextureBlock.UP, true), c1)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true), c2)
        );
    }

    protected void registerConnectedTextureHorizontalModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();

        MultiVariant base = plainVariant(ModelTemplates.CUBE_TOP.create(block, (new TextureMapping()).put(TextureSlot.TOP, variant.getMaterial("top")).put(TextureSlot.BOTTOM, variant.getMaterial("top")).put(TextureSlot.SIDE, variant.getMaterial()), blockModels.modelOutput));
        MultiVariant c1 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c1", getC1Textures(variant).put(TextureSlot.UP, variant.getMaterial("top")).put(TextureSlot.DOWN, variant.getMaterial("top")), blockModels.modelOutput));
        MultiVariant c2 = plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_c2", getC2Textures(variant).put(TextureSlot.UP, variant.getMaterial("top")).put(TextureSlot.DOWN, variant.getMaterial("top")), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(block)
                        .with(base)
                        .with(condition().term(ConnectedTextureBlock.NORTH, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Z_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.SOUTH, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.WEST, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)).with(VariantMutator.Z_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
        );
    }

    protected void registerMultiLayer(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();
        TextureMapping textures = (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.LAYER1, variant.getMaterial("bg"))
                .put(TextureSlot.LAYER0, variant.getMaterial());
        MultiVariant model = plainVariant(CUBE_MULTI_PASS.create(block, textures, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(block, model));
    }

    private TextureMapping getC1Textures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial())
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("u"))
                .put(TextureSlot.SOUTH, variant.getMaterial("u"))
                .put(TextureSlot.WEST, variant.getMaterial("u"))
                .put(TextureSlot.EAST, variant.getMaterial("u"));
    }

    private TextureMapping getC2Textures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("news"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("ns"))
                .put(TextureSlot.SOUTH, variant.getMaterial("ns"))
                .put(TextureSlot.WEST, variant.getMaterial("ns"))
                .put(TextureSlot.EAST, variant.getMaterial("ns"));
    }

    private TextureMapping getC2AngleTextures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("e"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("nw"))
                .put(TextureSlot.SOUTH, variant.getMaterial("ne"))
                .put(TextureSlot.WEST, variant.getMaterial("n"))
                .put(TextureSlot.EAST, variant.getMaterial("news"));
    }

    private TextureMapping getC3AngleTextures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("ne"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("nw"))
                .put(TextureSlot.SOUTH, variant.getMaterial("news"))
                .put(TextureSlot.WEST, variant.getMaterial("ne"))
                .put(TextureSlot.EAST, variant.getMaterial("news"));
    }

    private TextureMapping getC3t1Textures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("news"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("nes"))
                .put(TextureSlot.SOUTH, variant.getMaterial("nws"))
                .put(TextureSlot.WEST, variant.getMaterial("news"))
                .put(TextureSlot.EAST, variant.getMaterial("ns"));
    }

    private TextureMapping getC3t2Textures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("ew"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("new"))
                .put(TextureSlot.SOUTH, variant.getMaterial("new"))
                .put(TextureSlot.WEST, variant.getMaterial("news"))
                .put(TextureSlot.EAST, variant.getMaterial("news"));
    }

    private TextureMapping getC4AngleTextures(Variant variant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("news"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("news"))
                .put(TextureSlot.SOUTH, variant.getMaterial("nws"))
                .put(TextureSlot.WEST, variant.getMaterial("news"))
                .put(TextureSlot.EAST, variant.getMaterial("nes"));
    }
}
