package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CreatorFamily extends ChiselFamily {
    public CreatorFamily(BlockBehaviour.Properties props) {
        family = builder("creator")
                .addVariant("youtube", props)
                .addVariant("twitch", props)
                .addVariant("discord", props)
                .addVariant("bucket_block", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("youtube"), "Youtube", "Youtube");
        lang.addBlock(getVariant("twitch"), "Twitch", "Twitch");
        lang.addBlock(getVariant("discord"), "Discord", "Discord");
        lang.addBlock(getVariant("bucket_block"), "Bucketst", "Bucketst");
    }
}

