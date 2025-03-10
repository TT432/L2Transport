package dev.xkmc.lasertransport.content.tile.block;

import dev.xkmc.l2library.block.impl.BlockEntityBlockMethodImpl;
import dev.xkmc.l2library.block.one.BlockEntityBlockMethod;
import dev.xkmc.lasertransport.content.tile.flux.OrderedFluxNodeBlockEntity;
import dev.xkmc.lasertransport.content.tile.flux.RetrieverFluxNodeBlockEntity;
import dev.xkmc.lasertransport.content.tile.flux.SimpleFluxNodeBlockEntity;
import dev.xkmc.lasertransport.init.registrate.LTBlocks;

public class FluxTransferBlock {

	public static final BlockEntityBlockMethod<SimpleFluxNodeBlockEntity> SIMPLE = new BlockEntityBlockMethodImpl<>(LTBlocks.TE_FLUX_SIMPLE, SimpleFluxNodeBlockEntity.class);
	public static final BlockEntityBlockMethod<OrderedFluxNodeBlockEntity> ORDERED = new BlockEntityBlockMethodImpl<>(LTBlocks.TE_FLUX_ORDERED, OrderedFluxNodeBlockEntity.class);
	public static final BlockEntityBlockMethod<RetrieverFluxNodeBlockEntity> RETRIEVE = new BlockEntityBlockMethodImpl<>(LTBlocks.TE_FLUX_RETRIEVE, RetrieverFluxNodeBlockEntity.class);

}
