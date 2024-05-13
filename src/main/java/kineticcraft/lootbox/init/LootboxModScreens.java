
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package kineticcraft.lootbox.init;

import net.minecraft.client.gui.screens.MenuScreens;

import kineticcraft.lootbox.client.gui.LootboxGuiT3Screen;
import kineticcraft.lootbox.client.gui.LootboxGuiT2Screen;
import kineticcraft.lootbox.client.gui.LootboxGuiT1Screen;

public class LootboxModScreens {
	public static void load() {
		MenuScreens.register(LootboxModMenus.LOOTBOX_GUI_T2, LootboxGuiT2Screen::new);
		MenuScreens.register(LootboxModMenus.LOOTBOX_GUI_T3, LootboxGuiT3Screen::new);
		MenuScreens.register(LootboxModMenus.LOOTBOX_GUI_T1, LootboxGuiT1Screen::new);
	}
}
