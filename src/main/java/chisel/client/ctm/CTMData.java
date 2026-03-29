package chisel.client.ctm;

import chisel.core.Variant;
import net.minecraft.core.Direction;

import java.util.Arrays;
import java.util.Objects;

public final class CTMData {

    public final Variant variant;
    private final CTMLogic[][] logic;

    public CTMData(Variant variant, CTMLogic[][] logic) {
        this.variant = variant;

        this.logic = new CTMLogic[6][4];
        for (int i = 0; i < 6; i++) {
            System.arraycopy(logic[i], 0, this.logic[i], 0, 4);
        }
    }

    public CTMLogic get(Direction face, int corner) {
        return logic[face.get3DDataValue()][corner];
    }

    public CTMLogic[][] raw() {
        CTMLogic[][] copy = new CTMLogic[6][4];
        for (int i = 0; i < 6; i++) {
            System.arraycopy(logic[i], 0, copy[i], 0, 4);
        }
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTMData that)) return false;
        return Objects.equals(variant, that.variant) &&
                Arrays.deepEquals(logic, that.logic);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(variant);
        result = 31 * result + Arrays.deepHashCode(logic);
        return result;
    }
}