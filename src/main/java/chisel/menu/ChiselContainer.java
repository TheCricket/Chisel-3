package chisel.menu;

import net.minecraft.world.SimpleContainer;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

public class ChiselContainer extends SimpleContainer {

    public ChiselContainer() {
        super(61);
    }

    @Override
    public void onTransfer(int slot, int amountChange, TransactionContext transaction) {
        if(slot == 60) {

        }
    }
}
