package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Chisel.MODID);

    public static final Holder<SoundEvent> FALLBACK = register("fallback");
    public static final Holder<SoundEvent> WOOD = register("wood");
    public static final Holder<SoundEvent> SQUASH = register("squash");
    public static final Holder<SoundEvent> DIG_HOLYSTONE = register("dig_holystone");
    public static final Holder<SoundEvent> DIG_GRIMSTONE = register("dig_grimstone");
    public static final Holder<SoundEvent> DIG_METAL = register("dig_metal");
    public static final Holder<SoundEvent> STEP_TEMPLE = register("step_temple");
    public static final Holder<SoundEvent> STEP_HOLYSTONE = register("step_holystone");
    public static final Holder<SoundEvent> STEP_METAL = register("step_metal");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        return SOUNDS.register(name, SoundEvent::createVariableRangeEvent);
    }
}
