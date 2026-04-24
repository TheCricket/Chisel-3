package chisel.registry;

import chisel.Chisel;
import chisel.item.BallOMossItem;
import chisel.item.ChiselItem;
import chisel.item.CloudInABottleItem;
import chisel.item.SmashingRockItem;
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

    public static DeferredItem<Item> CHISEL_IRON = registerChisel("chisel_iron", new Item.Properties().stacksTo(1).durability(512));
    public static DeferredItem<Item> CHISEL_DIAMOND = registerChisel("chisel_diamond", new Item.Properties().stacksTo(1).durability(5096));
    public static DeferredItem<Item> CHISEL_OBSIDIAN = registerChisel("chisel_obsidian", new Item.Properties().stacksTo(1).durability(10048));

    public static DeferredItem<Item> UPGRADE_STACK = register("upgrade_stack");
    public static DeferredItem<Item> UPGRADE_SPEED = register("upgrade_speed");
    public static DeferredItem<Item> UPGRADE_REVERSION = register("upgrade_reversion");
    public static DeferredItem<Item> UPGRADE_AUTOMATION = register("upgrade_automation");
    public static DeferredItem<Item> AUTO_CHISEL = ITEMS.registerItem("auto_chisel", p -> new BlockItem(ChiselBlocks.AUTO_CHISEL.get(), p), Item.Properties::new);

    public static DeferredItem<Item> BALL_O_MOSS = register("ballomoss", BallOMossItem::new, Item.Properties::new);
    public static DeferredItem<Item> CLOUD_IN_A_BOTTLE = register("cloudinabottle", CloudInABottleItem::new, Item.Properties::new);
    public static DeferredItem<Item> SMASHING_ROCK = register("smashingrock", SmashingRockItem::new, Item.Properties::new);

    private static DeferredItem<Item> register(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    private static DeferredItem<Item> register(String name, Function<Item.Properties, ? extends Item> func, Supplier<Item.Properties> properties) {
        return ITEMS.registerItem(name, func, properties);
    }

    private static DeferredItem<Item> registerChisel(String name, Item.Properties props) {
        return ITEMS.register(name, () -> new ChiselItem(props.setId(ResourceKey.create(Registries.ITEM, Chisel.prefix(name)))));
    }
}
