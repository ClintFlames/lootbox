
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package kineticcraft.lootbox.init;

import kineticcraft.lootbox.procedures.LootboxOpenProcedure;
import kineticcraft.lootbox.procedures.LootboxOpenNoGuiProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class LootboxModProcedures {
	public static void load() {
		new LootboxOpenNoGuiProcedure();
		new LootboxOpenProcedure();
	}
}
