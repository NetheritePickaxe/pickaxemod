package com.pickaxe.pickaxemod.item;

import com.pickaxe.pickaxemod.PickaxeMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(PickaxeMod.MODID);

    public static final DeferredItem<Item> PICKAXE_E =
            ITEMS.register("pickaxe_e", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

