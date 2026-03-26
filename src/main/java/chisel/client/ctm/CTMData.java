package chisel.client.ctm;

import net.minecraft.core.Direction;
import net.neoforged.neoforge.model.data.ModelProperty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CTMData {

    public static ModelProperty<CTMData> DATA = new ModelProperty<>();
    public final Set<Direction> unculledFaces = new HashSet<>();
    public final CTMLogic[][] logic = new CTMLogic[6][4];

    public CTMData() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                logic[i][j] = CTMLogic.NONE;
            }
        }
    }

    public CTMData(List<Direction> unculledFaces, List<CTMLogic> logic) {
        this.unculledFaces.addAll(unculledFaces);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                this.logic[i][j] = index < logic.size() ? logic.get(index) : CTMLogic.NONE;
            }
        }
    }
}
