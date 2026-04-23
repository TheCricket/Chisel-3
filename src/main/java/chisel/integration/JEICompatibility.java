package chisel.integration;

import chisel.Chisel;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@JeiPlugin
public class JEICompatibility implements IModPlugin {
    @Override
    public @NonNull Identifier getPluginUid() {
        return Chisel.prefix("jei_plugin");
    }
}
