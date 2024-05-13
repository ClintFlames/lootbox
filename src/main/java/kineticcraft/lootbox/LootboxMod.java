/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package kineticcraft.lootbox;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

import kineticcraft.lootbox.init.LootboxModTabs;
import kineticcraft.lootbox.init.LootboxModProcedures;
import kineticcraft.lootbox.init.LootboxModMenus;
import kineticcraft.lootbox.init.LootboxModItems;

public class LootboxMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "lootbox";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing LootboxMod");

		LootboxModTabs.load();

		LootboxModItems.load();

		LootboxModProcedures.load();

		LootboxModMenus.load();

	}
}
