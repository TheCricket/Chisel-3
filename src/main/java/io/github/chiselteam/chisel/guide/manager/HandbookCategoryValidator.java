package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.guide.HandbookCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;

public class HandbookCategoryValidator {
    private HandbookCategoryValidator() {
    }

    public static boolean validate(Identifier id, HandbookCategory category) {
        var errors = new ArrayList<String>();
        var warnings = new ArrayList<String>();

        validateMetadata(category, errors, warnings);

        if (!warnings.isEmpty()) {
            HandbookValidator.LOGGER.warn(
                    "Handbook category '{}' loaded with warnings:{}",
                    id,
                    formatProblems(warnings)
            );
        }

        if (!errors.isEmpty()) {
            HandbookValidator.LOGGER.error(
                    "Rejected handbook category '{}':{}",
                    id,
                    formatProblems(errors)
            );

            return false;
        }

        return true;
    }

    private static void validateMetadata(
            HandbookCategory category,
            List<String> errors,
            List<String> warnings
    ) {
        if (category.title().getString().isBlank()) {
            errors.add("Category title must not be empty");
        }

        if (category.description().getString().isBlank()) {
            warnings.add("Category description is empty");
        }

        if (category.sortOrder() < 0) {
            errors.add(
                    "Category sort order is %d; expected zero or greater"
                            .formatted(category.sortOrder())
            );
        }

        if (!BuiltInRegistries.ITEM.containsKey(category.icon())) {
            warnings.add(
                    "Category icon references an unknown item: %s"
                            .formatted(category.icon())
            );
        }
    }

    private static String formatProblems(List<String> problems) {
        return "\n - " + String.join("\n - ", problems);
    }
}
