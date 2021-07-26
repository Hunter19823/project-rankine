package com.cannolicatfish.rankine.init;

import com.cannolicatfish.rankine.blocks.plants.RankinePlantBlock;
import com.cannolicatfish.rankine.world.gen.feature.*;
import com.cannolicatfish.rankine.world.gen.placement.IntrusionPlacement;
import com.cannolicatfish.rankine.world.gen.placement.RankineDoublePlantPlacer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunkplacer.*;

import java.util.OptionalInt;

public class RankineFeatures {

    public static void registerConfiguredFeatures() {
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:meteorite",METEORITE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:fire_clay",FIRE_CLAY);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:elderberry_bush",ELDERBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:snowberry_bush",SNOWBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:blueberry_bush",BLUEBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:raspberry_bush",RASPBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:blackberry_bush",BLACKBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:cranberry_bush",CRANBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:strawberry_bush",STRAWBERRY_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:pineapple_bush",PINEAPPLE_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:banana_yucca_bush",BANANA_YUCCA_BUSH);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:camphor_basil_plant",CAMPHOR_BASIL_PLANT);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:aloe_plant",ALOE_PLANT);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:yellow_birch_tree",YELLOW_BIRCH_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:black_birch_tree",BLACK_BIRCH_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:eastern_hemlock_tree",EASTERN_HEMLOCK_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:cedar_tree",CEDAR_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:coconut_palm_tree",COCONUT_PALM_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:pinyon_pine_tree",PINYON_PINE_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:balsam_fir_tree",BALSAM_FIR_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:dead_balsam_fir_tree",DEAD_BALSAM_FIR_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:magnolia_tree",MAGNOLIA_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:juniper_tree",JUNIPER_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:maple_tree",MAPLE_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:black_walnut_tree",BLACK_WALNUT_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:cork_oak_tree",CORK_OAK_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:sharinga_tree",SHARINGA_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:cinnamon_tree",CINNAMON_TREE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:flat_bedrock",FLAT_BEDROCK);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:flat_bedrock_nether",FLAT_BEDROCK_NETHER);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:gravel_disks",GRAVEL_DISKS);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:sand_disks",SAND_DISKS);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:clay_disks",CLAY_DISKS);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:ore_alluvium",ORE_ALLUVIUM);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:ore_evaporite",ORE_EVAPORITE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:ore_intrusion",ORE_INTRUSION);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:sill_phosphorite",SILL_PHOSPHORITE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:sill_ironstone",SILL_IRONSTONE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:nether_ore_intrusion",NETHER_ORE_INTRUSION);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:andesitic_tuff",ANDESITIC_TUFF);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:rhyolitic_tuff",RHYOLITIC_TUFF);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:tholeitic_basaltic_tuff",THOLEIITIC_BASALTIC_TUFF);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:dacitic_tuff",DACITIC_TUFF);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:andesite_var",ANDESITE_VAR);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:ore_nodule",ORE_NODULE);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:end_stone_gen",END_STONE_GEN);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:nether_stone_gen",NETHER_STONE_GEN);
        WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:overworld_stone_gen",OVERWORLD_STONE_GEN);
        //WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,"rankine:mud_feature",MUD_FEATURE);
    }

    // FEATURE CONFIGS
    public static final BaseTreeFeatureConfig CEDAR_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.CEDAR_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.CEDAR_LEAVES.get().getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
            new StraightTrunkPlacer(7, 4, 1),
            new TwoLayerFeature(2, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig BALSAM_FIR_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LEAVES.get().getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
            new StraightTrunkPlacer(8, 5, 0),
            new TwoLayerFeature(2, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig TALL_BALSAM_FIR_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LEAVES.get().getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
            new StraightTrunkPlacer(10, 4, 0),
            new TwoLayerFeature(2, 0, 0)))
            .setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState()))))
            .build();

    public static final BaseTreeFeatureConfig LARGE_BALSAM_FIR_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LEAVES.get().getDefaultState()),
            new MegaPineFoliagePlacer(FeatureSpread.create(0, 0), FeatureSpread.create(0, 0), FeatureSpread.create(3, 6)),
            new GiantTrunkPlacer(9, 4, 12),
            new TwoLayerFeature(1, 1, 2)))
            .setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState()))))
            .build();

    public static final BaseTreeFeatureConfig EASTERN_HEMLOCK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LEAVES.get().getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
            new StraightTrunkPlacer(4, 4, 1),
            new TwoLayerFeature(2, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig SMALL_EASTERN_HEMLOCK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LEAVES.get().getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), FeatureSpread.create(0, 0)),
            new StraightTrunkPlacer(2, 1, 0),
            new TwoLayerFeature(2, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig LARGE_EASTERN_HEMLOCK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.EASTERN_HEMLOCK_LEAVES.get().getDefaultState()),
            new MegaPineFoliagePlacer(FeatureSpread.create(0, 0), FeatureSpread.create(0, 0), FeatureSpread.create(5, 8)),
            new GiantTrunkPlacer(8, 2, 6),
            new TwoLayerFeature(1, 1, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig MAGNOLIA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.MAGNOLIA_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.MAGNOLIA_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 0)),
            new ForkyTrunkPlacer(4, 2, 2),
            new TwoLayerFeature(1, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig CINNAMON_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.CINNAMON_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.CINNAMON_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 0)),
            new ForkyTrunkPlacer(5, 2, 1),
            new TwoLayerFeature(1, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig PINYON_PINE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.PINYON_PINE_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.PINYON_PINE_LEAVES.get().getDefaultState()),
            new DarkOakFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0)),
            new DarkOakTrunkPlacer(5, 2, 2),
            new ThreeLayerFeature(1, 2, 1, 1, 2, OptionalInt.empty())))
            .setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig JUNIPER_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.JUNIPER_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.JUNIPER_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(1, 0)),
            new ForkyTrunkPlacer(1, 1, 1),
            new TwoLayerFeature(1, 1, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig COCONUT_PALM_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.COCONUT_PALM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.COCONUT_PALM_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 0)),
            new ForkyTrunkPlacer(7, 4, 2),
            new TwoLayerFeature(1, 0, 2)))
            .setIgnoreVines()
            .build();


    //OTHER TREE CONFIGS
    public static final BaseTreeFeatureConfig DEAD_BALSAM_FIR_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BALSAM_FIR_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new SpruceFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
            new StraightTrunkPlacer(5, 2, 1),
            new TwoLayerFeature(2, 0, 2)))
            .setIgnoreVines()
            .build();

    public static final BaseTreeFeatureConfig MAPLE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.MAPLE_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.MAPLE_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(3, 0), FeatureSpread.create(4, 0), 4),
            new FancyTrunkPlacer(8, 4, 0),
            new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BaseTreeFeatureConfig YELLOW_BIRCH_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.YELLOW_BIRCH_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.YELLOW_BIRCH_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(2, 0), 2),
            new FancyTrunkPlacer(6, 2, 4),
            new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BaseTreeFeatureConfig BLACK_BIRCH_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BLACK_BIRCH_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.BLACK_BIRCH_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(2, 0), 1),
            new FancyTrunkPlacer(6, 2, 4),
            new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BaseTreeFeatureConfig BLACK_WALNUT_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.BLACK_WALNUT_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.BLACK_WALNUT_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(3, 0), 3),
            new FancyTrunkPlacer(8, 2, 5),
            new TwoLayerFeature(2, 0, 0, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BaseTreeFeatureConfig CORK_OAK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.CORK_OAK_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.CORK_OAK_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(3, 0), FeatureSpread.create(2, 0), 1),
            new FancyTrunkPlacer(6, 2, 5),
            new TwoLayerFeature(2, 0, 3, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BaseTreeFeatureConfig SHARINGA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RankineBlocks.SHARINGA_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RankineBlocks.SHARINGA_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(2, 0), 3),
            new FancyTrunkPlacer(8, 2, 3),
            new TwoLayerFeature(1, 0, 0, OptionalInt.of(4))))
            .setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING)
            .build();

    public static final BlockClusterFeatureConfig ELDERBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.ELDERBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), new RankineDoublePlantPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig SNOWBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.SNOWBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig BLUEBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.BLUEBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), new RankineDoublePlantPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig RASPBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.RASPBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig BLACKBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.BLACKBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig CRANBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.CRANBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), new RankineDoublePlantPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig STRAWBERRY_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.STRAWBERRY_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig CAMPHOR_BASIL_PLANT_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.CAMPHOR_BASIL_PLANT.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(16).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT)).preventProjection().build();
    public static final BlockClusterFeatureConfig PINEAPPLE_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.PINEAPPLE_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, Blocks.SAND, Blocks.RED_SAND)).preventProjection().build();
    public static final BlockClusterFeatureConfig BANANA_YUCCA_BUSH_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.BANANA_YUCCA_BUSH.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, Blocks.SAND, Blocks.RED_SAND)).preventProjection().build();
    public static final BlockClusterFeatureConfig ALOE_PLANT_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RankineBlocks.ALOE_PLANT.get().getDefaultState().with(RankinePlantBlock.AGE, 3)), SimpleBlockPlacer.PLACER)).tries(16).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, Blocks.SAND, Blocks.RED_SAND)).preventProjection().build();

    // BASE FEATURE/S
    public static final Feature<RankineOreFeatureConfig> RANKINE_ORE = new RankineOreFeature(RankineOreFeatureConfig.CODEC);
    //public static final Feature<RankineMultiOreFeatureConfig> MULTI_RANKINE_ORE = new RankineMultiOreFeature(RankineMultiOreFeatureConfig.CODEC);
    public static final Feature<MeteoriteFeatureConfig> METEORITE_FEATURE = new MeteoriteFeature(MeteoriteFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> FIRE_CLAY_DISK = new FireClayDiskFeature(NoFeatureConfig.CODEC);
    public static final Feature<ReplacerFeatureConfig> FLAT_BEDROCK_FEATURE = new FlatBedrockFeature(ReplacerFeatureConfig.CODEC);
    public static final Feature<ReplacerFeatureConfig> INTRUSION = new IntrusionFeature(ReplacerFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> PHOSPHORITE_SILL = new SillFeature(NoFeatureConfig.CODEC, RankineBlocks.PHOSPHORITE.get().getDefaultState());
    public static final Feature<NoFeatureConfig> IRONSTONE_SILL = new SillFeature(NoFeatureConfig.CODEC, RankineBlocks.IRONSTONE.get().getDefaultState());
    public static final Feature<ReplacerFeatureConfig> NETHER_INTRUSION = new NetherIntrusionFeature(ReplacerFeatureConfig.CODEC);
    public static final Feature<OreFeatureConfig> ANDESITIC_TUFF_FEATURE =  new ModularOreFeature(OreFeatureConfig.CODEC, RankineBlocks.HORNBLENDE_ANDESITE.get().getDefaultState());
    public static final Feature<OreFeatureConfig> RHYOLITIC_TUFF_FEATURE =  new ModularOreFeature(OreFeatureConfig.CODEC, RankineBlocks.RHYOLITE.get().getDefaultState());
    public static final Feature<OreFeatureConfig> BASALTIC_TUFF_FEATURE =  new ModularOreFeature(OreFeatureConfig.CODEC, RankineBlocks.THOLEIITIC_BASALT.get().getDefaultState());
    public static final Feature<OreFeatureConfig> ORE_NODULE_FEATURE = new ModularOreFeature(OreFeatureConfig.CODEC, RankineBlocks.LIMESTONE.get().getDefaultState());
    public static final Feature<NoFeatureConfig> END_STONE_REPLACER = new EndStoneReplacerFeature(NoFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> NETHER_STONE_REPLACER = new NetherStoneReplacerFeature(NoFeatureConfig.CODEC);
    public static final Feature<NoFeatureConfig> STONE_REPLACER = new StoneReplacerFeature(NoFeatureConfig.CODEC);
    //public static final Feature<NoFeatureConfig> MUD_REPLACER = new MudReplacerFeature(NoFeatureConfig.CODEC);

    // BASE PLACEMENTS
    public static final Placement<NoPlacementConfig> REPLACER_PLACEMENT = new ReplacerPlacement(NoPlacementConfig.CODEC);
    public static final Placement<ChanceConfig> INTRUSION_PLACEMENT = new IntrusionPlacement(ChanceConfig.CODEC);

    // LOCAL_MODIFICATIONS
    public static final ConfiguredFeature<?, ?> METEORITE = METEORITE_FEATURE.withConfiguration(new MeteoriteFeatureConfig(RankineBlocks.METEORITE.get().getDefaultState(), 1))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(WGConfig.MISC.METEORITE_CHANCE.get())));
    public static final ConfiguredFeature<?, ?> VOLCANO = new VolcanoFeature(NoFeatureConfig.CODEC).withConfiguration(new NoFeatureConfig())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(30)));
    public static final ConfiguredFeature<?, ?> FIRE_CLAY = FIRE_CLAY_DISK.withConfiguration(new NoFeatureConfig())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5)));



    // VEGETAL_DECORATION
    public static final ConfiguredFeature<?, ?> ELDERBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(ELDERBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> SNOWBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(SNOWBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> BLUEBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(BLUEBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> RASPBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(RASPBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> BLACKBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(BLACKBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> CRANBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(CRANBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> STRAWBERRY_BUSH = Feature.RANDOM_PATCH.withConfiguration(STRAWBERRY_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> PINEAPPLE_BUSH = Feature.RANDOM_PATCH.withConfiguration(PINEAPPLE_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> BANANA_YUCCA_BUSH = Feature.RANDOM_PATCH.withConfiguration(BANANA_YUCCA_BUSH_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> CAMPHOR_BASIL_PLANT = Feature.RANDOM_PATCH.withConfiguration(CAMPHOR_BASIL_PLANT_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);
    public static final ConfiguredFeature<?, ?> ALOE_PLANT = Feature.RANDOM_PATCH.withConfiguration(ALOE_PLANT_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT);


    public static final ConfiguredFeature<?, ?> YELLOW_BIRCH_TREE = Feature.TREE.withConfiguration(YELLOW_BIRCH_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> BLACK_BIRCH_TREE = Feature.TREE.withConfiguration(BLACK_BIRCH_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> EASTERN_HEMLOCK_TREE = Feature.TREE.withConfiguration(LARGE_EASTERN_HEMLOCK_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1)));
    public static final ConfiguredFeature<?, ?> CEDAR_TREE = Feature.TREE.withConfiguration(CEDAR_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> COCONUT_PALM_TREE = Feature.TREE.withConfiguration(COCONUT_PALM_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1)));
    public static final ConfiguredFeature<?, ?> PINYON_PINE_TREE = Feature.TREE.withConfiguration(PINYON_PINE_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> BALSAM_FIR_TREE = Feature.TREE.withConfiguration(BALSAM_FIR_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> DEAD_BALSAM_FIR_TREE = Feature.TREE.withConfiguration(DEAD_BALSAM_FIR_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1)));
    public static final ConfiguredFeature<?, ?> MAGNOLIA_TREE = Feature.TREE.withConfiguration(MAGNOLIA_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(3)));
    public static final ConfiguredFeature<?, ?> JUNIPER_TREE = Feature.TREE.withConfiguration(JUNIPER_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> MAPLE_TREE = Feature.TREE.withConfiguration(MAPLE_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(11)));
    public static final ConfiguredFeature<?, ?> BLACK_WALNUT_TREE = Feature.TREE.withConfiguration(BLACK_WALNUT_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> CORK_OAK_TREE = Feature.TREE.withConfiguration(CORK_OAK_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(3)));
    public static final ConfiguredFeature<?, ?> SHARINGA_TREE = Feature.TREE.withConfiguration(SHARINGA_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1)));
    public static final ConfiguredFeature<?, ?> CINNAMON_TREE = Feature.TREE.withConfiguration(CINNAMON_TREE_CONFIG)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1)));



    // UNDERGROUND_ORES


    public static final ConfiguredFeature<?, ?> FLAT_BEDROCK = FLAT_BEDROCK_FEATURE.withConfiguration(
            new ReplacerFeatureConfig(Blocks.STONE.getDefaultState(), Blocks.BEDROCK.getDefaultState(), 0, WGConfig.MISC.BEDROCK_LAYERS.get())).withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
    public static final ConfiguredFeature<?, ?> FLAT_BEDROCK_NETHER = FLAT_BEDROCK_FEATURE.withConfiguration(
            new ReplacerFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BEDROCK.getDefaultState(), 0, WGConfig.MISC.BEDROCK_LAYERS.get())).withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));

    public static final ConfiguredFeature<?, ?> GRAVEL_DISKS = Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.create(2, 4), 2,
            Lists.newArrayList(Blocks.DIRT.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT);
    public static final ConfiguredFeature<?, ?> SAND_DISKS = Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.create(2, 3), 2,
            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT);
    public static final ConfiguredFeature<?, ?> CLAY_DISKS = Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), FeatureSpread.create(2, 2), 1,
            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT);
    public static final ConfiguredFeature<?, ?> ORE_ALLUVIUM = Feature.DISK.withConfiguration(new SphereReplaceConfig(RankineBlocks.ALLUVIUM.get().getDefaultState(), FeatureSpread.create(1, 2), 1,
            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.CLAY.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT);
    public static final ConfiguredFeature<?, ?> ORE_EVAPORITE = Feature.DISK.withConfiguration(new SphereReplaceConfig(RankineBlocks.EVAPORITE.get().getDefaultState(), FeatureSpread.create(1, 1), 1,
            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.CLAY.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT);

    public static final ConfiguredFeature<?, ?> ORE_INTRUSION = INTRUSION.withConfiguration(
            new ReplacerFeatureConfig(Blocks.STONE.getDefaultState(), Blocks.AIR.getDefaultState(), 1, 256)).withPlacement(INTRUSION_PLACEMENT.configure(new ChanceConfig(1)));
    public static final ConfiguredFeature<?, ?> SILL_PHOSPHORITE = PHOSPHORITE_SILL.withConfiguration(new NoFeatureConfig())
            .withPlacement(INTRUSION_PLACEMENT.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> SILL_IRONSTONE = IRONSTONE_SILL.withConfiguration(new NoFeatureConfig())
            .withPlacement(INTRUSION_PLACEMENT.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> NETHER_ORE_INTRUSION = NETHER_INTRUSION.withConfiguration(
            new ReplacerFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.AIR.getDefaultState(), 1, 256)).withPlacement(INTRUSION_PLACEMENT.configure(new ChanceConfig(2)));
    public static final ConfiguredFeature<?, ?> ANDESITIC_TUFF = ANDESITIC_TUFF_FEATURE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RankineBlocks.ANDESITIC_TUFF.get().getDefaultState(), 64))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(60, 60, 128))).square().count(1);
    public static final ConfiguredFeature<?, ?> RHYOLITIC_TUFF = RHYOLITIC_TUFF_FEATURE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RankineBlocks.RHYOLITIC_TUFF.get().getDefaultState(), 64))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 60))).square().count(1);
    public static final ConfiguredFeature<?, ?> THOLEIITIC_BASALTIC_TUFF = BASALTIC_TUFF_FEATURE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RankineBlocks.BASALTIC_TUFF.get().getDefaultState(), 64))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 60))).square().count(1);
    public static final ConfiguredFeature<?, ?> DACITIC_TUFF = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.DACITES, RankineBlocks.DACITIC_TUFF.get().getStateContainer().getBaseState(), 60))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 60))).square().count(1);
    public static final ConfiguredFeature<?, ?> ANDESITE_VAR = ANDESITIC_TUFF_FEATURE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.ANDESITE.getDefaultState(), 40))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(64, 64, 150))).square().count(2);
    public static final ConfiguredFeature<?, ?> ORE_NODULE = ORE_NODULE_FEATURE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RankineBlocks.LIMESTONE_NODULE.get().getDefaultState(), 6))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(31, 31, 90))).square().count(20);
    public static final ConfiguredFeature<?, ?> END_STONE_GEN = END_STONE_REPLACER.withConfiguration(new NoFeatureConfig())
            .withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
    public static final ConfiguredFeature<?, ?> NETHER_STONE_GEN = NETHER_STONE_REPLACER.withConfiguration(new NoFeatureConfig())
            .withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
    public static final ConfiguredFeature<?, ?> OVERWORLD_STONE_GEN = STONE_REPLACER.withConfiguration(new NoFeatureConfig())
            .withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
    //public static final ConfiguredFeature<?, ?> MUD_FEATURE = MUD_REPLACER.withConfiguration(new NoFeatureConfig())
    //        .withPlacement(REPLACER_PLACEMENT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));

    //ORES
    public static final ConfiguredFeature<?,?> ORE_NATIVE_COPPER_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_COPPER, RankineBlocks.NATIVE_COPPER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_COPPER_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_COPPER_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_COPPER_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_COPPER, RankineBlocks.NATIVE_COPPER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_COPPER_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_COPPER_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_COPPER_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_COPPER, RankineBlocks.NATIVE_COPPER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_COPPER_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_COPPER_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_COPPER_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TIN_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TIN, RankineBlocks.NATIVE_TIN_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TIN_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_TIN_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TIN_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TIN, RankineBlocks.NATIVE_TIN_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TIN_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_TIN_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TIN_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TIN, RankineBlocks.NATIVE_TIN_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TIN_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TIN_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_TIN_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GOLD_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GOLD, RankineBlocks.NATIVE_GOLD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GOLD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_GOLD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GOLD_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GOLD, RankineBlocks.NATIVE_GOLD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GOLD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_GOLD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GOLD_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GOLD, RankineBlocks.NATIVE_GOLD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GOLD_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GOLD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_GOLD_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ALUMINUM_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ALUMINUM, RankineBlocks.NATIVE_ALUMINUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_ALUMINUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ALUMINUM_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ALUMINUM, RankineBlocks.NATIVE_ALUMINUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_ALUMINUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ALUMINUM_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ALUMINUM, RankineBlocks.NATIVE_ALUMINUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ALUMINUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_ALUMINUM_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_LEAD_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_LEAD, RankineBlocks.NATIVE_LEAD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_LEAD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_LEAD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_LEAD_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_LEAD, RankineBlocks.NATIVE_LEAD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_LEAD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_LEAD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_LEAD_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_LEAD, RankineBlocks.NATIVE_LEAD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_LEAD_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_LEAD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_LEAD_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SILVER_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SILVER, RankineBlocks.NATIVE_SILVER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SILVER_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_SILVER_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SILVER_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SILVER, RankineBlocks.NATIVE_SILVER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SILVER_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SILVER_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SILVER_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SILVER, RankineBlocks.NATIVE_SILVER_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SILVER_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SILVER_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SILVER_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ARSENIC_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ARSENIC, RankineBlocks.NATIVE_ARSENIC_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ARSENIC_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_ARSENIC_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ARSENIC_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ARSENIC, RankineBlocks.NATIVE_ARSENIC_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ARSENIC_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_ARSENIC_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_ARSENIC_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_ARSENIC, RankineBlocks.NATIVE_ARSENIC_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_ARSENIC_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_ARSENIC_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_BISMUTH_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_BISMUTH, RankineBlocks.NATIVE_BISMUTH_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_BISMUTH_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_BISMUTH_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_BISMUTH_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_BISMUTH, RankineBlocks.NATIVE_BISMUTH_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_BISMUTH_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_BISMUTH_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_BISMUTH_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_BISMUTH, RankineBlocks.NATIVE_BISMUTH_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_BISMUTH_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_BISMUTH_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SULFUR_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SULFUR, RankineBlocks.NATIVE_SULFUR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SULFUR_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_SULFUR_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SULFUR_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SULFUR, RankineBlocks.NATIVE_SULFUR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SULFUR_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SULFUR_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SULFUR_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SULFUR, RankineBlocks.NATIVE_SULFUR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SULFUR_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SULFUR_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SULFUR_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GALLIUM_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GALLIUM, RankineBlocks.NATIVE_GALLIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GALLIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_GALLIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GALLIUM_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GALLIUM, RankineBlocks.NATIVE_GALLIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GALLIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_GALLIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_GALLIUM_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_GALLIUM, RankineBlocks.NATIVE_GALLIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_GALLIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_GALLIUM_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_INDIUM_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_INDIUM, RankineBlocks.NATIVE_INDIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_INDIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_INDIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_INDIUM_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_INDIUM, RankineBlocks.NATIVE_INDIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_INDIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_INDIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_INDIUM_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_INDIUM, RankineBlocks.NATIVE_INDIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_INDIUM_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_INDIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_INDIUM_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TELLURIUM_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TELLURIUM, RankineBlocks.NATIVE_TELLURIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_TELLURIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TELLURIUM_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TELLURIUM, RankineBlocks.NATIVE_TELLURIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_TELLURIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_TELLURIUM_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_TELLURIUM, RankineBlocks.NATIVE_TELLURIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_TELLURIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_TELLURIUM_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SELENIUM_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SELENIUM, RankineBlocks.NATIVE_SELENIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SELENIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.NATIVE_SELENIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SELENIUM_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SELENIUM, RankineBlocks.NATIVE_SELENIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SELENIUM_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SELENIUM_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_NATIVE_SELENIUM_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.NATIVE_SELENIUM, RankineBlocks.NATIVE_SELENIUM_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MIN_HEIGHT.get(), WGConfig.ORES.NATIVE_SELENIUM_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.NATIVE_SELENIUM_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MALACHITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MALACHITE, RankineBlocks.MALACHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MALACHITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MALACHITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MALACHITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MALACHITE, RankineBlocks.MALACHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MALACHITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MALACHITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MALACHITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MALACHITE, RankineBlocks.MALACHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MALACHITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MALACHITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MALACHITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CASSITERITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CASSITERITE, RankineBlocks.CASSITERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CASSITERITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.CASSITERITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CASSITERITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CASSITERITE, RankineBlocks.CASSITERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CASSITERITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CASSITERITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CASSITERITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CASSITERITE, RankineBlocks.CASSITERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CASSITERITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CASSITERITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CASSITERITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BAUXITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BAUXITE, RankineBlocks.BAUXITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BAUXITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.BAUXITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BAUXITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BAUXITE, RankineBlocks.BAUXITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BAUXITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BAUXITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BAUXITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BAUXITE, RankineBlocks.BAUXITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BAUXITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BAUXITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BAUXITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPHALERITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPHALERITE, RankineBlocks.SPHALERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPHALERITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.SPHALERITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPHALERITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPHALERITE, RankineBlocks.SPHALERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPHALERITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SPHALERITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPHALERITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPHALERITE, RankineBlocks.SPHALERITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPHALERITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPHALERITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SPHALERITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CINNABAR_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CINNABAR, RankineBlocks.CINNABAR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CINNABAR_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.CINNABAR_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CINNABAR_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CINNABAR, RankineBlocks.CINNABAR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CINNABAR_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CINNABAR_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CINNABAR_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CINNABAR, RankineBlocks.CINNABAR_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CINNABAR_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CINNABAR_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CINNABAR_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNETITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNETITE, RankineBlocks.MAGNETITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNETITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MAGNETITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNETITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNETITE, RankineBlocks.MAGNETITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNETITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAGNETITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNETITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNETITE, RankineBlocks.MAGNETITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNETITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNETITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAGNETITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PENTLANDITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PENTLANDITE, RankineBlocks.PENTLANDITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PENTLANDITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PENTLANDITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PENTLANDITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PENTLANDITE, RankineBlocks.PENTLANDITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PENTLANDITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PENTLANDITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PENTLANDITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PENTLANDITE, RankineBlocks.PENTLANDITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PENTLANDITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PENTLANDITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PENTLANDITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNESITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNESITE, RankineBlocks.MAGNESITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNESITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MAGNESITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNESITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNESITE, RankineBlocks.MAGNESITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNESITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAGNESITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAGNESITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAGNESITE, RankineBlocks.MAGNESITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAGNESITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAGNESITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAGNESITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GALENA_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GALENA, RankineBlocks.GALENA_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GALENA_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.GALENA_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GALENA_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GALENA, RankineBlocks.GALENA_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GALENA_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.GALENA_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GALENA_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GALENA, RankineBlocks.GALENA_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GALENA_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GALENA_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.GALENA_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_VANADINITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.VANADINITE, RankineBlocks.VANADINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.VANADINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.VANADINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_VANADINITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.VANADINITE, RankineBlocks.VANADINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.VANADINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.VANADINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_VANADINITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.VANADINITE, RankineBlocks.VANADINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.VANADINITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.VANADINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.VANADINITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BISMUTHINITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BISMUTHINITE, RankineBlocks.BISMUTHINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BISMUTHINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.BISMUTHINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BISMUTHINITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BISMUTHINITE, RankineBlocks.BISMUTHINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BISMUTHINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BISMUTHINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BISMUTHINITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BISMUTHINITE, RankineBlocks.BISMUTHINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BISMUTHINITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BISMUTHINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BISMUTHINITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ACANTHITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ACANTHITE, RankineBlocks.ACANTHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ACANTHITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.ACANTHITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ACANTHITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ACANTHITE, RankineBlocks.ACANTHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ACANTHITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ACANTHITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ACANTHITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ACANTHITE, RankineBlocks.ACANTHITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ACANTHITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ACANTHITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ACANTHITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYROLUSITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYROLUSITE, RankineBlocks.PYROLUSITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYROLUSITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PYROLUSITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYROLUSITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYROLUSITE, RankineBlocks.PYROLUSITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYROLUSITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PYROLUSITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYROLUSITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYROLUSITE, RankineBlocks.PYROLUSITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYROLUSITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYROLUSITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PYROLUSITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CHROMITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CHROMITE, RankineBlocks.CHROMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CHROMITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.CHROMITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CHROMITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CHROMITE, RankineBlocks.CHROMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CHROMITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CHROMITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CHROMITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CHROMITE, RankineBlocks.CHROMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CHROMITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CHROMITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CHROMITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOLYBDENITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOLYBDENITE, RankineBlocks.MOLYBDENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOLYBDENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MOLYBDENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOLYBDENITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOLYBDENITE, RankineBlocks.MOLYBDENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOLYBDENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MOLYBDENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOLYBDENITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOLYBDENITE, RankineBlocks.MOLYBDENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOLYBDENITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOLYBDENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MOLYBDENITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ILMENITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ILMENITE, RankineBlocks.ILMENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ILMENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.ILMENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ILMENITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ILMENITE, RankineBlocks.ILMENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ILMENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ILMENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ILMENITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ILMENITE, RankineBlocks.ILMENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ILMENITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ILMENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ILMENITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COLUMBITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COLUMBITE, RankineBlocks.COLUMBITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COLUMBITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.COLUMBITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COLUMBITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COLUMBITE, RankineBlocks.COLUMBITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COLUMBITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.COLUMBITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COLUMBITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COLUMBITE, RankineBlocks.COLUMBITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COLUMBITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COLUMBITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.COLUMBITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_WOLFRAMITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.WOLFRAMITE, RankineBlocks.WOLFRAMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.WOLFRAMITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.WOLFRAMITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_WOLFRAMITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.WOLFRAMITE, RankineBlocks.WOLFRAMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.WOLFRAMITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.WOLFRAMITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_WOLFRAMITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.WOLFRAMITE, RankineBlocks.WOLFRAMITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.WOLFRAMITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.WOLFRAMITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.WOLFRAMITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TANTALITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TANTALITE, RankineBlocks.TANTALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TANTALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.TANTALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TANTALITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TANTALITE, RankineBlocks.TANTALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TANTALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TANTALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TANTALITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TANTALITE, RankineBlocks.TANTALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TANTALITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TANTALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TANTALITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PLUMBAGO_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PLUMBAGO, RankineBlocks.PLUMBAGO_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PLUMBAGO_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PLUMBAGO_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PLUMBAGO_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PLUMBAGO, RankineBlocks.PLUMBAGO_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PLUMBAGO_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PLUMBAGO_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PLUMBAGO_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PLUMBAGO, RankineBlocks.PLUMBAGO_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PLUMBAGO_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PLUMBAGO_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PLUMBAGO_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOISSANITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOISSANITE, RankineBlocks.MOISSANITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOISSANITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MOISSANITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOISSANITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOISSANITE, RankineBlocks.MOISSANITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOISSANITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MOISSANITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MOISSANITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MOISSANITE, RankineBlocks.MOISSANITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MOISSANITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MOISSANITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MOISSANITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPERRYLITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPERRYLITE, RankineBlocks.SPERRYLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPERRYLITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.SPERRYLITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPERRYLITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPERRYLITE, RankineBlocks.SPERRYLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPERRYLITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SPERRYLITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SPERRYLITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SPERRYLITE, RankineBlocks.SPERRYLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SPERRYLITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SPERRYLITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SPERRYLITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LIGNITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LIGNITE, RankineBlocks.LIGNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LIGNITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.LIGNITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LIGNITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LIGNITE, RankineBlocks.LIGNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LIGNITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LIGNITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LIGNITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LIGNITE, RankineBlocks.LIGNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LIGNITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LIGNITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LIGNITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SUBBITUMINOUS_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SUBBITUMINOUS, RankineBlocks.SUBBITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SUBBITUMINOUS_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.SUBBITUMINOUS_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SUBBITUMINOUS_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SUBBITUMINOUS, RankineBlocks.SUBBITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SUBBITUMINOUS_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SUBBITUMINOUS_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_SUBBITUMINOUS_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.SUBBITUMINOUS, RankineBlocks.SUBBITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.SUBBITUMINOUS_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.SUBBITUMINOUS_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.SUBBITUMINOUS_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BITUMINOUS_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BITUMINOUS, RankineBlocks.BITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BITUMINOUS_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.BITUMINOUS_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BITUMINOUS_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BITUMINOUS, RankineBlocks.BITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BITUMINOUS_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BITUMINOUS_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_BITUMINOUS_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.BITUMINOUS, RankineBlocks.BITUMINOUS_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.BITUMINOUS_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MIN_HEIGHT.get(), WGConfig.ORES.BITUMINOUS_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.BITUMINOUS_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTHRACITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTHRACITE, RankineBlocks.ANTHRACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTHRACITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.ANTHRACITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTHRACITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTHRACITE, RankineBlocks.ANTHRACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTHRACITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ANTHRACITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTHRACITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTHRACITE, RankineBlocks.ANTHRACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTHRACITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTHRACITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ANTHRACITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LAZURITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LAZURITE, RankineBlocks.LAZURITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LAZURITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.LAZURITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LAZURITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LAZURITE, RankineBlocks.LAZURITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LAZURITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LAZURITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LAZURITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LAZURITE, RankineBlocks.LAZURITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LAZURITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LAZURITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LAZURITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_DIAMOND_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.DIAMOND, RankineBlocks.DIAMOND_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.DIAMOND_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.DIAMOND_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_DIAMOND_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.DIAMOND, RankineBlocks.DIAMOND_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.DIAMOND_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.DIAMOND_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_DIAMOND_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.DIAMOND, RankineBlocks.DIAMOND_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.DIAMOND_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MIN_HEIGHT.get(), WGConfig.ORES.DIAMOND_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.DIAMOND_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GREENOCKITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GREENOCKITE, RankineBlocks.GREENOCKITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GREENOCKITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.GREENOCKITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GREENOCKITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GREENOCKITE, RankineBlocks.GREENOCKITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GREENOCKITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.GREENOCKITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_GREENOCKITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.GREENOCKITE, RankineBlocks.GREENOCKITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.GREENOCKITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.GREENOCKITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.GREENOCKITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_EMERALD_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.EMERALD, RankineBlocks.EMERALD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.EMERALD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.EMERALD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_EMERALD_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.EMERALD, RankineBlocks.EMERALD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.EMERALD_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.EMERALD_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_EMERALD_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.EMERALD, RankineBlocks.EMERALD_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.EMERALD_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MIN_HEIGHT.get(), WGConfig.ORES.EMERALD_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.EMERALD_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_AQUAMARINE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.AQUAMARINE, RankineBlocks.AQUAMARINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.AQUAMARINE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.AQUAMARINE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_AQUAMARINE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.AQUAMARINE, RankineBlocks.AQUAMARINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.AQUAMARINE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.AQUAMARINE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_AQUAMARINE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.AQUAMARINE, RankineBlocks.AQUAMARINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.AQUAMARINE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.AQUAMARINE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.AQUAMARINE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_QUARTZ_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.QUARTZ, RankineBlocks.QUARTZ_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.QUARTZ_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.QUARTZ_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_QUARTZ_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.QUARTZ, RankineBlocks.QUARTZ_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.QUARTZ_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.QUARTZ_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_QUARTZ_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.QUARTZ, RankineBlocks.QUARTZ_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.QUARTZ_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MIN_HEIGHT.get(), WGConfig.ORES.QUARTZ_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.QUARTZ_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_OPAL_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.OPAL, RankineBlocks.OPAL_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.OPAL_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.OPAL_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_OPAL_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.OPAL, RankineBlocks.OPAL_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.OPAL_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.OPAL_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_OPAL_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.OPAL, RankineBlocks.OPAL_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.OPAL_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MIN_HEIGHT.get(), WGConfig.ORES.OPAL_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.OPAL_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAJORITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAJORITE, RankineBlocks.MAJORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAJORITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MAJORITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAJORITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAJORITE, RankineBlocks.MAJORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAJORITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAJORITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MAJORITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MAJORITE, RankineBlocks.MAJORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MAJORITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MAJORITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MAJORITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_FLUORITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.FLUORITE, RankineBlocks.FLUORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.FLUORITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.FLUORITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_FLUORITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.FLUORITE, RankineBlocks.FLUORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.FLUORITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.FLUORITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_FLUORITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.FLUORITE, RankineBlocks.FLUORITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.FLUORITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.FLUORITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.FLUORITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_URANINITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.URANINITE, RankineBlocks.URANINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.URANINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.URANINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_URANINITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.URANINITE, RankineBlocks.URANINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.URANINITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.URANINITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_URANINITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.URANINITE, RankineBlocks.URANINITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.URANINITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.URANINITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.URANINITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_STIBNITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.STIBNITE, RankineBlocks.STIBNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.STIBNITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.STIBNITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_STIBNITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.STIBNITE, RankineBlocks.STIBNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.STIBNITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.STIBNITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_STIBNITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.STIBNITE, RankineBlocks.STIBNITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.STIBNITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.STIBNITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.STIBNITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_XENOTIME_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.XENOTIME, RankineBlocks.XENOTIME_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.XENOTIME_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.XENOTIME_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_XENOTIME_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.XENOTIME, RankineBlocks.XENOTIME_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.XENOTIME_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.XENOTIME_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_XENOTIME_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.XENOTIME, RankineBlocks.XENOTIME_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.XENOTIME_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MIN_HEIGHT.get(), WGConfig.ORES.XENOTIME_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.XENOTIME_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_HALITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.HALITE, RankineBlocks.HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.HALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.HALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_HALITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.HALITE, RankineBlocks.HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.HALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.HALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_HALITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.HALITE, RankineBlocks.HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.HALITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.HALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.HALITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PINK_HALITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PINK_HALITE, RankineBlocks.PINK_HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PINK_HALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PINK_HALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PINK_HALITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PINK_HALITE, RankineBlocks.PINK_HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PINK_HALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PINK_HALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PINK_HALITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PINK_HALITE, RankineBlocks.PINK_HALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PINK_HALITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PINK_HALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PINK_HALITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_INTERSPINIFEX_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.INTERSPINIFEX, RankineBlocks.INTERSPINIFEX_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.INTERSPINIFEX_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.INTERSPINIFEX_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_INTERSPINIFEX_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.INTERSPINIFEX, RankineBlocks.INTERSPINIFEX_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.INTERSPINIFEX_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.INTERSPINIFEX_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_INTERSPINIFEX_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.INTERSPINIFEX, RankineBlocks.INTERSPINIFEX_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.INTERSPINIFEX_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MIN_HEIGHT.get(), WGConfig.ORES.INTERSPINIFEX_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.INTERSPINIFEX_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PETALITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PETALITE, RankineBlocks.PETALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PETALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PETALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PETALITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PETALITE, RankineBlocks.PETALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PETALITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PETALITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PETALITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PETALITE, RankineBlocks.PETALITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PETALITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PETALITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PETALITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COBALTITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COBALTITE, RankineBlocks.COBALTITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COBALTITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.COBALTITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COBALTITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COBALTITE, RankineBlocks.COBALTITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COBALTITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.COBALTITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_COBALTITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.COBALTITE, RankineBlocks.COBALTITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.COBALTITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.COBALTITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.COBALTITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CRYOLITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CRYOLITE, RankineBlocks.CRYOLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CRYOLITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.CRYOLITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CRYOLITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CRYOLITE, RankineBlocks.CRYOLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CRYOLITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CRYOLITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CRYOLITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CRYOLITE, RankineBlocks.CRYOLITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CRYOLITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CRYOLITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CRYOLITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYRITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYRITE, RankineBlocks.PYRITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYRITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.PYRITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYRITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYRITE, RankineBlocks.PYRITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYRITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PYRITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_PYRITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.PYRITE, RankineBlocks.PYRITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.PYRITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.PYRITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.PYRITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CELESTINE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CELESTINE, RankineBlocks.CELESTINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CELESTINE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.CELESTINE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CELESTINE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CELESTINE, RankineBlocks.CELESTINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CELESTINE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CELESTINE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_CELESTINE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.CELESTINE, RankineBlocks.CELESTINE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.CELESTINE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.CELESTINE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.CELESTINE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MONAZITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MONAZITE, RankineBlocks.MONAZITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MONAZITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.MONAZITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MONAZITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MONAZITE, RankineBlocks.MONAZITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MONAZITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MONAZITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_MONAZITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.MONAZITE, RankineBlocks.MONAZITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.MONAZITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.MONAZITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.MONAZITE_ORE_MEGA_CHANCE.get());

    
    
    
    
    public static final ConfiguredFeature<?,?> ORE_KAMACITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.KAMACITE, RankineBlocks.KAMACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.KAMACITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.KAMACITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_KAMACITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.KAMACITE, RankineBlocks.KAMACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.KAMACITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.KAMACITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_KAMACITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.KAMACITE, RankineBlocks.KAMACITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.KAMACITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.KAMACITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.KAMACITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTITAENITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTITAENITE, RankineBlocks.ANTITAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTITAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.ANTITAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTITAENITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTITAENITE, RankineBlocks.ANTITAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTITAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ANTITAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_ANTITAENITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.ANTITAENITE, RankineBlocks.ANTITAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.ANTITAENITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.ANTITAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.ANTITAENITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TAENITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TAENITE, RankineBlocks.TAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.TAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TAENITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TAENITE, RankineBlocks.TAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TAENITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TAENITE, RankineBlocks.TAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TAENITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TAENITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TETRATAENITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TETRATAENITE, RankineBlocks.TETRATAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TETRATAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.TETRATAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TETRATAENITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TETRATAENITE, RankineBlocks.TETRATAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TETRATAENITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TETRATAENITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_TETRATAENITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.TETRATAENITE, RankineBlocks.TETRATAENITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.TETRATAENITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.TETRATAENITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.TETRATAENITE_ORE_MEGA_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LONSDALEITE_COUNT = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LONSDALEITE, RankineBlocks.LONSDALEITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LONSDALEITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MAX_HEIGHT.get()))).square().count(WGConfig.ORES.LONSDALEITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LONSDALEITE_CHANCE = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LONSDALEITE, RankineBlocks.LONSDALEITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LONSDALEITE_ORE_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LONSDALEITE_ORE_CHANCE.get());
    public static final ConfiguredFeature<?,?> ORE_LONSDALEITE_MEGA = RANKINE_ORE.withConfiguration(new RankineOreFeatureConfig(RankineOreFeatureConfig.RankineFillerBlockType.LONSDALEITE, RankineBlocks.LONSDALEITE_ORE.get().getStateContainer().getBaseState(), WGConfig.ORES.LONSDALEITE_ORE_MEGA_SIZE.get()))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MIN_HEIGHT.get(), WGConfig.ORES.LONSDALEITE_ORE_MAX_HEIGHT.get()))).square().chance(WGConfig.ORES.LONSDALEITE_ORE_MEGA_CHANCE.get());


}

