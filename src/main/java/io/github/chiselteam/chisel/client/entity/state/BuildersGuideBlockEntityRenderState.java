package io.github.chiselteam.chisel.client.entity.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;

import java.util.Collections;
import java.util.List;

public class BuildersGuideBlockEntityRenderState extends BlockEntityRenderState {
    public List<BlockPos> ghostBlocks = Collections.emptyList();
    public BlockPos origin = BlockPos.ZERO;
    public DyeColor color = DyeColor.WHITE;
}
