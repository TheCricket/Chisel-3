package chisel.core.variant;
import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum VariantModelType implements StringRepresentable {
    CUBE_ALL("cube_all"),
    PILLAR("pillar"),
    BOOKSHELF("bookshelf"),
    TBS("top_bottom_side"),
    CONNECTED("connected"),
    CONNECTED_TBS("connected_tbs"),
    CTMV("ctmv"),
    CTMH("ctmh"),
    MULTI_LAYER("multi_layer"),
    MULTI_LAYER_TBS("multi_layer_tbs"),
    MULTI_LAYER_TBS_TINTED("multi_layer_tbs_tinted"),
    MULTI_LAYER_LAVA("multi_layer_lava"),
    MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE("multi_layer_lava_top_bottom_side"),
    LAVA_2x2("lava_2x2"),
    LAVA_3x3("lava_3x3"),
    LAVA_4x4("lava_4x4"),
    MULTI_LAYER_WATER("multi_layer_water"),
    MULTI_LAYER_CONNECTED("multi_layer_connected"),
    MULTI_LAYER_CONNECTED_TINTED("multi_layer_connected_tinted"),
    MULTI_LAYER_CONNECTED_GLOW("multi_layer_connected_glow"),
    CARPET("carpet"),
    IRON_BARS("iron_bars"),
    GLASS_PANE("glass_pane"),
    MOSSY("mossy"),
    MOSSY_TOP_BOTTOM_SIDE("mossy_top_bottom_side"),
    PUMPKIN("pumpkin"),
    TORCH("torch"),
    WALL_TORCH("wall_torch"),
    ROAD_LINES("road_lines"),
    V4("v4"),
    MULTIBLOCK_2X2("multiblock_2x2"),
    MULTIBLOCK_3X3("multiblock_3x3"),
    MULTIBLOCK_4X4("multiblock_4x4"),
    MULTI_LAYER_WATER_2X2("multi_layer_water_2x2"),
    MULTI_LAYER_WATER_3X3("multi_layer_water_3x3"),
    MULTI_LAYER_WATER_4X4("multi_layer_water_4x4");

    public static final Codec<VariantModelType> CODEC = StringRepresentable.fromEnum(VariantModelType::values);
    private final String name;

    VariantModelType(String name) {
        this.name = name;
    }

    @Override
    public @NonNull String getSerializedName() {
        return name;
    }
}
