package chisel.core.model;

import chisel.Chisel;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

import java.util.Optional;

public class ChiselModelTemplates {

    public static final ModelTemplate CUBE_MULTI_PASS = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass")),
            Optional.empty(),
            TextureSlot.LAYER0,
            TextureSlot.LAYER1,
            TextureSlot.PARTICLE
    );

    public static final ModelTemplate CUBE_MULTI_PASS_CONNECTED = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass_ctm")),
            Optional.empty(),
            TextureSlot.LAYER1,
            TextureSlot.DOWN,
            TextureSlot.UP,
            TextureSlot.NORTH,
            TextureSlot.WEST,
            TextureSlot.EAST,
            TextureSlot.SOUTH,
            TextureSlot.PARTICLE
    );

    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side")),
            Optional.empty(),
            TextureSlot.TOP,
            TextureSlot.BOTTOM,
            TextureSlot.SIDE,
            TextureSlot.LAYER1,
            TextureSlot.PARTICLE
    );
}
