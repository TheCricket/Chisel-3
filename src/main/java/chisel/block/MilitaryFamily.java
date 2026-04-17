package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MilitaryFamily extends ChiselBlock {
    public MilitaryFamily(BlockBehaviour.Properties props) {
        family = builder("military")
                .addVariant("military_imperial_camo", props, VariantModelType.V4)
                .addVariant("military_imperial_camo_secluded", props, VariantModelType.V4)
                .addVariant("military_imperial_caution_orange", props, VariantModelType.CONNECTED)
                .addVariant("military_imperial_caution_white", props, VariantModelType.CONNECTED)
                .addVariant("military_imperial_plate", props)
                .addVariant("military_rebel_camo", props, VariantModelType.V4)
                .addVariant("military_rebel_camo_secluded", props, VariantModelType.V4)
                .addVariant("military_rebel_caution_red", props, VariantModelType.CONNECTED)
                .addVariant("military_rebel_caution_white", props, VariantModelType.CONNECTED)
                .addVariant("military_rebel_plate", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("military_imperial_camo"), "Military", "Camouflaged");
        lang.addBlock(getVariant("military_imperial_camo_secluded"), "Military", "Camouflaged (Secluded)");
        lang.addBlock(getVariant("military_imperial_caution_orange"), "Military", "Teamed Caution Tape");
        lang.addBlock(getVariant("military_imperial_caution_white"), "Military", "White Caution Tape");
        lang.addBlock(getVariant("military_imperial_plate"), "Military", "Bolted Plate");
        lang.addBlock(getVariant("military_rebel_camo"), "Military", "Camouflaged");
        lang.addBlock(getVariant("military_rebel_camo_secluded"), "Military", "Camouflaged (Secluded)");
        lang.addBlock(getVariant("military_rebel_caution_red"), "Military", "Teamed Caution Tape");
        lang.addBlock(getVariant("military_rebel_caution_white"), "Military", "White Caution Tape");
        lang.addBlock(getVariant("military_rebel_plate"), "Military", "Bolted Plate");
    }
}

