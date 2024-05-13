
package kineticcraft.lootbox.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

import kineticcraft.lootbox.world.inventory.LootboxGuiT3Menu;
import kineticcraft.lootbox.item.inventory.LootboxT3Inventory;
import kineticcraft.lootbox.init.LootboxModTabs;

public class LootboxT3Item extends Item {
	public LootboxT3Item() {
		super(new Item.Properties().tab(LootboxModTabs.TAB_LOOTBOXES).stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		entity.openMenu(new ExtendedScreenHandlerFactory() {
			@Override
			public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
				return new LootboxGuiT3Menu(syncId, inventory, new LootboxT3Inventory(itemstack));
			}

			@Override
			public Component getDisplayName() {
				return itemstack.getDisplayName();
			}

			@Override
			public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
				buf.writeBlockPos(BlockPos.ZERO);
			}
		});
		return ar;
	}
}
