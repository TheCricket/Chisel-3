package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class ChiselStats {
    public static final Identifier INTERACT_WITH_AUTO_CHISEL = makeStat( "interact_with_auto_chisel");
    public static final Identifier BLOCKS_CHISELED = makeStat( "blocks_chiseled");

    private static Identifier makeStat(String name) {
        Identifier location = Chisel.prefix(name);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, name, location);
        Stats.CUSTOM.get(location, StatFormatter.DEFAULT);
        return location;
    }
}
