package chisel.core.model.ctm;

import chisel.block.ConnectedTextureBlock;
import chisel.core.Variant;
import chisel.core.VariantModel;
import chisel.core.model.ctm.util.C1Model;
import chisel.core.model.ctm.util.C2Model;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;

import static net.minecraft.client.data.models.BlockModelGenerators.condition;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class CTMVTopBottomSide extends VariantModel {

    private final C1Model c1Model = new C1Model();
    private final C2Model c2Model = new C2Model();

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.TOP, variant.getMaterial("top"))
                .put(TextureSlot.BOTTOM, variant.getMaterial("bottom"))
                .put(TextureSlot.SIDE, variant.getMaterial("side"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        c1Model.setVariant(variant);
        c2Model.setVariant(variant);

        MultiVariant base = plainVariant(
                ModelTemplates.CUBE_BOTTOM_TOP_INNER_FACES.create(
                        getBlock(),
                        getTextureMapping(),
                        blockModels.modelOutput
                )
        );

        MultiVariant c1 = c1Model.getModel(
                variant,
                c1Model.getTextureMapping()
                        .put(TextureSlot.UP, variant.getMaterial("top"))
                        .put(TextureSlot.DOWN, variant.getMaterial("bottom")),
                blockModels
        );

        MultiVariant c2 = c2Model.getModel(
                variant,
                c2Model.getTextureMapping()
                        .put(TextureSlot.UP, variant.getMaterial("top"))
                        .put(TextureSlot.DOWN, variant.getMaterial("bottom")),
                blockModels
        );

        blockModels.blockStateOutput.accept(
                MultiPartGenerator
                        .multiPart(getBlock())
                        .with(base)
                        .with(condition().term(ConnectedTextureBlock.UP, true), c1)
                        .with(condition().term(ConnectedTextureBlock.DOWN, true), c1.with(VariantMutator.X_ROT.withValue(Quadrant.R180)))
                        .with(condition().term(ConnectedTextureBlock.UP, true).term(ConnectedTextureBlock.DOWN, true), c2)
        );
    }
}
