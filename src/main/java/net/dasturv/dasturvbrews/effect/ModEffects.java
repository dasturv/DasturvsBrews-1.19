package net.dasturv.dasturvbrews.effect;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.dasturv.dasturvbrews.attribute.ModAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect RELAXATION = registerEffect("relaxation", new RelaxedEffect()
            .addAttributeModifier(ModAttributes.HEALTH_REGENERATION_RATE, "51AEEA36-315B-4468-895B-1F1F35074205", 1.0D, EntityAttributeModifier.Operation.ADDITION));
    public static final StatusEffect ENERGIZED = registerEffect("energized", new EnergizedEffect()
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4468-935B-2F7F38074645", 0.04D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "51AEEA56-376B-4468-835B-2F1F38074445", 0.04D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(ModAttributes.MINING_SPEED, "51AEEA56-315B-4468-835B-2F1F35074245", 0.04D, EntityAttributeModifier.Operation.ADDITION));

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(DasturvBrews.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        DasturvBrews.LOGGER.debug("Registering Effects for " + DasturvBrews.MOD_ID);
    }

}
