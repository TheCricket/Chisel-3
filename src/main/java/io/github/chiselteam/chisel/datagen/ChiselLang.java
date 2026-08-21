package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselItems;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.data.PackOutput;

public class ChiselLang extends LangHelper {

    public ChiselLang(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItems();
        addTabs();

        ChiselBlocks.getFamilies().forEach(block -> block.addTranslations(this));

        add("item.chisel.chisel.desc1", "Right click to open GUI");
        add("item.chisel.chisel.desc2", "Left click to chisel blocks in the world");
        add("item.chisel.chisel.desc3", "Target a block by leaving it in the Chisel Slot");

        add("item.chisel.offset_tool.desc", "Right click highlighted direction to shift texture");
        add("item.chisel.offset_tool.desc2", "Will only highlight on textures that can be offset");

        add("item.chisel.ball_o_moss.desc", "Right click to throw. Will change a variety of blocks into their mossy counterpart");
        add("item.chisel.cloud_in_a_bottle.desc", "Right click to throw. This will spawn clouds on impact.");
        add("item.chisel.smashing_rock.desc", "Right click to throw. Crushes blocks on impact.");

        add("block.chisel.auto_chisel", "Auto Chisel");
        add("item.chisel.auto_chisel", "Auto Chisel");

        add("block.chisel.builders_guide", "Builders Guide");
        add("item.chisel.builders_guide", "Builders Guide");
        add("chisel.builders_guide.mode_changed", "Changed Mode to");
        add("chisel.builders_guide.size_changed", "Changed Size to");

        addContainer("chisel", "Chisel");
        addContainer("auto_chisel", "Auto Chisel");

        add("chisel.gui.search", "Search:");
        add("chisel.gui.no_variants", "No matching variants");
        add("chisel.search", "Search");

        addPreviewMode("donut", "Donut");
        addPreviewMode("panel", "Panel");
        addPreviewMode("plus", "Plus");
        addPreviewMode("single", "Single");
        addPreviewMode("column", "Column");
        addPreviewMode("row", "Row");

        addChiselMode("single", "Single");
        addChiselMode("panel", "Panel");
        addChiselMode("column", "Column");
        addChiselMode("row", "Row");
        addChiselMode("shapeless", "Shapeless");
        addChiselMode("shapeless_flat", "Shapeless Flat");
        addChiselMode("shapeless_exact", "Shapeless Exact");
        addChiselMode("shapeless_flat_exact", "Shapeless Flat Exact");

        // Builders Guide - Building Modes
        addBuildingMode("cuboid", "Cuboid (Edges)");
        addBuildingMode("full_cuboid", "Cuboid (Faces)");
        addBuildingMode("sphere", "Sphere");
        addBuildingMode("dome", "Dome");
        addBuildingMode("cylinder", "Cylinder");
        addBuildingMode("triangle", "Triangle");
        addBuildingMode("pentagon", "Pentagon");
        addBuildingMode("hexagon", "Hexagon");
        addBuildingMode("octagon", "Octagon");
        addBuildingMode("axes", "Axes");
        addBuildingMode("planes", "Planes");

        add("tooltip.chisel.builders_guide.mode_desc", "Shift + Right click to change Mode");
        add("tooltip.chisel.builders_guide.length_desc", "Right click on North / South side to change Length");
        add("tooltip.chisel.builders_guide.width_desc", "Right click on East / West side to change Width");
        add("tooltip.chisel.builders_guide.height_desc", "Right click on Top / Bottom side to change Height");
        add("tooltip.chisel.builders_guide.place_desc", "Right click with Block to Place in shape");

        add("stat.chisel.blocks_chiseled", "Blocks Chiseled");

        add("config.jade.plugin_chisel.jade_plugin", "Chisel Descriptions");

        add("key.category.chisel.chisel", "Chisel");
        add("key.chisel.mode_select", "Select Chisel Mode");
    }

    private void addTabs() {
        add("itemGroup.tabChisel", "Chisel Items");
        add("itemGroup.tabModdedChiselBlocks", "Modded Chisel Blocks");
        add("itemGroup.tabMetalChiselBlocks", "Metal Chisel Blocks");
        add("itemGroup.tabWoodChiselBlocks", "Wood Chisel Blocks");
        add("itemGroup.tabStoneChiselBlocks", "Stone Chisel Blocks");
        add("itemGroup.tabOtherChiselBlocks", "Other Chisel Blocks");
    }

    private void addItems() {
        addItem(ChiselItems.BALL_O_MOSS, "Ball O' Moss");
        addItem(ChiselItems.CHISEL_DIAMOND, "Diamond Chisel");
        addItem(ChiselItems.CHISEL_IRON, "Chisel");
        addItem(ChiselItems.CHISEL_OBSIDIAN, "Obsidian Chisel");
        addItem(ChiselItems.OFFSET_TOOL, "Ender Offset Wand");
        addItem(ChiselItems.CLOUD_IN_A_BOTTLE, "Cloud in a Bottle");
        addItem(ChiselItems.SMASHING_ROCK, "Smashing Rock");
        addItem(ChiselItems.UPGRADE_AUTOMATION, "Automation Upgrade");
        addItem(ChiselItems.UPGRADE_REVERSION, "Reversion Upgrade");
        addItem(ChiselItems.UPGRADE_SPEED, "Speed Upgrade");
        addItem(ChiselItems.UPGRADE_STACK, "Stack Upgrade");
    }

    private void addBuildingMode(String id, String name) {
        add("chisel.building_mode.chisel:" + id, name);
    }
}
