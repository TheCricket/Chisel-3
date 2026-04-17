package chisel.block;

import chisel.Chisel;
import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ChiselIronBarsFamily extends ChiselBlock {
    public ChiselIronBarsFamily(BlockBehaviour.Properties props) {
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
