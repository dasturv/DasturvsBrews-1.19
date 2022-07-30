package net.dasturv.dasturvbrews.item;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new FabricItemSettings().group(ModItemGroup.DASTURV_BREWS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DasturvBrews.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DasturvBrews.LOGGER.debug("Registering Items for " + DasturvBrews.MOD_ID);
    }
}
