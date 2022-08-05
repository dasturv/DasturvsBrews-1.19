package net.dasturv.dasturvbrews.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class DrinkItem extends Item {
    public DrinkItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            applyEffects(stack, world, user);
        }

        ItemStack container = new ItemStack(stack.getItem().getRecipeRemainder());

        if (stack.isFood()) {
            super.finishUsing(stack, world, user);
        } else if (user instanceof PlayerEntity player) {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Criteria.CONSUME_ITEM.trigger(serverPlayer, stack);
            }
            player.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        if (stack.isEmpty()) {
            return container;
        } else {
            if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode && !player.getInventory().insertStack(container)) {
                player.dropItem(container, false);
            }

            return stack;
        }
    }

    public void applyEffects(ItemStack stack, World world, LivingEntity user) {

    }
}
