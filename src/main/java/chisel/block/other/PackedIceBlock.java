package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PackedIceBlock extends ChiselBlock {
    public PackedIceBlock(BlockBehaviour.Properties props) {
        

        family = builder("packed_ice")
                .addVariant(Blocks.PACKED_ICE)
                .addVariant("packed_ice_array", props)
                .addVariant("packed_ice_braid", props)
                .addVariant("packed_ice_chaotic", props)
                .addVariant("packed_ice_circular", props)
                .addVariant("packed_ice_cuts", props)
                .addVariant("packed_ice_dent", props)
                .addVariant("packed_ice_french", props)
                .addVariant("packed_ice_french_2", props)
                .addVariant("packed_ice_layers", props)
                .addVariant("packed_ice_ornate", props)
                .addVariant("packed_ice_panel", props)
                .addVariant("packed_ice_road", props)
                .addVariant("packed_ice_tiles", props)
                .addVariant("packed_ice_weaver", props)
                .addVariant("packed_ice_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("packed_ice_array"), "Packed Ice", "Array");
        lang.addBlock(getVariant("packed_ice_braid"), "Packed Ice", "Braid");
        lang.addBlock(getVariant("packed_ice_chaotic"), "Packed Ice", "Chaotic");
        lang.addBlock(getVariant("packed_ice_circular"), "Packed Ice", "Circular");
        lang.addBlock(getVariant("packed_ice_cuts"), "Packed Ice", "Cuts");
        lang.addBlock(getVariant("packed_ice_dent"), "Packed Ice", "Dent");
        lang.addBlock(getVariant("packed_ice_french"), "Packed Ice", "French");
        lang.addBlock(getVariant("packed_ice_french_2"), "Packed Ice", "French 2");
        lang.addBlock(getVariant("packed_ice_layers"), "Packed Ice", "Layers");
        lang.addBlock(getVariant("packed_ice_ornate"), "Packed Ice", "Ornate");
        lang.addBlock(getVariant("packed_ice_panel"), "Packed Ice", "Panel");
        lang.addBlock(getVariant("packed_ice_road"), "Packed Ice", "Road");
        lang.addBlock(getVariant("packed_ice_tiles"), "Packed Ice", "Tiles");
        lang.addBlock(getVariant("packed_ice_weaver"), "Packed Ice", "Weaver");
        lang.addBlock(getVariant("packed_ice_zag"), "Packed Ice", "Zag");
    }
}

