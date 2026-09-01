package io.github.chiselteam.chisel.content.family;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.block.*;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.List;

public class SpecialFamilies {
    public static final ChiselFamily ANTIBLOCK, BOOKSHELF, GLASS, GLASS_PANE, IRON_BARS, JACK_O_LANTERN, PUMPKIN, REDSTONE_LAMP, ROAD_LINE, TORCH;
    private static final List<ChiselFamily> FAMILIES;

    static {
        ANTIBLOCK = ChiselFamily.build("antiblock", builder -> builder
                .properties(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.0F, 5.0F).requiresCorrectToolForDrops().lightLevel((_) -> 15))
                .addVariant("antiblock_black", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_black", "Antiblock", "Black Anti Block")
                .addVariant("antiblock_blue", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_blue", "Antiblock", "Blue Anti Block")
                .addVariant("antiblock_brown", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_brown", "Antiblock", "Brown Anti Block")
                .addVariant("antiblock_cyan", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_cyan", "Antiblock", "Cyan Anti Block")
                .addVariant("antiblock_gray", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_gray", "Antiblock", "Gray Anti Block")
                .addVariant("antiblock_green", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_green", "Antiblock", "Green Anti Block")
                .addVariant("antiblock_light_blue", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_light_blue", "Antiblock", "Light Blue Anti Block")
                .addVariant("antiblock_light_gray", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_light_gray", "Antiblock", "Light Gray Anti Block")
                .addVariant("antiblock_lime", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_lime", "Antiblock", "Lime Anti Block")
                .addVariant("antiblock_magenta", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_magenta", "Antiblock", "Magenta Anti Block")
                .addVariant("antiblock_orange", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_orange", "Antiblock", "Orange Anti Block")
                .addVariant("antiblock_pink", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_pink", "Antiblock", "Pink Anti Block")
                .addVariant("antiblock_purple", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_purple", "Antiblock", "Purple Anti Block")
                .addVariant("antiblock_red", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_red", "Antiblock", "Red Anti Block")
                .addVariant("antiblock_white", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_white", "Antiblock", "White Anti Block")
                .addVariant("antiblock_yellow", ChiselModelHandlers.ANTIBLOCK).translation("antiblock_yellow", "Antiblock", "Yellow Anti Block")
                // .addVariant("antiblock_black_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_blue_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_brown_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_cyan_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_gray_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_green_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_light_blue_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_light_gray_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_lime_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_magenta_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_orange_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_pink_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_purple_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_red_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_white_borderless", ChiselModelHandlers.SHADELESS)
                // .addVariant("antiblock_yellow_borderless", ChiselModelHandlers.SHADELESS)
                .addVariant("antiblock_black_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_black_dull", "Antiblock", "Black Dull Anti Block")
                .addVariant("antiblock_blue_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_blue_dull", "Antiblock", "Blue Dull Anti Block")
                .addVariant("antiblock_brown_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_brown_dull", "Antiblock", "Brown Dull Anti Block")
                .addVariant("antiblock_cyan_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_cyan_dull", "Antiblock", "Cyan Dull Anti Block")
                .addVariant("antiblock_gray_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_gray_dull", "Antiblock", "Gray Dull Anti Block")
                .addVariant("antiblock_green_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_green_dull", "Antiblock", "Green Dull Anti Block")
                .addVariant("antiblock_light_blue_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_light_blue_dull", "Antiblock", "Light Blue Dull Anti Block")
                .addVariant("antiblock_light_gray_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_light_gray_dull", "Antiblock", "Light Gray Dull Anti Block")
                .addVariant("antiblock_lime_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_lime_dull", "Antiblock", "Lime Dull Anti Block")
                .addVariant("antiblock_magenta_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_magenta_dull", "Antiblock", "Magenta Dull Anti Block")
                .addVariant("antiblock_orange_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_orange_dull", "Antiblock", "Orange Dull Anti Block")
                .addVariant("antiblock_pink_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_pink_dull", "Antiblock", "Pink Dull Anti Block")
                .addVariant("antiblock_purple_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_purple_dull", "Antiblock", "Purple Dull Anti Block")
                .addVariant("antiblock_red_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_red_dull", "Antiblock", "Red Dull Anti Block")
                .addVariant("antiblock_white_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_white_dull", "Antiblock", "White Dull Anti Block")
                .addVariant("antiblock_yellow_dull", ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW).translation("antiblock_yellow_dull", "Antiblock", "Yellow Dull Anti Block")
                .addVariant("antiblock_black_dull_borderless").translation("antiblock_black_dull_borderless", "Antiblock", "Black Dull Borderless Anti Block")
                .addVariant("antiblock_blue_dull_borderless").translation("antiblock_blue_dull_borderless", "Antiblock", "Blue Dull Borderless Anti Block")
                .addVariant("antiblock_brown_dull_borderless").translation("antiblock_brown_dull_borderless", "Antiblock", "Brown Dull Borderless Anti Block")
                .addVariant("antiblock_cyan_dull_borderless").translation("antiblock_cyan_dull_borderless", "Antiblock", "Cyan Dull Borderless Anti Block")
                .addVariant("antiblock_gray_dull_borderless").translation("antiblock_gray_dull_borderless", "Antiblock", "Gray Dull Borderless Anti Block")
                .addVariant("antiblock_green_dull_borderless").translation("antiblock_green_dull_borderless", "Antiblock", "Green Dull Borderless Anti Block")
                .addVariant("antiblock_light_blue_dull_borderless").translation("antiblock_light_blue_dull_borderless", "Antiblock", "Light Blue Dull Borderless Anti Block")
                .addVariant("antiblock_light_gray_dull_borderless").translation("antiblock_light_gray_dull_borderless", "Antiblock", "Light Gray Dull Borderless Anti Block")
                .addVariant("antiblock_lime_dull_borderless").translation("antiblock_lime_dull_borderless", "Antiblock", "Lime Dull Borderless Anti Block")
                .addVariant("antiblock_magenta_dull_borderless").translation("antiblock_magenta_dull_borderless", "Antiblock", "Magenta Dull Borderless Anti Block")
                .addVariant("antiblock_orange_dull_borderless").translation("antiblock_orange_dull_borderless", "Antiblock", "Orange Dull Borderless Anti Block")
                .addVariant("antiblock_pink_dull_borderless").translation("antiblock_pink_dull_borderless", "Antiblock", "Pink Dull Borderless Anti Block")
                .addVariant("antiblock_purple_dull_borderless").translation("antiblock_purple_dull_borderless", "Antiblock", "Purple Dull Borderless Anti Block")
                .addVariant("antiblock_red_dull_borderless").translation("antiblock_red_dull_borderless", "Antiblock", "Red Dull Borderless Anti Block")
                .addVariant("antiblock_white_dull_borderless").translation("antiblock_white_dull_borderless", "Antiblock", "White Dull Borderless Anti Block")
                .addVariant("antiblock_yellow_dull_borderless").translation("antiblock_yellow_dull_borderless", "Antiblock", "Yellow Dull Borderless Anti Block")
                .build());

        BOOKSHELF = buildBookshelf(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF));

        GLASS = ChiselFamily.build("glass", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
                .addVariant(Blocks.GLASS)
                .addVariant("glass_borderless", ChiselModelHandlers.CONNECTED).translation("glass_borderless", "Glass", "Borderless Glass")
                .addVariant("glass_bubble", ChiselModelHandlers.CONNECTED).translation("glass_bubble", "Glass", "Bubble Glass")
                .addVariant("glass_chinese").translation("glass_chinese", "Glass", "Chinese Glass")
                .addVariant("glass_chinese_2").translation("glass_chinese_2", "Glass", "Chinese Glass")
                .addVariant("glass_chrono", ChiselModelHandlers.CONNECTED).translation("glass_chrono", "Glass", "Chrono")
                .addVariant("glass_dungeon").translation("glass_dungeon", "Glass", "Dungeon Glass")
                .addVariant("glass_edge", ChiselModelHandlers.CONNECTED).translation("glass_edge", "Glass", "Edge")
                .addVariant("glass_edge_steel", ChiselModelHandlers.CONNECTED).translation("glass_edge_steel", "Glass", "Steel Edge")
                .addVariant("glass_fence").translation("glass_fence", "Glass", "Modern Iron Fence")
                .addVariant("glass_grid_thick").translation("glass_grid_thick", "Glass", "Thick Grid Glass")
                .addVariant("glass_grid_thin").translation("glass_grid_thin", "Glass", "Thin Grid Glass")
                .addVariant("glass_japanese").translation("glass_japanese", "Glass", "Japanese Glass")
                .addVariant("glass_japanese_2").translation("glass_japanese_2", "Glass", "Japanese Glass")
                .addVariant("glass_light", ChiselModelHandlers.CONNECTED).translation("glass_light", "Glass", "Light Glass")
                .addVariant("glass_ornate", ChiselModelHandlers.CONNECTED).translation("glass_ornate", "Glass", "Ornate Steel Glass")
                .addVariant("glass_ornate_old").translation("glass_ornate_old", "Glass", "Old Ornate")
                .addVariant("glass_screen").translation("glass_screen", "Glass", "Screen")
                .addVariant("glass_shale", ChiselModelHandlers.CONNECTED).translation("glass_shale", "Glass", "Shale Glass")
                .addVariant("glass_steel", ChiselModelHandlers.CONNECTED).translation("glass_steel", "Glass", "Steel Frame Glass")
                .addVariant("glass_stone", ChiselModelHandlers.CONNECTED).translation("glass_stone", "Glass", "Stone Frame Glass")
                .addVariant("glass_streak").translation("glass_streak", "Glass", "Streak Glass")
                .build());

        GLASS_PANE = ChiselFamily.build("glass_pane", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE))
                .addVariant(Blocks.GLASS_PANE)
                .addVariant("glass_pane_borderless", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_borderless")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_borderless", "Glass Pane", "Borderless Glass Pane")
                .addVariant("glass_pane_bubble", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_bubble")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_bubble", "Glass Pane", "Bubble Glass Pane")
                .addVariant("glass_pane_chinese", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_chinese", "Glass Pane", "Chinese Glass Pane")
                .addVariant("glass_pane_chinese_gold", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_chinese_gold")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_chinese_gold", "Glass Pane", "Chinese Glass Pane with Golden Frame")
                .addVariant("glass_pane_japanese", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_japanese", "Glass Pane", "Japanese Glass Pane")
                .addVariant("glass_pane_japanese2", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_japanese2")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_japanese2", "Glass Pane", "Ornate Japanese Glass Pane")
                .addVariant("glass_pane_streak", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("glass_pane_streak")))), ChiselModelHandlers.GLASS_PANE).translation("glass_pane_streak", "Glass Pane", "Streak Glass Pane")
                .build());

        IRON_BARS = ChiselFamily.build("iron_bars", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS))
                .addVariant(Blocks.IRON_BARS)
                .addVariant("iron_bars_barbed_wire", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_barbed_wire")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_barbed_wire", "Iron Bars", "Menacing Iron Bars")
                .addVariant("iron_bars_bars", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_bars")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_bars", "Iron Bars", "Iron Bars without Frame")
                .addVariant("iron_bars_borderless", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_borderless")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_borderless", "Iron Bars", "Iron Bars without Frame")
                .addVariant("iron_bars_cage", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_cage")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_cage", "Iron Bars", "Iron Cage Bars")
                .addVariant("iron_bars_classic", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_classic", "Iron Bars", "Menacing Iron Bars")
                .addVariant("iron_bars_classic_new", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic_new")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_classic_new", "Iron Bars", "Vertical Iron Bars")
                .addVariant("iron_bars_fence", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_fence")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_fence", "Iron Bars", "Ornate Iron Pane Fence")
                .addVariant("iron_bars_modern", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_modern")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_modern", "Iron Bars", "Modern")
                .addVariant("iron_bars_ornate_steel", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_ornate_steel")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_ornate_steel", "Iron Bars", "Ornate Steel")
                .addVariant("iron_bars_spikes", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_spikes")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_spikes", "Iron Bars", "Iron Spikes")
                .addVariant("iron_bars_thick_grid", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thick_grid")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_thick_grid", "Iron Bars", "Thick Iron Grid")
                .addVariant("iron_bars_thin_grid", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thin_grid")))), ChiselModelHandlers.IRON_BARS).translation("iron_bars_thin_grid", "Iron Bars", "Thin Iron Grid")
                .build());

        JACK_O_LANTERN = ChiselFamily.build("jack_o_lantern", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN))
                .addVariant(Blocks.JACK_O_LANTERN)
                .addVariant("jack_o_lantern_0", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_0", "Jack o'Lantern", "Suprised")
                .addVariant("jack_o_lantern_1", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_1", "Jack o'Lantern", "Smiling open")
                .addVariant("jack_o_lantern_2", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_2", "Jack o'Lantern", "Cheeky")
                .addVariant("jack_o_lantern_3", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_3", "Jack o'Lantern", "Pensive")
                .addVariant("jack_o_lantern_4", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_4", "Jack o'Lantern", "Disappointed")
                .addVariant("jack_o_lantern_5", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_5", "Jack o'Lantern", "Smirking")
                .addVariant("jack_o_lantern_6", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_6", "Jack o'Lantern", "Curious")
                .addVariant("jack_o_lantern_7", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_7", "Jack o'Lantern", "Bored")
                .addVariant("jack_o_lantern_8", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_8", "Jack o'Lantern", "Sad")
                .addVariant("jack_o_lantern_9", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_9", "Jack o'Lantern", "Evil")
                .addVariant("jack_o_lantern_10", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_10", "Jack o'Lantern", "Exited")
                .addVariant("jack_o_lantern_11", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_11", "Jack o'Lantern", "Sleeping")
                .addVariant("jack_o_lantern_12", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_12", "Jack o'Lantern", "Astonished")
                .addVariant("jack_o_lantern_13", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_13", "Jack o'Lantern", "Neutral")
                .addVariant("jack_o_lantern_14", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_14", "Jack o'Lantern", "Laughing out loud")
                .addVariant("jack_o_lantern_15", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_15", "Jack o'Lantern", "Smiling Closed")
                .addVariant("jack_o_lantern_16", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("jack_o_lantern_16", "Jack o'Lantern", "Scary")
                .build());

        PUMPKIN = ChiselFamily.build("pumpkin", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN))
                .addVariant(Blocks.CARVED_PUMPKIN)
                .addVariant("pumpkin_0", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_0", "Pumpkin", "Surprised")
                .addVariant("pumpkin_1", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_1", "Pumpkin", "Smiling open")
                .addVariant("pumpkin_2", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_2", "Pumpkin", "Cheeky")
                .addVariant("pumpkin_3", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_3", "Pumpkin", "Pensive")
                .addVariant("pumpkin_4", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_4", "Pumpkin", "Disappointed")
                .addVariant("pumpkin_5", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_5", "Pumpkin", "Smirking")
                .addVariant("pumpkin_6", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_6", "Pumpkin", "Curious")
                .addVariant("pumpkin_7", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_7", "Pumpkin", "Bored")
                .addVariant("pumpkin_8", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_8", "Pumpkin", "Sad")
                .addVariant("pumpkin_9", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_9", "Pumpkin", "Evil")
                .addVariant("pumpkin_10", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_10", "Pumpkin", "Exited")
                .addVariant("pumpkin_11", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_11", "Pumpkin", "Sleeping")
                .addVariant("pumpkin_12", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_12", "Pumpkin", "Astonished")
                .addVariant("pumpkin_13", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_13", "Pumpkin", "Neutral")
                .addVariant("pumpkin_14", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_14", "Pumpkin", "Laughing out loud")
                .addVariant("pumpkin_15", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_15", "Pumpkin", "Smiling Closed")
                .addVariant("pumpkin_16", ChiselCarvedPumpkinBlock::new, ChiselModelHandlers.PUMPKIN).translation("pumpkin_16", "Pumpkin", "Scary")
                .build());

        REDSTONE_LAMP = ChiselFamily.build("redstone_lamp", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP))
                .addVariant(Blocks.REDSTONE_LAMP)
                .addVariant("redstone_lamp_square", ChiselRedstoneLampBlock::new, ChiselModelHandlers.REDSTONE_LAMP).translation("redstone_lamp_square", "Redstone Lamp", "Square")
                .build());

        ROAD_LINE = ChiselFamily.build("road_line", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().noCollision())
                .addVariant("road_line_double_white_center", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_white_center", "Road Lines", "Double White")
                .addVariant("road_line_double_white_long", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_white_long", "Road Lines", "Double White")
                .addVariant("road_line_double_white_side", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_white_side", "Road Lines", "Double White")
                .addVariant("road_line_double_yellow_center", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_yellow_center", "Road Lines", "Double Yellow")
                .addVariant("road_line_double_yellow_long", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_yellow_long", "Road Lines", "Double Yellow")
                .addVariant("road_line_double_yellow_side", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_double_yellow_side", "Road Lines", "Double Yellow")
                .addVariant("road_line_white_center", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_white_center", "Road Lines", "White")
                .addVariant("road_line_white_long", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_white_long", "Road Lines", "White")
                .addVariant("road_line_white_side", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_white_side", "Road Lines", "White")
                .addVariant("road_line_yellow_center", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_yellow_center", "Road Lines", "Yellow")
                .addVariant("road_line_yellow_long", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_yellow_long", "Road Lines", "Yellow")
                .addVariant("road_line_yellow_side", RoadlineBlock::new, ChiselModelHandlers.ROAD_LINES).translation("road_line_yellow_side", "Road Lines", "Yellow")
                .build());

        TORCH = ChiselFamily.build("torch", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH))
                .addVariant(Blocks.TORCH)
                .addTorchVariant("torch_1", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_1", "Torch", "Wax Candle")
                .addTorchVariant("torch_2", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_2", "Torch", "Tall Wax Candle")
                .addTorchVariant("torch_3", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_3", "Torch", "White Lamp")
                .addTorchVariant("torch_4", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_4", "Torch", "Embroidered White Lamp")
                .addTorchVariant("torch_5", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_5", "Torch", "Small Black Lamp")
                .addTorchVariant("torch_6", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_6", "Torch", "Tall Black Lamp")
                .addTorchVariant("torch_7", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_7", "Torch", "Red Lamp")
                .addTorchVariant("torch_8", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_8", "Torch", "Embroidered Red Lamp")
                .addTorchVariant("torch_9", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_9", "Torch", "Light Bulb")
                .addTorchVariant("torch_10", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new).translation("torch_10", "Torch", "Clear Light Bulb")
                .build());

        FAMILIES = List.of(ANTIBLOCK, BOOKSHELF, GLASS, GLASS_PANE, IRON_BARS, JACK_O_LANTERN, PUMPKIN, REDSTONE_LAMP, ROAD_LINE, TORCH);
    }

    private SpecialFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }

    private static ChiselFamily buildBookshelf(BlockBehaviour.Properties properties) {
        String[] woods = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"};
        String[] woodNames = {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "Dark Oak", "Mangrove", "Cherry", "Pale Oak", "Bamboo", "Crimson", "Warped"};
        String[] types = {"abandoned", "brim", "cans", "historian", "hoarder", "necromancer", "necromancer_apprentice", "papers", "rainbow", "tomes"};
        String[] typeNames = {"Abandoned", "Brim", "Cans", "Historian", "Hoarder", "Necromancer", "Necromancer Apprentice", "Papers", "Rainbow", "Tomes"};

        return ChiselFamily.build("bookshelf", builder -> {
            builder.properties(properties).addVariant(Blocks.BOOKSHELF);
            for (int wood = 0; wood < woods.length; wood++) {
                for (int type = 0; type < types.length; type++) {
                    String description = typeNames[type];
                    switch (types[type]) {
                        case "abandoned" -> description = "Abandoned Bookshelf";
                        case "brim" -> description = "Bookshelf filled to the brim with boring Pastel Books";
                        case "historian" -> description = "Historian's Bookshelf";
                        case "hoarder" -> description = "Hoarder's Bookshelf";
                        case "necromancer" -> description = "Necromancer's Bookshelf";
                        case "necromancer_apprentice" -> description = "Necromancer’s Apprentice Bookshelf";
                        case "rainbow" -> description = "Bookshelf with Rainbow Books";
                        case "tomes" -> description = "Bookshelf with Red Tomes";
                    }
                    String variant = "bookshelf_%s_%s".formatted(woods[wood], types[type]);
                    builder.addVariant(variant, ChiselModelHandlers.BOOKSHELF).translation(variant, "%s Bookshelf".formatted(woodNames[wood]), description);
                }
            }
        });
    }
}
