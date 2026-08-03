package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.AutoChiselBlock;
import io.github.chiselteam.chisel.block.BuildersGuideBlock;
import io.github.chiselteam.chisel.block.family.*;
import io.github.chiselteam.chisel.block.family.compat.*;
import io.github.chiselteam.chisel.block.family.materials.*;
import io.github.chiselteam.chisel.block.family.materials.copper.CopperFamily;
import io.github.chiselteam.chisel.block.family.materials.copper.ExposedCopperFamily;
import io.github.chiselteam.chisel.block.family.materials.copper.OxidizedCopperFamily;
import io.github.chiselteam.chisel.block.family.materials.copper.WeatheredCopperFamily;
import io.github.chiselteam.chisel.block.family.stone.*;
import io.github.chiselteam.chisel.block.family.wood.*;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ConnectedTextureBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ChiselBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chisel.MODID);

    public static final AcaciaFamily ACACIA = new AcaciaFamily(Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final AluminumFamily ALUMINUM = new AluminumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final AncientStoneFamily ANCIENT_STONE = new AncientStoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final AndesiteFamily ANDESITE = new AndesiteFamily(Properties.ofFullCopy(Blocks.ANDESITE));
    public static final AntiblockFamily ANTIBLOCK = new AntiblockFamily(Properties.of().mapColor(MapColor.STONE).strength(3.0F, 5.0F).requiresCorrectToolForDrops().lightLevel((_) -> 15));
    public static final ArcaneFamily ARCANE = new ArcaneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final BambooFamily BAMBOO = new BambooFamily(Properties.ofFullCopy(Blocks.BAMBOO_PLANKS));
    public static final BirchFamily BIRCH = new BirchFamily(Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final BookshelfFamily BOOKSHELF = new BookshelfFamily(Properties.ofFullCopy(Blocks.BOOKSHELF));
    public static final BricksFamily BRICKS = new BricksFamily(Properties.ofFullCopy(Blocks.BRICKS));
    public static final BronzeFamily BRONZE = new BronzeFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CertusFamily CERTUS = new CertusFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final CharcoalFamily CHARCOAL = new CharcoalFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final CloudFamily CLOUD = new CloudFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion());
    public static final CoalFamily COAL = new CoalFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final CoalCokeFamily COAL_COKE = new CoalCokeFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final CobaltFamily COBALT = new CobaltFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final CobblestoneFamily COBBLESTONE = new CobblestoneFamily(Properties.ofFullCopy(Blocks.COBBLESTONE));
    public static final ConcreteFamily CONCRETE = new ConcreteFamily(Properties.ofFullCopy(Blocks.WHITE_CONCRETE));
    public static final CopperFamily COPPER = new CopperFamily(Properties.ofFullCopy(Blocks.COPPER_BLOCK));
    public static final ExposedCopperFamily EXPOSED_COPPER = new ExposedCopperFamily(Properties.ofFullCopy(Blocks.EXPOSED_COPPER));
    public static final WeatheredCopperFamily WEATHERED_COPPER = new WeatheredCopperFamily(Properties.ofFullCopy(Blocks.WEATHERED_COPPER));
    public static final OxidizedCopperFamily OXIDIZED_COPPER = new OxidizedCopperFamily(Properties.ofFullCopy(Blocks.OXIDIZED_COPPER));
    public static final CrimsonFamily CRIMSON = new CrimsonFamily(Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final WarpedFamily WARPED = new WarpedFamily(Properties.ofFullCopy(Blocks.WARPED_PLANKS));
    public static final DarkOakFamily DARK_OAK = new DarkOakFamily(Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final CherryFamily CHERRY = new CherryFamily(Properties.ofFullCopy(Blocks.CHERRY_PLANKS));
    public static final BasaltFamily BASALT = new BasaltFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final DiamondFamily DIAMOND = new DiamondFamily(Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
    public static final DioriteFamily DIORITE = new DioriteFamily(Properties.ofFullCopy(Blocks.DIORITE));
    public static final DeepslateFamily DEEPSLATE = new DeepslateFamily(Properties.ofFullCopy(Blocks.DEEPSLATE));
    public static final DirtFamily DIRT = new DirtFamily(Properties.ofFullCopy(Blocks.DIRT));
    public static final ElectrumFamily ELECTRUM = new ElectrumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final EmeraldFamily EMERALD = new EmeraldFamily(Properties.ofFullCopy(Blocks.EMERALD_BLOCK));
    public static final EndStoneFamily END_STONE = new EndStoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final EnergizedVoidstoneFamily ENERGIZED_VOIDSTONE = new EnergizedVoidstoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final FactoryFamily FACTORY = new FactoryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final FuturaFamily FUTURA = new FuturaFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final GlassFamily GLASS = new GlassFamily(Properties.ofFullCopy(Blocks.GLASS));
    public static final GlassPaneFamily GLASS_PANE = new GlassPaneFamily(Properties.ofFullCopy(Blocks.GLASS_PANE));
    public static final GlowstoneFamily GLOWSTONE = new GlowstoneFamily(Properties.ofFullCopy(Blocks.GLOWSTONE));
    public static final GoldFamily GOLD = new GoldFamily(Properties.ofFullCopy(Blocks.GOLD_BLOCK));
    public static final GraniteFamily GRANITE = new GraniteFamily(Properties.ofFullCopy(Blocks.GRANITE));
    public static final GrimstoneFamily GRIMSTONE = new GrimstoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final HexPlatingFamily HEX_PLATING = new HexPlatingFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final HolystoneFamily HOLYSTONE = new HolystoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final IceFamily ICE = new IceFamily(Properties.ofFullCopy(Blocks.ICE));
    public static final InvarFamily INVAR = new InvarFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final IronFamily IRON = new IronFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final IronBarsFamily IRON_BARS = new IronBarsFamily(Properties.ofFullCopy(Blocks.IRON_BARS));
    public static final JackOLanternFamily JACK_O_LANTERN = new JackOLanternFamily(Properties.ofFullCopy(Blocks.JACK_O_LANTERN));
    public static final JungleFamily JUNGLE = new JungleFamily(Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final MangroveFamily MANGROVE = new MangroveFamily(Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
    public static final LaboratoryFamily LABORATORY = new LaboratoryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LapisFamily LAPIS = new LapisFamily(Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final LavastoneFamily LAVASTONE = new LavastoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final LeadFamily LEAD = new LeadFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final LeafFamily LEAF = new LeafFamily(Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final LimestoneFamily LIMESTONE = new LimestoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final MagmaFamily MAGMA = new MagmaFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final MarbleFamily MARBLE = new MarbleFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final MilitaryFamily MILITARY = new MilitaryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final MossyCobblestoneFamily MOSSY_COBBLESTONE = new MossyCobblestoneFamily(Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE));
    public static final MossyTempleFamily MOSSY_TEMPLE = new MossyTempleFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final NeoVitaeFamily NEOVITAE = new NeoVitaeFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final NetherBrickFamily NETHERBRICK = new NetherBrickFamily(Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final NetherrackFamily NETHERRACK = new NetherrackFamily(Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final NickelFamily NICKEL = new NickelFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final OakFamily OAK = new OakFamily(Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final PaleOakFamily PALE_OAK = new PaleOakFamily(Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS));
    public static final ObsidianFamily OBSIDIAN = new ObsidianFamily(Properties.ofFullCopy(Blocks.OBSIDIAN));
    public static final PaperwallFamily PAPERWALL = new PaperwallFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final PlatinumFamily PLATINUM = new PlatinumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final PrismarineFamily PRISMARINE = new PrismarineFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final PumpkinFamily PUMPKIN = new PumpkinFamily(Properties.ofFullCopy(Blocks.PUMPKIN));
    public static final PurpurFamily PURPUR = new PurpurFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final RedSandstoneFamily RED_SANDSTONE = new RedSandstoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final RedstoneFamily REDSTONE = new RedstoneFamily(Properties.ofFullCopy(Blocks.REDSTONE_BLOCK));
    public static final RedstoneLampFamily REDSTONE_LAMP = new RedstoneLampFamily(Properties.ofFullCopy(Blocks.REDSTONE_LAMP));
    public static final RoadLineFamily ROAD_LINE = new RoadLineFamily(Properties.ofFullCopy(Blocks.STONE).noOcclusion().noCollision());
    public static final SandstoneFamily SANDSTONE = new SandstoneFamily(Properties.ofFullCopy(Blocks.SANDSTONE));
    public static final ShingleFamily SHINGLE = new ShingleFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final SilverFamily SILVER = new SilverFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final SpruceFamily SPRUCE = new SpruceFamily(Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final SteelFamily STEEL = new SteelFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final StoneBricksFamily STONE_BRICKS = new StoneBricksFamily(Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final TallowFamily TALLOW = new TallowFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final TechnicalFamily TECHNICAL = new TechnicalFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TempleFamily TEMPLE = new TempleFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final TerracottaFamily TERRACOTTA = new TerracottaFamily(Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final ThaumiumFamily THAUMIUM = new ThaumiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TinFamily TIN = new TinFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final TorchFamily TORCH = new TorchFamily(Properties.ofFullCopy(Blocks.TORCH));
    public static final TyrianFamily TYRIAN = new TyrianFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final UraniumFamily URANIUM = new UraniumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final ValentinesFamily VALENTINES = new ValentinesFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final VoidstoneFamily VOIDSTONE = new VoidstoneFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final WarningFamily WARNING = new WarningFamily(Properties.ofFullCopy(Blocks.STONE));
    public static final WaterstoneFamily WATERSTONE = new WaterstoneFamily(Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final WoolenClayFamily WOOLEN_CLAY = new WoolenClayFamily(Properties.ofFullCopy(Blocks.CLAY));

    public static final List<WoolFamily> WOOLS = new ArrayList<>();
    public static final List<StainedGlassFamily> STAINED_GLASS = new ArrayList<>();
    public static final List<StainedGlassPaneFamily> STAINED_GLASS_PANE = new ArrayList<>();

    static {
        for (DyeColor color : DyeColor.values()) {
            WOOLS.add(new WoolFamily(Properties.ofFullCopy(getVanillaWool(color)), color.getName(), getVanillaWool(color)));
            STAINED_GLASS.add(new StainedGlassFamily(Properties.ofFullCopy(Blocks.GLASS), color.getName(), getVanillaStainedGlass(color)));
            STAINED_GLASS_PANE.add(new StainedGlassPaneFamily(Properties.ofFullCopy(Blocks.GLASS_PANE), color, getVanillaStainedGlassPane(color)));
        }
    }

    public static final DeferredBlock<Block> AUTO_CHISEL = BLOCKS.registerBlock("auto_chisel", AutoChiselBlock::new, () -> Properties.of()
            .sound(SoundType.METAL)
            .strength(2.5F)
            .noOcclusion()
            .requiresCorrectToolForDrops());

    public static final DeferredBlock<Block> BUILDERS_GUIDE = BLOCKS.registerBlock("builders_guide", BuildersGuideBlock::new, () -> Properties.of()
            .sound(SoundType.METAL)
            .strength(2.5F)
            .requiresCorrectToolForDrops());

    private static Block getVanillaWool(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_WOOL;
            case ORANGE -> Blocks.ORANGE_WOOL;
            case MAGENTA -> Blocks.MAGENTA_WOOL;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
            case YELLOW -> Blocks.YELLOW_WOOL;
            case LIME -> Blocks.LIME_WOOL;
            case PINK -> Blocks.PINK_WOOL;
            case GRAY -> Blocks.GRAY_WOOL;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
            case CYAN -> Blocks.CYAN_WOOL;
            case PURPLE -> Blocks.PURPLE_WOOL;
            case BLUE -> Blocks.BLUE_WOOL;
            case BROWN -> Blocks.BROWN_WOOL;
            case GREEN -> Blocks.GREEN_WOOL;
            case RED -> Blocks.RED_WOOL;
            case BLACK -> Blocks.BLACK_WOOL;
        };
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

    public static List<ChiselFamily> getBlocks() {
        List<ChiselFamily> blocks = new ArrayList<>(List.of(
                ACACIA, ALUMINUM, ANCIENT_STONE, ANDESITE, ANTIBLOCK, ARCANE, BAMBOO, BIRCH, BOOKSHELF, BRICKS, BRONZE,
                CERTUS, CHARCOAL, CLOUD, COAL, COAL_COKE, COBALT, COBBLESTONE, CONCRETE, COPPER, EXPOSED_COPPER, WEATHERED_COPPER, OXIDIZED_COPPER,
                CRIMSON, WARPED, DARK_OAK, CHERRY, BASALT, DIAMOND, DIORITE, DEEPSLATE, DIRT, ELECTRUM, EMERALD, END_STONE, ENERGIZED_VOIDSTONE,
                FACTORY, FUTURA, GLASS, GLASS_PANE, GLOWSTONE, GOLD, GRANITE, GRIMSTONE, HEX_PLATING, HOLYSTONE, ICE, INVAR, IRON, IRON_BARS,
                JACK_O_LANTERN, JUNGLE, MANGROVE, LABORATORY, LAPIS, LAVASTONE, LEAD, LEAF, LIMESTONE, MAGMA, MARBLE, MILITARY, MOSSY_COBBLESTONE,
                MOSSY_TEMPLE, NEOVITAE, NETHERBRICK, NETHERRACK, NICKEL, OAK, PALE_OAK, OBSIDIAN, PAPERWALL, PLATINUM, PRISMARINE, PUMPKIN,
                PURPUR, RED_SANDSTONE, REDSTONE, REDSTONE_LAMP, ROAD_LINE, SANDSTONE, SHINGLE, SILVER, SPRUCE, STEEL,
                STONE_BRICKS, TALLOW, TECHNICAL, TEMPLE, TERRACOTTA, THAUMIUM, TIN, TORCH, TYRIAN, URANIUM, VALENTINES,
                VOIDSTONE, WARNING, WATERSTONE, WOOLEN_CLAY
        ));
        blocks.addAll(WOOLS);
        blocks.addAll(STAINED_GLASS);
        blocks.addAll(STAINED_GLASS_PANE);
        return blocks;
    }

    public static void registerBlocks(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public static DeferredBlock<Block> register(String name, Properties properties) {
        return BLOCKS.registerBlock(name, ConnectedTextureBlock::new, () -> properties);
    }

    public static DeferredBlock<Block> register(String name, Function<Properties, ? extends Block> func, Supplier<Properties> properties) {
        return BLOCKS.registerBlock(name, func, properties);
    }
}
