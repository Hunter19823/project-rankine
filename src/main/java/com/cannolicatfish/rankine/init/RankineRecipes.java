package com.cannolicatfish.rankine.init;

import com.cannolicatfish.rankine.advancements.ExactCompositionPredicate;
import com.cannolicatfish.rankine.advancements.HarvestLevelPredicate;
import com.cannolicatfish.rankine.advancements.IncludesCompositionPredicate;
import com.cannolicatfish.rankine.advancements.AlloyEnchantabilityPredicate;
import com.cannolicatfish.rankine.entities.CannonballEntity;
import com.cannolicatfish.rankine.entities.CarcassEntity;
import com.cannolicatfish.rankine.items.GasBottleItem;
import com.cannolicatfish.rankine.potion.RankinePotions;
import com.cannolicatfish.rankine.recipe.ElementRecipe;
import com.cannolicatfish.rankine.recipe.helper.AlloyCustomHelper;
import com.cannolicatfish.rankine.recipe.helper.AlloyRecipeHelper;
import com.cannolicatfish.rankine.util.PeriodicTableUtils;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import java.util.*;

public class RankineRecipes {

    private static final IDispenseItemBehavior gasDispenseBehavior = new DefaultDispenseItemBehavior() {
        private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            Block dispensing = Blocks.AIR;
            if (stack.getItem() instanceof GasBottleItem) {
                GasBottleItem bucketitem = (GasBottleItem) stack.getItem();
                dispensing = bucketitem.getGas();
            }

            BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
            World world = source.getWorld();
            if (world.getBlockState(blockpos).isAir()) {
                world.setBlockState(blockpos, dispensing.getDefaultState(),3);
                return new ItemStack(Items.GLASS_BOTTLE);
            } else {
                return this.defaultBehaviour.dispense(source, stack);
            }
        }
    };

    private static final IDispenseItemBehavior bucketItemBehavior = new DefaultDispenseItemBehavior() {
        private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            BucketItem bucketitem = (BucketItem)stack.getItem();
            BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
            World world = source.getWorld();
            if (bucketitem.tryPlaceContainedLiquid((PlayerEntity)null, world, blockpos, (BlockRayTraceResult)null)) {
                bucketitem.onLiquidPlaced(world, stack, blockpos);
                return new ItemStack(Items.BUCKET);
            } else {
                return this.defaultBehaviour.dispense(source, stack);
            }
        }
    };

    private static final IDispenseItemBehavior cannonballItemBehavior = new DefaultDispenseItemBehavior() {
        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            IPosition iposition = DispenserBlock.getDispensePosition(source);
            double d0 = iposition.getX() + (double) ((float) direction.getXOffset() * 0.3F);
            double d1 = iposition.getY() + (double) ((float) direction.getYOffset() * 0.3F);
            double d2 = iposition.getZ() + (double) ((float) direction.getZOffset() * 0.3F);
            World world = source.getWorld();
            Random random = world.rand;
            double d3 = random.nextGaussian() * 0.05D + (double) direction.getXOffset();
            double d4 = random.nextGaussian() * 0.05D + (double) direction.getYOffset();
            double d5 = random.nextGaussian() * 0.05D + (double) direction.getZOffset();
            world.addEntity(Util.make(new CannonballEntity(world, d0, d1, d2, d3, d4, d5), (fireball) -> {
                fireball.setStack(stack);
            }));
            stack.shrink(1);
            return stack;
        }
    };


    private static final IDispenseItemBehavior carcassItemBehavior = new DefaultDispenseItemBehavior() {
        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            IPosition iposition = DispenserBlock.getDispensePosition(source);
            double d0 = iposition.getX() + (double) ((float) direction.getXOffset() * 0.3F);
            double d1 = iposition.getY() + (double) ((float) direction.getYOffset() * 0.3F);
            double d2 = iposition.getZ() + (double) ((float) direction.getZOffset() * 0.3F);
            World world = source.getWorld();
            Random random = world.rand;
            double d3 = random.nextGaussian() * 0.05D + (double) direction.getXOffset();
            double d4 = random.nextGaussian() * 0.05D + (double) direction.getYOffset();
            double d5 = random.nextGaussian() * 0.05D + (double) direction.getZOffset();
            world.addEntity(Util.make(new CarcassEntity(world, d0, d1, d2, d3, d4, d5), (fireball) -> {
                fireball.setStack(stack);
            }));
            stack.shrink(1);
            return stack;
        }
    };

        /**
         * Play the dispense sound from the specified block.
         */
        protected void playDispenseSound(IBlockSource source) {
            source.getWorld().playEvent(1018, source.getBlockPos(), 0);
        }


        public static void registerPotionRecipes() {
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD)),Ingredient.fromItems(RankineItems.MERCURY::get), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), RankinePotions.MERCURY_POISON));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD)),Ingredient.fromItems(RankineItems.SODIUM_CHLORIDE::get,RankineItems.PINK_SALT::get), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), RankinePotions.CONDUCTIVE_POTION));

    }

    public static void registerDispenserBehaviors() {
        for (Item i : RankineLists.GAS_BOTTLES) {
            DispenserBlock.registerDispenseBehavior(i,gasDispenseBehavior);
        }
        DispenserBlock.registerDispenseBehavior(RankineItems.JUGLONE_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.LIQUID_MERCURY_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.AQUA_REGIA_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.HYDROBROMIC_ACID_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.GRAY_MUD_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.RED_MUD_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.SULFURIC_ACID_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.LATEX_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.RESIN_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.SAP_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.MAPLE_SAP_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.BLACK_LIQUOR_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.GREEN_LIQUOR_BUCKET.get(),bucketItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.WHITE_LIQUOR_BUCKET.get(),bucketItemBehavior);

        DispenserBlock.registerDispenseBehavior(RankineItems.CANNONBALL.get(),cannonballItemBehavior);
        DispenserBlock.registerDispenseBehavior(RankineItems.CARCASS.get(),carcassItemBehavior);
    }

    public static void registerPredicates() {
        ItemPredicate.register(new ResourceLocation("rankine","harvest_level_check"), HarvestLevelPredicate::new);
        ItemPredicate.register(new ResourceLocation("rankine","enchant_check"), AlloyEnchantabilityPredicate::new);
        ItemPredicate.register(new ResourceLocation("rankine","exact_composition"), ExactCompositionPredicate::new);
        ItemPredicate.register(new ResourceLocation("rankine","includes_composition"), IncludesCompositionPredicate::new);
    }

    public static String generateAlloyString(IInventory inv) {
        List<ElementRecipe> currentElements = new ArrayList<>();
        List<Integer> currentMaterial = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && AlloyCustomHelper.hasElement(stack.getItem())) {
                Tuple<ElementRecipe,Integer> entry = AlloyCustomHelper.getEntryForElementItem(stack.getItem());
                if (!currentElements.contains(entry.getA())) {
                    currentElements.add(entry.getA());
                    currentMaterial.add(entry.getB());
                }
            }
        }
        int sum = currentMaterial.stream().mapToInt(Integer::intValue).sum();

        List<Integer> percents = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        for (int j = 0; j < currentElements.size(); j++) {
            ElementRecipe curEl = currentElements.get(j);
            int curPer = Math.round(currentMaterial.get(j) * 100f/sum);
            symbols.add(curEl.getSymbol());
            percents.add(curPer);
        }
        return AlloyRecipeHelper.getDirectComposition(percents,symbols);
    }

}
