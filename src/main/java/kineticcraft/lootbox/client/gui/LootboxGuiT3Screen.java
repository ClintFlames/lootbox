
package kineticcraft.lootbox.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import kineticcraft.lootbox.world.inventory.LootboxGuiT3Menu;
import kineticcraft.lootbox.network.LootboxGuiT3ButtonMessage;
import kineticcraft.lootbox.LootboxMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LootboxGuiT3Screen extends AbstractContainerScreen<LootboxGuiT3Menu> {
	private final static HashMap<String, Object> guistate = LootboxGuiT3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_open;

	public LootboxGuiT3Screen(LootboxGuiT3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 125;
		this.imageHeight = 72;
	}

	private static final ResourceLocation texture = new ResourceLocation("lootbox:textures/screens/lootbox_gui_t3.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.lootbox.lootbox_gui_t3.label_lootbox_tier_3"), 23, 10, -171);
		this.font.draw(poseStack, Component.translatable("gui.lootbox.lootbox_gui_t3.label_loot_type_any"), 14, 28, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_open = new Button(this.leftPos + 14, this.topPos + 46, 99, 20, Component.translatable("gui.lootbox.lootbox_gui_t3.button_open"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(LootboxMod.MODID, "lootboxguit3_button_" + 0), new LootboxGuiT3ButtonMessage(0, x, y, z));
			}
		});
		guistate.put("button:button_open", button_open);
		this.addRenderableWidget(button_open);
	}
}
