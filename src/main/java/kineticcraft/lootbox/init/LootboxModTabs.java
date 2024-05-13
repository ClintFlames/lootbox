
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package kineticcraft.lootbox.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public class LootboxModTabs {
	public static CreativeModeTab TAB_LOOTBOXES;

	public static void load() {
		TAB_LOOTBOXES = FabricItemGroupBuilder.create(new ResourceLocation("lootbox", "lootboxes")).icon(() -> new ItemStack(LootboxModItems.LOOTBOX_T1)).build();
	}
}
