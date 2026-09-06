package io.github.chiselteam.chisel.guide.manager;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.jspecify.annotations.NonNull;

public final class HandbookReferenceReloadListener implements ResourceManagerReloadListener {
    @Override
    public void onResourceManagerReload(@NonNull ResourceManager manager) {
        var categories = ServerHandbookManager.getCategories();
        ServerHandbookManager.getGuides().forEach((id, guide) ->
                guide.categories().stream().distinct().filter(category -> !categories.containsKey(category))
                        .forEach(category -> HandbookValidator.LOGGER.warn("Handbook guide '{}' references unknown category '{}'; available through All Guides", id, category)));
    }
}
