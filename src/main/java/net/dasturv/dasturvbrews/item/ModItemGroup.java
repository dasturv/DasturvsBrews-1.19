package net.dasturv.dasturvbrews.item;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DASTURV_BREWS = FabricItemGroupBuilder.build(new Identifier(DasturvBrews.MOD_ID, "dasturv_brews"), () -> new ItemStack(Items.GLASS_BOTTLE));
}
