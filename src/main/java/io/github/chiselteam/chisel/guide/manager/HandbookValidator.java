package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.section.PaletteSection;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class HandbookValidator {
    public static final Logger LOGGER = LoggerFactory.getLogger("%s/Handbook".formatted(Chisel.MODID));

    private HandbookValidator() {
    }

    public static boolean validate(Identifier id, HandbookGuide guide) {
        var errors = new ArrayList<String>();
        var warnings = new ArrayList<String>();

        validateGuideMetadata(guide, errors, warnings);
        validateSections(guide, errors, warnings);

        if (!warnings.isEmpty()) {
            LOGGER.warn("Handbook guide '{}' loaded with warnings:{}", id, formatProblems(warnings));
        }

        if (!errors.isEmpty()) {
            LOGGER.error("Rejected handbook guide '{}':{}", id, formatProblems(errors));
            return false;
        }

        return true;
    }

    private static void validateGuideMetadata(HandbookGuide guide, List<String> errors, List<String> warnings) {
        if (isBlank(guide.title())) errors.add("Guide title must not be empty");
        if (isBlank(guide.description())) warnings.add("Guide description is empty");
        if (guide.sections().isEmpty()) errors.add("Guide has no sections");
        if (!BuiltInRegistries.ITEM.containsKey(guide.icon())) {
            warnings.add("Guide icon references an unknown item: %s".formatted(guide.icon()));
        }

        validateCategories(guide, warnings);
    }

    private static void validateCategories(HandbookGuide guide, List<String> warnings) {
        var encounteredCategories = new HashSet<>();

        for (int categoryIndex = 0; categoryIndex < guide.categories().size(); categoryIndex++) {
            var category = guide.categories().get(categoryIndex);

            if (!encounteredCategories.add(category)) {
                warnings.add("Category '%s' is listed more than once".formatted(category));
            }
        }
    }

    private static void validateSections(HandbookGuide guide, List<String> errors, List<String> warnings) {
        for (int sectionIndex = 0; sectionIndex < guide.sections().size(); sectionIndex++) {
            var section = guide.sections().get(sectionIndex);

            if (section instanceof PaletteSection palette) {
                validatePaletteSection(sectionIndex, palette, errors, warnings);
            }
        }
    }

    private static void validatePaletteSection(int sectionIndex, PaletteSection palette, List<String> errors, List<String> warnings) {
        if (isBlank(palette.title())) {
            errors.add("Palette section %d has an empty title".formatted(sectionIndex));
        }

        if (palette.entries().isEmpty()) {
            errors.add("Palette section %d has no entries".formatted(sectionIndex));
            return;
        }

        var encounteredBlocks = new HashSet<>();

        for (int entryIndex = 0; entryIndex < palette.entries().size(); entryIndex++) {
            var entry = palette.entries().get(entryIndex);
            var location = "Palette section %d, entry %d".formatted(sectionIndex, entryIndex);

            if (entry.weight() < 1 || entry.weight() > 100) {
                errors.add("%s has weight %d; expected a value from 1-100".formatted(location, entry.weight()));
            }

            if (!BuiltInRegistries.BLOCK.containsKey(entry.block())) {
                warnings.add("%s references an unknown block: %s".formatted(location, entry.block()));
            }

            if (!encounteredBlocks.add(entry.block())) {
                warnings.add("%s repeats block %s".formatted(location, entry.block()));
            }
        }
    }

    private static boolean isBlank(Component component) {
        return component.getString().isBlank();
    }

    private static String formatProblems(List<String> problems) {
        return "\n - " + String.join("\n - ", problems);
    }
}
