package net.dasturv.dasturvbrews.attribute;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModAttributes {
    public static final EntityAttribute MINING_SPEED = registerAttribute("mining_speed", new ClampedEntityAttribute("attribute.dasturvbrews.mining_speed",1.0D,0.0D,2048.0D).setTracked(true));
    public static final EntityAttribute HEALTH_REGENERATION_RATE = registerAttribute("health_regeneration_rate", new ClampedEntityAttribute("attribute.dasturvbrews.health_regeneration_rate",0.0D,0.0D,2048.0D).setTracked(true));

    private static EntityAttribute registerAttribute(String name, EntityAttribute attribute) {
        return Registry.register(Registry.ATTRIBUTE, new Identifier(DasturvBrews.MOD_ID, name), attribute);
    }

    public static void registerModAttributes() {
        DasturvBrews.LOGGER.debug("Registering Attributes for " + DasturvBrews.MOD_ID);
    }
}
