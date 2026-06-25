package com.pickaxe.pickaxemod.item.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class TimedExplosive extends Item {
    public TimedExplosive(Properties properties) {
        super(properties);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof Player player)) {
            return super.hurtEnemy(stack, target, attacker);
        }
            Level level = target.level();

            if (!level.isClientSide()) {
                player.sendSystemMessage(Component.literal("攻击者：" + player.getName().getString() + "，目标：" + target.getName().getString()));

                if(!player.isCreative()) {
                    stack.shrink(1);
                }
            }
            return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = context.getLevel();

        if (!level.isClientSide()) {


        }

        return super.useOn(context);
    }
}
