package net.dasturv.dasturvbrews.screen;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<KettleScreenHandler> KETTLE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(DasturvBrews.MOD_ID, "kettle"),
                    KettleScreenHandler::new);
}
