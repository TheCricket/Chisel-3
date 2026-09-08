package io.github.chiselteam.chisel.client.gui.palette;

import io.github.chiselteam.chisel.palette.PaletteDefinition;
import io.github.chiselteam.chisel.palette.WeightedBlock;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public final class PaletteWall {
    public static final int COLUMNS = 8;
    public static final int ROWS = 5;

    private PaletteWall() {
    }

    public static List<Identifier> sample(PaletteDefinition palette, long seed, Predicate<Identifier> available) {
        var entries = palette.entries().stream().filter(e -> e.enabled() && available.test(e.block())).toList();
        int total = entries.stream().mapToInt(WeightedBlock::weight).sum();
        if (total == 0) return List.of();
        var random = new Random(seed);
        var result = new ArrayList<Identifier>();
        for (int cell = 0; cell < COLUMNS * ROWS; cell++) {
            int choice = (int) (random.nextDouble() * total);
            for (var entry : entries) {
                choice -= entry.weight();
                if (choice < 0) {
                    result.add(entry.block());
                    break;
                }
            }
        }
        return List.copyOf(result);
    }
}
