package chisel.registry;

import chisel.Chisel;
import chisel.block.*;
import chisel.block.util.ChiselBlock;
import chisel.block.util.ConnectedTextureBlock;
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

    public static final AcaciaFamily ACACIA = new AcaciaFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final AluminumFamily ALUMINUM = new AluminumFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final AndesiteFamily ANDESITE = new AndesiteFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));
    public static final AntiblockFamily ANTIBLOCK = new AntiblockFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE));
    public static final BirchFamily BIRCH = new BirchFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final BookshelfFamily BOOKSHELF = new BookshelfFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF));
    public static final BricksFamily BRICKS = new BricksFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
    public static final BronzeFamily BRONZE = new BronzeFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CloudFamily CLOUD = new CloudFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion());
    public static final CobaltFamily COBALT = new CobaltFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CobblestoneFamily COBBLESTONE = new CobblestoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));
    public static final ConcreteFamily CONCRETE = new ConcreteFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE));
    public static final CopperFamily COPPER = new CopperFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));
    public static final DarkOakFamily DARK_OAK = new DarkOakFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final DiamondFamily DIAMOND = new DiamondFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
    public static final DioriteFamily DIORITE = new DioriteFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE));
    public static final DirtFamily DIRT = new DirtFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final ElectrumFamily ELECTRUM = new ElectrumFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final EmeraldFamily EMERALD = new EmeraldFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK));
    public static final EnergizedVoidstoneFamily ENERGIZED_VOIDSTONE = new EnergizedVoidstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final FactoryFamily FACTORY = new FactoryFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final FuturaFamily FUTURA = new FuturaFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final GlassFamily GLASS = new GlassFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final GlassPaneFamily GLASS_PANE = new GlassPaneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE));
    public static final GlowstoneFamily GLOWSTONE = new GlowstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE));
    public static final GoldFamily GOLD = new GoldFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
    public static final GraniteFamily GRANITE = new GraniteFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE));
    public static final GrimstoneFamily GRIMSTONE = new GrimstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final HexPlatingFamily HEX_PLATING = new HexPlatingFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final HolystoneFamily HOLYSTONE = new HolystoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final IceFamily ICE = new IceFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE));
    public static final InvarFamily INVAR = new InvarFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final IronFamily IRON = new IronFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ChiselIronBarsFamily IRON_BARS = new ChiselIronBarsFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS));
    public static final JungleFamily JUNGLE = new JungleFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final LaboratoryFamily LABORATORY = new LaboratoryFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LapisFamily LAPIS = new LapisFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final LavastoneFamily LAVASTONE = new LavastoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final LeadFamily LEAD = new LeadFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LeafFamily LEAF = new LeafFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final LimestoneFamily LIMESTONE = new LimestoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final JackOLanternFamily JACK_O_LANTERN = new JackOLanternFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN));
    public static final MarbleFamily MARBLE = new MarbleFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final MossyCobblestoneFamily MOSSY_COBBLESTONE = new MossyCobblestoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE));
    public static final MossyTempleFamily MOSSY_TEMPLE = new MossyTempleFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final NetherBrickFamily NETHERBRICK = new NetherBrickFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final NetherrackFamily NETHERRACK = new NetherrackFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final NickelFamily NICKEL = new NickelFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final OakFamily OAK = new OakFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final ObsidianFamily OBSIDIAN = new ObsidianFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN));
    public static final PaperwallFamily PAPERWALL = new PaperwallFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final PlatinumFamily PLATINUM = new PlatinumFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ChiselPumpkinFamily PUMPKIN = new ChiselPumpkinFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN));
    public static final RedstoneFamily REDSTONE = new RedstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK));
    public static final RoadLineFamily ROAD_LINE = new RoadLineFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().noCollision());
    public static final SandstoneFamily SANDSTONE = new SandstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
    public static final SilverFamily SILVER = new SilverFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    //public static final SnakestoneSandFamily SNAKESTONE_SAND = new SnakestoneSandFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
    //public static final SnakestoneStoneFamily SNAKESTONE_STONE = new SnakestoneStoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final SpruceFamily SPRUCE = new SpruceFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final SteelFamily STEEL = new SteelFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final StoneBricksFamily STONE_BRICKS = new StoneBricksFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final TechnicalFamily TECHNICAL = new TechnicalFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TempleFamily TEMPLE = new TempleFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final TinFamily TIN = new TinFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ChiselTorchFamily TORCH = new ChiselTorchFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH));
    public static final TyrianFamily TYRIAN = new TyrianFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final UraniumFamily URANIUM = new UraniumFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ValentinesFamily VALENTINES = new ValentinesFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final VoidstoneFamily VOIDSTONE = new VoidstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final WarningFamily WARNING = new WarningFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final WaterstoneFamily WATERSTONE = new WaterstoneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final WoolenClayFamily WOOLEN_CLAY = new WoolenClayFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY));

    public static final List<StainedGlassFamily> STAINED_GLASS = new ArrayList<>();
    public static final List<StainedGlassPaneFamily> STAINED_GLASS_PANE = new ArrayList<>();

    static {
        for (DyeColor color : DyeColor.values()) {
            STAINED_GLASS.add(new StainedGlassFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS), color.getName(), getVanillaStainedGlass(color)));
            STAINED_GLASS_PANE.add(new StainedGlassPaneFamily(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE), color, getVanillaStainedGlassPane(color)));
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
                LEAF, LIMESTONE, JACK_O_LANTERN, MARBLE, MOSSY_COBBLESTONE, MOSSY_TEMPLE, NETHERBRICK, NETHERRACK,
                NICKEL, OAK, OBSIDIAN, PAPERWALL, PLATINUM,
                PUMPKIN, REDSTONE, ROAD_LINE, SANDSTONE, SILVER,
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
