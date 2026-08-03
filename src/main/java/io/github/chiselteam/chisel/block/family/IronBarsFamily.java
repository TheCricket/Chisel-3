package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ChiselIronBarsBlock;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.IRON_BARS;

public class IronBarsFamily extends ChiselFamily {
    public IronBarsFamily(BlockBehaviour.Properties props) {
        family = builder("iron_bars")
                .addVariant(Blocks.IRON_BARS)
                .addVariant("iron_bars_barbed_wire", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_barbed_wire")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_bars", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_bars")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_borderless", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_borderless")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_cage", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_cage")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_classic", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_classic_new", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic_new")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_fence", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_fence")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_modern", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_modern")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_ornate_steel", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_ornate_steel")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_spikes", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_spikes")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_thick_grid", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thick_grid")))), () -> props, IRON_BARS)
                .addVariant("iron_bars_thin_grid", (p) -> new ChiselIronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thin_grid")))), () -> props, IRON_BARS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("iron_bars_barbed_wire"), "Iron Bars", "Menacing Iron Bars");
        lang.addBlock(getVariant("iron_bars_bars"), "Iron Bars", "Iron Bars without Frame");
        lang.addBlock(getVariant("iron_bars_borderless"), "Iron Bars", "Iron Bars without Frame");
        lang.addBlock(getVariant("iron_bars_cage"), "Iron Bars", "Iron Cage Bars");
        lang.addBlock(getVariant("iron_bars_classic"), "Iron Bars", "Menacing Iron Bars");
        lang.addBlock(getVariant("iron_bars_classic_new"), "Iron Bars", "Vertical Iron Bars");
        lang.addBlock(getVariant("iron_bars_fence"), "Iron Bars", "Ornate Iron Pane Fence");
        lang.addBlock(getVariant("iron_bars_modern"), "Iron Bars", "Modern");
        lang.addBlock(getVariant("iron_bars_ornate_steel"), "Iron Bars", "Ornate Steel");
        lang.addBlock(getVariant("iron_bars_spikes"), "Iron Bars", "Iron Spikes");
        lang.addBlock(getVariant("iron_bars_thick_grid"), "Iron Bars", "Thick Iron Grid");
        lang.addBlock(getVariant("iron_bars_thin_grid"), "Iron Bars", "Thin Iron Grid");
    }
}
