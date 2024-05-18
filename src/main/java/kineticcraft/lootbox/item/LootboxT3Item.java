
package kineticcraft.lootbox.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import kineticcraft.lootbox.procedures.LootboxOpenNoGuiProcedure;
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
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		return LootboxOpenNoGuiProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", context.getPlayer()).build());
	}
}
