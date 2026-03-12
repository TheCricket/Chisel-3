package chisel.datagen;

import chisel.Chisel;
import chisel.registry.ChiselSounds;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ChiselSoundDefinitionProvider extends SoundDefinitionsProvider {

    /**
     * Creates a new instance of this data provider.
     *
     * @param output The {@linkplain PackOutput} instance provided by the data generator.
     */
    public ChiselSoundDefinitionProvider(PackOutput output) {
        super(output, Chisel.MODID);
    }

    @Override
    public void registerSounds() {
        add(ChiselSounds.FALLBACK, SoundDefinition.definition()
                .with(sound(Chisel.prefix("chisel/fallback")))
        );

        add(ChiselSounds.WOOD, SoundDefinition.definition()
                .with(sound(Chisel.prefix("chisel/wood2")))
                .with(sound(Chisel.prefix("chisel/wood3")))
                .with(sound(Chisel.prefix("chisel/wood4")))
                .with(sound(Chisel.prefix("chisel/wood5")))
                .with(sound(Chisel.prefix("chisel/wood8")))
                .with(sound(Chisel.prefix("chisel/wood9")))
                .with(sound(Chisel.prefix("chisel/wood11")))
        );

        add(ChiselSounds.SQUASH, SoundDefinition.definition()
                .with(sound(Chisel.prefix("random/squash")))
                .with(sound(Chisel.prefix("random/squash2")))
        );

        add(ChiselSounds.DIG_HOLYSTONE, SoundDefinition.definition()
                .with(sound(Chisel.prefix("dig/holystone1")))
                .with(sound(Chisel.prefix("dig/holystone2")))
                .with(sound(Chisel.prefix("dig/holystone5")))
        );

        add(ChiselSounds.DIG_GRIMSTONE, SoundDefinition.definition()
                .with(sound(Chisel.prefix("dig/grimstone1")))
        );

        add(ChiselSounds.DIG_METAL, SoundDefinition.definition()
                .with(sound(Chisel.prefix("dig/metal")))
                .with(sound(Chisel.prefix("dig/metal1")))
                .with(sound(Chisel.prefix("dig/metal2")))
                .with(sound(Chisel.prefix("dig/metal3")))
                .with(sound(Chisel.prefix("dig/metal7")))
                .with(sound(Chisel.prefix("dig/metal8")))
        );

        add(ChiselSounds.STEP_TEMPLE, SoundDefinition.definition()
                .with(sound(Chisel.prefix("step/templeblock1")))
                .with(sound(Chisel.prefix("step/templeblock2")))
                .with(sound(Chisel.prefix("step/templeblock3")))
                .with(sound(Chisel.prefix("step/templeblock4")))
                .with(sound(Chisel.prefix("step/templeblock5")))
        );

        add(ChiselSounds.STEP_HOLYSTONE, SoundDefinition.definition()
                .with(sound(Chisel.prefix("step/holystone3")))
                .with(sound(Chisel.prefix("step/holystone7")))
        );

        add(ChiselSounds.STEP_METAL, SoundDefinition.definition()
                .with(sound(Chisel.prefix("step/metal4")))
                .with(sound(Chisel.prefix("step/metal5")))
                .with(sound(Chisel.prefix("step/metal6")))
                .with(sound(Chisel.prefix("step/metal9")))
        );
    }
}
