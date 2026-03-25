package chisel.core.model.ctm;

import chisel.block.ConnectedTextureBlock;
import chisel.client.ChiselTextureSlots;
import chisel.core.Variant;
import chisel.core.VariantModel;
import chisel.client.ChiselModelTemplates;
import chisel.core.model.ctm.util.*;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;

import static net.minecraft.client.data.models.BlockModelGenerators.condition;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class MultiLayerCTMModel extends VariantModel {
    private final C1Model c1Model = new C1Model();
    private final C2Model c2Model = new C2Model();
    private final C2AngleModel c2AngleModel = new C2AngleModel();
    private final C3AngleModel c3AngleModel = new C3AngleModel();
    private final C3T1Model c3T1Model = new C3T1Model();
    private final C3T2Model c3T2Model = new C3T2Model();
    private final C4AngleModel c4AngleModel = new C4AngleModel();

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(ChiselTextureSlots.CTM_BASE, variant.getMaterial("bg"))
                .put(ChiselTextureSlots.CTM_OVERLAY, variant.getMaterial())
                .put(ChiselTextureSlots.CTM_OVERLAY_CONNECTED, variant.getMaterial("ctm"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        c1Model.setVariant(variant);
        c2Model.setVariant(variant);
        c2AngleModel.setVariant(variant);
        c3AngleModel.setVariant(variant);
        c3T1Model.setVariant(variant);
        c3T2Model.setVariant(variant);
        c4AngleModel.setVariant(variant);

        MultiVariant base = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS.create(getBlock(), getTextureMapping().put(TextureSlot.LAYER0, variant.getMaterial()), blockModels.modelOutput));
        MultiVariant c1 = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c1", c1Model.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c2 = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c2", c2Model.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c2angle = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c2angle", c2AngleModel.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c3angle = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c3angle", c3AngleModel.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c3t1 = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c3t1", c3T1Model.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c3t2 = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c3t2", c3T2Model.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")).put(TextureSlot.PARTICLE, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c4angle = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_CONNECTED.createWithSuffix(getBlock(), "_c4angle", c4AngleModel.getTextureMapping().put(TextureSlot.LAYER1, variant.getMaterial("bg")), blockModels.modelOutput));
        MultiVariant c4x = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS.createWithSuffix(getBlock(), "_news", getTextureMapping().put(TextureSlot.LAYER0, variant.getMaterial("news")), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(getBlock())
                        .with(condition().term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), base)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c1)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c2angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false), c2angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c2)
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.SOUTH, false), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c3t1)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c3t1.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false), c3t1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.WEST, false), c3t1.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.SOUTH, false), c3t2)
                        .with(condition().term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.SOUTH, false), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.SOUTH, false), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c3t2.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c3t2.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false), c3angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false), c3angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c3angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.SOUTH, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false).term(ConnectedTextureBlock.DOWN, false), c4x.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.WEST, false), c4x.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.EAST, false).term(ConnectedTextureBlock.SOUTH, false), c4angle)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.EAST, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.EAST, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.EAST, false), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, false).term(ConnectedTextureBlock.SOUTH, false), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.NORTH, false).term(ConnectedTextureBlock.WEST, false), c4angle.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.WEST, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R90)).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.NORTH, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.NORTH, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.DOWN, false).term(ConnectedTextureBlock.SOUTH, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R270)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.SOUTH, false), c4angle.with(VariantMutator.X_ROT.withValue(Quadrant.R180)).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))

                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.NORTH, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.EAST, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.SOUTH, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true).term(ConnectedTextureBlock.UP, false), c4x)
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true).term(ConnectedTextureBlock.NORTH, true).term(ConnectedTextureBlock.EAST, true).term(ConnectedTextureBlock.SOUTH, true).term(ConnectedTextureBlock.WEST, true), c4x)
        );
    }
}
