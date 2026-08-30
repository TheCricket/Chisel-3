package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import io.github.chiselteam.chisel.mode.chisel.impl.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselModes {

    public static final ResourceKey<Registry<ChiselMode>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("modes"));
    public static final DeferredRegister<ChiselMode> MODES = DeferredRegister.create(KEY, Chisel.MODID);
    public static final Registry<ChiselMode> REGISTRY = MODES.makeRegistry(_ -> {});

    public static final DeferredHolder<ChiselMode, ChiselMode> SINGLE = MODES.register("single", SingleChiselMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> PANEL = MODES.register("panel", PanelChiselMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> COLUMN = MODES.register("column", ColumnChiselMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> ROW = MODES.register("row", RowChiselMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> SHAPELESS = MODES.register("shapeless", ShapelessMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> SHAPELESS_FLAT = MODES.register("shapeless_flat", ShapelessFlatMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> SHAPELESS_EXACT = MODES.register("shapeless_exact", ShapelessExactMode::new);
    public static final DeferredHolder<ChiselMode, ChiselMode> SHAPELESS_FLAT_EXACT = MODES.register("shapeless_flat_exact", ShapelessFlatExactMode::new);

    public static void register(IEventBus bus) {
        MODES.register(bus);
    }
}
