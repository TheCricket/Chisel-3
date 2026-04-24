package chisel.client.entity.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class AutoChiselBlockEntityRenderState extends BlockEntityRenderState {

    public ItemStackRenderState chisel;
    public ItemStackRenderState[] upgrades;
    public ItemStackRenderState block;
}
