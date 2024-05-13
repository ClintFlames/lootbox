
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package kineticcraft.lootbox.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

import kineticcraft.lootbox.world.inventory.LootboxGuiT3Menu;
import kineticcraft.lootbox.world.inventory.LootboxGuiT2Menu;
import kineticcraft.lootbox.world.inventory.LootboxGuiT1Menu;
import kineticcraft.lootbox.LootboxMod;

public class LootboxModMenus {
	public static MenuType<LootboxGuiT2Menu> LOOTBOX_GUI_T2;
	public static MenuType<LootboxGuiT3Menu> LOOTBOX_GUI_T3;
	public static MenuType<LootboxGuiT1Menu> LOOTBOX_GUI_T1;

	public static void load() {
		LOOTBOX_GUI_T2 = Registry.register(Registry.MENU, new ResourceLocation(LootboxMod.MODID, "lootbox_gui_t2"), new ExtendedScreenHandlerType<>(LootboxGuiT2Menu::new));
		LootboxGuiT2Menu.screenInit();
		LOOTBOX_GUI_T3 = Registry.register(Registry.MENU, new ResourceLocation(LootboxMod.MODID, "lootbox_gui_t3"), new ExtendedScreenHandlerType<>(LootboxGuiT3Menu::new));
		LootboxGuiT3Menu.screenInit();
		LOOTBOX_GUI_T1 = Registry.register(Registry.MENU, new ResourceLocation(LootboxMod.MODID, "lootbox_gui_t1"), new ExtendedScreenHandlerType<>(LootboxGuiT1Menu::new));
		LootboxGuiT1Menu.screenInit();
	}
}
