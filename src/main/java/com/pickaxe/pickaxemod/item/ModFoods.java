package com.pickaxe.pickaxemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SHIT = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.INFESTED, 600), 0.3f)
            .nutrition(3)
            .alwaysEdible()
            .build();
}
