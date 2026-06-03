package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.block.ModBlocks;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, PickaxeMod.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.pickaxemod.pickaxe_tab","合金模组");

        add(ModItems.PICKAXE_E.get(),"合金搞e");

        add(ModBlocks.PICKAXE_BLOCK.get(),"合金方块");
    }
}
