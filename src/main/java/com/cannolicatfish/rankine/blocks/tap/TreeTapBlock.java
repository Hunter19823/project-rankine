package com.cannolicatfish.rankine.blocks.tap;

import com.cannolicatfish.rankine.blocks.FloodGateBlock;
import com.cannolicatfish.rankine.blocks.states.TapBarrelFluids;
import com.cannolicatfish.rankine.blocks.states.TreeTapFluids;
import com.cannolicatfish.rankine.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;

public class TreeTapBlock extends Block {
    public static final EnumProperty<TreeTapFluids> FLUID = EnumProperty.create("fluid", TreeTapFluids.class);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(7.0D, 9.0D, 7.0D, 16.0D, 12.0D, 9.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 9.0D, 7.0D, 9.0D, 12.0D, 9.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(7.0D, 9.0D, 7.0D, 9.0D, 12.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(7.0D, 9.0D, 0.0D, 9.0D, 12.0D, 9.0D);
    protected static final VoxelShape TAP_WEST_AABB = Block.makeCuboidShape(5.0D, 0.0D, 4.0D, 16.0D, 13.0D, 12.0D);
    protected static final VoxelShape TAP_EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 11.0D, 13.0D, 12.0D);
    protected static final VoxelShape TAP_NORTH_AABB = Block.makeCuboidShape(4.0D, 0.0D, 5.0D, 12.0D, 13.0D, 16.0D);
    protected static final VoxelShape TAP_SOUTH_AABB = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 13.0D, 11.0D);

    private int ticks = 0;

