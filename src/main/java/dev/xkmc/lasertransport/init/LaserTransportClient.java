package dev.xkmc.lasertransport.init;

import dev.xkmc.lasertransport.content.client.overlay.NodeInfoOverlay;
import dev.xkmc.lasertransport.content.client.overlay.NumberSetOverlay;
import dev.xkmc.lasertransport.content.client.overlay.ToolSelectionOverlay;
import dev.xkmc.lasertransport.events.ClientGeneralEvents;
import dev.xkmc.lasertransport.init.data.Keys;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class LaserTransportClient {

	public static void onCtorClient(IEventBus bus, IEventBus eventBus) {
		bus.addListener(LaserTransportClient::clientSetup);
		bus.addListener(LaserTransportClient::registerOverlays);
		bus.addListener(LaserTransportClient::registerKeys);
		eventBus.register(ClientGeneralEvents.class);
	}

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		registerItemProperties();
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerItemProperties() {
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerOverlays(RegisterGuiOverlaysEvent event) {
		event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), "node_info", new NodeInfoOverlay());
		event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), "number_adjust", new NumberSetOverlay());
		event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), "tool_select", ToolSelectionOverlay.INSTANCE);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		for (Keys key : Keys.values()) {
			event.register(key.map);
		}
	}
}
