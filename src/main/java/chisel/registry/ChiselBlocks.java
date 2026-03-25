package chisel.registry;

import chisel.Chisel;
import chisel.block.ChiselBlock;
import chisel.block.ConnectedTextureBlock;
import chisel.block.glass.GlassBlock;
import chisel.block.glass.GlassPaneBlock;
import chisel.block.metal.*;
import chisel.block.modded.*;
import chisel.block.other.*;
import chisel.block.glass.StainedGlassBlock;
import chisel.block.glass.StainedGlassPaneBlock;
import chisel.block.stone.*;
import chisel.block.wood.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ChiselBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chisel.MODID);

    public static final AcaciaBlock ACACIA = new AcaciaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final AluminumBlock ALUMINUM = new AluminumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final AndesiteBlock ANDESITE = new AndesiteBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));
    public static final AntiblockBlock ANTIBLOCK = new AntiblockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE));
    public static final BirchBlock BIRCH = new BirchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final BookshelfBlock BOOKSHELF = new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF));
    public static final BricksBlock BRICKS = new BricksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
    public static final BronzeBlock BRONZE = new BronzeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CloudBlock CLOUD = new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion());
    public static final CobaltBlock COBALT = new CobaltBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CobblestoneBlock COBBLESTONE = new CobblestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));
    public static final ConcreteBlock CONCRETE = new ConcreteBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE));
    public static final CopperBlock COPPER = new CopperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));
    public static final DarkOakBlock DARK_OAK = new DarkOakBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final DiamondBlock DIAMOND = new DiamondBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
    public static final DioriteBlock DIORITE = new DioriteBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE));
    public static final DirtBlock DIRT = new DirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final ElectrumBlock ELECTRUM = new ElectrumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final EmeraldBlock EMERALD = new EmeraldBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK));
    public static final EnergizedVoidstoneBlock ENERGIZED_VOIDSTONE = new EnergizedVoidstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final FactoryBlock FACTORY = new FactoryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final FuturaBlock FUTURA = new FuturaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final GlassBlock GLASS = new GlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final GlassPaneBlock GLASS_PANE = new GlassPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE));
    public static final GlowstoneBlock GLOWSTONE = new GlowstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE));
    public static final GoldBlock GOLD = new GoldBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
    public static final GraniteBlock GRANITE = new GraniteBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE));
    public static final GrimstoneBlock GRIMSTONE = new GrimstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final HexPlatingBlock HEX_PLATING = new HexPlatingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final HolystoneBlock HOLYSTONE = new HolystoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final IceBlock ICE = new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE));
    public static final InvarBlock INVAR = new InvarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final IronBlock IRON = new IronBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ChiselIronBarsBlock IRON_BARS = new ChiselIronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS));
    public static final JungleBlock JUNGLE = new JungleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final LaboratoryBlock LABORATORY = new LaboratoryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LapisBlock LAPIS = new LapisBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final LavastoneBlock LAVASTONE = new LavastoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final LeadBlock LEAD = new LeadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LeafBlock LEAF = new LeafBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final LimestoneBlock LIMESTONE = new LimestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final LitPumpkinBlock LIT_PUMPKIN = new LitPumpkinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN));
    public static final MarbleBlock MARBLE = new MarbleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final MossyCobblestoneBlock MOSSY_COBBLESTONE = new MossyCobblestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE));
    public static final MossyTempleBlock MOSSY_TEMPLE = new MossyTempleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final NetherBrickBlock NETHERBRICK = new NetherBrickBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final NetherrackBlock NETHERRACK = new NetherrackBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final NickelBlock NICKEL = new NickelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final OakBlock OAK = new OakBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final ObsidianBlock OBSIDIAN = new ObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN));
    public static final PackedIceBlock PACKED_ICE = new PackedIceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
    public static final PackedIcePillarBlock PACKED_ICE_PILLAR = new PackedIcePillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
    public static final PaperwallBlock PAPERWALL = new PaperwallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final PaperwallBlockBlock PAPERWALL_BLOCK = new PaperwallBlockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final PlatinumBlock PLATINUM = new PlatinumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final PumpkinBlock PUMPKIN = new PumpkinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN));
    public static final RedstoneBlock REDSTONE = new RedstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK));
    public static final RoadLineBlock ROAD_LINE = new RoadLineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final RunicVoidstoneBlock RUNIC_VOIDSTONE = new RunicVoidstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final SandstoneBlock SANDSTONE = new SandstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
    public static final SilverBlock SILVER = new SilverBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final SnakestoneSandBlock SNAKESTONE_SAND = new SnakestoneSandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
    public static final SnakestoneStoneBlock SNAKESTONE_STONE = new SnakestoneStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final SpruceBlock SPRUCE = new SpruceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final SteelBlock STEEL = new SteelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final StoneBricksBlock STONE_BRICKS = new StoneBricksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final TechnicalBlock TECHNICAL = new TechnicalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TempleBlock TEMPLE = new TempleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final TinBlock TIN = new TinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TorchBlock TORCH = new TorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH));
    public static final TyrianBlock TYRIAN = new TyrianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final UraniumBlock URANIUM = new UraniumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ValentinesBlock VALENTINES = new ValentinesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final VoidstoneBlock VOIDSTONE = new VoidstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final WarningBlock WARNING = new WarningBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final WaterstoneBlock WATERSTONE = new WaterstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final WoolenClayBlock WOOLEN_CLAY = new WoolenClayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY));

    public static final List<StainedGlassBlock> STAINED_GLASS = new ArrayList<>();
    public static final List<StainedGlassPaneBlock> STAINED_GLASS_PANE = new ArrayList<>();

    static {
        for (DyeColor color : DyeColor.values()) {
            STAINED_GLASS.add(new StainedGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS), color.getName(), getVanillaStainedGlass(color)));
            STAINED_GLASS_PANE.add(new StainedGlassPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE), color, getVanillaStainedGlassPane(color)));
        }
    }

    private static Block getVanillaStainedGlass(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_STAINED_GLASS;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS;
            case LIME -> Blocks.LIME_STAINED_GLASS;
            case PINK -> Blocks.PINK_STAINED_GLASS;
            case GRAY -> Blocks.GRAY_STAINED_GLASS;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS;
            case CYAN -> Blocks.CYAN_STAINED_GLASS;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS;
            case BLUE -> Blocks.BLUE_STAINED_GLASS;
            case BROWN -> Blocks.BROWN_STAINED_GLASS;
            case GREEN -> Blocks.GREEN_STAINED_GLASS;
            case RED -> Blocks.RED_STAINED_GLASS;
            case BLACK -> Blocks.BLACK_STAINED_GLASS;
        };
    }

    private static Block getVanillaStainedGlassPane(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_STAINED_GLASS_PANE;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS_PANE;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS_PANE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS_PANE;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS_PANE;
            case LIME -> Blocks.LIME_STAINED_GLASS_PANE;
            case PINK -> Blocks.PINK_STAINED_GLASS_PANE;
            case GRAY -> Blocks.GRAY_STAINED_GLASS_PANE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS_PANE;
            case CYAN -> Blocks.CYAN_STAINED_GLASS_PANE;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS_PANE;
            case BLUE -> Blocks.BLUE_STAINED_GLASS_PANE;
            case BROWN -> Blocks.BROWN_STAINED_GLASS_PANE;
            case GREEN -> Blocks.GREEN_STAINED_GLASS_PANE;
            case RED -> Blocks.RED_STAINED_GLASS_PANE;
            case BLACK -> Blocks.BLACK_STAINED_GLASS_PANE;
        };
    }

    public static List<ChiselBlock> getBlocks() {
        List<ChiselBlock> blocks = new ArrayList<>(List.of(
                ACACIA, ALUMINUM, ANDESITE, ANTIBLOCK, BIRCH, BOOKSHELF, BRICKS, BRONZE,
                CLOUD, COBALT, COBBLESTONE, CONCRETE, COPPER, DARK_OAK, DIAMOND, DIORITE, DIRT, ELECTRUM, EMERALD,
                ENERGIZED_VOIDSTONE, FACTORY, FUTURA, GLASS, GLASS_PANE, GLOWSTONE, GOLD, GRANITE, GRIMSTONE,
                HEX_PLATING, HOLYSTONE, ICE, INVAR, IRON, IRON_BARS, JUNGLE, LABORATORY, LAPIS, LAVASTONE, LEAD,
                LEAF, LIMESTONE, LIT_PUMPKIN, MARBLE, MOSSY_COBBLESTONE, MOSSY_TEMPLE, NETHERBRICK, NETHERRACK,
                NICKEL, OAK, OBSIDIAN, PACKED_ICE, PACKED_ICE_PILLAR, PAPERWALL, PAPERWALL_BLOCK, PLATINUM,
                PUMPKIN, REDSTONE, ROAD_LINE, RUNIC_VOIDSTONE, SANDSTONE, SILVER, SNAKESTONE_SAND, SNAKESTONE_STONE,
                SPRUCE, STEEL, STONE_BRICKS, TECHNICAL, TEMPLE, TIN, TORCH, TYRIAN, URANIUM, VALENTINES, VOIDSTONE, WARNING,
                WATERSTONE, WOOLEN_CLAY
        ));
        blocks.addAll(STAINED_GLASS);
        blocks.addAll(STAINED_GLASS_PANE);
        return blocks;
    }

    public static void registerBlocks(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public static DeferredBlock<Block> register(String name, BlockBehaviour.Properties properties) {
        return BLOCKS.register(name, () -> new ConnectedTextureBlock(properties.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix(name)))));
    }

    public static DeferredBlock<Block> register(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties) {
        return BLOCKS.register(name, () -> func.apply(properties.get().setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix(name)))));
    }
}
