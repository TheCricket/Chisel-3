package chisel.client.entity;

import chisel.block.entity.AutoChiselBlockEntity;
import chisel.client.entity.state.AutoChiselBlockEntityRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.jspecify.annotations.NonNull;

public class AutoChiselBlockEntityRenderer implements BlockEntityRenderer<AutoChiselBlockEntity, AutoChiselBlockEntityRenderState> {
    @Override
    public @NonNull AutoChiselBlockEntityRenderState createRenderState() {
        return new AutoChiselBlockEntityRenderState();
    }

    @Override
    public void submit(@NonNull AutoChiselBlockEntityRenderState state, @NonNull PoseStack pose, @NonNull SubmitNodeCollector submit, @NonNull CameraRenderState camera) {

    }
}
