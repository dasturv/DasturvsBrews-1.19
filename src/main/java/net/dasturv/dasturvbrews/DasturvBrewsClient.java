package net.dasturv.dasturvbrews;

import net.dasturv.dasturvbrews.block.ModBlocks;
import net.dasturv.dasturvbrews.screen.KettleScreen;
import net.dasturv.dasturvbrews.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class DasturvBrewsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_TEA_LEAF_MAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_TEA_LEAF_MAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OOLONG_TEA_LEAF_MAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_TEA_LEAF_MAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PUERH_TEA_LEAF_MAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEA_BUSH_BLOCK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_KETTLE, RenderLayer.getCutout());

        ScreenRegistry.register(ModScreenHandlers.KETTLE_SCREEN_HANDLER, KettleScreen::new);
    }
}
