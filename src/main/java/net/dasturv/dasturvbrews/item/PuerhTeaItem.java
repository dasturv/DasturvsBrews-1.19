package net.dasturv.dasturvbrews.item;

import net.dasturv.dasturvbrews.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PuerhTeaItem extends DrinkItem{
    public PuerhTeaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void applyEffects(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(ModEffects.RELAXATION, 6000, 1, true, false));
        user.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGIZED, 6000, 1, true, false));
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);

        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
