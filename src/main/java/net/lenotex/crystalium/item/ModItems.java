package net.lenotex.crystalium.item;

import net.lenotex.crystalium.Crystalium;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Crystalium.MODID);

    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.CRYSTALIUM_TAB)));
    public static final RegistryObject<Item> RAW_BLACK_OPAL = ITEMS.register("raw_black_opal", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.CRYSTALIUM_TAB)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
