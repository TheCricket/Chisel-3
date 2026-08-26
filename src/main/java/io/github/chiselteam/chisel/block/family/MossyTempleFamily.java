package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class MossyTempleFamily extends ChiselFamily {
        public MossyTempleFamily(BlockBehaviour.Properties props) {
            family = builder("mossy_temple")
                    .addEldritchVariant("mossy_temple_bricks", props)
                    .addEldritchVariant("mossy_temple_bricks_disarray", props)
                    .addEldritchVariant("mossy_temple_bricks_large", props)
                    .addEldritchVariant("mossy_temple_bricks_worn", props)
                    .addEldritchVariant("mossy_temple_cobble", props)
                    .addEldritchVariant("mossy_temple_column", props, TBS)
                    .addEldritchVariant("mossy_temple_ornate", props)
                    .addEldritchVariant("mossy_temple_plate", props)
                    .addEldritchVariant("mossy_temple_plate_cracked", props)
                    .addEldritchVariant("mossy_temple_stand", props, TBS)
                    .addEldritchVariant("mossy_temple_stand_creeper", props, TBS)
                    .addEldritchVariant("mossy_temple_stand_mosaic", props, TBS)
                    .addEldritchVariant("mossy_temple_tiles", props)
                    .addEldritchVariant("mossy_temple_tiles_light", props)
                    .addEldritchVariant("mossy_temple_tiles_small", props)
                    .addEldritchVariant("mossy_temple_tiles_small_light", props)
                    .family();
        }

        @Override
        public void addTranslations(LangHelper lang) {
            lang.addBlock(getVariant("mossy_temple_bricks"), "Mossy Temple Block", "Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_disarray"), "Mossy Temple Block", "Mossy Temple Bricks in disarray");
            lang.addBlock(getVariant("mossy_temple_bricks_large"), "Mossy Temple Block", "Large Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_worn"), "Mossy Temple Block", "Worn Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_cobble"), "Mossy Temple Block", "Mossy Temple Cobblestone");
            lang.addBlock(getVariant("mossy_temple_column"), "Mossy Temple Block", "Mossy Temple Column");
            lang.addBlock(getVariant("mossy_temple_ornate"), "Mossy Temple Block", "Ornate Mossy Temple Block");
            lang.addBlock(getVariant("mossy_temple_plate"), "Mossy Temple Block", "Mossy Temple Plate");
            lang.addBlock(getVariant("mossy_temple_plate_cracked"), "Mossy Temple Block", "Cracked Mossy Temple Plate");
            lang.addBlock(getVariant("mossy_temple_stand"), "Mossy Temple Block", "Mossy Temple Stand");
            lang.addBlock(getVariant("mossy_temple_stand_creeper"), "Mossy Temple Block", "Mossy Temple Creeper Stand");
            lang.addBlock(getVariant("mossy_temple_stand_mosaic"), "Mossy Temple Block", "Mossy Temple Mosaic Stand");
            lang.addBlock(getVariant("mossy_temple_tiles"), "Mossy Temple Block", "Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_light"), "Mossy Temple Block", "Light Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small"), "Mossy Temple Block", "Small Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small_light"), "Mossy Temple Block", "Small Light Mossy Temple Tiles");
        }
    }