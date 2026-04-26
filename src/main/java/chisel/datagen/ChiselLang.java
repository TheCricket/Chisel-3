package chisel.datagen;

import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import chisel.util.LangHelper;
import net.minecraft.data.PackOutput;

public class ChiselLang extends LangHelper {

    public ChiselLang(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItems();
        addTabs();

        ChiselBlocks.getBlocks().forEach(block -> block.addTranslations(this));

        add("block.chisel.auto_chisel", "Auto Chisel");
        add("item.chisel.auto_chisel", "Auto Chisel");

        add("container.chisel", "Chisel");
        add("container.auto_chisel", "Auto Chisel");
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
        addItem(ChiselItems.CLOUD_IN_A_BOTTLE, "Cloud in a Bottle");
        addItem(ChiselItems.SMASHING_ROCK, "Smashing Rock");
        addItem(ChiselItems.UPGRADE_AUTOMATION, "Automation Upgrade");
        addItem(ChiselItems.UPGRADE_REVERSION, "Reversion Upgrade");
        addItem(ChiselItems.UPGRADE_SPEED, "Speed Upgrade");
        addItem(ChiselItems.UPGRADE_STACK, "Stack Upgrade");
    }
}