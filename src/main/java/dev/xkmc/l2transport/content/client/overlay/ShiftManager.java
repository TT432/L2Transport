package dev.xkmc.l2transport.content.client.overlay;

import net.minecraft.client.gui.screens.Screen;

public class ShiftManager {

	public static boolean isAlternate() {
		return Screen.hasAltDown();
	}

}
