package io.github.chiselteam.chisel.event.client;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.chiselteam.chisel.Chisel;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class ChiselKeyMappings {

    public static final KeyMapping.Category CATEGORY = new KeyMapping.Category(Chisel.prefix("chisel"));
    public static final KeyMapping MODE_SELECT = new KeyMapping(
            "key.chisel.mode_select",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            CATEGORY
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.registerCategory(CATEGORY);
        event.register(MODE_SELECT);
    }
}
