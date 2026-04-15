package chisel.core.variant;

import chisel.client.model.CubeAllModel;
import chisel.client.model.MultiLayerModel;
import chisel.client.model.PillarModel;
import chisel.client.model.TopBottomSideModel;
import chisel.client.model.ctm.*;
import chisel.client.model.special.*;
import chisel.client.model.special.lavastone.LavastoneModel;
import chisel.client.model.special.lavastone.LavastoneTBSModel;
import chisel.client.model.special.waterstone.WaterstoneModel;
import chisel.client.model.special.waterstone.WaterstoneMultiblockModel;

public class VariantModels {
    public final TopBottomSideModel TOP_BOTTOM_SIDE = new TopBottomSideModel();

    public final CTMModel CTM = new CTMModel();
    public final CTMTBSModel CTM_TBS = new CTMTBSModel();
    public final CTMVModel CTMV = new CTMVModel();
    public final CTMHModel CTMH = new CTMHModel();

    public final CubeAllModel CUBE_ALL = new CubeAllModel();
    public final PillarModel PILLAR = new PillarModel();
    public final MultiLayerModel MULTI_LAYER = new MultiLayerModel();
    public final MultiLayerTBSModel MULTI_LAYER_TBS = new MultiLayerTBSModel();
    public final MultiLayerTBSTintedModel MULTI_LAYER_TBS_TINTED = new MultiLayerTBSTintedModel();
    public final MultiLayerCTMModel MULTI_LAYER_CTM = new MultiLayerCTMModel(false);
    public final MultiLayerCTMTintedModel MULTI_LAYER_CTM_TINTED = new MultiLayerCTMTintedModel();
    public final MultiLayerCTMModel MULTI_LAYER_CTM_GLOW = new MultiLayerCTMModel(true);
    public final WaterstoneModel WATERSTONE = new WaterstoneModel();
    public final BookshelfModel BOOKSHELF = new BookshelfModel();
    public final CarpetModel CARPET = new CarpetModel();
    public final GlassPaneModel GLASS_PANE = new GlassPaneModel();
    public final IronBarsModel IRON_BARS = new IronBarsModel();
    public final MossyModel MOSSY = new MossyModel();
    public final MossyTBSModel MOSSY_TOP_BOTTOM_SIDE = new MossyTBSModel();
    public final PumpkinModel PUMPKIN = new PumpkinModel();
    public final TorchModel TORCH = new TorchModel(false);
    public final TorchModel WALL_TORCH = new TorchModel(true);
    public final RoadLineModel ROAD_LINES = new RoadLineModel();
    public final V4Model V4 = new V4Model();

    public final Multiblock2x2Model MULTIBLOCK_2X2 = new Multiblock2x2Model();
    public final Multiblock3x3Model MULTIBLOCK_3X3 = new Multiblock3x3Model();
    public final Multiblock4x4Model MULTIBLOCK_4X4 = new Multiblock4x4Model();

    public final WaterstoneMultiblockModel WATERSTONE_2X2 = new WaterstoneMultiblockModel(2);
    public final WaterstoneMultiblockModel WATERSTONE_3X3 = new WaterstoneMultiblockModel(3);
    public final WaterstoneMultiblockModel WATERSTONE_4X4 = new WaterstoneMultiblockModel(4);


    public final LavastoneModel LAVASTONE = new LavastoneModel();
    public final LavastoneTBSModel LAVASTONE_TOP_BOTTOM_SIDE = new LavastoneTBSModel();
    public final WaterstoneMultiblockModel LAVASTONE_2X2 = new WaterstoneMultiblockModel(2);
    public final WaterstoneMultiblockModel LAVASTONE_3X3 = new WaterstoneMultiblockModel(3);
    public final WaterstoneMultiblockModel LAVASTONE_4X4 = new WaterstoneMultiblockModel(4);
}
