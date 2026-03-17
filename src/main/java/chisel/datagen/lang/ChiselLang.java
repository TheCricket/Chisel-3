package chisel.datagen.lang;

import chisel.registry.ChiselItems;
import chisel.registry.blocks.*;
import chisel.util.LangHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public class ChiselLang extends LangHelper {

    public ChiselLang(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItems();
        addVariantFamilies();
        addTabs();
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

    private void addVariantFamilies() {
        addAcacia();
        addAluminum();
        addAndesite();
        addAntiblock();
        addBirch();
        addBookshelf();
        addBricks();
        addBronze();
        addCarpet();
        addCarpetFloor();
        addCloud();
        addCobblestone();
        addConcrete();
        addCopper();
        addDarkOak();
        addDiamond();
        addDiorite();
        addDirt();
        addEmerald();
        addEnergizedVoidstone();
        addEnergizedVoidstonePillar();
        addFactory();
        addFutura();
        addGlass();
        addlGlass();
        addGlassPane();
        addGlowstone();
        addGold();
        addGranite();
        addGrimstone();
        addHexPlating();
        addHolystone();
        addIce();
        addIron();
        addIronBars();
        addJungle();
        addLaboratory();
        addLapis();
        addLargeHexPlating();
        addLavastone();
        addLead();
        addLeaf();
        addLimestone();
        addLitPumpkin();
        addMarble();
        addMossyCobblestone();
        addMossyTemple();
        addNetherbrick();
        addNetherrack();
        addOak();
        addObsidian();
        addPackedIce();
        addPackedIcePillar();
        addPaperwall();
        addPaperwallBlock();
        addPumpkin();
        addRedstone();
        addRoadLine();
        addRunicVoidstone();
        addSandstone();
        addSilver();
        addSpruce();
        addSnakestoneSand();
        addSnakestoneStone();
        addStainedGlassBlack();
        addStainedGlassBlue();
        addStainedGlassBrown();
        addStainedGlassCyan();
        addStainedGlassGray();
        addStainedGlassGreen();
        addStainedGlassLightBlue();
        addStainedGlassLightGray();
        addStainedGlassLime();
        addStainedGlassMagenta();
        addStainedGlassOrange();
        addStainedGlassPink();
        addStainedGlassPurple();
        addStainedGlassRed();
        addStainedGlassWhite();
        addStainedGlassYellow();
        addStainedGlassPaneBlack();
        addStainedGlassPaneBlue();
        addStainedGlassPaneBrown();
        addStainedGlassPaneCyan();
        addStainedGlassPaneGray();
        addStainedGlassPaneGreen();
        addStainedGlassPaneLightBlue();
        addStainedGlassPaneLightGray();
        addStainedGlassPaneLime();
        addStainedGlassPaneMagenta();
        addStainedGlassPaneOrange();
        addStainedGlassPanePink();
        addStainedGlassPanePurple();
        addStainedGlassPaneRed();
        addStainedGlassPaneWhite();
        addStainedGlassPaneYellow();
        addSteel();
        addStoneBricks();
        addTechnical();
        addTemple();
        addTin();
        addTorch();
        addTyrian();
        addUranium();
        addValentines();
        addVoidstone();
        addWarning();
        addWaterstone();
        addWoolenClay();
    }

    private void addAcacia() {
        addBlock(() -> Blocks.ACACIA_PLANKS, "Acacia Wood Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_BRACED, "Acacia Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_BRAID, "Acacia Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_CRUDE_HORIZONTAL, "Acacia Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_CRUDE_PANELING, "Acacia Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_CRUDE_VERTICAL, "Acacia Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_ENCASED, "Acacia Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_ENCASED_LARGE, "Acacia Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_ENCASED_SMOOTH, "Acacia Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_LARGE, "Acacia Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_LOG_CABIN, "Acacia Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_PANELING, "Acacia Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_SHIPPING, "Acacia Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_SMOOTH, "Acacia Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_STACKED, "Acacia Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.ACACIA_PLANKS_VERTICAL, "Acacia Wood Planks", "Vertical Planks");
    }

    private void addAluminum() {
        addBlock(ChiselMetalBlocks.ALUMINUM_BAD_GREGGY, "Aluminum", "Egregious");
        addBlock(ChiselMetalBlocks.ALUMINUM_BOLTED, "Aluminum", "Bolted");
        addBlock(ChiselMetalBlocks.ALUMINUM_CAUTION, "Aluminum", "Caution Stripes");
        addBlock(ChiselMetalBlocks.ALUMINUM_CRATE, "Aluminum", "Shipping Crate");
        addBlock(ChiselMetalBlocks.ALUMINUM_MACHINE, "Aluminum", "An Old Relic From The Land Of OneTeuFyv");
        addBlock(ChiselMetalBlocks.ALUMINUM_SCAFFOLD, "Aluminum", "Scaffold");
        addBlock(ChiselMetalBlocks.ALUMINUM_THERMAL, "Aluminum", "Thermal Series");
    }

    private void addAndesite() {
        addBlock(() -> Blocks.ANDESITE, "Andesite");
        addBlock(ChiselStoneBlocks.ANDESITE_ARRAY, "Andesite", "Array");
        addBlock(ChiselStoneBlocks.ANDESITE_BRAID, "Andesite", "Braid");
        addBlock(ChiselStoneBlocks.ANDESITE_CHAOTIC_BRICKS, "Andesite", "Trodden Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_CHAOTIC_MEDIUM, "Andesite", "Disordered Tiles");
        addBlock(ChiselStoneBlocks.ANDESITE_CHAOTIC_SMALL, "Andesite", "Small Disordered Tiles");
        addBlock(ChiselStoneBlocks.ANDESITE_CIRCULAR, "Andesite", "Circular");
        addBlock(ChiselStoneBlocks.ANDESITE_CRACKED, "Andesite", "Cracked");
        addBlock(ChiselStoneBlocks.ANDESITE_CRACKED_BRICKS, "Andesite", "Cracked Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_CUTS, "Andesite", "Cuts");
        addBlock(ChiselStoneBlocks.ANDESITE_DENT, "Andesite", "Dent");
        addBlock(ChiselStoneBlocks.ANDESITE_ENCASED_BRICKS, "Andesite", "Encased Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_FRENCH_1, "Andesite", "French 1");
        addBlock(ChiselStoneBlocks.ANDESITE_FRENCH_2, "Andesite", "French 2");
        addBlock(ChiselStoneBlocks.ANDESITE_JELLYBEAN, "Andesite", "Array");
        addBlock(ChiselStoneBlocks.ANDESITE_LAYERS, "Andesite", "Layers");
        addBlock(ChiselStoneBlocks.ANDESITE_MOSAIC, "Andesite", "Mosaic");
        addBlock(ChiselStoneBlocks.ANDESITE_ORNATE, "Andesite", "Ornate");
        addBlock(ChiselStoneBlocks.ANDESITE_PANEL, "Andesite", "Panel");
        addBlock(ChiselStoneBlocks.ANDESITE_PILLAR, "Andesite", "Pillar");
        addBlock(ChiselStoneBlocks.ANDESITE_PRISM, "Andesite", "Prism");
        addBlock(ChiselStoneBlocks.ANDESITE_ROAD, "Andesite", "Road");
        addBlock(ChiselStoneBlocks.ANDESITE_SLANTED, "Andesite", "Slanted");
        addBlock(ChiselStoneBlocks.ANDESITE_SMALL_BRICKS, "Andesite", "Small Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_SOFT_BRICKS, "Andesite", "Weathered Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_SOLID_BRICKS, "Andesite", "Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_TILES_LARGE, "Andesite", "Big Tile");
        addBlock(ChiselStoneBlocks.ANDESITE_TILES_MEDIUM, "Andesite", "Tiles");
        addBlock(ChiselStoneBlocks.ANDESITE_TILES_SMALL, "Andesite", "Small Tiles");
        addBlock(ChiselStoneBlocks.ANDESITE_TRIPLE_BRICKS, "Andesite", "Wide Bricks");
        addBlock(ChiselStoneBlocks.ANDESITE_TWISTED, "Andesite", "Twisted");
        addBlock(ChiselStoneBlocks.ANDESITE_WEAVER, "Andesite", "Celtic");
        addBlock(ChiselStoneBlocks.ANDESITE_ZAG, "Andesite", "Zag");
    }

    private void addAntiblock() {
        addBlock(ChiselOtherBlocks.ANTIBLOCK_BLACK, "Anti Block", "Black");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_BLUE, "Anti Block", "Blue");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_BROWN, "Anti Block", "Brown");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_CYAN, "Anti Block", "Cyan");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_GRAY, "Anti Block", "Gray");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_GREEN, "Anti Block", "Green");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_LIGHT_BLUE, "Anti Block", "Light Gray");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_LIGHT_GRAY, "Anti Block", "Light Gray");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_LIME, "Anti Block", "Lime");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_MAGENTA, "Anti Block", "Magenta");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_ORANGE, "Anti Block", "Orange");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_PINK, "Anti Block", "Pink");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_PURPLE, "Anti Block", "Purple");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_RED, "Anti Block", "Red");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_WHITE, "Anti Block", "White");
        addBlock(ChiselOtherBlocks.ANTIBLOCK_YELLOW, "Anti Block", "Yellow");
    }

    private void addBirch() {
        addBlock(() -> Blocks.BIRCH_PLANKS, "Birch Wood Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_BRACED, "Birch Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_BRAID, "Birch Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_CRUDE_HORIZONTAL, "Birch Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_CRUDE_PANELING, "Birch Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_CRUDE_VERTICAL, "Birch Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_ENCASED, "Birch Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_ENCASED_LARGE, "Birch Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_ENCASED_SMOOTH, "Birch Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_LARGE, "Birch Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_LOG_CABIN, "Birch Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_PANELING, "Birch Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_SHIPPING, "Birch Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_SMOOTH, "Birch Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_STACKED, "Birch Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.BIRCH_PLANKS_VERTICAL, "Birch Wood Planks", "Vertical Planks");
    }

    private void addBookshelf() {
        addBlock(() -> Blocks.BOOKSHELF, "Bookshelf");
        addBlock(ChiselWoodBlocks.BOOKSHELF_ABANDONED, "Bookshelf", "Abandoned");
        addBlock(ChiselWoodBlocks.BOOKSHELF_BRIM, "Bookshelf", "Brim");
        addBlock(ChiselWoodBlocks.BOOKSHELF_CANS, "Bookshelf", "Cans");
        addBlock(ChiselWoodBlocks.BOOKSHELF_HISTORIAN, "Bookshelf", "Historian's");
        addBlock(ChiselWoodBlocks.BOOKSHELF_HOARDER, "Bookshelf", "Hoarder's");
        addBlock(ChiselWoodBlocks.BOOKSHELF_NECROMANCER, "Bookshelf", "Necromancer's");
        addBlock(ChiselWoodBlocks.BOOKSHELF_NECROMANCER_APPRENTICE, "Bookshelf", "Necromancer’s Apprentice");
        addBlock(ChiselWoodBlocks.BOOKSHELF_PAPERS, "Bookshelf", "Papers");
        addBlock(ChiselWoodBlocks.BOOKSHELF_RAINBOW, "Bookshelf", "Rainbow Books");
        addBlock(ChiselWoodBlocks.BOOKSHELF_TOMES, "Bookshelf", "Red Tomes");
    }

    private void addBricks() {
        addBlock(() -> Blocks.BRICKS, "Brick Block");
        addBlock(ChiselStoneBlocks.BRICKS_ARRAY, "Brick Block", "Array Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_BRAID, "Brick Block", "Braid Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CHAOTIC, "Brick Block", "Chaotic Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CHAOTIC_MEDIUM, "Brick Block", "Medium Chaotic Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CHAOTIC_SMALL, "Brick Block", "Small Chaotic Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CIRCULAR, "Brick Block", "Circular Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CRACKED, "Brick Block", "Cracked Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CRACKED_BRICKS, "Brick Block", "Cracked Brick Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_CUTS, "Brick Block", "Brick Cuts");
        addBlock(ChiselStoneBlocks.BRICKS_DENT, "Brick Block", "Dent Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_ENCASED, "Brick Block", "Encased Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_FRENCH, "Brick Block", "French Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_FRENCH_2, "Brick Block", "French Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_JELLYBEAN, "Brick Block", "Jellybean Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_LAYERS, "Brick Block", "Layered Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_MOSAIC, "Brick Block", "Mosaic Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_ORNATE, "Brick Block", "Ornate Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_PANEL, "Brick Block", "Brick Panel");
        addBlock(ChiselStoneBlocks.BRICKS_PILLAR, "Brick Block", "Brick Pillar");
        addBlock(ChiselStoneBlocks.BRICKS_PRISM, "Brick Block", "Prism Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_RAW, "Brick Block", "Raw Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_ROAD, "Brick Block", "Road Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_SLANTED, "Brick Block", "Slanted Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_SMALL, "Brick Block", "Small Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_SOFT, "Brick Block", "Soft Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_SOLID, "Brick Block", "Solid Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_TILES_LARGE, "Brick Block", "Large Brick Tiles");
        addBlock(ChiselStoneBlocks.BRICKS_TILES_MEDIUM, "Brick Block", "Medium Brick Tiles");
        addBlock(ChiselStoneBlocks.BRICKS_TILES_SMALL, "Brick Block", "Small Brick Tiles");
        addBlock(ChiselStoneBlocks.BRICKS_TRIPLE, "Brick Block", "Triple Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_TWISTED, "Brick Block", "Twisted Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_WEAVER, "Brick Block", "Weaver Bricks");
        addBlock(ChiselStoneBlocks.BRICKS_ZAG, "Brick Block", "Zag Bricks");
    }

    private void addBronze() {
        addBlock(ChiselModdedBlocks.BRONZE_BAD_GREGGY, "Block of Bronze", "Egregious");
        addBlock(ChiselModdedBlocks.BRONZE_BOLTED, "Block of Bronze", "Bolted");
        addBlock(ChiselModdedBlocks.BRONZE_CAUTION, "Block of Bronze", "Caution Stripes");
        addBlock(ChiselModdedBlocks.BRONZE_CRATE, "Block of Bronze", "Shipping Crate");
        addBlock(ChiselModdedBlocks.BRONZE_MACHINE, "Block of Bronze", "An Old Relic From The Land Of OneTeuFyv");
        addBlock(ChiselModdedBlocks.BRONZE_SCAFFOLD, "Block of Bronze", "Scaffold");
        addBlock(ChiselModdedBlocks.BRONZE_THERMAL, "Block of Bronze", "Thermal Series");
    }

    private void addCarpet() {
        addBlock(ChiselOtherBlocks.CARPET_0, "Carpet", "White");
        addBlock(ChiselOtherBlocks.CARPET_1, "Carpet", "Orange");
        addBlock(ChiselOtherBlocks.CARPET_10, "Carpet", "Purple");
        addBlock(ChiselOtherBlocks.CARPET_11, "Carpet", "Dark blue");
        addBlock(ChiselOtherBlocks.CARPET_12, "Carpet", "Brown");
        addBlock(ChiselOtherBlocks.CARPET_13, "Carpet", "Green");
        addBlock(ChiselOtherBlocks.CARPET_14, "Carpet", "Red");
        addBlock(ChiselOtherBlocks.CARPET_15, "Carpet", "Black");
        addBlock(ChiselOtherBlocks.CARPET_2, "Carpet", "Magenta");
        addBlock(ChiselOtherBlocks.CARPET_3, "Carpet", "Light Blue");
        addBlock(ChiselOtherBlocks.CARPET_4, "Carpet", "Yellow");
        addBlock(ChiselOtherBlocks.CARPET_5, "Carpet", "Light green");
        addBlock(ChiselOtherBlocks.CARPET_6, "Carpet", "Pink");
        addBlock(ChiselOtherBlocks.CARPET_7, "Carpet", "Dark grey");
        addBlock(ChiselOtherBlocks.CARPET_8, "Carpet", "Grey");
        addBlock(ChiselOtherBlocks.CARPET_9, "Carpet", "Teal");
    }

    private void addCarpetFloor() {
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_0, "Floor Carpet", "White");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_1, "Floor Carpet", "Orange");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_10, "Floor Carpet", "Purple");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_11, "Floor Carpet", "Dark Blue");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_12, "Floor Carpet", "Brown");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_13, "Floor Carpet", "Green");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_14, "Floor Carpet", "Red");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_15, "Floor Carpet", "Black");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_2, "Floor Carpet", "Magenta");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_3, "Floor Carpet", "Light Blue");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_4, "Floor Carpet", "Yellow");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_5, "Floor Carpet", "Light Green");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_6, "Floor Carpet", "Pink");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_7, "Floor Carpet", "Dark Grey");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_8, "Floor Carpet", "Grey");
        addBlock(ChiselOtherBlocks.CARPET_FLOOR_9, "Floor Carpet", "Teal");
    }

    private void addCloud() {
        addBlock(() -> Blocks.SNOW_BLOCK, "Cloud");
        addBlock(ChiselOtherBlocks.CLOUD_GRID, "Cloud", "Gridded Bricks");
        addBlock(ChiselOtherBlocks.CLOUD_LARGE, "Cloud", "Large Bricks");
        addBlock(ChiselOtherBlocks.CLOUD_NORMAL, "Cloud", "Block");
        addBlock(ChiselOtherBlocks.CLOUD_SMALL, "Cloud", "Small Bricks");
        addBlock(ChiselOtherBlocks.CLOUD_VERTICAL, "Cloud", "Small Vertical Bricks");
    }

    private void addCobblestone() {
        addBlock(() -> Blocks.COBBLESTONE, "Cobblestone");
        addBlock(ChiselStoneBlocks.COBBLESTONE_ARRAY, "Cobblestone", "Array");
        addBlock(ChiselStoneBlocks.COBBLESTONE_BRAID, "Cobblestone", "Braid");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CHAOTIC, "Cobblestone", "Chaotic Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CHAOTIC_MEDIUM, "Cobblestone", "Medium Chaotic Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CHAOTIC_SMALL, "Cobblestone", "Small Chaotic Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CIRCULAR, "Cobblestone", "Circular");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CRACKED, "Cobblestone", "Cracked");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CRACKED_BRICKS, "Cobblestone", "Cracked Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_CUTS, "Cobblestone", "Cuts");
        addBlock(ChiselStoneBlocks.COBBLESTONE_DENT, "Cobblestone", "Dent");
        addBlock(ChiselStoneBlocks.COBBLESTONE_EMBOSS, "Cobblestone", "Embossed");
        addBlock(ChiselStoneBlocks.COBBLESTONE_ENCASED, "Cobblestone", "Encased Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_FRENCH, "Cobblestone", "French Tiles");
        addBlock(ChiselStoneBlocks.COBBLESTONE_FRENCH_2, "Cobblestone", "French Tiles 2");
        addBlock(ChiselStoneBlocks.COBBLESTONE_INDENT, "Cobblestone", "Indent");
        addBlock(ChiselStoneBlocks.COBBLESTONE_JELLYBEAN, "Cobblestone", "Jellybean");
        addBlock(ChiselStoneBlocks.COBBLESTONE_LAYERS, "Cobblestone", "Layers");
        addBlock(ChiselStoneBlocks.COBBLESTONE_MARKER, "Cobblestone", "Marker");
        addBlock(ChiselStoneBlocks.COBBLESTONE_MOSAIC, "Cobblestone", "Mosaic");
        addBlock(ChiselStoneBlocks.COBBLESTONE_ORNATE, "Cobblestone", "Ornate");
        addBlock(ChiselStoneBlocks.COBBLESTONE_PANEL, "Cobblestone", "Panel");
        addBlock(ChiselStoneBlocks.COBBLESTONE_PILLAR, "Cobblestone", "Pillar");
        addBlock(ChiselStoneBlocks.COBBLESTONE_PRISM, "Cobblestone", "Prism");
        addBlock(ChiselStoneBlocks.COBBLESTONE_RAW, "Cobblestone", "Raw");
        addBlock(ChiselStoneBlocks.COBBLESTONE_ROAD, "Cobblestone", "Road");
        addBlock(ChiselStoneBlocks.COBBLESTONE_SLANTED, "Cobblestone", "Slanted");
        addBlock(ChiselStoneBlocks.COBBLESTONE_SMALL, "Cobblestone", "Small Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_SOFT, "Cobblestone", "Soft");
        addBlock(ChiselStoneBlocks.COBBLESTONE_SOLID, "Cobblestone", "Solid");
        addBlock(ChiselStoneBlocks.COBBLESTONE_TILES_LARGE, "Cobblestone", "Large Tiles");
        addBlock(ChiselStoneBlocks.COBBLESTONE_TILES_MEDIUM, "Cobblestone", "Medium Tiles");
        addBlock(ChiselStoneBlocks.COBBLESTONE_TILES_SMALL, "Cobblestone", "Small Tiles");
        addBlock(ChiselStoneBlocks.COBBLESTONE_TRIPLE, "Cobblestone", "Triple Bricks");
        addBlock(ChiselStoneBlocks.COBBLESTONE_TWISTED, "Cobblestone", "Twisted Pillar");
        addBlock(ChiselStoneBlocks.COBBLESTONE_WEAVER, "Cobblestone", "Weaver");
        addBlock(ChiselStoneBlocks.COBBLESTONE_ZAG, "Cobblestone", "Zag");
    }

    private void addConcrete() {
        addBlock(ChiselStoneBlocks.CONCRETE_ASPHALT, "Concrete", "Asphalt");
        addBlock(ChiselStoneBlocks.CONCRETE_BLOCK, "Concrete", "Block");
        addBlock(ChiselStoneBlocks.CONCRETE_BLOCKS, "Concrete", "Small Blocks");
        addBlock(ChiselStoneBlocks.CONCRETE_BLOCKS_WEATHERED, "Concrete", "Small Weathered Blocks");
        addBlock(ChiselStoneBlocks.CONCRETE_BLOCK_PARTLY, "Concrete", "Partly Weathered Block");
        addBlock(ChiselStoneBlocks.CONCRETE_BLOCK_WEATHERED, "Concrete", "Weathered Block");
        addBlock(ChiselStoneBlocks.CONCRETE_RAW, "Concrete", "Raw");
        addBlock(ChiselStoneBlocks.CONCRETE_RAW_PARTLY, "Concrete", "Partly Weathered Raw");
        addBlock(ChiselStoneBlocks.CONCRETE_RAW_WEATHERED, "Concrete", "Weathered Raw");
        addBlock(ChiselStoneBlocks.CONCRETE_SLAB, "Concrete", "Double Slab");
        addBlock(ChiselStoneBlocks.CONCRETE_SLAB_WEATHERED, "Concrete", "Weathered Double Slab");
    }

    private void addCopper() {
        addBlock(ChiselMetalBlocks.COPPER_BAD_GREGGY, "Block of Copper", "Egregious");
        addBlock(ChiselMetalBlocks.COPPER_BOLTED, "Block of Copper", "Bolted");
        addBlock(ChiselMetalBlocks.COPPER_CAUTION, "Block of Copper", "Caution Stripes");
        addBlock(ChiselMetalBlocks.COPPER_CRATE, "Block of Copper", "Shipping Crate");
        addBlock(ChiselMetalBlocks.COPPER_MACHINE, "Block of Copper", "An Old Relic From The Land Of OneTeuFyv");
        addBlock(ChiselMetalBlocks.COPPER_SCAFFOLD, "Block of Copper", "Scaffold");
        addBlock(ChiselMetalBlocks.COPPER_THERMAL, "Block of Copper", "Thermal Series");
    }

    private void addDarkOak() {
        addBlock(() -> Blocks.DARK_OAK_PLANKS, "Dark Oak Wood Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_BRACED, "Dark Oak Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_BRAID, "Dark Oak Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_CRUDE_HORIZONTAL, "Dark Oak Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_CRUDE_PANELING, "Dark Oak Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_CRUDE_VERTICAL, "Dark Oak Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_ENCASED, "Dark Oak Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_ENCASED_LARGE, "Dark Oak Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_ENCASED_SMOOTH, "Dark Oak Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_LARGE, "Dark Oak Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_LOG_CABIN, "Dark Oak Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_PANELING, "Dark Oak Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_SHIPPING, "Dark Oak Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_SMOOTH, "Dark Oak Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_STACKED, "Dark Oak Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.DARK_OAK_PLANKS_VERTICAL, "Dark Oak Wood Planks", "Vertical Planks");
    }

    private void addDiamond() {
        addBlock(() -> Blocks.DIAMOND_BLOCK, "Diamond Block");
        addBlock(ChiselOtherBlocks.DIAMOND_BISMUTH, "Diamond Block", "Bismuth");
        addBlock(ChiselOtherBlocks.DIAMOND_CELLS, "Diamond Block", "Cells");
        addBlock(ChiselOtherBlocks.DIAMOND_CRUSHED, "Diamond Block", "Crushed");
        addBlock(ChiselOtherBlocks.DIAMOND_EMBOSSED, "Diamond Block", "Embossed");
        addBlock(ChiselOtherBlocks.DIAMOND_OBSIDIAN, "Diamond Block", "in Obsidian");
        addBlock(ChiselOtherBlocks.DIAMOND_OBSIDIAN_PURPLE, "Diamond Block", "in Purple Obsidian");
        addBlock(ChiselOtherBlocks.DIAMOND_ORNATE, "Diamond Block", "with Ornate Layer");
        addBlock(ChiselOtherBlocks.DIAMOND_PANEL, "Diamond Block", "with Panel");
        addBlock(ChiselOtherBlocks.DIAMOND_SIMPLE, "Diamond Block", "Simple");
        addBlock(ChiselOtherBlocks.DIAMOND_SMALL_BLOCKS, "Diamond Block", "Small");
        addBlock(ChiselOtherBlocks.DIAMOND_SMALL_BLOCKS_ORNATE, "Diamond Block", "Small Ornate");
        addBlock(ChiselOtherBlocks.DIAMOND_ZELDA, "Diamond Block", "Zelda");
    }

    private void addDiorite() {
        addBlock(() -> Blocks.DIORITE, "Diorite");
        addBlock(ChiselStoneBlocks.DIORITE_ARRAY, "Diorite", "Array");
        addBlock(ChiselStoneBlocks.DIORITE_BRAID, "Diorite", "Braid");
        addBlock(ChiselStoneBlocks.DIORITE_CHAOTIC, "Diorite", "Chaotic Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_CHAOTIC_MEDIUM, "Diorite", "Medium Chaotic Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_CHAOTIC_SMALL, "Diorite", "Small Chaotic Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_CIRCULAR, "Diorite", "Circular");
        addBlock(ChiselStoneBlocks.DIORITE_CRACKED, "Diorite", "Cracked");
        addBlock(ChiselStoneBlocks.DIORITE_CRACKED_BRICKS, "Diorite", "Cracked Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_CUTS, "Diorite", "Cuts");
        addBlock(ChiselStoneBlocks.DIORITE_DENT, "Diorite", "Dent");
        addBlock(ChiselStoneBlocks.DIORITE_ENCASED, "Diorite", "Encased Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_FRENCH, "Diorite", "French Tiles");
        addBlock(ChiselStoneBlocks.DIORITE_FRENCH_2, "Diorite", "French Tiles 2");
        addBlock(ChiselStoneBlocks.DIORITE_JELLYBEAN, "Diorite", "Jellybean");
        addBlock(ChiselStoneBlocks.DIORITE_LAYERS, "Diorite", "Layers");
        addBlock(ChiselStoneBlocks.DIORITE_MOSAIC, "Diorite", "Mosaic");
        addBlock(ChiselStoneBlocks.DIORITE_ORNATE, "Diorite", "Ornate");
        addBlock(ChiselStoneBlocks.DIORITE_PANEL, "Diorite", "Panel");
        addBlock(ChiselStoneBlocks.DIORITE_PILLAR, "Diorite", "Pillar");
        addBlock(ChiselStoneBlocks.DIORITE_PRISM, "Diorite", "Prism");
        addBlock(ChiselStoneBlocks.DIORITE_RAW, "Diorite", "Raw");
        addBlock(ChiselStoneBlocks.DIORITE_ROAD, "Diorite", "Road");
        addBlock(ChiselStoneBlocks.DIORITE_SLANTED, "Diorite", "Slanted");
        addBlock(ChiselStoneBlocks.DIORITE_SMALL, "Diorite", "Small Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_SOFT, "Diorite", "Soft");
        addBlock(ChiselStoneBlocks.DIORITE_SOLID, "Diorite", "Solid");
        addBlock(ChiselStoneBlocks.DIORITE_TILES_LARGE, "Diorite", "Large Tiles");
        addBlock(ChiselStoneBlocks.DIORITE_TILES_MEDIUM, "Diorite", "Medium Tiles");
        addBlock(ChiselStoneBlocks.DIORITE_TILES_SMALL, "Diorite", "Small Tiles");
        addBlock(ChiselStoneBlocks.DIORITE_TRIPLE, "Diorite", "Triple Bricks");
        addBlock(ChiselStoneBlocks.DIORITE_TWISTED, "Diorite", "Twisted Pillar");
        addBlock(ChiselStoneBlocks.DIORITE_WEAVER, "Diorite", "Weaver");
        addBlock(ChiselStoneBlocks.DIORITE_ZAG, "Diorite", "Zag");
    }

    private void addDirt() {
        addBlock(() -> Blocks.DIRT, "Dirt");
        addBlock(ChiselOtherBlocks.DIRT_BRICKS, "Dirt", "Bricks");
        addBlock(ChiselOtherBlocks.DIRT_BRICKS_ARRANGED, "Dirt", "Arranged Bricks");
        addBlock(ChiselOtherBlocks.DIRT_BRICKS_DISARRAY, "Dirt", "Bricks in Disarray");
        addBlock(ChiselOtherBlocks.DIRT_BRICKS_LARGE, "Dirt", "Large Bricks");
        addBlock(ChiselOtherBlocks.DIRT_CHUNKY, "Dirt", "Decayed Bricks");
        addBlock(ChiselOtherBlocks.DIRT_COBBLE, "Dirt", "Cobble-Dirt");
        addBlock(ChiselOtherBlocks.DIRT_HAPPY, "Dirt", "Happy");
        addBlock(ChiselOtherBlocks.DIRT_HORIZONTAL, "Dirt", "Horizontal");
        addBlock(ChiselOtherBlocks.DIRT_LAYERS, "Dirt", "Layers");
        addBlock(ChiselOtherBlocks.DIRT_NETHERBRICKS, "Dirt", "Netherbricks");
        addBlock(ChiselOtherBlocks.DIRT_PLATE, "Dirt", "Dried Farmland");
        addBlock(ChiselOtherBlocks.DIRT_REINFORCED, "Dirt", "Reinforced");
        addBlock(ChiselOtherBlocks.DIRT_REINFORCED_COBBLE, "Dirt", "Reinforced Cobble");
        addBlock(ChiselOtherBlocks.DIRT_VERT, "Dirt", "Vertical Bricks");
        addBlock(ChiselOtherBlocks.DIRT_VERTICAL, "Dirt", "Vertical");
    }

    private void addEmerald() {
        addBlock(() -> Blocks.EMERALD_BLOCK, "Emerald Block");
        addBlock(ChiselOtherBlocks.EMERALD_BISMUTH, "Emerald Block", "Bismuth");
        addBlock(ChiselOtherBlocks.EMERALD_BLOCKS_SMALL, "Emerald Block", "Small Blocks");
        addBlock(ChiselOtherBlocks.EMERALD_BLOCKS_SMALL_ORNATE, "Emerald Block", "Small Ornate Blocks");
        addBlock(ChiselOtherBlocks.EMERALD_CELL, "Emerald Block", "Cell");
        addBlock(ChiselOtherBlocks.EMERALD_CHUNK, "Emerald Block", "Chunk");
        addBlock(ChiselOtherBlocks.EMERALD_CIRCLE, "Emerald Block", "Circle");
        addBlock(ChiselOtherBlocks.EMERALD_MASONRY, "Emerald Block", "Masonry");
        addBlock(ChiselOtherBlocks.EMERALD_ORNATE, "Emerald Block", "Ornate");
        addBlock(ChiselOtherBlocks.EMERALD_ORNATE_LAYER, "Emerald Block", "with Ornate Layer");
        addBlock(ChiselOtherBlocks.EMERALD_PANEL, "Emerald Block", "Panel");
        addBlock(ChiselOtherBlocks.EMERALD_PANEL_CLASSIC, "Emerald Block", "Classic Panel");
        addBlock(ChiselOtherBlocks.EMERALD_PRISMATIC, "Emerald Block", "Prismatic");
        addBlock(ChiselOtherBlocks.EMERALD_SMOOTH, "Emerald Block", "Smooth");
        addBlock(ChiselOtherBlocks.EMERALD_ZELDA, "Emerald Block", "Zelda");
    }

    private void addEnergizedVoidstone() {
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_BEVEL, "Energised Voidstone", "Beveled");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_EYE, "Energised Voidstone", "Eye");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_METAL, "Energised Voidstone", "Metal-Bordered");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_RAW, "Energised Voidstone", "Raw");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_RUNIC, "Energised Voidstone", "Runic");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_SKULL, "Energised Voidstone", "Skull");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_SMOOTH, "Energised Voidstone", "Smooth");
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_TILES, "Energised Voidstone", "Large Tiles");
    }

    private void addEnergizedVoidstonePillar() {
        addBlock(ChiselStoneBlocks.ENERGISED_VOIDSTONE_PILLAR, "Energised Voidstone Pillar", "Striped");
    }

    private void addFactory() {
        addBlock(ChiselMetalBlocks.FACTORY_CIRCUIT, "Factory Block", "Circuit");
        addBlock(ChiselMetalBlocks.FACTORY_COLUMN, "Factory Block", "Column");
        addBlock(ChiselMetalBlocks.FACTORY_DOTS, "Factory Block", "Dots");
        addBlock(ChiselMetalBlocks.FACTORY_FRAME_BLUE, "Factory Block", "Circuit");
        addBlock(ChiselMetalBlocks.FACTORY_GOLD_PLATE, "Factory Block", "Gold Plate");
        addBlock(ChiselMetalBlocks.FACTORY_GOLD_PLATING, "Factory Block", "Gold Plating");
        addBlock(ChiselMetalBlocks.FACTORY_GRINDER, "Factory Block", "Grinder");
        addBlock(ChiselMetalBlocks.FACTORY_HAZARD, "Factory Block", "Hazard");
        addBlock(ChiselMetalBlocks.FACTORY_HAZARD_ORANGE, "Factory Block", "Hazard Orange");
        addBlock(ChiselMetalBlocks.FACTORY_ICE, "Factory Block", "Ice");
        addBlock(ChiselMetalBlocks.FACTORY_METAL_BOX, "Factory Block", "Metal Box");
        addBlock(ChiselMetalBlocks.FACTORY_PLATEX, "Factory Block", "Plate");
        addBlock(ChiselMetalBlocks.FACTORY_PLATING, "Factory Block", "Plating");
        addBlock(ChiselMetalBlocks.FACTORY_RUST, "Factory Block", "Rust");
        addBlock(ChiselMetalBlocks.FACTORY_RUST2, "Factory Block", "Rust 2");
        addBlock(ChiselMetalBlocks.FACTORY_RUST_PLATES, "Factory Block", "Rust Plates");
        addBlock(ChiselMetalBlocks.FACTORY_TILE_MOSAIC, "Factory Block", "Mosaic");
        addBlock(ChiselMetalBlocks.FACTORY_VENT, "Factory Block", "Vent");
        addBlock(ChiselMetalBlocks.FACTORY_WIREFRAME, "Factory Block", "Wireframe");
        addBlock(ChiselMetalBlocks.FACTORY_WIREFRAME_BLUE, "Factory Block", "Wireframe Blue");
        addBlock(ChiselMetalBlocks.FACTORY_WIREFRAME_WHITE, "Factory Block", "Wireframe White");
    }

    private void addFutura() {
        addBlock(ChiselMetalBlocks.FUTURA_CONTROLLER, "Futura Block", "Applied Labyrinthic Neon Lines");
        addBlock(ChiselMetalBlocks.FUTURA_CONTROLLER_PURPLE, "Futura Block", "Applied Labyrinthic Neon Lines");
        addBlock(ChiselMetalBlocks.FUTURA_RAINBOW, "Futura Block", "Poptart Rainbow");
        addBlock(ChiselMetalBlocks.FUTURA_SCREEN_CYAN, "Futura Block", "Glowing Screen with Cyan Borders");
        addBlock(ChiselMetalBlocks.FUTURA_SCREEN_GRAY, "Futura Block", "Glowing Screen with Metallic Borders");
    }

    private void addGlass() {
        addBlock(() -> Blocks.GLASS, "Glass");
        addBlock(ChiselOtherBlocks.GLASS_BORDERLESS, "Glass", "Borderless");
        addBlock(ChiselOtherBlocks.GLASS_BUBBLE, "Glass", "Bubble");
        addBlock(ChiselOtherBlocks.GLASS_CHINESE, "Glass", "Chinese");
        addBlock(ChiselOtherBlocks.GLASS_DUNGEON, "Glass", "Dungeon");
        addBlock(ChiselOtherBlocks.GLASS_FENCE, "Glass", "Modern Iron Fence");
        addBlock(ChiselOtherBlocks.GLASS_GRID_THICK, "Glass", "Thick Grid");
        addBlock(ChiselOtherBlocks.GLASS_GRID_THIN, "Glass", "Thin Grid");
        addBlock(ChiselOtherBlocks.GLASS_JAPANESE, "Glass", "Japanese");
        addBlock(ChiselOtherBlocks.GLASS_LIGHT, "Glass", "Light");
        addBlock(ChiselOtherBlocks.GLASS_ORNATE, "Glass", "Ornate Steel");
        addBlock(ChiselOtherBlocks.GLASS_SCREEN, "Glass", "Screen");
        addBlock(ChiselOtherBlocks.GLASS_SHALE, "Glass", "Shale");
        addBlock(ChiselOtherBlocks.GLASS_STEEL, "Glass", "Steel Frame");
        addBlock(ChiselOtherBlocks.GLASS_STONE, "Glass", "Stone Frame");
    }

    private void addlGlass() {
        addBlock(ChiselOtherBlocks.GLASS_CHINESE_2, "Glass", "Chinese 2");
        addBlock(ChiselOtherBlocks.GLASS_CHRONO, "Glass", "Chrono");
        addBlock(ChiselOtherBlocks.GLASS_EDGE, "Glass", "Edge");
        addBlock(ChiselOtherBlocks.GLASS_EDGE_STEEL, "Glass", "Steel-Edged");
        addBlock(ChiselOtherBlocks.GLASS_JAPANESE_2, "Glass", "Japanese 2");
        addBlock(ChiselOtherBlocks.GLASS_ORNATE_OLD, "Glass", "Old Ornate Steel");
    }

    private void addGlassPane() {
        addBlock(() -> Blocks.GLASS_PANE, "Glass Pane");
        addBlock(ChiselOtherBlocks.GLASS_PANE_BORDERLESS, "Glass Pane", "Borderless");
        addBlock(ChiselOtherBlocks.GLASS_PANE_BUBBLE, "Glass Pane", "Bubble");
        addBlock(ChiselOtherBlocks.GLASS_PANE_CHINESE, "Glass Pane", "Chinese");
        addBlock(ChiselOtherBlocks.GLASS_PANE_CHINESE_GOLD, "Glass Pane", "Chinese with Golden Frame");
        addBlock(ChiselOtherBlocks.GLASS_PANE_JAPANESE_TILES, "Glass Pane", "Japanese");
        addBlock(ChiselOtherBlocks.GLASS_PANE_JAPANESE_TRADITIONAL, "Glass Pane", "Ornate Japanese");
        addBlock(ChiselOtherBlocks.GLASS_PANE_SCREEN, "Glass Pane", "Screen");
        addBlock(ChiselOtherBlocks.GLASS_PANE_STREAK, "Glass Pane", "Streak");
    }

    private void addGlowstone() {
        addBlock(() -> Blocks.GLOWSTONE, "Glowstone");
        addBlock(ChiselOtherBlocks.GLOWSTONE_ARRAY, "Glowstone", "Array");
        addBlock(ChiselOtherBlocks.GLOWSTONE_BISMUTH, "Glowstone", "Bismuth");
        addBlock(ChiselOtherBlocks.GLOWSTONE_BRAID, "Glowstone", "Braid");
        addBlock(ChiselOtherBlocks.GLOWSTONE_CHAOTIC_MEDIUM, "Glowstone", "Medium Chaotic");
        addBlock(ChiselOtherBlocks.GLOWSTONE_CHAOTIC_SMALL, "Glowstone", "Small Chaotic");
        addBlock(ChiselOtherBlocks.GLOWSTONE_CIRCULAR, "Glowstone", "Circular");
        addBlock(ChiselOtherBlocks.GLOWSTONE_CRACKED, "Glowstone", "Cracked");
        addBlock(ChiselOtherBlocks.GLOWSTONE_CRACKED_BRICKS, "Glowstone", "Cracked Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_DENT, "Glowstone", "Dent");
        addBlock(ChiselOtherBlocks.GLOWSTONE_ENCASED_BRICKS, "Glowstone", "Encased Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_FRENCH_1, "Glowstone", "French 1");
        addBlock(ChiselOtherBlocks.GLOWSTONE_FRENCH_2, "Glowstone", "French 2");
        addBlock(ChiselOtherBlocks.GLOWSTONE_JELLYBEAN, "Glowstone", "Jellybean");
        addBlock(ChiselOtherBlocks.GLOWSTONE_LAYERS, "Glowstone", "Layers");
        addBlock(ChiselOtherBlocks.GLOWSTONE_MOSAIC, "Glowstone", "Mosaic");
        addBlock(ChiselOtherBlocks.GLOWSTONE_NEON, "Glowstone", "Neon");
        addBlock(ChiselOtherBlocks.GLOWSTONE_NEON_PANEL, "Glowstone", "Neon Panel");
        addBlock(ChiselOtherBlocks.GLOWSTONE_ORNATE, "Glowstone", "Ornate");
        addBlock(ChiselOtherBlocks.GLOWSTONE_PANEL, "Glowstone", "Panel");
        addBlock(ChiselOtherBlocks.GLOWSTONE_PILLAR, "Glowstone", "Pillar");
        addBlock(ChiselOtherBlocks.GLOWSTONE_PRISM, "Glowstone", "Prism");
        addBlock(ChiselOtherBlocks.GLOWSTONE_ROAD, "Glowstone", "Road");
        addBlock(ChiselOtherBlocks.GLOWSTONE_SLANTED, "Glowstone", "Slanted");
        addBlock(ChiselOtherBlocks.GLOWSTONE_SMALL_BRICKS, "Glowstone", "Small Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_SOFT_BRICKS, "Glowstone", "Soft Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_SOLID_BRICKS, "Glowstone", "Solid Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TILES_LARGE, "Glowstone", "Large Tiles");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TILES_LARGE_BISMUTH, "Glowstone", "Large Bismuth Tiles");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TILES_MEDIUM, "Glowstone", "Medium Tiles");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TILES_SMALL, "Glowstone", "Small Tiles");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TRIPLE_BRICKS, "Glowstone", "Triple Bricks");
        addBlock(ChiselOtherBlocks.GLOWSTONE_TWISTED, "Glowstone", "Twisted");
    }

    private void addGold() {
        addBlock(() -> Blocks.GOLD_BLOCK, "Block of Gold");
        addBlock(ChiselMetalBlocks.GOLD_125, "Block of Gold", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselMetalBlocks.GOLD_BOLTED, "Block of Gold", "Fancy Bolted Plating");
        addBlock(ChiselMetalBlocks.GOLD_BORDERED, "Block of Gold", "Egregiously Bordered Block");
        addBlock(ChiselMetalBlocks.GOLD_BRICKS, "Block of Gold", "Golden Bricks");
        addBlock(ChiselMetalBlocks.GOLD_CART, "Block of Gold", "Gold Cart");
        addBlock(ChiselMetalBlocks.GOLD_CAUTION, "Block of Gold", "Caution Stripes");
        addBlock(ChiselMetalBlocks.GOLD_COIN_HEADS, "Block of Gold", "Golden Coin Stack Heads-up");
        addBlock(ChiselMetalBlocks.GOLD_COIN_TAILS, "Block of Gold", "Golden Coin Stack Heads-down");
        addBlock(ChiselMetalBlocks.GOLD_CRATE_DARK, "Block of Gold", "Dark Gold Crate");
        addBlock(ChiselMetalBlocks.GOLD_CRATE_LIGHT, "Block of Gold", "Light Gold Crate");
        addBlock(ChiselMetalBlocks.GOLD_INGOTS_LARGE, "Block of Gold", "Large Golden Ingots");
        addBlock(ChiselMetalBlocks.GOLD_INGOTS_SMALL, "Block of Gold", "Small Golden Ingots");
        addBlock(ChiselMetalBlocks.GOLD_PLATES, "Block of Gold", "Golden Plates");
        addBlock(ChiselMetalBlocks.GOLD_RIVETS, "Block of Gold", "Gold Plates with Rivets");
        addBlock(ChiselMetalBlocks.GOLD_SHIPPING, "Block of Gold", "Shipping Crate");
        addBlock(ChiselMetalBlocks.GOLD_SIMPLE, "Block of Gold", "Simple");
        addBlock(ChiselMetalBlocks.GOLD_STAR_DECOR, "Block of Gold", "with Star Decoration");
        addBlock(ChiselMetalBlocks.GOLD_STAR_OBSIDIAN, "Block of Gold", "Golden Star in Obsidian");
        addBlock(ChiselMetalBlocks.GOLD_STAR_OBSIDIAN_PURPLE, "Block of Gold", "Golden Star in Purple Obsidian");
        addBlock(ChiselMetalBlocks.GOLD_THERMAL, "Block of Gold", "Thermal");
    }

    private void addGranite() {
        addBlock(() -> Blocks.GRANITE, "Granite");
        addBlock(ChiselStoneBlocks.GRANITE_ARRAY, "Granite", "Array");
        addBlock(ChiselStoneBlocks.GRANITE_BRAID, "Granite", "Braid");
        addBlock(ChiselStoneBlocks.GRANITE_CHAOTIC_BRICKS, "Granite", "Chaotic Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_CHAOTIC_MEDIUM, "Granite", "Medium Chaotic");
        addBlock(ChiselStoneBlocks.GRANITE_CHAOTIC_SMALL, "Granite", "Small Chaotic");
        addBlock(ChiselStoneBlocks.GRANITE_CIRCULAR, "Granite", "Circular");
        addBlock(ChiselStoneBlocks.GRANITE_CRACKED, "Granite", "Cracked");
        addBlock(ChiselStoneBlocks.GRANITE_CRACKED_BRICKS, "Granite", "Cracked Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_CUTS, "Granite", "Cuts");
        addBlock(ChiselStoneBlocks.GRANITE_DENT, "Granite", "Dent");
        addBlock(ChiselStoneBlocks.GRANITE_ENCASED_BRICKS, "Granite", "Encased Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_FRENCH_1, "Granite", "French 1");
        addBlock(ChiselStoneBlocks.GRANITE_FRENCH_2, "Granite", "French 2");
        addBlock(ChiselStoneBlocks.GRANITE_JELLYBEAN, "Granite", "Jellybean");
        addBlock(ChiselStoneBlocks.GRANITE_LAYERS, "Granite", "Layers");
        addBlock(ChiselStoneBlocks.GRANITE_MOSAIC, "Granite", "Mosaic");
        addBlock(ChiselStoneBlocks.GRANITE_ORNATE, "Granite", "Ornate");
        addBlock(ChiselStoneBlocks.GRANITE_PANEL, "Granite", "Panel");
        addBlock(ChiselStoneBlocks.GRANITE_PILLAR, "Granite", "Pillar");
        addBlock(ChiselStoneBlocks.GRANITE_PRISM, "Granite", "Prism");
        addBlock(ChiselStoneBlocks.GRANITE_RAW, "Granite", "Raw");
        addBlock(ChiselStoneBlocks.GRANITE_ROAD, "Granite", "Road");
        addBlock(ChiselStoneBlocks.GRANITE_SLANTED, "Granite", "Slanted");
        addBlock(ChiselStoneBlocks.GRANITE_SMALL_BRICKS, "Granite", "Small Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_SOFT_BRICKS, "Granite", "Soft Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_SOLID_BRICKS, "Granite", "Solid Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_TILES_LARGE, "Granite", "Large Tiles");
        addBlock(ChiselStoneBlocks.GRANITE_TILES_MEDIUM, "Granite", "Medium Tiles");
        addBlock(ChiselStoneBlocks.GRANITE_TILES_SMALL, "Granite", "Small Tiles");
        addBlock(ChiselStoneBlocks.GRANITE_TRIPLE_BRICKS, "Granite", "Triple Bricks");
        addBlock(ChiselStoneBlocks.GRANITE_TWISTED, "Granite", "Twisted");
        addBlock(ChiselStoneBlocks.GRANITE_WEAVER, "Granite", "Weaver");
        addBlock(ChiselStoneBlocks.GRANITE_ZAG, "Granite", "Zag");
    }

    private void addGrimstone() {
        addBlock(ChiselStoneBlocks.GRIMSTONE_BLOCKS, "Grimstone", "Blocks");
        addBlock(ChiselStoneBlocks.GRIMSTONE_BLOCKS_ROUGH, "Grimstone", "Rough Blocks");
        addBlock(ChiselStoneBlocks.GRIMSTONE_BRICKS, "Grimstone", "Bricks");
        addBlock(ChiselStoneBlocks.GRIMSTONE_BRICKS_LARGE, "Grimstone", "Large Bricks");
        addBlock(ChiselStoneBlocks.GRIMSTONE_CHISELED, "Grimstone", "Chiseled");
        addBlock(ChiselStoneBlocks.GRIMSTONE_CONSTRUCTION, "Grimstone", "Construction");
        addBlock(ChiselStoneBlocks.GRIMSTONE_FLAKY, "Grimstone", "Flaky");
        addBlock(ChiselStoneBlocks.GRIMSTONE_PLATE, "Grimstone", "Plate");
        addBlock(ChiselStoneBlocks.GRIMSTONE_PLATE_SMOOTH, "Grimstone", "Smooth Plate");
        addBlock(ChiselStoneBlocks.GRIMSTONE_PLATFORM, "Grimstone", "Platform");
        addBlock(ChiselStoneBlocks.GRIMSTONE_PLATFORM_TILES, "Grimstone", "Platform Tiles");
        addBlock(ChiselStoneBlocks.GRIMSTONE_RAW, "Grimstone", "Raw");
        addBlock(ChiselStoneBlocks.GRIMSTONE_SMOOTH, "Grimstone", "Smooth");
        addBlock(ChiselStoneBlocks.GRIMSTONE_SYMBOL, "Grimstone", "Symbol");
        addBlock(ChiselStoneBlocks.GRIMSTONE_TILES, "Grimstone", "Tiles");
    }

    private void addHexPlating() {
        addBlock(ChiselMetalBlocks.HEX_PLATING_0, "Hex Plating", "Black");
        addBlock(ChiselMetalBlocks.HEX_PLATING_1, "Hex Plating", "Blue");
        addBlock(ChiselMetalBlocks.HEX_PLATING_10, "Hex Plating", "Pink");
        addBlock(ChiselMetalBlocks.HEX_PLATING_11, "Hex Plating", "Purple");
        addBlock(ChiselMetalBlocks.HEX_PLATING_12, "Hex Plating", "Red");
        addBlock(ChiselMetalBlocks.HEX_PLATING_13, "Hex Plating", "White");
        addBlock(ChiselMetalBlocks.HEX_PLATING_14, "Hex Plating", "Yellow");
        addBlock(ChiselMetalBlocks.HEX_PLATING_15, "Hex Plating", "Gray");
        addBlock(ChiselMetalBlocks.HEX_PLATING_2, "Hex Plating", "Brown");
        addBlock(ChiselMetalBlocks.HEX_PLATING_3, "Hex Plating", "Cyan");
        addBlock(ChiselMetalBlocks.HEX_PLATING_4, "Hex Plating", "Green");
        addBlock(ChiselMetalBlocks.HEX_PLATING_5, "Hex Plating", "Light Blue");
        addBlock(ChiselMetalBlocks.HEX_PLATING_6, "Hex Plating", "Light Gray");
        addBlock(ChiselMetalBlocks.HEX_PLATING_7, "Hex Plating", "Lime");
        addBlock(ChiselMetalBlocks.HEX_PLATING_8, "Hex Plating", "Magenta");
        addBlock(ChiselMetalBlocks.HEX_PLATING_9, "Hex Plating", "Orange");
    }

    private void addHolystone() {
        addBlock(ChiselStoneBlocks.HOLYSTONE_BLOCKS, "Holystone", "Blocks");
        addBlock(ChiselStoneBlocks.HOLYSTONE_BLOCKS_ROUGH, "Holystone", "Rough Blocks");
        addBlock(ChiselStoneBlocks.HOLYSTONE_BRICKS, "Holystone", "Bricks");
        addBlock(ChiselStoneBlocks.HOLYSTONE_BRICKS_LARGE, "Holystone", "Large Bricks");
        addBlock(ChiselStoneBlocks.HOLYSTONE_CHISELED, "Holystone", "Chiseled");
        addBlock(ChiselStoneBlocks.HOLYSTONE_CONSTRUCTION, "Holystone", "Construction");
        addBlock(ChiselStoneBlocks.HOLYSTONE_PLATE, "Holystone", "Plate");
        addBlock(ChiselStoneBlocks.HOLYSTONE_PLATE_SMOOTH, "Holystone", "Smooth Plate");
        addBlock(ChiselStoneBlocks.HOLYSTONE_PLATFORM, "Holystone", "Platform");
        addBlock(ChiselStoneBlocks.HOLYSTONE_PLATFORM_TILES, "Holystone", "Platform Tiles");
        addBlock(ChiselStoneBlocks.HOLYSTONE_RAW, "Holystone", "Raw");
        addBlock(ChiselStoneBlocks.HOLYSTONE_SMOOTH, "Holystone", "Smooth");
        addBlock(ChiselStoneBlocks.HOLYSTONE_SYMBOL, "Holystone", "Symbol");
        addBlock(ChiselStoneBlocks.HOLYSTONE_TILES, "Holystone", "Tiles");
    }

    private void addIce() {
        addBlock(() -> Blocks.ICE, "Ice");
        addBlock(ChiselOtherBlocks.ICE_ARRAY, "Ice", "Array");
        addBlock(ChiselOtherBlocks.ICE_BRAID, "Ice", "Braid");
        addBlock(ChiselOtherBlocks.ICE_CHAOTIC_BRICKS, "Ice", "Chaotic Bricks");
        addBlock(ChiselOtherBlocks.ICE_CHAOTIC_MEDIUM, "Ice", "Medium Chaotic");
        addBlock(ChiselOtherBlocks.ICE_CHAOTIC_SMALL, "Ice", "Small Chaotic");
        addBlock(ChiselOtherBlocks.ICE_CIRCULAR, "Ice", "Circular");
        addBlock(ChiselOtherBlocks.ICE_CRACKED, "Ice", "Cracked");
        addBlock(ChiselOtherBlocks.ICE_CRACKED_BRICKS, "Ice", "Cracked Bricks");
        addBlock(ChiselOtherBlocks.ICE_CUTS, "Ice", "Cuts");
        addBlock(ChiselOtherBlocks.ICE_DENT, "Ice", "Dent");
        addBlock(ChiselOtherBlocks.ICE_ENCASED_BRICKS, "Ice", "Encased Bricks");
        addBlock(ChiselOtherBlocks.ICE_FRENCH_1, "Ice", "French 1");
        addBlock(ChiselOtherBlocks.ICE_FRENCH_2, "Ice", "French 2");
        addBlock(ChiselOtherBlocks.ICE_JELLYBEAN, "Ice", "Jellybean");
        addBlock(ChiselOtherBlocks.ICE_LAYERS, "Ice", "Layers");
        addBlock(ChiselOtherBlocks.ICE_MOSAIC, "Ice", "Mosaic");
        addBlock(ChiselOtherBlocks.ICE_ORNATE, "Ice", "Ornate");
        addBlock(ChiselOtherBlocks.ICE_PANEL, "Ice", "Panel");
        addBlock(ChiselOtherBlocks.ICE_PILLAR, "Ice", "Pillar");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_CARVED, "Ice Pillar", "Carved Capstone");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_GREEK_GREEK, "Ice Pillar", "Greek with Greek Capstone");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_GREEK_PLAIN, "Ice Pillar", "Greek with Plain Capstone");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_CONVEX, "Ice Pillar", "Convex");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_ORNAMENTAL, "Ice Pillar", "Ornamental Capstone");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_PLAIN_GREEK, "Ice Pillar", "Plain with Greek Capstone");
        addBlock(ChiselOtherBlocks.ICE_PILLAR_PLAIN_PLAIN, "Ice Pillar", "Plain with Plain Capstone");
        addBlock(ChiselOtherBlocks.ICE_PRISM, "Ice", "Prism");
        addBlock(ChiselOtherBlocks.ICE_RAW, "Ice", "Raw");
        addBlock(ChiselOtherBlocks.ICE_ROAD, "Ice", "Road");
        addBlock(ChiselOtherBlocks.ICE_SLANTED, "Ice", "Slanted");
        addBlock(ChiselOtherBlocks.ICE_SMALL_BRICKS, "Ice", "Small Bricks");
        addBlock(ChiselOtherBlocks.ICE_SOFT_BRICKS, "Ice", "Soft Bricks");
        addBlock(ChiselOtherBlocks.ICE_SOLID_BRICKS, "Ice", "Solid Bricks");
        addBlock(ChiselOtherBlocks.ICE_TILES_LARGE, "Ice", "Large Tiles");
        addBlock(ChiselOtherBlocks.ICE_TILES_MEDIUM, "Ice", "Medium Tiles");
        addBlock(ChiselOtherBlocks.ICE_TILES_SMALL, "Ice", "Small Tiles");
        addBlock(ChiselOtherBlocks.ICE_TRIPLE_BRICKS, "Ice", "Triple Bricks");
        addBlock(ChiselOtherBlocks.ICE_TWISTED, "Ice", "Twisted");
        addBlock(ChiselOtherBlocks.ICE_WEAVER, "Ice", "Weaver");
        addBlock(ChiselOtherBlocks.ICE_ZAG, "Ice", "Zag");
    }

    private void addIron() {
        addBlock(() -> Blocks.IRON_BLOCK, "Block of Iron");
        addBlock(ChiselMetalBlocks.IRON_125, "Block of Iron", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselMetalBlocks.IRON_BOLTED, "Block of Iron", "Fancy Bolted Plating");
        addBlock(ChiselMetalBlocks.IRON_BORDERED, "Block of Iron", "Egregiously Bordered Block");
        addBlock(ChiselMetalBlocks.IRON_BRICKS, "Block of Iron", "Iron Bricks");
        addBlock(ChiselMetalBlocks.IRON_CAUTION, "Block of Iron", "Caution Stripes");
        addBlock(ChiselMetalBlocks.IRON_COIN_HEADS, "Block of Iron", "Iron Coin Stack Heads-up");
        addBlock(ChiselMetalBlocks.IRON_COIN_TAILS, "Block of Iron", "Iron Coin Stack Heads-down");
        addBlock(ChiselMetalBlocks.IRON_CRATE_DARK, "Block of Iron", "Dark Iron Crate");
        addBlock(ChiselMetalBlocks.IRON_CRATE_LIGHT, "Block of Iron", "Light Iron Crate");
        addBlock(ChiselMetalBlocks.IRON_GEARS, "Block of Iron", "Iron Gears");
        addBlock(ChiselMetalBlocks.IRON_INGOTS_LARGE, "Block of Iron", "Large Iron Ingots");
        addBlock(ChiselMetalBlocks.IRON_INGOTS_SMALL, "Block of Iron", "Small Iron Ingots");
        addBlock(ChiselMetalBlocks.IRON_MOON_DECOR, "Block of Iron", "with Moon Decoration");
        addBlock(ChiselMetalBlocks.IRON_MOON_OBSIDIAN, "Block of Iron", "Iron Moon in Obsidian");
        addBlock(ChiselMetalBlocks.IRON_MOON_OBSIDIAN_PURPLE, "Block of Iron", "Iron Moon in Purple Obsidian");
        addBlock(ChiselMetalBlocks.IRON_PLATES, "Block of Iron", "Iron Plates");
        addBlock(ChiselMetalBlocks.IRON_RIVETS, "Block of Iron", "Iron Plates with Rivets");
        addBlock(ChiselMetalBlocks.IRON_SHIPPING, "Block of Iron", "Shipping Crate");
        addBlock(ChiselMetalBlocks.IRON_SIMPLE, "Block of Iron", "Simple");
        addBlock(ChiselMetalBlocks.IRON_THERMAL, "Block of Iron", "Thermal");
        addBlock(ChiselMetalBlocks.IRON_VENTS, "Block of Iron", "Iron Vents");
    }

    private void addIronBars() {
        addBlock(() -> Blocks.IRON_BARS, "Iron Bars");
        addBlock(ChiselOtherBlocks.IRON_BARS_BARBED_WIRE, "Iron Bars", "Barbed Wire");
        addBlock(ChiselOtherBlocks.IRON_BARS_BARS, "Iron Bars", "Bars");
        addBlock(ChiselOtherBlocks.IRON_BARS_BORDERLESS, "Iron Bars", "Borderless");
        addBlock(ChiselOtherBlocks.IRON_BARS_CAGE, "Iron Bars", "Cage");
        addBlock(ChiselOtherBlocks.IRON_BARS_CLASSIC, "Iron Bars", "Classic");
        addBlock(ChiselOtherBlocks.IRON_BARS_CLASSIC_NEW, "Iron Bars", "New Classic");
        addBlock(ChiselOtherBlocks.IRON_BARS_FENCE, "Iron Bars", "Fence");
        addBlock(ChiselOtherBlocks.IRON_BARS_MODERN, "Iron Bars", "Modern");
        addBlock(ChiselOtherBlocks.IRON_BARS_ORNATE_STEEL, "Iron Bars", "Ornate Steel");
        addBlock(ChiselOtherBlocks.IRON_BARS_SPIKES, "Iron Bars", "Spikes");
        addBlock(ChiselOtherBlocks.IRON_BARS_THICK_GRID, "Iron Bars", "Thick Grid");
        addBlock(ChiselOtherBlocks.IRON_BARS_THIN_GRID, "Iron Bars", "Thin Grid");
    }

    private void addJungle() {
        addBlock(() -> Blocks.JUNGLE_PLANKS, "Jungle Wood Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_BRACED, "Jungle Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_BRAID, "Jungle Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_CRUDE_HORIZONTAL, "Jungle Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_CRUDE_PANELING, "Jungle Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_CRUDE_VERTICAL, "Jungle Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_ENCASED, "Jungle Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_ENCASED_LARGE, "Jungle Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_ENCASED_SMOOTH, "Jungle Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_LARGE, "Jungle Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_LOG_CABIN, "Jungle Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_PANELING, "Jungle Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_SHIPPING, "Jungle Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_SMOOTH, "Jungle Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_STACKED, "Jungle Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.JUNGLE_PLANKS_VERTICAL, "Jungle Wood Planks", "Vertical Planks");
    }

    private void addLaboratory() {
        addBlock(ChiselMetalBlocks.LABORATORY_CHECKERBOARD, "Laboratory Block", "Checkerboard Floor");
        addBlock(ChiselMetalBlocks.LABORATORY_CONSOLE_INFORMATION, "Laboratory Block", "Information Console");
        addBlock(ChiselMetalBlocks.LABORATORY_CONSOLE_LEFT, "Laboratory Block", "Direction Console (Left)");
        addBlock(ChiselMetalBlocks.LABORATORY_CONSOLE_RIGHT, "Laboratory Block", "Direction Console (Right)");
        addBlock(ChiselMetalBlocks.LABORATORY_FLOOR, "Laboratory Block", "Laboratory Floor");
        addBlock(ChiselMetalBlocks.LABORATORY_PANEL_CLEAR, "Laboratory Block", "Clear Panel");
        addBlock(ChiselMetalBlocks.LABORATORY_PANEL_DOTTED, "Laboratory Block", "Dotted Panel");
        addBlock(ChiselMetalBlocks.LABORATORY_PANEL_FUZZY, "Laboratory Block", "Fuzzy Panel");
        addBlock(ChiselMetalBlocks.LABORATORY_PANEL_WALL, "Laboratory Block", "Wall Panel");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_ENAMELLED_LARGE, "Laboratory Block", "Large Enamelled Tile");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_ENAMELLED_SMALL, "Laboratory Block", "Small Enamelled Tiles");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_STEEL_LARGE, "Laboratory Block", "Large Steel Tile");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_STEEL_SMALL, "Laboratory Block", "Small Steel Tiles");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_SMALL, "Laboratory Block", "Small Tiles");
        addBlock(ChiselMetalBlocks.LABORATORY_TILES_LARGE, "Laboratory Block", "Large Tiles");
        addBlock(ChiselMetalBlocks.LABORATORY_WALL, "Laboratory Block", "Enamelled Wall");
        addBlock(ChiselMetalBlocks.LABORATORY_WALL_ROUNDED, "Laboratory Block", "Enamelled Roundel Wall");
        addBlock(ChiselMetalBlocks.LABORATORY_WALL_VENT, "Laboratory Block", "Enamelled Wall Vents");
    }

    private void addLapis() {
        addBlock(() -> Blocks.LAPIS_BLOCK, "Lapis Block");
        addBlock(ChiselOtherBlocks.LAPIS_CHUNKY, "Lapis Block", "Chunky");
        addBlock(ChiselOtherBlocks.LAPIS_DARK, "Lapis Block", "Dark");
        addBlock(ChiselOtherBlocks.LAPIS_ORNATE, "Lapis Block", "Ornate");
        addBlock(ChiselOtherBlocks.LAPIS_ORNATE_LAYER, "Lapis Block", "with Ornate Layer");
        addBlock(ChiselOtherBlocks.LAPIS_PANEL, "Lapis Block", "Panel");
        addBlock(ChiselOtherBlocks.LAPIS_SMOOTH, "Lapis Block", "Smooth");
        addBlock(ChiselOtherBlocks.LAPIS_TILE, "Lapis Block", "Tile");
        addBlock(ChiselOtherBlocks.LAPIS_ZELDA, "Lapis Block", "Zelda");
    }

    private void addLargeHexPlating() {
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_0, "Large Hex Plating", "Black");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_1, "Large Hex Plating", "Blue");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_10, "Large Hex Plating", "Pink");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_11, "Large Hex Plating", "Purple");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_12, "Large Hex Plating", "Red");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_13, "Large Hex Plating", "White");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_14, "Large Hex Plating", "Yellow");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_15, "Large Hex Plating", "Gray");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_2, "Large Hex Plating", "Brown");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_3, "Large Hex Plating", "Cyan");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_4, "Large Hex Plating", "Green");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_5, "Large Hex Plating", "Light Blue");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_6, "Large Hex Plating", "Light Gray");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_7, "Large Hex Plating", "Lime");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_8, "Large Hex Plating", "Magenta");
        addBlock(ChiselMetalBlocks.LARGE_HEX_PLATING_9, "Large Hex Plating", "Orange");
    }

    private void addLavastone() {
        addBlock(ChiselStoneBlocks.LAVASTONE_BLACK, "Lavastone", "Black");
        addBlock(ChiselStoneBlocks.LAVASTONE_BRICKS, "Lavastone", "Chaotic Bricks");
        addBlock(ChiselStoneBlocks.LAVASTONE_DARK, "Lavastone", "Dark");
        addBlock(ChiselStoneBlocks.LAVASTONE_PANEL, "Lavastone", "Panel");
        addBlock(ChiselStoneBlocks.LAVASTONE_PANEL_ORNATE, "Lavastone", "Ornate Panel");
        addBlock(ChiselStoneBlocks.LAVASTONE_RAW, "Lavastone", "Raw");
        addBlock(ChiselStoneBlocks.LAVASTONE_TILES, "Lavastone", "Tiles");
        addBlock(ChiselStoneBlocks.LAVASTONE_TILES_CREEPER, "Lavastone", "Creeper in Tiles");
    }

    private void addLead() {
        addBlock(ChiselModdedBlocks.LEAD_125, "Block of Lead", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselModdedBlocks.LEAD_BOLTED, "Block of Lead", "Fancy Bolted Plating");
        addBlock(ChiselModdedBlocks.LEAD_BORDERED, "Block of Lead", "Egregiously Bordered Block");
        addBlock(ChiselModdedBlocks.LEAD_CAUTION, "Block of Lead", "Caution Stripes");
        addBlock(ChiselModdedBlocks.LEAD_SHIPPING, "Block of Lead", "Shipping Crate");
        addBlock(ChiselModdedBlocks.LEAD_THERMAL, "Block of Lead", "Thermal");
    }

    private void addLeaf() {
        addBlock(ChiselOtherBlocks.LEAVES_CHRISTMAS_BALLS, "Leaf", "Christmas Balls");
        addBlock(ChiselOtherBlocks.LEAVES_CHRISTMAS_LIGHTS, "Leaf", "Christmas Lights");
        addBlock(ChiselOtherBlocks.LEAVES_DEAD, "Leaf", "Dead");
        addBlock(ChiselOtherBlocks.LEAVES_FANCY, "Leaf", "Fancy");
        addBlock(ChiselOtherBlocks.LEAVES_PINK, "Leaf", "Pink Petals");
        addBlock(ChiselOtherBlocks.LEAVES_RED, "Leaf", "Red Rose");
        addBlock(ChiselOtherBlocks.LEAVES_WHITE, "Leaf", "White Rose");
    }

    private void addLimestone() {
        addBlock(ChiselStoneBlocks.LIMESTONE_BRICKS, "Limestone", "Small Bricks");
        addBlock(ChiselStoneBlocks.LIMESTONE_DENT, "Limestone", "with Dent");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL, "Limestone", "with Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL_CREEPER, "Limestone", "with Creeper Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL_DARK, "Limestone", "with Dark Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL_ENGRAVED, "Limestone", "with Engraved Ornate Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL_LIGHT, "Limestone", "with Light Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_PANEL_ORNATE, "Limestone", "with Ornate Panel");
        addBlock(ChiselStoneBlocks.LIMESTONE_RAW, "Limestone", "Raw");
        addBlock(ChiselStoneBlocks.LIMESTONE_SMOOTH, "Limestone", "Smooth");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES, "Limestone", "Small Tiles");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES_CREEPER, "Limestone", "Creeper Tiles");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES_DAMAGED, "Limestone", "Damaged Tiles");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES_FRENCH, "Limestone", "French Tiles");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES_FRENCH_LIGHT, "Limestone", "French Tiles Light");
        addBlock(ChiselStoneBlocks.LIMESTONE_TILES_LARGE, "Limestone", "Large Tiles");
    }

    private void addLitPumpkin() {
        addBlock(ChiselOtherBlocks.LITPUMPKIN_0, "Jack-O-Lantern", "Suprised");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_1, "Jack-O-Lantern", "Smiling open");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_10, "Jack-O-Lantern", "Exited");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_11, "Jack-O-Lantern", "Sleeping");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_12, "Jack-O-Lantern", "Astonished");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_13, "Jack-O-Lantern", "Neutral");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_14, "Jack-O-Lantern", "Laughing out loud");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_15, "Jack-O-Lantern", "Smiling Closed");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_16, "Jack-O-Lantern", "Astonished");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_2, "Jack-O-Lantern", "Cheeky");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_3, "Jack-O-Lantern", "Pensive");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_4, "Jack-O-Lantern", "Disappointed");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_5, "Jack-O-Lantern", "Smirking");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_6, "Jack-O-Lantern", "Curious");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_7, "Jack-O-Lantern", "Bored");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_8, "Jack-O-Lantern", "Sad");
        addBlock(ChiselOtherBlocks.LITPUMPKIN_9, "Jack-O-Lantern", "Evil");
    }

    private void addMarble() {
        addBlock(ChiselStoneBlocks.MARBLE_BLOCK, "Marble", "Block");
        addBlock(ChiselStoneBlocks.MARBLE_BLOCKS, "Marble", "Blocks");
        addBlock(ChiselStoneBlocks.MARBLE_BRICK, "Marble", "Brick");
        addBlock(ChiselStoneBlocks.MARBLE_CARVED, "Marble", "Carved");
        addBlock(ChiselStoneBlocks.MARBLE_CARVED_RADIAL, "Marble", "Radial Carved");
        addBlock(ChiselStoneBlocks.MARBLE_CREEPER_DARK, "Marble", "Dark Creeper");
        addBlock(ChiselStoneBlocks.MARBLE_CREEPER_LIGHT, "Marble", "Light Creeper");
        addBlock(ChiselStoneBlocks.MARBLE_DENT, "Marble", "with Dent");
        addBlock(ChiselStoneBlocks.MARBLE_DENT_LARGE, "Marble", "with Large Dent");
        addBlock(ChiselStoneBlocks.MARBLE_PANEL, "Marble", "Panel");
        addBlock(ChiselStoneBlocks.MARBLE_PANEL_CLASSIC, "Marble", "Classic Panel");
        addBlock(ChiselStoneBlocks.MARBLE_PANEL_ORNATE, "Marble", "Ornate Panel");
        addBlock(ChiselStoneBlocks.MARBLE_RAW, "Marble", "Raw");
        addBlock(ChiselStoneBlocks.MARBLE_TILES, "Marble", "Tiles");
        addBlock(ChiselStoneBlocks.MARBLE_TILES_ARRANGED, "Marble", "Arranged Tiles");
        addBlock(ChiselStoneBlocks.MARBLE_TILES_FANCY, "Marble", "Fancy Tiles");
    }

    private void addMossyCobblestone() {
        addBlock(() -> Blocks.MOSSY_COBBLESTONE, "Mossy Cobblestone");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_BRICKS_ALIGNED, "Mossy Cobblestone", "Aligned Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_BRICKS_DETAILED, "Mossy Cobblestone", "Detailed Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_BRICKS_SMALL, "Mossy Cobblestone", "Small Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_DENT, "Mossy Cobblestone", "Dent");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_PANEL, "Mossy Cobblestone", "Pane");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_PANEL_CREEPER, "Mossy Cobblestone", "Creeper Panel");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_PANEL_DARK, "Mossy Cobblestone", "Dark Panel");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_PANEL_LIGHT, "Mossy Cobblestone", "Light Panel");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_CREEPER, "Mossy Cobblestone", "Creeper Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_DAMAGED, "Mossy Cobblestone", "Damaged Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_FRENCH, "Mossy Cobblestone", "French Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_FRENCH_LIGHT, "Mossy Cobblestone", "French Tiles Light");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_HUGE, "Mossy Cobblestone", "Huge Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_LARGE, "Mossy Cobblestone", "Large Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_COBBLESTONE_TILES_SMALL, "Mossy Cobblestone", "Small Tiles");
    }

    private void addMossyTemple() {
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_BRICKS, "Mossy Temple Block", "Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_BRICKS_DISARRAY, "Mossy Temple Block", "Bricks in disarray");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_BRICKS_LARGE, "Mossy Temple Block", "Large Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_BRICKS_WORN, "Mossy Temple Block", "Worn Bricks");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_COBBLE, "Mossy Temple Block", "Cobblestone");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_COLUMN, "Mossy Temple Block", "Column");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_ORNATE, "Mossy Temple Block", "Ornate");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_PLATE, "Mossy Temple Block", "Plate");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_PLATE_CRACKED, "Mossy Temple Block", "Cracked Plate");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_STAND, "Mossy Temple Block", "Stand");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_STAND_CREEPER, "Mossy Temple Block", "Creeper Stand");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_STAND_MOSAIC, "Mossy Temple Block", "Mosaic Stand");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_TILES, "Mossy Temple Block", "Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_TILES_LIGHT, "Mossy Temple Block", "Light Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_TILES_SMALL, "Mossy Temple Block", "Small Tiles");
        addBlock(ChiselStoneBlocks.MOSSY_TEMPLE_TILES_SMALL_LIGHT, "Mossy Temple Block", "Small Light Tiles");
    }

    private void addNetherbrick() {
        addBlock(() -> Blocks.NETHER_BRICKS, "Nether Brick");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_BLUE, "Nether Brick", "Blue");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_BLUE_LAVA, "Nether Brick", "Blue with Lava");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_BROWN, "Nether Brick", "Brown");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_GUTS, "Nether Brick", "made of Guts");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_GUTS_DARK, "Nether Brick", "Dark made of Guts");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_GUTS_SMALL, "Nether Brick", "Small made of Guts");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_MEAT, "Nether Brick", "made of Meat");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_MEAT_RED, "Nether Brick", "Red made of Meat");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_MEAT_SMALL, "Nether Brick", "Small made of Meat");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_MEAT_SMALL_RED, "Nether Brick", "Small Red made of Meat");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_OBSIDIAN, "Nether Brick", "Obsidian");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_RED, "Nether Brick", "Red");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_RED_SMALL, "Nether Brick", "Small Red");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_SPATTERED, "Nether Brick", "Spattered");
        addBlock(ChiselStoneBlocks.NETHER_BRICK_STONE, "Nether Brick", "Stone");
    }

    private void addNetherrack() {
        addBlock(() -> Blocks.NETHERRACK, "Netherrack");
        addBlock(ChiselStoneBlocks.NETHERRACK_BLOOD, "Netherrack", "with Blood");
        addBlock(ChiselStoneBlocks.NETHERRACK_BLOOD_DARK, "Netherrack", "Darker with Blood");
        addBlock(ChiselStoneBlocks.NETHERRACK_BLOOD_GRAVEL, "Netherrack", "Nethergravel with Blood");
        addBlock(ChiselStoneBlocks.NETHERRACK_BLUE, "Netherrack", "Blue");
        addBlock(ChiselStoneBlocks.NETHERRACK_BLUE_SHALE, "Netherrack", "Shale Blue");
        addBlock(ChiselStoneBlocks.NETHERRACK_CLASSIC, "Netherrack", "Classic");
        addBlock(ChiselStoneBlocks.NETHERRACK_GUTS, "Netherrack", "made of Guts");
        addBlock(ChiselStoneBlocks.NETHERRACK_GUTS_DARK, "Netherrack", "Dark made of Guts");
        addBlock(ChiselStoneBlocks.NETHERRACK_LAVA, "Netherrack", "with Flowing Lava");
        addBlock(ChiselStoneBlocks.NETHERRACK_MEAT, "Netherrack", "made of Meat");
        addBlock(ChiselStoneBlocks.NETHERRACK_MEAT_RED, "Netherrack", "Red made of Meat");
        addBlock(ChiselStoneBlocks.NETHERRACK_MEAT_SMALL, "Netherrack", "made of Smaller Meat Chunks");
        addBlock(ChiselStoneBlocks.NETHERRACK_RED, "Netherrack", "Dark Red");
        addBlock(ChiselStoneBlocks.NETHERRACK_SPATTERED, "Netherrack", "Spattered");
    }

    private void addOak() {
        addBlock(() -> Blocks.OAK_PLANKS, "Oak Wood Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_BRACED, "Oak Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_BRAID, "Oak Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_CRUDE_HORIZONTAL, "Oak Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_CRUDE_PANELING, "Oak Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_CRUDE_VERTICAL, "Oak Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_ENCASED, "Oak Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_ENCASED_LARGE, "Oak Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_ENCASED_SMOOTH, "Oak Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_LARGE, "Oak Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_LOG_CABIN, "Oak Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_PANELING, "Oak Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_SHIPPING, "Oak Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_SMOOTH, "Oak Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_STACKED, "Oak Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.OAK_PLANKS_VERTICAL, "Oak Wood Planks", "Vertical Planks");
    }

    private void addObsidian() {
        addBlock(() -> Blocks.OBSIDIAN, "Obsidian");
        addBlock(ChiselStoneBlocks.OBSIDIAN_BLOCKS, "Obsidian", "Blocks");
        addBlock(ChiselStoneBlocks.OBSIDIAN_CHISELED, "Obsidian", "Chiseled");
        addBlock(ChiselStoneBlocks.OBSIDIAN_CRATE, "Obsidian", "Small Blocks inside an Oak Wood Crate");
        addBlock(ChiselStoneBlocks.OBSIDIAN_CRYSTAL, "Obsidian", "Crystal");
        addBlock(ChiselStoneBlocks.OBSIDIAN_GREEK, "Obsidian", "Light Blocks with Greek Decor");
        addBlock(ChiselStoneBlocks.OBSIDIAN_ORGANIC_CHUNKS, "Obsidian", "Organic-Looking Chunks");
        addBlock(ChiselStoneBlocks.OBSIDIAN_ORGANIC_GROWTH, "Obsidian", "Organic-Looking Growth");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PANEL, "Obsidian", "Panel");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PANEL_BRIGHT, "Obsidian", "Bright Panel");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PANEL_MAP, "Obsidian", "Panel with Map");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PANEL_REGION, "Obsidian", "Panel with Region Map");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PANEL_SHINY, "Obsidian", "Shiny Panel");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PILLAR, "Obsidian", "Pillar");
        addBlock(ChiselStoneBlocks.OBSIDIAN_PILLAR_LARGE, "Obsidian", "Large Pillar");
        addBlock(ChiselStoneBlocks.OBSIDIAN_TILES, "Obsidian", "Tiles");
    }

    private void addPackedIce() {
        addBlock(() -> Blocks.PACKED_ICE, "Packed Ice");
        addBlock(ChiselOtherBlocks.PACKED_ICE_BISMUTH, "Packed Ice", "Bismuth");
        addBlock(ChiselOtherBlocks.PACKED_ICE_BRICKS_LARGE, "Packed Ice", "Large Bricks");
        addBlock(ChiselOtherBlocks.PACKED_ICE_BRICKS_SMALL, "Packed Ice", "Small Bricks");
        addBlock(ChiselOtherBlocks.PACKED_ICE_COBBLE, "Packed Ice", "Cobble-Packed Ice");
        addBlock(ChiselOtherBlocks.PACKED_ICE_DOUBLE_SLAB, "Packed Ice", "Double Slab");
        addBlock(ChiselOtherBlocks.PACKED_ICE_GLASS_WALL, "Packed Ice", "Fancy Glass Wall");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PANEL, "Packed Ice", "Panel");
        addBlock(ChiselOtherBlocks.PACKED_ICE_POISON, "Packed Ice", "Poison");
        addBlock(ChiselOtherBlocks.PACKED_ICE_ROUGH, "Packed Ice", "Rough");
        addBlock(ChiselOtherBlocks.PACKED_ICE_ROUGH_LARGE, "Packed Ice", "Large Rough Bricks");
        addBlock(ChiselOtherBlocks.PACKED_ICE_TILES_DISORDERED, "Packed Ice", "Disordered Tiles");
        addBlock(ChiselOtherBlocks.PACKED_ICE_TILES_FANCY, "Packed Ice", "Fancy Tiles");
        addBlock(ChiselOtherBlocks.PACKED_ICE_TILES_LARGE, "Packed Ice", "Large Tiles");
        addBlock(ChiselOtherBlocks.PACKED_ICE_TILES_SUNKEN, "Packed Ice", "Sunken Tiles");
        addBlock(ChiselOtherBlocks.PACKED_ICE_ZELDA, "Packed Ice", "Zelda");
    }

    private void addPackedIcePillar() {
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_CARVED, "Packed Ice Pillar", "Carved Capstone");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_GREEK_GREEK, "Packed Ice Pillar", "Greek with Greek Capstone");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_GREEK_PLAIN, "Packed Ice Pillar", "Greek with Plain Capstone");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_INSCRIBED, "Packed Ice Pillar", "Inscribed");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_ORNAMENTAL, "Packed Ice Pillar", "Ornamental Capstone");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_PLAIN_GREEK, "Packed Ice Pillar", "Plain with Greek Capstone");
        addBlock(ChiselOtherBlocks.PACKED_ICE_PILLAR_PLAIN_PLAIN, "Packed Ice Pillar", "Plain with Plain Capstone");
    }

    private void addPaperwall() {
        addBlock(ChiselOtherBlocks.PAPERWALL_BOXED, "Paperwall", "Boxed");
        addBlock(ChiselOtherBlocks.PAPERWALL_CROSSED, "Paperwall", "Crossed");
        addBlock(ChiselOtherBlocks.PAPERWALL_DOOR, "Paperwall", "Door Shaped");
        addBlock(ChiselOtherBlocks.PAPERWALL_FLORAL, "Paperwall", "Floral Adorned");
        addBlock(ChiselOtherBlocks.PAPERWALL_PLAIN, "Paperwall", "Plain");
        addBlock(ChiselOtherBlocks.PAPERWALL_SIX, "Paperwall", "Six Sectioned");
        addBlock(ChiselOtherBlocks.PAPERWALL_STRIKE_HORIZONTAL, "Paperwall", "Horizontally Striked");
        addBlock(ChiselOtherBlocks.PAPERWALL_STRIKE_MIDDLE, "Paperwall", "Middle Striked");
        addBlock(ChiselOtherBlocks.PAPERWALL_STRIKE_VERTICAL, "Paperwall", "Vertically Striked");
    }

    private void addPaperwallBlock() {
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_BOXED, "Paperwall Block", "Boxed");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_CROSSED, "Paperwall Block", "Crossed");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_DOOR, "Paperwall Block", "Door Shaped");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_FLORAL, "Paperwall Block", "Floral Adorned");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_PLAIN, "Paperwall Block", "Plain");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_SIX, "Paperwall Block", "Six Sectioned");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_STRIKE_HORIZONTAL, "Paperwall Block", "Horizontally Striked");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_STRIKE_MIDDLE, "Paperwall Block", "Middle Striked");
        addBlock(ChiselOtherBlocks.PAPERWALL_BLOCK_STRIKE_VERTICAL, "Paperwall Block", "Vertically Striked");
    }

    private void addPumpkin() {
        addBlock(ChiselOtherBlocks.PUMPKIN_0, "Pumpkin", "Suprised");
        addBlock(ChiselOtherBlocks.PUMPKIN_1, "Pumpkin", "Smiling open");
        addBlock(ChiselOtherBlocks.PUMPKIN_10, "Pumpkin", "Exited");
        addBlock(ChiselOtherBlocks.PUMPKIN_11, "Pumpkin", "Sleeping");
        addBlock(ChiselOtherBlocks.PUMPKIN_12, "Pumpkin", "Astonished");
        addBlock(ChiselOtherBlocks.PUMPKIN_13, "Pumpkin", "Neutral");
        addBlock(ChiselOtherBlocks.PUMPKIN_14, "Pumpkin", "Laughing out loud");
        addBlock(ChiselOtherBlocks.PUMPKIN_15, "Pumpkin", "Smiling Closed");
        addBlock(ChiselOtherBlocks.PUMPKIN_16, "Pumpkin", "Astonished");
        addBlock(ChiselOtherBlocks.PUMPKIN_2, "Pumpkin", "Cheeky");
        addBlock(ChiselOtherBlocks.PUMPKIN_3, "Pumpkin", "Pensive");
        addBlock(ChiselOtherBlocks.PUMPKIN_4, "Pumpkin", "Disappointed");
        addBlock(ChiselOtherBlocks.PUMPKIN_5, "Pumpkin", "Smirking");
        addBlock(ChiselOtherBlocks.PUMPKIN_6, "Pumpkin", "Curious");
        addBlock(ChiselOtherBlocks.PUMPKIN_7, "Pumpkin", "Bored");
        addBlock(ChiselOtherBlocks.PUMPKIN_8, "Pumpkin", "Sad");
        addBlock(ChiselOtherBlocks.PUMPKIN_9, "Pumpkin", "Evil");
    }

    private void addRedstone() {
        addBlock(() -> Blocks.REDSTONE_BLOCK, "Redstone Block");
        addBlock(ChiselOtherBlocks.REDSTONE_BRICKS, "Redstone Block", "Bricks");
        addBlock(ChiselOtherBlocks.REDSTONE_BRICKS_CHAOTIC, "Redstone Block", "Chaotic Bricks");
        addBlock(ChiselOtherBlocks.REDSTONE_BRICKS_SMALL, "Redstone Block", "Small Bricks");
        addBlock(ChiselOtherBlocks.REDSTONE_CHISELED, "Redstone Block", "Chiseled");
        addBlock(ChiselOtherBlocks.REDSTONE_CIRCUIT, "Redstone Block", "Circuit");
        addBlock(ChiselOtherBlocks.REDSTONE_CIRCUIT_SUPAPLEX, "Redstone Block", "Supaplex Circuit");
        addBlock(ChiselOtherBlocks.REDSTONE_GREEK, "Redstone Block", "Greek Decoration");
        addBlock(ChiselOtherBlocks.REDSTONE_LARGE, "Redstone Block", "Large Block");
        addBlock(ChiselOtherBlocks.REDSTONE_PILLAR, "Redstone Block", "Pillar");
        addBlock(ChiselOtherBlocks.REDSTONE_SKULLS, "Redstone Block", "Skulls");
        addBlock(ChiselOtherBlocks.REDSTONE_SMALL, "Redstone Block", "Small Block");
        addBlock(ChiselOtherBlocks.REDSTONE_SMOOTH, "Redstone Block", "Smooth");
        addBlock(ChiselOtherBlocks.REDSTONE_TILES, "Redstone Block", "Tiles");
        addBlock(ChiselOtherBlocks.REDSTONE_TILES_ORNATE, "Redstone Block", "Ornate Tiles");
        addBlock(ChiselOtherBlocks.REDSTONE_ZELDA, "Redstone Block", "Zelda");
    }

    private void addRoadLine() {
        addBlock(ChiselOtherBlocks.ROAD_LINES_WHITE, "Road Lines", "White");
        addBlock(ChiselOtherBlocks.ROAD_LINES_WHITE_DOUBLE, "Road Lines", "Double White");
        addBlock(ChiselOtherBlocks.ROAD_LINES_YELLOW, "Road Lines", "Yellow");
        addBlock(ChiselOtherBlocks.ROAD_LINES_YELLOW_DOUBLE, "Road Lines", "Double Yellow");
    }

    private void addRunicVoidstone() {
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_0, "Runic Voidstone", "Voidstone - Black Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_1, "Runic Voidstone", "Voidstone - Red Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_10, "Runic Voidstone", "Voidstone - Lime Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_11, "Runic Voidstone", "Voidstone - Yellow Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_12, "Runic Voidstone", "Voidstone - Light Blue Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_13, "Runic Voidstone", "Voidstone - Magenta Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_14, "Runic Voidstone", "Voidstone - Orange Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_15, "Runic Voidstone", "Voidstone - White Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_2, "Runic Voidstone", "Voidstone - Green Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_3, "Runic Voidstone", "Voidstone - Brown Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_4, "Runic Voidstone", "Voidstone - Blue Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_5, "Runic Voidstone", "Voidstone - Purple Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_6, "Runic Voidstone", "Voidstone - Cyan Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_7, "Runic Voidstone", "Voidstone - Light Gray Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_8, "Runic Voidstone", "Voidstone - Gray Rune");
        addBlock(ChiselStoneBlocks.RUNIC_VOIDSTONE_9, "Runic Voidstone", "Voidstone - Pink Rune");
    }

    private void addSandstone() {
        addBlock(() -> Blocks.SANDSTONE, "Sandstone");
        addBlock(ChiselOtherBlocks.SANDSTONE_BLOCK, "Sandstone", "Block");
        addBlock(ChiselOtherBlocks.SANDSTONE_BLOCKS, "Sandstone", "Blocks");
        addBlock(ChiselOtherBlocks.SANDSTONE_BLOCKS_SMALL, "Sandstone", "Small Blocks");
        addBlock(ChiselOtherBlocks.SANDSTONE_FADED, "Sandstone", "Faded");
        addBlock(ChiselOtherBlocks.SANDSTONE_MOSAIC, "Sandstone", "Mosaic");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR, "Sandstone", "Pillar");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_BASE, "Sandstone", "Pillar Base");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_CAPSTONE, "Sandstone", "Pillar Capstone");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_CAPSTONE_SMOOTH, "Sandstone", "Smooth Pillar Capstone");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_SMALL, "Sandstone", "Small Pillar");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_SMALL_SMOOTH, "Sandstone", "Small Smooth Pillar");
        addBlock(ChiselOtherBlocks.SANDSTONE_PILLAR_SMOOTH, "Sandstone", "Smooth Pillar");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_0, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_1, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_10, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_11, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_12, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_13, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_14, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_15, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_2, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_3, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_4, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_5, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_6, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_7, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_8, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SCRIBBLES_9, "Sandstone", "Scribbles");
        addBlock(ChiselOtherBlocks.SANDSTONE_SMOOTH_FLAT, "Sandstone", "Smooth & Flat");
        addBlock(ChiselOtherBlocks.SANDSTONE_STACKED, "Sandstone", "Stacked Tiles");
    }

    private void addSilver() {
        addBlock(ChiselModdedBlocks.SILVER_125, "Block of Silver", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselModdedBlocks.SILVER_BOLTED, "Block of Silver", "Fancy Bolted Plating");
        addBlock(ChiselModdedBlocks.SILVER_BORDERED, "Block of Silver", "Egregiously Bordered Block");
        addBlock(ChiselModdedBlocks.SILVER_CAUTION, "Block of Silver", "Caution Stripes");
        addBlock(ChiselModdedBlocks.SILVER_SHIPPING, "Block of Silver", "Shipping Crate");
        addBlock(ChiselModdedBlocks.SILVER_THERMAL, "Block of Silver", "Thermal");
    }

    private void addSpruce() {
        addBlock(() -> Blocks.SPRUCE_PLANKS, "Spruce Wood Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_BRACED, "Spruce Wood Planks", "Braced Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_BRAID, "Spruce Wood Planks", "Braid");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_CRUDE_HORIZONTAL, "Spruce Wood Planks", "Crude Horizontal Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_CRUDE_PANELING, "Spruce Wood Planks", "Crude Paneling");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_CRUDE_VERTICAL, "Spruce Wood Planks", "Crude Vertical Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_ENCASED, "Spruce Wood Planks", "Encased Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_ENCASED_LARGE, "Spruce Wood Planks", "Encased Large Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_ENCASED_SMOOTH, "Spruce Wood Planks", "Encased Smooth");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_LARGE, "Spruce Wood Planks", "Large Planks");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_LOG_CABIN, "Spruce Wood Planks", "Log Cabin");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_PANELING, "Spruce Wood Planks", "Paneling");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_SHIPPING, "Spruce Wood Planks", "Shipping Crate");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_SMOOTH, "Spruce Wood Planks", "Smooth");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_STACKED, "Spruce Wood Planks", "Stacked");
        addBlock(ChiselWoodBlocks.SPRUCE_PLANKS_VERTICAL, "Spruce Wood Planks", "Vertical Planks");
    }

    private void addSnakestoneSand() {
        addBlock(ChiselOtherBlocks.SNAKESTONE_SAND_0, "Sand Snakestone", "Head");
        addBlock(ChiselOtherBlocks.SNAKESTONE_SAND_1, "Sand Snakestone", "Body");
    }

    private void addSnakestoneStone() {
        addBlock(ChiselOtherBlocks.SNAKESTONE_STONE_0, "Stone Snakestone", "Head");
        addBlock(ChiselOtherBlocks.SNAKESTONE_STONE_1, "Stone Snakestone", "Body");
    }

    private void addStainedGlassBlack() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLACK_BORDERLESS, "Stained Glass", "Black Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLACK_BUBBLE, "Stained Glass", "Black Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLACK_PANEL, "Stained Glass", "Black Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLACK_PANEL_FANCY, "Stained Glass", "Black Fancy Panel");
    }

    private void addStainedGlassBlue() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLUE_BORDERLESS, "Stained Glass", "Blue Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLUE_BUBBLE, "Stained Glass", "Blue Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLUE_PANEL, "Stained Glass", "Blue Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BLUE_PANEL_FANCY, "Stained Glass", "Blue Fancy Panel");
    }

    private void addStainedGlassBrown() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BROWN_BORDERLESS, "Stained Glass", "Brown Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BROWN_BUBBLE, "Stained Glass", "Brown Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BROWN_PANEL, "Stained Glass", "Brown Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_BROWN_PANEL_FANCY, "Stained Glass", "Brown Fancy Panel");
    }

    private void addStainedGlassCyan() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_CYAN_BORDERLESS, "Stained Glass", "Cyan Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_CYAN_BUBBLE, "Stained Glass", "Cyan Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_CYAN_PANEL, "Stained Glass", "Cyan Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_CYAN_PANEL_FANCY, "Stained Glass", "Cyan Fancy Panel");
    }

    private void addStainedGlassGray() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GRAY_BORDERLESS, "Stained Glass", "Gray Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GRAY_BUBBLE, "Stained Glass", "Gray Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GRAY_PANEL, "Stained Glass", "Gray Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GRAY_PANEL_FANCY, "Stained Glass", "Gray Fancy Panel");
    }

    private void addStainedGlassGreen() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GREEN_BORDERLESS, "Stained Glass", "Green Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GREEN_BUBBLE, "Stained Glass", "Green Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GREEN_PANEL, "Stained Glass", "Green Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_GREEN_PANEL_FANCY, "Stained Glass", "Green Fancy Panel");
    }

    private void addStainedGlassLightBlue() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_BLUE_BORDERLESS, "Stained Glass", "Light Blue Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_BLUE_BUBBLE, "Stained Glass", "Light Blue Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_BLUE_PANEL, "Stained Glass", "Light Blue Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_BLUE_PANEL_FANCY, "Stained Glass", "Light Blue Fancy Panel");
    }

    private void addStainedGlassLightGray() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_GRAY_BORDERLESS, "Stained Glass", "Light Gray Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_GRAY_BUBBLE, "Stained Glass", "Light Gray Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_GRAY_PANEL, "Stained Glass", "Light Gray Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIGHT_GRAY_PANEL_FANCY, "Stained Glass", "Light Gray Fancy Panel");
    }

    private void addStainedGlassLime() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIME_BORDERLESS, "Stained Glass", "Lime Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIME_BUBBLE, "Stained Glass", "Lime Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIME_PANEL, "Stained Glass", "Lime Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_LIME_PANEL_FANCY, "Stained Glass", "Lime Fancy Panel");
    }

    private void addStainedGlassMagenta() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_MAGENTA_BORDERLESS, "Stained Glass", "Magenta Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_MAGENTA_BUBBLE, "Stained Glass", "Magenta Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_MAGENTA_PANEL, "Stained Glass", "Magenta Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_MAGENTA_PANEL_FANCY, "Stained Glass", "Magenta Fancy Panel");
    }

    private void addStainedGlassOrange() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_ORANGE_BORDERLESS, "Stained Glass", "Orange Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_ORANGE_BUBBLE, "Stained Glass", "Orange Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_ORANGE_PANEL, "Stained Glass", "Orange Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_ORANGE_PANEL_FANCY, "Stained Glass", "Orange Fancy Panel");
    }

    private void addStainedGlassPink() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PINK_BORDERLESS, "Stained Glass", "Pink Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PINK_BUBBLE, "Stained Glass", "Pink Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PINK_PANEL, "Stained Glass", "Pink Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PINK_PANEL_FANCY, "Stained Glass", "Pink Fancy Panel");
    }

    private void addStainedGlassPurple() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PURPLE_BORDERLESS, "Stained Glass", "Purple Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PURPLE_BUBBLE, "Stained Glass", "Purple Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PURPLE_PANEL, "Stained Glass", "Purple Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PURPLE_PANEL_FANCY, "Stained Glass", "Purple Fancy Panel");
    }

    private void addStainedGlassRed() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_RED_BORDERLESS, "Stained Glass", "Red Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_RED_BUBBLE, "Stained Glass", "Red Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_RED_PANEL, "Stained Glass", "Red Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_RED_PANEL_FANCY, "Stained Glass", "Red Fancy Panel");
    }

    private void addStainedGlassWhite() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_WHITE_BORDERLESS, "Stained Glass", "White Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_WHITE_BUBBLE, "Stained Glass", "White Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_WHITE_PANEL, "Stained Glass", "White Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_WHITE_PANEL_FANCY, "Stained Glass", "White Fancy Panel");
    }

    private void addStainedGlassYellow() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_YELLOW_BORDERLESS, "Stained Glass", "Yellow Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_YELLOW_BUBBLE, "Stained Glass", "Yellow Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_YELLOW_PANEL, "Stained Glass", "Yellow Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_YELLOW_PANEL_FANCY, "Stained Glass", "Yellow Fancy Panel");
    }

    private void addStainedGlassPaneBlack() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLACK_BORDERLESS, "Stained Glass Pane", "Black Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLACK_BUBBLE, "Stained Glass Pane", "Black Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLACK_PANEL, "Stained Glass Pane", "Black Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLACK_PANEL_FANCY, "Stained Glass Pane", "Black Fancy Panel");
    }

    private void addStainedGlassPaneBlue() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLUE_BORDERLESS, "Stained Glass Pane", "Blue Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLUE_BUBBLE, "Stained Glass Pane", "Blue Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLUE_PANEL, "Stained Glass Pane", "Blue Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BLUE_PANEL_FANCY, "Stained Glass Pane", "Blue Fancy Panel");
    }

    private void addStainedGlassPaneBrown() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BROWN_BORDERLESS, "Stained Glass Pane", "Brown Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BROWN_BUBBLE, "Stained Glass Pane", "Brown Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BROWN_PANEL, "Stained Glass Pane", "Brown Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_BROWN_PANEL_FANCY, "Stained Glass Pane", "Brown Fancy Panel");
    }

    private void addStainedGlassPaneCyan() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_CYAN_BORDERLESS, "Stained Glass Pane", "Cyan Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_CYAN_BUBBLE, "Stained Glass Pane", "Cyan Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_CYAN_PANEL, "Stained Glass Pane", "Cyan Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_CYAN_PANEL_FANCY, "Stained Glass Pane", "Cyan Fancy Panel");
    }

    private void addStainedGlassPaneGray() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GRAY_BORDERLESS, "Stained Glass Pane", "Gray Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GRAY_BUBBLE, "Stained Glass Pane", "Gray Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GRAY_PANEL, "Stained Glass Pane", "Gray Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GRAY_PANEL_FANCY, "Stained Glass Pane", "Gray Fancy Panel");
    }

    private void addStainedGlassPaneGreen() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GREEN_BORDERLESS, "Stained Glass Pane", "Green Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GREEN_BUBBLE, "Stained Glass Pane", "Green Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GREEN_PANEL, "Stained Glass Pane", "Green Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_GREEN_PANEL_FANCY, "Stained Glass Pane", "Green Fancy Panel");
    }

    private void addStainedGlassPaneLightBlue() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_BORDERLESS, "Stained Glass Pane", "Light Blue Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_BUBBLE, "Stained Glass Pane", "Light Blue Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_PANEL, "Stained Glass Pane", "Light Blue Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_PANEL_FANCY, "Stained Glass Pane", "Light Blue Fancy Panel");
    }

    private void addStainedGlassPaneLightGray() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_BORDERLESS, "Stained Glass Pane", "Light Gray Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_BUBBLE, "Stained Glass Pane", "Light Gray Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_PANEL, "Stained Glass Pane", "Light Gray Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_PANEL_FANCY, "Stained Glass Pane", "Light Gray Fancy Panel");
    }

    private void addStainedGlassPaneLime() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIME_BORDERLESS, "Stained Glass Pane", "Lime Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIME_BUBBLE, "Stained Glass Pane", "Lime Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIME_PANEL, "Stained Glass Pane", "Lime Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_LIME_PANEL_FANCY, "Stained Glass Pane", "Lime Fancy Panel");
    }

    private void addStainedGlassPaneMagenta() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_MAGENTA_BORDERLESS, "Stained Glass Pane", "Magenta Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_MAGENTA_BUBBLE, "Stained Glass Pane", "Magenta Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_MAGENTA_PANEL, "Stained Glass Pane", "Magenta Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_MAGENTA_PANEL_FANCY, "Stained Glass Pane", "Magenta Fancy Panel");
    }

    private void addStainedGlassPaneOrange() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_ORANGE_BORDERLESS, "Stained Glass Pane", "Orange Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_ORANGE_BUBBLE, "Stained Glass Pane", "Orange Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_ORANGE_PANEL, "Stained Glass Pane", "Orange Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_ORANGE_PANEL_FANCY, "Stained Glass Pane", "Orange Fancy Panel");
    }

    private void addStainedGlassPanePink() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PINK_BORDERLESS, "Stained Glass Pane", "Pink Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PINK_BUBBLE, "Stained Glass Pane", "Pink Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PINK_PANEL, "Stained Glass Pane", "Pink Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PINK_PANEL_FANCY, "Stained Glass Pane", "Pink Fancy Panel");
    }

    private void addStainedGlassPanePurple() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PURPLE_BORDERLESS, "Stained Glass Pane", "Purple Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PURPLE_BUBBLE, "Stained Glass Pane", "Purple Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PURPLE_PANEL, "Stained Glass Pane", "Purple Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_PURPLE_PANEL_FANCY, "Stained Glass Pane", "Purple Fancy Panel");
    }

    private void addStainedGlassPaneRed() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_RED_BORDERLESS, "Stained Glass Pane", "Red Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_RED_BUBBLE, "Stained Glass Pane", "Red Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_RED_PANEL, "Stained Glass Pane", "Red Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_RED_PANEL_FANCY, "Stained Glass Pane", "Red Fancy Panel");
    }

    private void addStainedGlassPaneWhite() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_WHITE_BORDERLESS, "Stained Glass Pane", "White Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_WHITE_BUBBLE, "Stained Glass Pane", "White Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_WHITE_PANEL, "Stained Glass Pane", "White Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_WHITE_PANEL_FANCY, "Stained Glass Pane", "White Fancy Panel");
    }

    private void addStainedGlassPaneYellow() {
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_YELLOW_BORDERLESS, "Stained Glass Pane", "Yellow Borderless");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_YELLOW_BUBBLE, "Stained Glass Pane", "Yellow Bubble");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_YELLOW_PANEL, "Stained Glass Pane", "Yellow Panel");
        addBlock(ChiselStainedGlassBlocks.STAINED_GLASS_PANE_YELLOW_PANEL_FANCY, "Stained Glass Pane", "Yellow Fancy Panel");
    }

    private void addSteel() {
        addBlock(ChiselModdedBlocks.STEEL_125, "Block of Steel", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselModdedBlocks.STEEL_BOLTED, "Block of Steel", "Fancy Bolted Plating");
        addBlock(ChiselModdedBlocks.STEEL_BORDERED, "Block of Steel", "Egregiously Bordered Block");
        addBlock(ChiselModdedBlocks.STEEL_CAUTION, "Block of Steel", "Caution Stripes");
        addBlock(ChiselModdedBlocks.STEEL_SHIPPING, "Block of Steel", "Shipping Crate");
        addBlock(ChiselModdedBlocks.STEEL_THERMAL, "Block of Steel", "Thermal");
    }

    private void addStoneBricks() {
        addBlock(() -> Blocks.STONE_BRICKS, "Stone Bricks");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_DISORDERED, "Stone Bricks", "Disordered Stone Bricks");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_DISORDERED_PANEL, "Stone Bricks", "Disordered Stone Panels");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_DISORDERED_SMALL, "Stone Bricks", "Small Disordered Stone Bricks");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_FANCY, "Stone Bricks", "Stone Bricks in a Fancy Arrangement");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_FELSIC, "Stone Bricks", "Modern Felsic Masonry");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_MAFIC, "Stone Bricks", "Modern Mafic Masonry");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_NEUTRAL, "Stone Bricks", "Modern Neutral Masonry");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_ORNATE, "Stone Bricks", "Ornate Stone Brick tiles");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_ORNATE_LARGE, "Stone Bricks", "Large Ornate Stone Brick Tiles");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_PANEL, "Stone Bricks", "Stone Panel");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_PANEL_ORNATE, "Stone Bricks", "Ornate Stone Panel");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_PANEL_SUNKEN, "Stone Bricks", "Sunken Stone Panel");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_POISON, "Stone Bricks", "Poison Stone Brick");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_SMALL, "Stone Bricks", "Small Stone Bricks");
        addBlock(ChiselOtherBlocks.STONE_BRICKS_WIDE, "Stone Bricks", "Wide Stone Bricks");
    }

    private void addTechnical() {
        addBlock(ChiselMetalBlocks.TECHNICAL_125, "Technical Block", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselMetalBlocks.TECHNICAL_CABLES, "Technical Block", "Cables");
        addBlock(ChiselMetalBlocks.TECHNICAL_FAN_FAST, "Technical Block", "Fan (Fast)");
        addBlock(ChiselMetalBlocks.TECHNICAL_FAN_MALFUNCTIONING, "Technical Block", "Fan (Malfunctioning)");
        addBlock(ChiselMetalBlocks.TECHNICAL_FAN_OFF, "Technical Block", "Fan (Off)");
        addBlock(ChiselMetalBlocks.TECHNICAL_GEARS, "Technical Block", "Gears and Flywheels");
        addBlock(ChiselMetalBlocks.TECHNICAL_GRATE, "Technical Block", "Grate");
        addBlock(ChiselMetalBlocks.TECHNICAL_GRATE_RUSTY, "Technical Block", "Rusty Grate");
        addBlock(ChiselMetalBlocks.TECHNICAL_INSULATION, "Technical Block", "Insulation");
        addBlock(ChiselMetalBlocks.TECHNICAL_PANEL_CAUTION, "Technical Block", "Panels with Caution Tape");
        addBlock(ChiselMetalBlocks.TECHNICAL_PANEL_RUSTY, "Technical Block", "Rusty Panel");
        addBlock(ChiselMetalBlocks.TECHNICAL_SCAFFOLD, "Technical Block", "Scaffold");
        addBlock(ChiselMetalBlocks.TECHNICAL_UNDER_LARGE, "Technical Block", "Under-Pipe (Large Pipe)");
        addBlock(ChiselMetalBlocks.TECHNICAL_UNDER_SMALL, "Technical Block", "Under-Pipe (Small Pipes)");
        addBlock(ChiselMetalBlocks.TECHNICAL_VENTS, "Technical Block", "Vents");
        addBlock(ChiselMetalBlocks.TECHNICAL_VENTS_GLOWING, "Technical Block", "Glowing Vents");
        addBlock(ChiselMetalBlocks.TRANSPARENT_TECHNICAL_FAN_FAST, "Technical Block", "Fan (Fast)");
        addBlock(ChiselMetalBlocks.TRANSPARENT_TECHNICAL_FAN_MALFUNCTIONING, "Technical Block", "Fan (Malfunctioning)");
        addBlock(ChiselMetalBlocks.TRANSPARENT_TECHNICAL_FAN_OFF, "Technical Block", "Fan (Off)");
        addBlock(ChiselMetalBlocks.TRANSPARENT_TECHNICAL_SCAFFOLD, "Technical Block", "Scaffold");
    }

    private void addTemple() {
        addBlock(ChiselStoneBlocks.TEMPLE_BRICKS, "Temple Block", "Temple Bricks");
        addBlock(ChiselStoneBlocks.TEMPLE_BRICKS_DISARRAY, "Temple Block", "Temple Bricks in disarray");
        addBlock(ChiselStoneBlocks.TEMPLE_BRICKS_LARGE, "Temple Block", "Large Temple Bricks");
        addBlock(ChiselStoneBlocks.TEMPLE_BRICKS_WORN, "Temple Block", "Worn Temple Bricks");
        addBlock(ChiselStoneBlocks.TEMPLE_COBBLE, "Temple Block", "Temple Cobblestone");
        addBlock(ChiselStoneBlocks.TEMPLE_COLUMN, "Temple Block", "Temple Column");
        addBlock(ChiselStoneBlocks.TEMPLE_ORNATE, "Temple Block", "Ornate Temple Block");
        addBlock(ChiselStoneBlocks.TEMPLE_PLATE, "Temple Block", "Temple Plate");
        addBlock(ChiselStoneBlocks.TEMPLE_PLATE_CRACKED, "Temple Block", "Cracked Temple Plate");
        addBlock(ChiselStoneBlocks.TEMPLE_STAND, "Temple Block", "Temple Stand");
        addBlock(ChiselStoneBlocks.TEMPLE_STAND_CREEPER, "Temple Block", "Temple Creeper Stand");
        addBlock(ChiselStoneBlocks.TEMPLE_STAND_MOSAIC, "Temple Block", "Temple Mosaic Stand");
        addBlock(ChiselStoneBlocks.TEMPLE_TILES, "Temple Block", "Temple Tiles");
        addBlock(ChiselStoneBlocks.TEMPLE_TILES_LIGHT, "Temple Block", "Light Temple Tiles");
        addBlock(ChiselStoneBlocks.TEMPLE_TILES_SMALL, "Temple Block", "Small Temple Tiles");
        addBlock(ChiselStoneBlocks.TEMPLE_TILES_SMALL_LIGHT, "Temple Block", "Small Light Temple Tiles");
    }

    private void addTin() {
        addBlock(ChiselModdedBlocks.TIN_125, "Block of Tin", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselModdedBlocks.TIN_BOLTED, "Block of Tin", "Fancy Bolted Plating");
        addBlock(ChiselModdedBlocks.TIN_BORDERED, "Block of Tin", "Egregiously Bordered Block");
        addBlock(ChiselModdedBlocks.TIN_CAUTION, "Block of Tin", "Caution Stripes");
        addBlock(ChiselModdedBlocks.TIN_SHIPPING, "Block of Tin", "Shipping Crate");
        addBlock(ChiselModdedBlocks.TIN_THERMAL, "Block of Tin", "Thermal");
    }

    private void addTorch() {
        addBlock(ChiselOtherBlocks.TORCH_0, "Torch", "Wax Candle");
        addBlock(ChiselOtherBlocks.TORCH_1, "Torch", "Tall Wax Candle");
        addBlock(ChiselOtherBlocks.TORCH_2, "Torch", "White Lamp");
        addBlock(ChiselOtherBlocks.TORCH_3, "Torch", "Embroidered White Lamp");
        addBlock(ChiselOtherBlocks.TORCH_4, "Torch", "Small Black Lamp");
        addBlock(ChiselOtherBlocks.TORCH_5, "Torch", "Tall Black Lamp");
        addBlock(ChiselOtherBlocks.TORCH_6, "Torch", "Red Lamp");
        addBlock(ChiselOtherBlocks.TORCH_7, "Torch", "Embroidered Red Lamp");
        addBlock(ChiselOtherBlocks.TORCH_8, "Torch", "Light Bulb");
        addBlock(ChiselOtherBlocks.TORCH_9, "Torch", "Clear Light Bulb");
    }

    private void addTyrian() {
        addBlock(ChiselMetalBlocks.TYRIAN_BLACK, "Tyrian", "Black Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_BLACK_TILES, "Tyrian", "Black Futuristic Armor Plating Tiles");
        addBlock(ChiselMetalBlocks.TYRIAN_BLEAK, "Tyrian", "Bleak Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_BLUE, "Tyrian", "Blue Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_DENT, "Tyrian", "Futuristic Armor Plating Block with dent");
        addBlock(ChiselMetalBlocks.TYRIAN_DIAGONAL, "Tyrian", "Diagonal Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_ELABORATE, "Tyrian", "Elaborate Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_NORMAL, "Tyrian", "Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_OPENING, "Tyrian", "Black Futuristic Armor Plating Block with Opening");
        addBlock(ChiselMetalBlocks.TYRIAN_PLATFORM, "Tyrian", "Futuristic Platform Block");
        addBlock(ChiselMetalBlocks.TYRIAN_PURPLE, "Tyrian", "Purple Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_PURPLE_FADED, "Tyrian", "Faded Purple Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_RUSTED, "Tyrian", "Rusted Futuristic Armor Plating Block");
        addBlock(ChiselMetalBlocks.TYRIAN_SEAMS, "Tyrian", "Futuristic Armor Plating Block with many seams");
        addBlock(ChiselMetalBlocks.TYRIAN_SHINY, "Tyrian", "Shiny Futuristic Armor Plating");
        addBlock(ChiselMetalBlocks.TYRIAN_TILES, "Tyrian", "Futuristic Armor Plating Tiles");
    }

    private void addUranium() {
        addBlock(ChiselModdedBlocks.URANIUM_125, "Block of Uranium", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselModdedBlocks.URANIUM_BOLTED, "Block of Uranium", "Fancy Bolted Plating");
        addBlock(ChiselModdedBlocks.URANIUM_BORDERED, "Block of Uranium", "Egregiously Bordered Block");
        addBlock(ChiselModdedBlocks.URANIUM_CAUTION, "Block of Uranium", "Caution Stripes");
        addBlock(ChiselModdedBlocks.URANIUM_SHIPPING, "Block of Uranium", "Shipping Crate");
        addBlock(ChiselModdedBlocks.URANIUM_THERMAL, "Block of Uranium", "Thermal");
    }

    private void addValentines() {
        addBlock(ChiselOtherBlocks.VALENTINES_BLOCK, "Valentines Block", "Pink Panel");
        addBlock(ChiselOtherBlocks.VALENTINES_BRICKS, "Valentines Block", "Bricks");
        addBlock(ChiselOtherBlocks.VALENTINES_BUMPY, "Valentines Block", "There's a flame in my heart");
        addBlock(ChiselOtherBlocks.VALENTINES_COBBLE, "Valentines Block", "Pink Cobble");
        addBlock(ChiselOtherBlocks.VALENTINES_COMPANION, "Valentines Block", "If it speaks, I wouldn't touch it");
        addBlock(ChiselOtherBlocks.VALENTINES_EMPTY, "Valentines Block", "Heart in stone");
        addBlock(ChiselOtherBlocks.VALENTINES_FIRE, "Valentines Block", "Pink Chunk");
        addBlock(ChiselOtherBlocks.VALENTINES_HEART, "Valentines Block", "Pink Tinted Heart in stone");
        addBlock(ChiselOtherBlocks.VALENTINES_HEART_GRAY, "Valentines Block", "Pink Heart in stone");
        addBlock(ChiselOtherBlocks.VALENTINES_TILE, "Valentines Block", "Panel");
    }

    private void addVoidstone() {
        addBlock(ChiselStoneBlocks.VOIDSTONE_BEVEL, "Voidstone", "Beveled");
        addBlock(ChiselStoneBlocks.VOIDSTONE_EYE, "Voidstone", "Eye");
        addBlock(ChiselStoneBlocks.VOIDSTONE_METAL, "Voidstone", "Metal-Bordered");
        addBlock(ChiselStoneBlocks.VOIDSTONE_RAW, "Voidstone", "Raw");
        addBlock(ChiselStoneBlocks.VOIDSTONE_RUNIC, "Voidstone", "Runic");
        addBlock(ChiselStoneBlocks.VOIDSTONE_SKULL, "Voidstone", "Skull");
        addBlock(ChiselStoneBlocks.VOIDSTONE_SMOOTH, "Voidstone", "Smooth");
        addBlock(ChiselStoneBlocks.VOIDSTONE_TILES, "Voidstone", "Large Tiles");
    }

    private void addWarning() {
        addBlock(ChiselMetalBlocks.WARNING_BIOHAZARD, "Warning Sign", "Biohazard");
        addBlock(ChiselMetalBlocks.WARNING_CHEM, "Warning Sign", "Dangerous Chemicals");
        addBlock(ChiselMetalBlocks.WARNING_CONSTRUCTION, "Warning Sign", "Under Construction");
        addBlock(ChiselMetalBlocks.WARNING_CRYOGENIC, "Warning Sign", "Cryogenic Freezing in progress");
        addBlock(ChiselMetalBlocks.WARNING_DEATH, "Warning Sign", "Death");
        addBlock(ChiselMetalBlocks.WARNING_EXPLOSION, "Warning Sign", "Explosion");
        addBlock(ChiselMetalBlocks.WARNING_FALLING, "Warning Sign", "Danger of Falling");
        addBlock(ChiselMetalBlocks.WARNING_FALLING_OBJECTS, "Warning Sign", "Falling Objects");
        addBlock(ChiselMetalBlocks.WARNING_FIRE, "Warning Sign", "Fire");
        addBlock(ChiselMetalBlocks.WARNING_GENERIC, "Warning Sign", "Generic Warning");
        addBlock(ChiselMetalBlocks.WARNING_LOUD, "Warning Sign", "Loud Sounds");
        addBlock(ChiselMetalBlocks.WARNING_NO_ENTRY, "Warning Sign", "No Entry");
        addBlock(ChiselMetalBlocks.WARNING_OXYGEN, "Warning Sign", "Oxygen Required");
        addBlock(ChiselMetalBlocks.WARNING_RADIATION, "Warning Sign", "Radiation");
        addBlock(ChiselMetalBlocks.WARNING_VOLTAGE, "Warning Sign", "High Voltage");
    }

    private void addWaterstone() {
        addBlock(ChiselStoneBlocks.WATERSTONE_BLACK, "Waterstone", "Black Waterstone");
        addBlock(ChiselStoneBlocks.WATERSTONE_BRICKS, "Waterstone", "Waterstone Bricks");
        addBlock(ChiselStoneBlocks.WATERSTONE_CHAOTIC, "Waterstone", "Chaotic Waterstone Bricks");
        addBlock(ChiselStoneBlocks.WATERSTONE_CREEPER, "Waterstone", "Water Creeper in Tiles");
        addBlock(ChiselStoneBlocks.WATERSTONE_ORNATE, "Waterstone", "Ornate Water Panel");
        addBlock(ChiselStoneBlocks.WATERSTONE_PANEL, "Waterstone", "Water Panel");
        addBlock(ChiselStoneBlocks.WATERSTONE_TILES, "Waterstone", "Waterstone Tiles");
    }

    private void addWoolenClay() {
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_0, "Woolen Clay", "White");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_1, "Woolen Clay", "Orange");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_10, "Woolen Clay", "Purple");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_11, "Woolen Clay", "Blue");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_12, "Woolen Clay", "Brown");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_13, "Woolen Clay", "Green");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_14, "Woolen Clay", "Red");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_15, "Woolen Clay", "Black");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_2, "Woolen Clay", "Magenta");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_3, "Woolen Clay", "Light Blue");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_4, "Woolen Clay", "Yellow");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_5, "Woolen Clay", "Lime");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_6, "Woolen Clay", "Pink");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_7, "Woolen Clay", "Grey");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_8, "Woolen Clay", "Light Grey");
        addBlock(ChiselOtherBlocks.WOOLEN_CLAY_9, "Woolen Clay", "Cyan");
    }
}
