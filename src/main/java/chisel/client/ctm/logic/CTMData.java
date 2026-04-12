package chisel.client.ctm.logic;

import chisel.core.variant.Variant;
import net.minecraft.core.Direction;

import java.util.Arrays;
import java.util.Objects;

public final class CTMData {

    public final Variant variant;
    private final CTMLogic[][] logic;
    private final CTMLogic2x2[] logic2x2;
    private final CTMLogic3x3[] logic3x3;
    private final CTMLogic4x4[] logic4x4;

    public CTMData(Variant variant, CTMLogic[][] logic) {
        this(variant, logic, null, null, null);
    }

    public CTMData(Variant variant, CTMLogic[][] logic, CTMLogic2x2[] logic2x2, CTMLogic3x3[] logic3x3, CTMLogic4x4[] logic4x4) {
        this.variant = variant;
        this.logic = new CTMLogic[6][4];
        if (logic != null) {
            for (int i = 0; i < 6; i++) {
                System.arraycopy(logic[i], 0, this.logic[i], 0, 4);
            }
        }
        this.logic2x2 = logic2x2;
        this.logic3x3 = logic3x3;
        this.logic4x4 = logic4x4;
    }

    public CTMLogic get(Direction face, int corner) {
        return logic[face.get3DDataValue()][corner];
    }

    public CTMLogic2x2 get2x2(Direction face) {
        return logic2x2 != null ? logic2x2[face.get3DDataValue()] : null;
    }

    public CTMLogic3x3 get3x3(Direction face) {
        return logic3x3 != null ? logic3x3[face.get3DDataValue()] : null;
    }

    public CTMLogic4x4 get4x4(Direction face) {
        return logic4x4 != null ? logic4x4[face.get3DDataValue()] : null;
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
                Arrays.deepEquals(logic, that.logic) &&
                Arrays.equals(logic2x2, that.logic2x2) &&
                Arrays.equals(logic3x3, that.logic3x3) &&
                Arrays.equals(logic4x4, that.logic4x4);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(variant);
        result = 31 * result + Arrays.deepHashCode(logic);
        result = 31 * result + Arrays.hashCode(logic2x2);
        result = 31 * result + Arrays.hashCode(logic3x3);
        result = 31 * result + Arrays.hashCode(logic4x4);
        return result;
    }
}