package net.dasturv.dasturvbrews.item;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item GREEN_TEA_LEAF = registerItem("green_tea_leaf", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item WHITE_TEA_LEAF = registerItem("white_tea_leaf", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item OOLONG_TEA_LEAF = registerItem("oolong_tea_leaf", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item BLACK_TEA_LEAF = registerItem("black_tea_leaf", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item PUERH_TEA_LEAF = registerItem("puerh_tea_leaf", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DasturvBrews.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DasturvBrews.LOGGER.debug("Registering Items for " + DasturvBrews.MOD_ID);
    }
}
