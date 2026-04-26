package chisel.block.entity;

import chisel.core.variant.VariantFamily;
import chisel.registry.ChiselBlockEntities;
import chisel.registry.ChiselItemAbilities;
import chisel.registry.ChiselItems;
import chisel.util.VariantFinder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import java.util.logging.Logger;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class AutoChiselBlockEntity extends BlockEntity implements WorldlyContainer {

    public static final int INPUT_SLOTS = 12;
    public static final int TEMPLATE_SLOT = 12;
    public static final int CHISEL_SLOT = 13;
    public static final int OUTPUT_SLOTS = 12;
    public static final int STACK_UPGRADE_SLOT = 26;
    public static final int AUTOMATION_UPGRADE_SLOT = 27;
    public static final int REVERSION_UPGRADE_SLOT = 28;
    public static final int SPEED_UPGRADE_SLOT = 29;
    public static final int TOTAL_SLOTS = 30;

    private final NonNullList<ItemStack> items = NonNullList.withSize(TOTAL_SLOTS, ItemStack.EMPTY);

    private int progress = 0;
    private static final int MAX_PROGRESS = 100;

    // Data for UI highlighting
    // 0: progress, 1: template invalid, 2: chisel invalid, 3: reversion active
    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> AutoChiselBlockEntity.this.progress;
                case 1 -> isTemplateInvalid() ? 1 : 0;
                case 2 -> isChiselInvalid() ? 1 : 0;
                case 3 -> items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get()) ? 1 : 0;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            if (index == 0) {
                AutoChiselBlockEntity.this.progress = value;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public AutoChiselBlockEntity(BlockPos pos, BlockState state) {
        super(ChiselBlockEntities.AUTO_CHISEL.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AutoChiselBlockEntity blockEntity) {
        if (level.isClientSide()) return;

        if (blockEntity.canProcess()) {
            int speed = blockEntity.items.get(SPEED_UPGRADE_SLOT).is(ChiselItems.UPGRADE_SPEED.get()) ? 2 : 1;
            blockEntity.progress += speed;
            if (blockEntity.progress >= MAX_PROGRESS) {
                blockEntity.process();
                blockEntity.progress = 0;
            }
            blockEntity.setChanged();
        } else {
            if (blockEntity.shouldResetProgress()) {
                blockEntity.progress = 0;
                blockEntity.setChanged();
            }
        }
    }

    private boolean canProcess() {
        ItemStack template = items.get(TEMPLATE_SLOT);
        if (template.isEmpty() || !(template.getItem() instanceof BlockItem)) {
            // Reversion upgrade allows processing without template
            if (items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get())) {
                // We still need a family to revert to. We'll find it from the first valid input.
                return findValidReversionInputSlot() != -1 && !items.get(CHISEL_SLOT).isEmpty() && items.get(CHISEL_SLOT).canPerformAction(ChiselItemAbilities.CHISEL) && hasOutputSpace();
            }
            return false;
        }

        ItemStack chisel = items.get(CHISEL_SLOT);
        if (chisel.isEmpty() || !chisel.canPerformAction(ChiselItemAbilities.CHISEL)) return false;

        Block templateBlock = ((BlockItem) template.getItem()).getBlock();
        VariantFamily templateFamily = VariantFinder.getFamilyForBlock(templateBlock, level.registryAccess());
        if (templateFamily == null) return false;

        int inputSlot = findValidInputSlot(templateFamily);
        if (inputSlot == -1) return false;

        return hasOutputSpace();
    }

    private int findValidReversionInputSlot() {
        for (int i = 0; i < INPUT_SLOTS; i++) {
            ItemStack input = items.get(i);
            if (!input.isEmpty() && input.getItem() instanceof BlockItem blockItem) {
                if (VariantFinder.getFamilyForBlock(blockItem.getBlock(), level.registryAccess()) != null) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean shouldResetProgress() {
        boolean reversion = items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get());
        ItemStack template = items.get(TEMPLATE_SLOT);
        VariantFamily family = null;

        if (!template.isEmpty() && template.getItem() instanceof BlockItem blockItem) {
            family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), level.registryAccess());
        }

        // Reset if no template AND no reversion upgrade
        if (family == null && !reversion) return true;

        ItemStack chisel = items.get(CHISEL_SLOT);
        if (chisel.isEmpty() || !chisel.canPerformAction(ChiselItemAbilities.CHISEL)) return true;

        // Reset if current input is gone or changed
        int inputSlot = (family != null) ? findValidInputSlot(family) : findValidReversionInputSlot();
        if (inputSlot == -1) return true;

        if (!hasOutputSpace()) return true;

        return false;
    }

    private int findValidInputSlot(VariantFamily templateFamily) {
        for (int i = 0; i < INPUT_SLOTS; i++) {
            ItemStack input = items.get(i);
            if (!input.isEmpty() && input.getItem() instanceof BlockItem blockItem) {
                if (templateFamily.isBlockInFamily(blockItem.getBlock())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean hasOutputSpace() {
        for (int i = 14; i < 26; i++) {
            ItemStack out = items.get(i);
            if (out.isEmpty()) return true;
            if (ItemStack.isSameItemSameComponents(out, getOutputPreview()) && out.getCount() < out.getMaxStackSize()) {
                return true;
            }
        }
        return false;
    }

    public ItemStack getOutputPreview() {
        ItemStack template = items.get(TEMPLATE_SLOT);
        if (template.isEmpty()) {
            if (items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get())) {
                int inputSlot = findValidReversionInputSlot();
                if (inputSlot != -1) {
                    Block inputBlock = ((BlockItem) items.get(inputSlot).getItem()).getBlock();
                    VariantFamily family = VariantFinder.getFamilyForBlock(inputBlock, level.registryAccess());
                    if (family != null && !family.getVariants().isEmpty()) {
                        ItemStack output = new ItemStack(family.getVariants().get(0).getBlock());
                        output.setCount(1);
                        return output;
                    }
                }
            }
            return ItemStack.EMPTY;
        }

        if (items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get())) {
            Block templateBlock = ((BlockItem) template.getItem()).getBlock();
            VariantFamily family = VariantFinder.getFamilyForBlock(templateBlock, level.registryAccess());
            if (family != null && !family.getVariants().isEmpty()) {
                ItemStack output = new ItemStack(family.getVariants().get(0).getBlock());
                output.setCount(1);
                return output;
            }
        }

        ItemStack output = template.copy();
        output.setCount(1);
        return output;
    }

    private void process() {
        boolean reversion = items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get());
        ItemStack template = items.get(TEMPLATE_SLOT);
        VariantFamily family = null;

        if (!template.isEmpty() && template.getItem() instanceof BlockItem blockItem) {
            family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), level.registryAccess());
        }

        int inputSlot = (family != null) ? findValidInputSlot(family) : (reversion ? findValidReversionInputSlot() : -1);

        if (inputSlot != -1) {
            ItemStack input = items.get(inputSlot);
            if (family == null) {
                family = VariantFinder.getFamilyForBlock(((BlockItem) input.getItem()).getBlock(), level.registryAccess());
            }

            if (family == null) return;

            int countToProcess = 1;
            if (items.get(STACK_UPGRADE_SLOT).is(ChiselItems.UPGRADE_STACK.get())) {
                countToProcess = input.getCount();
                // Also limited by output space
                ItemStack preview = getOutputPreview();
                int space = getOutputSpaceFor(preview);
                countToProcess = Math.min(countToProcess, space);
                // Also limited by chisel durability
                ItemStack chisel = items.get(CHISEL_SLOT);
                if (!chisel.isDamageableItem()) {
                    // non-damageable chisel, no limit from durability
                } else {
                    int durability = chisel.getMaxDamage() - chisel.getDamageValue();
                    countToProcess = Math.min(countToProcess, durability);
                }
            }

            if (countToProcess <= 0) return;

            ItemStack outputStack = getOutputPreview();
            outputStack.setCount(countToProcess);

            input.shrink(countToProcess);

            for (int i = 14; i < 26; i++) {
                ItemStack existing = items.get(i);
                if (existing.isEmpty()) {
                    items.set(i, outputStack.copy());
                    outputStack.setCount(0);
                    break;
                } else if (ItemStack.isSameItemSameComponents(existing, outputStack) && existing.getCount() < existing.getMaxStackSize()) {
                    int growBy = Math.min(outputStack.getCount(), existing.getMaxStackSize() - existing.getCount());
                    existing.grow(growBy);
                    outputStack.shrink(growBy);
                    if (outputStack.isEmpty()) break;
                }
            }

            ItemStack chisel = items.get(CHISEL_SLOT);
            if (level instanceof ServerLevel serverLevel) {
                chisel.hurtAndBreak(countToProcess, serverLevel, null, _ -> {
                    items.set(CHISEL_SLOT, ItemStack.EMPTY);
                });
            }
        }
    }

    private int getOutputSpaceFor(ItemStack stack) {
        int totalSpace = 0;
        for (int i = 14; i < 26; i++) {
            ItemStack out = items.get(i);
            if (out.isEmpty()) {
                totalSpace += stack.getMaxStackSize();
            } else if (ItemStack.isSameItemSameComponents(out, stack)) {
                totalSpace += out.getMaxStackSize() - out.getCount();
            }
        }
        return totalSpace;
    }

    private boolean isTemplateInvalid() {
        ItemStack template = items.get(TEMPLATE_SLOT);
        if (template.isEmpty()) return false;
        if (!(template.getItem() instanceof BlockItem blockItem)) return true;

        if(level != null) {
            VariantFamily family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), level.registryAccess());
            if(family != null) {
                return findValidInputSlot(family) == -1;
            } else {
                return true;
            }
        }

        return true;
    }

    private boolean isChiselInvalid() {
        ItemStack chisel = items.get(CHISEL_SLOT);
        if (chisel.isEmpty()) return false;
        return !chisel.canPerformAction(ChiselItemAbilities.CHISEL);
    }

    public boolean isInputInvalid(int slot) {
        ItemStack input = items.get(slot);
        if (input.isEmpty()) return false;
        ItemStack template = items.get(TEMPLATE_SLOT);
        VariantFamily family = null;

        if (!template.isEmpty() && template.getItem() instanceof BlockItem templateBlockItem) {
            family = VariantFinder.getFamilyForBlock(templateBlockItem.getBlock(), level != null ? level.registryAccess() : null);
        }

        if (family == null) {
            if (items.get(REVERSION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_REVERSION.get())) {
                if (input.getItem() instanceof BlockItem inputBlockItem) {
                    return VariantFinder.getFamilyForBlock(inputBlockItem.getBlock(), level != null ? level.registryAccess() : null) == null;
                }
            }
            return true;
        }

        if (input.getItem() instanceof BlockItem inputBlockItem) {
            return !family.isBlockInFamily(inputBlockItem.getBlock());
        }
        return true;
    }

    @Override
    public int @NonNull [] getSlotsForFace(@NonNull Direction side) {
        if (side == Direction.DOWN) {
            int[] slots = new int[OUTPUT_SLOTS];
            for (int i = 0; i < OUTPUT_SLOTS; i++) slots[i] = 14 + i;
            return slots;
        } else {
            int[] slots = new int[INPUT_SLOTS];
            for (int i = 0; i < INPUT_SLOTS; i++) slots[i] = i;
            return slots;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NonNull ItemStack stack, @Nullable Direction side) {
        if (!items.get(AUTOMATION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_AUTOMATION.get())) return false;
        return index < INPUT_SLOTS;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NonNull ItemStack stack, @NonNull Direction side) {
        if (!items.get(AUTOMATION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_AUTOMATION.get())) return false;
        return index >= 14 && index < 26;
    }

    @Override
    public int getContainerSize() {
        return TOTAL_SLOTS;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : items) {
            if (!itemstack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public @NonNull ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public @NonNull ItemStack removeItem(int slot, int amount) {
        ItemStack result = ContainerHelper.removeItem(items, slot, amount);
        setChanged();
        if (level != null) {
            if (!level.isClientSide()) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            } else {
                requestModelDataUpdate();
            }
        }
        return result;
    }

    @Override
    public @NonNull ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, @NonNull ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
        setChanged();
        if (level != null) {
            if (!level.isClientSide()) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            } else {
                requestModelDataUpdate();
            }
        }
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        items.clear();
        setChanged();
        if (level != null) {
            if (!level.isClientSide()) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            } else {
                requestModelDataUpdate();
            }
        }
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput input) {
        super.loadAdditional(input);
        ContainerHelper.loadAllItems(input, items);
        progress = input.getIntOr("Progress", 0);
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, items);
        output.putInt("Progress", progress);
    }

    public ContainerData getData() {
        return data;
    }

    @Override
    public void onDataPacket(@NonNull Connection net, @NonNull ValueInput valueInput) {
        super.onDataPacket(net, valueInput);
        loadAdditional(valueInput);
        if (level != null && level.isClientSide()) {
            requestModelDataUpdate();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void handleUpdateTag(@NonNull ValueInput input) {
        super.handleUpdateTag(input);
        loadAdditional(input);
        if (level != null && level.isClientSide()) {
            requestModelDataUpdate();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NonNull CompoundTag getUpdateTag(HolderLookup.@NonNull Provider registries) {
        return saveWithoutMetadata(registries);
    }
}
