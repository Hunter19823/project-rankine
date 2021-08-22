package com.cannolicatfish.rankine.world.gen.feature;

import com.cannolicatfish.rankine.init.RankineBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CoralBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MudReplacerFeature extends Feature<NoFeatureConfig> {
    public MudReplacerFeature(Codec<NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        IChunk chunk = reader.getChunk(pos);
        int startX = chunk.getPos().getXStart();
        int startZ = chunk.getPos().getZStart();
        int endX = chunk.getPos().getXEnd();
        int endZ = chunk.getPos().getZEnd();
        for (int x = startX; x <= endX; ++x) {
            for (int z = startZ; z <= endZ; ++z) {
                int endY = reader.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, x, z);
                for (int y = 0; y <= endY; ++y) {
                    BlockPos b = new BlockPos(x,y,z);
                    if (reader.getBlockState(b) == Blocks.DIRT.getDefaultState() && (reader.getBlockState(b.up()) == Blocks.WATER.getDefaultState() || reader.getBlockState(b.down()) == Blocks.WATER.getDefaultState() || reader.getBlockState(b.east()) == Blocks.WATER.getDefaultState() || reader.getBlockState(b.west()) == Blocks.WATER.getDefaultState() || reader.getBlockState(b.south()) == Blocks.WATER.getDefaultState() || reader.getBlockState(b.north()) == Blocks.WATER.getDefaultState()) ) {
                        //reader.setBlockState(b, RankineBlocks.MUD.get().getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}