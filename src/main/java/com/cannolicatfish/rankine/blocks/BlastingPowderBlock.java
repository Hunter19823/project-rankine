package com.cannolicatfish.rankine.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class BlastingPowderBlock extends FallingBlock {
    public BlastingPowderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable net.minecraft.util.Direction face, @Nullable LivingEntity igniter) {
        world.explode(igniter, pos.getX(), pos.getY() + 16 * .0625D, pos.getZ(), 2.4F, Explosion.Mode.BREAK);
        world.removeBlock(pos, false);
    }

    @Override
    public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        Random random = new Random();
        if (random.nextFloat() <= 0.05f)
        {
            if (placer instanceof PlayerEntity)
            {
                if (!((PlayerEntity)placer).abilities.instabuild)
                {
                    catchFire(state, worldIn, pos, null, null);
                }
            } else
            {
                catchFire(state, worldIn, pos, null, null);
            }


        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (worldIn.hasNeighborSignal(pos)) {
            catchFire(state, worldIn, pos, null, null);
        }
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 280;
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
        ItemStack itemstack = player.getItemInHand(handIn);
        Item item = itemstack.getItem();
        if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
            return super.use(state, worldIn, pos, player, handIn, p_225533_6_);
        } else {
            catchFire(state, worldIn, pos, p_225533_6_.getDirection(), player);
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
            if (!player.isCreative()) {
                if (item == Items.FLINT_AND_STEEL) {
                    itemstack.hurtAndBreak(1, player, (p_220287_1_) -> {
                        p_220287_1_.broadcastBreakEvent(handIn);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }

            return ActionResultType.SUCCESS;
        }
    }

    @Override
    public void onProjectileHit(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        if (!worldIn.isClientSide && projectile instanceof AbstractArrowEntity) {
            AbstractArrowEntity abstractarrowentity = (AbstractArrowEntity)projectile;
            Entity entity = abstractarrowentity.getOwner();
            if (abstractarrowentity.isOnFire()) {
                BlockPos blockpos = hit.getBlockPos();
                catchFire(state, worldIn, blockpos, null, entity instanceof LivingEntity ? (LivingEntity)entity : null);
            }
        }

    }

    public void wasExploded(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isClientSide) {
            catchFire(worldIn.getBlockState(pos), worldIn, pos, null,null);
        }
    }

    @Override
    public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        Random random = new Random();
        if (random.nextFloat() <= 0.50f && !player.abilities.instabuild)
        {
            catchFire(worldIn.getBlockState(pos), worldIn, pos, null,player);
        }
    }

    @Override
    public void onLand(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity p_176502_5_)  {
        catchFire(this.defaultBlockState(), worldIn, pos, null, null);
    }


    /**
     * Return whether this block can drop from an explosion.
     */
    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return true;
    }
}
