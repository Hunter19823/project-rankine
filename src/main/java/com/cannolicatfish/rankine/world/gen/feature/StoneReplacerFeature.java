package com.cannolicatfish.rankine.world.gen.feature;

import com.cannolicatfish.rankine.Config;
import com.cannolicatfish.rankine.compatibility.TerraForged;
import com.cannolicatfish.rankine.init.ModBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ObserverBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StoneReplacerFeature extends Feature<StoneReplacerFeatureConfig> {


    public StoneReplacerFeature(Codec<StoneReplacerFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    public static final int NOISE_SCALE = Config.NOISE_SCALE.get();
    public static final int NOISE_OFFSET = Config.NOISE_OFFSET.get();
    public static final List<BlockState> OCEAN_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GABBRO.getDefaultState(), ModBlocks.THOLEIITIC_BASALT.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.BRECCIA.getDefaultState(), ModBlocks.SHALE.getDefaultState());
    public static final List<BlockState> DESERT_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GNEISS.getDefaultState(), ModBlocks.SCHIST.getDefaultState(), ModBlocks.MARBLE.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.RED_DACITE.getDefaultState(), ModBlocks.RHYOLITE.getDefaultState(), ModBlocks.BLACK_DACITE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.ANORTHOSITE.getDefaultState(), ModBlocks.BRECCIA.getDefaultState(), ModBlocks.QUARTZ_SANDSTONE.getDefaultState());
    public static final List<BlockState> MESA_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GNEISS.getDefaultState(), ModBlocks.SCHIST.getDefaultState(), ModBlocks.MARBLE.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.RED_DACITE.getDefaultState(),ModBlocks.RHYOLITE.getDefaultState(), ModBlocks.BLACK_DACITE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.ANORTHOSITE.getDefaultState(), ModBlocks.BRECCIA.getDefaultState(), ModBlocks.ARKOSE_SANDSTONE.getDefaultState());
    public static final List<BlockState> MOUNTAIN_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GNEISS.getDefaultState(), ModBlocks.SCHIST.getDefaultState(), ModBlocks.MARBLE.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.RED_DACITE.getDefaultState(),ModBlocks.RHYOLITE.getDefaultState(), ModBlocks.BLACK_DACITE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.SHALE.getDefaultState(), ModBlocks.ANORTHOSITE.getDefaultState(), ModBlocks.HORNBLENDE_ANDESITE.getDefaultState());
    public static final List<BlockState> SWAMP_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GNEISS.getDefaultState(), ModBlocks.SCHIST.getDefaultState(), ModBlocks.MARBLE.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.RED_DACITE.getDefaultState(),ModBlocks.RHYOLITE.getDefaultState(), ModBlocks.BLACK_DACITE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.SHALE.getDefaultState(), ModBlocks.ANORTHOSITE.getDefaultState(), ModBlocks.MUDSTONE.getDefaultState());
    public static final List<BlockState> DEFAULT_STONES = Arrays.asList(ModBlocks.PERIDOTITE.getDefaultState(), ModBlocks.GNEISS.getDefaultState(), ModBlocks.SCHIST.getDefaultState(), ModBlocks.MARBLE.getDefaultState(), ModBlocks.SLATE.getDefaultState(), ModBlocks.RED_DACITE.getDefaultState(),ModBlocks.RHYOLITE.getDefaultState(), ModBlocks.BLACK_DACITE.getDefaultState(), ModBlocks.LIMESTONE.getDefaultState(), ModBlocks.SHALE.getDefaultState(), ModBlocks.ANORTHOSITE.getDefaultState());



    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, StoneReplacerFeatureConfig config) {

        IChunk chunk = reader.getChunk(pos);
        int startX = chunk.getPos().getXStart();
        int startZ = chunk.getPos().getZStart();
        int endX = chunk.getPos().getXEnd();
        int endZ = chunk.getPos().getZEnd();

        for (int x = startX; x <= endX; ++x) {
            for (int z = startZ; z <= endZ; ++z) {
                int endY = reader.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, x, z);
                if (reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.OCEAN || reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.MUSHROOM ) {
                    int stoneCount = OCEAN_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,60/stoneCount * (i+1)), OCEAN_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,60/stoneCount * (i)), getLayerHeights(x,z,i,60/stoneCount * (i+1)), OCEAN_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,60/stoneCount * (i)), endY, OCEAN_STONES.get(i));
                        }
                    }
                } else if (reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.DESERT) {
                    int stoneCount = DESERT_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,64/stoneCount * (i+1)), DESERT_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,64/stoneCount * (i)), getLayerHeights(x,z,i,64/stoneCount * (i+1)), DESERT_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,64/stoneCount * (i)), endY, DESERT_STONES.get(i));
                        }
                    }
                } else if (reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.MESA) {
                    int stoneCount = MESA_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,64/stoneCount * (i+1)), MESA_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,64/stoneCount * (i)), getLayerHeights(x,z,i,64/stoneCount * (i+1)), MESA_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,64/stoneCount * (i)), endY, MESA_STONES.get(i));
                        }
                    }
                } else if (reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.EXTREME_HILLS) {
                    int stoneCount = MOUNTAIN_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,80/stoneCount * (i+1)), MOUNTAIN_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,80/stoneCount * (i)), getLayerHeights(x,z,i,80/stoneCount * (i+1)), MOUNTAIN_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,80/stoneCount * (i)), endY, MOUNTAIN_STONES.get(i));
                        }
                    }
                } else if (reader.getBiome(new BlockPos(x,0,z)).getCategory() == Biome.Category.SWAMP) {
                    int stoneCount = SWAMP_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,70/stoneCount * (i+1)), SWAMP_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,70/stoneCount * (i)), getLayerHeights(x,z,i,70/stoneCount * (i+1)), SWAMP_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,70/stoneCount * (i)), endY, SWAMP_STONES.get(i));
                        }
                    }
                } else {
                    int stoneCount = DEFAULT_STONES.size();
                    for (int i = 0; i < stoneCount; ++i) {
                        if (i == 0) {
                            replaceStone(reader, config, x, z, 0, getLayerHeights(x,z,i,70/stoneCount * (i+1)), DEFAULT_STONES.get(i));
                        } else if (i < stoneCount-1) {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,70/stoneCount * (i)), getLayerHeights(x,z,i,70/stoneCount * (i+1)), DEFAULT_STONES.get(i));
                        } else {
                            replaceStone(reader, config, x, z, getLayerHeights(x,z,i-1,70/stoneCount * (i)), endY, DEFAULT_STONES.get(i));
                        }
                    }
                }
            }
        }
        return true;
    }


    private static int getLayerHeights(int x, int z, int index, int height) {
        double noise = Biome.INFO_NOISE.noiseAt((double)x / NOISE_SCALE + index * NOISE_OFFSET, (double)z / NOISE_SCALE + index * NOISE_OFFSET, false);
        return height + (int) Math.round((noise/0.2D));
    }

    private static void replaceStone(ISeedReader reader, StoneReplacerFeatureConfig config, int x, int z, int StartY, int EndY, BlockState Block) {
        for (int y = StartY; y <= EndY; ++y) {
            if (reader.getBlockState(new BlockPos(x, y, z)).getBlock() == config.target.getBlock()) {
                reader.setBlockState(new BlockPos(x, y, z), Block, 2);
            }
        }
    }

    private static void replaceAll(ISeedReader reader, StoneReplacerFeatureConfig config, int x, int z, int StartY, int EndY, BlockState Block) {
        for (int y = StartY; y <= EndY; ++y) {
            if (reader.getBlockState(new BlockPos(x, y, z)).getBlock().getTags().contains(new ResourceLocation("forge:stone"))) {
                reader.setBlockState(new BlockPos(x, y, z), Block, 2);
            }
        }
    }
}
