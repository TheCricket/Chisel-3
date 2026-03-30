package chisel.block.metal;

import chisel.Chisel;
import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ChiselIronBarsBlock extends ChiselBlock {
    public ChiselIronBarsBlock(BlockBehaviour.Properties props) {
        family = builder("iron_bars")
                .addVariant(Blocks.IRON_BARS)
                .addVariant("iron_bars_barbed_wire", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_barbed_wire")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_bars", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_bars")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_borderless", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_borderless")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_cage", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_cage")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_classic", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_classic_new", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_classic_new")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_fence", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_fence")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_modern", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_modern")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_ornate_steel", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_ornate_steel")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_spikes", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_spikes")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_thick_grid", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thick_grid")))), () -> props, VariantModelType.IRON_BARS)
                .addVariant("iron_bars_thin_grid", (p) -> new IronBarsBlock(p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("iron_bars_thin_grid")))), () -> props, VariantModelType.IRON_BARS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("iron_bars_barbed_wire"), "Iron Bars", "Barbed Wire");
        lang.addBlock(getVariant("iron_bars_bars"), "Iron Bars", "Bars");
        lang.addBlock(getVariant("iron_bars_borderless"), "Iron Bars", "Borderless");
        lang.addBlock(getVariant("iron_bars_cage"), "Iron Bars", "Cage");
        lang.addBlock(getVariant("iron_bars_classic"), "Iron Bars", "Classic");
        lang.addBlock(getVariant("iron_bars_classic_new"), "Iron Bars", "New Classic");
        lang.addBlock(getVariant("iron_bars_fence"), "Iron Bars", "Fence");
        lang.addBlock(getVariant("iron_bars_modern"), "Iron Bars", "Modern");
        lang.addBlock(getVariant("iron_bars_ornate_steel"), "Iron Bars", "Ornate Steel");
        lang.addBlock(getVariant("iron_bars_spikes"), "Iron Bars", "Spikes");
        lang.addBlock(getVariant("iron_bars_thick_grid"), "Iron Bars", "Thick Grid");
        lang.addBlock(getVariant("iron_bars_thin_grid"), "Iron Bars", "Thin Grid");
    }
}
