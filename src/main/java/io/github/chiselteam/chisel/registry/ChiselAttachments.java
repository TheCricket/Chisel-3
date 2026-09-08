package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.palette.PlayerPalettes;
import io.github.chiselteam.chisel.projectile.MossData;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ChiselAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Chisel.MODID);
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<MossData>> MOSS;

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<PlayerPalettes>> PALETTES = ATTACHMENTS.register("player_palettes",
            () -> AttachmentType.builder(() -> PlayerPalettes.EMPTY).serialize(PlayerPalettes.CODEC).copyOnDeath()
                    .sync((holder, recipient) -> holder == recipient, PlayerPalettes.STREAM_CODEC).build());

    static {
        MOSS = ATTACHMENTS.register("moss", () -> AttachmentType.builder(MossData::new).serialize(MossData.CODEC).build());
    }

    private ChiselAttachments() {
    }
}
