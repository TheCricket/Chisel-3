package chisel.client;

import chisel.Chisel;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import static chisel.client.ChiselTextureSlots.*;
import static net.minecraft.client.data.models.model.TextureSlot.*;

import java.util.Optional;

public class ChiselModelTemplates extends ModelTemplates {

    public static final ModelTemplate CTM = create("chisel:ctm", PARTICLE, ALL, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_NO_BASE = create("chisel:ctm_no_base", PARTICLE, ALL, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_NO_BASE_TBS = create("chisel:ctm_no_base_tbs", PARTICLE, ALL, TOP, BOTTOM, SIDE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_bottom_top_inner_faces")).build();
    public static final ModelTemplate CTM_MULTI_PASS = create("chisel:ctm_multi_pass", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass")).build();
    public static final ModelTemplate CTM_MULTI_PASS_TINTED = create("chisel:ctm_multi_pass_tinted", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass_tinted")).build();
    public static final ModelTemplate CTM_MULTI_PASS_NO_GLOW = create("chisel:ctm_multi_pass_no_glow", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass_no_glow")).build();

    public static final ModelTemplate CUBE_MULTI_PASS = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TINTED = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_tinted")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_NO_GLOW = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_no_glow")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side")), Optional.empty(), TOP, BOTTOM, SIDE, LAYER0, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_TINTED = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side_tinted")), Optional.empty(), TOP, BOTTOM, SIDE, LAYER0, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_NO_GLOW = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side_no_glow")), Optional.empty(), TOP, BOTTOM, SIDE, LAYER0, PARTICLE);

    public static final ModelTemplate TORCH = new ModelTemplate(Optional.of(Chisel.prefix("block/torch")), Optional.empty(), TextureSlot.TORCH);
    public static final ModelTemplate WALL_TORCH = new ModelTemplate(Optional.of(Chisel.prefix("block/wall_torch")), Optional.empty(), TextureSlot.TORCH);
}
