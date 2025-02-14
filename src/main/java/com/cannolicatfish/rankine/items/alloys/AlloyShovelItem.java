package com.cannolicatfish.rankine.items.alloys;

import com.cannolicatfish.rankine.init.RankineEnchantments;
import com.cannolicatfish.rankine.recipe.helper.AlloyCustomHelper;
import com.google.common.collect.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;

public class AlloyShovelItem extends ShovelItem implements IAlloyTool {
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL);
    private final String defaultComposition;
    private final ResourceLocation defaultAlloyRecipe;

    public AlloyShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, String defaultCompositionIn, @Nullable ResourceLocation defaultAlloyRecipeIn,  Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder.addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getHarvestLevel()));
        this.defaultComposition = defaultCompositionIn;
        this.defaultAlloyRecipe = defaultAlloyRecipeIn;
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        if (!IAlloyItem.getNameOverride(stack).isEmpty()) {
            return new TranslationTextComponent(this.getTranslationKey(stack),new TranslationTextComponent(IAlloyItem.getNameOverride(stack)));
        }
        return new TranslationTextComponent(this.getTranslationKey(stack),new TranslationTextComponent(generateLangFromRecipe(this.defaultAlloyRecipe)));
    }


    /**
     * Called when this item is used when targetting a Block
     */
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Direction e = context.getFace();
        PlayerEntity playerentity = context.getPlayer();
        if (e == Direction.DOWN) {
            if (EnchantmentHelper.getEnchantmentLevel(RankineEnchantments.ENDOLITHIC,context.getItem()) > 0 && blockstate.getMaterial().equals(Material.ROCK) && playerentity != null) {
                for (int x = 2; x <= 32; x++) {
                    BlockPos newPos = blockpos.up(x);
                    if (world.getBlockState(newPos).isAir() && world.getBlockState(newPos.up(1)).isAir() && world.getBlockState(newPos.down(1)).isSolid()){
                        playerentity.setPositionAndUpdate(newPos.getX(), MathHelper.clamp(newPos.getY() + 0.5,0.0D, (double)(world.func_234938_ad_() - 1)),newPos.getZ());
                        context.getItem().damageItem(calcDurabilityLoss(context.getItem(),context.getWorld(),playerentity,false) * 2, playerentity, (p_220040_1_) -> {
                            p_220040_1_.sendBreakAnimation(context.getHand());
                        });
                        SoundEvent soundevent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        world.playSound((PlayerEntity)null,blockpos.getX(), blockpos.getY(), blockpos.getZ(), soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        playerentity.playSound(soundevent, 1.0F, 1.0F);
                        return ActionResultType.func_233537_a_(world.isRemote);
                    }
                }
            }
            return ActionResultType.PASS;
        } else {
            BlockState blockstate1 = SHOVEL_LOOKUP.get(blockstate.getBlock());
            BlockState blockstate2 = null;
            if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
                if (!world.isRemote()) {
                    world.playEvent((PlayerEntity)null, 1009, blockpos, 0);
                }

                CampfireBlock.extinguish(world, blockpos, blockstate);
                blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.FALSE);
            } else if (EnchantmentHelper.getEnchantmentLevel(RankineEnchantments.ENDOLITHIC,context.getItem()) > 0 && blockstate.getMaterial().equals(Material.ROCK) && playerentity != null) {
                for (int x = 2; x <= 32; x++) {
                    BlockPos newPos = blockpos;
                    switch (e.getOpposite()) {
                        case UP:
                            newPos = blockpos.up(x);
                            break;
                        case DOWN:
                            newPos = blockpos.down(x);
                            break;
                        case NORTH:
                            newPos = blockpos.north(x);
                            break;
                        case SOUTH:
                            newPos = blockpos.south(x);
                            break;
                        case EAST:
                            newPos = blockpos.east(x);
                            break;
                        case WEST:
                            newPos = blockpos.west(x);
                            break;
                    }
                    if (world.getBlockState(newPos).isAir() && world.getBlockState(newPos.up(1)).isAir() && world.getBlockState(newPos.down(1)).isSolid()){
                        playerentity.setPositionAndUpdate(newPos.getX(), MathHelper.clamp(newPos.getY() + 0.5,0.0D, (double)(world.func_234938_ad_() - 1)),newPos.getZ());
                        context.getItem().damageItem(calcDurabilityLoss(context.getItem(),context.getWorld(),playerentity,false) * 2, playerentity, (p_220040_1_) -> {
                            p_220040_1_.sendBreakAnimation(context.getHand());
                        });
                        SoundEvent soundevent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        world.playSound((PlayerEntity)null,blockpos.getX(), blockpos.getY(), blockpos.getZ(), soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        playerentity.playSound(soundevent, 1.0F, 1.0F);
                        return ActionResultType.func_233537_a_(world.isRemote);
                    }
                }
            }

            if (blockstate2 != null) {
                if (!world.isRemote) {
                    world.setBlockState(blockpos, blockstate2, 11);
                    if (playerentity != null) {
                        context.getItem().damageItem(calcDurabilityLoss(context.getItem(),context.getWorld(),context.getPlayer(),true), playerentity, (p_220040_1_) -> {
                            p_220040_1_.sendBreakAnimation(context.getHand());
                        });
                    }
                }

                return ActionResultType.func_233537_a_(world.isRemote);
            } else {
                return ActionResultType.PASS;
            }
        }
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (getToolTypes(stack).stream().anyMatch(state::isToolEffective)) return getAlloyMiningSpeed(stack);
        return EFFECTIVE_ON.contains(state.getBlock()) ? getAlloyMiningSpeed(stack) : 1.0F;
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(calcDurabilityLoss(stack,attacker.getEntityWorld(),attacker,false), attacker, (entity) -> {
            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!worldIn.isRemote && state.getBlockHardness(worldIn, pos) != 0.0F) {
            stack.damageItem(calcDurabilityLoss(stack,worldIn,entityLiving,true), entityLiving, (entity) -> {
                entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return getDamage(stack) * 1f / this.getAlloyDurability(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.getAlloyDurability(stack);
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return this.getAlloyEnchantability(stack);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        addAlloyInformation(stack,worldIn,tooltip,flagIn);
        if (flagIn.isAdvanced()) {
            addAdvancedAlloyInformation(stack,worldIn,tooltip,flagIn);
        }
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        this.applyAlloyEnchantments(stack,worldIn);
        super.onCreated(stack, worldIn, playerIn);
    }


    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!this.isAlloyInit(stack)) {
            this.createAlloyNBT(stack,worldIn,this.defaultComposition,this.defaultAlloyRecipe,null);
            this.initStats(stack,getElementMap(this.defaultComposition,worldIn),getAlloyingRecipe(this.defaultAlloyRecipe,worldIn),null);
            this.applyAlloyEnchantments(stack,worldIn);
        } else if (this.needsRefresh(stack)) {
            this.createAlloyNBT(stack,worldIn,IAlloyItem.getAlloyComposition(stack),IAlloyItem.getAlloyRecipe(stack),null);
            this.initStats(stack,getElementMap(IAlloyItem.getAlloyComposition(stack),worldIn),getAlloyingRecipe(IAlloyItem.getAlloyRecipe(stack),worldIn),null);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group) && this.defaultAlloyRecipe == null) {
            items.addAll(AlloyCustomHelper.getItemsFromAlloying(this));
            items.addAll(AlloyCustomHelper.getItemsFromAlloyCrafting(this));
        } else if (this.isInGroup(group)) {
            super.fillItemGroup(group,items);
        }
    }

    @Override
    public String getDefaultComposition() {
        return this.defaultComposition;
    }

    @Override
    public ResourceLocation getDefaultRecipe() {
        return this.defaultAlloyRecipe;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (isAlloyInit(repair) && isAlloyInit(toRepair) && (repair.getItem().getTags().contains(new ResourceLocation("forge:ingots")) || repair.getItem() == this)) {
            String s = IAlloyItem.getAlloyComposition(repair);
            String r = IAlloyItem.getAlloyComposition(toRepair);

            String s2 = IAlloyItem.getAlloyRecipe(repair).toString();
            String r2 = IAlloyItem.getAlloyRecipe(toRepair).toString();
            return !s.isEmpty() && s.equals(r) && s2.equals(r2);
        }
        return false;
    }
}