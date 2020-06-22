package com.cannolicatfish.rankine.world.gen;

import com.cannolicatfish.rankine.init.ModBlocks;
import com.cannolicatfish.rankine.blocks.RankineOre;
import com.cannolicatfish.rankine.world.biome.RankineBiomes;
import com.cannolicatfish.rankine.world.gen.feature.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class OreGen {

    public static final Feature<RankineOreFeatureConfig> RANKINE_ORE = new RankineOreFeature(RankineOreFeatureConfig::deserialize);
    public static final Feature<RankineMultiOreFeatureConfig> MULTI_RANKINE_ORE = new RankineMultiOreFeature(RankineMultiOreFeatureConfig::deserialize);


    public static void setupOreGeneration() {

        removeFeatures();
        addCrystal();
        IntrusionGen.addIntrusions();


        //Extras
        replaceGenDef(Blocks.DIRT, ModBlocks.PERMAFROST, 50, 128, getBiomesFromCategory(Collections.singletonList(Biome.Category.ICY), true));
        replaceGenDef(Blocks.STONE, Blocks.RED_SANDSTONE, 61, 80, getBiomesFromCategory(Collections.singletonList(Biome.Category.MESA), true));
        replaceGenDef(Blocks.STONE, ModBlocks.SHALE, 51, 70, getBiomesFromCategory(Arrays.asList(Biome.Category.SWAMP, Biome.Category.RIVER), true));

        //Ocean
        replaceGenDef(Blocks.STONE, ModBlocks.MARBLE, 0, 10, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.MUSHROOM), true));
        replaceGenDef(Blocks.STONE, ModBlocks.BASALT, 11, 35, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.MUSHROOM), true));
        replaceGenDef(Blocks.STONE, ModBlocks.LIMESTONE, 36, 60, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.MUSHROOM), true));
        replaceGenDef(Blocks.STONE, ModBlocks.SHALE, 61, 80, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.MUSHROOM), true));
        replaceGenDef(Blocks.STONE, ModBlocks.ANDESITE, 81, 256, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.MUSHROOM), true));

        //Beach
        replaceGenDef(Blocks.STONE, ModBlocks.GNEISS, 0, 10, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));
        replaceGenDef(Blocks.STONE, ModBlocks.BASALT, 11, 30, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));
        replaceGenDef(Blocks.STONE, ModBlocks.GRANITE, 31, 40, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));
        replaceGenDef(Blocks.STONE, ModBlocks.LIMESTONE, 41, 55, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));
        replaceGenDef(Blocks.STONE, ModBlocks.SHALE, 56, 90, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));
        replaceGenDef(Blocks.STONE, ModBlocks.SHALE, 91, 256, getBiomesFromCategory(Collections.singletonList(Biome.Category.BEACH), true));

        //Continental
        replaceGenDef(Blocks.STONE, ModBlocks.GNEISS, 0, 10, getBiomesFromCategory(Arrays.asList(Biome.Category.JUNGLE, Biome.Category.FOREST, Biome.Category.EXTREME_HILLS, Biome.Category.TAIGA), true));
        replaceGenDef(Blocks.STONE, ModBlocks.MARBLE, 0, 10, getBiomesFromCategory(Arrays.asList(Biome.Category.JUNGLE, Biome.Category.FOREST, Biome.Category.EXTREME_HILLS, Biome.Category.TAIGA), false));
        replaceGenDef(Blocks.STONE, ModBlocks.RHYOLITE, 11, 30, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.BEACH, Biome.Category.MUSHROOM), false));
        replaceGenDef(Blocks.STONE, ModBlocks.GRANITE, 31, 45, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.BEACH, Biome.Category.MUSHROOM), false));
        replaceGenDef(Blocks.STONE, ModBlocks.LIMESTONE, 46, 60, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.BEACH, Biome.Category.MUSHROOM), false));
        replaceGenDef(Blocks.STONE, ModBlocks.ANORTHOSITE, 61, 80, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.BEACH, Biome.Category.MUSHROOM), false));
        replaceGenDef(Blocks.STONE, ModBlocks.ANDESITE, 81, 256, getBiomesFromCategory(Arrays.asList(Biome.Category.OCEAN, Biome.Category.BEACH, Biome.Category.MUSHROOM), false));


        chunkGenDef(ModBlocks.NATIVE_COPPER_ORE,17,1F,51,70, RankineOreFeatureConfig.RankineFillerBlockType.ALL);
        chunkGenDef(ModBlocks.NATIVE_TIN_ORE,17,1F,51,70, RankineOreFeatureConfig.RankineFillerBlockType.ALL);
        chunkGenDef(ModBlocks.NATIVE_COPPER_ORE,17,1F,71,128, RankineOreFeatureConfig.RankineFillerBlockType.ALL);
        chunkGenDef(ModBlocks.NATIVE_TIN_ORE,17,1F,71,128, RankineOreFeatureConfig.RankineFillerBlockType.ALL);
        chunkGenDef(ModBlocks.NATIVE_GOLD_ORE,17,0.8F,11,128, RankineOreFeatureConfig.RankineFillerBlockType.ALL);
        chunkGenDef(ModBlocks.MAGNETITE_ORE,50,0.1F,0,70, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.MALACHITE_ORE,50,0.07F,31,128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.CASSITERITE_ORE,50,0.07F,31,128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.BAUXITE_ORE,50,0.07F,31,128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.SPHALERITE_ORE,50,0.07F,31,128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.MAGNESITE_ORE, 30, 0.07F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.PENTLANDITE_ORE, 30, 0.02F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkMultiGenDef(ModBlocks.GALENA_ORE, 40, 0.02F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE, 0.3f);
        chunkGenDef(ModBlocks.ACANTHITE_ORE, 30, 0.02F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.PYROLUSITE_ORE, 30, 0.02F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.CINNABAR_ORE, 30, 0.2F, 11, 50, RankineOreFeatureConfig.RankineFillerBlockType.OW_IGNEOUS);
        chunkGenDef(ModBlocks.LIGNITE_ORE, 30, 0.5F, 51, 128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.SUBBITUMINOUS_ORE, 25, 0.5F, 31, 50, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.BITUMINOUS_ORE, 20, 0.5F, 11, 30, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.LAZURITE_ORE, 20, 0.1F, 31, 128, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.EMERALD_ORE, 15, 0.15F, 11, 30, RankineOreFeatureConfig.RankineFillerBlockType.NO_SHALE);
        chunkGenDef(ModBlocks.PLUMBAGO_ORE, 8, 0.10F, 0, 11, RankineOreFeatureConfig.RankineFillerBlockType.MARBLE);

        rockGenCountDef(ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.LIMESTONE_NODULE.getDefaultState(),6,20,31,70, getBiomesFromCategory(Arrays.asList(Biome.Category.RIVER, Biome.Category.SWAMP),false));
        rockGenCountDef(ModBlocks.KIMBERLITE.getDefaultState(), ModBlocks.DIAMOND_ORE.getDefaultState().with(RankineOre.TYPE,11),9,3,0,25, getBiomesFromCategory(Collections.emptyList(),true));
        rockGenCountDef(Blocks.DIRT.getDefaultState(), Blocks.CLAY.getDefaultState(),10,1,55,70, getBiomesFromCategory(Arrays.asList(Biome.Category.RIVER, Biome.Category.SWAMP),true));
        rockGenCountDef(Blocks.SANDSTONE.getDefaultState(), ModBlocks.IRONSTONE.getDefaultState(),60,4,50,128, getBiomesFromCategory(Arrays.asList(Biome.Category.DESERT, Biome.Category.MESA),true));
        rockGenCountDef(ModBlocks.IRONSTONE.getDefaultState(), ModBlocks.OPAL_ORE.getDefaultState(),6,20,50,128, getBiomesFromCategory(Arrays.asList(Biome.Category.DESERT, Biome.Category.MESA),true));

    }

    //---------------------------------------------------------------------------------------------------------------------------------------------

    private static List<Biome> getBiomesFromCategory(List<Biome.Category> biomeCats, boolean include) {
        List<Biome> b = new ArrayList<>();
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (!biomeCats.isEmpty()) {
                for (Biome.Category cat : biomeCats) {
                    if (biome.getCategory() == cat && include){
                        b.add(biome);
                    }
                    if (!include && biome.getCategory() != cat && biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome != RankineBiomes.MANTLE) {
                        b.add(biome);
                    }
                }
            }
            else if (!include && biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome != RankineBiomes.MANTLE) {
                    b.add(biome);
                }
        }
        return b;
    }

    private static void replaceGenDef(Block oldBlock, Block newBlock, int lowerBound, int upperBound, List<Biome> biomes) {
        for (Biome b: biomes) {
            b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new ReplacerFeature(ReplacerFeatureConfig::deserialize).withConfiguration(
                    new ReplacerFeatureConfig(oldBlock.getDefaultState(), newBlock.getDefaultState(), lowerBound, upperBound)).withPlacement(new ReplacerPlacement(NoPlacementConfig::deserialize).configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }
    }

    private static void chunkGenDef(RankineOre block, int veinSize, float chance, int minHeight, int maxHeight, RankineOreFeatureConfig.RankineFillerBlockType type) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome != RankineBiomes.MANTLE) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RANKINE_ORE.withConfiguration(
                        new RankineOreFeatureConfig(type, block.getStateContainer().getBaseState(), veinSize)).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(chance, minHeight, 0, maxHeight))));
            }
        }
    }

    private static void chunkMultiGenDef(RankineOre block, int veinSize, float chance, int minHeight, int maxHeight, RankineOreFeatureConfig.RankineFillerBlockType type, float replaceChance) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome != RankineBiomes.MANTLE) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MULTI_RANKINE_ORE.withConfiguration(
                        new RankineMultiOreFeatureConfig(type, block.getStateContainer().getBaseState(), veinSize, replaceChance)).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(chance, minHeight, 0, maxHeight))));
            }
        }
    }

    private static void rockGenCountDef(BlockState oldBlock, BlockState newBlock, int veinSize, int count, int minHeight, int maxHeight, List<Biome> biomes) {
        final Feature<OreFeatureConfig> MODULE = new ModularOreFeature(OreFeatureConfig::deserialize,oldBlock);
        for (Biome b: biomes) {
            b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MODULE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, newBlock, veinSize))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, minHeight, 0, maxHeight))));
        }
    }

    private static void rockGenChanceDef(BlockState oldBlock, BlockState newBlock, int veinSize, float chance, int minHeight, int maxHeight, List<Biome> biomes) {
        final Feature<OreFeatureConfig> MODULE = new ModularOreFeature(OreFeatureConfig::deserialize,oldBlock);
        for (Biome b: biomes) {
            b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MODULE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, newBlock, veinSize))
                    .withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(chance, minHeight, 0, maxHeight))));
        }
    }

    private static void netherGen() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) // if biome is supposed to be included (reverse)
            {
                final Feature<OreFeatureConfig> MODULE = new ModularOreFeature(OreFeatureConfig::deserialize,Blocks.NETHERRACK.getDefaultState());
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MODULE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.PEROVSKITE.getDefaultState(), 40))
                        .withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(.2f, 100, 0, 128))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new ReplacerFeature(ReplacerFeatureConfig::deserialize).withConfiguration(
                        new ReplacerFeatureConfig(Blocks.NETHERRACK.getDefaultState(), ModBlocks.FERROPERICLASE.getDefaultState(), 115,128)).withPlacement(new ReplacerPlacement(NoPlacementConfig::deserialize).configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new ReplacerFeature(ReplacerFeatureConfig::deserialize).withConfiguration(
                        new ReplacerFeatureConfig(Blocks.NETHERRACK.getDefaultState(), ModBlocks.BRIDGMANITE.getDefaultState(), 100, 114)).withPlacement(new ReplacerPlacement(NoPlacementConfig::deserialize).configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
            }
        }
    }




    // ---------------------------------------------------------------


    private static void addCrystal()
    {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.MESA || biome.getCategory() == Biome.Category.SAVANNA) {
                biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,new CrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
            }
        }
    }

    private static void removeFeatures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            List<ConfiguredFeature> features = new ArrayList<ConfiguredFeature>();
            for (ConfiguredFeature<?,?> f : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)) {
                if (((DecoratedFeatureConfig) f.config).feature.feature instanceof OreFeature) {
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.GRANITE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.ANDESITE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.DIORITE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.IRON_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.COAL_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.REDSTONE_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.GOLD_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.DIAMOND_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.EMERALD_ORE) {
                        features.add(f);
                    }
                    if (((OreFeatureConfig) ((DecoratedFeatureConfig) f.config).feature.config).state.getBlock() == Blocks.LAPIS_ORE) {
                        features.add(f);
                    }
                }
            }
            biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(features);
        }
    }
}
