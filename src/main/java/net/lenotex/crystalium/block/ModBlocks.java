package net.lenotex.crystalium.block;

import net.lenotex.crystalium.Crystalium;
import net.lenotex.crystalium.block.custom.JumpyBlock;
import net.lenotex.crystalium.item.ModCreativeModeTabs;
import net.lenotex.crystalium.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Crystalium.MODID);

    public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()), ModCreativeModeTabs.CRYSTALIUM_TAB);

    public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTabs.CRYSTALIUM_TAB);

    public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE = registerBlock("deepslate_black_opal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .sound(SoundType.DEEPSLATE)
            .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTabs.CRYSTALIUM_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block", () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()), ModCreativeModeTabs.CRYSTALIUM_TAB);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
