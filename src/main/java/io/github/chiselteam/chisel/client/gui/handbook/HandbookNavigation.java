package io.github.chiselteam.chisel.client.gui.handbook;

import io.github.chiselteam.chisel.guide.HandbookEntry;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.HandbookView;
import io.github.chiselteam.chisel.guide.Snapshot;
import io.github.chiselteam.chisel.guide.page.HandbookSpread;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.function.Function;

import static io.github.chiselteam.chisel.client.gui.handbook.HandbookLayout.ENTRIES_PER_LIST_PAGE;

public final class HandbookNavigation {
    private Snapshot snapshot = Snapshot.EMPTY;
    private HandbookView view = HandbookView.COVER;
    private Identifier selectedCategory;
    private HandbookEntry selectedGuide;
    private List<HandbookEntry> categoryGuides = List.of();
    private List<HandbookSpread> spreads = List.of();
    private int contentsPage;
    private int categoryPage;
    private int spreadIndex;

    private static Entry allGuides() {
        return new Entry(Component.translatable("chisel.builders_handbook.all_guides"),
                Component.translatable("chisel.builders_handbook.all_guides.description"), Identifier.withDefaultNamespace("bookshelf"));
    }

    private static int pageCount(int count) {
        return Math.max(1, (count + ENTRIES_PER_LIST_PAGE - 1) / ENTRIES_PER_LIST_PAGE);
    }

    public void refresh(Snapshot newSnapshot, Function<HandbookGuide, List<HandbookSpread>> paginate) {
        snapshot = newSnapshot;
        contentsPage = Math.clamp(contentsPage, 0, pageCount(snapshot.categoryEntries().size() + 1) - 1);
        if (selectedCategory != null && (!snapshot.categories().containsKey(selectedCategory) || snapshot.categoryIndex().getOrDefault(selectedCategory, List.of()).isEmpty())) {
            selectedCategory = null;
            categoryPage = 0;
            clearGuide();
            if (view != HandbookView.COVER) view = HandbookView.CONTENTS;
        }
        categoryGuides = selectedCategory == null ? snapshot.entries() : snapshot.categoryIndex().getOrDefault(selectedCategory, List.of());
        categoryPage = Math.clamp(categoryPage, 0, pageCount(categoryGuides.size()) - 1);
        if (view != HandbookView.GUIDE) return;
        var guideId = selectedGuide.id();
        selectedGuide = categoryGuides.stream().filter(entry -> entry.id().equals(guideId)).findFirst().orElse(null);
        if (selectedGuide == null) {
            clearGuide();
            view = HandbookView.CATEGORY;
        } else {
            spreads = List.copyOf(paginate.apply(selectedGuide.guide()));
            spreadIndex = Math.clamp(spreadIndex, 0, Math.max(0, spreads.size() - 1));
        }
    }

    public void open() {
        view = HandbookView.CONTENTS;
    }

    public void selectRow(int row, Function<HandbookGuide, List<HandbookSpread>> paginate) {
        if (!isList() || row < 0 || row >= visibleCount()) return;
        int index = firstVisibleIndex() + row;
        if (view == HandbookView.CONTENTS) {
            selectedCategory = index == 0 ? null : snapshot.categoryEntries().get(index - 1).id();
            categoryGuides = selectedCategory == null ? snapshot.entries() : snapshot.categoryIndex().get(selectedCategory);
            clearGuide();
            categoryPage = 0;
            view = HandbookView.CATEGORY;
        } else {
            selectedGuide = categoryGuides.get(index);
            spreads = List.copyOf(paginate.apply(selectedGuide.guide()));
            spreadIndex = 0;
            view = HandbookView.GUIDE;
        }
    }

    public boolean canPrevious() {
        return view == HandbookView.GUIDE || view == HandbookView.CATEGORY || (view == HandbookView.CONTENTS && contentsPage > 0);
    }

    public boolean canNext() {
        return switch (view) {
            case COVER -> false;
            case CONTENTS, CATEGORY -> listPage() < pageCount(entryCount()) - 1;
            case GUIDE -> spreadIndex < spreads.size() - 1;
        };
    }

    public void previous() {
        if (!canPrevious()) return;
        switch (view) {
            case CONTENTS -> contentsPage--;
            case CATEGORY -> {
                if (categoryPage > 0) categoryPage--;
                else {
                    selectedCategory = null;
                    clearGuide();
                    view = HandbookView.CONTENTS;
                }
            }
            case GUIDE -> {
                if (spreadIndex > 0) spreadIndex--;
                else {
                    clearGuide();
                    view = HandbookView.CATEGORY;
                }
            }
        }
    }

    public void next() {
        if (!canNext()) return;
        switch (view) {
            case CONTENTS -> contentsPage++;
            case CATEGORY -> categoryPage++;
            case GUIDE -> spreadIndex++;
            case COVER -> {
            }
        }
    }

    private void clearGuide() {
        selectedGuide = null;
        spreads = List.of();
        spreadIndex = 0;
    }

    public Entry entry(int row) {
        int index = firstVisibleIndex() + row;
        if (view == HandbookView.CONTENTS) {
            if (index == 0) return allGuides();
            var category = snapshot.categoryEntries().get(index - 1).category();
            return new Entry(category.title(), category.description(), category.icon());
        }
        var guide = categoryGuides.get(index).guide();
        return new Entry(guide.title(), guide.description(), guide.icon());
    }

    public Entry introduction() {
        if (view == HandbookView.CONTENTS) return new Entry(
                Component.translatable("chisel.builders_handbook.title"), Component.translatable("chisel.builders_handbook.intro"),
                Identifier.withDefaultNamespace("bookshelf"));
        if (selectedCategory == null) return allGuides();
        var category = snapshot.categories().get(selectedCategory);
        return new Entry(category.title(), category.description(), category.icon());
    }

    private int entryCount() {
        return view == HandbookView.CONTENTS ? snapshot.categoryEntries().size() + 1 : categoryGuides.size();
    }

    private int listPage() {
        return view == HandbookView.CONTENTS ? contentsPage : categoryPage;
    }

    private int firstVisibleIndex() {
        return listPage() * ENTRIES_PER_LIST_PAGE;
    }

    public int visibleCount() {
        return isList() ? Math.min(ENTRIES_PER_LIST_PAGE, entryCount() - firstVisibleIndex()) : 0;
    }

    public boolean isList() {
        return view == HandbookView.CONTENTS || view == HandbookView.CATEGORY;
    }

    public HandbookView view() {
        return view;
    }

    public List<HandbookSpread> spreads() {
        return spreads;
    }

    public int spreadIndex() {
        return spreadIndex;
    }

    public long revision() {
        return snapshot.revision();
    }

    public record Entry(Component title, Component description, Identifier icon) {
    }
}
