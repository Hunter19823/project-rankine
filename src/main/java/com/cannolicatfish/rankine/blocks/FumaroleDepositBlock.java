package com.cannolicatfish.rankine.blocks;

import com.cannolicatfish.rankine.init.RankineBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FumaroleDepositBlock extends Block {
    public FumaroleDepositBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (random.nextFloat()<0.1 && worldIn.getBlockState(pos.down()).matchesBlock(Blocks.AIR) && worldIn.getBlockState(pos.down()).matchesBlock(Blocks.WATER)) {
            worldIn.setBlockState(pos.down(), RankineBlocks.GWIHABAITE_CRYSTAL.get().getDefaultState().with(GwihabaiteBlock.FACING, Direction.DOWN),3);
        }

        super.randomTick(state, worldIn, pos, random);
    }
}
