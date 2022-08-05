package net.dasturv.dasturvbrews.screen.slot;

import net.dasturv.dasturvbrews.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class ModCupSlot extends Slot {
    public ModCupSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (stack.getItem() == ModItems.TEA_CUP) {
            return true;
        }
        return false;
    }
}
