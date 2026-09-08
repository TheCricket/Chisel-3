package io.github.chiselteam.chisel.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;

public record WeightedBlock(Identifier block, int weight, boolean enabled) {
    public static final Codec<Identifier> IDENTIFIER_CODEC = Codec.string(1, 256).comapFlatMap(Identifier::read, Identifier::toString);
    public static final Codec<WeightedBlock> CODEC = RecordCodecBuilder.create(i -> i.group(
            IDENTIFIER_CODEC.fieldOf("block").forGetter(WeightedBlock::block),
            Codec.intRange(1, 100).fieldOf("weight").forGetter(WeightedBlock::weight),
            Codec.BOOL.optionalFieldOf("enabled", true).forGetter(WeightedBlock::enabled)
    ).apply(i, WeightedBlock::new));
}
