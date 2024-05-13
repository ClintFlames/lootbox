
package kineticcraft.lootbox.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import kineticcraft.lootbox.world.inventory.LootboxGuiT2Menu;
import kineticcraft.lootbox.procedures.LootboxOpenProcedure;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class LootboxGuiT2ButtonMessage extends FriendlyByteBuf {
	public LootboxGuiT2ButtonMessage(int buttonID, int x, int y, int z) {
		super(Unpooled.buffer());
		writeInt(buttonID);
		writeInt(x);
		writeInt(y);
		writeInt(z);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		int buttonID = buf.readInt();
		double x = buf.readInt();
		double y = buf.readInt();
		double z = buf.readInt();
		server.execute(() -> {
			Level world = entity.getLevel();
			HashMap guistate = LootboxGuiT2Menu.guistate;
			if (buttonID == 0) {

				LootboxOpenProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
			}
		});
	}
}
