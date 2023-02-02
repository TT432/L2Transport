package dev.xkmc.l2transport.content.tile.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.xkmc.l2library.base.overlay.OverlayUtils;
import dev.xkmc.l2library.util.Proxy;
import dev.xkmc.l2library.util.raytrace.RayTraceUtil;
import dev.xkmc.l2transport.content.tile.base.IRenderableNode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class OverlayRenderer extends GuiComponent implements IGuiOverlay {

	@Override
	public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
		if (Minecraft.getInstance().screen != null) return;
		LocalPlayer player = Proxy.getClientPlayer();
		if (player == null) return;
		var ray = RayTraceUtil.rayTraceBlock(player.level, player, player.getReachDistance());
		if (ray.getType() != HitResult.Type.BLOCK) return;
		BlockPos pos = ray.getBlockPos();
		BlockEntity entity = player.level.getBlockEntity(pos);
		if (entity instanceof IRenderableNode be) {
			OverlayUtils util = new OverlayUtils(screenWidth, screenHeight);
			util.renderLongText(gui, poseStack,
					screenWidth / 2 + 16, -1, screenWidth / 2 - 32,
					be.getTooltips().build());
		}
	}

}
