package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantFamily;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BookshelfFamily extends ChiselBlock {

    private final String[] woods = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"};
    private final String[] woodNames = {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "Dark Oak", "Mangrove", "Cherry", "Pale Oak", "Bamboo", "Crimson", "Warped"};
    private final String[] types = {"abandoned", "brim", "cans", "historian", "hoarder", "necromancer", "necromancer_apprentice", "papers", "rainbow", "tomes"};
    private final String[] typeNames = {"Abandoned", "Brim", "Cans", "Historian", "Hoarder", "Necromancer", "Necromancer Apprentice", "Papers", "Rainbow", "Tomes"};

    public BookshelfFamily(BlockBehaviour.Properties props) {
        VariantFamily.Builder b = this.builder("bookshelf");
        b.addVariant(Blocks.BOOKSHELF);
        for (String wood : woods) {
            for (String type : types) {
                b.addVariant("bookshelf_%s_%s".formatted(wood, type), props, VariantModelType.BOOKSHELF);
            }
        }

        family = b.family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int c = 0; c < woods.length; c++) {
            for (int d = 0; d < types.length; d++) {
                lang.addBlock(getVariant("bookshelf_" + woods[c] + "_" + types[d]), woodNames[c] + " Bookshelf", typeNames[d]);
            }
        }
    }
}

