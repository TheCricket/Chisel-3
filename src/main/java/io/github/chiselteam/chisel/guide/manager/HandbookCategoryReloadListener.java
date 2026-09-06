package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.guide.HandbookCategory;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jspecify.annotations.NonNull;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandbookCategoryReloadListener extends SimpleJsonResourceReloadListener<HandbookCategory> {

    public HandbookCategoryReloadListener() {
        super(HandbookCategory.CODEC, FileToIdConverter.json("chisel/handbook_categories"));
    }

    @Override
    protected void apply(@NonNull Map<Identifier, HandbookCategory> prepared, @NonNull ResourceManager resourceManager, @NonNull ProfilerFiller profilerFiller) {
        var validCategories = new LinkedHashMap<Identifier, HandbookCategory>();

        prepared.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getKey().toString())).forEach(entry -> {
            var id = entry.getKey();
            var category = entry.getValue();

            if (HandbookCategoryValidator.validate(id, category)) {
                validCategories.put(id, category);
            }
        });

        ServerHandbookManager.replaceCategories(validCategories);
        HandbookValidator.LOGGER.info("Loaded {} handbook category definitions", validCategories.size());
    }
}
