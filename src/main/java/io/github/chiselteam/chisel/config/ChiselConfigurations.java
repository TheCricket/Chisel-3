package io.github.chiselteam.chisel.config;

import io.github.chiselteam.chisel.Chisel;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ChiselConfigurations {

    public static final ClientConfig CLIENT;
    public static final ModConfigSpec CLIENT_SPEC;

    public static final ServerConfig SERVER;
    public static final ModConfigSpec SERVER_SPEC;

    public static final CommonConfig COMMON;
    public static final ModConfigSpec COMMON_SPEC;

    static {
        final Pair<ClientConfig, ModConfigSpec> clientPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = clientPair.getRight();
        CLIENT = clientPair.getLeft();

        final Pair<ServerConfig, ModConfigSpec> serverPair = new ModConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPEC = serverPair.getRight();
        SERVER = serverPair.getLeft();

        final Pair<CommonConfig, ModConfigSpec> commonPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = commonPair.getRight();
        COMMON = commonPair.getLeft();
    }

    public static void init(ModContainer mod) {
        mod.registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC, "%s_client.toml".formatted(Chisel.MODID));
        mod.registerConfig(ModConfig.Type.SERVER, SERVER_SPEC, "%s_server.toml".formatted(Chisel.MODID));
        mod.registerConfig(ModConfig.Type.STARTUP, COMMON_SPEC, "%s_common.toml".formatted(Chisel.MODID));
    }
}
