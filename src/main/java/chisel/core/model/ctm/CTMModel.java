package chisel.core.model.ctm;

import chisel.block.ConnectedTextureBlock;
import chisel.core.Variant;
import chisel.core.VariantModel;
import chisel.core.model.ctm.util.*;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;

import static net.minecraft.client.data.models.BlockModelGenerators.condition;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class CTMModel extends VariantModel {

    private final C1Model c1Model = new C1Model();
    private final C2Model c2Model = new C2Model();
    private final C2AngleModel c2AngleModel = new C2AngleModel();
    private final C3AngleModel c3AngleModel = new C3AngleModel();
    private final C3T1Model c3T1Model = new C3T1Model();
    private final C3T2Model c3T2Model = new C3T2Model();
    private final C4AngleModel c4AngleModel = new C4AngleModel();

    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.cube(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);

        MultiVariant base = plainVariant(TexturedModel.CUBE.create(getBlock(), blockModels.modelOutput));
        MultiVariant c1 = c1Model.getModel(variant, blockModels);
        MultiVariant c2 = c2Model.getModel(variant, blockModels);
        MultiVariant c2angle = c2AngleModel.getModel(variant, blockModels);
        MultiVariant c3angle = c3AngleModel.getModel(variant, blockModels);
        MultiVariant c3t1 = c3T1Model.getModel(variant, blockModels);
        MultiVariant c3t2 = c3T2Model.getModel(variant, blockModels);
        MultiVariant c4angle = c4AngleModel.getModel(variant, blockModels);
        MultiVariant c4x = plainVariant(TexturedModel.CUBE.updateTexture(map -> map.put(TextureSlot.ALL, variant.getMaterial("news"))).createWithSuffix(getBlock(), "_news", blockModels.modelOutput));

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