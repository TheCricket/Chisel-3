package io.github.chiselteam.chisel.datagen.model.generator.ctm;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.ChiselTextureSlots;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateDefinitionGenerator;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateModelBuilder;
import io.github.chiselteam.ctm.api.datagen.CTMBlockStateGenerator;
import io.github.chiselteam.ctm.api.datagen.CTMModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class MultiLayerCTMModelGenerator extends VariantModelGenerator {

    private final boolean glow;
    private final boolean layered;

    public MultiLayerCTMModelGenerator(boolean glow) {
        this(glow, false);
    }

    public MultiLayerCTMModelGenerator(boolean glow, boolean layered) {
        this.glow = glow;
        this.layered = layered;
    }

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant))
                .put(TextureSlot.ALL, VariantTextures.get(variant))
                .put(TextureSlot.LAYER1, VariantTextures.get(variant))
                .put(TextureSlot.LAYER0, VariantTextures.get(variant, "bg"))
                .put(ChiselTextureSlots.CTM_BASE, VariantTextures.get(variant, "bg"))
                .put(ChiselTextureSlots.CTM_OVERLAY, VariantTextures.get(variant))
                .put(ChiselTextureSlots.CTM_OVERLAY_CONNECTED, VariantTextures.get(variant, "ctm"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        ModelTemplate template = glow ? ChiselModelTemplates.CTM_MULTI_PASS : ChiselModelTemplates.CTM_MULTI_PASS_NO_GLOW;
        Identifier modelLocation = template.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        ConnectedTextureBlockStateModelBuilder builder = new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(true)
                .variant(variant)
                .connectedFace(Direction.UP)
                .connectedFace(Direction.DOWN)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.WEST)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.SOUTH)
                .baseEmissivity(glow ? 15 : 0)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16));

        if (layered) {
            CTMModelBuilder background = builder.toCTMBuilder()
                    .texture("overlay_texture", VariantTextures.get(variant, "bg").sprite())
                    .texture("overlay_connected", VariantTextures.get(variant, "bg-ctm").sprite());
            blockModels.blockStateOutput.accept(CTMBlockStateGenerator.of(
                    variant.getBlock(), CTMModelBuilder.layered(builder.toCTMBuilder(), background)
            ));
        } else {
            blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), builder));
        }
    }
}
