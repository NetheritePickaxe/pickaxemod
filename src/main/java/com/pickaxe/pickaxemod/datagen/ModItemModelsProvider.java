package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PickaxeMod.MODID, existingFileHelper);
    }

    private void c4Item(DeferredItem<?> item) {
        withExistingParent(item.getId().getPath(), "item/generated")
                .texture("layer0", modLoc("item/c4"));
    }


    @Override
    protected void registerModels() {
        basicItem(ModItems.PICKAXE_E.get());
        c4Item(ModItems.TimedExplosive);
        basicItem(ModItems.SHIT.get());
    }
}
