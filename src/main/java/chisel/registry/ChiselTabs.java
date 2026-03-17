package chisel.registry;

import chisel.Chisel;
import chisel.datagen.VariantFamilies;
import chisel.registry.blocks.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

@SuppressWarnings("unused")
public class ChiselTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chisel.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STONE = CREATIVE_MODE_TABS.register("chisel_stone", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabStoneChiselBlocks"))
            .icon(() -> new ItemStack(ChiselStoneBlocks.MARBLE_RAW.get()))
            .displayItems((_, output) -> List.of(
                    VariantFamilies.ANDESITE,
                    VariantFamilies.BRICKS,
                    VariantFamilies.COBBLESTONE,
                    VariantFamilies.STONE_BRICKS,
                    VariantFamilies.CONCRETE,
                    VariantFamilies.DIORITE,
                    VariantFamilies.GRANITE,
                    VariantFamilies.GRIMSTONE,
                    VariantFamilies.HOLYSTONE,
                    VariantFamilies.LAVASTONE,
                    VariantFamilies.LIMESTONE,
                    VariantFamilies.MARBLE,
                    VariantFamilies.MOSSY_COBBLESTONE,
                    VariantFamilies.MOSSY_TEMPLE,
                    VariantFamilies.NETHERBRICK,
                    VariantFamilies.NETHERRACK,
                    VariantFamilies.OBSIDIAN,
                    VariantFamilies.RUNIC_VOIDSTONE,
                    VariantFamilies.SANDSTONE,
                    VariantFamilies.SNAKESTONE_SAND,
                    VariantFamilies.SNAKESTONE_STONE,
                    VariantFamilies.TEMPLE,
                    VariantFamilies.VOIDSTONE,
                    VariantFamilies.WATERSTONE).forEach(family -> family.getVariants().forEach(variant -> output.accept(variant.getBlock().get()))))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WOOD = CREATIVE_MODE_TABS.register("chisel_wood", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabWoodChiselBlocks"))
            .icon(() -> new ItemStack(ChiselWoodBlocks.OAK_PLANKS_SMOOTH.get()))
            .displayItems((_, output) -> List.of(
                    VariantFamilies.ACACIA,
                    VariantFamilies.BIRCH,
                    VariantFamilies.BOOKSHELF,
                    VariantFamilies.DARK_OAK,
                    VariantFamilies.JUNGLE,
                    VariantFamilies.OAK,
                    VariantFamilies.SPRUCE).forEach(family -> family.getVariants().forEach(variant -> output.accept(variant.getBlock().get()))))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> METAL = CREATIVE_MODE_TABS.register("chisel_metal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabMetalChiselBlocks"))
            .icon(() -> new ItemStack(ChiselMetalBlocks.IRON_INGOTS_LARGE.get()))
            .displayItems((_, output) -> List.of(
                    VariantFamilies.FACTORY,
                            VariantFamilies.COPPER,
                            VariantFamilies.FUTURA,
                            VariantFamilies.GOLD,
                            VariantFamilies.HEX_PLATING,
                            VariantFamilies.LARGE_HEX_PLATING,
                            VariantFamilies.IRON,
                            VariantFamilies.LABORATORY,
                            VariantFamilies.TECHNICAL,
                            VariantFamilies.TYRIAN,
                            VariantFamilies.ALUMINUM,
                            VariantFamilies.WARNING)
                    .forEach(family -> family.getVariants().forEach(variant -> output.accept(variant.getBlock().get()))))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OTHER = CREATIVE_MODE_TABS.register("chisel_other", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabOtherChiselBlocks"))
            .icon(() -> new ItemStack(ChiselOtherBlocks.ANTIBLOCK_BLACK.get()))
            .displayItems((_, output) -> List.of(
                    VariantFamilies.ANTIBLOCK,
                    VariantFamilies.CARPET,
                    VariantFamilies.CARPET_FLOOR,
                    VariantFamilies.GLASS,
                    VariantFamilies.STAINED_GLASS_BLACK,
                    VariantFamilies.STAINED_GLASS_BLUE,
                    VariantFamilies.STAINED_GLASS_BROWN,
                    VariantFamilies.STAINED_GLASS_CYAN,
                    VariantFamilies.STAINED_GLASS_GRAY,
                    VariantFamilies.STAINED_GLASS_GREEN,
                    VariantFamilies.STAINED_GLASS_LIGHT_BLUE,
                    VariantFamilies.STAINED_GLASS_LIGHT_GRAY,
                    VariantFamilies.STAINED_GLASS_LIME,
                    VariantFamilies.STAINED_GLASS_MAGENTA,
                    VariantFamilies.STAINED_GLASS_ORANGE,
                    VariantFamilies.STAINED_GLASS_PINK,
                    VariantFamilies.STAINED_GLASS_PURPLE,
                    VariantFamilies.STAINED_GLASS_RED,
                    VariantFamilies.STAINED_GLASS_WHITE,
                    VariantFamilies.STAINED_GLASS_YELLOW,
                    VariantFamilies.TORCH,
                    VariantFamilies.CLOUD,
                    VariantFamilies.DIAMOND,
                    VariantFamilies.DIRT,
                    VariantFamilies.EMERALD,
                    VariantFamilies.ENERGIZED_VOIDSTONE,
                    VariantFamilies.GLASS_PANE,
                    VariantFamilies.STAINED_GLASS_PANE_BLACK,
                    VariantFamilies.STAINED_GLASS_PANE_BLUE,
                    VariantFamilies.STAINED_GLASS_PANE_BROWN,
                    VariantFamilies.STAINED_GLASS_PANE_CYAN,
                    VariantFamilies.STAINED_GLASS_PANE_GRAY,
                    VariantFamilies.STAINED_GLASS_PANE_GREEN,
                    VariantFamilies.STAINED_GLASS_PANE_LIGHT_BLUE,
                    VariantFamilies.STAINED_GLASS_PANE_LIGHT_GRAY,
                    VariantFamilies.STAINED_GLASS_PANE_LIME,
                    VariantFamilies.STAINED_GLASS_PANE_MAGENTA,
                    VariantFamilies.STAINED_GLASS_PANE_ORANGE,
                    VariantFamilies.STAINED_GLASS_PANE_PINK,
                    VariantFamilies.STAINED_GLASS_PANE_PURPLE,
                    VariantFamilies.STAINED_GLASS_PANE_RED,
                    VariantFamilies.STAINED_GLASS_PANE_WHITE,
                    VariantFamilies.STAINED_GLASS_PANE_YELLOW,
                    VariantFamilies.GLOWSTONE,
                    VariantFamilies.ICE,
                    VariantFamilies.LIT_PUMPKIN,
                    VariantFamilies.IRON_BARS,
                    VariantFamilies.LAPIS,
                    VariantFamilies.LEAF,
                    VariantFamilies.PACKED_ICE,
                    VariantFamilies.PACKED_ICE_PILLAR,
                    VariantFamilies.PAPERWALL,
                    VariantFamilies.PUMPKIN,
                    VariantFamilies.REDSTONE,
                    VariantFamilies.PAPERWALL_BLOCK,
                    VariantFamilies.ROAD_LINE,
                    VariantFamilies.VALENTINES,
                    VariantFamilies.WOOLEN_CLAY).forEach(family -> family.getVariants().forEach(variant -> output.accept(variant.getBlock().get()))))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODDED = CREATIVE_MODE_TABS.register("chisel_modded", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabModdedChiselBlocks"))
            .icon(() -> new ItemStack(ChiselModdedBlocks.BRONZE_CAUTION.get()))
            .displayItems((_, output) -> List.of(
                    VariantFamilies.BRONZE,
                    VariantFamilies.LEAD,
                    VariantFamilies.SILVER,
                    VariantFamilies.STEEL,
                    VariantFamilies.TIN,
                    VariantFamilies.URANIUM).forEach(family -> family.getVariants().forEach(variant -> output.accept(variant.getBlock().get()))))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHISEL = CREATIVE_MODE_TABS.register("chisel_main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabChisel"))
            .icon(() -> new ItemStack(ChiselItems.CHISEL_IRON.get()))
            .displayItems((_, output) -> {
                output.accept(ChiselItems.CHISEL_IRON.get());
                output.accept(ChiselItems.CHISEL_DIAMOND.get());
                output.accept(ChiselItems.CHISEL_OBSIDIAN.get());
                output.accept(ChiselItems.UPGRADE_STACK.get());
                output.accept(ChiselItems.UPGRADE_SPEED.get());
                output.accept(ChiselItems.UPGRADE_REVERSION.get());
                output.accept(ChiselItems.UPGRADE_AUTOMATION.get());
                output.accept(ChiselItems.BALL_O_MOSS.get());
                output.accept(ChiselItems.CLOUD_IN_A_BOTTLE.get());
                output.accept(ChiselItems.SMASHING_ROCK.get());
            })
            .build());
}
