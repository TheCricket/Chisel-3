package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.item.BuildersGuideBlockItem;
import io.github.chiselteam.chisel.config.CommonConfig;
import io.github.chiselteam.chisel.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ChiselItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Chisel.MODID);

    public static DeferredItem<Item> CHISEL_IRON, CHISEL_DIAMOND, CHISEL_OBSIDIAN;
    public static DeferredItem<Item> OFFSET_TOOL;
    public static DeferredItem<Item> UPGRADE_STACK, UPGRADE_SPEED, UPGRADE_REVERSION, UPGRADE_AUTOMATION;
    public static DeferredItem<Item> AUTO_CHISEL, BUILDERS_GUIDE;
    public static DeferredItem<Item> BALL_O_MOSS, CLOUD_IN_A_BOTTLE, SMASHING_ROCK, MEASURING_TAPE;

    private static DeferredItem<Item> register(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    private static DeferredItem<Item> register(String name, Function<Item.Properties, ? extends Item> func, Supplier<Item.Properties> properties) {
        return ITEMS.registerItem(name, func, properties);
    }

    private static DeferredItem<Item> registerChisel(String name, Item.Properties props) {
        return ITEMS.register(name, () -> new ChiselItem(props.setId(ResourceKey.create(Registries.ITEM, Chisel.prefix(name)))));
    }

    static {
        int iron_durability = CommonConfig.IRON_CHISEL_DURABILITY.getAsInt();
        int diamond_durability = CommonConfig.DIAMOND_CHISEL_DURABILITY.getAsInt();
        int obsidian_durability = CommonConfig.OBSIDIAN_CHISEL_DURABILITY.getAsInt();

        CHISEL_IRON = iron_durability > 0 ? registerChisel("chisel_iron", getChiselProps().durability(iron_durability)) : registerChisel("chisel_iron", getChiselProps());
        CHISEL_DIAMOND = diamond_durability > 0 ? registerChisel("chisel_diamond", getChiselProps().durability(diamond_durability)) : registerChisel("chisel_diamond", getChiselProps());
        CHISEL_OBSIDIAN = obsidian_durability > 0 ? registerChisel("chisel_obsidian", getChiselProps().durability(obsidian_durability)) : registerChisel("chisel_obsidian", getChiselProps());

        OFFSET_TOOL = register("offset_tool", OffsetToolItem::new, Item.Properties::new);

        UPGRADE_STACK = register("upgrade_stack");
        UPGRADE_SPEED = register("upgrade_speed");
        UPGRADE_REVERSION = register("upgrade_reversion");
        UPGRADE_AUTOMATION = register("upgrade_automation");

        AUTO_CHISEL = ITEMS.registerItem("auto_chisel", p -> new BlockItem(ChiselBlocks.AUTO_CHISEL.get(), p), Item.Properties::new);
        BUILDERS_GUIDE = ITEMS.registerItem("builders_guide", p -> new BuildersGuideBlockItem(ChiselBlocks.BUILDERS_GUIDE.get(), p), Item.Properties::new);

        BALL_O_MOSS = register("ballomoss", BallOMossItem::new, Item.Properties::new);
        CLOUD_IN_A_BOTTLE = register("cloudinabottle", CloudInABottleItem::new, Item.Properties::new);
        SMASHING_ROCK = register("smashingrock", SmashingRockItem::new, Item.Properties::new);
        MEASURING_TAPE = register("measuring_tape", MeasuringTapeItem::new, Item.Properties::new);
    }

    private static Item.Properties getChiselProps() {
        return new Item.Properties().stacksTo(1);
    }
}
