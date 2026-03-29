package chisel.client;

import chisel.Chisel;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ChiselModelTemplates extends ModelTemplates {

    public static final ModelTemplate CTM = create("chisel:ctm", TextureSlot.PARTICLE, TextureSlot.ALL, ChiselTextureSlots.CTM_BASE, ChiselTextureSlots.CTM_OVERLAY, ChiselTextureSlots.CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_NO_BASE = create("chisel:ctm", TextureSlot.PARTICLE, ChiselTextureSlots.CTM_OVERLAY, ChiselTextureSlots.CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/block")).build();

    public static final ModelTemplate CUBE_MULTI_PASS = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass")),
            Optional.empty(),
            TextureSlot.LAYER0,
            TextureSlot.LAYER1,
            TextureSlot.PARTICLE
    );

    public static final ModelTemplate CUBE_MULTI_PASS_NO_GLOW = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass_no_glow")),
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

    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_NO_GLOW = new ModelTemplate(
            Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side_no_glow")),
            Optional.empty(),
            TextureSlot.TOP,
            TextureSlot.BOTTOM,
            TextureSlot.SIDE,
            TextureSlot.LAYER1,
            TextureSlot.PARTICLE
    );
}
