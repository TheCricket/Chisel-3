package chisel.client.model.special;

import chisel.Chisel;
import chisel.client.ChiselModelTemplates;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class BookshelfModel extends VariantModel {
    private final String[] woods = {"_dark_oak", "_pale_oak", "_mangrove", "_spruce", "_jungle", "_acacia", "_cherry", "_bamboo", "_crimson", "_warped", "_birch", "_oak"};

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getBlockMaterial())
                .put(TextureSlot.TOP, getBlockMaterial())
                .put(TextureSlot.BOTTOM, getBlockMaterial())
                .put(TextureSlot.SIDE, getMaterial())
                .put(TextureSlot.LAYER0, getBlockMaterial());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        MultiVariant model = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_NO_GLOW.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(getBlock(), model));
    }
    
    private Material getBlockMaterial() {
        String path = variant.getMaterial().sprite().getPath();
        for(String wood : woods) {
            if(path.contains(wood)) {
                return new Material(Identifier.withDefaultNamespace("block/%s_planks".formatted(wood.substring(1))));
            }
        }

        return new Material(Identifier.withDefaultNamespace("missingno"));
    }

    private Material getMaterial() {
        return new Material(Chisel.prefix(cleanId(variant.getMaterial().sprite().getPath())));
    }

    private String cleanId(String path) {
        String ret = path;
        for(String wood : woods) {
            ret = ret.replace(wood, "");
        }
        return ret;
    }
}
