package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.block.ModBlocks;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PICKAXE_E)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .define('#', ItemTags.STONE_TOOL_MATERIALS)
                .define('X', Items.NETHERITE_PICKAXE)
                .unlockedBy(getHasName(Items.NETHERITE_PICKAXE), has(Items.NETHERITE_PICKAXE))
                .save(recipeOutput);
    }
}
