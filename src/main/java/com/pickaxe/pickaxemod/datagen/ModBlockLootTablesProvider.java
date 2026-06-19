package com.pickaxe.pickaxemod.datagen;

import com.pickaxe.pickaxemod.block.ModBlocks;
import java.util.Set;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //        dropSelf(ModBlocks.PICKAXE_BLOCK.get());
        add(
                ModBlocks.PICKAXE_BLOCK.get(),
                block -> createSilkTouchDispatchTable(
                        block,
                        applyExplosionCondition(block, LootItem.lootTableItem(Items.NETHERITE_BLOCK))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
