package net.dasturv.dasturvbrews.recipe;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registeRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(DasturvBrews.MOD_ID, KettleRecipe.Serializer.ID),
                KettleRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(DasturvBrews.MOD_ID, KettleRecipe.Type.ID),
                KettleRecipe.Type.INSTANCE);
    }
}
