package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class TempleFamily extends ChiselFamily {
    public TempleFamily(BlockBehaviour.Properties props) {
        family = builder("temple")
                .addEldritchVariant("temple_cobble", props, CONNECTED)
                .addEldritchVariant("temple_bricks", props)
                .addEldritchVariant("temple_bricks_disarray", props)
                .addEldritchVariant("temple_bricks_large", props)
                .addEldritchVariant("temple_bricks_worn", props)
                .addEldritchVariant("temple_column", props, TBS)
                .addEldritchVariant("temple_ornate", props)
                .addEldritchVariant("temple_plate", props)
                .addEldritchVariant("temple_plate_cracked", props)
                .addEldritchVariant("temple_stand", props, TBS)
                .addEldritchVariant("temple_stand_creeper", props, TBS)
                .addEldritchVariant("temple_stand_mosaic", props, TBS)
                .addEldritchVariant("temple_tiles", props)
                .addEldritchVariant("temple_tiles_light", props)
                .addEldritchVariant("temple_tiles_small", props)
                .addEldritchVariant("temple_tiles_small_light", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("temple_bricks"), "Temple Block", "Temple Bricks");
        lang.addBlock(getVariant("temple_bricks_disarray"), "Temple Block", "Temple Bricks in disarray");
        lang.addBlock(getVariant("temple_bricks_large"), "Temple Block", "Large Temple Bricks");
        lang.addBlock(getVariant("temple_bricks_worn"), "Temple Block", "Worn Temple Bricks");
        lang.addBlock(getVariant("temple_cobble"), "Temple Block", "Temple Cobblestone");
        lang.addBlock(getVariant("temple_column"), "Temple Block", "Temple Column");
        lang.addBlock(getVariant("temple_ornate"), "Temple Block", "Ornate Temple Block");
        lang.addBlock(getVariant("temple_plate"), "Temple Block", "Temple Plate");
        lang.addBlock(getVariant("temple_plate_cracked"), "Temple Block", "Cracked Temple Plate");
        lang.addBlock(getVariant("temple_stand"), "Temple Block", "Temple Stand");
        lang.addBlock(getVariant("temple_stand_creeper"), "Temple Block", "Temple Creeper Stand");
        lang.addBlock(getVariant("temple_stand_mosaic"), "Temple Block", "Temple Mosaic Stand");
        lang.addBlock(getVariant("temple_tiles"), "Temple Block", "Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_light"), "Temple Block", "Light Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_small"), "Temple Block", "Small Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_small_light"), "Temple Block", "Small Light Temple Tiles");
    }
}

