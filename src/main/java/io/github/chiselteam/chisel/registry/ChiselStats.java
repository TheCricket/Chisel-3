package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselStats {

    public static final DeferredRegister<Identifier> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, Chisel.MODID);

    public static final DeferredHolder<Identifier, Identifier> INTERACT_WITH_AUTO_CHISEL = makeStat( "interact_with_auto_chisel");
    public static final DeferredHolder<Identifier, Identifier> BLOCKS_CHISELED = makeStat( "blocks_chiseled");
    public static final DeferredHolder<Identifier, Identifier> CHISEL_GUIDE_USED = makeStat("chisel_guide_used");

    private static DeferredHolder<Identifier, Identifier> makeStat(String name) {
        Identifier location = Chisel.prefix(name);
        return STATS.register(name, () -> location);
    }
}
