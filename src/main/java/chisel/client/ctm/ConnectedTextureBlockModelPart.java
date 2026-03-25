package chisel.client.ctm;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import chisel.core.Variant;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.model.data.ModelData;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedTextureBlockModelPart implements BlockStateModelPart {

    private final ModelData modelData;
    private final Set<Direction> connectedFaces;
    private final Set<Direction> unculledFaces;
    private final Map<Direction, BakedQuad[]> baseQuads;
    private final Map<Direction, BakedQuad[][]> connectedQuads;
    private final boolean renderOverlayOnAllFaces;
    private final boolean useAmbientOcclusion;
    private final Material.Baked particleMaterial;

    public ConnectedTextureBlockModelPart(ModelData data, Set<Direction> connectedFaces, Set<Direction> unculledFaces, Map<Direction, BakedQuad[]> baseQuads, Map<Direction, BakedQuad[][]> connectedQuads, boolean renderOverlayOnAllFaces, boolean useAmbientOcclusion, TextureAtlasSprite particle) {
        modelData = data;
        this.connectedFaces = connectedFaces;
        this.unculledFaces = unculledFaces;
        this.baseQuads = baseQuads;
        this.connectedQuads = connectedQuads;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.useAmbientOcclusion = useAmbientOcclusion;
        particleMaterial = new Material.Baked(particle, false);
    }

    @Override
    public @NonNull List<BakedQuad> getQuads(@Nullable Direction side) {
        if (side == null) {
            List<BakedQuad> quadList = new ArrayList<>();
            for (Direction direction : unculledFaces) quadList.addAll(getQuadsForFace(direction));
            return quadList;
        } else return getQuadsForFace(side);
    }

    public List<BakedQuad> getQuadsForFace(Direction side) {
        BakedQuad[] baseQuads = this.baseQuads.get(side);
        CTMData data = modelData.get(CTMData.DATA);
        ArrayList<BakedQuad> quads = new ArrayList<>(4 + (baseQuads != null ? 4 : 0));
        if (baseQuads != null) quads.addAll(List.of(baseQuads));

        if (connectedFaces.contains(side) || this.renderOverlayOnAllFaces) {
            for (int quad = 0; quad < 4; ++quad) {
                //if our model data is null (happens for items), we can skip connected textures since we dont have the info we need
                CTMLogic connectionType = data != null && this.connectedFaces.contains(side) ? data.logic[side.get3DDataValue()][quad] : CTMLogic.NONE;
                if (connectionType == null) connectionType = CTMLogic.NONE;
                BakedQuad[][] faceQuads = connectedQuads.get(side);
                if (faceQuads != null && faceQuads[quad] != null) {
                    quads.add(faceQuads[quad][connectionType.ordinal()]);
                }
            }
        }

        return quads;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return useAmbientOcclusion;
    }

    @Override
    public Material.@NonNull Baked particleMaterial() {
        return particleMaterial;
    }

    @Override
    public @BakedQuad.MaterialFlags int materialFlags() {
        return 0;
    }

    public record Unbaked(
            Identifier modelLocation,
            Pair<Vector3f, Vector3f> element,
            Set<Direction> connectedFaces,
            boolean renderOverlayOnAllFaces,
            Variant variant,
            int baseTintIndex,
            int baseEmissivity,
            int tintIndex,
            int emissivity
    ) implements BlockStateModelPart.Unbaked {

        private static final Codec<Vector3f> VECTOR3F_CODEC = Codec.FLOAT.listOf().comapFlatMap(
                list -> list.size() == 3 ? DataResult.success(new Vector3f(list.get(0), list.get(1), list.get(2))) : DataResult.error(() -> "Vector3f must have 3 components"),
                vec -> List.of(vec.x(), vec.y(), vec.z())
        );

        private static final MapCodec<Pair<Vector3f, Vector3f>> ELEMENT_CODEC = RecordCodecBuilder.mapCodec(j -> j.group(
                VECTOR3F_CODEC.fieldOf("min").forGetter(Pair::getFirst),
                VECTOR3F_CODEC.fieldOf("max").forGetter(Pair::getSecond)
        ).apply(j, Pair::of));

        public static final MapCodec<Unbaked> CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                        Identifier.CODEC.fieldOf("model_location").forGetter(Unbaked::modelLocation),
                        ELEMENT_CODEC.fieldOf("element").forGetter(Unbaked::element),
                        Direction.CODEC.listOf().fieldOf("connected_faces").forGetter(m -> m.connectedFaces().stream().toList()),
                        Codec.BOOL.optionalFieldOf("render_overlay_on_all_faces", false).forGetter(Unbaked::renderOverlayOnAllFaces),
                        Variant.CODEC.fieldOf("variant").forGetter(Unbaked::variant),
                        Codec.INT.optionalFieldOf("base_tint_index", -1).forGetter(Unbaked::baseTintIndex),
                        Codec.INT.optionalFieldOf("base_emissivity", 0).forGetter(Unbaked::baseEmissivity),
                        Codec.INT.optionalFieldOf("tint_index", -1).forGetter(Unbaked::tintIndex),
                        Codec.INT.optionalFieldOf("emissivity", 0).forGetter(Unbaked::emissivity)
                ).apply(instance, (Identifier modelLocation, Pair<Vector3f, Vector3f> element, List<Direction> connectedFaces, Boolean renderOverlayOnAllFaces, Variant variant, Integer baseTintIndex, Integer baseEmissivity, Integer tintIndex, Integer emissivity) ->
                        new Unbaked(modelLocation, element, Set.copyOf(connectedFaces), renderOverlayOnAllFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity))
        );

        @Override
        public BlockStateModelPart bake(ModelBaker modelBaker) {
            return null;
        }

        @Override
        public void resolveDependencies(Resolver resolver) {
            resolver.markDependency(modelLocation);
        }
    }
}
