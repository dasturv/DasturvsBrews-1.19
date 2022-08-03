package net.dasturv.dasturvbrews.world.gen;

import net.dasturv.dasturvbrews.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetationGeneration {
    public static void generateVegetation() {
        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() > 0.6f && context.getBiome().getDownfall() > 0.6f && context.getBiomeKey() != BiomeKeys.SWAMP && context.getBiomeKey() != BiomeKeys.MANGROVE_SWAMP, GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.TEA_BUSH_PLACED.getKey().get());
    }
}
