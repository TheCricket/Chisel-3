package com.cricketcraft.chisel.client;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IItemWithVariants;
import com.cricketcraft.chisel.util.PropertyVariant;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.cricketcraft.chisel.init.ChiselBlocks.*;
import static com.cricketcraft.chisel.init.ChiselItems.*;
import static com.cricketcraft.chisel.init.ChiselProperties.*;

@SideOnly(Side.CLIENT)
public class ModelsChisel {
    public static void prepareModels() {
        registerBlockModels(acacia, ACACIA_VARIANTS);
        registerBlockModels(aluminum, ALUMINUM_VARIANTS);
        registerBlockModels(andesite, ANDESITE_VARIANTS);
        registerBlockModels(antiblock, ANTIBLOCK_VARIANTS);
        registerBlockModels(birch, BIRCH_VARIANTS);
        registerBlockModels(bookshelf, BOOKSHELF_VARIANTS);
        registerBlockModels(bricks, BRICKS_VARIANTS);
        registerBlockModels(bronze, BRONZE_VARIANTS);
        registerBlockModels(carpet, CARPET_VARIANTS);
        registerBlockModels(carpet_floor, CARPET_FLOOR_VARIANTS);
        registerBlockModels(cobblestone, COBBLESTONE_VARIANTS);
        registerBlockModels(concrete, CONCRETE_VARIANTS);
        registerBlockModels(copper, COPPER_VARIANTS);
        registerBlockModels(cloud, CLOUD_VARIANTS);
        registerBlockModels(dark_oak, DARK_OAK_VARIANTS);
        registerBlockModels(diamond, DIAMOND_VARIANTS);
        registerBlockModels(diorite, DIORITE_VARIANTS);
        registerBlockModels(dirt, DIRT_VARIANTS);
        registerBlockModels(emerald, EMERALD_VARIANTS);
        registerBlockModels(energised_voidstone, ENERGISED_VOIDSTONE_VARIANTS);
        registerBlockModels(energised_voidstone_pillar, ENERGISED_VOIDSTONE_PILLAR_VARIANTS);
        registerBlockModels(factory, FACTORY_VARIANTS);
        registerBlockModels(fantasy, FANTASY_VARIANTS);
        registerBlockModels(futura, FUTURA_VARIANTS);
        registerBlockModels(glass, GLASS_VARIANTS);
        registerBlockModels(glass_pane, GLASS_PANE_VARIANTS);
        registerBlockModels(glowstone, GLOWSTONE_VARIANTS);
        registerBlockModels(gold, GOLD_VARIANTS);
        registerBlockModels(gold2, GOLD2_VARIANTS);
        registerBlockModels(granite, GRANITE_VARIANTS);
        registerBlockModels(grimstone, GRIMSTONE_VARIANTS);
        registerBlockModels(hex_plating, HEX_PLATING_VARIANTS);
        registerBlockModels(holystone, HOLYSTONE_VARIANTS);
        registerBlockModels(ice, ICE_VARIANTS);
        registerBlockModels(ice_pillar, ICE_PILLAR_VARIANTS);
        registerBlockModels(iron, IRON_VARIANTS);
        registerBlockModels(iron_bars, IRON_BARS_VARIANTS);
        registerBlockModels(jungle, JUNGLE_VARIANTS);
        registerBlockModels(laboratory, LABORATORY_VARIANTS);
        registerBlockModels(lapis, LAPIS_VARIANTS);
        registerBlockModels(large_hex_plating, LARGE_HEX_PLATING_VARIANTS);
        registerBlockModels(lead, LEAD_VARIANTS);
        registerBlockModels(leaf, LEAF_VARIANTS);
        registerBlockModels(limestone, LIMESTONE_VARIANTS);
        registerBlockModels(litpumpkin, LITPUMPKIN_VARIANTS);
        registerBlockModels(marble, MARBLE_VARIANTS);
        registerBlockModels(mossy_cobblestone, MOSSY_COBBLESTONE_VARIANTS);
        registerBlockModels(mossy_temple, MOSSY_TEMPLE_VARIANTS);
        registerBlockModels(netherbrick, NETHERBRICK_VARIANTS);
        registerBlockModels(netherrack, NETHERRACK_VARIANTS);
        registerBlockModels(oak, OAK_VARIANTS);
        registerBlockModels(obsidian, OBSIDIAN_VARIANTS);
        registerBlockModels(packed_ice, PACKED_ICE_VARIANTS);
        registerBlockModels(packed_ice_pillar, PACKED_ICE_PILLAR_VARIANTS);
        registerBlockModels(pumpkin, PUMPKIN_VARIANTS);
        registerBlockModels(purpled_fantasy, PURPLED_FANTASY_VARIANTS);
        registerBlockModels(redstone, REDSTONE_VARIANTS);
        registerBlockModels(road_line, ROAD_LINE_VARIANTS);
        registerBlockModels(runic_voidstone, RUNIC_VOIDSTONE_VARIANTS);
        registerBlockModels(sandstone, SANDSTONE_VARIANTS);
        registerBlockModels(sandstone_scribbles, SANDSTONE_SCRIBBLES_VARIANTS);
        registerBlockModels(silver, SILVER_VARIANTS);
        registerBlockModels(snakestone_sand, SNAKESTONE_SAND_VARIANTS);
        registerBlockModels(snakestone_stone, SNAKESTONE_STONE_VARIANTS);
        registerBlockModels(spruce, SPRUCE_VARIANTS);
        registerBlockModels(stained_glass_black, STAINED_GLASS_BLACK_VARIANTS);
        registerBlockModels(stained_glass_red, STAINED_GLASS_RED_VARIANTS);
        registerBlockModels(stained_glass_green, STAINED_GLASS_GREEN_VARIANTS);
        registerBlockModels(stained_glass_brown, STAINED_GLASS_BROWN_VARIANTS);
        registerBlockModels(stained_glass_blue, STAINED_GLASS_BLUE_VARIANTS);
        registerBlockModels(stained_glass_purple, STAINED_GLASS_PURPLE_VARIANTS);
        registerBlockModels(stained_glass_cyan, STAINED_GLASS_CYAN_VARIANTS);
        registerBlockModels(stained_glass_light_gray, STAINED_GLASS_LIGHT_GRAY_VARIANTS);
        registerBlockModels(stained_glass_gray, STAINED_GLASS_GRAY_VARIANTS);
        registerBlockModels(stained_glass_pink, STAINED_GLASS_PINK_VARIANTS);
        registerBlockModels(stained_glass_lime, STAINED_GLASS_LIME_VARIANTS);
        registerBlockModels(stained_glass_yellow, STAINED_GLASS_YELLOW_VARIANTS);
        registerBlockModels(stained_glass_light_blue, STAINED_GLASS_LIGHT_BLUE_VARIANTS);
        registerBlockModels(stained_glass_magenta, STAINED_GLASS_MAGENTA_VARIANTS);
        registerBlockModels(stained_glass_orange, STAINED_GLASS_ORANGE_VARIANTS);
        registerBlockModels(stained_glass_white, STAINED_GLASS_WHITE_VARIANTS);
        registerBlockModels(stained_glass_pane_black, STAINED_GLASS_PANE_BLACK_VARIANTS);
        registerBlockModels(stained_glass_pane_red, STAINED_GLASS_PANE_RED_VARIANTS);
        registerBlockModels(stained_glass_pane_green, STAINED_GLASS_PANE_GREEN_VARIANTS);
        registerBlockModels(stained_glass_pane_brown, STAINED_GLASS_PANE_BROWN_VARIANTS);
        registerBlockModels(stained_glass_pane_blue, STAINED_GLASS_PANE_BLUE_VARIANTS);
        registerBlockModels(stained_glass_pane_purple, STAINED_GLASS_PANE_PURPLE_VARIANTS);
        registerBlockModels(stained_glass_pane_cyan, STAINED_GLASS_PANE_CYAN_VARIANTS);
        registerBlockModels(stained_glass_pane_light_gray, STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS);
        registerBlockModels(stained_glass_pane_gray, STAINED_GLASS_PANE_GRAY_VARIANTS);
        registerBlockModels(stained_glass_pane_pink, STAINED_GLASS_PANE_PINK_VARIANTS);
        registerBlockModels(stained_glass_pane_lime, STAINED_GLASS_PANE_LIME_VARIANTS);
        registerBlockModels(stained_glass_pane_yellow, STAINED_GLASS_PANE_YELLOW_VARIANTS);
        registerBlockModels(stained_glass_pane_light_blue, STAINED_GLASS_PANE_LIGHT_BLUE_VARIANTS);
        registerBlockModels(stained_glass_pane_magenta, STAINED_GLASS_PANE_MAGENTA_VARIANTS);
        registerBlockModels(stained_glass_pane_orange, STAINED_GLASS_PANE_ORANGE_VARIANTS);
        registerBlockModels(stained_glass_pane_white, STAINED_GLASS_PANE_WHITE_VARIANTS);
        registerBlockModels(steel, STEEL_VARIANTS);
        registerBlockModels(stone_bricks, STONE_BRICKS_VARIANTS);
        registerBlockModels(technical, TECHNICAL_VARIANTS);
        registerBlockModels(temple, TEMPLE_VARIANTS);
        registerBlockModels(tin, TIN_VARIANTS);
        registerBlockModels(torch, TORCH_VARIANTS);
        registerBlockModels(transparent_technical, TRANSPARENT_TECHNICAL_VARIANSTS);
        registerBlockModels(tyrian, TYRIAN_VARIANTS);
        registerBlockModels(uranium, URANIUM_VARIANTS);
        registerBlockModels(valentines, VALENTINES_VARIANTS);
        registerBlockModels(voidstone, VOIDSTONE_VARIANTS);
        registerBlockModels(warning, WARNING_VARIANTS);
        registerBlockModels(waterstone, WATERSTONE_VARIANTS);
        registerBlockModels(woolen_clay, WOOLEN_CLAY_VARIANTS);

        addVariantNames(upgrade, "upgrade_speed", "upgrade_automation", "upgrade_stack", "upgrade_reversion");
    }

