package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
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
    public static final TagKey<Block> WOOD = TagKey.create(Registries.BLOCK, Chisel.prefix("wood"));
    public static final TagKey<Block> FRAMEDBLOCKS_FRAMEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("framedblocks", "frameable"));

    private final List<VariantFamily> NOT_FRAMEABLE = List.of(
            ChiselBlocks.TORCH.getFamily(),
            ChiselBlocks.ROAD_LINE.getFamily(),
            ChiselBlocks.IRON_BARS.getFamily(),
            ChiselBlocks.GLASS_PANE.getFamily()
    );

    public ChiselBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chisel.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        addToWood(ChiselBlocks.ACACIA.getFamily());
        addToWood(ChiselBlocks.BAMBOO.getFamily());
        addToWood(ChiselBlocks.BIRCH.getFamily());
        addToWood(ChiselBlocks.CHERRY.getFamily());
        addToWood(ChiselBlocks.DARK_OAK.getFamily());
        addToWood(ChiselBlocks.JUNGLE.getFamily());
        addToWood(ChiselBlocks.MANGROVE.getFamily());
        addToWood(ChiselBlocks.WARPED.getFamily());
        addToWood(ChiselBlocks.OAK.getFamily());
        addToWood(ChiselBlocks.PALE_OAK.getFamily());
        addToWood(ChiselBlocks.SPRUCE.getFamily());
        addToWood(ChiselBlocks.CRIMSON.getFamily());
        addToWood(ChiselBlocks.BOOKSHELF.getFamily());

        // AXE
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.ACACIA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.BAMBOO.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.BIRCH.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.CHERRY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.DARK_OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.JUNGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.MANGROVE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.WARPED.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.PALE_OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.SPRUCE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.BOOKSHELF.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.CRIMSON.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.PUMPKIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.JACK_O_LANTERN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.PAPERWALL.getFamily());

        // SHOVEL
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselBlocks.DIRT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselBlocks.WOOLEN_CLAY.getFamily());

        // PICKAXE
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ALUMINUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ANCIENT_STONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ANDESITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ANTIBLOCK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.FA_ARCANE_DARKSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.BASALT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.BRONZE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.AE2_CERTUS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.CHARCOAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COAL_COKE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COBALT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COBBLESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.C_CONCRETE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COPPER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.DIAMOND.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.DIORITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.DEEPSLATE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ELECTRUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.EMERALD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.END_STONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ENERGIZED_VOIDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.FACTORY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.FUTURA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GLASS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GLASS_PANE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GLOWSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GOLD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GRANITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.GRIMSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.HEX_PLATING.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.HOLYSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ICE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.INVAR.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.IRON.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.IRON_BARS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.LABORATORY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.LAPIS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.LAVASTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.LEAD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.LIMESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.JACK_O_LANTERN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.MAGMA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.MARBLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.MILITARY.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.MOSSY_COBBLESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.MOSSY_TEMPLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.NETHERBRICK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.NETHERRACK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.NICKEL.getFamily());
        addToTag(BlockTags.NEEDS_DIAMOND_TOOL, ChiselBlocks.OBSIDIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.OBSIDIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.PLATINUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.PRISMARINE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.PURPUR.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.RED_SANDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.REDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.REDSTONE_LAMP.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ROAD_LINE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SANDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SHINGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SILVER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.STEEL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.STONE_BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TECHNICAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TEMPLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TERRACOTTA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.THAUMIUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TYRIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.URANIUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.VALENTINES.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.VOIDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.WARNING.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.WATERSTONE.getFamily());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ChiselBlocks.AUTO_CHISEL.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ChiselBlocks.BUILDERS_GUIDE.get());

        ChiselBlocks.getFamilies().forEach(f -> {
            if (f.getFamily().getWaxedFamily() != null) {
                addToTag(BlockTags.MINEABLE_WITH_PICKAXE, f.getFamily().getWaxedFamily());
            }
        });

        ChiselBlocks.STAINED_GLASS.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));
        ChiselBlocks.STAINED_GLASS_PANE.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));

        // VANILLA TAGS
        addToTag(BlockTags.LEAVES, ChiselBlocks.LEAF.getFamily());
        ChiselBlocks.WOOLS.forEach(family -> addToTag(BlockTags.WOOL, family.getFamily()));
        addToTag(BlockTags.ENCHANTMENT_POWER_PROVIDER, ChiselBlocks.BOOKSHELF.getFamily());

        // NEOFORGE TAGS
        addToTag(Tags.Blocks.COBBLESTONES, ChiselBlocks.COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.COBBLESTONES_NORMAL, ChiselBlocks.COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.COBBLESTONES_MOSSY, ChiselBlocks.MOSSY_COBBLESTONE.getFamily());
        addToTag(Tags.Blocks.BOOKSHELVES, ChiselBlocks.BOOKSHELF.getFamily());

        addToTag(Tags.Blocks.GLASS_BLOCKS, ChiselBlocks.GLASS.getFamily());
        addToTag(Tags.Blocks.GLASS_PANES, ChiselBlocks.GLASS_PANE.getFamily());

        addToTag(Tags.Blocks.SANDS, ChiselBlocks.DIRT.getFamily());

        addToTag(Tags.Blocks.END_STONES, ChiselBlocks.END_STONE.getFamily());
        addToTag(Tags.Blocks.NETHERRACKS, ChiselBlocks.NETHERRACK.getFamily());
        addToTag(Tags.Blocks.OBSIDIANS, ChiselBlocks.OBSIDIAN.getFamily());
        addToTag(Tags.Blocks.SANDSTONE_BLOCKS, ChiselBlocks.SANDSTONE.getFamily());
        addToTag(Tags.Blocks.SANDSTONE_BLOCKS, ChiselBlocks.RED_SANDSTONE.getFamily());

        ChiselBlocks.WOOLS.forEach(family -> {
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getFamily().getFamilyName().substring(5)), family.getFamily());
        });

        ChiselBlocks.STAINED_GLASS.forEach(family -> {
            addToTag(Tags.Blocks.GLASS_BLOCKS, family.getFamily());
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getColor()), family.getFamily());
        });

        ChiselBlocks.STAINED_GLASS_PANE.forEach(family -> {
            addToTag(Tags.Blocks.GLASS_PANES, family.getFamily());
            addToTag(Tags.Blocks.DYED, family.getFamily());
            addToTag(getTagForColor(family.getColor().getName()), family.getFamily());
        });

        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.ALUMINUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.BRONZE.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.COBALT.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.COPPER.getFamily());
        if (ChiselBlocks.COPPER.getFamily().getWaxedFamily() != null) {
            addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.COPPER.getFamily().getWaxedFamily());
        }
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.DIAMOND.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.ELECTRUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.EMERALD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.GOLD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.INVAR.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.IRON.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.LAPIS.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.LEAD.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.NICKEL.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.PLATINUM.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.REDSTONE.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.SILVER.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.STEEL.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.TIN.getFamily());
        addToTag(Tags.Blocks.STORAGE_BLOCKS, ChiselBlocks.URANIUM.getFamily());

        ChiselBlocks.getFamilies().forEach(family -> {
            if(!NOT_FRAMEABLE.contains(family.getFamily())) {
                addToTag(FRAMEDBLOCKS_FRAMEABLE, family.getFamily());
                if (family.getFamily().getWaxedFamily() != null) {
                    addToTag(FRAMEDBLOCKS_FRAMEABLE, family.getFamily().getWaxedFamily());
                }
            }
        });

        addToTag(BlockTags.create(Chisel.prefix("marble")), ChiselBlocks.MARBLE.getFamily());
        addToTag(BlockTags.create(Chisel.prefix("limestone")), ChiselBlocks.LIMESTONE.getFamily());
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
        addToTag(WOOD, family);
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
