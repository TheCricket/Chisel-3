package chisel.core;

import chisel.core.model.*;
import chisel.core.model.ctm.*;
import chisel.core.model.special.BookshelfModel;
import chisel.core.model.special.CarpetModel;
import chisel.core.model.special.LavastoneModel;

public class VariantModels {
    public final TopBottomSideModel TOP_BOTTOM_SIDE = new TopBottomSideModel();
    public final CTMVTopBottomSide TOP_BOTTOM_SIDE_CTMV = new CTMVTopBottomSide();

    public final CTMModel CTM = new CTMModel();
    public final CTMVModel CTMV = new CTMVModel();
    public final CTMHModel CTMH = new CTMHModel();

    public final CubeAllModel CUBE_ALL = new CubeAllModel();
    public final PillarModel PILLAR = new PillarModel();
    public final MultiLayerModel MULTI_LAYER = new MultiLayerModel();
    public final MultiLayerCTMModel MULTI_LAYER_CTM = new MultiLayerCTMModel();
    public final LavastoneModel LAVASTONE = new LavastoneModel();
    public final BookshelfModel BOOKSHELF = new BookshelfModel();
    public final CarpetModel CARPET = new CarpetModel();
}
