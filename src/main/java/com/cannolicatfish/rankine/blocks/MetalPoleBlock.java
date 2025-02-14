package com.cannolicatfish.rankine.blocks;

import com.cannolicatfish.rankine.init.RankineItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MetalPoleBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty STYLE = IntegerProperty.create("style",0,1);
    int alloyColor;

    public MetalPoleBlock(int color) {
        super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.AIR).setRequiresTool().hardnessAndResistance(4.0F, 6.0F).sound(SoundType.METAL).notSolid());
        this.alloyColor = color;
        this.setDefaultState(this.stateContainer.getBaseState().with(STYLE,0).with(WATERLOGGED, Boolean.FALSE));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STYLE,WATERLOGGED);
    }

    public int getColor() {
        return this.alloyColor;
    }


    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        //VoxelShape BOX = makeCuboidShape(0,0,0,0,0,0);
        VoxelShape main = makeCuboidShape(5,0,5,11,16,11);
        /*
        if (state.get(NORTH)) {
            BOX = makeCuboidShape(5,12,0,11,16,5);
        }
        if (state.get(SOUTH)) {
            BOX = makeCuboidShape(5,10,11,11,16,16);
        }
        if (state.get(WEST)) {
            BOX = makeCuboidShape(0,10,5,5,16,11);
        }
        if (state.get(EAST)) {
            BOX = makeCuboidShape(11,10,5,16,16,11);
        }
        main = VoxelShapes.combineAndSimplify(main, BOX, IBooleanFunction.OR);

         */
        return main;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }
/*
    public BlockState makeConnections(IBlockReader blockReader, BlockPos pos) {
        BlockState bs1 = blockReader.getBlockState(pos.north());
        BlockState bs2 = blockReader.getBlockState(pos.east());
        BlockState bs3 = blockReader.getBlockState(pos.south());
        BlockState bs4 = blockReader.getBlockState(pos.west());
        return this.getDefaultState()
                .with(NORTH,  bs1 == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HANGING, false).with(SodiumVaporLampBlock.HORIZONTAL_FACING, Direction.NORTH))
                .with(EAST, bs2 == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HANGING, false).with(SodiumVaporLampBlock.HORIZONTAL_FACING, Direction.EAST))
                .with(SOUTH, bs3 == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HANGING, false).with(SodiumVaporLampBlock.HORIZONTAL_FACING, Direction.SOUTH))
                .with(WEST, bs4 == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HANGING, false).with(SodiumVaporLampBlock.HORIZONTAL_FACING, Direction.WEST));
    }

 */

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        /*
        boolean flag;
        switch (facing) {
            case NORTH:
                flag = facingState == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HORIZONTAL_FACING, facing).with(SodiumVaporLampBlock.HANGING, false);
                return stateIn.with(NORTH, flag);
            case SOUTH:
                flag = facingState == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HORIZONTAL_FACING, facing).with(SodiumVaporLampBlock.HANGING, false);
                return stateIn.with(SOUTH, flag);
            case EAST:
                flag = facingState == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HORIZONTAL_FACING, facing).with(SodiumVaporLampBlock.HANGING, false);
                return stateIn.with(EAST, flag);
            case WEST:
                flag = facingState == RankineBlocks.SODIUM_VAPOR_LAMP.get().getDefaultState().with(SodiumVaporLampBlock.HORIZONTAL_FACING, facing).with(SodiumVaporLampBlock.HANGING, false);
                return stateIn.with(WEST, flag);
        }

         */
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);

    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getHeldItem(handIn).getItem().equals(RankineItems.GARLAND.get()) && state.get(STYLE) != 1 && !worldIn.isRemote) {
            worldIn.setBlockState(pos,state.with(STYLE,1));
            worldIn.playSound(null,pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS,0.8f,0.8f);
            player.swing(handIn,true);
            if (!player.isCreative()) player.getHeldItem(handIn).shrink(1);

        } else if (player.isSneaking()) {
            int n = 1;
            while (worldIn.getBlockState(pos.down(n)).getBlock() == this.getBlock()) {
                n += 1;
            }
            if (!worldIn.isRemote) {
                BlockPos newpos = pos.add(0,-n+1,0);
                if (worldIn.isAirBlock(newpos.north()) && worldIn.isAirBlock(newpos.north().up())) {
                    newpos = newpos.north();
                } else if (worldIn.isAirBlock(newpos.east()) && worldIn.isAirBlock(newpos.east().up())) {
                    newpos = newpos.east();
                } else if (worldIn.isAirBlock(newpos.south()) && worldIn.isAirBlock(newpos.south().up())) {
                    newpos = newpos.south();
                } else if (worldIn.isAirBlock(newpos.west()) && worldIn.isAirBlock(newpos.west().up())) {
                    newpos = newpos.west();
                }
                player.setPositionAndUpdate(newpos.getX() + .5f, newpos.getY(), newpos.getZ() + .5f);
                player.playSound(SoundEvents.BLOCK_METAL_FALL, SoundCategory.BLOCKS,0.8f,1.0f);
                if (n>5) {
                    player.attackEntityFrom(DamageSource.FALL, 1.0F);
                }
                return ActionResultType.FAIL;
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }


}
