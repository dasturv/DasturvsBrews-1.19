package net.dasturv.dasturvbrews.mixin;

import net.dasturv.dasturvbrews.attribute.ModAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {
    @Shadow int foodLevel;
    @Shadow private float saturationLevel;
    @Shadow private float exhaustion;
    @Shadow private int foodTickTimer;
    @Shadow private int prevFoodLevel;


    @Shadow public abstract void addExhaustion(float exhaustion);

    /**
     * @author
     */
    @Overwrite
    public void update(PlayerEntity player) {
        Difficulty difficulty = player.world.getDifficulty();
        this.prevFoodLevel = this.foodLevel;
        Double healthRegenerationRate = player.getAttributeValue(ModAttributes.HEALTH_REGENERATION_RATE);

        if (this.exhaustion > 4.0F) {
            this.exhaustion -= 4.0F;
            if (this.saturationLevel > 0.0F) {
                this.saturationLevel = Math.max(this.saturationLevel - 1.0F, 0.0F);
            } else if (difficulty != Difficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }

        boolean bl = player.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);
        if (bl && this.saturationLevel > 0.0F && player.canFoodHeal() && this.foodLevel >= 20) {
            ++this.foodTickTimer;
            if (this.foodTickTimer >= 10 * (1/(0.2 * healthRegenerationRate + 1))) {
                float f = Math.min(this.saturationLevel, 6.0F);
                player.heal(f / 6.0F);
                this.addExhaustion(f);
                this.foodTickTimer = 0;
            }
        } else if (bl && this.foodLevel >= 18 - healthRegenerationRate && player.canFoodHeal()) {
            ++this.foodTickTimer;
            if (this.foodTickTimer >= 80 * (1/(0.2 * healthRegenerationRate + 1))) {
                player.heal(1.0F);
                this.addExhaustion(6.0F);
                this.foodTickTimer = 0;
            }
        } else if (this.foodLevel <= 0) {
            ++this.foodTickTimer;
            if (this.foodTickTimer >= 80) {
                if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
                    player.damage(DamageSource.STARVE, 1.0F);
                }

                this.foodTickTimer = 0;
            }
        } else {
            this.foodTickTimer = 0;
        }

    }
}
