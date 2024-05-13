
package kineticcraft.lootbox.item.inventory;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class LootboxT2Inventory implements WorldlyContainer {
	private final ItemStack stack;
	private final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

	public LootboxT2Inventory(ItemStack stack) {
		this.stack = stack;
		CompoundTag tag = stack.getTagElement("Items");
		if (tag != null) {
			ContainerHelper.loadAllItems(tag, items);
		}
	}

	public NonNullList<ItemStack> getItems() {
		return items;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		int[] result = new int[getItems().size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction dir) {
		return true;
	}

	@Override
	public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
		return true;
	}

	@Override
	public int getContainerSize() {
		return getItems().size();
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < getContainerSize(); i++) {
			ItemStack stack = getItem(i);
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getItem(int slot) {
		return getItems().get(slot);
	}

	@Override
	public ItemStack removeItem(int slot, int amount) {
		ItemStack result = ContainerHelper.removeItem(getItems(), slot, amount);
		if (!result.isEmpty()) {
			setChanged();
		}
		return result;
	}

	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ContainerHelper.takeItem(getItems(), slot);
	}

	@Override
	public void setItem(int slot, ItemStack stack) {
		getItems().set(slot, stack);
		if (stack.getCount() > getMaxStackSize()) {
			stack.setCount(getMaxStackSize());
		}
	}

	@Override
	public void setChanged() {
		CompoundTag tag = stack.getOrCreateTagElement("Items");
		ContainerHelper.saveAllItems(tag, items);
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public void clearContent() {
		getItems().clear();
	}
}
