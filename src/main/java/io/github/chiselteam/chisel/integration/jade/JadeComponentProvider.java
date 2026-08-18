package io.github.chiselteam.chisel.integration.jade;

import io.github.chiselteam.chisel.Chisel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public class JadeComponentProvider implements IBlockComponentProvider {

    public static final JadeComponentProvider INSTANCE = new JadeComponentProvider();

    @Override
    public void appendTooltip(@NonNull ITooltip tooltip, @NonNull BlockAccessor accessor, @NonNull IPluginConfig config) {
        tooltip.add(Component.translatable(accessor.getBlock().getDescriptionId() + ".desc"));
    }

    @Override
    public @NonNull Identifier getUid() {
        return Chisel.prefix("jade_plugin");
    }
}
