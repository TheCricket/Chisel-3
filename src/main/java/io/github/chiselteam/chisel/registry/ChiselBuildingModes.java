package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.mode.building.impl.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselBuildingModes {

    public static final ResourceKey<Registry<ChiselBuildingMode>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("building_modes"));
    public static final DeferredRegister<ChiselBuildingMode> BUILDING_MODES = DeferredRegister.create(KEY, Chisel.MODID);
    public static final Registry<ChiselBuildingMode> REGISTRY = BUILDING_MODES.makeRegistry(_ -> {});

    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> CUBOID = BUILDING_MODES.register("cuboid", CuboidMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> FULL_CUBOID = BUILDING_MODES.register("full_cuboid", FullCuboidMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> SPHERE = BUILDING_MODES.register("sphere", SphereMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> DOME = BUILDING_MODES.register("dome", DomeMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> CYLINDER = BUILDING_MODES.register("cylinder", CylinderMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> TRIANGLE = BUILDING_MODES.register("triangle", TriangleMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> PENTAGON = BUILDING_MODES.register("pentagon", PentagonMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> HEXAGON = BUILDING_MODES.register("hexagon", HexagonMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> OCTAGON = BUILDING_MODES.register("octagon", OctagonMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> AXES = BUILDING_MODES.register("axes", AxisMode::new);
    public static final DeferredHolder<ChiselBuildingMode, ChiselBuildingMode> PLANES = BUILDING_MODES.register("planes", PlanesMode::new);

    public static void register(IEventBus bus) {
        BUILDING_MODES.register(bus);
    }
}
