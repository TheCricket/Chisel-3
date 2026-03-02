package chisel.registry;

import chisel.Chisel;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Chisel.MODID);

    public static DeferredItem<Item> CHISEL_IRON = register("chisel_iron");
    public static DeferredItem<Item> CHISEL_DIAMOND = register("chisel_diamond");
    public static DeferredItem<Item> CHISEL_OBSIDIAN = register("chisel_obsidian");

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
}
