package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class PackedIcePillarBlock extends ChiselBlock {
    public PackedIcePillarBlock(BlockBehaviour.Properties props) {
        

        family = builder("packed_ice_pillar")
                .addVariant("packed_ice_pillar_array", props)
                .addVariant("packed_ice_pillar_braid", props)
                .addVariant("packed_ice_pillar_chaotic", props)
                .addVariant("packed_ice_pillar_circular", props)
                .addVariant("packed_ice_pillar_cuts", props)
                .addVariant("packed_ice_pillar_dent", props)
                .addVariant("packed_ice_pillar_french", props)
                .addVariant("packed_ice_pillar_french_2", props)
                .addVariant("packed_ice_pillar_layers", props)
                .addVariant("packed_ice_pillar_ornate", props)
                .addVariant("packed_ice_pillar_panel", props)
                .addVariant("packed_ice_pillar_road", props)
                .addVariant("packed_ice_pillar_tiles", props)
                .addVariant("packed_ice_pillar_weaver", props)
                .addVariant("packed_ice_pillar_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("packed_ice_pillar_array"), "Packed Ice Pillar", "Array");
        lang.addBlock(getVariant("packed_ice_pillar_braid"), "Packed Ice Pillar", "Braid");
        lang.addBlock(getVariant("packed_ice_pillar_chaotic"), "Packed Ice Pillar", "Chaotic");
        lang.addBlock(getVariant("packed_ice_pillar_circular"), "Packed Ice Pillar", "Circular");
        lang.addBlock(getVariant("packed_ice_pillar_cuts"), "Packed Ice Pillar", "Cuts");
        lang.addBlock(getVariant("packed_ice_pillar_dent"), "Packed Ice Pillar", "Dent");
        lang.addBlock(getVariant("packed_ice_pillar_french"), "Packed Ice Pillar", "French");
        lang.addBlock(getVariant("packed_ice_pillar_french_2"), "Packed Ice Pillar", "French 2");
        lang.addBlock(getVariant("packed_ice_pillar_layers"), "Packed Ice Pillar", "Layers");
        lang.addBlock(getVariant("packed_ice_pillar_ornate"), "Packed Ice Pillar", "Ornate");
        lang.addBlock(getVariant("packed_ice_pillar_panel"), "Packed Ice Pillar", "Panel");
        lang.addBlock(getVariant("packed_ice_pillar_road"), "Packed Ice Pillar", "Road");
        lang.addBlock(getVariant("packed_ice_pillar_tiles"), "Packed Ice Pillar", "Tiles");
        lang.addBlock(getVariant("packed_ice_pillar_weaver"), "Packed Ice Pillar", "Weaver");
        lang.addBlock(getVariant("packed_ice_pillar_zag"), "Packed Ice Pillar", "Zag");
    }
}

