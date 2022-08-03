package net.dasturv.dasturvbrews.world.feature;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.dasturv.dasturvbrews.block.ModBlocks;
import net.dasturv.dasturvbrews.block.TeaBushBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TEA_BUSH =
            ConfiguredFeatures.register("patch_tea_bush", Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of((BlockState)ModBlocks.TEA_BUSH_BLOCK.getDefaultState().with(TeaBushBlock.AGE, 3))), List.of(Blocks.GRASS_BLOCK)));
    public static void registerConfiguredFeatures() {
        DasturvBrews.LOGGER.debug("Registering Configured Features for " + DasturvBrews.MOD_ID);
    }
}
