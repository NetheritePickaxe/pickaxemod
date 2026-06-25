package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.block.ModBlocks;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output) {
        super(output, PickaxeMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.pickaxemod.pickaxe_tab", "Pickaxe Mod");

        add(ModItems.PICKAXE_E.get(), "pickaxe_e");
        add(ModItems.TimedExplosive.get(),"C4");
        add(ModItems.SHIT.get(), "shit");

        add(ModBlocks.PICKAXE_BLOCK.get(), "pickaxe block");
    }
}
