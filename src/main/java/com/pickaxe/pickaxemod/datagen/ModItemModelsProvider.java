package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PickaxeMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.PICKAXE_E.get());
        basicItem(ModItems.SHIT.get());
    }
}
