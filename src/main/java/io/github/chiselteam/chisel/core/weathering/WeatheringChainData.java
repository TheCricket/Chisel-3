package io.github.chiselteam.chisel.core.weathering;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/// Datapack entry describing a single weathering chain.
/// - `blocks`: ordered list of block identifiers from youngest to oldest
/// - `aging_rate`: chance `[0..1]` per random tick to advance one stage (defaults to `0.25`)
/// - `waxed_map`: map of unwaxed block identifiers to waxed block identifiers
/// Example JSON:
/// ```json
/// {
///   "blocks": [
///     "yourmod:stone_clean",
///     "yourmod:stone_worn",
///     "yourmod:stone_weathered"
///   ],
///   "aging_rate": 0.25,
///   "waxed_map": {
///     "yourmod:stone_clean": "yourmod:waxed_stone_clean",
///     "yourmod:stone_worn": "yourmod:waxed_stone_worn",
///     "yourmod:stone_weathered": "yourmod:waxed_stone_weathered"
///   }
/// }
/// ```
public record WeatheringChainData(List<Identifier> blocks, float agingRate, Map<Identifier, Identifier> waxedMap) {

    /// Codec for serializing/deserializing `WeatheringChainData` from datapack JSON.
    /// Fields:
    /// - `blocks` (array of `string`): block ids in order from youngest to oldest
    /// - `aging_rate` (number, optional): chance per random tick; defaults to `0.25`
    /// - `waxed_map` (map of `string` to `string`, optional): unwaxed to waxed mapping
    public static final Codec<WeatheringChainData> CODEC = RecordCodecBuilder.create(i -> i.group(
            Identifier.CODEC.listOf().fieldOf("blocks").forGetter(WeatheringChainData::blocks),
            Codec.FLOAT.optionalFieldOf("aging_rate", 0.25f).forGetter(WeatheringChainData::agingRate),
            Codec.unboundedMap(Identifier.CODEC, Identifier.CODEC).optionalFieldOf("waxed_map", Collections.emptyMap()).forGetter(WeatheringChainData::waxedMap)
    ).apply(i, WeatheringChainData::new));
}
