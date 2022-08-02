package net.dasturv.dasturvbrews.mixin;

import net.dasturv.dasturvbrews.attribute.ModAttributes;
import net.dasturv.dasturvbrews.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(at = @At("RETURN"), method = "modifyAppliedDamage", cancellable = true)
    private void applyAttributes(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        LivingEntity livingEntity = (LivingEntity)(Object)this;
        if (livingEntity instanceof PlayerEntity) {
            float reductionMultiplier = 1f;
            PlayerEntity player = (PlayerEntity)livingEntity;
            reductionMultiplier = player.hasStatusEffect(ModEffects.RELAXATION) ? (1f / (0.05f * (float)player.getStatusEffect(ModEffects.RELAXATION).getAmplifier() + 1f)) : 1f;
            cir.setReturnValue(cir.getReturnValue() * reductionMultiplier);
        }
    }
}
