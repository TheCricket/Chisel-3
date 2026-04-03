package chisel.core;
import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum VariantModelType implements StringRepresentable {
    CUBE_ALL("cube_all"),
    PILLAR("pillar"),
    BOOKSHELF("bookshelf"),
    TOP_BOTTOM_SIDE("top_bottom_side"),
    TOP_BOTTOM_SIDE_CONNECTED_VERTICALLY("top_bottom_side_connected_vertically"),
    CONNECTED("connected"),
    CONNECTED_VERTICALLY("connected_vertically"),
    CONNECTED_HORIZONTALLY("connected_horizontally"),
    MULTI_LAYER("multi_layer"),
    MULTI_LAYER_TBS("multi_layer_tbs"),
    MULTI_LAYER_LAVA("multi_layer_lava"),
    MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE("multi_layer_lava_top_bottom_side"),
    MULTI_LAYER_WATER("multi_layer_water"),
    MULTI_LAYER_CONNECTED("multi_layer_connected"),
    MULTI_LAYER_CONNECTED_GLOW("multi_layer_connected_glow"),
    CARPET("carpet"),
    IRON_BARS("iron_bars"),
    MOSSY("mossy"),
    MOSSY_TOP_BOTTOM_SIDE("mossy_top_bottom_side"),
    PUMPKIN("pumpkin"),
    GLASS_PANE("glass_pane");

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
