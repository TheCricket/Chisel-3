package io.github.chiselteam.chisel;

import io.github.chiselteam.chisel.config.ChiselConfigurations;
import io.github.chiselteam.chisel.registry.*;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";

    public Chisel(ModContainer mod, IEventBus bus) {
        ChiselConfigurations.init(mod);
        ChiselModelHandlers.registerAll();
        ChiselModes.register(bus);
        ChiselBuildingModes.register(bus);
        ChiselDataComponents.DATA_COMPONENTS.register(bus);
        ChiselSounds.SOUNDS.register(bus);
        ChiselBlocks.registerBlocks(bus);
        ChiselBlockEntities.BLOCK_ENTITIES.register(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
        ChiselMenus.MENU_TYPES.register(bus);
        ChiselEntities.ENTITY_TYPES.register(bus);
        ChiselParticles.PARTICLES.register(bus);
        ChiselStats.STATS.register(bus);

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ChiselFluidInteractions::init);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
