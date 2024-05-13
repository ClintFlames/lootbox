
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package kineticcraft.lootbox.init;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import kineticcraft.lootbox.item.LootboxT3Item;
import kineticcraft.lootbox.item.LootboxT2Item;
import kineticcraft.lootbox.item.LootboxT1Item;
import kineticcraft.lootbox.LootboxMod;

public class LootboxModItems {
	public static Item LOOTBOX_T3;
	public static Item LOOTBOX_T2;
	public static Item LOOTBOX_T1;

	public static void load() {
		LOOTBOX_T3 = Registry.register(Registry.ITEM, new ResourceLocation(LootboxMod.MODID, "lootbox_t3"), new LootboxT3Item());
		LOOTBOX_T2 = Registry.register(Registry.ITEM, new ResourceLocation(LootboxMod.MODID, "lootbox_t2"), new LootboxT2Item());
		LOOTBOX_T1 = Registry.register(Registry.ITEM, new ResourceLocation(LootboxMod.MODID, "lootbox_t1"), new LootboxT1Item());
	}
}
