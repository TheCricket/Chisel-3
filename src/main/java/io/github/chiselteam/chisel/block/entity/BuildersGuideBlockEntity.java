package io.github.chiselteam.chisel.block.entity;

import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.registry.ChiselBlockEntities;
import io.github.chiselteam.chisel.registry.ChiselBuildingModes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;

public class BuildersGuideBlockEntity extends BlockEntity {

    private static final int MIN_DIM = 1;
    private static final int MAX_DIM = 64;
    private int length = 8;
    private int width  = 8;
    private int height = 8;

    private DyeColor color = DyeColor.WHITE;

    @NonNull
    private ChiselBuildingMode buildingMode = defaultMode();

    public BuildersGuideBlockEntity(BlockPos pos, BlockState state) {
        super(ChiselBlockEntities.BUILDERS_GUIDE.get(), pos, state);
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput input) {
        super.loadAdditional(input);
        length = clamp(input.getIntOr("length", 8));
        width  = clamp(input.getIntOr("width",  8));
        height = clamp(input.getIntOr("height", 8));

        Optional<String> modeId = input.getString("mode");
        if (modeId.isPresent()) {
            Identifier id = Identifier.tryParse(modeId.get());
            if (id != null) {
                ChiselBuildingModes.REGISTRY.getOptional(id).ifPresent(m -> this.buildingMode = m);
            }
        }
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("length", length);
        output.putInt("width",  width);
        output.putInt("height", height);
        output.putString("mode", buildingMode.getRegistryName().toString());
    }

    public void increaseLength() { setLength(length + 1); }
    public void increaseWidth()  { setWidth (width  + 1); }
    public void increaseHeight() { setHeight(height + 1); }
    public void decreaseLength() { setLength(length - 1); }
    public void decreaseWidth()  { setWidth (width  - 1); }
    public void decreaseHeight() { setHeight(height - 1); }

    public int getLength() { return length; }
    public int getWidth()  { return width;  }
    public int getHeight() { return height; }

    public void setLength(int value) { this.length = clamp(value); markDirty(); }
    public void setWidth (int value) { this.width  = clamp(value); markDirty(); }
    public void setHeight(int value) { this.height = clamp(value); markDirty(); }

    public DyeColor getColor() { return color; }
    public void setColor(DyeColor value) { this.color = value; markDirty(); }

    public @NonNull ChiselBuildingMode getBuildingMode() {
        return buildingMode;
    }

    public void setBuildingMode(@NonNull ChiselBuildingMode mode) {
        this.buildingMode = mode;
        markDirty();
    }

    public void cycleBuildingMode() {
        List<ChiselBuildingMode> modes = ChiselBuildingModes.REGISTRY.stream().toList();
        if (modes.isEmpty()) return;
        int idx = modes.indexOf(buildingMode);
        int next = (idx < 0) ? 0 : (idx + 1) % modes.size();
        setBuildingMode(modes.get(next));
    }

    public List<BlockPos> getGhostBlocks() {
        return buildingMode.getGhostBlocks(getBlockPos(), length, width, height);
    }

    public void placeBlock(Block block) {
        if (level != null) {
            buildingMode.getGhostBlocks(getBlockPos(), length, width, height);
            buildingMode.placeBlock(level, block);
        }
    }

    private static int clamp(int value) {
        return Math.clamp(value, MIN_DIM, MAX_DIM);
    }

    private void markDirty() {
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    private static @NonNull ChiselBuildingMode defaultMode() {
        return ChiselBuildingModes.REGISTRY.stream()
                .findFirst()
                .orElseGet(() -> new ChiselBuildingMode(Identifier.fromNamespaceAndPath("chisel", "empty")));
    }
}
