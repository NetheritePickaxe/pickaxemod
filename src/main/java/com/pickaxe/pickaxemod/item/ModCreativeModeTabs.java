package com.pickaxe.pickaxemod.item;

import com.pickaxe.pickaxemod.PickaxeMod;
import com.pickaxe.pickaxemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PickaxeMod.MODID);

    public static final Supplier<CreativeModeTab> PICKAXE_TAB =
            CREATIVE_MODE_TABS.register("pickaxe_tab",() -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PICKAXE_E.get()))
                    .title(Component.translatable("itemGroup.pickaxemod.pickaxe_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PICKAXE_E);
                        output.accept(ModItems.SHIT);
                        output.accept(ModItems.EVERLASTING_SHIT);
                        output.accept(ModBlocks.PICKAXE_BLOCK);
                    }).build());

    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
