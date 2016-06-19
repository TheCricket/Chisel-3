package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.block.BlockCarvablePane;
import com.cricketcraft.chisel.block.metal.*;
import com.cricketcraft.chisel.block.modded.*;
import com.cricketcraft.chisel.block.other.*;
import com.cricketcraft.chisel.block.other.stained.*;
import com.cricketcraft.chisel.block.other.stained.panes.*;
import com.cricketcraft.chisel.block.stone.*;
import com.cricketcraft.chisel.block.wood.*;
import com.cricketcraft.chisel.item.itemblock.ItemBlockCarvable;
import com.cricketcraft.chisel.item.itemblock.ItemCarvablePumpkin;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ChiselBlocks {
	public static BlockCarvable
			acacia,
			aluminum,
			andesite,
			antiblock,
			birch,
			bronze,
			bricks,
			bookshelf,
			carpet,
			carpet_floor,
			cobblestone,
			concrete,
			copper,
			cloud,
			dark_oak,
			diamond,
			diorite,
			dirt,
			emerald,
			energised_voidstone,
			energised_voidstone_pillar,
			factory,
			fantasy,
			futura,
			glass,
			glowstone,
			gold,
			gold2,
			granite,
			grimstone,
			hex_plating,
			holystone,
			ice,
			ice_pillar,
			iron,
			jungle,
			laboratory,
			lapis,
			large_hex_plating,
			lavastone,
			lead,
			leaf,
			limestone,
			marble,
			mossy_cobblestone,
			mossy_temple,
			netherbrick,
			netherrack,
			oak,
			obsidian,
			packed_ice,
			packed_ice_pillar,
			paperwall_block,
			purpled_fantasy,
			redstone,
			road_line,
			runic_voidstone,
			sandstone,
			sandstone_scribbles,
			silver,
			snakestone_sand,
			snakestone_stone,
			spruce,
			stained_glass_black,
			stained_glass_red,
			stained_glass_green,
			stained_glass_brown,
			stained_glass_blue,
			stained_glass_purple,
			stained_glass_cyan,
			stained_glass_light_gray,
			stained_glass_gray,
			stained_glass_pink,
			stained_glass_lime,
			stained_glass_yellow,
			stained_glass_light_blue,
			stained_glass_magenta,
			stained_glass_orange,
			stained_glass_white,
			steel,
			stone_bricks,
			technical,
			temple,
			tin,
			transparent_technical,
			tyrian,
			uranium,
			valentines,
			voidstone,
			warning,
			waterstone,
			woolen_clay;
	public static BlockCarvablePane glass_pane,
			iron_bars,
			paperwall,
			stained_glass_pane_black,
			stained_glass_pane_red,
			stained_glass_pane_green,
			stained_glass_pane_brown,
			stained_glass_pane_blue,
			stained_glass_pane_purple,
			stained_glass_pane_cyan,
			stained_glass_pane_light_gray,
			stained_glass_pane_gray,
			stained_glass_pane_pink,
			stained_glass_pane_lime,
			stained_glass_pane_yellow,
			stained_glass_pane_light_blue,
			stained_glass_pane_magenta,
			stained_glass_pane_orange,
			stained_glass_pane_white;
	public static Block litpumpkin, pumpkin;
	public static ChiselBlockCarvableTorch torch;

	public static void preInit() {
		acacia = (BlockCarvable) registerBlock("acacia_planks", new ChiselBlockAcacia());
		aluminum = (BlockCarvable) registerBlock("aluminumblock", new ChiselBlockAluminum());
		andesite = (BlockCarvable) registerBlock("andesite", new ChiselBlockAndesite());
		antiblock = (BlockCarvable) registerBlock("antiBlock", new ChiselBlockAntiblock());
		birch = (BlockCarvable) registerBlock("birch_planks", new ChiselBlockBirch());
		bronze = (BlockCarvable) registerBlock("bronzeblock", new ChiselBlockBronze());
		bricks = (BlockCarvable) registerBlock("brickCustom", new ChiselBlockBricks());
		bookshelf = (BlockCarvable) registerBlock("bookshelf", new ChiselBlockBookshelf());
		carpet = (BlockCarvable) registerBlock("carpet_block", new ChiselBlockCarvableCarpet());
		carpet_floor = (BlockCarvable) registerBlock("carpet_floor", new ChiselBlockCarpetFloor());
		cobblestone = (BlockCarvable) registerBlock("cobblestone", new ChiselBlockCobblestone());
		concrete = (BlockCarvable) registerBlock("concrete", new ChiselBlockConcrete());
		copper = (BlockCarvable) registerBlock("copperblock", new ChiselBlockCopper());
		cloud = (BlockCarvable) registerBlock("cloud", new ChiselBlockCloud());
		dark_oak = (BlockCarvable) registerBlock("dark_oak_planks", new ChiselBlockDarkOak());
		diamond = (BlockCarvable) registerBlock("diamond_block", new ChiselBlockDiamond());
		diorite = (BlockCarvable) registerBlock("diorite", new ChiselBlockDiorite());
		dirt = (BlockCarvable) registerBlock("dirt", new ChiselBlockDirt());
		emerald = (BlockCarvable) registerBlock("emerald_block", new ChiselBlockEmerald());
		energised_voidstone = (BlockCarvable) registerBlock("voidstone2", new ChiselBlockEnergisedVoidstone());
		energised_voidstone_pillar = (BlockCarvable) registerBlock("voidstonePillar2", new ChiselBlockEnergisedVoidstonePillar());
		factory = (BlockCarvable) registerBlock("factoryBlock", new ChiselBlockFactory());
		fantasy = (BlockCarvable) registerBlock("fantasyblock2", new ChiselBlockFantasy());
		futura = (BlockCarvable) registerBlock("futura", new ChiselBlockFutura());
		glass = (BlockCarvable) registerBlock("glass", new ChiselBlockCarvableGlass());
		glass_pane = (BlockCarvablePane) registerBlock("glass_pane", new ChiselBlockGlassPane());
		glowstone = (BlockCarvable) registerBlock("glowstone", new ChiselBlockGlowstone());
		gold = (BlockCarvable) registerBlock("gold_block", new ChiselBlockGold());
		gold2 = (BlockCarvable) registerBlock("gold2_block", new ChiselBlockGold2());
		granite = (BlockCarvable) registerBlock("granite", new ChiselBlockGranite());
		grimstone = (BlockCarvable) registerBlock("grimstone", new ChiselBlockGrimstone());
		hex_plating = (BlockCarvable) registerBlock("hex_plating", new ChiselBlockHexPlating());
		holystone = (BlockCarvable) registerBlock("holystone", new ChiselBlockHolystone());
		ice = (BlockCarvable) registerBlock("ice", new ChiselBlockIce());
		ice_pillar = (BlockCarvable) registerBlock("icePillar", new ChiselBlockIcePillar());
		iron = (BlockCarvable) registerBlock("iron_block", new ChiselBlockIron());
		iron_bars = (BlockCarvablePane) registerBlock("iron_bars", new ChiselBlockIronBars());
		jungle = (BlockCarvable) registerBlock("jungle_planks", new ChiselBlockJungle());
		laboratory = (BlockCarvable) registerBlock("laboratory", new ChiselBlockLaboratory());
		lapis = (BlockCarvable) registerBlock("lapis_block", new ChiselBlockLapis());
		large_hex_plating = (BlockCarvable) registerBlock("large_hex_plating", new ChiselBlockHexPlatingLarge());
		lavastone = (BlockCarvable) registerBlock("lavastone", new ChiselBlockLavastone());
		lead = (BlockCarvable) registerBlock("leadblock", new ChiselBlockLead());
		leaf = (BlockCarvable) registerBlock("leaf", new ChiselBlockLeaves());
		limestone = (BlockCarvable) registerBlock("limestone", new ChiselBlockLimestone());
		litpumpkin = registerBlock("litpumpkin", new ChiselBlockJackolantern());
		marble = (BlockCarvable) registerBlock("marble", new ChiselBlockMarble());
		mossy_cobblestone = (BlockCarvable) registerBlock("mossy_cobblestone", new ChiselBlockMossyCobblestone());
		mossy_temple = (BlockCarvable) registerBlock("mossy_temple", new ChiselBlockMossyTemple());
		netherbrick = (BlockCarvable) registerBlock("netherbrick", new ChiselBlockNetherBrick());
		netherrack = (BlockCarvable) registerBlock("netherrack", new ChiselBlockNetherrack());
		oak = (BlockCarvable) registerBlock("oak_planks", new ChiselBlockOak());
		obsidian = (BlockCarvable) registerBlock("obsidian", new ChiselBlockObsidian());
		packed_ice = (BlockCarvable) registerBlock("packed_ice", new ChiselBlockPackedIce());
		packed_ice_pillar = (BlockCarvable) registerBlock("packed_ice_pillar", new ChiselBlockPackedIcePillar());
		paperwall = (BlockCarvablePane) registerBlock("paperwall", new ChiselBlockPaperWallPane());
		paperwall_block = (BlockCarvable) registerBlock("paperwall_block", new ChiselBlockPaperWall());
		pumpkin = registerBlock("pumpkin", ItemCarvablePumpkin.class, new ChiselBlockPumpkin());
		purpled_fantasy = (BlockCarvable) registerBlock("fantasy", new ChiselBlockFantasyPurple());
		redstone = (BlockCarvable) registerBlock("redstone_block", new ChiselBlockRedstone());
		road_line = (BlockCarvable) registerBlock("road_line", new ChiselBlockRoadline());
		runic_voidstone = (BlockCarvable) registerBlock("runic_voidstone", new ChiselBlockRunicVoidstone());
		sandstone = (BlockCarvable) registerBlock("sandstone", new ChiselBlockSandstone());
		sandstone_scribbles = (BlockCarvable) registerBlock("sandstone_scribbles", new ChiselBlockSandstoneScribbles());
		silver = (BlockCarvable) registerBlock("silverblock", new ChiselBlockSilver());
		snakestone_sand = (BlockCarvable) registerBlock("snakestone_sand", new ChiselBlockSnakestoneSand());
		snakestone_stone = (BlockCarvable) registerBlock("snakestone_stone", new ChiselBlockSnakestone());
		spruce = (BlockCarvable) registerBlock("spruce_planks", new ChiselBlockSpruce());
		stained_glass_black = (BlockCarvable) registerBlock("stained_glass_black", new ChiselBlockStainedGlassBlack());
		stained_glass_red = (BlockCarvable) registerBlock("stained_glass_red", new ChiselBlockStainedGlassRed());
		stained_glass_green = (BlockCarvable) registerBlock("stained_glass_green", new ChiselBlockStainedGlassGreen());
		stained_glass_brown = (BlockCarvable) registerBlock("stained_glass_brown", new ChiselBlockStainedGlassBrown());
		stained_glass_blue = (BlockCarvable) registerBlock("stained_glass_blue", new ChiselBlockStainedGlassBlue());
		stained_glass_purple = (BlockCarvable) registerBlock("stained_glass_purple", new ChiselBlockStainedGlassPurple());
		stained_glass_cyan = (BlockCarvable) registerBlock("stained_glass_cyan", new ChiselBlockStainedGlassCyan());
		stained_glass_light_gray = (BlockCarvable) registerBlock("stained_glass_light_gray", new ChiselBlockStainedGlassLightGray());
		stained_glass_gray = (BlockCarvable) registerBlock("stained_glass_gray", new ChiselBlockStainedGlassGray());
		stained_glass_pink = (BlockCarvable) registerBlock("stained_glass_pink", new ChiselBlockStainedGlassPink());
		stained_glass_lime = (BlockCarvable) registerBlock("stained_glass_lime", new ChiselBlockStainedGlassLime());
		stained_glass_yellow = (BlockCarvable) registerBlock("stained_glass_yellow", new ChiselBlockStainedGlassYellow());
		stained_glass_light_blue = (BlockCarvable) registerBlock("stained_glass_light_blue", new ChiselBlockStainedGlassLightBlue());
		stained_glass_magenta = (BlockCarvable) registerBlock("stained_glass_magenta", new ChiselBlockStainedGlassMagenta());
		stained_glass_orange = (BlockCarvable) registerBlock("stained_glass_orange", new ChiselBlockStainedGlassOrange());
		stained_glass_white = (BlockCarvable) registerBlock("stained_glass_white", new ChiselBlockStainedGlassWhite());
		stained_glass_pane_black = (BlockCarvablePane) registerBlock("stained_glass_pane_black", new ChiselBlockStainedGlassPaneBlack());
		stained_glass_pane_red = (BlockCarvablePane) registerBlock("stained_glass_pane_red", new ChiselBlockStainedGlassPaneRed());
		stained_glass_pane_green = (BlockCarvablePane) registerBlock("stained_glass_pane_green", new ChiselBlockStainedGlassPaneGreen());
		stained_glass_pane_brown = (BlockCarvablePane) registerBlock("stained_glass_pane_brown", new ChiselBlockStainedGlassPaneBrown());
		stained_glass_pane_blue = (BlockCarvablePane) registerBlock("stained_glass_pane_blue", new ChiselBlockStainedGlassPaneBlue());
		stained_glass_pane_purple = (BlockCarvablePane) registerBlock("stained_glass_pane_purple", new ChiselBlockStainedGlassPanePurple());
		stained_glass_pane_cyan = (BlockCarvablePane) registerBlock("stained_glass_pane_cyan", new ChiselBlockStainedGlassPaneCyan());
		stained_glass_pane_light_gray = (BlockCarvablePane) registerBlock("stained_glass_pane_light_gray", new ChiselBlockStainedGlassPaneLightGray());
		stained_glass_pane_gray = (BlockCarvablePane) registerBlock("stained_glass_pane_gray", new ChiselBlockStainedGlassPaneGray());
		stained_glass_pane_pink = (BlockCarvablePane) registerBlock("stained_glass_pane_pink", new ChiselBlockStainedGlassPanePink());
		stained_glass_pane_lime = (BlockCarvablePane) registerBlock("stained_glass_pane_lime", new ChiselBlockStainedGlassPaneLime());
		stained_glass_pane_yellow = (BlockCarvablePane) registerBlock("stained_glass_pane_yellow", new ChiselBlockStainedGlassPaneYellow());
		stained_glass_pane_light_blue = (BlockCarvablePane) registerBlock("stained_glass_pane_light_blue", new ChiselBlockStainedGlassPaneLightBlue());
		stained_glass_pane_magenta = (BlockCarvablePane) registerBlock("stained_glass_pane_magenta", new ChiselBlockStainedGlassPaneMagenta());
		stained_glass_pane_orange = (BlockCarvablePane) registerBlock("stained_glass_pane_orange", new ChiselBlockStainedGlassPaneOrange());
		stained_glass_pane_white = (BlockCarvablePane) registerBlock("stained_glass_pane_white", new ChiselBlockStainedGlassPaneWhite());
		steel = (BlockCarvable) registerBlock("steelblock", new ChiselBlockSteel());
		stone_bricks = (BlockCarvable) registerBlock("stone_bricks", new ChiselBlockStoneBricks());
		technical = (BlockCarvable) registerBlock("technical", new ChiselBlockTechnical());
		temple = (BlockCarvable) registerBlock("temple", new ChiselBlockTemple());
		tin = (BlockCarvable) registerBlock("tinblock", new ChiselBlockTin());
		torch = (ChiselBlockCarvableTorch) registerBlock("torch", new ChiselBlockCarvableTorch());
		transparent_technical = (BlockCarvable) registerBlock("technical2", new ChiselBlockTransparentTechnical());
		tyrian = (BlockCarvable) registerBlock("tyrian", new ChiselBlockTyrian());
		uranium = (BlockCarvable) registerBlock("uraniumblock", new ChiselBlockUranium());
		valentines = (BlockCarvable) registerBlock("valentines", new ChiselBlockValentines());
		voidstone = (BlockCarvable) registerBlock("voidstone", new ChiselBlockVoidstone());
		warning = (BlockCarvable) registerBlock("warning", new ChiselBlockWarning());
		waterstone = (BlockCarvable) registerBlock("waterstone", new ChiselBlockWaterstone());
		woolen_clay = (BlockCarvable) registerBlock("woolen_clay", new ChiselBlockWoolenClay());
	}

	private static Block registerBlock(String name, Block block) {
		return registerBlock(name, ItemBlockCarvable.class, block);
	}

	private static Block registerBlock(String name, Class<? extends ItemBlock> itemClass, Block block) {
		block.setUnlocalizedName(name);
		GameRegistry.registerBlock(block, itemClass, name);

		return block;
	}
}
