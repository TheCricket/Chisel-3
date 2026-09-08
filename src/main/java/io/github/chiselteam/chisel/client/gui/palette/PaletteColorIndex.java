package io.github.chiselteam.chisel.client.gui.palette;

import com.mojang.logging.LogUtils;
import io.github.chiselteam.chisel.client.gui.preview.PreviewGetter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3f;

import java.util.*;

public final class PaletteColorIndex {
    private final Map<TextureKey, PaletteColorProfile> textures = new HashMap<>();
    private final Map<Block, PaletteColorProfile> blocks = new IdentityHashMap<>();
    private Object modelSet;
    private int cursor;

    public boolean update(List<Block> catalog, boolean analyze) {
        Object current = Minecraft.getInstance().getModelManager().getBlockStateModelSet();
        boolean changed = current != modelSet;
        if (changed) {
            modelSet = current;
            textures.clear();
            blocks.clear();
            cursor = 0;
        }
        if (!analyze) return changed;
        long deadline = System.nanoTime() + 3_000_000;
        int count = 0;
        while (cursor < catalog.size() && count++ < 64 && System.nanoTime() < deadline) {
            Block block = catalog.get(cursor++);
            try {
                blocks.put(block, analyze(block.defaultBlockState()));
            } catch (RuntimeException error) {
                blocks.put(block, new PaletteColorProfile());
                LogUtils.getLogger().warn("Could not inspect palette colors for {}", BuiltInRegistries.BLOCK.getKey(block), error);
            }
            changed = true;
        }
        return changed;
    }

    public boolean complete(List<Block> catalog) {
        return cursor == catalog.size();
    }

    public double score(Block block, PaletteColor color) {
        var profile = blocks.get(block);
        return profile == null ? 0 : profile.share(color);
    }

    private PaletteColorProfile analyze(BlockState state) {
        var minecraft = Minecraft.getInstance();
        var model = minecraft.getModelManager().getBlockStateModelSet().get(state);
        var getter = new PreviewGetter(state, new int[][]{{0, 0, 0}});
        var parts = new ArrayList<BlockStateModelPart>();
        model.collectParts(getter, BlockPos.ZERO, state, RandomSource.create(42), parts);
        var result = new PaletteColorProfile();
        for (var part : parts) {
            for (var direction : Direction.values())
                for (var quad : part.getQuads(direction)) addQuad(result, quad, state, getter);
            for (var quad : part.getQuads(null)) addQuad(result, quad, state, getter);
        }
        if (result.isEmpty()) result.add(texture(model.particleMaterial(getter, BlockPos.ZERO, state).sprite(), -1), 1);
        return result;
    }

    private void addQuad(PaletteColorProfile result, BakedQuad quad, BlockState state, PreviewGetter getter) {
        var material = quad.materialInfo();
        int tint = -1;
        if (material.tintIndex() >= 0) {
            var source = Minecraft.getInstance().getBlockColors().getTintSource(state, material.tintIndex());
            if (source != null) tint = source.colorInWorld(state, getter, BlockPos.ZERO);
        }

        var edge1 = new Vector3f(quad.position1()).sub(quad.position0());
        var edge2 = new Vector3f(quad.position2()).sub(quad.position0());
        var edge3 = new Vector3f(quad.position3()).sub(quad.position0());
        double area = new Vector3f(edge1).cross(edge2).length() / 2.0 + new Vector3f(edge2).cross(edge3).length() / 2.0;
        result.add(texture(material.sprite(), tint), area);
    }

    private PaletteColorProfile texture(TextureAtlasSprite sprite, int tint) {
        return textures.computeIfAbsent(new TextureKey(sprite, tint), key -> {
            var result = new PaletteColorProfile();
            var contents = sprite.contents();
            if (contents.name().equals(MissingTextureAtlasSprite.getLocation())) return result;
            int samplesX = Math.min(16, contents.width()), samplesY = Math.min(16, contents.height());
            var frames = contents.getUniqueFrames();
            int frameCount = contents.isAnimated() ? Math.min(4, frames.size()) : 1;
            for (int f = 0; f < frameCount; f++) {
                int frame = contents.isAnimated() ? frames.getInt(f * frames.size() / frameCount) : 0;
                for (int y = 0; y < samplesY; y++)
                    for (int x = 0; x < samplesX; x++) {
                        int pixel = sprite.getPixelRGBA(frame, (2 * x + 1) * contents.width() / (2 * samplesX), (2 * y + 1) * contents.height() / (2 * samplesY));
                        result.addPixel(pixel, tint);
                    }
            }
            return result;
        });
    }

    private record TextureKey(TextureAtlasSprite sprite, int tint) {
    }
}
