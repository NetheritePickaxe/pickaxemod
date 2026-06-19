package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, PickaxeMod.MODID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlockWithItem(ModBlocks.PICKAXE_BLOCK.get(), cubeAll(ModBlocks.PICKAXE_BLOCK.get()));
  }
}
