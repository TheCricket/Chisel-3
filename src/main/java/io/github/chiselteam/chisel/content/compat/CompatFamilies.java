package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.content.ChiselFamily;

import java.util.List;

public class CompatFamilies {

    private static final List<CompatModule> MODULES = List.of(
            new CompatModule("aether_ii", AetherIIFamilies.families()),
            new CompatModule("allthemodium", AllTheModsFamilies.families()),
            new CompatModule("ae2", AppliedEnergisticsFamilies.families()),
            new CompatModule("forbidden_arcanus", ForbiddenArcanusFamilies.families()),
            new CompatModule("mysticalagriculture", MysticalAgricultureFamilies.families()),
            new CompatModule("neovitae", NeoVitaeFamilies.families()),
            new CompatModule("occultism", OccultismFamilies.families())
    );

    private CompatFamilies() {
    }

    public static List<ChiselFamily> families() {
        return MODULES.stream().flatMap(module -> module.families().stream()).toList();
    }

    public static List<CompatModule> modules() {
        return MODULES;
    }
}
