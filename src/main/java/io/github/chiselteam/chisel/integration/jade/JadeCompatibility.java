package io.github.chiselteam.chisel.integration.jade;

import io.github.chiselteam.chisel.block.util.*;
import org.jspecify.annotations.NonNull;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeCompatibility implements IWailaPlugin {

    @Override
    public void register(@NonNull IWailaCommonRegistration registration) {
        IWailaPlugin.super.register(registration);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ConnectedTextureBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, NoParticleTorchBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, RoadlineBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ChiselPoweredBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ChiselCarvedPumpkinBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ChiselRedstoneLampBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ChiselIronBarsBlock.class);
        registration.registerBlockComponent(JadeComponentProvider.INSTANCE, ChiselStainedGlassPaneBlock.class);
    }
}
