package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ChiselDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.DataComponents.createDataComponents(Registries.DATA_COMPONENT_TYPE, Chisel.MODID);

    public static final Supplier<DataComponentType<ChiselMode>> CHISEL_MODE = DATA_COMPONENTS.registerComponentType(
            "chisel_mode",
            builder -> builder.persistent(ChiselMode.CODEC).networkSynchronized(ChiselMode.STREAM_CODEC)
    );
}
