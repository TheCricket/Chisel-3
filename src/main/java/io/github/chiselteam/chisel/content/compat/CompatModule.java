package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.content.ChiselFamily;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public record CompatModule(String modId, List<ChiselFamily> families) {
}
