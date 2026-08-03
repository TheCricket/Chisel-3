package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.BOOKSHELF;

public class BookshelfFamily extends ChiselFamily {

    private final String[] woods = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"};
    private final String[] woodNames = {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "Dark Oak", "Mangrove", "Cherry", "Pale Oak", "Bamboo", "Crimson", "Warped"};
    private final String[] types = {"abandoned", "brim", "cans", "historian", "hoarder", "necromancer", "necromancer_apprentice", "papers", "rainbow", "tomes"};
    private final String[] typeNames = {"Abandoned", "Brim", "Cans", "Historian", "Hoarder", "Necromancer", "Necromancer Apprentice", "Papers", "Rainbow", "Tomes"};

    public BookshelfFamily(BlockBehaviour.Properties props) {
        VariantFamily.Builder b = this.builder("bookshelf");
        b.addVariant(Blocks.BOOKSHELF);
        for (String wood : woods) {
            for (String type : types) {
                b.addVariant("bookshelf_%s_%s".formatted(wood, type), props, BOOKSHELF);
            }
        }

        family = b.family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int c = 0; c < woods.length; c++) {
            for (int d = 0; d < types.length; d++) {
                String desc = typeNames[d];
                switch (types[d]) {
                    case "abandoned" -> desc = "Abandoned Bookshelf";
                    case "brim" -> desc = "Bookshelf filled to the brim with boring Pastel Books";
                    case "historian" -> desc = "Historian's Bookshelf";
                    case "hoarder" -> desc = "Hoarder's Bookshelf";
                    case "necromancer" -> desc = "Necromancer's Bookshelf";
                    case "necromancer_apprentice" -> desc = "Necromancer’s Apprentice Bookshelf";
                    case "rainbow" -> desc = "Bookshelf with Rainbow Books";
                    case "tomes" -> desc = "Bookshelf with Red Tomes";
                }
                lang.addBlock(getVariant("bookshelf_%s_%s".formatted(woods[c], types[d])), "%s Bookshelf".formatted(woodNames[c]), desc);
            }
        }
    }
}

