package chisel.client;

import chisel.Chisel;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

import static chisel.client.ChiselTextureSlots.*;
import static net.minecraft.client.data.models.model.TextureSlot.*;

public class ChiselModelTemplates extends ModelTemplates {

    public static final ModelTemplate CTM = create("chisel:ctm_no_base", PARTICLE, ALL, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_TBS = create("chisel:ctm_no_base_tbs", PARTICLE, ALL, TOP, BOTTOM, SIDE, CTM_OVERLAY, CTM_OVERLAY_TOP, CTM_OVERLAY_TOP_CONNECTED, CTM_OVERLAY_BOTTOM, CTM_OVERLAY_BOTTOM_CONNECTED, CTM_OVERLAY_SIDE, CTM_OVERLAY_SIDE_CONNECTED, CTM_OVERLAY_CONNECTED).extend().parent(Identifier.withDefaultNamespace("block/cube_bottom_top_inner_faces")).build();
    public static final ModelTemplate CTM_MULTI_PASS = create("chisel:ctm_multi_pass", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass")).build();
    public static final ModelTemplate CTM_MULTI_PASS_TINTED = create("chisel:ctm_multi_pass_tinted", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass_tinted")).build();
    public static final ModelTemplate CTM_MULTI_PASS_NO_GLOW = create("chisel:ctm_multi_pass_no_glow", PARTICLE, ALL, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY, CTM_OVERLAY_CONNECTED).extend().parent(Chisel.prefix("block/cube_multi_pass_no_glow")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_2x2 = create("chisel:ctm_multiblock_2x2", PARTICLE, ALL, CTM_OVERLAY_2X2).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_3x3 = create("chisel:ctm_multiblock_3x3", PARTICLE, ALL, CTM_OVERLAY_3X3).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_4x4 = create("chisel:ctm_multiblock_4x4", PARTICLE, ALL, CTM_OVERLAY_4X4).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_2x2_WATER = create("chisel:ctm_multiblock_2x2_water", PARTICLE, ALL, LAYER0, LAYER1, CTM_OVERLAY_2X2).extend().parent(Chisel.prefix("block/cube_multi_pass_tinted")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_3x3_WATER = create("chisel:ctm_multiblock_3x3_water", PARTICLE, ALL, LAYER0, LAYER1, CTM_OVERLAY_3X3).extend().parent(Chisel.prefix("block/cube_multi_pass_tinted")).build();
    public static final ModelTemplate CTM_MULTIBLOCK_4x4_WATER = create("chisel:ctm_multiblock_4x4_water", PARTICLE, ALL, LAYER0, LAYER1, CTM_OVERLAY_4X4).extend().parent(Chisel.prefix("block/cube_multi_pass_tinted")).build();
    public static final ModelTemplate CTM_HORIZONTAL = create("chisel:ctm_horizontal", PARTICLE, ALL, TOP, BOTTOM, SIDE, CTM_OVERLAY_HORIZONTAL).extend().parent(Identifier.withDefaultNamespace("block/cube_all")).build();
    public static final ModelTemplate CTM_VERTICAL = create("chisel:ctm_vertical", PARTICLE, ALL, TOP, BOTTOM, SIDE, CTM_OVERLAY, CTM_OVERLAY_TOP, CTM_OVERLAY_BOTTOM, CTM_OVERLAY_BOTTOM, CTM_OVERLAY_SIDE_CONNECTED, CTM_OVERLAY_VERTICAL).extend().parent(Identifier.withDefaultNamespace("block/cube_bottom_top_inner_faces")).build();
    public static final ModelTemplate CTM_HORIZONTAL_MULTI_PASS = create("chisel:ctm_horizontal_multi_pass", PARTICLE, TOP, BOTTOM, SIDE, LAYER0, LAYER1, CTM_BASE, CTM_OVERLAY_HORIZONTAL).extend().parent(Chisel.prefix("block/cube_multi_pass_top_bottom_side")).build();

    public static final ModelTemplate CUBE_MULTI_PASS = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TINTED = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_tinted")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_NO_GLOW = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_no_glow")), Optional.empty(), LAYER0, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side")), Optional.empty(), LAYER0, TOP, BOTTOM, SIDE, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_TINTED = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side_tinted")), Optional.empty(), LAYER0, TOP, BOTTOM, SIDE, LAYER1, PARTICLE);
    public static final ModelTemplate CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_NO_GLOW = new ModelTemplate(Optional.of(Chisel.prefix("block/cube_multi_pass_top_bottom_side_no_glow")), Optional.empty(), LAYER0, TOP, BOTTOM, SIDE, LAYER1, PARTICLE);

    public static final ModelTemplate TORCH = new ModelTemplate(Optional.of(Chisel.prefix("block/torch")), Optional.empty(), TextureSlot.TORCH);
    public static final ModelTemplate WALL_TORCH = new ModelTemplate(Optional.of(Chisel.prefix("block/wall_torch")), Optional.empty(), TextureSlot.TORCH);
    public static final ModelTemplate ROAD_LINES = new ModelTemplate(Optional.of(Chisel.prefix("block/road_lines")), Optional.empty(), TextureSlot.TEXTURE);

    public static final ModelTemplate CTM_MULTI_PASS_MULTIBLOCK_2x2 = create("chisel:ctm_multi_pass_multiblock_2x2", PARTICLE, ALL, CTM_OVERLAY_2X2).extend().parent(Chisel.prefix("block/cube_multi_pass")).build();
    public static final ModelTemplate CTM_MULTI_PASS_MULTIBLOCK_3x3 = create("chisel:ctm_multi_pass_multiblock_3x3", PARTICLE, ALL, CTM_OVERLAY_3X3).extend().parent(Chisel.prefix("block/cube_multi_pass")).build();
    public static final ModelTemplate CTM_MULTI_PASS_MULTIBLOCK_4x4 = create("chisel:ctm_multi_pass_multiblock_4x4", PARTICLE, ALL, CTM_OVERLAY_4X4).extend().parent(Chisel.prefix("block/cube_multi_pass")).build();
}
