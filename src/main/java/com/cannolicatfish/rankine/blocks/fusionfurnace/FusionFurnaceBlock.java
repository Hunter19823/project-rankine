package com.cannolicatfish.rankine.blocks.fusionfurnace;

import com.cannolicatfish.rankine.blocks.inductionfurnace.InductionFurnaceTile;
import com.cannolicatfish.rankine.blocks.rankinebox.RankineBoxTile;
import com.cannolicatfish.rankine.recipe.helper.FluidHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class FusionFurnaceBlock extends Block {
    public FusionFurnaceBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(BlockStateProperties.LIT)) {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + 0.4D;
            double d2 = (double)pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
            Direction direction = stateIn.get(BlockStateProperties.HORIZONTAL_FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getXOffset() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getZOffset() * 0.52D : d4;
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(BlockStateProperties.LIT, false);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.get(BlockStateProperties.LIT) ? super.getLightValue(state,world,pos) : 0;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FusionFurnaceTile();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (!world.isRemote) {
            LazyOptional<IFluidHandlerItem> item = FluidUtil.getFluidHandler(player.getHeldItem(hand));
            FusionFurnaceTile fusionFurnaceTile = (FusionFurnaceTile) world.getTileEntity(pos);
            if (item.isPresent() && fusionFurnaceTile != null) {
                FluidActionResult emptyContainerAndStow = FluidUtil.tryEmptyContainerAndStow(player.getHeldItem(hand), fusionFurnaceTile.inputTank, new InvWrapper(player.inventory), fusionFurnaceTile.inputTank.getCapacity(), player, true);
                if (emptyContainerAndStow.isSuccess()) {
                    player.setHeldItem(hand, emptyContainerAndStow.getResult());
                    world.markChunkDirty(pos, fusionFurnaceTile);
                    return ActionResultType.CONSUME;
                }

                FluidActionResult fillContainerAndStowOutput = FluidUtil.tryFillContainerAndStow(player.getHeldItem(hand), fusionFurnaceTile.outputTank, new InvWrapper(player.inventory), fusionFurnaceTile.outputTank.getFluidAmount(), player, true);
                if (fillContainerAndStowOutput.isSuccess()) {
                    player.setHeldItem(hand, fillContainerAndStowOutput.getResult());
                    world.markChunkDirty(pos, fusionFurnaceTile);
                    return ActionResultType.CONSUME;
                }

                FluidActionResult fillContainerAndStowInput = FluidUtil.tryFillContainerAndStow(player.getHeldItem(hand), fusionFurnaceTile.inputTank, new InvWrapper(player.inventory), fusionFurnaceTile.inputTank.getFluidAmount(), player, true);
                if (fillContainerAndStowInput.isSuccess()) {
                    player.setHeldItem(hand, fillContainerAndStowInput.getResult());
                    world.markChunkDirty(pos, fusionFurnaceTile);
                    return ActionResultType.CONSUME;
                }
            }
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
            return ActionResultType.CONSUME;
        } else
        {
            return ActionResultType.SUCCESS;
        }
    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.matchesBlock(newState.getBlock())) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof FusionFurnaceTile) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (FusionFurnaceTile)tileentity);
                //((InductionFurnaceTile)tileentity).grantStoredRecipeExperience(worldIn, Vector3d.copyCentered(pos));
                worldIn.updateComparatorOutputLevel(pos, this);
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING,BlockStateProperties.LIT);
    }

    @Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

    @Override
    @Nullable
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof INamedContainerProvider ? (INamedContainerProvider)tileentity : null;
    }

}

