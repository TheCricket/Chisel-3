package chisel.client.ctm;

import net.minecraft.core.Direction;
import net.neoforged.neoforge.model.data.ModelProperty;

import java.util.HashSet;
import java.util.Set;

public final class CTMData {

    public static ModelProperty<CTMData> DATA = new ModelProperty<>();
    public final Set<Direction> unculledFaces = new HashSet<>();
    public final CTMLogic[][] logic = new CTMLogic[6][4];
    public CTMData(){}
}
