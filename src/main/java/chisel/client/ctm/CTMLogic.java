package chisel.client.ctm;

import com.mojang.serialization.Codec;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

import static net.minecraft.core.Direction.*;

public enum CTMLogic implements StringRepresentable {

    NONE(0, 0, 0, 16, 16),
    CORNERLESS(1, 0, 0, 8, 8),
    VERTICAL(1, 0, 8, 8, 16),
    HORIZONTAL(1, 8, 0, 16, 8),
    CORNER(1, 8, 8, 16, 16);

    private final int texture;
    private final int u0, v0, u1, v1;

    public static final Direction[][] AXIS_PLANE_DIRECTIONS = {
            {UP, NORTH, DOWN, SOUTH},
            {NORTH, EAST, SOUTH, WEST},
            {UP, EAST, DOWN, WEST},
    };

    CTMLogic(int texture, int u0, int v0, int u1, int v1) {
        this.texture = texture;
        this.u0 = u0;
        this.v0 = v0;
        this.u1 = u1;
        this.v1 = v1;
    }

    public static CTMLogic of(boolean horizontal, boolean vertical, boolean corner) {
        if (corner) {
            return CORNERLESS;
        } else if (horizontal) {
            return vertical ? CORNER : HORIZONTAL;
        } else {
            return vertical ? VERTICAL : NONE;
        }
    }

    public Material.Baked chooseMaterial(Material.Baked[] textures) {
        return textures[texture];
    }

    public CuboidFace.UVs remapUVs(CuboidFace.UVs uvs) {
        return new CuboidFace.UVs(getU(uvs.minU()), getV(uvs.minV()), getU(uvs.maxU()), getV(uvs.maxV()));
    }

    public float getU(float delta) {
        return (float) this.u0 + (float) (this.u1 - this.u0) * (delta / 16.0F);
    }

    public float getV(float delta) {
        return (float) this.v0 + (float) (this.v1 - this.v0) * (delta / 16.0F);
    }

    public static final Codec<CTMLogic> CODEC = StringRepresentable.fromEnum(CTMLogic::values);

    @Override
    public @NonNull String getSerializedName() {
        return name().toLowerCase();
    }
}
