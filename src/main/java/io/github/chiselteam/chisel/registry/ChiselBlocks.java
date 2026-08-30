package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.AutoChiselBlock;
import io.github.chiselteam.chisel.block.BuildersGuideBlock;
import io.github.chiselteam.chisel.block.family.*;
import io.github.chiselteam.chisel.block.family.compat.*;
import io.github.chiselteam.chisel.block.family.compat.materials.*;
import io.github.chiselteam.chisel.block.family.materials.*;
import io.github.chiselteam.chisel.block.family.materials.copper.*;
import io.github.chiselteam.chisel.block.family.stone.*;
import io.github.chiselteam.chisel.block.family.wood.*;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ConnectedTextureBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ChiselBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chisel.MODID);
    private static final List<ChiselFamily> families = new ArrayList<>();

// -----------------Vanilla blocks-----------------
// Wood
    public static final AcaciaFamily ACACIA = registerFamily(new AcaciaFamily(Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final CrimsonFamily CRIMSON = registerFamily(new CrimsonFamily(Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final WarpedFamily WARPED = registerFamily(new WarpedFamily(Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final SpruceFamily SPRUCE = registerFamily(new SpruceFamily(Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DarkOakFamily DARK_OAK = registerFamily(new DarkOakFamily(Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final CherryFamily CHERRY = registerFamily(new CherryFamily(Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final BambooFamily BAMBOO = registerFamily(new BambooFamily(Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final BirchFamily BIRCH = registerFamily(new BirchFamily(Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final JungleFamily JUNGLE = registerFamily(new JungleFamily(Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final MangroveFamily MANGROVE = registerFamily(new MangroveFamily(Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final OakFamily OAK = registerFamily(new OakFamily(Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final PaleOakFamily PALE_OAK = registerFamily(new PaleOakFamily(Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS)));
    public static final LeafFamily LEAF = registerFamily(new LeafFamily(Properties.ofFullCopy(Blocks.OAK_LEAVES)));

// Others
    public static final AndesiteFamily ANDESITE = registerFamily(new AndesiteFamily(Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final BlackstoneFamily BLACKSTONE = registerFamily(new BlackstoneFamily(Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final GildedBlackstoneFamily GILDED_BLACKSTONE = registerFamily(new GildedBlackstoneFamily(Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final BookshelfFamily BOOKSHELF = registerFamily(new BookshelfFamily(Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final BricksFamily BRICKS = registerFamily(new BricksFamily(Properties.ofFullCopy(Blocks.BRICKS)));
    public static final CobblestoneFamily COBBLESTONE = registerFamily(new CobblestoneFamily(Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final CopperFamily COPPER = registerFamily(new CopperFamily(Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final ExposedCopperFamily EXPOSED_COPPER = registerFamily(new ExposedCopperFamily(Properties.ofFullCopy(Blocks.EXPOSED_COPPER)));
    public static final WeatheredCopperFamily WEATHERED_COPPER = registerFamily(new WeatheredCopperFamily(Properties.ofFullCopy(Blocks.WEATHERED_COPPER)));
    public static final OxidizedCopperFamily OXIDIZED_COPPER = registerFamily(new OxidizedCopperFamily(Properties.ofFullCopy(Blocks.OXIDIZED_COPPER)));
    public static final BasaltFamily BASALT = registerFamily(new BasaltFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final DioriteFamily DIORITE = registerFamily(new DioriteFamily(Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeepslateFamily DEEPSLATE = registerFamily(new DeepslateFamily(Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DirtFamily DIRT = registerFamily(new DirtFamily(Properties.ofFullCopy(Blocks.DIRT)));
    public static final EndStoneFamily END_STONE = registerFamily(new EndStoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final GlowstoneFamily GLOWSTONE = registerFamily(new GlowstoneFamily(Properties.ofFullCopy(Blocks.GLOWSTONE)));
    public static final SeaLanternFamily SEA_LANTERN = registerFamily(new SeaLanternFamily(Properties.ofFullCopy(Blocks.SEA_LANTERN)));
    public static final GraniteFamily GRANITE = registerFamily(new GraniteFamily(Properties.ofFullCopy(Blocks.GRANITE)));
    public static final TorchFamily TORCH = registerFamily(new TorchFamily(Properties.ofFullCopy(Blocks.TORCH)));
    public static final IronBarsFamily IRON_BARS = registerFamily(new IronBarsFamily(Properties.ofFullCopy(Blocks.IRON_BARS)));
    public static final GlassFamily GLASS = registerFamily(new GlassFamily(Properties.ofFullCopy(Blocks.GLASS)));
    public static final GlassPaneFamily GLASS_PANE = registerFamily(new GlassPaneFamily(Properties.ofFullCopy(Blocks.GLASS_PANE)));
    public static final MagmaFamily MAGMA = registerFamily(new MagmaFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final MossyCobblestoneFamily MOSSY_COBBLESTONE = registerFamily(new MossyCobblestoneFamily(Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final NetherBrickFamily NETHERBRICK = registerFamily(new NetherBrickFamily(Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final NetherrackFamily NETHERRACK = registerFamily(new NetherrackFamily(Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final IceFamily ICE = registerFamily(new IceFamily(Properties.ofFullCopy(Blocks.ICE)));
    public static final ObsidianFamily OBSIDIAN = registerFamily(new ObsidianFamily(Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final QuartzFamily QUARTZ = registerFamily(new QuartzFamily(Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final PrismarineFamily PRISMARINE = registerFamily(new PrismarineFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final PumpkinFamily PUMPKIN = registerFamily(new PumpkinFamily(Properties.ofFullCopy(Blocks.PUMPKIN)));
    public static final JackOLanternFamily JACK_O_LANTERN = registerFamily(new JackOLanternFamily(Properties.ofFullCopy(Blocks.JACK_O_LANTERN)));
    public static final PurpurFamily PURPUR = registerFamily(new PurpurFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final RedSandstoneFamily RED_SANDSTONE = registerFamily(new RedSandstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final RedstoneLampFamily REDSTONE_LAMP = registerFamily(new RedstoneLampFamily(Properties.ofFullCopy(Blocks.REDSTONE_LAMP)));
    public static final SandstoneFamily SANDSTONE = registerFamily(new SandstoneFamily(Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final StoneBricksFamily STONE_BRICKS = registerFamily(new StoneBricksFamily(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final TerracottaFamily TERRACOTTA = registerFamily(new TerracottaFamily(Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final WoolenClayFamily WOOLEN_CLAY = registerFamily(new WoolenClayFamily(Properties.ofFullCopy(Blocks.CLAY)));
    public static final CoalFamily COAL = registerFamily(new CoalFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final IronFamily IRON = registerFamily(new IronFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final GoldFamily GOLD = registerFamily(new GoldFamily(Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final RedstoneFamily REDSTONE = registerFamily(new RedstoneFamily(Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final LapisFamily LAPIS = registerFamily(new LapisFamily(Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final EmeraldFamily EMERALD = registerFamily(new EmeraldFamily(Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
    public static final DiamondFamily DIAMOND = registerFamily(new DiamondFamily(Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final NetheriteFamily NETHERITE = registerFamily(new NetheriteFamily(Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
    public static final TuffFamily TUFF = registerFamily(new TuffFamily(Properties.ofFullCopy(Blocks.TUFF)));
    public static final CalciteFamily CALCITE = registerFamily(new CalciteFamily(Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DripstoneFamily DRIPSTONE = registerFamily(new DripstoneFamily(Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final MudFamily MUD = registerFamily(new MudFamily(Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final ResinFamily RESIN = registerFamily(new ResinFamily(Properties.ofFullCopy(Blocks.RESIN_BRICKS)));

// -----------------Custom blocks-----------------
    public static final GrimstoneFamily GRIMSTONE = registerFamily(new GrimstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final HolystoneFamily HOLYSTONE = registerFamily(new HolystoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final FuturaFamily FUTURA = registerFamily(new FuturaFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final HexPlatingFamily HEX_PLATING = registerFamily(new HexPlatingFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final LimestoneFamily LIMESTONE = registerFamily(new LimestoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final CConcreteFamily C_CONCRETE = registerFamily(new CConcreteFamily(Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final CloudFamily CLOUD = registerFamily(new CloudFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion()));
    public static final MarbleFamily MARBLE = registerFamily(new MarbleFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final TempleFamily TEMPLE = registerFamily(new TempleFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final MossyTempleFamily MOSSY_TEMPLE = registerFamily(new MossyTempleFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final ShingleFamily SHINGLE = registerFamily(new ShingleFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final LaboratoryFamily LABORATORY = registerFamily(new LaboratoryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final FactoryFamily FACTORY = registerFamily(new FactoryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final LavastoneFamily LAVASTONE = registerFamily(new LavastoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final MilitaryFamily MILITARY = registerFamily(new MilitaryFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final MossyBlackstoneFamily MOSSY_BLACKSTONE = registerFamily(new MossyBlackstoneFamily(Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final AntiblockFamily ANTIBLOCK = registerFamily(new AntiblockFamily(Properties.of().mapColor(MapColor.STONE).strength(3.0F, 5.0F).requiresCorrectToolForDrops().lightLevel((_) -> 15)));
    public static final TyrianFamily TYRIAN = registerFamily(new TyrianFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final EnergizedVoidstoneFamily ENERGIZED_VOIDSTONE = registerFamily(new EnergizedVoidstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final PaperwallFamily PAPERWALL = registerFamily(new PaperwallFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final ValentinesFamily VALENTINES = registerFamily(new ValentinesFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final VoidstoneFamily VOIDSTONE = registerFamily(new VoidstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final WarningFamily WARNING = registerFamily(new WarningFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final WaterstoneFamily WATERSTONE = registerFamily(new WaterstoneFamily(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final RoadLineFamily ROAD_LINE = registerFamily(new RoadLineFamily(Properties.ofFullCopy(Blocks.STONE).noOcclusion().noCollision()));
    public static final TechnicalFamily TECHNICAL = registerFamily(new TechnicalFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final CreatorFamily CREATOR = registerFamily(new CreatorFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));


// -----------------Modded blocks-----------------
// Materials
    public static final AluminumFamily ALUMINUM = registerFamily(new AluminumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final SilverFamily SILVER = registerFamily(new SilverFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final BronzeFamily BRONZE = registerFamily(new BronzeFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final BrassFamily BRASS = registerFamily(new BrassFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final CharcoalFamily CHARCOAL = registerFamily(new CharcoalFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final TinFamily TIN = registerFamily(new TinFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final LeadFamily LEAD = registerFamily(new LeadFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final CobaltFamily COBALT = registerFamily(new CobaltFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final PlatinumFamily PLATINUM = registerFamily(new PlatinumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final NickelFamily NICKEL = registerFamily(new NickelFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final InvarFamily INVAR = registerFamily(new InvarFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final CoalCokeFamily COAL_COKE = registerFamily(new CoalCokeFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final SteelFamily STEEL = registerFamily(new SteelFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ElectrumFamily ELECTRUM = registerFamily(new ElectrumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final UraniumFamily URANIUM = registerFamily(new UraniumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));

// other
    public static final ThaumiumFamily THAUMIUM = registerFamily(new ThaumiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final AncientStoneFamily ANCIENT_STONE = registerFamily(new AncientStoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final FAArcaneDarkstoneFamily FA_ARCANE_DARKSTONE = registerFamily(new FAArcaneDarkstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final FADarkstoneFamily FA_DARKSTONE = registerFamily(new FADarkstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final OCTallowFamily OC_TALLOW = registerFamily(new OCTallowFamily(Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final OCOtherrockFamily OC_OTHERROCK = registerFamily(new OCOtherrockFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final OCOtherstoneFamily OC_OTHERSTONE = registerFamily(new OCOtherstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final MASoulstoneFamily MA_SOULSTONE = registerFamily(new MASoulstoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVDungeonStoneFamily NV_DUNGEON_STONE = registerFamily(new NVDungeonStoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVDungeonStoneInvictusFamily NV_DUNGEON_STONE_INVICTUS = registerFamily(new NVDungeonStoneInvictusFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVDungeonStoneNihilumFamily NV_DUNGEON_STONE_NIHILUM = registerFamily(new NVDungeonStoneNihilumFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVDungeonStoneRuinaFamily NV_DUNGEON_STONE_RUINA = registerFamily(new NVDungeonStoneRuinaFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVDungeonStoneVindictaFamily NV_DUNGEON_STONE_VINDICTA = registerFamily(new NVDungeonStoneVindictaFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVRitualStoneFamily NV_RITUAL_STONE = registerFamily(new NVRitualStoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final NVRuneFamily NV_RUNE = registerFamily(new NVRuneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final ATMAllthemodiumFamily ATM_ALLTHEMODIUM = registerFamily(new ATMAllthemodiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ATMUnobtainiumAllthemodiumFamily ATM_UNOBTAINIUM_ALLTHEMODIUM = registerFamily(new ATMUnobtainiumAllthemodiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ATMUnobtainiumFamily ATM_UNOBTAINIUM = registerFamily(new ATMUnobtainiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ATMUnobtainiumVibraniumFamily ATM_UNOBTAINIUM_VIBRANIUM = registerFamily(new ATMUnobtainiumVibraniumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ATMVibraniumAllthemodiumFamily ATM_VIBRANIUM_ALLTHEMODIUM = registerFamily(new ATMVibraniumAllthemodiumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final ATMVibraniumFamily ATM_VIBRANIUM = registerFamily(new ATMVibraniumFamily(Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final AIIAgiositeFamily AII_AGIOSITE = registerFamily(new AIIAgiositeFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIAmberootFamily AII_AMBEROOT = registerFamily(new AIIAmberootFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIFadedHolystoneFamily AII_FADED_HOLYSTONE = registerFamily(new AIIFadedHolystoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIHolystoneFamily AII_HOLYSTONE = registerFamily(new AIIHolystoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIIcestoneFamily AII_ICESTONE = registerFamily(new AIIIcestoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIIchoriteFamily AII_CHORITE = registerFamily(new AIIIchoriteFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIMarbledFamily AII_MARBLED = registerFamily(new AIIMarbledFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIISkyrootFamily AII_SKYROOT = registerFamily(new AIISkyrootFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIUndershaleFamily AII_UNDERSHALE = registerFamily(new AIIUndershaleFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIWisprootFamily AII_WISPROOT = registerFamily(new AIIWisprootFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AIIGreatrootFamily AII_GREATROOT = registerFamily(new AIIGreatrootFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AE2CertusFamily AE2_CERTUS = registerFamily(new AE2CertusFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final AE2Certus2Family AE2_CERTUS2 = registerFamily(new AE2Certus2Family(Properties.ofFullCopy(Blocks.STONE)));
    public static final AE2SkyStoneFamily AE2_SKY_STONE = registerFamily(new AE2SkyStoneFamily(Properties.ofFullCopy(Blocks.STONE)));
    public static final IAFDreadstoneFamily iaf_dreadstone = registerFamily(new IAFDreadstoneFamily(Properties.ofFullCopy(Blocks.STONE)));


// -----------------Color blocks-----------------
    public static final List<WoolFamily> WOOLS = new ArrayList<>();
    public static final List<ConcreteFamily> CONCRETE = new ArrayList<>();
    public static final List<StainedGlassFamily> STAINED_GLASS = new ArrayList<>();
    public static final List<StainedGlassPaneFamily> STAINED_GLASS_PANE = new ArrayList<>();


    static {
        for (DyeColor color : DyeColor.values()) {
            WOOLS.add(registerFamily(new WoolFamily(Properties.ofFullCopy(getVanillaWool(color)), color.getName(), getVanillaWool(color))));
            CONCRETE.add(registerFamily(new ConcreteFamily(Properties.ofFullCopy(getVanillaConcrete(color)), color.getName(), getVanillaConcrete(color))));
            STAINED_GLASS.add(registerFamily(new StainedGlassFamily(Properties.ofFullCopy(Blocks.GLASS), color.getName(), getVanillaStainedGlass(color))));
            STAINED_GLASS_PANE.add(registerFamily(new StainedGlassPaneFamily(Properties.ofFullCopy(Blocks.GLASS_PANE), color, getVanillaStainedGlassPane(color))));
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

    private static Block getVanillaConcrete(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CONCRETE;
            case BLUE -> Blocks.BLUE_CONCRETE;
            case BROWN -> Blocks.BROWN_CONCRETE;
            case CYAN -> Blocks.CYAN_CONCRETE;
            case GRAY -> Blocks.GRAY_CONCRETE;
            case GREEN -> Blocks.GREEN_CONCRETE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CONCRETE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CONCRETE;
            case LIME -> Blocks.LIME_CONCRETE;
            case MAGENTA -> Blocks.MAGENTA_CONCRETE;
            case ORANGE -> Blocks.ORANGE_CONCRETE;
            case PINK -> Blocks.PINK_CONCRETE;
            case PURPLE -> Blocks.PURPLE_CONCRETE;
            case RED -> Blocks.RED_CONCRETE;
            case WHITE -> Blocks.WHITE_CONCRETE;
            case YELLOW -> Blocks.YELLOW_CONCRETE;
        };
    }

    public static List<ChiselFamily> getFamilies() {
        return families;
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

    private static <F extends ChiselFamily> F registerFamily(F family) {
        families.add(family);
        return family;
    }
}
