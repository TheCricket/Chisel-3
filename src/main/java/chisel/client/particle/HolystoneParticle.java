package chisel.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class HolystoneParticle extends SingleQuadParticle {

    private static final float FADE_TIME = 20.0f;

    public HolystoneParticle(ClientLevel level, double x, double y, double z, TextureAtlasSprite sprite) {
        super(level, x, y, z, sprite);
        setLifetime(Math.max((int) (Math.random() * 10.0D) + 80, 1));
    }

    @Override
    public float getQuadSize(float partialTick) {
        return 0.75F * (float) Math.sin((age + partialTick) / 180.0f);
    }

    @Override
    public void tick() {
        super.tick();
        if (age < FADE_TIME) {
            alpha = age / FADE_TIME;
        } else if (age + FADE_TIME >= lifetime) {
            alpha = (lifetime - age) / FADE_TIME;
        } else {
            alpha = 1.0f;
        }
    }

    @Override
    protected @NonNull Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprite;

        public Provider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        @Override
        public @Nullable Particle createParticle(@NonNull SimpleParticleType type, @NonNull ClientLevel level, double x, double y, double z, double xVel, double yVel, double zVel, @NonNull RandomSource random) {
            return new HolystoneParticle(level, x, y, z, sprite.first());
        }
    }
}
