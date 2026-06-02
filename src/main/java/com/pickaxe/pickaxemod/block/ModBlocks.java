package com.pickaxe.pickaxemod.block;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PickaxeMod.MODID);

    public static final DeferredBlock<Block> PICKAXE_BLOCK =
            registerBlocks("pickaxe_block", () -> new ModDirectionalBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .strength(50.0F, 1200.0F)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel((state) -> 8)
            ));


    private static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block){
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
