package chisel.client.ctm;

import chisel.Chisel;
import chisel.core.Variant;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import org.joml.Vector3f;
import org.jspecify.annotations.NonNull;

import java.util.*;

public record UnbakedConnectedTextureBlockStateModel(UnbakedConnectedTextureBlockModelPart unbakedPart) implements CustomUnbakedBlockStateModel {

    public static final Identifier ID = Chisel.prefix("connected_texture_model");

    public static final MapCodec<UnbakedConnectedTextureBlockStateModel> CODEC = UnbakedConnectedTextureBlockModelPart.CODEC.xmap(UnbakedConnectedTextureBlockStateModel::new, UnbakedConnectedTextureBlockStateModel::unbakedPart);

    public UnbakedConnectedTextureBlockStateModel(Identifier modelLocation, Pair<Vector3f, Vector3f> element, Set<Direction> connectedFaces, boolean renderOnDisabledFaces, Variant variant, int baseTintIndex, int baseEmissivity, int tintIndex, int emissivity) {
        this(new UnbakedConnectedTextureBlockModelPart(modelLocation, element, connectedFaces, renderOnDisabledFaces, variant, baseTintIndex, baseEmissivity, tintIndex, emissivity));
    }

    @Override
    public @NonNull MapCodec<? extends CustomUnbakedBlockStateModel> codec() {
        return CODEC;
    }

    @Override
    public @NonNull BlockStateModel bake(@NonNull ModelBaker baker) {
        ConnectedTextureBlockModelPart bakedPart = (ConnectedTextureBlockModelPart) unbakedPart.bake(baker);
        return new ConnectedTextureBlockStateModel(
                bakedPart.connectedFaces(),
                bakedPart.unculledFaces(),
                bakedPart.renderOverlayOnAllFaces(),
                bakedPart.baseQuads(),
                bakedPart.connectedQuads(),
                bakedPart.particleMaterial().sprite(),
                unbakedPart.variant()
        );
    }

    @Override
    public void resolveDependencies(@NonNull Resolver resolver) {
        unbakedPart.resolveDependencies(resolver);
    }

    public Variant getVariant() {
        return unbakedPart.variant();
    }
}
