package chisel.datagen;

import chisel.Chisel;
import chisel.core.variant.VariantFamily;
import chisel.registry.ChiselBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ChiselBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> WOOD = TagKey.create(Registries.BLOCK, Chisel.prefix("wood"));

    public ChiselBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chisel.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        addToWood(ChiselBlocks.ACACIA.getFamily());
        addToWood(ChiselBlocks.BIRCH.getFamily());
        addToWood(ChiselBlocks.DARK_OAK.getFamily());
        addToWood(ChiselBlocks.JUNGLE.getFamily());
        addToWood(ChiselBlocks.OAK.getFamily());
        addToWood(ChiselBlocks.SPRUCE.getFamily());
        addToWood(ChiselBlocks.BOOKSHELF.getFamily());

        // AXE
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.ACACIA.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.BIRCH.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.DARK_OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.JUNGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.OAK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.SPRUCE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.BOOKSHELF.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.CRIMSON.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.CLOUD.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.CARPET.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.PUMPKIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.JACK_O_LANTERN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_AXE, ChiselBlocks.PAPERWALL.getFamily());

        // SHOVEL
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselBlocks.DIRT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_SHOVEL, ChiselBlocks.WOOLEN_CLAY.getFamily());

        // PICKAXE
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ALUMINUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ANDESITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ANTIBLOCK.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.BRONZE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COBALT.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COBBLESTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.CONCRETE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.COPPER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.DIAMOND.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.DIORITE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ELECTRUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.EMERALD.getFamily());
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
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.REDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.ROAD_LINE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SANDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SHINGLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.SILVER.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.STEEL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.STONE_BRICKS.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TECHNICAL.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TEMPLE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TIN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.TYRIAN.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.URANIUM.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.VALENTINES.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.VOIDSTONE.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.WARNING.getFamily());
        addToTag(BlockTags.MINEABLE_WITH_PICKAXE, ChiselBlocks.WATERSTONE.getFamily());

        ChiselBlocks.STAINED_GLASS.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));
        ChiselBlocks.STAINED_GLASS_PANE.forEach(family -> addToTag(BlockTags.MINEABLE_WITH_PICKAXE, family.getFamily()));
    }

    private void addToWood(VariantFamily family) {
        addToTag(WOOD, family);
    }

    private void addToTag(TagKey<Block> tag, VariantFamily family) {
        family.getVariants().forEach(variant -> {
            if(variant.shouldGenerateModel()) tag(tag).add(variant.getBlock());
        });
    }
}
