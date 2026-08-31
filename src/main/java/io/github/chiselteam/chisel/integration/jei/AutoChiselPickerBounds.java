package io.github.chiselteam.chisel.integration.jei;

import io.github.chiselteam.chisel.client.gui.AutoChiselScreen;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import net.minecraft.client.renderer.Rect2i;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class AutoChiselPickerBounds implements IGuiContainerHandler<AutoChiselScreen> {
    @Override
    public @NonNull List<Rect2i> getGuiExtraAreas(AutoChiselScreen screen) {
        return screen.getPickerBounds();
    }
}
