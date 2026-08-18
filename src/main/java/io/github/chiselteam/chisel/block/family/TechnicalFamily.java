package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class TechnicalFamily extends ChiselFamily {
    public TechnicalFamily(BlockBehaviour.Properties props) {
        family = builder("technical")
                .addVariant("technical_125", props)
                .addVariant("technical_cables", props, CONNECTED)
                .addVariant("technical_engineering", props, CONNECTED)
                .addVariant("technical_engineering_1", props, CONNECTED)
                .addVariant("technical_engineering_2", props, CONNECTED)
                .addVariant("technical_engineering_3", props, CONNECTED)
                .addVariant("technical_engineering_prototype", props, CONNECTED)
                .addVariant("technical_exhaust", props, CONNECTED)
                .addVariant("technical_fan_fast", props, TBS)
                .addVariant("technical_fan_fast_transparent", props.noOcclusion(), TBS)
                .addVariant("technical_fan_malfunction", props, TBS)
                .addVariant("technical_fan_malfunction_slow", props, TBS)
                .addVariant("technical_fan_massive", props, V9)
                .addVariant("technical_fan_still", props, TBS)
                .addVariant("technical_fan_still_transparent", props.noOcclusion(), TBS)
                .addVariant("technical_gears", props)
                .addVariant("technical_grate", props, CONNECTED)
                .addVariant("technical_grate_rusty", props, CONNECTED)
                .addVariant("technical_hex_plating", props, V9)
                .addVariant("technical_insulation", props, CONNECTED)
                .addVariant("technical_makeshift_panels", props, V9)
                .addVariant("technical_megacell", props, TBS)
                .addVariant("technical_old", props)
                .addVariant("technical_oldtimeyserveranim", props)
                .addVariant("technical_panel_caution", props)
                .addVariant("technical_piping", props, R9)
                .addVariant("technical_rusty", props, R9)
                .addVariant("technical_scaffold", props, CONNECTED)
                .addVariant("technical_scaffold_large", props, CONNECTED)
                .addVariant("technical_scaffold_large_1", props, CONNECTED)
                .addVariant("technical_scaffold_large_2", props, CONNECTED)
                .addVariant("technical_scaffold_large_3", props, CONNECTED)
                .addVariant("technical_scaffold_transparent", props.noOcclusion(), CONNECTED)
                .addVariant("technical_spinning_stuff", props, CONNECTED)
                .addVariant("technical_sturdy", props, CONNECTED)
                .addVariant("technical_under_large", props, CONNECTED)
                .addVariant("technical_under_small", props, CONNECTED)
                .addVariant("technical_vents", props, CONNECTED)
                .addVariant("technical_vents_glowing", props, CONNECTED)
                .addVariant("technical_wall_pads", props, CONNECTED)
                .addVariant("technical_weathered_green_panels", props, R4)
                .addVariant("technical_weathered_orange_panels", props, R4)
                .addVariant("technical_wires", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("technical_125"), "Technical Block", "125");
        lang.addBlock(getVariant("technical_cables"), "Technical Block", "Cables");
        lang.addBlock(getVariant("technical_engineering"), "Technical Block", "Engineering");
        lang.addBlock(getVariant("technical_engineering_1"), "Technical Block", "Engineering");
        lang.addBlock(getVariant("technical_engineering_2"), "Technical Block", "Engineering");
        lang.addBlock(getVariant("technical_engineering_3"), "Technical Block", "Engineering");
        lang.addBlock(getVariant("technical_engineering_prototype"), "Technical Block", "Engineering Prototype");
        lang.addBlock(getVariant("technical_exhaust"), "Technical Block", "Exhaust");
        lang.addBlock(getVariant("technical_fan_fast"), "Technical Block", "Fan (Fast)");
        lang.addBlock(getVariant("technical_fan_fast_transparent"), "Technical Block", "Transparent Fast Fan");
        lang.addBlock(getVariant("technical_fan_malfunction"), "Technical Block", "Fan (Malfunctioning)");
        lang.addBlock(getVariant("technical_fan_malfunction_slow"), "Technical Block", "Slow Malfunctioning Fan");
        lang.addBlock(getVariant("technical_fan_massive"), "Technical Block", "Massive Fan");
        lang.addBlock(getVariant("technical_fan_still"), "Technical Block", "Fan (Off)");
        lang.addBlock(getVariant("technical_fan_still_transparent"), "Technical Block", "Transparent Still Fan");
        lang.addBlock(getVariant("technical_gears"), "Technical Block", "Gears and Flywheels");
        lang.addBlock(getVariant("technical_grate"), "Technical Block", "Grate");
        lang.addBlock(getVariant("technical_grate_rusty"), "Technical Block", "Rusty Grate");
        lang.addBlock(getVariant("technical_hex_plating"), "Technical Block", "Hex Plating");
        lang.addBlock(getVariant("technical_insulation"), "Technical Block", "Insulation");
        lang.addBlock(getVariant("technical_makeshift_panels"), "Technical Block", "Makeshift Panels");
        lang.addBlock(getVariant("technical_megacell"), "Technical Block", "Megacell");
        lang.addBlock(getVariant("technical_old"), "Technical Block", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("technical_oldtimeyserveranim"), "Technical Block", "Old-Timey Server");
        lang.addBlock(getVariant("technical_panel_caution"), "Technical Block", "Panels with Caution Tape");
        lang.addBlock(getVariant("technical_piping"), "Technical Block", "Piping");
        lang.addBlock(getVariant("technical_rusty"), "Technical Block", "Rusty");
        lang.addBlock(getVariant("technical_scaffold"), "Technical Block", "Scaffold");
        lang.addBlock(getVariant("technical_scaffold_large"), "Technical Block", "Large Scaffold");
        lang.addBlock(getVariant("technical_scaffold_large_1"), "Technical Block", "Large Scaffold");
        lang.addBlock(getVariant("technical_scaffold_large_2"), "Technical Block", "Large Scaffold");
        lang.addBlock(getVariant("technical_scaffold_large_3"), "Technical Block", "Large Scaffold");
        lang.addBlock(getVariant("technical_scaffold_transparent"), "Technical Block", "Transparent Scaffold");
        lang.addBlock(getVariant("technical_spinning_stuff"), "Technical Block", "Spinning Stuff");
        lang.addBlock(getVariant("technical_sturdy"), "Technical Block", "Sturdy");
        lang.addBlock(getVariant("technical_under_large"), "Technical Block", "Under-Pipe (Large Pipe)");
        lang.addBlock(getVariant("technical_under_small"), "Technical Block", "Under-Pipe (Small Pipes)");
        lang.addBlock(getVariant("technical_vents"), "Technical Block", "Vents");
        lang.addBlock(getVariant("technical_vents_glowing"), "Technical Block", "Glowing Vents");
        lang.addBlock(getVariant("technical_wall_pads"), "Technical Block", "Wall Pads");
        lang.addBlock(getVariant("technical_weathered_green_panels"), "Technical Block", "Weathered Green Panels");
        lang.addBlock(getVariant("technical_weathered_orange_panels"), "Technical Block", "Weathered Orange Panels");
        lang.addBlock(getVariant("technical_wires"), "Technical Block", "Wires");
    }
}

