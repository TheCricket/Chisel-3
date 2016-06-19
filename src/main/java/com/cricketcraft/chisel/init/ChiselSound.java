package com.cricketcraft.chisel.init;

import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ChiselSound {

    public static final SoundType soundTypeHolyStone;
    public static final SoundType soundTypeGrimstone;
    public static final SoundType soundTypeChiselMetal;
    public static final SoundType soundTypeTemple;

    public static final SoundEvent holystone_dig;
    public static final SoundEvent holystone_step;
    public static final SoundEvent grimstone_dig;
    public static final SoundEvent grimstone_step;
    public static final SoundEvent metal_dig;
    public static final SoundEvent metal_step;
    public static final SoundEvent temple_step;
    public static final SoundEvent ballomoss;
    public static final SoundEvent chiselWood;
    public static final SoundEvent chiselFallback;

    static {
        holystone_dig = getRegisteredSoundEvent("chisel:dig.holystone");
        holystone_step = getRegisteredSoundEvent("chisel:step.holystone");
        grimstone_dig = getRegisteredSoundEvent("chisel:dig.grimstone");
        grimstone_step = getRegisteredSoundEvent("chisel:step.grimstone");
        metal_dig = getRegisteredSoundEvent("chisel:dig.metal");
        metal_step = getRegisteredSoundEvent("chisel:step.metal");
        temple_step = getRegisteredSoundEvent("chisel:step.temple");
        ballomoss = getRegisteredSoundEvent("chisel:random.squash");
        chiselWood = getRegisteredSoundEvent("chisel:chisel.wood");
        chiselFallback = getRegisteredSoundEvent("chisel:chisel.fallback");

        soundTypeHolyStone = new SoundType(1.0F, 1.0F, holystone_dig, holystone_step, holystone_dig, holystone_dig, holystone_step);
        soundTypeGrimstone = new SoundType(0.3F, 1.0F, grimstone_dig, grimstone_step, grimstone_dig, grimstone_dig, grimstone_step);
        soundTypeChiselMetal = new SoundType(1.0F, 1.0F, metal_dig, metal_step, metal_dig, metal_dig, metal_step);
        soundTypeTemple = new SoundType(1.0F, 1.0F, temple_step, temple_step, temple_step, temple_step, temple_step);
    }

    private static SoundEvent getRegisteredSoundEvent(String id) {
        SoundEvent soundevent = (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation(id));

        if (soundevent == null) {
            throw new IllegalStateException("Invalid Sound requested: " + id);
        } else {
            return soundevent;
        }
    }
}
