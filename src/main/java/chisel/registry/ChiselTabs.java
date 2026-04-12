package chisel.registry;

import chisel.Chisel;
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
            .icon(() -> new ItemStack(ChiselBlocks.MARBLE.getVariant("marble_raw").get()))
            .displayItems((_, output) -> List.of(
                    ChiselBlocks.ANDESITE.getFamily(),
                    ChiselBlocks.BRICKS.getFamily(),
                    ChiselBlocks.COBBLESTONE.getFamily(),
                    ChiselBlocks.STONE_BRICKS.getFamily(),
                    ChiselBlocks.CONCRETE.getFamily(),
                    ChiselBlocks.DIORITE.getFamily(),
                    ChiselBlocks.GRANITE.getFamily(),
                    ChiselBlocks.GRIMSTONE.getFamily(),
                    ChiselBlocks.HOLYSTONE.getFamily(),
                    ChiselBlocks.LAVASTONE.getFamily(),
                    ChiselBlocks.LIMESTONE.getFamily(),
                    ChiselBlocks.MARBLE.getFamily(),
                    ChiselBlocks.MOSSY_COBBLESTONE.getFamily(),
                    ChiselBlocks.MOSSY_TEMPLE.getFamily(),
                    ChiselBlocks.NETHERBRICK.getFamily(),
                    ChiselBlocks.NETHERRACK.getFamily(),
                    ChiselBlocks.OBSIDIAN.getFamily(),
                    ChiselBlocks.SANDSTONE.getFamily(),
                    ChiselBlocks.TEMPLE.getFamily(),
                    ChiselBlocks.VOIDSTONE.getFamily(),
                    ChiselBlocks.WATERSTONE.getFamily()).forEach(family -> family.getVariants().forEach(variant -> {
                        if(variant.shouldGenerateModel() && variant.isInTab)
                            output.accept(variant.getBlock());
            })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WOOD = CREATIVE_MODE_TABS.register("chisel_wood", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabWoodChiselBlocks"))
            .icon(() -> new ItemStack(ChiselBlocks.OAK.getVariant("oak_planks_smooth").get()))
            .displayItems((_, output) -> List.of(
                    ChiselBlocks.ACACIA.getFamily(),
                    ChiselBlocks.BIRCH.getFamily(),
                    ChiselBlocks.CRIMSON.getFamily(),
                    ChiselBlocks.BOOKSHELF.getFamily(),
                    ChiselBlocks.DARK_OAK.getFamily(),
                    ChiselBlocks.JUNGLE.getFamily(),
                    ChiselBlocks.OAK.getFamily(),
                    ChiselBlocks.SPRUCE.getFamily()).forEach(family -> family.getVariants().forEach(variant -> {
                        if(variant.shouldGenerateModel() && variant.isInTab)
                            output.accept(variant.getBlock());
                    })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> METAL = CREATIVE_MODE_TABS.register("chisel_metal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabMetalChiselBlocks"))
            .icon(() -> new ItemStack(ChiselBlocks.IRON.getVariant("iron_ingots_small").get()))
            .displayItems((_, output) -> List.of(
                    ChiselBlocks.FACTORY.getFamily(),
                    ChiselBlocks.COPPER.getFamily(),
                    ChiselBlocks.FUTURA.getFamily(),
                    ChiselBlocks.GOLD.getFamily(),
                    ChiselBlocks.HEX_PLATING.getFamily(),
                    ChiselBlocks.IRON.getFamily(),
                    ChiselBlocks.LABORATORY.getFamily(),
                    ChiselBlocks.TECHNICAL.getFamily(),
                    ChiselBlocks.TYRIAN.getFamily(),
                    ChiselBlocks.ALUMINUM.getFamily(),
                    ChiselBlocks.WARNING.getFamily())
                    .forEach(family -> family.getVariants().forEach(variant ->  {
                        if(variant.shouldGenerateModel() && variant.isInTab)
                            output.accept(variant.getBlock());
                    })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OTHER = CREATIVE_MODE_TABS.register("chisel_other", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabOtherChiselBlocks"))
            .icon(() -> new ItemStack(ChiselBlocks.ANTIBLOCK.getVariant("antiblock_black").get()))
            .displayItems((_, output) -> {
                List.of(
                        ChiselBlocks.ANTIBLOCK.getFamily(),
                        ChiselBlocks.GLASS.getFamily(),
                        ChiselBlocks.TORCH.getFamily(),
                        ChiselBlocks.CLOUD.getFamily(),
                        ChiselBlocks.DIAMOND.getFamily(),
                        ChiselBlocks.DIRT.getFamily(),
                        ChiselBlocks.EMERALD.getFamily(),
                        ChiselBlocks.ENERGIZED_VOIDSTONE.getFamily(),
                        ChiselBlocks.GLASS_PANE.getFamily(),
                        ChiselBlocks.GLOWSTONE.getFamily(),
                        ChiselBlocks.ICE.getFamily(),
                        ChiselBlocks.JACK_O_LANTERN.getFamily(),
                        ChiselBlocks.IRON_BARS.getFamily(),
                        ChiselBlocks.LAPIS.getFamily(),
                        ChiselBlocks.LEAF.getFamily(),
                        ChiselBlocks.PAPERWALL.getFamily(),
                        ChiselBlocks.PUMPKIN.getFamily(),
                        ChiselBlocks.REDSTONE.getFamily(),
                        ChiselBlocks.ROAD_LINE.getFamily(),
                        ChiselBlocks.VALENTINES.getFamily(),
                        ChiselBlocks.WOOLEN_CLAY.getFamily()).forEach(family -> family.getVariants().forEach(variant ->  {
                            if(variant.shouldGenerateModel() && variant.isInTab)
                                output.accept(variant.getBlock());
                }));

                ChiselBlocks.STAINED_GLASS.forEach(block -> block.getFamily().getVariants().forEach(variant -> output.accept(variant.getBlock())));
                ChiselBlocks.STAINED_GLASS_PANE.forEach(block -> block.getFamily().getVariants().forEach(variant -> output.accept(variant.getBlock())));
            })
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODDED = CREATIVE_MODE_TABS.register("chisel_modded", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabModdedChiselBlocks"))
            .icon(() -> new ItemStack(ChiselBlocks.BRONZE.getVariant("bronze_caution").get()))
            .displayItems((_, output) -> List.of(
                    ChiselBlocks.BRONZE.getFamily(),
                    ChiselBlocks.LEAD.getFamily(),
                    ChiselBlocks.SILVER.getFamily(),
                    ChiselBlocks.STEEL.getFamily(),
                    ChiselBlocks.TIN.getFamily(),
                    ChiselBlocks.URANIUM.getFamily()).forEach(family -> family.getVariants().forEach(variant -> {
                        if(variant.shouldGenerateModel() && variant.isInTab)
                            output.accept(variant.getBlock());
            })))
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
