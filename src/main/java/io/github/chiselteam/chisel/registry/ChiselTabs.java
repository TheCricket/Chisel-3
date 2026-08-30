package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.content.ChiselFamilies;
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
            .icon(() -> new ItemStack(ChiselFamilies.MARBLE.getVariant("marble_raw").get()))
            .displayItems((_, output) -> List.of(
                    ChiselFamilies.ANCIENT_STONE.getFamily(),
                    ChiselFamilies.ANDESITE.getFamily(),
                    ChiselFamilies.BLACKSTONE.getFamily(),
                    ChiselFamilies.GILDED_BLACKSTONE.getFamily(),
                    ChiselFamilies.BRICKS.getFamily(),
                    ChiselFamilies.CHARCOAL.getFamily(),
                    ChiselFamilies.COAL.getFamily(),
                    ChiselFamilies.COBBLESTONE.getFamily(),
                    ChiselFamilies.STONE_BRICKS.getFamily(),
                    ChiselFamilies.C_CONCRETE.getFamily(),
                    ChiselFamilies.BASALT.getFamily(),
                    ChiselFamilies.DIORITE.getFamily(),
                    ChiselFamilies.DEEPSLATE.getFamily(),
                    ChiselFamilies.END_STONE.getFamily(),
                    ChiselFamilies.GRANITE.getFamily(),
                    ChiselFamilies.GRIMSTONE.getFamily(),
                    ChiselFamilies.HOLYSTONE.getFamily(),
                    ChiselFamilies.LAVASTONE.getFamily(),
                    ChiselFamilies.LIMESTONE.getFamily(),
                    ChiselFamilies.MAGMA.getFamily(),
                    ChiselFamilies.MARBLE.getFamily(),
                    ChiselFamilies.MOSSY_COBBLESTONE.getFamily(),
                    ChiselFamilies.MOSSY_BLACKSTONE.getFamily(),
                    ChiselFamilies.MOSSY_TEMPLE.getFamily(),
                    ChiselFamilies.NETHERBRICK.getFamily(),
                    ChiselFamilies.NETHERRACK.getFamily(),
                    ChiselFamilies.OBSIDIAN.getFamily(),
                    ChiselFamilies.PRISMARINE.getFamily(),
                    ChiselFamilies.PURPUR.getFamily(),
                    ChiselFamilies.QUARTZ.getFamily(),
                    ChiselFamilies.RED_SANDSTONE.getFamily(),
                    ChiselFamilies.SANDSTONE.getFamily(),
                    ChiselFamilies.SHINGLE.getFamily(),
                    ChiselFamilies.TEMPLE.getFamily(),
                    ChiselFamilies.TERRACOTTA.getFamily(),
                    ChiselFamilies.VOIDSTONE.getFamily(),
                    ChiselFamilies.TUFF.getFamily(),
                    ChiselFamilies.CALCITE.getFamily(),
                    ChiselFamilies.DRIPSTONE.getFamily(),
                    ChiselFamilies.MUD.getFamily(),
                    ChiselFamilies.RESIN.getFamily(),
                    ChiselFamilies.WATERSTONE.getFamily()
                
                ).forEach(family -> family.getVariants().forEach(variant -> {
                if (variant.shouldGenerateModel() && variant.isInTab())
                            output.accept(variant.getBlock());
            })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WOOD = CREATIVE_MODE_TABS.register("chisel_wood", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabWoodChiselBlocks"))
            .icon(() -> new ItemStack(ChiselFamilies.OAK.getVariant("oak_planks_smooth").get()))
            .displayItems((_, output) -> List.of(
                    ChiselFamilies.ACACIA.getFamily(),
                    ChiselFamilies.BIRCH.getFamily(),
                    ChiselFamilies.CRIMSON.getFamily(),
                    ChiselFamilies.BOOKSHELF.getFamily(),
                    ChiselFamilies.DARK_OAK.getFamily(),
                    ChiselFamilies.JUNGLE.getFamily(),
                    ChiselFamilies.WARPED.getFamily(),
                    ChiselFamilies.CHERRY.getFamily(),
                    ChiselFamilies.MANGROVE.getFamily(),
                    ChiselFamilies.PALE_OAK.getFamily(),
                    ChiselFamilies.OAK.getFamily(),
                    ChiselFamilies.SPRUCE.getFamily(),
                    ChiselFamilies.BAMBOO.getFamily()
                
                ).forEach(family -> family.getVariants().forEach(variant -> {
                if (variant.shouldGenerateModel() && variant.isInTab())
                            output.accept(variant.getBlock());
                    })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> METAL = CREATIVE_MODE_TABS.register("chisel_metal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabMetalChiselBlocks"))
            .icon(() -> new ItemStack(ChiselFamilies.IRON.getVariant("iron_ingots_small").get()))
            .displayItems((_, output) -> List.of(
                    ChiselFamilies.FACTORY.getFamily(),
                    ChiselFamilies.COPPER.getFamily(),
                    ChiselFamilies.EXPOSED_COPPER.getFamily(),
                    ChiselFamilies.WEATHERED_COPPER.getFamily(),
                    ChiselFamilies.OXIDIZED_COPPER.getFamily(),
                    ChiselFamilies.FUTURA.getFamily(),
                    ChiselFamilies.GOLD.getFamily(),
                    ChiselFamilies.HEX_PLATING.getFamily(),
                    ChiselFamilies.IRON.getFamily(),
                    ChiselFamilies.LABORATORY.getFamily(),
                    ChiselFamilies.MILITARY.getFamily(),
                    ChiselFamilies.TECHNICAL.getFamily(),
                    ChiselFamilies.TYRIAN.getFamily(),
                    ChiselFamilies.WARNING.getFamily()
                
                ).forEach(family -> family.getVariants().forEach(variant ->  {
                if (variant.shouldGenerateModel() && variant.isInTab())
                            output.accept(variant.getBlock());
                    })))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OTHER = CREATIVE_MODE_TABS.register("chisel_other", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabOtherChiselBlocks"))
            .icon(() -> new ItemStack(ChiselFamilies.ANTIBLOCK.getVariant("antiblock_black").get()))
            .displayItems((_, output) -> {
                List.of(
                        ChiselFamilies.ANTIBLOCK.getFamily(),
                        ChiselFamilies.GLASS.getFamily(),
                        ChiselFamilies.TORCH.getFamily(),
                        ChiselFamilies.CLOUD.getFamily(),
                        ChiselFamilies.DIAMOND.getFamily(),
                        ChiselFamilies.DIRT.getFamily(),
                        ChiselFamilies.EMERALD.getFamily(),
                        ChiselFamilies.ENERGIZED_VOIDSTONE.getFamily(),
                        ChiselFamilies.GLASS_PANE.getFamily(),
                        ChiselFamilies.GLOWSTONE.getFamily(),
                        ChiselFamilies.SEA_LANTERN.getFamily(),
                        ChiselFamilies.ICE.getFamily(),
                        ChiselFamilies.JACK_O_LANTERN.getFamily(),
                        ChiselFamilies.IRON_BARS.getFamily(),
                        ChiselFamilies.LAPIS.getFamily(),
                        ChiselFamilies.LEAF.getFamily(),
                        ChiselFamilies.PAPERWALL.getFamily(),
                        ChiselFamilies.PUMPKIN.getFamily(),
                        ChiselFamilies.REDSTONE.getFamily(),
                        ChiselFamilies.REDSTONE_LAMP.getFamily(),
                        ChiselFamilies.ROAD_LINE.getFamily(),
                        ChiselFamilies.VALENTINES.getFamily(),
                        ChiselFamilies.NETHERITE.getFamily(),
                        ChiselFamilies.WOOLEN_CLAY.getFamily()
                
                ).forEach(family -> family.getVariants().forEach(variant ->  {
                    if (variant.shouldGenerateModel() && variant.isInTab())
                                output.accept(variant.getBlock());
                        }));
                ChiselFamilies.TORCH.getVariant("torch_1").get();
                ChiselFamilies.TORCH.getVariant("torch_2").get();
                ChiselFamilies.TORCH.getVariant("torch_3").get();
                ChiselFamilies.TORCH.getVariant("torch_4").get();
                ChiselFamilies.TORCH.getVariant("torch_5").get();
                ChiselFamilies.TORCH.getVariant("torch_6").get();
                ChiselFamilies.TORCH.getVariant("torch_7").get();
                ChiselFamilies.TORCH.getVariant("torch_8").get();
                ChiselFamilies.TORCH.getVariant("torch_9").get();
                ChiselFamilies.TORCH.getVariant("torch_10").get();

                ChiselFamilies.WOOLS.forEach(family -> family.getFamily().getVariants().forEach(variant -> {
                    if (variant.shouldGenerateModel() && variant.isInTab())
                        output.accept(variant.getBlock());
                }));

                ChiselFamilies.CONCRETE.forEach(family -> family.getFamily().getVariants().forEach(variant -> {
                    if (variant.shouldGenerateModel() && variant.isInTab())
                        output.accept(variant.getBlock());
                }));

                ChiselFamilies.STAINED_GLASS.forEach(block -> block.getFamily().getVariants().forEach(variant -> output.accept(variant.getBlock())));
                ChiselFamilies.STAINED_GLASS_PANE.forEach(block -> block.getFamily().getVariants().forEach(variant -> output.accept(variant.getBlock())));
            })
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODDED = CREATIVE_MODE_TABS.register("chisel_modded", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tabModdedChiselBlocks"))
            .icon(() -> new ItemStack(ChiselFamilies.BRONZE.getVariant("bronze_caution").get()))
            .displayItems((_, output) -> List.of(
                    ChiselFamilies.ANCIENT_STONE.getFamily(),
                    ChiselFamilies.ALUMINUM.getFamily(),
                    ChiselFamilies.FA_ARCANE_DARKSTONE.getFamily(),
                    ChiselFamilies.BRONZE.getFamily(),
                    ChiselFamilies.AE2_CERTUS.getFamily(),
                    ChiselFamilies.COAL_COKE.getFamily(),
                    ChiselFamilies.COBALT.getFamily(),
                    ChiselFamilies.ELECTRUM.getFamily(),
                    ChiselFamilies.INVAR.getFamily(),
                    ChiselFamilies.LEAD.getFamily(),
                    ChiselFamilies.NV_RUNE.getFamily(),
                    ChiselFamilies.NICKEL.getFamily(),
                    ChiselFamilies.PLATINUM.getFamily(),
                    ChiselFamilies.SILVER.getFamily(),
                    ChiselFamilies.STEEL.getFamily(),
                    ChiselFamilies.THAUMIUM.getFamily(),
                    ChiselFamilies.TIN.getFamily(),
                    ChiselFamilies.OC_TALLOW.getFamily(),
                    ChiselFamilies.URANIUM.getFamily()
                
                ).forEach(family -> family.getVariants().forEach(variant -> {
                if (variant.shouldGenerateModel() && variant.isInTab())
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
                output.accept(ChiselItems.OFFSET_TOOL.get());
                output.accept(ChiselBlocks.AUTO_CHISEL.get().asItem());
                output.accept(ChiselBlocks.BUILDERS_GUIDE.get().asItem());
                output.accept(ChiselItems.UPGRADE_STACK.get());
                output.accept(ChiselItems.UPGRADE_SPEED.get());
                output.accept(ChiselItems.UPGRADE_REVERSION.get());
                output.accept(ChiselItems.UPGRADE_AUTOMATION.get());
                output.accept(ChiselItems.BALL_O_MOSS.get());
                output.accept(ChiselItems.CLOUD_IN_A_BOTTLE.get());
                output.accept(ChiselItems.SMASHING_ROCK.get());
                output.accept(ChiselItems.MEASURING_TAPE.get());
            })
            .build());
}
