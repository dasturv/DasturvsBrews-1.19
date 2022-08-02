package net.dasturv.dasturvbrews.mixin;

import net.dasturv.dasturvbrews.attribute.ModAttributes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(at = @At("RETURN"), method = "getBlockBreakingSpeed", cancellable = true)
    public void applyingAttributeToBlockBreaking(BlockState block, CallbackInfoReturnable<Float> cir) {
        float f = cir.getReturnValue();
        f *= (float) ((PlayerEntity) (Object) this).getAttributeValue(ModAttributes.MINING_SPEED);
        cir.setReturnValue(f);
    }

    @Inject(at = @At("RETURN"), method = "createPlayerAttributes")
    private static void addAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue().add(ModAttributes.MINING_SPEED).add(ModAttributes.HEALTH_REGENERATION_RATE);
    }
}
