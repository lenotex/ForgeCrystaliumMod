package net.lenotex.crystalium.world.feature;

import com.google.common.base.Suppliers;
import net.lenotex.crystalium.Crystalium;
import net.lenotex.crystalium.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Crystalium.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BLACK_OPAL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NATURAL_STONE, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> DEEPSLATE_BLACK_OPAL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACK_OPAL_ORE = CONFIGURED_FEATURES.register("black_opal_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLACK_OPAL_ORES.get(), 7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DEEPSLATE_BLACK_OPAL_ORE = CONFIGURED_FEATURES.register("deepslate_black_opal_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DEEPSLATE_BLACK_OPAL_ORES.get(), 7)));
    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
