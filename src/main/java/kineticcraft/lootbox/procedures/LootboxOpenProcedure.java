package kineticcraft.lootbox.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import kineticcraft.lootbox.world.inventory.LootboxGuiT3Menu;
import kineticcraft.lootbox.world.inventory.LootboxGuiT2Menu;
import kineticcraft.lootbox.world.inventory.LootboxGuiT1Menu;
import kineticcraft.lootbox.init.LootboxModItems;
import kineticcraft.lootbox.LootboxMod;

import java.util.Map;

public class LootboxOpenProcedure {

	public static InteractionResult execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LootboxMod.LOGGER.warn("Failed to load dependency entity for procedure LootboxOpen!");
			return InteractionResult.PASS;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		ItemStack t1 = ItemStack.EMPTY;
		ItemStack t2 = ItemStack.EMPTY;
		ItemStack t3 = ItemStack.EMPTY;
		String lootname = "";
		String shulker_color = "";
		String lootname_title = "";
		t1 = new ItemStack(LootboxModItems.LOOTBOX_T1);
		t2 = new ItemStack(LootboxModItems.LOOTBOX_T2);
		t3 = new ItemStack(LootboxModItems.LOOTBOX_T3);
		if ((entity instanceof Player _plr ? _plr.containerMenu instanceof LootboxGuiT1Menu : false) && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(t1) : false)) {
			random = Math.floor(Mth.nextDouble(RandomSource.create(), 0, 11));
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = t1;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if ((entity instanceof Player _plr ? _plr.containerMenu instanceof LootboxGuiT2Menu : false) && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(t2) : false)) {
			random = Math.floor(Mth.nextDouble(RandomSource.create(), 0, 17));
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = t2;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if ((entity instanceof Player _plr ? _plr.containerMenu instanceof LootboxGuiT3Menu : false) && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(t3) : false)) {
			random = Math.floor(Mth.nextDouble(RandomSource.create(), 0, 43));
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = t3;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("tellraw @s \"%NS%\"".replace("%NS%", Component.translatable("translation.key.noshulker").getString())));
				}
			}
			return InteractionResult.CONSUME;
		}
		if (random < 11) {
			shulker_color = "light_purple";
		} else if (random < 17) {
			shulker_color = "aqua";
		} else if (random < 43) {
			shulker_color = "yellow";
		}
		if (random == 0) {
			lootname = "ancient_city";
		} else if (random == 1) {
			lootname = "abandoned_mineshaft";
		} else if (random == 2) {
			lootname = "buried_treasure";
		} else if (random == 3) {
			lootname = "bastion_hoglin_stable";
		} else if (random == 4) {
			lootname = "bastion_treasure";
		} else if (random == 5) {
			lootname = "bastion_other";
		} else if (random == 6) {
			lootname = "desert_pyramid";
		} else if (random == 7) {
			lootname = "pillager_outpost";
		} else if (random == 8) {
			lootname = "simple_dungeon";
		} else if (random == 9) {
			lootname = "stronghold_corridor";
		} else if (random == 10) {
			lootname = "woodland_mansion";
		} else if (random == 11) {
			lootname = "bastion_bridge";
		} else if (random == 12) {
			lootname = "end_city_treasure";
		} else if (random == 13) {
			lootname = "jungle_temple";
		} else if (random == 14) {
			lootname = "nether_bridge";
		} else if (random == 15) {
			lootname = "shipwreck_treasure";
		} else if (random == 16) {
			lootname = "village/village_toolsmith";
		} else if (random == 17) {
			lootname = "ancient_city_ice_box";
		} else if (random == 18) {
			lootname = "igloo_chest";
		} else if (random == 19) {
			lootname = "jungle_temple_dispenser";
		} else if (random == 20) {
			lootname = "shipwreck_map";
		} else if (random == 21) {
			lootname = "shipwreck_supply";
		} else if (random == 22) {
			lootname = "spawn_bonus_chest";
		} else if (random == 23) {
			lootname = "stronghold_crossing";
		} else if (random == 24) {
			lootname = "stronghold_library";
		} else if (random == 25) {
			lootname = "underwater_ruin_big";
		} else if (random == 26) {
			lootname = "underwater_ruin_small";
		} else if (random == 27) {
			lootname = "village/village_armorer";
		} else if (random == 28) {
			lootname = "village/village_butcher";
		} else if (random == 29) {
			lootname = "village/village_cartographer";
		} else if (random == 30) {
			lootname = "village/village_desert_house";
		} else if (random == 31) {
			lootname = "village/village_fisher";
		} else if (random == 32) {
			lootname = "village/village_fletcher";
		} else if (random == 33) {
			lootname = "village/village_mason";
		} else if (random == 34) {
			lootname = "village/village_plains_house";
		} else if (random == 35) {
			lootname = "village/village_savanna_house";
		} else if (random == 36) {
			lootname = "village/village_shepherd";
		} else if (random == 37) {
			lootname = "village/village_snowy_house";
		} else if (random == 38) {
			lootname = "village/village_taiga_house";
		} else if (random == 39) {
			lootname = "village/village_tannery";
		} else if (random == 40) {
			lootname = "village/village_temple";
		} else if (random == 41) {
			lootname = "village/village_toolsmith";
		} else if (random == 42) {
			lootname = "village/village_weaponsmith";
		} else {
			return InteractionResult.CONSUME;
		}
		lootname_title = lootname;
		if (lootname_title.startsWith("village/")) {
			lootname_title = lootname_title.substring(8);
		}
		lootname_title = (lootname_title.substring(0, 1)).toUpperCase() + "" + (lootname_title.replace("_", " ")).substring(1);
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level.getServer(), _ent),
						((("give @s minecraft:shulker_box{BlockEntityTag:{LootTable:\"chests/%LT%\"},display:{Name:'[{\"text\":\"%NAME%\",\"italic\":false,\"color\":\"%COLOR%\"}]'}}".replace("%LT%", lootname)).replace("%COLOR%", shulker_color))
								.replace("%NAME%", lootname_title)));
			}
		}
		return InteractionResult.SUCCESS;
	}
}
