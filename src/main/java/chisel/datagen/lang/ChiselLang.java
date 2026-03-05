package chisel.datagen.lang;

import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
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
        addItem(ChiselItems.CHISEL_IRON, "Chisel");
        addItem(ChiselItems.CHISEL_DIAMOND, "Diamond Chisel");
        addItem(ChiselItems.CHISEL_OBSIDIAN, "Obsidian Chisel");
        addItem(ChiselItems.UPGRADE_STACK, "Stack Upgrade");
        addItem(ChiselItems.UPGRADE_SPEED, "Speed Upgrade");
        addItem(ChiselItems.UPGRADE_REVERSION, "Reversion Upgrade");
        addItem(ChiselItems.UPGRADE_AUTOMATION, "Automation Upgrade");
        addItem(ChiselItems.BALL_O_MOSS, "Ball O' Moss");
        addItem(ChiselItems.CLOUD_IN_A_BOTTLE, "Cloud in a Bottle");
        addItem(ChiselItems.SMASHING_ROCK, "Smashing Rock");
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
        addFantasy();
        addFutura();
        addGlass();
        addGlassPane();
        addGlowstone();
        addGold();
        addGranite();
        addGrimstone();
        addHexPlating();
        addHolystone();
        addIce();
        addIcePillar();
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
        addPurpledFantasy();
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
        addBlock(ChiselBlocks.ACACIA_PLANKS_SMOOTH, "Acacia Wood Planks", "Smooth");
        addBlock(ChiselBlocks.ACACIA_PLANKS_SHORT, "Acacia Wood Planks", "Short");
        addBlock(ChiselBlocks.ACACIA_PLANKS_FANCY, "Acacia Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.ACACIA_PLANKS_PANEL, "Acacia Wood Planks", "Panel");
        addBlock(ChiselBlocks.ACACIA_PLANKS_DOUBLE_SLAB, "Acacia Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.ACACIA_PLANKS_CRATE, "Acacia Wood Planks", "Crate");
        addBlock(ChiselBlocks.ACACIA_PLANKS_CRATE_FANCY, "Acacia Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.ACACIA_PLANKS_LONG, "Acacia Wood Planks", "Large Long");
        addBlock(ChiselBlocks.ACACIA_PLANKS_VERTICAL, "Acacia Wood Planks", "Vertical");
        addBlock(ChiselBlocks.ACACIA_PLANKS_VERTICAL_UNEVEN, "Acacia Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.ACACIA_PLANKS_PARQUET, "Acacia Wood Planks", "Parquet");
        addBlock(ChiselBlocks.ACACIA_PLANKS_BLINDS, "Acacia Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.ACACIA_PLANKS_SCAFFOLD, "Acacia Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.ACACIA_PLANKS_DISARRAY, "Acacia Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.ACACIA_PLANKS_DISARRAY_VERTICAL, "Acacia Wood Planks", "Vertical Planks in Disarray");
    }

    private void addAluminum() {
        addBlock(ChiselBlocks.ALUMINUM_CAUTION, "Aluminum", "Caution Stripes");
        addBlock(ChiselBlocks.ALUMINUM_SHIPPING, "Aluminum", "Shipping Crate");
        addBlock(ChiselBlocks.ALUMINUM_THERMAL, "Aluminum", "Thermal");
        addBlock(ChiselBlocks.ALUMINUM_125, "Aluminum", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.ALUMINUM_BORDERED, "Aluminum", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.ALUMINUM_BOLTED, "Aluminum", "Fancy Bolted Plating");
    }

    private void addAndesite() {
        addBlock(() -> Blocks.ANDESITE, "Andesite");
        addBlock(ChiselBlocks.ANDESITE_PILLAR, "Andesite", "Pillar");
        addBlock(ChiselBlocks.ANDESITE_BRICKS, "Andesite", "Bricks");
        addBlock(ChiselBlocks.ANDESITE_ORNATE, "Andesite", "Ornate");
        addBlock(ChiselBlocks.ANDESITE_PRISMATIC, "Andesite", "Prismatic");
        addBlock(ChiselBlocks.ANDESITE_TILES_SMALL, "Andesite", "Small Tiles");
        addBlock(ChiselBlocks.ANDESITE_POLISHED, "Andesite", "Polished");
    }

    private void addAntiblock() {
        addBlock(ChiselBlocks.ANTIBLOCK_0, "Anti Block", "Black");
        addBlock(ChiselBlocks.ANTIBLOCK_1, "Anti Block", "Blue");
        addBlock(ChiselBlocks.ANTIBLOCK_2, "Anti Block", "Brown");
        addBlock(ChiselBlocks.ANTIBLOCK_3, "Anti Block", "Cyan");
        addBlock(ChiselBlocks.ANTIBLOCK_4, "Anti Block", "Green");
        addBlock(ChiselBlocks.ANTIBLOCK_5, "Anti Block", "Light Blue");
        addBlock(ChiselBlocks.ANTIBLOCK_6, "Anti Block", "Light Gray");
        addBlock(ChiselBlocks.ANTIBLOCK_7, "Anti Block", "Lime");
        addBlock(ChiselBlocks.ANTIBLOCK_8, "Anti Block", "Magenta");
        addBlock(ChiselBlocks.ANTIBLOCK_9, "Anti Block", "Orange");
        addBlock(ChiselBlocks.ANTIBLOCK_10, "Anti Block", "Pink");
        addBlock(ChiselBlocks.ANTIBLOCK_11, "Anti Block", "Purple");
        addBlock(ChiselBlocks.ANTIBLOCK_12, "Anti Block", "Red");
        addBlock(ChiselBlocks.ANTIBLOCK_13, "Anti Block", "White");
        addBlock(ChiselBlocks.ANTIBLOCK_14, "Anti Block", "Yellow");
        addBlock(ChiselBlocks.ANTIBLOCK_15, "Anti Block", "Gray");
    }

    private void addBirch() {
        addBlock(() -> Blocks.BIRCH_PLANKS, "Birch Wood Planks");
        addBlock(ChiselBlocks.BIRCH_PLANKS_SMOOTH, "Birch Wood Planks", "Smooth");
        addBlock(ChiselBlocks.BIRCH_PLANKS_SHORT, "Birch Wood Planks", "Short");
        addBlock(ChiselBlocks.BIRCH_PLANKS_FANCY, "Birch Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.BIRCH_PLANKS_PANEL, "Birch Wood Planks", "Panel");
        addBlock(ChiselBlocks.BIRCH_PLANKS_DOUBLE_SLAB, "Birch Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.BIRCH_PLANKS_CRATE, "Birch Wood Planks", "Crate");
        addBlock(ChiselBlocks.BIRCH_PLANKS_CRATE_FANCY, "Birch Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.BIRCH_PLANKS_LONG, "Birch Wood Planks", "Large Long");
        addBlock(ChiselBlocks.BIRCH_PLANKS_VERTICAL, "Birch Wood Planks", "Vertical");
        addBlock(ChiselBlocks.BIRCH_PLANKS_VERTICAL_UNEVEN, "Birch Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.BIRCH_PLANKS_PARQUET, "Birch Wood Planks", "Parquet");
        addBlock(ChiselBlocks.BIRCH_PLANKS_BLINDS, "Birch Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.BIRCH_PLANKS_SCAFFOLD, "Birch Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.BIRCH_PLANKS_DISARRAY, "Birch Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.BIRCH_PLANKS_DISARRAY_VERTICAL, "Birch Wood Planks", "Vertical Planks in Disarray");
    }

    private void addBookshelf() {
        addBlock(() -> Blocks.BOOKSHELF, "Bookshelf");
        addBlock(ChiselBlocks.BOOKSHELF_RAINBOW, "Bookshelf", "Rainbow Books");
        addBlock(ChiselBlocks.BOOKSHELF_NECROMANCER_APPRENTICE, "Bookshelf", "Necromancer’s Apprentice");
        addBlock(ChiselBlocks.BOOKSHELF_NECROMANCER, "Bookshelf", "Necromancer's");
        addBlock(ChiselBlocks.BOOKSHELF_TOMES, "Bookshelf", "Red Tomes");
        addBlock(ChiselBlocks.BOOKSHELF_ABANDONED, "Bookshelf", "Abandoned");
        addBlock(ChiselBlocks.BOOKSHELF_HOARDER, "Bookshelf", "Hoarder's");
        addBlock(ChiselBlocks.BOOKSHELF_PASTEL, "Bookshelf", "filled to the brim with boring Pastel Books");
        addBlock(ChiselBlocks.BOOKSHELF_HISTORIAN, "Bookshelf", "Historian's");
    }

    private void addBricks() {
        addBlock(() -> Blocks.BRICKS, "Brick Block");
        addBlock(ChiselBlocks.BRICKS_LARGE, "Brick Block", "Large Bricks");
        addBlock(ChiselBlocks.BRICKS_MORTARLESS, "Brick Block", "Mortarless Bricks");
        addBlock(ChiselBlocks.BRICKS_VARIED, "Brick Block", "Varied Bricks");
        addBlock(ChiselBlocks.BRICKS_AGED, "Brick Block", "Aged Bricks");
        addBlock(ChiselBlocks.BRICKS_YELLOW, "Brick Block", "Yellow Bricks");
    }

    private void addBronze() {
        addBlock(ChiselBlocks.BRONZE_CAUTION, "Block of Bronze", "Caution Stripes");
        addBlock(ChiselBlocks.BRONZE_SHIPPING, "Block of Bronze", "Shipping Crate");
        addBlock(ChiselBlocks.BRONZE_THERMAL, "Block of Bronze", "Thermal");
        addBlock(ChiselBlocks.BRONZE_125, "Block of Bronze", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.BRONZE_BORDERED, "Block of Bronze", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.BRONZE_BOLTED, "Block of Bronze", "Fancy Bolted Plating");
    }

    private void addCarpet() {
        addBlock(ChiselBlocks.CARPET_0, "Carpet", "White");
        addBlock(ChiselBlocks.CARPET_1, "Carpet", "Orange");
        addBlock(ChiselBlocks.CARPET_2, "Carpet", "Magenta");
        addBlock(ChiselBlocks.CARPET_3, "Carpet", "Light Blue");
        addBlock(ChiselBlocks.CARPET_4, "Carpet", "Yellow");
        addBlock(ChiselBlocks.CARPET_5, "Carpet", "Light green");
        addBlock(ChiselBlocks.CARPET_6, "Carpet", "Pink");
        addBlock(ChiselBlocks.CARPET_7, "Carpet", "Dark grey");
        addBlock(ChiselBlocks.CARPET_8, "Carpet", "Grey");
        addBlock(ChiselBlocks.CARPET_9, "Carpet", "Teal");
        addBlock(ChiselBlocks.CARPET_10, "Carpet", "Purple");
        addBlock(ChiselBlocks.CARPET_11, "Carpet", "Dark blue");
        addBlock(ChiselBlocks.CARPET_12, "Carpet", "Brown");
        addBlock(ChiselBlocks.CARPET_13, "Carpet", "Green");
        addBlock(ChiselBlocks.CARPET_14, "Carpet", "Red");
        addBlock(ChiselBlocks.CARPET_15, "Carpet", "Black");
    }

    private void addCarpetFloor() {
        addBlock(ChiselBlocks.CARPET_FLOOR_0, "Floor Carpet", "White");
        addBlock(ChiselBlocks.CARPET_FLOOR_1, "Floor Carpet", "Orange");
        addBlock(ChiselBlocks.CARPET_FLOOR_2, "Floor Carpet", "Magenta");
        addBlock(ChiselBlocks.CARPET_FLOOR_3, "Floor Carpet", "Light Blue");
        addBlock(ChiselBlocks.CARPET_FLOOR_4, "Floor Carpet", "Yellow");
        addBlock(ChiselBlocks.CARPET_FLOOR_5, "Floor Carpet", "Light Green");
        addBlock(ChiselBlocks.CARPET_FLOOR_6, "Floor Carpet", "Pink");
        addBlock(ChiselBlocks.CARPET_FLOOR_7, "Floor Carpet", "Dark Grey");
        addBlock(ChiselBlocks.CARPET_FLOOR_8, "Floor Carpet", "Grey");
        addBlock(ChiselBlocks.CARPET_FLOOR_9, "Floor Carpet", "Teal");
        addBlock(ChiselBlocks.CARPET_FLOOR_10, "Floor Carpet", "Purple");
        addBlock(ChiselBlocks.CARPET_FLOOR_11, "Floor Carpet", "Dark Blue");
        addBlock(ChiselBlocks.CARPET_FLOOR_12, "Floor Carpet", "Brown");
        addBlock(ChiselBlocks.CARPET_FLOOR_13, "Floor Carpet", "Green");
        addBlock(ChiselBlocks.CARPET_FLOOR_14, "Floor Carpet", "Red");
        addBlock(ChiselBlocks.CARPET_FLOOR_15, "Floor Carpet", "Black");
    }

    private void addCloud() {
        addBlock(() -> Blocks.SNOW_BLOCK, "Cloud");
        addBlock(ChiselBlocks.CLOUD_NORMAL, "Cloud", "Block");
        addBlock(ChiselBlocks.CLOUD_GRID, "Cloud", "Gridded Bricks");
        addBlock(ChiselBlocks.CLOUD_LARGE, "Cloud", "Large Bricks");
        addBlock(ChiselBlocks.CLOUD_SMALL, "Cloud", "Small Bricks");
        addBlock(ChiselBlocks.CLOUD_VERTICAL, "Cloud", "Small Vertical Bricks");
    }

    private void addCobblestone() {
        addBlock(() -> Blocks.COBBLESTONE, "Cobblestone");
        addBlock(ChiselBlocks.COBBLESTONE_BRICKS_ALIGNED, "Cobblestone", "Aligned Bricks");
        addBlock(ChiselBlocks.COBBLESTONE_BRICKS_DETAILED, "Cobblestone", "Detailed Bricks");
        addBlock(ChiselBlocks.COBBLESTONE_BRICKS_SMALL, "Cobblestone", "Small Bricks");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_LARGE, "Cobblestone", "Large Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_SMALL, "Cobblestone", "Small Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_FRENCH, "Cobblestone", "French Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_FRENCH_LIGHT, "Cobblestone", "French Tiles Light");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_CREEPER, "Cobblestone", "Creeper Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_DAMAGED, "Cobblestone", "Damaged Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_TILES_HUGE, "Cobblestone", "Huge Tiles");
        addBlock(ChiselBlocks.COBBLESTONE_PANEL_CREEPER, "Cobblestone", "Creeper Panel");
        addBlock(ChiselBlocks.COBBLESTONE_DENT, "Cobblestone", "Dent");
        addBlock(ChiselBlocks.COBBLESTONE_PANEL, "Cobblestone", "Panel");
        addBlock(ChiselBlocks.COBBLESTONE_PANEL_LIGHT, "Cobblestone", "Light Panel");
        addBlock(ChiselBlocks.COBBLESTONE_PANEL_DARK, "Cobblestone", "Dark Panel");
    }

    private void addConcrete() {
        addBlock(ChiselBlocks.CONCRETE_RAW, "Concrete", "Raw");
        addBlock(ChiselBlocks.CONCRETE_BLOCK, "Concrete", "Block");
        addBlock(ChiselBlocks.CONCRETE_SLAB, "Concrete", "Double Slab");
        addBlock(ChiselBlocks.CONCRETE_BLOCKS, "Concrete", "Small Blocks");
        addBlock(ChiselBlocks.CONCRETE_RAW_WEATHERED, "Concrete", "Weathered Raw");
        addBlock(ChiselBlocks.CONCRETE_BLOCK_WEATHERED, "Concrete", "Weathered Block");
        addBlock(ChiselBlocks.CONCRETE_SLAB_WEATHERED, "Concrete", "Weathered Double Slab");
        addBlock(ChiselBlocks.CONCRETE_BLOCKS_WEATHERED, "Concrete", "Small Weathered Blocks");
        addBlock(ChiselBlocks.CONCRETE_RAW_PARTLY, "Concrete", "Partly Weathered Raw");
        addBlock(ChiselBlocks.CONCRETE_BLOCK_PARTLY, "Concrete", "Partly Weathered Block");
        addBlock(ChiselBlocks.CONCRETE_ASPHALT, "Concrete", "Asphalt");
    }

    private void addCopper() {
        addBlock(ChiselBlocks.COPPER_CAUTION, "Block of Copper", "Caution Stripes");
        addBlock(ChiselBlocks.COPPER_SHIPPING, "Block of Copper", "Shipping Crate");
        addBlock(ChiselBlocks.COPPER_THERMAL, "Block of Copper", "Thermal");
        addBlock(ChiselBlocks.COPPER_125, "Block of Copper", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.COPPER_BORDERED, "Block of Copper", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.COPPER_BOLTED, "Block of Copper", "Fancy Bolted Plating");
    }

    private void addDarkOak() {
        addBlock(() -> Blocks.DARK_OAK_PLANKS, "Dark Oak Wood Planks");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_SMOOTH, "Dark Oak Wood Planks", "Smooth");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_SHORT, "Dark Oak Wood Planks", "Short");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_FANCY, "Dark Oak Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_PANEL, "Dark Oak Wood Planks", "Panel");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_DOUBLE_SLAB, "Dark Oak Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_CRATE, "Dark Oak Wood Planks", "Crate");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_CRATE_FANCY, "Dark Oak Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_LONG, "Dark Oak Wood Planks", "Large Long");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_VERTICAL, "Dark Oak Wood Planks", "Vertical");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_VERTICAL_UNEVEN, "Dark Oak Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_PARQUET, "Dark Oak Wood Planks", "Parquet");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_BLINDS, "Dark Oak Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_SCAFFOLD, "Dark Oak Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_DISARRAY, "Dark Oak Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.DARK_OAK_PLANKS_DISARRAY_VERTICAL, "Dark Oak Wood Planks", "Vertical Planks in Disarray");
    }

    private void addDiamond() {
        addBlock(() -> Blocks.DIAMOND_BLOCK, "Diamond Block");
        addBlock(ChiselBlocks.DIAMOND_EMBOSSED, "Diamond Block", "Embossed");
        addBlock(ChiselBlocks.DIAMOND_PANEL, "Diamond Block", "with Panel");
        addBlock(ChiselBlocks.DIAMOND_CELLS, "Diamond Block", "Cells");
        addBlock(ChiselBlocks.DIAMOND_OBSIDIAN_PURPLE, "Diamond Block", "in Purple Obsidian");
        addBlock(ChiselBlocks.DIAMOND_OBSIDIAN, "Diamond Block", "in Obsidian");
        addBlock(ChiselBlocks.DIAMOND_SIMPLE, "Diamond Block", "Simple");
        addBlock(ChiselBlocks.DIAMOND_BISMUTH, "Diamond Block", "Bismuth");
        addBlock(ChiselBlocks.DIAMOND_CRUSHED, "Diamond Block", "Crushed");
        addBlock(ChiselBlocks.DIAMOND_SMALL_BLOCKS, "Diamond Block", "Small");
        addBlock(ChiselBlocks.DIAMOND_SMALL_BLOCKS_ORNATE, "Diamond Block", "Small Ornate");
        addBlock(ChiselBlocks.DIAMOND_ZELDA, "Diamond Block", "Zelda");
        addBlock(ChiselBlocks.DIAMOND_ORNATE, "Diamond Block", "with Ornate Layer");
    }

    private void addDiorite() {
        addBlock(() -> Blocks.DIORITE, "Diorite");
        addBlock(ChiselBlocks.DIORITE_POLISHED, "Diorite", "Polished");
        addBlock(ChiselBlocks.DIORITE_PILLAR, "Diorite", "Pillar");
        addBlock(ChiselBlocks.DIORITE_BRICKS, "Diorite", "Bricks");
        addBlock(ChiselBlocks.DIORITE_ORNATE, "Diorite", "Ornate");
        addBlock(ChiselBlocks.DIORITE_PRISMATIC, "Diorite", "Prismatic");
        addBlock(ChiselBlocks.DIORITE_TILES_SMALL, "Diorite", "Small Tiles");
    }

    private void addDirt() {
        addBlock(() -> Blocks.DIRT, "Dirt");
        addBlock(ChiselBlocks.DIRT_BRICKS_DISARRAY, "Dirt", "Bricks in Disarray");
        addBlock(ChiselBlocks.DIRT_NETHER, "Dirt", "Bricks Imitating Nether Brick Design");
        addBlock(ChiselBlocks.DIRT_BRICKS, "Dirt", "Bricks");
        addBlock(ChiselBlocks.DIRT_COBBLE, "Dirt", "Cobble-Dirt");
        addBlock(ChiselBlocks.DIRT_COBBLE_REINFORCED, "Dirt", "Reinforced Cobble-Dirt");
        addBlock(ChiselBlocks.DIRT_REINFORCED, "Dirt", "Reinforced");
        addBlock(ChiselBlocks.DIRT_HAPPY, "Dirt", "Happy");
        addBlock(ChiselBlocks.DIRT_BRICKS_LARGE, "Dirt", "Large Bricks");
        addBlock(ChiselBlocks.DIRT_BRICKS_LARGE_ON, "Dirt", "Large Bricks on top of Dirt");
        addBlock(ChiselBlocks.DIRT_HORIZONTAL, "Dirt", "Horizontal");
        addBlock(ChiselBlocks.DIRT_VERTICAL, "Dirt", "Vertical");
        addBlock(ChiselBlocks.DIRT_LAYERS, "Dirt", "Layers");
        addBlock(ChiselBlocks.DIRT_CRUMBLING, "Dirt", "Crumbling");
        addBlock(ChiselBlocks.DIRT_CHUNKY, "Dirt", "Decayed Bricks");
        addBlock(ChiselBlocks.DIRT_HORIZONTAL2, "Dirt", "Horizontal");
        addBlock(ChiselBlocks.DIRT_PLATE, "Dirt", "Dried Farmland");
    }

    private void addEmerald() {
        addBlock(() -> Blocks.EMERALD_BLOCK, "Emerald Block");
        addBlock(ChiselBlocks.EMERALD_PANEL, "Emerald Block", "Panel");
        addBlock(ChiselBlocks.EMERALD_PANEL_CLASSIC, "Emerald Block", "Classic Panel");
        addBlock(ChiselBlocks.EMERALD_SMOOTH, "Emerald Block", "Smooth");
        addBlock(ChiselBlocks.EMERALD_CHUNK, "Emerald Block", "Chunk");
        addBlock(ChiselBlocks.EMERALD_ORNATE_LAYER, "Emerald Block", "with Ornate Layer");
        addBlock(ChiselBlocks.EMERALD_ZELDA, "Emerald Block", "Zelda");
        addBlock(ChiselBlocks.EMERALD_CELL, "Emerald Block", "Cell");
        addBlock(ChiselBlocks.EMERALD_BISMUTH, "Emerald Block", "Bismuth");
        addBlock(ChiselBlocks.EMERALD_BLOCKS_SMALL, "Emerald Block", "Small Blocks");
        addBlock(ChiselBlocks.EMERALD_BLOCKS_SMALL_ORNATE, "Emerald Block", "Small Ornate Blocks");
        addBlock(ChiselBlocks.EMERALD_ORNATE, "Emerald Block", "Ornate");
    }

    private void addEnergizedVoidstone() {
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_RAW, "Energised Voidstone", "Raw");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_TILES, "Energised Voidstone", "Large Tiles");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_SMOOTH, "Energised Voidstone", "Smooth");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_SKULL, "Energised Voidstone", "Skull");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_RUNIC, "Energised Voidstone", "Runic");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_METAL, "Energised Voidstone", "Metal-Bordered");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_EYE, "Energised Voidstone", "Eye");
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_BEVEL, "Energised Voidstone", "Beveled");
    }

    private void addEnergizedVoidstonePillar() {
        addBlock(ChiselBlocks.ENERGISED_VOIDSTONE_PILLAR_NORMAL, "Energised Voidstone Pillar", "Striped");
    }

    private void addFactory() {
        addBlock(ChiselBlocks.FACTORY_RUSTY_DOTTED, "Factory Block", "Rusty Metal Plate with Dotted Pattern");
        addBlock(ChiselBlocks.FACTORY_RUSTY_PLATE, "Factory Block", "Rusty Metal Plate");
        addBlock(ChiselBlocks.FACTORY_RUSTY_VERY, "Factory Block", "Very Rusty Metal Plate");
        addBlock(ChiselBlocks.FACTORY_RUSTY_LITTLE, "Factory Block", "A Metal Plate with Little Rust");
        addBlock(ChiselBlocks.FACTORY_WIREFRAME, "Factory Block", "Wireframe");
        addBlock(ChiselBlocks.FACTORY_WIREFRAME_PURPLE, "Factory Block", "Wireframe in a Shade of Purple");
        addBlock(ChiselBlocks.FACTORY_HAZARD_YELLOW, "Factory Block", "Yellow-Black Hazard");
        addBlock(ChiselBlocks.FACTORY_HAZARD_ORANGE, "Factory Block", "Orange-White Hazard");
        addBlock(ChiselBlocks.FACTORY_CIRCUIT_FANCY, "Factory Block", "Fancy Circuit");
        addBlock(ChiselBlocks.FACTORY_METAL, "Factory Block", "Fancy Metal Box");
        addBlock(ChiselBlocks.FACTORY_GOLD_CIRCUIT, "Factory Block", "Gold-Plated Fancy Circuit");
        addBlock(ChiselBlocks.FACTORY_GOLD_PURPLE, "Factory Block", "Gold-Plated Rusty Purple");
        addBlock(ChiselBlocks.FACTORY_CONSTRUCTION, "Factory Block", "Shiny Metal Construction");
        addBlock(ChiselBlocks.FACTORY_VENT_WORN, "Factory Block", "Worn Metal Wall with Ventilation Openings");
        addBlock(ChiselBlocks.FACTORY_RUSTY_PLATES, "Factory Block", "Rusty Metal Plates");
        addBlock(ChiselBlocks.FACTORY_COLUMN, "Factory Block", "Worn Metal Column");
        addBlock(ChiselBlocks.FACTORY_BLUE, "Factory Block", "Neon Blue Plating");
        addBlock(ChiselBlocks.FACTORY_VENT_VERTICAL, "Factory Block", "Vertical Venting");
        addBlock(ChiselBlocks.FACTORY_CIRCUIT_BLUE, "Factory Block", "Metallic Blue Circuit Plating");
        addBlock(ChiselBlocks.FACTORY_WIREFRAME_BLUE, "Factory Block", "Blue Wireframing");
    }

    private void addFantasy() {
        addBlock(ChiselBlocks.FANTASY_BRICK, "Fantasy Block", "Brick");
        addBlock(ChiselBlocks.FANTASY_BRICK_FADED, "Fantasy Block", "Faded Brick");
        addBlock(ChiselBlocks.FANTASY_BRICK_WORN, "Fantasy Block", "Worn Brick");
        addBlock(ChiselBlocks.FANTASY_BRICK_DAMAGED, "Fantasy Block", "Damaged Bricks");
        addBlock(ChiselBlocks.FANTASY_DECORATION, "Fantasy Block", "Decoration");
        addBlock(ChiselBlocks.FANTASY_DECORATION_BLOCK, "Fantasy Block", "Decoration Block");
        addBlock(ChiselBlocks.FANTASY_DECORATION_PILLAR, "Fantasy Block", "Decoration Pillar");
        addBlock(ChiselBlocks.FANTASY_PILLAR, "Fantasy Block", "Pillar");
        addBlock(ChiselBlocks.FANTASY_DECORATION_SNAKE, "Fantasy Block", "Gold Snake Decoration");
        addBlock(ChiselBlocks.FANTASY_DECORATION_NOISE, "Fantasy Block", "Gold Noise Decoration");
        addBlock(ChiselBlocks.FANTASY_DECORATION_ENGRAVING, "Fantasy Block", "Gold Engravings Decoration");
        addBlock(ChiselBlocks.FANTASY_DECORATION_CHAINS, "Fantasy Block", "Gold Chains Decoration");
        addBlock(ChiselBlocks.FANTASY_DECORATION_PLATE, "Fantasy Block", "Plate Decoration");
        addBlock(ChiselBlocks.FANTASY_BLOCK, "Fantasy Block", "Block");
        addBlock(ChiselBlocks.FANTASY_BRICKS_DISARRAY, "Fantasy Block", "Bricks in disarray");
        addBlock(ChiselBlocks.FANTASY_BRICKS_DISARRAY_WORN, "Fantasy Block", "Worn Bricks in disarray");
    }

    private void addFutura() {
        addBlock(ChiselBlocks.FUTURA_SCREEN_GRAY, "Futura Block", "Glowing Screen with Metallic Borders");
        addBlock(ChiselBlocks.FUTURA_SCREEN_CYAN, "Futura Block", "Glowing Screen with Cyan Borders");
        addBlock(ChiselBlocks.FUTURA_CONTROLLER, "Futura Block", "Applied Labyrinthic Neon Lines");
        addBlock(ChiselBlocks.FUTURA_CONTROLLER_PURPLE, "Futura Block", "Applied Labyrinthic Neon Lines");
        addBlock(ChiselBlocks.FUTURA_RAINBOW, "Futura Block", "Poptart Rainbow");
    }

    private void addGlass() {
        addBlock(() -> Blocks.GLASS, "Glass");
        addBlock(ChiselBlocks.GLASS_BUBBLE, "Glass", "Bubble");
        addBlock(ChiselBlocks.GLASS_CHINESE, "Glass", "Chinese");
        addBlock(ChiselBlocks.GLASS_JAPANESE, "Glass", "Japanese");
        addBlock(ChiselBlocks.GLASS_DUNGEON, "Glass", "Dungeon");
        addBlock(ChiselBlocks.GLASS_LIGHT, "Glass", "Light");
        addBlock(ChiselBlocks.GLASS_BORDERLESS, "Glass", "Borderless");
        addBlock(ChiselBlocks.GLASS_ORNATE, "Glass", "Ornate Steel");
        addBlock(ChiselBlocks.GLASS_SCREEN, "Glass", "Screen");
        addBlock(ChiselBlocks.GLASS_SHALE, "Glass", "Shale");
        addBlock(ChiselBlocks.GLASS_STEEL, "Glass", "Steel Frame");
        addBlock(ChiselBlocks.GLASS_STONE, "Glass", "Stone Frame");
        addBlock(ChiselBlocks.GLASS_GRID_THICK, "Glass", "Thick Grid");
        addBlock(ChiselBlocks.GLASS_GRID_THIN, "Glass", "Thin Grid");
        addBlock(ChiselBlocks.GLASS_FENCE, "Glass", "Modern Iron Fence");
        addBlock(ChiselBlocks.GLASS_LEADED, "Glass", "Asymmetrical Leaded");
    }

    private void addGlassPane() {
        addBlock(() -> Blocks.GLASS_PANE, "Glass Pane");
        addBlock(ChiselBlocks.GLASS_PANE_BUBBLE, "Glass Pane", "Bubble");
        addBlock(ChiselBlocks.GLASS_PANE_BORDERLESS, "Glass Pane", "Borderless");
        addBlock(ChiselBlocks.GLASS_PANE_SCREEN, "Glass Pane", "Screen");
        addBlock(ChiselBlocks.GLASS_PANE_STREAK, "Glass Pane", "Streak");
        addBlock(ChiselBlocks.GLASS_PANE_CHINESE, "Glass Pane", "Chinese");
        addBlock(ChiselBlocks.GLASS_PANE_CHINESE_GOLD, "Glass Pane", "Chinese with Golden Frame");
        addBlock(ChiselBlocks.GLASS_PANE_JAPANESE_TILES, "Glass Pane", "Japanese");
        addBlock(ChiselBlocks.GLASS_PANE_JAPANESE_TRADITIONAL, "Glass Pane", "Ornate Japanese");
    }

    private void addGlowstone() {
        addBlock(() -> Blocks.GLOWSTONE, "Glowstone");
        addBlock(ChiselBlocks.GLOWSTONE_COBBLE, "Glowstone", "Cobble Block");
        addBlock(ChiselBlocks.GLOWSTONE_CORRODED, "Glowstone", "Corroded Blocks");
        addBlock(ChiselBlocks.GLOWSTONE_BLOCKS, "Glowstone", "Blocks with Glass");
        addBlock(ChiselBlocks.GLOWSTONE_NEON, "Glowstone", "Neon");
        addBlock(ChiselBlocks.GLOWSTONE_ORNATE, "Glowstone", "Ornate Blocks");
        addBlock(ChiselBlocks.GLOWSTONE_ROCKY, "Glowstone", "Rocky");
        addBlock(ChiselBlocks.GLOWSTONE_SHALE, "Glowstone", "Shale-Shaped");
        addBlock(ChiselBlocks.GLOWSTONE_TILES, "Glowstone", "Tiles");
        addBlock(ChiselBlocks.GLOWSTONE_FANCY, "Glowstone", "Fancy Lantern");
        addBlock(ChiselBlocks.GLOWSTONE_CRUMBLING, "Glowstone", "Crumbling Block");
        addBlock(ChiselBlocks.GLOWSTONE_ORGANIC, "Glowstone", "Organic Growth Block");
        addBlock(ChiselBlocks.GLOWSTONE_LAYERS, "Glowstone", "Layers");
        addBlock(ChiselBlocks.GLOWSTONE_CORRODED_TILES, "Glowstone", "Corroded Tiles");
        addBlock(ChiselBlocks.GLOWSTONE_BISMUTH, "Glowstone", "Bismuth");
        addBlock(ChiselBlocks.GLOWSTONE_BISMUTH_PANEL, "Glowstone", "Bismuth Panel");
    }

    private void addGold() {
        addBlock(() -> Blocks.GOLD_BLOCK, "Block of Gold");
        addBlock(ChiselBlocks.GOLD_INGOTS_LARGE, "Block of Gold", "Large Golden Ingots");
        addBlock(ChiselBlocks.GOLD_INGOTS_SMALL, "Block of Gold", "Small Golden Ingots");
        addBlock(ChiselBlocks.GOLD_BRICKS, "Block of Gold", "Golden Bricks");
        addBlock(ChiselBlocks.GOLD_CART, "Block of Gold", "Gold Cart");
        addBlock(ChiselBlocks.GOLD_COIN_HEADS, "Block of Gold", "Golden Coin Stack Heads-up");
        addBlock(ChiselBlocks.GOLD_COIN_TAILS, "Block of Gold", "Golden Coin Stack Heads-down");
        addBlock(ChiselBlocks.GOLD_CRATE_DARK, "Block of Gold", "Dark Gold Crate");
        addBlock(ChiselBlocks.GOLD_CRATE_LIGHT, "Block of Gold", "Light Gold Crate");
        addBlock(ChiselBlocks.GOLD_PLATES, "Block of Gold", "Golden Plates");
        addBlock(ChiselBlocks.GOLD_RIVETS, "Block of Gold", "Gold Plates with Rivets");
        addBlock(ChiselBlocks.GOLD_STAR_DECOR, "Block of Gold", "with Star Decoration");
        addBlock(ChiselBlocks.GOLD_STAR_OBSIDIAN_PURPLE, "Block of Gold", "Golden Star in Purple Obsidian");
        addBlock(ChiselBlocks.GOLD_STAR_OBSIDIAN, "Block of Gold", "Golden Star in Obsidian");
        addBlock(ChiselBlocks.GOLD_SIMPLE, "Block of Gold", "Simple");
        addBlock(ChiselBlocks.GOLD_CAUTION, "Block of Gold", "Caution Stripes");
        addBlock(ChiselBlocks.GOLD_SHIPPING, "Block of Gold", "Shipping Crate");
        addBlock(ChiselBlocks.GOLD_THERMAL, "Block of Gold", "Thermal");
        addBlock(ChiselBlocks.GOLD_125, "Block of Gold", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.GOLD_BORDERED, "Block of Gold", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.GOLD_BOLTED, "Block of Gold", "Fancy Bolted Plating");
    }

    private void addGranite() {
        addBlock(() -> Blocks.GRANITE, "Granite");
        addBlock(ChiselBlocks.GRANITE_POLISHED, "Granite", "Polished");
        addBlock(ChiselBlocks.GRANITE_PILLAR, "Granite", "Pillar");
        addBlock(ChiselBlocks.GRANITE_BRICKS, "Granite", "Bricks");
        addBlock(ChiselBlocks.GRANITE_ORNATE, "Granite", "Ornate");
        addBlock(ChiselBlocks.GRANITE_PRISMATIC, "Granite", "Prismatic");
        addBlock(ChiselBlocks.GRANITE_TILES_SMALL, "Granite", "Small Tiles");
    }

    private void addGrimstone() {
        addBlock(ChiselBlocks.GRIMSTONE_RAW, "Grimstone", "Raw");
        addBlock(ChiselBlocks.GRIMSTONE_SMOOTH, "Grimstone", "Smooth");
        addBlock(ChiselBlocks.GRIMSTONE_SYMBOL, "Grimstone", "Symbol");
        addBlock(ChiselBlocks.GRIMSTONE_CHISELED, "Grimstone", "Chiseled");
        addBlock(ChiselBlocks.GRIMSTONE_BLOCKS, "Grimstone", "Blocks");
        addBlock(ChiselBlocks.GRIMSTONE_BLOCKS_ROUGH, "Grimstone", "Rough Blocks");
        addBlock(ChiselBlocks.GRIMSTONE_BRICKS, "Grimstone", "Bricks");
        addBlock(ChiselBlocks.GRIMSTONE_BRICKS_LARGE, "Grimstone", "Large Bricks");
        addBlock(ChiselBlocks.GRIMSTONE_PLATFORM, "Grimstone", "Platform");
        addBlock(ChiselBlocks.GRIMSTONE_PLATFORM_TILES, "Grimstone", "Platform Tiles");
        addBlock(ChiselBlocks.GRIMSTONE_CONSTRUCTION, "Grimstone", "Construction");
        addBlock(ChiselBlocks.GRIMSTONE_TILES, "Grimstone", "Tiles");
        addBlock(ChiselBlocks.GRIMSTONE_PLATE_SMOOTH, "Grimstone", "Smooth Plate");
        addBlock(ChiselBlocks.GRIMSTONE_PLATE, "Grimstone", "Plate");
        addBlock(ChiselBlocks.GRIMSTONE_FLAKY, "Grimstone", "Flaky");
    }

    private void addHexPlating() {
        addBlock(ChiselBlocks.HEX_PLATING_0, "Hex Plating", "Black");
        addBlock(ChiselBlocks.HEX_PLATING_1, "Hex Plating", "Blue");
        addBlock(ChiselBlocks.HEX_PLATING_2, "Hex Plating", "Brown");
        addBlock(ChiselBlocks.HEX_PLATING_3, "Hex Plating", "Cyan");
        addBlock(ChiselBlocks.HEX_PLATING_4, "Hex Plating", "Green");
        addBlock(ChiselBlocks.HEX_PLATING_5, "Hex Plating", "Light Blue");
        addBlock(ChiselBlocks.HEX_PLATING_6, "Hex Plating", "Light Gray");
        addBlock(ChiselBlocks.HEX_PLATING_7, "Hex Plating", "Lime");
        addBlock(ChiselBlocks.HEX_PLATING_8, "Hex Plating", "Magenta");
        addBlock(ChiselBlocks.HEX_PLATING_9, "Hex Plating", "Orange");
        addBlock(ChiselBlocks.HEX_PLATING_10, "Hex Plating", "Pink");
        addBlock(ChiselBlocks.HEX_PLATING_11, "Hex Plating", "Purple");
        addBlock(ChiselBlocks.HEX_PLATING_12, "Hex Plating", "Red");
        addBlock(ChiselBlocks.HEX_PLATING_13, "Hex Plating", "White");
        addBlock(ChiselBlocks.HEX_PLATING_14, "Hex Plating", "Yellow");
        addBlock(ChiselBlocks.HEX_PLATING_15, "Hex Plating", "Gray");
    }

    private void addHolystone() {
        addBlock(ChiselBlocks.HOLYSTONE_RAW, "Holystone", "Raw");
        addBlock(ChiselBlocks.HOLYSTONE_SMOOTH, "Holystone", "Smooth");
        addBlock(ChiselBlocks.HOLYSTONE_SYMBOL, "Holystone", "Symbol");
        addBlock(ChiselBlocks.HOLYSTONE_CHISELED, "Holystone", "Chiseled");
        addBlock(ChiselBlocks.HOLYSTONE_BLOCKS, "Holystone", "Blocks");
        addBlock(ChiselBlocks.HOLYSTONE_BLOCKS_ROUGH, "Holystone", "Rough Blocks");
        addBlock(ChiselBlocks.HOLYSTONE_BRICKS, "Holystone", "Bricks");
        addBlock(ChiselBlocks.HOLYSTONE_BRICKS_LARGE, "Holystone", "Large Bricks");
        addBlock(ChiselBlocks.HOLYSTONE_PLATFORM, "Holystone", "Platform");
        addBlock(ChiselBlocks.HOLYSTONE_PLATFORM_TILES, "Holystone", "Platform Tiles");
        addBlock(ChiselBlocks.HOLYSTONE_CONSTRUCTION, "Holystone", "Construction");
        addBlock(ChiselBlocks.HOLYSTONE_TILES, "Holystone", "Tiles");
        addBlock(ChiselBlocks.HOLYSTONE_PLATE_SMOOTH, "Holystone", "Smooth Plate");
        addBlock(ChiselBlocks.HOLYSTONE_PLATE, "Holystone", "Plate");
    }

    private void addIce() {
        addBlock(() -> Blocks.ICE, "Ice");
        addBlock(ChiselBlocks.ICE_ROUGH, "Ice", "Rough");
        addBlock(ChiselBlocks.ICE_COBBLE, "Ice", "Cobble-Ice");
        addBlock(ChiselBlocks.ICE_ROUGH_LARGE, "Ice", "Large Rough Bricks");
        addBlock(ChiselBlocks.ICE_BRICKS_LARGE, "Ice", "Large Bricks");
        addBlock(ChiselBlocks.ICE_BRICKS_SMALL, "Ice", "Small Bricks");
        addBlock(ChiselBlocks.ICE_GLASS_WALL, "Ice", "Fancy Glass Wall");
        addBlock(ChiselBlocks.ICE_TILES_LARGE, "Ice", "Large Tiles");
        addBlock(ChiselBlocks.ICE_TILES_FANCY, "Ice", "Fancy Tiles");
        addBlock(ChiselBlocks.ICE_TILES_SUNKEN, "Ice", "Sunken Tiles");
        addBlock(ChiselBlocks.ICE_TILES_DISORDERED, "Ice", "Disordered Tiles");
        addBlock(ChiselBlocks.ICE_PANEL, "Ice", "Panel");
        addBlock(ChiselBlocks.ICE_DOUBLE_SLAB, "Ice", "Double Slab");
        addBlock(ChiselBlocks.ICE_ZELDA, "Ice", "Zelda");
        addBlock(ChiselBlocks.ICE_BISMUTH, "Ice", "Bismuth");
        addBlock(ChiselBlocks.ICE_POISON, "Ice", "Poison");
    }

    private void addIcePillar() {
        addBlock(ChiselBlocks.ICE_PILLAR_PLAIN_PLAIN, "Ice Pillar", "Plain with Plain Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_PLAIN_GREEK, "Ice Pillar", "Plain with Greek Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_GREEK_PLAIN, "Ice Pillar", "Greek with Plain Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_GREEK_GREEK, "Ice Pillar", "Greek with Greek Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_CARVED, "Ice Pillar", "Carved Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_ORNAMENTAL, "Ice Pillar", "Ornamental Capstone");
        addBlock(ChiselBlocks.ICE_PILLAR_INSCRIBED, "Ice Pillar", "Inscribed");
    }

    private void addIron() {
        addBlock(() -> Blocks.IRON_BLOCK, "Block of Iron");
        addBlock(ChiselBlocks.IRON_INGOTS_LARGE, "Block of Iron", "Large Iron Ingots");
        addBlock(ChiselBlocks.IRON_INGOTS_SMALL, "Block of Iron", "Small Iron Ingots");
        addBlock(ChiselBlocks.IRON_GEARS, "Block of Iron", "Iron Gears");
        addBlock(ChiselBlocks.IRON_BRICKS, "Block of Iron", "Iron Bricks");
        addBlock(ChiselBlocks.IRON_PLATES, "Block of Iron", "Iron Plates");
        addBlock(ChiselBlocks.IRON_RIVETS, "Block of Iron", "Iron Plates with Rivets");
        addBlock(ChiselBlocks.IRON_COIN_HEADS, "Block of Iron", "Iron Coin Stack Heads-up");
        addBlock(ChiselBlocks.IRON_COIN_TAILS, "Block of Iron", "Iron Coin Stack Heads-down");
        addBlock(ChiselBlocks.IRON_CRATE_DARK, "Block of Iron", "Dark Iron Crate");
        addBlock(ChiselBlocks.IRON_CRATE_LIGHT, "Block of Iron", "Light Iron Crate");
        addBlock(ChiselBlocks.IRON_MOON_DECOR, "Block of Iron", "with Moon Decoration");
        addBlock(ChiselBlocks.IRON_MOON_OBSIDIAN_PURPLE, "Block of Iron", "Iron Moon in Purple Obsidian");
        addBlock(ChiselBlocks.IRON_MOON_OBSIDIAN, "Block of Iron", "Iron Moon in Obsidian");
        addBlock(ChiselBlocks.IRON_VENTS, "Block of Iron", "Iron Vents");
        addBlock(ChiselBlocks.IRON_SIMPLE, "Block of Iron", "Simple");
        addBlock(ChiselBlocks.IRON_CAUTION, "Block of Iron", "Caution Stripes");
        addBlock(ChiselBlocks.IRON_SHIPPING, "Block of Iron", "Shipping Crate");
        addBlock(ChiselBlocks.IRON_THERMAL, "Block of Iron", "Thermal");
        addBlock(ChiselBlocks.IRON_125, "Block of Iron", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.IRON_BORDERED, "Block of Iron", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.IRON_BOLTED, "Block of Iron", "Fancy Bolted Plating");
    }

    private void addIronBars() {
        addBlock(() -> Blocks.IRON_BARS, "Iron Bars");
        addBlock(ChiselBlocks.IRON_BARS_NO_FRAME, "Iron Bars", "without Frame");
        addBlock(ChiselBlocks.IRON_BARS_MENACING, "Iron Bars", "Menacing");
        addBlock(ChiselBlocks.IRON_BARS_CAGE, "Iron Bars", "Cage");
        addBlock(ChiselBlocks.IRON_BARS_MENACING_SPIKES, "Iron Bars", "Menacing Spikes");
        addBlock(ChiselBlocks.IRON_BARS_GRID_THICK, "Iron Bars", "Thick Grid");
        addBlock(ChiselBlocks.IRON_BARS_GRID_THIN, "Iron Bars", "Thin Grid");
        addBlock(ChiselBlocks.IRON_BARS_ORNATE, "Iron Bars", "Ornate");
        addBlock(ChiselBlocks.IRON_BARS_VERTICAL, "Iron Bars", "Vertical");
        addBlock(ChiselBlocks.IRON_BARS_SPIKES, "Iron Bars", "Spikes");
    }

    private void addJungle() {
        addBlock(() -> Blocks.JUNGLE_PLANKS, "Jungle Wood Planks");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_SMOOTH, "Jungle Wood Planks", "Smooth");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_SHORT, "Jungle Wood Planks", "Short");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_FANCY, "Jungle Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_PANEL, "Jungle Wood Planks", "Panel");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_DOUBLE_SLAB, "Jungle Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_CRATE, "Jungle Wood Planks", "Crate");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_CRATE_FANCY, "Jungle Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_LONG, "Jungle Wood Planks", "Large Long");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_VERTICAL, "Jungle Wood Planks", "Vertical");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_VERTICAL_UNEVEN, "Jungle Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_PARQUET, "Jungle Wood Planks", "Parquet");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_BLINDS, "Jungle Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_SCAFFOLD, "Jungle Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_DISARRAY, "Jungle Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.JUNGLE_PLANKS_DISARRAY_VERTICAL, "Jungle Wood Planks", "Vertical Planks in Disarray");
    }

    private void addLaboratory() {
        addBlock(ChiselBlocks.LABORATORY_PANEL_WALL, "Laboratory Block", "Wall Panel");
        addBlock(ChiselBlocks.LABORATORY_PANEL_DOTTED, "Laboratory Block", "Dotted Panel");
        addBlock(ChiselBlocks.LABORATORY_WALL, "Laboratory Block", "Enamelled Wall");
        addBlock(ChiselBlocks.LABORATORY_WALL_ROUNDED, "Laboratory Block", "Enamelled Roundel Wall");
        addBlock(ChiselBlocks.LABORATORY_WALL_VENT, "Laboratory Block", "Enamelled Wall Vents");
        addBlock(ChiselBlocks.LABORATORY_TILES_ENAMELLED_LARGE, "Laboratory Block", "Large Enamelled Tile");
        addBlock(ChiselBlocks.LABORATORY_TILES_ENAMELLED_SMALL, "Laboratory Block", "Small Enamelled Tiles");
        addBlock(ChiselBlocks.LABORATORY_FLOOR, "Laboratory Block", "Laboratory Floor");
        addBlock(ChiselBlocks.LABORATORY_CHECKERBOARD, "Laboratory Block", "Checkerboard Floor");
        addBlock(ChiselBlocks.LABORATORY_PANEL_CLEAR, "Laboratory Block", "Clear Panel");
        addBlock(ChiselBlocks.LABORATORY_PANEL_FUZZY, "Laboratory Block", "Fuzzy Panel");
        addBlock(ChiselBlocks.LABORATORY_TILES_STEEL_LARGE, "Laboratory Block", "Large Steel Tile");
        addBlock(ChiselBlocks.LABORATORY_TILES_STEEL_SMALL, "Laboratory Block", "Small Steel Tiles");
        addBlock(ChiselBlocks.LABORATORY_CONSOLE_RIGHT, "Laboratory Block", "Direction Console (Right)");
        addBlock(ChiselBlocks.LABORATORY_CONSOLE_LEFT, "Laboratory Block", "Direction Console (Left)");
        addBlock(ChiselBlocks.LABORATORY_CONSOLE_INFORMATION, "Laboratory Block", "Information Console");
    }

    private void addLapis() {
        addBlock(() -> Blocks.LAPIS_BLOCK, "Lapis Block");
        addBlock(ChiselBlocks.LAPIS_CHUNKY, "Lapis Block", "Chunky");
        addBlock(ChiselBlocks.LAPIS_DARK, "Lapis Block", "Dark");
        addBlock(ChiselBlocks.LAPIS_ZELDA, "Lapis Block", "Zelda");
        addBlock(ChiselBlocks.LAPIS_ORNATE, "Lapis Block", "Ornate");
        addBlock(ChiselBlocks.LAPIS_TILE, "Lapis Block", "Tile");
        addBlock(ChiselBlocks.LAPIS_PANEL, "Lapis Block", "Panel");
        addBlock(ChiselBlocks.LAPIS_SMOOTH, "Lapis Block", "Smooth");
        addBlock(ChiselBlocks.LAPIS_ORNATE_LAYER, "Lapis Block", "with Ornate Layer");
    }

    private void addLargeHexPlating() {
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_0, "Large Hex Plating", "Black");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_1, "Large Hex Plating", "Blue");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_2, "Large Hex Plating", "Brown");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_3, "Large Hex Plating", "Cyan");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_4, "Large Hex Plating", "Green");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_5, "Large Hex Plating", "Light Blue");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_6, "Large Hex Plating", "Light Gray");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_7, "Large Hex Plating", "Lime");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_8, "Large Hex Plating", "Magenta");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_9, "Large Hex Plating", "Orange");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_10, "Large Hex Plating", "Pink");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_11, "Large Hex Plating", "Purple");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_12, "Large Hex Plating", "Red");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_13, "Large Hex Plating", "White");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_14, "Large Hex Plating", "Yellow");
        addBlock(ChiselBlocks.LARGE_HEX_PLATING_15, "Large Hex Plating", "Gray");
    }

    private void addLavastone() {
        addBlock(ChiselBlocks.LAVASTONE_RAW, "Lavastone", "Raw");
        addBlock(ChiselBlocks.LAVASTONE_BLACK, "Lavastone", "Black");
        addBlock(ChiselBlocks.LAVASTONE_TILES, "Lavastone", "Tiles");
        addBlock(ChiselBlocks.LAVASTONE_BRICKS, "Lavastone", "Chaotic Bricks");
        addBlock(ChiselBlocks.LAVASTONE_TILES_CREEPER, "Lavastone", "Creeper in Tiles");
        addBlock(ChiselBlocks.LAVASTONE_PANEL, "Lavastone", "Panel");
        addBlock(ChiselBlocks.LAVASTONE_PANEL_ORNATE, "Lavastone", "Ornate Panel");
        addBlock(ChiselBlocks.LAVASTONE_DARK, "Lavastone", "Dark");
    }

    private void addLead() {
        addBlock(ChiselBlocks.LEAD_CAUTION, "Block of Lead", "Caution Stripes");
        addBlock(ChiselBlocks.LEAD_SHIPPING, "Block of Lead", "Shipping Crate");
        addBlock(ChiselBlocks.LEAD_THERMAL, "Block of Lead", "Thermal");
        addBlock(ChiselBlocks.LEAD_125, "Block of Lead", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.LEAD_BORDERED, "Block of Lead", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.LEAD_BOLTED, "Block of Lead", "Fancy Bolted Plating");
    }

    private void addLeaf() {
        addBlock(ChiselBlocks.LEAVES_DEAD, "Leaf", "Dead");
        addBlock(ChiselBlocks.LEAVES_FANCY, "Leaf", "Fancy");
        addBlock(ChiselBlocks.LEAVES_PINK, "Leaf", "Pink Petals");
        addBlock(ChiselBlocks.LEAVES_RED, "Leaf", "Red Rose");
        addBlock(ChiselBlocks.LEAVES_WHITE, "Leaf", "White Rose");
        addBlock(ChiselBlocks.LEAVES_CHRISTMAS_BALLS, "Leaf", "Christmas Balls");
        addBlock(ChiselBlocks.LEAVES_CHRISTMAS_LIGHTS, "Leaf", "Christmas Lights");
    }

    private void addLimestone() {
        addBlock(ChiselBlocks.LIMESTONE_RAW, "Limestone", "Raw");
        addBlock(ChiselBlocks.LIMESTONE_TILES, "Limestone", "Small Tiles");
        addBlock(ChiselBlocks.LIMESTONE_TILES_FRENCH, "Limestone", "French Tiles");
        addBlock(ChiselBlocks.LIMESTONE_TILES_FRENCH_LIGHT, "Limestone", "French Tiles Light");
        addBlock(ChiselBlocks.LIMESTONE_TILES_CREEPER, "Limestone", "Creeper Tiles");
        addBlock(ChiselBlocks.LIMESTONE_TILES_DAMAGED, "Limestone", "Damaged Tiles");
        addBlock(ChiselBlocks.LIMESTONE_TILES_LARGE, "Limestone", "Large Tiles");
        addBlock(ChiselBlocks.LIMESTONE_BRICKS, "Limestone", "Small Bricks");
        addBlock(ChiselBlocks.LIMESTONE_SMOOTH, "Limestone", "Smooth");
        addBlock(ChiselBlocks.LIMESTONE_PANEL_ORNATE, "Limestone", "with Ornate Panel");
        addBlock(ChiselBlocks.LIMESTONE_PANEL_ENGRAVED, "Limestone", "with Engraved Ornate Panel");
        addBlock(ChiselBlocks.LIMESTONE_PANEL_CREEPER, "Limestone", "with Creeper Panel");
        addBlock(ChiselBlocks.LIMESTONE_PANEL_LIGHT, "Limestone", "with Light Panel");
        addBlock(ChiselBlocks.LIMESTONE_PANEL_DARK, "Limestone", "with Dark Panel");
        addBlock(ChiselBlocks.LIMESTONE_PANEL, "Limestone", "with Panel");
        addBlock(ChiselBlocks.LIMESTONE_DENT, "Limestone", "with Dent");
    }

    private void addLitPumpkin() {
        addBlock(ChiselBlocks.LITPUMPKIN_0, "Jack-O-Lantern", "Suprised");
        addBlock(ChiselBlocks.LITPUMPKIN_1, "Jack-O-Lantern", "Smiling open");
        addBlock(ChiselBlocks.LITPUMPKIN_2, "Jack-O-Lantern", "Cheeky");
        addBlock(ChiselBlocks.LITPUMPKIN_3, "Jack-O-Lantern", "Pensive");
        addBlock(ChiselBlocks.LITPUMPKIN_4, "Jack-O-Lantern", "Disappointed");
        addBlock(ChiselBlocks.LITPUMPKIN_5, "Jack-O-Lantern", "Smirking");
        addBlock(ChiselBlocks.LITPUMPKIN_6, "Jack-O-Lantern", "Curious");
        addBlock(ChiselBlocks.LITPUMPKIN_7, "Jack-O-Lantern", "Bored");
        addBlock(ChiselBlocks.LITPUMPKIN_8, "Jack-O-Lantern", "Sad");
        addBlock(ChiselBlocks.LITPUMPKIN_9, "Jack-O-Lantern", "Evil");
        addBlock(ChiselBlocks.LITPUMPKIN_10, "Jack-O-Lantern", "Exited");
        addBlock(ChiselBlocks.LITPUMPKIN_11, "Jack-O-Lantern", "Sleeping");
        addBlock(ChiselBlocks.LITPUMPKIN_12, "Jack-O-Lantern", "Astonished");
        addBlock(ChiselBlocks.LITPUMPKIN_13, "Jack-O-Lantern", "Neutral");
        addBlock(ChiselBlocks.LITPUMPKIN_14, "Jack-O-Lantern", "Laughing out loud");
        addBlock(ChiselBlocks.LITPUMPKIN_15, "Jack-O-Lantern", "Smiling Closed");
        addBlock(ChiselBlocks.LITPUMPKIN_16, "Jack-O-Lantern", "Astonished");
    }

    private void addMarble() {
        addBlock(ChiselBlocks.MARBLE_RAW, "Marble", "Raw");
        addBlock(ChiselBlocks.MARBLE_BRICK, "Marble", "Brick");
        addBlock(ChiselBlocks.MARBLE_PANEL_CLASSIC, "Marble", "Classic Panel");
        addBlock(ChiselBlocks.MARBLE_PANEL_ORNATE, "Marble", "Ornate Panel");
        addBlock(ChiselBlocks.MARBLE_PANEL, "Marble", "Panel");
        addBlock(ChiselBlocks.MARBLE_BLOCK, "Marble", "Block");
        addBlock(ChiselBlocks.MARBLE_CREEPER_DARK, "Marble", "Dark Creeper");
        addBlock(ChiselBlocks.MARBLE_CREEPER_LIGHT, "Marble", "Light Creeper");
        addBlock(ChiselBlocks.MARBLE_CARVED, "Marble", "Carved");
        addBlock(ChiselBlocks.MARBLE_CARVED_RADIAL, "Marble", "Radial Carved");
        addBlock(ChiselBlocks.MARBLE_DENT, "Marble", "with Dent");
        addBlock(ChiselBlocks.MARBLE_DENT_LARGE, "Marble", "with Large Dent");
        addBlock(ChiselBlocks.MARBLE_TILES, "Marble", "Tiles");
        addBlock(ChiselBlocks.MARBLE_TILES_ARRANGED, "Marble", "Arranged Tiles");
        addBlock(ChiselBlocks.MARBLE_TILES_FANCY, "Marble", "Fancy Tiles");
        addBlock(ChiselBlocks.MARBLE_BLOCKS, "Marble", "Blocks");
    }

    private void addMossyCobblestone() {
        addBlock(() -> Blocks.MOSSY_COBBLESTONE, "Mossy Cobblestone");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_BRICKS_ALIGNED, "Mossy Cobblestone", "Aligned Bricks");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_BRICKS_DETAILED, "Mossy Cobblestone", "Detailed Bricks");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_BRICKS_SMALL, "Mossy Cobblestone", "Small Bricks");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_LARGE, "Mossy Cobblestone", "Large Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_SMALL, "Mossy Cobblestone", "Small Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_FRENCH, "Mossy Cobblestone", "French Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_FRENCH_LIGHT, "Mossy Cobblestone", "French Tiles Light");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_CREEPER, "Mossy Cobblestone", "Creeper Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_DAMAGED, "Mossy Cobblestone", "Damaged Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_TILES_HUGE, "Mossy Cobblestone", "Huge Tiles");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_PANEL_CREEPER, "Mossy Cobblestone", "Creeper Panel");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_DENT, "Mossy Cobblestone", "Dent");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_PANEL, "Mossy Cobblestone", "Pane");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_PANEL_LIGHT, "Mossy Cobblestone", "Light Panel");
        addBlock(ChiselBlocks.MOSSY_COBBLESTONE_PANEL_DARK, "Mossy Cobblestone", "Dark Panel");
    }

    private void addMossyTemple() {
        addBlock(ChiselBlocks.MOSSY_TEMPLE_COBBLE, "Mossy Temple Block", "Cobblestone");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_ORNATE, "Mossy Temple Block", "Ornate");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_PLATE, "Mossy Temple Block", "Plate");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_PLATE_CRACKED, "Mossy Temple Block", "Cracked Plate");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_BRICKS, "Mossy Temple Block", "Bricks");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_BRICKS_LARGE, "Mossy Temple Block", "Large Bricks");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_BRICKS_WORN, "Mossy Temple Block", "Worn Bricks");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_BRICKS_DISARRAY, "Mossy Temple Block", "Bricks in disarray");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_COLUMN, "Mossy Temple Block", "Column");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_STAND, "Mossy Temple Block", "Stand");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_STAND_MOSAIC, "Mossy Temple Block", "Mosaic Stand");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_STAND_CREEPER, "Mossy Temple Block", "Creeper Stand");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_TILES, "Mossy Temple Block", "Tiles");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_TILES_SMALL, "Mossy Temple Block", "Small Tiles");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_TILES_LIGHT, "Mossy Temple Block", "Light Tiles");
        addBlock(ChiselBlocks.MOSSY_TEMPLE_TILES_SMALL_LIGHT, "Mossy Temple Block", "Small Light Tiles");
    }

    private void addNetherbrick() {
        addBlock(() -> Blocks.NETHER_BRICKS, "Nether Brick");
        addBlock(ChiselBlocks.NETHER_BRICK_BLUE, "Nether Brick", "Blue");
        addBlock(ChiselBlocks.NETHER_BRICK_SPATTERED, "Nether Brick", "Spattered");
        addBlock(ChiselBlocks.NETHER_BRICK_GUTS, "Nether Brick", "made of Guts");
        addBlock(ChiselBlocks.NETHER_BRICK_GUTS_DARK, "Nether Brick", "Dark made of Guts");
        addBlock(ChiselBlocks.NETHER_BRICK_GUTS_SMALL, "Nether Brick", "Small made of Guts");
        addBlock(ChiselBlocks.NETHER_BRICK_BLUE_LAVA, "Nether Brick", "Blue with Lava");
        addBlock(ChiselBlocks.NETHER_BRICK_BROWN, "Nether Brick", "Brown");
        addBlock(ChiselBlocks.NETHER_BRICK_OBSIDIAN, "Nether Brick", "Obsidian");
        addBlock(ChiselBlocks.NETHER_BRICK_STONE, "Nether Brick", "Stone");
        addBlock(ChiselBlocks.NETHER_BRICK_MEAT, "Nether Brick", "made of Meat");
        addBlock(ChiselBlocks.NETHER_BRICK_MEAT_RED, "Nether Brick", "Red made of Meat");
        addBlock(ChiselBlocks.NETHER_BRICK_MEAT_SMALL, "Nether Brick", "Small made of Meat");
        addBlock(ChiselBlocks.NETHER_BRICK_MEAT_SMALL_RED, "Nether Brick", "Small Red made of Meat");
        addBlock(ChiselBlocks.NETHER_BRICK_RED, "Nether Brick", "Red");
        addBlock(ChiselBlocks.NETHER_BRICK_RED_SMALL, "Nether Brick", "Small Red");
    }

    private void addNetherrack() {
        addBlock(() -> Blocks.NETHERRACK, "Netherrack");
        addBlock(ChiselBlocks.NETHERRACK_BLOOD_GRAVEL, "Netherrack", "Nethergravel with Blood");
        addBlock(ChiselBlocks.NETHERRACK_BLOOD, "Netherrack", "with Blood");
        addBlock(ChiselBlocks.NETHERRACK_BLOOD_DARK, "Netherrack", "Darker with Blood");
        addBlock(ChiselBlocks.NETHERRACK_BLUE, "Netherrack", "Blue");
        addBlock(ChiselBlocks.NETHERRACK_BLUE_SHALE, "Netherrack", "Shale Blue");
        addBlock(ChiselBlocks.NETHERRACK_CLASSIC, "Netherrack", "Classic");
        addBlock(ChiselBlocks.NETHERRACK_SPATTERED, "Netherrack", "Spattered");
        addBlock(ChiselBlocks.NETHERRACK_GUTS, "Netherrack", "made of Guts");
        addBlock(ChiselBlocks.NETHERRACK_GUTS_DARK, "Netherrack", "Dark made of Guts");
        addBlock(ChiselBlocks.NETHERRACK_MEAT, "Netherrack", "made of Meat");
        addBlock(ChiselBlocks.NETHERRACK_MEAT_RED, "Netherrack", "Red made of Meat");
        addBlock(ChiselBlocks.NETHERRACK_MEAT_SMALL, "Netherrack", "made of Smaller Meat Chunks");
        addBlock(ChiselBlocks.NETHERRACK_RED, "Netherrack", "Dark Red");
        addBlock(ChiselBlocks.NETHERRACK_LAVA, "Netherrack", "with Flowing Lava");
    }

    private void addOak() {
        addBlock(() -> Blocks.OAK_PLANKS, "Oak Wood Planks");
        addBlock(ChiselBlocks.OAK_PLANKS_SMOOTH, "Oak Wood Planks", "Smooth");
        addBlock(ChiselBlocks.OAK_PLANKS_SHORT, "Oak Wood Planks", "Short");
        addBlock(ChiselBlocks.OAK_PLANKS_FANCY, "Oak Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.OAK_PLANKS_PANEL, "Oak Wood Planks", "Panel");
        addBlock(ChiselBlocks.OAK_PLANKS_DOUBLE_SLAB, "Oak Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.OAK_PLANKS_CRATE, "Oak Wood Planks", "Crate");
        addBlock(ChiselBlocks.OAK_PLANKS_CRATE_FANCY, "Oak Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.OAK_PLANKS_LONG, "Oak Wood Planks", "Large Long");
        addBlock(ChiselBlocks.OAK_PLANKS_VERTICAL, "Oak Wood Planks", "Vertical");
        addBlock(ChiselBlocks.OAK_PLANKS_VERTICAL_UNEVEN, "Oak Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.OAK_PLANKS_PARQUET, "Oak Wood Planks", "Parquet");
        addBlock(ChiselBlocks.OAK_PLANKS_BLINDS, "Oak Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.OAK_PLANKS_SCAFFOLD, "Oak Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.OAK_PLANKS_DISARRAY, "Oak Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.OAK_PLANKS_DISARRAY_VERTICAL, "Oak Wood Planks", "Vertical Planks in Disarray");
    }

    private void addObsidian() {
        addBlock(() -> Blocks.OBSIDIAN, "Obsidian");
        addBlock(ChiselBlocks.OBSIDIAN_PILLAR_LARGE, "Obsidian", "Large Pillar");
        addBlock(ChiselBlocks.OBSIDIAN_PILLAR, "Obsidian", "Pillar");
        addBlock(ChiselBlocks.OBSIDIAN_CHISELED, "Obsidian", "Chiseled");
        addBlock(ChiselBlocks.OBSIDIAN_PANEL_SHINY, "Obsidian", "Shiny Panel");
        addBlock(ChiselBlocks.OBSIDIAN_PANEL, "Obsidian", "Panel");
        addBlock(ChiselBlocks.OBSIDIAN_ORGANIC_CHUNKS, "Obsidian", "Organic-Looking Chunks");
        addBlock(ChiselBlocks.OBSIDIAN_ORGANIC_GROWTH, "Obsidian", "Organic-Looking Growth");
        addBlock(ChiselBlocks.OBSIDIAN_CRYSTAL, "Obsidian", "Crystal");
        addBlock(ChiselBlocks.OBSIDIAN_PANEL_MAP, "Obsidian", "Panel with Map");
        addBlock(ChiselBlocks.OBSIDIAN_PANEL_REGION, "Obsidian", "Panel with Region Map");
        addBlock(ChiselBlocks.OBSIDIAN_PANEL_BRIGHT, "Obsidian", "Bright Panel");
        addBlock(ChiselBlocks.OBSIDIAN_BLOCKS, "Obsidian", "Blocks");
        addBlock(ChiselBlocks.OBSIDIAN_TILES, "Obsidian", "Tiles");
        addBlock(ChiselBlocks.OBSIDIAN_GREEK, "Obsidian", "Light Blocks with Greek Decor");
        addBlock(ChiselBlocks.OBSIDIAN_CRATE, "Obsidian", "Small Blocks inside an Oak Wood Crate");
    }

    private void addPackedIce() {
        addBlock(() -> Blocks.PACKED_ICE, "Packed Ice");
        addBlock(ChiselBlocks.PACKED_ICE_ROUGH, "Packed Ice", "Rough");
        addBlock(ChiselBlocks.PACKED_ICE_COBBLE, "Packed Ice", "Cobble-Packed Ice");
        addBlock(ChiselBlocks.PACKED_ICE_ROUGH_LARGE, "Packed Ice", "Large Rough Bricks");
        addBlock(ChiselBlocks.PACKED_ICE_BRICKS_LARGE, "Packed Ice", "Large Bricks");
        addBlock(ChiselBlocks.PACKED_ICE_BRICKS_SMALL, "Packed Ice", "Small Bricks");
        addBlock(ChiselBlocks.PACKED_ICE_GLASS_WALL, "Packed Ice", "Fancy Glass Wall");
        addBlock(ChiselBlocks.PACKED_ICE_TILES_LARGE, "Packed Ice", "Large Tiles");
        addBlock(ChiselBlocks.PACKED_ICE_TILES_FANCY, "Packed Ice", "Fancy Tiles");
        addBlock(ChiselBlocks.PACKED_ICE_TILES_SUNKEN, "Packed Ice", "Sunken Tiles");
        addBlock(ChiselBlocks.PACKED_ICE_TILES_DISORDERED, "Packed Ice", "Disordered Tiles");
        addBlock(ChiselBlocks.PACKED_ICE_PANEL, "Packed Ice", "Panel");
        addBlock(ChiselBlocks.PACKED_ICE_DOUBLE_SLAB, "Packed Ice", "Double Slab");
        addBlock(ChiselBlocks.PACKED_ICE_ZELDA, "Packed Ice", "Zelda");
        addBlock(ChiselBlocks.PACKED_ICE_BISMUTH, "Packed Ice", "Bismuth");
        addBlock(ChiselBlocks.PACKED_ICE_POISON, "Packed Ice", "Poison");
    }

    private void addPackedIcePillar() {
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_PLAIN_PLAIN, "Packed Ice Pillar", "Plain with Plain Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_PLAIN_GREEK, "Packed Ice Pillar", "Plain with Greek Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_GREEK_PLAIN, "Packed Ice Pillar", "Greek with Plain Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_GREEK_GREEK, "Packed Ice Pillar", "Greek with Greek Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_CARVED, "Packed Ice Pillar", "Carved Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_ORNAMENTAL, "Packed Ice Pillar", "Ornamental Capstone");
        addBlock(ChiselBlocks.PACKED_ICE_PILLAR_INSCRIBED, "Packed Ice Pillar", "Inscribed");
    }

    private void addPaperwall() {
        addBlock(ChiselBlocks.PAPERWALL_BOXED, "Paperwall", "Boxed");
        addBlock(ChiselBlocks.PAPERWALL_STRIKE_MIDDLE, "Paperwall", "Middle Striked");
        addBlock(ChiselBlocks.PAPERWALL_CROSSED, "Paperwall", "Crossed");
        addBlock(ChiselBlocks.PAPERWALL_SIX, "Paperwall", "Six Sectioned");
        addBlock(ChiselBlocks.PAPERWALL_STRIKE_VERTICAL, "Paperwall", "Vertically Striked");
        addBlock(ChiselBlocks.PAPERWALL_STRIKE_HORIZONTAL, "Paperwall", "Horizontally Striked");
        addBlock(ChiselBlocks.PAPERWALL_FLORAL, "Paperwall", "Floral Adorned");
        addBlock(ChiselBlocks.PAPERWALL_PLAIN, "Paperwall", "Plain");
        addBlock(ChiselBlocks.PAPERWALL_DOOR, "Paperwall", "Door Shaped");
    }

    private void addPaperwallBlock() {
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_BOXED, "Paperwall Block", "Boxed");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_STRIKE_MIDDLE, "Paperwall Block", "Middle Striked");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_CROSSED, "Paperwall Block", "Crossed");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_SIX, "Paperwall Block", "Six Sectioned");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_STRIKE_VERTICAL, "Paperwall Block", "Vertically Striked");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_STRIKE_HORIZONTAL, "Paperwall Block", "Horizontally Striked");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_FLORAL, "Paperwall Block", "Floral Adorned");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_PLAIN, "Paperwall Block", "Plain");
        addBlock(ChiselBlocks.PAPERWALL_BLOCK_DOOR, "Paperwall Block", "Door Shaped");
    }

    private void addPumpkin() {
        addBlock(ChiselBlocks.PUMPKIN_0, "Pumpkin", "Suprised");
        addBlock(ChiselBlocks.PUMPKIN_1, "Pumpkin", "Smiling open");
        addBlock(ChiselBlocks.PUMPKIN_2, "Pumpkin", "Cheeky");
        addBlock(ChiselBlocks.PUMPKIN_3, "Pumpkin", "Pensive");
        addBlock(ChiselBlocks.PUMPKIN_4, "Pumpkin", "Disappointed");
        addBlock(ChiselBlocks.PUMPKIN_5, "Pumpkin", "Smirking");
        addBlock(ChiselBlocks.PUMPKIN_6, "Pumpkin", "Curious");
        addBlock(ChiselBlocks.PUMPKIN_7, "Pumpkin", "Bored");
        addBlock(ChiselBlocks.PUMPKIN_8, "Pumpkin", "Sad");
        addBlock(ChiselBlocks.PUMPKIN_9, "Pumpkin", "Evil");
        addBlock(ChiselBlocks.PUMPKIN_10, "Pumpkin", "Exited");
        addBlock(ChiselBlocks.PUMPKIN_11, "Pumpkin", "Sleeping");
        addBlock(ChiselBlocks.PUMPKIN_12, "Pumpkin", "Astonished");
        addBlock(ChiselBlocks.PUMPKIN_13, "Pumpkin", "Neutral");
        addBlock(ChiselBlocks.PUMPKIN_14, "Pumpkin", "Laughing out loud");
        addBlock(ChiselBlocks.PUMPKIN_15, "Pumpkin", "Smiling Closed");
        addBlock(ChiselBlocks.PUMPKIN_16, "Pumpkin", "Astonished");
    }

    private void addPurpledFantasy() {
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICK, "Purpled Fantasy Block", "Brick");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICK_FADED, "Purpled Fantasy Block", "Faded Brick");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICK_WORN, "Purpled Fantasy Block", "Worn Brick");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICK_DAMAGED, "Purpled Fantasy Block", "Damaged Bricks");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION, "Purpled Fantasy Block", "Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_BLOCK, "Purpled Fantasy Block", "Decoration Block");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_PILLAR, "Purpled Fantasy Block", "Decoration Pillar");
        addBlock(ChiselBlocks.PURPLED_FANTASY_PILLAR, "Purpled Fantasy Block", "Pillar");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_SNAKE, "Purpled Fantasy Block", "Gold Snake Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_NOISE, "Purpled Fantasy Block", "Gold Noise Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_ENGRAVING, "Purpled Fantasy Block", "Gold Engravings Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_CHAINS, "Purpled Fantasy Block", "Gold Chains Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_DECORATION_PLATE, "Purpled Fantasy Block", "Plate Decoration");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BLOCK, "Purpled Fantasy Block", "Block");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICKS_DISARRAY, "Purpled Fantasy Block", "Bricks in disarray");
        addBlock(ChiselBlocks.PURPLED_FANTASY_BRICKS_DISARRAY_WORN, "Purpled Fantasy Block", "Worn Bricks in disarray");
    }

    private void addRedstone() {
        addBlock(() -> Blocks.REDSTONE_BLOCK, "Redstone Block");
        addBlock(ChiselBlocks.REDSTONE_SMOOTH, "Redstone Block", "Smooth");
        addBlock(ChiselBlocks.REDSTONE_LARGE, "Redstone Block", "Large Block");
        addBlock(ChiselBlocks.REDSTONE_SMALL, "Redstone Block", "Small Block");
        addBlock(ChiselBlocks.REDSTONE_BRICKS, "Redstone Block", "Bricks");
        addBlock(ChiselBlocks.REDSTONE_BRICKS_SMALL, "Redstone Block", "Small Bricks");
        addBlock(ChiselBlocks.REDSTONE_BRICKS_CHAOTIC, "Redstone Block", "Chaotic Bricks");
        addBlock(ChiselBlocks.REDSTONE_CHISELED, "Redstone Block", "Chiseled");
        addBlock(ChiselBlocks.REDSTONE_GREEK, "Redstone Block", "Greek Decoration");
        addBlock(ChiselBlocks.REDSTONE_TILES_ORNATE, "Redstone Block", "Ornate Tiles");
        addBlock(ChiselBlocks.REDSTONE_PILLAR, "Redstone Block", "Pillar");
        addBlock(ChiselBlocks.REDSTONE_TILES, "Redstone Block", "Tiles");
        addBlock(ChiselBlocks.REDSTONE_CIRCUIT, "Redstone Block", "Circuit");
        addBlock(ChiselBlocks.REDSTONE_CIRCUIT_SUPAPLEX, "Redstone Block", "Supaplex Circuit");
        addBlock(ChiselBlocks.REDSTONE_SKULLS, "Redstone Block", "Skulls");
        addBlock(ChiselBlocks.REDSTONE_ZELDA, "Redstone Block", "Zelda");
    }

    private void addRoadLine() {
        addBlock(ChiselBlocks.ROAD_LINES_WHITE, "Road Lines", "White");
        addBlock(ChiselBlocks.ROAD_LINES_YELLOW, "Road Lines", "Yellow");
        addBlock(ChiselBlocks.ROAD_LINES_WHITE_DOUBLE, "Road Lines", "Double White");
        addBlock(ChiselBlocks.ROAD_LINES_YELLOW_DOUBLE, "Road Lines", "Double Yellow");
    }

    private void addRunicVoidstone() {
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_0, "Runic Voidstone", "Voidstone - Black Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_1, "Runic Voidstone", "Voidstone - Red Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_2, "Runic Voidstone", "Voidstone - Green Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_3, "Runic Voidstone", "Voidstone - Brown Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_4, "Runic Voidstone", "Voidstone - Blue Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_5, "Runic Voidstone", "Voidstone - Purple Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_6, "Runic Voidstone", "Voidstone - Cyan Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_7, "Runic Voidstone", "Voidstone - Light Gray Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_8, "Runic Voidstone", "Voidstone - Gray Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_9, "Runic Voidstone", "Voidstone - Pink Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_10, "Runic Voidstone", "Voidstone - Lime Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_11, "Runic Voidstone", "Voidstone - Yellow Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_12, "Runic Voidstone", "Voidstone - Light Blue Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_13, "Runic Voidstone", "Voidstone - Magenta Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_14, "Runic Voidstone", "Voidstone - Orange Rune");
        addBlock(ChiselBlocks.RUNIC_VOIDSTONE_15, "Runic Voidstone", "Voidstone - White Rune");
    }

    private void addSandstone() {
        addBlock(() -> Blocks.SANDSTONE, "Sandstone");
        addBlock(ChiselBlocks.SANDSTONE_FADED, "Sandstone", "Faded");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR, "Sandstone", "Pillar");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_CAPSTONE, "Sandstone", "Pillar Capstone");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_SMALL, "Sandstone", "Small Pillar");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_BASE, "Sandstone", "Pillar Base");
        addBlock(ChiselBlocks.SANDSTONE_SMOOTH_FLAT, "Sandstone", "Smooth & Flat");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_CAPSTONE_SMOOTH, "Sandstone", "Smooth Pillar Capstone");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_SMALL_SMOOTH, "Sandstone", "Small Smooth Pillar");
        addBlock(ChiselBlocks.SANDSTONE_PILLAR_SMOOTH, "Sandstone", "Smooth Pillar");
        addBlock(ChiselBlocks.SANDSTONE_BLOCK, "Sandstone", "Block");
        addBlock(ChiselBlocks.SANDSTONE_BLOCKS_SMALL, "Sandstone", "Small Blocks");
        addBlock(ChiselBlocks.SANDSTONE_BLOCKS, "Sandstone", "Blocks");
        addBlock(ChiselBlocks.SANDSTONE_MOSAIC, "Sandstone", "Mosaic");
        addBlock(ChiselBlocks.SANDSTONE_STACKED, "Sandstone", "Stacked Tiles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_0, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_1, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_2, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_3, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_4, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_5, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_6, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_7, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_8, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_9, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_10, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_11, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_12, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_13, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_14, "Sandstone", "Scribbles");
        addBlock(ChiselBlocks.SANDSTONE_SCRIBBLES_15, "Sandstone", "Scribbles");
    }

    private void addSilver() {
        addBlock(ChiselBlocks.SILVER_CAUTION, "Block of Silver", "Caution Stripes");
        addBlock(ChiselBlocks.SILVER_SHIPPING, "Block of Silver", "Shipping Crate");
        addBlock(ChiselBlocks.SILVER_THERMAL, "Block of Silver", "Thermal");
        addBlock(ChiselBlocks.SILVER_125, "Block of Silver", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.SILVER_BORDERED, "Block of Silver", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.SILVER_BOLTED, "Block of Silver", "Fancy Bolted Plating");
    }

    private void addSpruce() {
        addBlock(() -> Blocks.SPRUCE_PLANKS, "Spruce Wood Planks");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_SMOOTH, "Spruce Wood Planks", "Smooth");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_SHORT, "Spruce Wood Planks", "Short");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_FANCY, "Spruce Wood Planks", "Fancy Arrangement");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_PANEL, "Spruce Wood Planks", "Panel");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_DOUBLE_SLAB, "Spruce Wood Planks", "Double Slab");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_CRATE, "Spruce Wood Planks", "Crate");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_CRATE_FANCY, "Spruce Wood Planks", "Fancy Crate");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_LONG, "Spruce Wood Planks", "Large Long");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_VERTICAL, "Spruce Wood Planks", "Vertical");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_VERTICAL_UNEVEN, "Spruce Wood Planks", "Vertical Uneven");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_PARQUET, "Spruce Wood Planks", "Parquet");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_BLINDS, "Spruce Wood Planks", "Plank Blinds");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_SCAFFOLD, "Spruce Wood Planks", "Scaffold");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_DISARRAY, "Spruce Wood Planks", "Planks in Disarray");
        addBlock(ChiselBlocks.SPRUCE_PLANKS_DISARRAY_VERTICAL, "Spruce Wood Planks", "Vertical Planks in Disarray");
    }

    private void addSnakestoneSand() {
        addBlock(ChiselBlocks.SNAKESTONE_SAND_0, "Sand Snakestone", "Head");
        addBlock(ChiselBlocks.SNAKESTONE_SAND_1, "Sand Snakestone", "Body");
    }

    private void addSnakestoneStone() {
        addBlock(ChiselBlocks.SNAKESTONE_STONE_0, "Stone Snakestone", "Head");
        addBlock(ChiselBlocks.SNAKESTONE_STONE_1, "Stone Snakestone", "Body");
    }

    private void addStainedGlassBlack() {
        addBlock(ChiselBlocks.STAINED_GLASS_BLACK_BUBBLE, "Stained Glass", "Black Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_BLACK_PANEL, "Stained Glass", "Black Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BLACK_PANEL_FANCY, "Stained Glass", "Black Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BLACK_BORDERLESS, "Stained Glass", "Black Borderless");
    }

    private void addStainedGlassBlue() {
        addBlock(ChiselBlocks.STAINED_GLASS_BLUE_BUBBLE, "Stained Glass", "Blue Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_BLUE_PANEL, "Stained Glass", "Blue Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BLUE_PANEL_FANCY, "Stained Glass", "Blue Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BLUE_BORDERLESS, "Stained Glass", "Blue Borderless");
    }

    private void addStainedGlassBrown() {
        addBlock(ChiselBlocks.STAINED_GLASS_BROWN_BUBBLE, "Stained Glass", "Brown Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_BROWN_PANEL, "Stained Glass", "Brown Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BROWN_PANEL_FANCY, "Stained Glass", "Brown Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_BROWN_BORDERLESS, "Stained Glass", "Brown Borderless");
    }

    private void addStainedGlassCyan() {
        addBlock(ChiselBlocks.STAINED_GLASS_CYAN_BUBBLE, "Stained Glass", "Cyan Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_CYAN_PANEL, "Stained Glass", "Cyan Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_CYAN_PANEL_FANCY, "Stained Glass", "Cyan Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_CYAN_BORDERLESS, "Stained Glass", "Cyan Borderless");
    }

    private void addStainedGlassGray() {
        addBlock(ChiselBlocks.STAINED_GLASS_GRAY_BUBBLE, "Stained Glass", "Gray Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_GRAY_PANEL, "Stained Glass", "Gray Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_GRAY_PANEL_FANCY, "Stained Glass", "Gray Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_GRAY_BORDERLESS, "Stained Glass", "Gray Borderless");
    }

    private void addStainedGlassGreen() {
        addBlock(ChiselBlocks.STAINED_GLASS_GREEN_BUBBLE, "Stained Glass", "Green Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_GREEN_PANEL, "Stained Glass", "Green Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_GREEN_PANEL_FANCY, "Stained Glass", "Green Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_GREEN_BORDERLESS, "Stained Glass", "Green Borderless");
    }

    private void addStainedGlassLightBlue() {
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_BLUE_BUBBLE, "Stained Glass", "Light Blue Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_BLUE_PANEL, "Stained Glass", "Light Blue Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_BLUE_PANEL_FANCY, "Stained Glass", "Light Blue Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_BLUE_BORDERLESS, "Stained Glass", "Light Blue Borderless");
    }

    private void addStainedGlassLightGray() {
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_GRAY_BUBBLE, "Stained Glass", "Light Gray Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_GRAY_PANEL, "Stained Glass", "Light Gray Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_GRAY_PANEL_FANCY, "Stained Glass", "Light Gray Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIGHT_GRAY_BORDERLESS, "Stained Glass", "Light Gray Borderless");
    }

    private void addStainedGlassLime() {
        addBlock(ChiselBlocks.STAINED_GLASS_LIME_BUBBLE, "Stained Glass", "Lime Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_LIME_PANEL, "Stained Glass", "Lime Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIME_PANEL_FANCY, "Stained Glass", "Lime Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_LIME_BORDERLESS, "Stained Glass", "Lime Borderless");
    }

    private void addStainedGlassMagenta() {
        addBlock(ChiselBlocks.STAINED_GLASS_MAGENTA_BUBBLE, "Stained Glass", "Magenta Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_MAGENTA_PANEL, "Stained Glass", "Magenta Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_MAGENTA_PANEL_FANCY, "Stained Glass", "Magenta Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_MAGENTA_BORDERLESS, "Stained Glass", "Magenta Borderless");
    }

    private void addStainedGlassOrange() {
        addBlock(ChiselBlocks.STAINED_GLASS_ORANGE_BUBBLE, "Stained Glass", "Orange Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_ORANGE_PANEL, "Stained Glass", "Orange Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_ORANGE_PANEL_FANCY, "Stained Glass", "Orange Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_ORANGE_BORDERLESS, "Stained Glass", "Orange Borderless");
    }

    private void addStainedGlassPink() {
        addBlock(ChiselBlocks.STAINED_GLASS_PINK_BUBBLE, "Stained Glass", "Pink Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PINK_PANEL, "Stained Glass", "Pink Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PINK_PANEL_FANCY, "Stained Glass", "Pink Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PINK_BORDERLESS, "Stained Glass", "Pink Borderless");
    }

    private void addStainedGlassPurple() {
        addBlock(ChiselBlocks.STAINED_GLASS_PURPLE_BUBBLE, "Stained Glass", "Purple Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PURPLE_PANEL, "Stained Glass", "Purple Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PURPLE_PANEL_FANCY, "Stained Glass", "Purple Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PURPLE_BORDERLESS, "Stained Glass", "Purple Borderless");
    }

    private void addStainedGlassRed() {
        addBlock(ChiselBlocks.STAINED_GLASS_RED_BUBBLE, "Stained Glass", "Red Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_RED_PANEL, "Stained Glass", "Red Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_RED_PANEL_FANCY, "Stained Glass", "Red Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_RED_BORDERLESS, "Stained Glass", "Red Borderless");
    }

    private void addStainedGlassWhite() {
        addBlock(ChiselBlocks.STAINED_GLASS_WHITE_BUBBLE, "Stained Glass", "White Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_WHITE_PANEL, "Stained Glass", "White Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_WHITE_PANEL_FANCY, "Stained Glass", "White Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_WHITE_BORDERLESS, "Stained Glass", "White Borderless");
    }

    private void addStainedGlassYellow() {
        addBlock(ChiselBlocks.STAINED_GLASS_YELLOW_BUBBLE, "Stained Glass", "Yellow Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_YELLOW_PANEL, "Stained Glass", "Yellow Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_YELLOW_PANEL_FANCY, "Stained Glass", "Yellow Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_YELLOW_PANEL_BORDERLESS, "Stained Glass", "Yellow Borderless");
    }

    private void addStainedGlassPaneBlack() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLACK_BUBBLE, "Stained Glass Pane", "Black Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLACK_PANEL, "Stained Glass Pane", "Black Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLACK_PANEL_FANCY, "Stained Glass Pane", "Black Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLACK_BORDERLESS, "Stained Glass Pane", "Black Borderless");
    }

    private void addStainedGlassPaneBlue() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLUE_BUBBLE, "Stained Glass Pane", "Blue Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLUE_PANEL, "Stained Glass Pane", "Blue Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLUE_PANEL_FANCY, "Stained Glass Pane", "Blue Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BLUE_BORDERLESS, "Stained Glass Pane", "Blue Borderless");
    }

    private void addStainedGlassPaneBrown() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BROWN_BUBBLE, "Stained Glass Pane", "Brown Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BROWN_PANEL, "Stained Glass Pane", "Brown Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BROWN_PANEL_FANCY, "Stained Glass Pane", "Brown Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_BROWN_BORDERLESS, "Stained Glass Pane", "Brown Borderless");
    }

    private void addStainedGlassPaneCyan() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_CYAN_BUBBLE, "Stained Glass Pane", "Cyan Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_CYAN_PANEL, "Stained Glass Pane", "Cyan Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_CYAN_PANEL_FANCY, "Stained Glass Pane", "Cyan Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_CYAN_BORDERLESS, "Stained Glass Pane", "Cyan Borderless");
    }

    private void addStainedGlassPaneGray() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GRAY_BUBBLE, "Stained Glass Pane", "Gray Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GRAY_PANEL, "Stained Glass Pane", "Gray Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GRAY_PANEL_FANCY, "Stained Glass Pane", "Gray Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GRAY_BORDERLESS, "Stained Glass Pane", "Gray Borderless");
    }

    private void addStainedGlassPaneGreen() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GREEN_BUBBLE, "Stained Glass Pane", "Green Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GREEN_PANEL, "Stained Glass Pane", "Green Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GREEN_PANEL_FANCY, "Stained Glass Pane", "Green Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_GREEN_BORDERLESS, "Stained Glass Pane", "Green Borderless");
    }

    private void addStainedGlassPaneLightBlue() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_BUBBLE, "Stained Glass Pane", "Light Blue Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_PANEL, "Stained Glass Pane", "Light Blue Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_PANEL_FANCY, "Stained Glass Pane", "Light Blue Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_BLUE_BORDERLESS, "Stained Glass Pane", "Light Blue Borderless");
    }

    private void addStainedGlassPaneLightGray() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_BUBBLE, "Stained Glass Pane", "Light Gray Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_PANEL, "Stained Glass Pane", "Light Gray Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_PANEL_FANCY, "Stained Glass Pane", "Light Gray Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIGHT_GRAY_BORDERLESS, "Stained Glass Pane", "Light Gray Borderless");
    }

    private void addStainedGlassPaneLime() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIME_BUBBLE, "Stained Glass Pane", "Lime Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIME_PANEL, "Stained Glass Pane", "Lime Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIME_PANEL_FANCY, "Stained Glass Pane", "Lime Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_LIME_BORDERLESS, "Stained Glass Pane", "Lime Borderless");
    }

    private void addStainedGlassPaneMagenta() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_MAGENTA_BUBBLE, "Stained Glass Pane", "Magenta Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_MAGENTA_PANEL, "Stained Glass Pane", "Magenta Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_MAGENTA_PANEL_FANCY, "Stained Glass Pane", "Magenta Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_MAGENTA_BORDERLESS, "Stained Glass Pane", "Magenta Borderless");
    }

    private void addStainedGlassPaneOrange() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_ORANGE_BUBBLE, "Stained Glass Pane", "Orange Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_ORANGE_PANEL, "Stained Glass Pane", "Orange Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_ORANGE_PANEL_FANCY, "Stained Glass Pane", "Orange Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_ORANGE_BORDERLESS, "Stained Glass Pane", "Orange Borderless");
    }

    private void addStainedGlassPanePink() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PINK_BUBBLE, "Stained Glass Pane", "Pink Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PINK_PANEL, "Stained Glass Pane", "Pink Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PINK_PANEL_FANCY, "Stained Glass Pane", "Pink Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PINK_BORDERLESS, "Stained Glass Pane", "Pink Borderless");
    }

    private void addStainedGlassPanePurple() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PURPLE_BUBBLE, "Stained Glass Pane", "Purple Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PURPLE_PANEL, "Stained Glass Pane", "Purple Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PURPLE_PANEL_FANCY, "Stained Glass Pane", "Purple Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_PURPLE_BORDERLESS, "Stained Glass Pane", "Purple Borderless");
    }

    private void addStainedGlassPaneRed() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_RED_BUBBLE, "Stained Glass Pane", "Red Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_RED_PANEL, "Stained Glass Pane", "Red Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_RED_PANEL_FANCY, "Stained Glass Pane", "Red Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_RED_BORDERLESS, "Stained Glass Pane", "Red Borderless");
    }

    private void addStainedGlassPaneWhite() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_WHITE_BUBBLE, "Stained Glass Pane", "White Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_WHITE_PANEL, "Stained Glass Pane", "White Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_WHITE_PANEL_FANCY, "Stained Glass Pane", "White Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_WHITE_BORDERLESS, "Stained Glass Pane", "White Borderless");
    }

    private void addStainedGlassPaneYellow() {
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_YELLOW_BUBBLE, "Stained Glass Pane", "Yellow Bubble");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_YELLOW_PANEL, "Stained Glass Pane", "Yellow Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_YELLOW_PANEL_FANCY, "Stained Glass Pane", "Yellow Fancy Panel");
        addBlock(ChiselBlocks.STAINED_GLASS_PANE_YELLOW_PANEL_BORDERLESS, "Stained Glass Pane", "Yellow Borderless");
    }

    private void addSteel() {
        addBlock(ChiselBlocks.STEEL_CAUTION, "Block of Steel", "Caution Stripes");
        addBlock(ChiselBlocks.STEEL_SHIPPING, "Block of Steel", "Shipping Crate");
        addBlock(ChiselBlocks.STEEL_THERMAL, "Block of Steel", "Thermal");
        addBlock(ChiselBlocks.STEEL_125, "Block of Steel", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.STEEL_BORDERED, "Block of Steel", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.STEEL_BOLTED, "Block of Steel", "Fancy Bolted Plating");
    }

    private void addStoneBricks() {
        addBlock(() -> Blocks.STONE_BRICKS, "Stone Bricks");
        addBlock(ChiselBlocks.STONE_BRICKS_NEUTRAL, "Stone Bricks", "Modern Neutral Masonry");
        addBlock(ChiselBlocks.STONE_BRICKS_FELSIC, "Stone Bricks", "Modern Felsic Masonry");
        addBlock(ChiselBlocks.STONE_BRICKS_MAFIC, "Stone Bricks", "Modern Mafic Masonry");
        addBlock(ChiselBlocks.STONE_BRICKS_SMALL, "Stone Bricks", "Small Stone Bricks");
        addBlock(ChiselBlocks.STONE_BRICKS_WIDE, "Stone Bricks", "Wide Stone Bricks");
        addBlock(ChiselBlocks.STONE_BRICKS_DISORDERED_SMALL, "Stone Bricks", "Small Disordered Stone Bricks");
        addBlock(ChiselBlocks.STONE_BRICKS_DISORDERED, "Stone Bricks", "Disordered Stone Bricks");
        addBlock(ChiselBlocks.STONE_BRICKS_DISORDERED_PANEL, "Stone Bricks", "Disordered Stone Panels");
        addBlock(ChiselBlocks.STONE_BRICKS_FANCY, "Stone Bricks", "Stone Bricks in a Fancy Arrangement");
        addBlock(ChiselBlocks.STONE_BRICKS_ORNATE, "Stone Bricks", "Ornate Stone Brick tiles");
        addBlock(ChiselBlocks.STONE_BRICKS_ORNATE_LARGE, "Stone Bricks", "Large Ornate Stone Brick Tiles");
        addBlock(ChiselBlocks.STONE_BRICKS_PANEL, "Stone Bricks", "Stone Panel");
        addBlock(ChiselBlocks.STONE_BRICKS_PANEL_SUNKEN, "Stone Bricks", "Sunken Stone Panel");
        addBlock(ChiselBlocks.STONE_BRICKS_PANEL_ORNATE, "Stone Bricks", "Ornate Stone Panel");
        addBlock(ChiselBlocks.STONE_BRICKS_POISON, "Stone Bricks", "Poison Stone Brick");
    }

    private void addTechnical() {
        addBlock(ChiselBlocks.TECHNICAL_SCAFFOLD, "Technical Block", "Scaffold");
        addBlock(ChiselBlocks.TECHNICAL_PANEL_CAUTION, "Technical Block", "Panels with Caution Tape");
        addBlock(ChiselBlocks.TECHNICAL_125, "Technical Block", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.TECHNICAL_UNDER_LARGE, "Technical Block", "Under-Pipe (Large Pipe)");
        addBlock(ChiselBlocks.TECHNICAL_FAN_FAST, "Technical Block", "Fan (Fast)");
        addBlock(ChiselBlocks.TECHNICAL_UNDER_SMALL, "Technical Block", "Under-Pipe (Small Pipes)");
        addBlock(ChiselBlocks.TECHNICAL_FAN_OFF, "Technical Block", "Fan (Off)");
        addBlock(ChiselBlocks.TECHNICAL_VENTS, "Technical Block", "Vents");
        addBlock(ChiselBlocks.TECHNICAL_VENTS_GLOWING, "Technical Block", "Glowing Vents");
        addBlock(ChiselBlocks.TECHNICAL_INSULATION, "Technical Block", "Insulation");
        addBlock(ChiselBlocks.TECHNICAL_GEARS, "Technical Block", "Gears and Flywheels");
        addBlock(ChiselBlocks.TECHNICAL_CABLES, "Technical Block", "Cables");
        addBlock(ChiselBlocks.TECHNICAL_PANEL_RUSTY, "Technical Block", "Rusty Panel");
        addBlock(ChiselBlocks.TECHNICAL_GRATE, "Technical Block", "Grate");
        addBlock(ChiselBlocks.TECHNICAL_FAN_MALFUNCTIONING, "Technical Block", "Fan (Malfunctioning)");
        addBlock(ChiselBlocks.TECHNICAL_GRATE_RUSTY, "Technical Block", "Rusty Grate");
        addBlock(ChiselBlocks.TRANSPARENT_TECHNICAL_SCAFFOLD, "Technical Block", "Scaffold");
        addBlock(ChiselBlocks.TRANSPARENT_TECHNICAL_FAN_FAST, "Technical Block", "Fan (Fast)");
        addBlock(ChiselBlocks.TRANSPARENT_TECHNICAL_FAN_OFF, "Technical Block", "Fan (Off)");
        addBlock(ChiselBlocks.TRANSPARENT_TECHNICAL_FAN_MALFUNCTIONING, "Technical Block", "Fan (Malfunctioning)");
    }

    private void addTemple() {
        addBlock(ChiselBlocks.TEMPLE_COBBLE, "Temple Block", "Temple Cobblestone");
        addBlock(ChiselBlocks.TEMPLE_ORNATE, "Temple Block", "Ornate Temple Block");
        addBlock(ChiselBlocks.TEMPLE_PLATE, "Temple Block", "Temple Plate");
        addBlock(ChiselBlocks.TEMPLE_PLATE_CRACKED, "Temple Block", "Cracked Temple Plate");
        addBlock(ChiselBlocks.TEMPLE_BRICKS, "Temple Block", "Temple Bricks");
        addBlock(ChiselBlocks.TEMPLE_BRICKS_LARGE, "Temple Block", "Large Temple Bricks");
        addBlock(ChiselBlocks.TEMPLE_BRICKS_WORN, "Temple Block", "Worn Temple Bricks");
        addBlock(ChiselBlocks.TEMPLE_BRICKS_DISARRAY, "Temple Block", "Temple Bricks in disarray");
        addBlock(ChiselBlocks.TEMPLE_COLUMN, "Temple Block", "Temple Column");
        addBlock(ChiselBlocks.TEMPLE_STAND, "Temple Block", "Temple Stand");
        addBlock(ChiselBlocks.TEMPLE_STAND_MOSAIC, "Temple Block", "Temple Mosaic Stand");
        addBlock(ChiselBlocks.TEMPLE_STAND_CREEPER, "Temple Block", "Temple Creeper Stand");
        addBlock(ChiselBlocks.TEMPLE_TILES, "Temple Block", "Temple Tiles");
        addBlock(ChiselBlocks.TEMPLE_TILES_SMALL, "Temple Block", "Small Temple Tiles");
        addBlock(ChiselBlocks.TEMPLE_TILES_LIGHT, "Temple Block", "Light Temple Tiles");
        addBlock(ChiselBlocks.TEMPLE_TILES_SMALL_LIGHT, "Temple Block", "Small Light Temple Tiles");
    }

    private void addTin() {
        addBlock(ChiselBlocks.TIN_CAUTION, "Block of Tin", "Caution Stripes");
        addBlock(ChiselBlocks.TIN_SHIPPING, "Block of Tin", "Shipping Crate");
        addBlock(ChiselBlocks.TIN_THERMAL, "Block of Tin", "Thermal");
        addBlock(ChiselBlocks.TIN_125, "Block of Tin", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.TIN_BORDERED, "Block of Tin", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.TIN_BOLTED, "Block of Tin", "Fancy Bolted Plating");
    }

    private void addTorch() {
        addBlock(ChiselBlocks.TORCH_0, "Torch", "Wax Candle");
        addBlock(ChiselBlocks.TORCH_1, "Torch", "Tall Wax Candle");
        addBlock(ChiselBlocks.TORCH_2, "Torch", "White Lamp");
        addBlock(ChiselBlocks.TORCH_3, "Torch", "Embroidered White Lamp");
        addBlock(ChiselBlocks.TORCH_4, "Torch", "Small Black Lamp");
        addBlock(ChiselBlocks.TORCH_5, "Torch", "Tall Black Lamp");
        addBlock(ChiselBlocks.TORCH_6, "Torch", "Red Lamp");
        addBlock(ChiselBlocks.TORCH_7, "Torch", "Embroidered Red Lamp");
        addBlock(ChiselBlocks.TORCH_8, "Torch", "Light Bulb");
        addBlock(ChiselBlocks.TORCH_9, "Torch", "Clear Light Bulb");
    }

    private void addTyrian() {
        addBlock(ChiselBlocks.TYRIAN_NORMAL, "Tyrian", "Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_BLEAK, "Tyrian", "Bleak Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_PURPLE, "Tyrian", "Purple Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_PURPLE_FADED, "Tyrian", "Faded Purple Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_RUSTED, "Tyrian", "Rusted Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_ELABORATE, "Tyrian", "Elaborate Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_SEAMS, "Tyrian", "Futuristic Armor Plating Block with many seams");
        addBlock(ChiselBlocks.TYRIAN_PLATFORM, "Tyrian", "Futuristic Platform Block");
        addBlock(ChiselBlocks.TYRIAN_TILES, "Tyrian", "Futuristic Armor Plating Tiles");
        addBlock(ChiselBlocks.TYRIAN_DIAGONAL, "Tyrian", "Diagonal Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_DENT, "Tyrian", "Futuristic Armor Plating Block with dent");
        addBlock(ChiselBlocks.TYRIAN_BLUE, "Tyrian", "Blue Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_BLACK, "Tyrian", "Black Futuristic Armor Plating Block");
        addBlock(ChiselBlocks.TYRIAN_BLACK_TILES, "Tyrian", "Black Futuristic Armor Plating Tiles");
        addBlock(ChiselBlocks.TYRIAN_OPENING, "Tyrian", "Black Futuristic Armor Plating Block with Opening");
        addBlock(ChiselBlocks.TYRIAN_SHINY, "Tyrian", "Shiny Futuristic Armor Plating");
    }

    private void addUranium() {
        addBlock(ChiselBlocks.URANIUM_CAUTION, "Block of Uranium", "Caution Stripes");
        addBlock(ChiselBlocks.URANIUM_SHIPPING, "Block of Uranium", "Shipping Crate");
        addBlock(ChiselBlocks.URANIUM_THERMAL, "Block of Uranium", "Thermal");
        addBlock(ChiselBlocks.URANIUM_125, "Block of Uranium", "An Old Relic from the land of Oneteufyv");
        addBlock(ChiselBlocks.URANIUM_BORDERED, "Block of Uranium", "Egregiously Bordered Block");
        addBlock(ChiselBlocks.URANIUM_BOLTED, "Block of Uranium", "Fancy Bolted Plating");
    }

    private void addValentines() {
        addBlock(ChiselBlocks.VALENTINES_BRICKS, "Valentines Block", "Bricks");
        addBlock(ChiselBlocks.VALENTINES_COMPANION, "Valentines Block", "If it speaks, I wouldn't touch it");
        addBlock(ChiselBlocks.VALENTINES_EMPTY, "Valentines Block", "Heart in stone");
        addBlock(ChiselBlocks.VALENTINES_HEART, "Valentines Block", "Pink Tinted Heart in stone");
        addBlock(ChiselBlocks.VALENTINES_HEART_GRAY, "Valentines Block", "Pink Heart in stone");
        addBlock(ChiselBlocks.VALENTINES_BLOCK, "Valentines Block", "Pink Panel");
        addBlock(ChiselBlocks.VALENTINES_COBBLE, "Valentines Block", "Pink Cobble");
        addBlock(ChiselBlocks.VALENTINES_BUMPY, "Valentines Block", "There's a flame in my heart");
        addBlock(ChiselBlocks.VALENTINES_FIRE, "Valentines Block", "Pink Chunk");
        addBlock(ChiselBlocks.VALENTINES_TILE, "Valentines Block", "Panel");
    }

    private void addVoidstone() {
        addBlock(ChiselBlocks.VOIDSTONE_RAW, "Voidstone", "Raw");
        addBlock(ChiselBlocks.VOIDSTONE_TILES, "Voidstone", "Large Tiles");
        addBlock(ChiselBlocks.VOIDSTONE_SMOOTH, "Voidstone", "Smooth");
        addBlock(ChiselBlocks.VOIDSTONE_SKULL, "Voidstone", "Skull");
        addBlock(ChiselBlocks.VOIDSTONE_RUNIC, "Voidstone", "Runic");
        addBlock(ChiselBlocks.VOIDSTONE_METAL, "Voidstone", "Metal-Bordered");
        addBlock(ChiselBlocks.VOIDSTONE_EYE, "Voidstone", "Eye");
        addBlock(ChiselBlocks.VOIDSTONE_BEVEL, "Voidstone", "Beveled");
    }

    private void addWarning() {
        addBlock(ChiselBlocks.WARNING_RADIATION, "Warning Sign", "Radiation");
        addBlock(ChiselBlocks.WARNING_BIOHAZARD, "Warning Sign", "Biohazard");
        addBlock(ChiselBlocks.WARNING_FIRE, "Warning Sign", "Fire");
        addBlock(ChiselBlocks.WARNING_EXPLOSION, "Warning Sign", "Explosion");
        addBlock(ChiselBlocks.WARNING_DEATH, "Warning Sign", "Death");
        addBlock(ChiselBlocks.WARNING_FALLING_OBJECTS, "Warning Sign", "Falling Objects");
        addBlock(ChiselBlocks.WARNING_FALLING, "Warning Sign", "Danger of Falling");
        addBlock(ChiselBlocks.WARNING_VOLTAGE, "Warning Sign", "High Voltage");
        addBlock(ChiselBlocks.WARNING_GENERIC, "Warning Sign", "Generic Warning");
        addBlock(ChiselBlocks.WARNING_CHEM, "Warning Sign", "Dangerous Chemicals");
        addBlock(ChiselBlocks.WARNING_CONSTRUCTION, "Warning Sign", "Under Construction");
        addBlock(ChiselBlocks.WARNING_LOUD, "Warning Sign", "Loud Sounds");
        addBlock(ChiselBlocks.WARNING_NO_ENTRY, "Warning Sign", "No Entry");
        addBlock(ChiselBlocks.WARNING_CRYOGENIC, "Warning Sign", "Cryogenic Freezing in progress");
        addBlock(ChiselBlocks.WARNING_OXYGEN, "Warning Sign", "Oxygen Required");
    }

    private void addWaterstone() {
        addBlock(ChiselBlocks.WATERSTONE_BRICKS, "Waterstone", "Waterstone Bricks");
        addBlock(ChiselBlocks.WATERSTONE_BLACK, "Waterstone", "Black Waterstone");
        addBlock(ChiselBlocks.WATERSTONE_TILES, "Waterstone", "Waterstone Tiles");
        addBlock(ChiselBlocks.WATERSTONE_CHAOTIC, "Waterstone", "Chaotic Waterstone Bricks");
        addBlock(ChiselBlocks.WATERSTONE_CREEPER, "Waterstone", "Water Creeper in Tiles");
        addBlock(ChiselBlocks.WATERSTONE_PANEL, "Waterstone", "Water Panel");
        addBlock(ChiselBlocks.WATERSTONE_ORNATE, "Waterstone", "Ornate Water Panel");
    }

    private void addWoolenClay() {
        addBlock(ChiselBlocks.WOOLEN_CLAY_0, "Woolen Clay", "White");
        addBlock(ChiselBlocks.WOOLEN_CLAY_1, "Woolen Clay", "Orange");
        addBlock(ChiselBlocks.WOOLEN_CLAY_2, "Woolen Clay", "Magenta");
        addBlock(ChiselBlocks.WOOLEN_CLAY_3, "Woolen Clay", "Light Blue");
        addBlock(ChiselBlocks.WOOLEN_CLAY_4, "Woolen Clay", "Yellow");
        addBlock(ChiselBlocks.WOOLEN_CLAY_5, "Woolen Clay", "Lime");
        addBlock(ChiselBlocks.WOOLEN_CLAY_6, "Woolen Clay", "Pink");
        addBlock(ChiselBlocks.WOOLEN_CLAY_7, "Woolen Clay", "Grey");
        addBlock(ChiselBlocks.WOOLEN_CLAY_8, "Woolen Clay", "Light Grey");
        addBlock(ChiselBlocks.WOOLEN_CLAY_9, "Woolen Clay", "Cyan");
        addBlock(ChiselBlocks.WOOLEN_CLAY_10, "Woolen Clay", "Purple");
        addBlock(ChiselBlocks.WOOLEN_CLAY_11, "Woolen Clay", "Blue");
        addBlock(ChiselBlocks.WOOLEN_CLAY_12, "Woolen Clay", "Brown");
        addBlock(ChiselBlocks.WOOLEN_CLAY_13, "Woolen Clay", "Green");
        addBlock(ChiselBlocks.WOOLEN_CLAY_14, "Woolen Clay", "Red");
        addBlock(ChiselBlocks.WOOLEN_CLAY_15, "Woolen Clay", "Black");
    }
}
