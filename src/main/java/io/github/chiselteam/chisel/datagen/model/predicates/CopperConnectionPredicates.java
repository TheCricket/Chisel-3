package io.github.chiselteam.chisel.datagen.model.predicates;

import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.ctm.api.strategy.CTMBlockPredicate;
import io.github.chiselteam.ctm.api.strategy.ResolvedBlockStateMatcher;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public final class CopperConnectionPredicates {

    private static final List<String> STAGES = List.of("copper", "exposed_copper", "weathered_copper", "oxidized_copper");

    public static CTMBlockPredicate forVariant(Variant variant) {
        String familyName = variant.getFamily().getFamilyName();
        String unwaxedFamilyName = familyName.startsWith("waxed_") ? familyName.substring(6) : familyName;
        if (!STAGES.contains(unwaxedFamilyName)) return CTMBlockPredicate.sameBlock();
        String variantName = variant.getName();
        String unwaxedVariantName = variantName.startsWith("waxed_") ? variantName.substring(6) : variantName;
        String suffix = unwaxedVariantName.substring(unwaxedFamilyName.length() + 1);
        List<CTMBlockPredicate> predicates = new ArrayList<>(STAGES.size() * 2);

        for (String stage : STAGES) {
            Block block = getCopperVariant(stage, stage + "_" + suffix);
            predicates.add(blockPredicate(block));

            Block waxedBlock = getCopperVariant(stage, "waxed_" + stage + "_" + suffix);
            predicates.add(blockPredicate(waxedBlock));
        }
        return CTMBlockPredicate.any(predicates.toArray(CTMBlockPredicate[]::new));
    }

    private static CTMBlockPredicate blockPredicate(Block block) {
        return CTMBlockPredicate.state(ResolvedBlockStateMatcher.forBlock(block).build());
    }

    private static Block getCopperVariant(String stage, String name) {
        return switch (stage) {
            case "copper" -> ChiselBlocks.COPPER.getVariant(name).get();
            case "exposed_copper" -> ChiselBlocks.EXPOSED_COPPER.getVariant(name).get();
            case "weathered_copper" -> ChiselBlocks.WEATHERED_COPPER.getVariant(name).get();
            case "oxidized_copper" -> ChiselBlocks.OXIDIZED_COPPER.getVariant(name).get();
            default -> throw new IllegalArgumentException("Unknown copper stage: " + stage);
        };
    }

    private CopperConnectionPredicates() {

    }
}
