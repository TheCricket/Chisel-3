package chisel.core.projectile;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BallOMossData {

    public static final Codec<BallOMossData> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.either(Identifier.CODEC, TagKey.codec(Registries.BLOCK)).fieldOf("input").forGetter(BallOMossData::getInput),
            Identifier.CODEC.fieldOf("moss_block").forGetter(BallOMossData::getMossBlock)
    ).apply(i, BallOMossData::new));

    private final TagKey<Block> BASE_TAG;
    private final Identifier BASE_BLOCK;
    private final Identifier MOSS_BLOCK;

    public BallOMossData(TagKey<Block> baseTag, Identifier mossBlock) {
        this(Either.right(baseTag), mossBlock);
    }

    public BallOMossData(Identifier baseBlock, Identifier mossBlock) {
        this(Either.left(baseBlock), mossBlock);
    }

    public BallOMossData(Either<Identifier, TagKey<Block>> either, Identifier moss) {
        if(either.right().isPresent()) {
            BASE_TAG = either.right().get();
            BASE_BLOCK = null;
        } else {
            BASE_TAG = null;
            //noinspection OptionalGetWithoutIsPresent it must be present
            BASE_BLOCK = either.left().get();
        }

        MOSS_BLOCK = moss;
    }

    public Either<Identifier, TagKey<Block>> getInput() {
        if(BASE_TAG != null) return Either.right(BASE_TAG);
        return Either.left(BASE_BLOCK);
    }

    public Identifier getMossBlock() {
        return MOSS_BLOCK;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BallOMossData data = (BallOMossData) obj;
        return BASE_TAG.equals(data.BASE_TAG) && BASE_BLOCK.equals(data.BASE_BLOCK) && MOSS_BLOCK.equals(data.MOSS_BLOCK);
    }
}