    public TreeTapBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FLUID, TreeTapFluids.NONE).with(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(FLUID).equals(TreeTapFluids.NONE)) {
            switch ((Direction) state.get(FACING)) {
                case NORTH:
                    return NORTH_AABB;
                case SOUTH:
                    return SOUTH_AABB;
                case WEST:
                    return WEST_AABB;
                case EAST:
                default:
                    return EAST_AABB;
            }
        } else {
            switch((Direction)state.get(FACING)) {
                case NORTH:
                    return TAP_NORTH_AABB;
                case SOUTH:
                    return TAP_SOUTH_AABB;
                case WEST:
                    return TAP_WEST_AABB;
                case EAST:
                default:
                    return TAP_EAST_AABB;
            }
        }
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        ticks += 1;
        if (!worldIn.isRemote() && ticks >= Config.MACHINES.TREE_TAP_SPEED.get() && isTreeAlive(pos,worldIn)) {

            //checks for other taps
            List<BlockPos> sides = Arrays.asList(pos.up(), pos.down(), pos.north(), pos.south(), pos.west(), pos.east());
            for (BlockPos s : sides) {
                if (worldIn.getBlockState(s).getBlock() == RankineBlocks.TREE_TAP.get()) {
                    return;
                }
            }

            if (state.get(FLUID).equals(TreeTapFluids.EMPTY)) {
                Block log = null;
                switch (state.get(FACING)) {
                    case NORTH:
                        log = worldIn.getBlockState(pos.south()).getBlock();
                        break;
                    case SOUTH:
                        log = worldIn.getBlockState(pos.north()).getBlock();
                        break;
                    case EAST:
                        log = worldIn.getBlockState(pos.west()).getBlock();
                        break;
                    case WEST:
                        log = worldIn.getBlockState(pos.east()).getBlock();
                        break;
                }
                if (log != null) {
                    if (log.getTags().contains(new ResourceLocation("rankine:logs_sap")) && Config.MACHINES.TREE_TAP_SAP.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.SAP).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_maple_sap")) && Config.MACHINES.TREE_TAP_MAPLE_SAP.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.MAPLE_SAP).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_resin")) && Config.MACHINES.TREE_TAP_RESIN.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.RESIN).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_latex")) && Config.MACHINES.TREE_TAP_LATEX.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.LATEX).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_juglone")) && Config.MACHINES.TREE_TAP_JUGLONE.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.JUGLONE).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_water")) && Config.MACHINES.TREE_TAP_WATER.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.WATER).with(FACING, state.get(FACING)),3);
                    } else if (log.getTags().contains(new ResourceLocation("rankine:logs_lava")) && Config.MACHINES.TREE_TAP_LAVA.get()) {
                        worldIn.setBlockState(pos, this.getDefaultState().with(FLUID, TreeTapFluids.LAVA).with(FACING, state.get(FACING)),3);
                    }
                }
            }
            ticks = 0;
        }

        if (!worldIn.isRemote() && !state.get(FLUID).equals(TreeTapFluids.NONE) && !state.get(FLUID).equals(TreeTapFluids.EMPTY) && worldIn.getBlockState(pos.down()).getBlock().matchesBlock(RankineBlocks.TAP_LINE.get())) {
            BlockPos barrel = null;
            Set<BlockPos> checkedBlocks = new HashSet<>();
            Stack<BlockPos> toCheck = new Stack<>();
            toCheck.add(pos.down());
            while (!toCheck.isEmpty()) {
                BlockPos cp = toCheck.pop();
                if (!checkedBlocks.contains(cp)) {
                    checkedBlocks.add(cp);
                    if (worldIn.isBlockLoaded(cp)) {
                        BlockState s = worldIn.getBlockState(cp);
                        if (s.getBlock().matchesBlock(RankineBlocks.FLOOD_GATE.get())) {
                                barrel = cp;
                                break;
                        } else if (s.getBlock().matchesBlock(RankineBlocks.TAP_LINE.get())) {
                            toCheck.add(cp.north());
                            toCheck.add(cp.east());
                            toCheck.add(cp.south());
                            toCheck.add(cp.west());
                            toCheck.add(cp.down());
                        }
                    }
                    if (checkedBlocks.size() > 200) {
                        break;
                    }
                }
            }

            if (barrel != null && VanillaIntegration.tapFluids_map.get(state.get(FLUID)) != null) {
                FloodGateBlock.placeFluid(worldIn, barrel, VanillaIntegration.tapFluids_map.get(state.get(FLUID)));
                worldIn.setBlockState(pos,state.with(FLUID,TreeTapFluids.EMPTY));
            }
        }
    }

    private boolean isTreeAlive(BlockPos pos, World worldIn) {
        Set<BlockPos> checkedBlocks = new HashSet<>();
        Stack<BlockPos> toCheck = new Stack<>();

        toCheck.add(pos.offset(worldIn.getBlockState(pos).get(FACING).getOpposite()));
        while (!toCheck.isEmpty()) {
            BlockPos cp = toCheck.pop();
            if (!checkedBlocks.contains(cp)) {
                checkedBlocks.add(cp);
                for (BlockPos b : BlockPos.getAllInBoxMutable(cp.add(-1,-1,-1), cp.add(1,1,1))) {
                    BlockState target = worldIn.getBlockState(b.toImmutable());
                   if (target.isIn(RankineTags.Blocks.TREE_LEAVES)) {
                        if (!target.get(LeavesBlock.PERSISTENT)) {
                            return true;
                        }
                    } else if (target.isIn(RankineTags.Blocks.TREE_LOGS)) {
                        toCheck.add(b.toImmutable());
                    }
                }
                if (toCheck.size() > 300) {
                    break;
                }
            }
        }
        return false;
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {

        switch (state.get(TreeTapBlock.FLUID)) {
            case NONE:
                ItemStack stack = player.getHeldItemMainhand();
                if (stack.getItem() == Items.BUCKET) {
                    worldIn.setBlockState(pos, state.with(TreeTapBlock.FLUID, TreeTapFluids.EMPTY).with(TreeTapBlock.FACING, state.get(TreeTapBlock.FACING)));
                    worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_CHAIN_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
                    if (!player.abilities.isCreativeMode) {
                        stack.shrink(1);
                    }
                    return ActionResultType.SUCCESS;
                } else {
                    return ActionResultType.FAIL;
                }
            case EMPTY:
                player.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
                break;
            case WATER:
                player.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET, 1));
                break;
            case LAVA:
                player.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
                break;
            case SAP:
                player.addItemStackToInventory(new ItemStack(RankineItems.SAP_BUCKET.get(), 1));
                break;
            case MAPLE_SAP:
                player.addItemStackToInventory(new ItemStack(RankineItems.MAPLE_SAP_BUCKET.get(), 1));
                break;
            case RESIN:
                player.addItemStackToInventory(new ItemStack(RankineItems.RESIN_BUCKET.get(), 1));
                break;
            case LATEX:
                player.addItemStackToInventory(new ItemStack(RankineItems.LATEX_BUCKET.get(), 1));
                break;
            case JUGLONE:
                player.addItemStackToInventory(new ItemStack(RankineItems.JUGLONE_BUCKET.get(), 1));
                break;
        }
        worldIn.setBlockState(pos, state.with(TreeTapBlock.FLUID, TreeTapFluids.NONE).with(TreeTapBlock.FACING, state.get(TreeTapBlock.FACING)));
        worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_CHAIN_HIT, SoundCategory.BLOCKS, 1.0F, 0.5F + worldIn.rand.nextFloat() * 0.4F);
        return ActionResultType.SUCCESS;

    }



    private boolean canAttachTo(IBlockReader blockReader, BlockPos pos, Direction direction) {
        BlockState blockstate = blockReader.getBlockState(pos);
        return blockstate.isSolidSide(blockReader, pos, direction);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canAttachTo(worldIn, pos.offset(direction.getOpposite()), direction);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FLUID, TreeTapFluids.NONE).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FLUID, FACING);
    }

}
