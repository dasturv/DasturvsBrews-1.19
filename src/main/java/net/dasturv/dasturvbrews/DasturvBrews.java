package net.dasturv.dasturvbrews;

import net.dasturv.dasturvbrews.attribute.ModAttributes;
import net.dasturv.dasturvbrews.block.ModBlocks;
import net.dasturv.dasturvbrews.effect.ModEffects;
import net.dasturv.dasturvbrews.item.ModItems;
import net.dasturv.dasturvbrews.world.feature.ModConfiguredFeatures;
import net.dasturv.dasturvbrews.world.gen.ModVegetationGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DasturvBrews implements ModInitializer {

	public static final String MOD_ID = "dasturvbrews";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerModEffects();
		ModAttributes.registerModAttributes();

		ModVegetationGeneration.generateVegetation();
	}
}