    public static void registerModels() {
        // ITEMS BELOW.

        registerItemModel(cloudInABottle);
        registerItemModel(smashing_rock);
        registerItemModel(ballOMoss);
        registerItemModels(upgrade);
        registerItemModel(chisel);
        registerItemModel(diamondChisel);
        registerItemModel(obsidianChisel);
        registerItemModel(ctmConnector);
    }

    private static void addVariantNames(Item item, String... names) {
        ResourceLocation[] locations = new ResourceLocation[names.length];
        for (int i = 0; i < names.length; i++) {
            locations[i] = getResourceLocation(names[i]);
        }

        ModelBakery.registerItemVariants(item, locations);
    }

    private static void registerBlockModels(Block base, PropertyVariant variants) {
        for (BlockVariant variant : variants.getAllowedValues()) {
            registerBlockModel(base, variant.getMeta(), getResource(variant.getName()));
        }
    }

    private static void registerBlockModel(Block block) {
        ResourceLocation resourceLocation = (ResourceLocation) Block.REGISTRY.getNameForObject(block);

        registerBlockModel(block, 0, resourceLocation.toString());
    }

    private static void registerItemModel(Item item) {
        ResourceLocation resourceLocation = (ResourceLocation) Item.REGISTRY.getNameForObject(item);

        registerItemModel(item, 0, resourceLocation.toString());
    }

    private static void registerBlockModel(Block block, int meta, String modelName) {
        registerItemModel(Item.getItemFromBlock(block), meta, modelName);
    }

    private static void registerItemModel(Item item, int meta, String resourcePath) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourcePath, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, meta, modelResourceLocation);
    }

    public static void registerItemModels(Item item) {
        for (int i = 0; i < ((IItemWithVariants) item).getVariantNames().length; i++) {
            String NAME = item.getUnlocalizedName().substring(5) + "_" + ((IItemWithVariants) item).getVariantNames()[i];
            registerItemModel(item, i, getResource(NAME));
        }
    }

    public static ResourceLocation getResourceLocation(String resource) {
        return new ResourceLocation((Chisel.MOD_ID + ":") + resource);
    }

    public static String getResource(String resource) {
        return (Chisel.MOD_ID + ":") + resource;
    }
}
