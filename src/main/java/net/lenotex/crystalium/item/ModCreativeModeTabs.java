package net.lenotex.crystalium.item;

import net.lenotex.crystalium.Crystalium;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Crystalium.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab CRYSTALIUM_TAB = new CreativeModeTab("crystalium_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLACK_OPAL.get());
        }
    };
}
