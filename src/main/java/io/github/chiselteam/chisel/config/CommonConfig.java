package io.github.chiselteam.chisel.config;

import net.neoforged.neoforge.common.ModConfigSpec.*;

public class CommonConfig {

    public static IntValue IRON_CHISEL_DURABILITY;
    public static IntValue DIAMOND_CHISEL_DURABILITY;
    public static IntValue OBSIDIAN_CHISEL_DURABILITY;

    public CommonConfig(Builder builder) {
        builder.push("general");
        IRON_CHISEL_DURABILITY = builder.defineInRange("iron_chisel_durability", 512, 0, Integer.MAX_VALUE);
        DIAMOND_CHISEL_DURABILITY = builder.defineInRange("diamond_chisel_durability", 5096, 0, Integer.MAX_VALUE);
        OBSIDIAN_CHISEL_DURABILITY = builder.defineInRange("obsidian_chisel_durability", 10_048, 0, Integer.MAX_VALUE);
        builder.pop();
    }
}
