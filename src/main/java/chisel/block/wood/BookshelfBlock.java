package chisel.block.wood;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BookshelfBlock extends ChiselBlock {
    public BookshelfBlock(BlockBehaviour.Properties props) {
        

        family = builder("bookshelf")
                .addVariant(Blocks.BOOKSHELF)
                .addVariant("bookshelf_abandoned", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_brim", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_cans", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_historian", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_hoarder", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_necromancer", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_necromancer_apprentice", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_papers", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_rainbow", props, VariantModelType.BOOKSHELF)
                .addVariant("bookshelf_tomes", props, VariantModelType.BOOKSHELF)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bookshelf_abandoned"), "Bookshelf", "Abandoned");
        lang.addBlock(getVariant("bookshelf_brim"), "Bookshelf", "Brim");
        lang.addBlock(getVariant("bookshelf_cans"), "Bookshelf", "Cans");
        lang.addBlock(getVariant("bookshelf_historian"), "Bookshelf", "Historian");
        lang.addBlock(getVariant("bookshelf_hoarder"), "Bookshelf", "Hoarder");
        lang.addBlock(getVariant("bookshelf_necromancer"), "Bookshelf", "Necromancer");
        lang.addBlock(getVariant("bookshelf_necromancer_apprentice"), "Bookshelf", "Necromancer Apprentice");
        lang.addBlock(getVariant("bookshelf_papers"), "Bookshelf", "Papers");
        lang.addBlock(getVariant("bookshelf_rainbow"), "Bookshelf", "Rainbow");
        lang.addBlock(getVariant("bookshelf_tomes"), "Bookshelf", "Tomes");
    }
}

