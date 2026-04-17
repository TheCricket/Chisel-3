package chisel.client.ctm;

import chisel.Chisel;
import chisel.client.ctm.unbaked.DirectionalUnbakedCTMModel;
import chisel.client.ctm.unbaked.MultiblockUnbakedCTMModel;
import chisel.client.ctm.unbaked.StandardUnbakedCTMModel;
import chisel.client.ctm.unbaked.TBSUnbakedCTMModel;
import chisel.core.variant.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Set;

public class UnbakedConnectedTextureBlockStateModel extends AbstractUnbakedConnectedTextureBlockStateModel {

    public static final Identifier ID = Chisel.prefix("connected_texture_model");

    public UnbakedConnectedTextureBlockStateModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOverlayOnAllFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        super(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
    }

    private static final Codec<Vector3f> VECTOR3F_CODEC = Codec.FLOAT.listOf().comapFlatMap(
            list -> list.size() == 3 ? DataResult.success(new Vector3f(list.get(0), list.get(1), list.get(2))) : DataResult.error(() -> "Vector3f must have 3 components"),
            vec -> List.of(vec.x(), vec.y(), vec.z())
    );

    private static final MapCodec<Pair<Vector3f, Vector3f>> ELEMENT_CODEC = RecordCodecBuilder.mapCodec(j -> j.group(
            VECTOR3F_CODEC.fieldOf("min").forGetter(Pair::getFirst),
            VECTOR3F_CODEC.fieldOf("max").forGetter(Pair::getSecond)
    ).apply(j, Pair::of));

    public static final MapCodec<UnbakedConnectedTextureBlockStateModel> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Identifier.CODEC.fieldOf("model_location").forGetter(m -> m.modelLocation),
                    ELEMENT_CODEC.fieldOf("element").forGetter(m -> m.element),
                    Direction.CODEC.listOf().fieldOf("connected_faces").forGetter(m -> m.connectedFaces.stream().toList().stream().sorted().toList()),
                    Codec.BOOL.optionalFieldOf("render_overlay_on_all_faces", false).forGetter(m -> m.renderOverlayOnAllFaces),
                    Variant.CODEC.fieldOf("variant").forGetter(m -> m.variant),
                    Codec.INT.optionalFieldOf("base_tint_index", -1).forGetter(m -> m.baseTintIndex),
                    Codec.INT.optionalFieldOf("base_emissivity", 0).forGetter(m -> m.baseEmissivity),
                    Codec.INT.optionalFieldOf("tint_index", -1).forGetter(m -> m.tintIndex),
                    Codec.INT.optionalFieldOf("emissivity", 0).forGetter(m -> m.emissivity)
            ).apply(instance, (Identifier modelLocation, Pair<Vector3f, Vector3f> element, List<Direction> connectedFaces, Boolean renderOverlayOnAllFaces, Variant variant, Integer baseTintIndex, Integer baseEmissivity, Integer tintIndex, Integer emissivity) ->
                    new UnbakedConnectedTextureBlockStateModel(modelLocation, element, Set.copyOf(connectedFaces), renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity))
    );

    @Override
    public @NonNull MapCodec<? extends CustomUnbakedBlockStateModel> codec() {
        return CODEC;
    }

    @Override
    public @NonNull BlockStateModel bake(@NonNull ModelBaker baker) {
        AbstractUnbakedConnectedTextureBlockStateModel specialized = switch (variant.getModelType()) {
            case MULTIBLOCK_2X2, MULTIBLOCK_3X3, MULTIBLOCK_4X4, V4, MULTI_LAYER_WATER_2X2, MULTI_LAYER_WATER_3X3, MULTI_LAYER_WATER_4X4 ->
                    new MultiblockUnbakedCTMModel(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
            case CTMH, CTMV, BOOKSHELF ->
                    new DirectionalUnbakedCTMModel(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
            case CONNECTED_TBS ->
                    new TBSUnbakedCTMModel(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
            default ->
                    new StandardUnbakedCTMModel(modelLocation, element, connectedFaces, renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity);
        };
        return specialized.bake(baker);
    }
}
