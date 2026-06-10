package com.pickaxe.pickaxemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SHIT = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.INFESTED, 200), 0.3f)
            .nutrition(3)
            .alwaysEdible()
            .build();

    public static final FoodProperties EVERLASTING_SHIT = new FoodProperties.Builder()
            .nutrition(3)
            .alwaysEdible()
            .build();
}
