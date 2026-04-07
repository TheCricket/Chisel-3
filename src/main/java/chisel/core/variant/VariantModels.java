package chisel.core.variant;

import chisel.core.model.CubeAllModel;
import chisel.core.model.MultiLayerModel;
import chisel.core.model.PillarModel;
import chisel.core.model.TopBottomSideModel;
import chisel.core.model.ctm.*;
import chisel.core.model.special.*;

public class VariantModels {
    public final TopBottomSideModel TOP_BOTTOM_SIDE = new TopBottomSideModel();
    public final CTMVTopBottomSide TOP_BOTTOM_SIDE_CTMV = new CTMVTopBottomSide();

    public final CTMModel CTM = new CTMModel();
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
    public final LavastoneModel LAVASTONE = new LavastoneModel();
    public final LavastoneTBSModel LAVASTONE_TOP_BOTTOM_SIDE = new LavastoneTBSModel();
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
}
