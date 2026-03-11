package chisel.registry;

import chisel.Chisel;
import chisel.item.ChiselItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Chisel.MODID);

    public static DeferredItem<Item> CHISEL_IRON = registerChisel("chisel_iron");
    public static DeferredItem<Item> CHISEL_DIAMOND = registerChisel("chisel_diamond");
    public static DeferredItem<Item> CHISEL_OBSIDIAN = registerChisel("chisel_obsidian");

    public static DeferredItem<Item> UPGRADE_STACK = register("upgrade_stack");
    public static DeferredItem<Item> UPGRADE_SPEED = register("upgrade_speed");
    public static DeferredItem<Item> UPGRADE_REVERSION = register("upgrade_reversion");
    public static DeferredItem<Item> UPGRADE_AUTOMATION = register("upgrade_automation");

    public static DeferredItem<Item> BALL_O_MOSS = register("ballomoss");
    public static DeferredItem<Item> CLOUD_IN_A_BOTTLE = register("cloudinabottle");
    public static DeferredItem<Item> SMASHING_ROCK = register("smashingrock");

    private static DeferredItem<Item> register(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    private static DeferredItem<Item> registerChisel(String name) {
        return ITEMS.register(name, () -> new ChiselItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Chisel.prefix(name)))));
    }
}
