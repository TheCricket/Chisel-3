package chisel.core;
import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

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
    MULTI_LAYER_LAVA("multi_layer_lava"),
    MULTI_LAYER_WATER("multi_layer_water"),
    CARPET("carpet");

    public static final Codec<VariantModelType> CODEC = StringRepresentable.fromEnum(VariantModelType::values);
    private final String name;

    VariantModelType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
