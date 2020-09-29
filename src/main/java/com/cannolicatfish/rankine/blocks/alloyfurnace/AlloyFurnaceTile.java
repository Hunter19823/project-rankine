package com.cannolicatfish.rankine.blocks.alloyfurnace;

import com.cannolicatfish.rankine.items.AlloyTemplate;
import com.cannolicatfish.rankine.items.ItemTemplate;
import com.cannolicatfish.rankine.items.alloys.AlloyData;
import com.cannolicatfish.rankine.items.alloys.AlloyItem;
import com.cannolicatfish.rankine.recipe.AlloyingRecipesComplex;
import com.cannolicatfish.rankine.recipe.CoalForgeRecipes;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.cannolicatfish.rankine.init.ModBlocks.ALLOY_FURNACE_TILE;

public class AlloyFurnaceTile extends TileEntity implements ISidedInventory, ITickableTileEntity, INamedContainerProvider {

    private static final int[] SLOTS_UP = new int[]{0,1,2,4};
    private static final int[] SLOTS_DOWN = new int[]{5};
    private static final int[] SLOTS_HORIZONTAL = new int[]{3};
    private ItemStack smelting = ItemStack.EMPTY;
    public AlloyFurnaceTile() {
        super(ALLOY_FURNACE_TILE);
    }
    protected NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY);
    private boolean recipeMode = false;
    private ItemStack templateResult = ItemStack.EMPTY;
    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int cookTimeTotal = 800;
    private int percentSlot1 = 0;
    private int percentSlot2 = 0;
    private int percentSlot3 = 0;
    private final IIntArray furnaceData = new IIntArray(){
        public int get(int index)
        {
            switch(index)
            {
                case 0:
                    return AlloyFurnaceTile.this.burnTime;
                case 1:
                    return AlloyFurnaceTile.this.currentBurnTime;
                case 2:
                    return AlloyFurnaceTile.this.cookTime;
                case 3:
                    return AlloyFurnaceTile.this.cookTimeTotal;
                case 4:
                    return AlloyFurnaceTile.this.percentSlot1;
                case 5:
                    return AlloyFurnaceTile.this.percentSlot2;
                case 6:
                    return AlloyFurnaceTile.this.percentSlot3;
                default:
                    return 0;
            }
        }
        public void set(int index, int value)
        {
            switch(index)
            {
                case 0:
                    AlloyFurnaceTile.this.burnTime = value;
                    break;
                case 1:
                    AlloyFurnaceTile.this.currentBurnTime = value;
                    break;
                case 2:
                    AlloyFurnaceTile.this.cookTime = value;
                    break;
                case 3:
                    AlloyFurnaceTile.this.cookTimeTotal = value;
                    break;
                case 4:
                    AlloyFurnaceTile.this.percentSlot1 = value;
                    break;
                case 5:
                    AlloyFurnaceTile.this.percentSlot2 = value;
                    break;
                case 6:
                    AlloyFurnaceTile.this.percentSlot3 = value;
                    break;
            }
        }
        public int size() {
            return 7;
        }
    };

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt,this.items);
        this.burnTime = nbt.getInt("BurnTime");
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeTotal = nbt.getInt("CookTimeTotal");
        this.currentBurnTime = ForgeHooks.getBurnTime(this.items.get(1));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("BurnTime", this.burnTime);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeTotal", this.cookTimeTotal);
        ItemStackHelper.saveAllItems(compound, this.items);

        return compound;
    }

    public void tick() {
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.burnTime;
        }

        if (!this.world.isRemote) {
            calcPercentages();
            ItemStack[] inputs = new ItemStack[]{this.items.get(0), this.items.get(1), this.items.get(2)};
            ItemStack fuel = this.items.get(3);
            if ((this.isBurning() || !fuel.isEmpty() && !this.items.get(0).isEmpty() && !this.items.get(1).isEmpty())) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.burnTime = ForgeHooks.getBurnTime(fuel);
                    this.currentBurnTime = this.burnTime;
                    if (this.isBurning()) {
                        flag1 = true;
                        if (fuel.hasContainerItem())
                            this.items.set(3, fuel.getContainerItem());
                        else
                        if (!fuel.isEmpty()) {
                            Item item = fuel.getItem();
                            fuel.shrink(1);
                            if (fuel.isEmpty()) {
                                this.items.set(3, fuel.getContainerItem());
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;
                    if (this.cookTime == this.cookTimeTotal) {
                        AbstractMap.SimpleEntry<ItemStack,int[]> alloyResult = AlloyingRecipesComplex.getInstance().getAlloyResult(inputs[0], inputs[1], inputs[2]);
                        ItemStack output = alloyResult.getKey();
                        if (output.getItem() instanceof AlloyItem)
                        {
                            int[] v = alloyResult.getValue();
                            AlloyItem.addAlloy(output,new AlloyData(AlloyingRecipesComplex.getInstance().getComposition(inputs[0], inputs[1], inputs[2])));
                        }
                        if (!output.isEmpty()) {
                            smelting = output;
                            this.cookTime++;
                            int[] x = alloyResult.getValue();
                            this.items.set(0, inputs[0]);
                            this.items.set(1, inputs[1]);
                            this.items.set(2, inputs[2]);
                        }
                        if (this.items.get(5).getCount() > 0) {
                            this.items.get(5).grow(smelting.getCount());
                        } else {
                            this.items.set(5, smelting);
                        }
                        int[] x = alloyResult.getValue();
                        inputs[0].shrink(x[0]);
                        inputs[1].shrink(x[1]);
                        inputs[2].shrink(x[2]);
                        smelting = ItemStack.EMPTY;
                        this.cookTime = 0;
                        flag1 = true;
                        return;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.cookTimeTotal);
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(AbstractFurnaceBlock.LIT, this.isBurning()), 3);
            }
        }

        if (flag1) {
            this.markDirty();
        }

    }

    private boolean redstoneCheck()
    {
        return true;
    }


    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isBurning(AlloyFurnaceTile te)
    {
        return te.furnaceData.get(0) > 0;
    }

    private void calcPercentages()
    {
        if((this.items.get(0)).isEmpty() || (this.items.get(1)).isEmpty())
        {
            this.percentSlot1 = 0;
            this.percentSlot2 = 0;
            this.percentSlot3 = 0;
        } else {
            this.percentSlot1 = AlloyingRecipesComplex.getInstance().getPercent(this.items.get(0), this.items.get(1), this.items.get(2), 0);
            this.percentSlot2 = AlloyingRecipesComplex.getInstance().getPercent(this.items.get(0), this.items.get(1), this.items.get(2), 1);
            this.percentSlot3 = AlloyingRecipesComplex.getInstance().getPercent(this.items.get(0), this.items.get(1), this.items.get(2), 2);
        }

    }

    private boolean canSmelt()
    {
        ItemStack template = this.items.get(4);
        if (template.getItem() instanceof AlloyTemplate)
        {
            if (AlloyTemplate.getTemplate(template).size() != 0)
            {
                recipeMode = true;
                templateResult = AlloyTemplate.getResult(template);
            }
        } else
        {
            recipeMode = false;
            templateResult = ItemStack.EMPTY;
        }
        if((this.items.get(0)).isEmpty() || (this.items.get(1)).isEmpty())
        {
            return false;
        }
        else
        {
            ItemStack result = AlloyingRecipesComplex.getInstance().getAlloyResult(this.items.get(0), this.items.get(1), this.items.get(2)).getKey();
            if(result.isEmpty())
            {
                return false;
            }
            else
            {
                AlloyItem.addAlloy(result,new AlloyData(AlloyingRecipesComplex.getInstance().getComposition(this.items.get(0), this.items.get(1), this.items.get(2))));
                ItemStack output = this.items.get(5);

                if(output.isEmpty())
                {
                    /*System.out.println("Template check:");
                    System.out.println("Tags equal: " + ItemStack.areItemStackTagsEqual(result, templateResult));
                    System.out.println("Alloy Furnace result tag:" + result.getTag());
                    System.out.println("Alloy Furnace result stack:" + result);
                    System.out.println("templateResult tag:" + templateResult.getTag());
                    System.out.println("templateResult stack:" + templateResult);
                    System.out.println("Stacks equal: " + ItemStack.areItemStacksEqual(result, templateResult));
                    System.out.println("RecipeMode is " + recipeMode);*/
                    if (!recipeMode || (ItemStack.areItemStackTagsEqual(result, templateResult) && ItemStack.areItemStacksEqual(result, templateResult)))
                    {
                        return true;
                    }

                }

                if(!output.isItemEqual(result))
                {
                    return false;
                }
                int res = output.getCount() + result.getCount();
                if (ItemStack.areItemStackTagsEqual(output,result))
                {
                    if (!recipeMode || (ItemStack.areItemStackTagsEqual(result, templateResult) && ItemStack.areItemStacksEqual(result, templateResult)))
                    {
                        return res <= 64 && res <= output.getMaxStackSize();
                    }
                }
                return false;

            }
        }
    }


    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void remove() {
        super.remove();
        for (int x = 0; x < handlers.length; x++)
            handlers[x].invalidate();
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    @Override
    @Nullable
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new AlloyFurnaceContainer(i, world, pos, playerInventory, playerEntity, this, this.furnaceData);
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_DOWN;
        } else {
            return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
        }
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.items.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.items.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.items.set(index, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.cookTimeTotal = 200;
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        switch (index)
        {
            case 0:
            case 1:
            case 2:
                String mat = AlloyingRecipesComplex.getInstance().returnItemMaterial(stack).getKey();
                return !mat.contains("none") && !mat.contains("nope");
            case 3:
                return AbstractFurnaceTileEntity.isFuel(stack);
            case 4:
                return stack.getItem() instanceof AlloyTemplate;
            case 5:
                return ItemStack.areItemsEqual(AlloyingRecipesComplex.getInstance().getAlloyResult(getStackInSlot(0),getStackInSlot(1),getStackInSlot(2)).getKey(), stack);
            default:
                return false;
        }
    }

    @Override
    public void clear() {
        this.items.clear();
    }

}

