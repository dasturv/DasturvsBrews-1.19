package net.dasturv.dasturvbrews.block;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.dasturv.dasturvbrews.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block GREEN_TEA_LEAF_MAT = registerBlock("green_tea_leaf_mat", new TeaMatBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).noCollision().sounds(BlockSoundGroup.GRASS).nonOpaque()), ModItemGroup.DASTURV_BREWS);
    public static final Block WHITE_TEA_LEAF_MAT = registerBlock("white_tea_leaf_mat", new TeaMatBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).noCollision().sounds(BlockSoundGroup.GRASS).nonOpaque()), ModItemGroup.DASTURV_BREWS);
    public static final Block OOLONG_TEA_LEAF_MAT = registerBlock("oolong_tea_leaf_mat", new TeaMatBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).noCollision().sounds(BlockSoundGroup.GRASS).nonOpaque()), ModItemGroup.DASTURV_BREWS);
    public static final Block BLACK_TEA_LEAF_MAT = registerBlock("black_tea_leaf_mat", new TeaMatBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).noCollision().sounds(BlockSoundGroup.GRASS).nonOpaque()), ModItemGroup.DASTURV_BREWS);
    public static final Block PUERH_TEA_LEAF_MAT = registerBlock("puerh_tea_leaf_mat", new TeaMatBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).noCollision().sounds(BlockSoundGroup.GRASS).nonOpaque()), ModItemGroup.DASTURV_BREWS);
    public static final Block TEA_BUSH_BLOCK = registerBlock("tea_bush", new TeaBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)), ModItemGroup.DASTURV_BREWS);

    //Kettles
    public static final Block CERAMIC_KETTLE = registerBlock("ceramic_kettle", new CeramicKettleBlock(FabricBlockSettings.copyOf(Blocks.FLOWER_POT)), ModItemGroup.DASTURV_BREWS);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(DasturvBrews.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(DasturvBrews.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        DasturvBrews.LOGGER.debug("Registering Blocks for " + DasturvBrews.MOD_ID);
    }
}
