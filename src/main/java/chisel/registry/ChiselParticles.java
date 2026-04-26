package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Chisel.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HOLYSTONE = register("holystone");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GRIMSTONE = register("grimstone");

    private static DeferredHolder<ParticleType<?>, SimpleParticleType> register(String name) {
        return PARTICLES.register(name, () -> new SimpleParticleType(false));
    }
}
