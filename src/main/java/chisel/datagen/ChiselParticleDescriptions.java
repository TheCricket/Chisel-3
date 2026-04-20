package chisel.datagen;

import chisel.Chisel;
import chisel.registry.ChiselParticles;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;

public class ChiselParticleDescriptions extends ParticleDescriptionProvider {
    /**
     * Creates an instance of the data provider.
     *
     * @param output the expected root directory the data generator outputs to
     */
    public ChiselParticleDescriptions(PackOutput output) {
        super(output);
    }

    @Override
    protected void addDescriptions() {
        spriteSet(ChiselParticles.HOLYSTONE.get(), Chisel.prefix("holystone_star"));
        spriteSet(ChiselParticles.GRIMSTONE.get(), Chisel.prefix("grimstone_star"));
    }
}
