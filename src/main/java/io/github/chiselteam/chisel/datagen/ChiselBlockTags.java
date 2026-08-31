package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.content.ChiselFamilies;
import io.github.chiselteam.chisel.content.family.WoodFamilies;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ChiselBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> FRAMEDBLOCKS_FRAMEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("framedblocks", "frameable"));

    private final List<VariantFamily> NOT_FRAMEABLE = List.of(
            ChiselFamilies.TORCH.getFamily(),
            ChiselFamilies.ROAD_LINE.getFamily(),
            ChiselFamilies.IRON_BARS.getFamily(),
            ChiselFamilies.GLASS_PANE.getFamily()
    );

    public ChiselBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chisel.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        WoodFamilies.families().forEach(family -> addToWood(family.getFamily()));
        addToWood(ChiselFamilies.BOOKSHELF.getFamily());

        // AXE
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.ACACIA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.BAMBOO.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.BIRCH.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.CHERRY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.DARK_OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.JUNGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.MANGROVE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.WARPED.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.PALE_OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.SPRUCE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.BOOKSHELF.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.CRIMSON.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.PUMPKIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.JACK_O_LANTERN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselFamilies.PAPERWALL.getFamily());

        // SHOVEL
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselFamilies.DIRT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselFamilies.WOOLEN_CLAY.getFamily());

        // PICKAXE
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ALUMINUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ANCIENT_STONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ANDESITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ANTIBLOCK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.FA_ARCANE_DARKSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.BASALT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.BRONZE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.AE2_CERTUS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.CHARCOAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.COAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.COAL_COKE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.COBALT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.COBBLESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.C_CONCRETE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.COPPER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.DIAMOND.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.DIORITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.DEEPSLATE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ELECTRUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.EMERALD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.END_STONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ENERGIZED_VOIDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.FACTORY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.FUTURA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GLASS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GLASS_PANE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GLOWSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GOLD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GRANITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.GRIMSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.HEX_PLATING.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.HOLYSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ICE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.INVAR.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.IRON.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.IRON_BARS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.LABORATORY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.LAPIS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.LAVASTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.LEAD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.LIMESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.JACK_O_LANTERN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.MAGMA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.MARBLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.MILITARY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.MOSSY_COBBLESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.MOSSY_TEMPLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.NETHERBRICK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.NETHERRACK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.NICKEL.getFamily());
        addToTag(BlockTags.NEEDS_DIAMOND_TOOL, ChiselFamilies.OBSIDIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.OBSIDIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.PLATINUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.PRISMARINE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.PURPUR.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.RED_SANDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.REDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.REDSTONE_LAMP.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.ROAD_LINE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.SANDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.SHINGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.SILVER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.STEEL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.STONE_BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.TECHNICAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.TEMPLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.TERRACOTTA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.THAUMIUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.TIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.TYRIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.URANIUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.VALENTINES.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.VOIDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.WARNING.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselFamilies.WATERSTONE.getFamily());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ChiselBlocks.AUTO_CHISEL.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ChiselBlocks.BUILDERS_GUIDE.get());

        ChiselFamilies.getFamilies().forEach(f -> {
            if (f.getFamily().getWaxedFamily() != null) {
                addToTag(BlockTags.MINEABLE_WITH_PICKAXE, f.getFamily().getWaxedFamily());
            }
        });

        ChiselFamilies.STAINED_GLASS.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));
        ChiselFamilies.STAINED_GLASS_PANE.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));

        // VANILLA TAGS
        addToTag(BlockTags.LEAVES, ChiselFamilies.LEAF.getFamily());
        ChiselFamilies.WOOLS.forEach(family -> addToTag(BlockTags.WOOL, family.getFamily()));
        addToTag(BlockTags.ENCHANTMENT_POWER_PROVIDER, ChiselFamilies.BOOKSHELF.getFamily());

        // NEOFORGE TAGS
        addToTag(Tags.Blocks.COBBLESTONES, ChiselFamilies.COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.COBBLESTONES_NORMAL, ChiselFamilies.COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.COBBLESTONES_MOSSY, ChiselFamilies.MOSSY_COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.BOOKSHELVES, ChiselFamilies.BOOKSHELF.getFamily());

        addToTag(Tags.Blocks.GLASS_BLOCKS, ChiselFamilies.GLASS.getFamily());
        addToTag(Tags.Blocks.GLASS_PANES, ChiselFamilies.GLASS_PANE.getFamily());

        addToTag(Tags.Blocks.SANDS, ChiselFamilies.DIRT.getFamily());

        addToTag(Tags.Blocks.END_STONES, ChiselFamilies.END_STONE.getFamily());
        addToTag(Tags.Blocks.NETHERRACKS, ChiselFamilies.NETHERRACK.getFamily());
        addToTag(Tags.Blocks.OBSIDIANS, ChiselFamilies.OBSIDIAN.getFamily());
        addToTag(Tags.Blocks.SANDSTONE_BLOCKS, ChiselFamilies.SANDSTONE.getFamily());
        addToTag(Tags.Blocks.SANDSTONE_BLOCKS, ChiselFamilies.RED_SANDSTONE.getFamily());

        ChiselFamilies.WOOLS.forEach(family -> {
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getFamily().getFamilyName().substring(5)), family.getFamily());
        });

        ChiselFamilies.STAINED_GLASS.forEach(family -> {
            addToTag(Tags.Blocks.GLASS_BLOCKS, family.getFamily());
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getFamily().getFamilyName().substring("stained_glass_".length())), family.getFamily());
        });

        ChiselFamilies.STAINED_GLASS_PANE.forEach(family -> {
            addToTag(Tags.Blocks.GLASS_PANES, family.getFamily());
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getFamily().getFamilyName().substring("stained_glass_pane_".length())), family.getFamily());
        });

        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.ALUMINUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.BRONZE.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.COBALT.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.COPPER.getFamily());
        if (ChiselFamilies.COPPER.getFamily().getWaxedFamily() != null) {
            addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.COPPER.getFamily().getWaxedFamily());
        }
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.DIAMOND.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.ELECTRUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.EMERALD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.GOLD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.INVAR.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.IRON.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.LAPIS.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.LEAD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.NICKEL.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.PLATINUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.REDSTONE.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.SILVER.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.STEEL.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.TIN.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselFamilies.URANIUM.getFamily());

        ChiselFamilies.getFamilies().forEach(family -> {
            if(!NOT_FRAMEABLE.contains(family.getFamily())) {
                addToTag(FRAMEDBLOCKS_FRAMEABLE, family.getFamily());
                if (family.getFamily().getWaxedFamily() != null) {
                    addToTag(FRAMEDBLOCKS_FRAMEABLE, family.getFamily().getWaxedFamily());
                }
            }
        });

        addToTag(BlockTags.create(Chisel.prefix("marble")), ChiselFamilies.MARBLE.getFamily());
        addToTag(BlockTags.create(Chisel.prefix("limestone")), ChiselFamilies.LIMESTONE.getFamily());
    }

    private TagKey<Block> getTagForColor(String color) {
        return switch (color) {
            case "white" -> Tags.Blocks.DYED_WHITE;
            case "orange" -> Tags.Blocks.DYED_ORANGE;
            case "magenta" -> Tags.Blocks.DYED_MAGENTA;
            case "light_blue" -> Tags.Blocks.DYED_LIGHT_BLUE;
            case "yellow" -> Tags.Blocks.DYED_YELLOW;
            case "lime" -> Tags.Blocks.DYED_LIME;
            case "pink" -> Tags.Blocks.DYED_PINK;
            case "gray" -> Tags.Blocks.DYED_GRAY;
            case "light_gray" -> Tags.Blocks.DYED_LIGHT_GRAY;
            case "cyan" -> Tags.Blocks.DYED_CYAN;
            case "purple" -> Tags.Blocks.DYED_PURPLE;
            case "blue" -> Tags.Blocks.DYED_BLUE;
            case "brown" -> Tags.Blocks.DYED_BROWN;
            case "green" -> Tags.Blocks.DYED_GREEN;
            case "red" -> Tags.Blocks.DYED_RED;
            case "black" -> Tags.Blocks.DYED_BLACK;
            default -> throw new IllegalArgumentException("Unknown color: " + color);
        };
    }

    private void addToWood(VariantFamily family) {
        addToTag(ChiselTags.WOOD, family);
        if (family.getWaxedFamily() != null) {
            addToWood(family.getWaxedFamily());
        }
    }

    private void addToTag(TagKey<Block> tag, VariantFamily family) {
        family.getVariants().forEach(variant -> {
            if(variant.shouldGenerateModel()) tag(tag).add(variant.getBlock());
        });
        family.getHiddenVariants().forEach(variant -> {
            if (variant.shouldGenerateModel()) tag(tag).add(variant.getBlock());
        });
    }
}
