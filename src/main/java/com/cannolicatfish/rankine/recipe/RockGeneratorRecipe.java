package com.cannolicatfish.rankine.recipe;

import com.cannolicatfish.rankine.init.RankineBlocks;
import com.cannolicatfish.rankine.init.RankineItems;
import com.cannolicatfish.rankine.init.RankineRecipeTypes;
import com.cannolicatfish.rankine.recipe.helper.BlockRecipeHelper;
import com.cannolicatfish.rankine.util.RockGeneratorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RockGeneratorRecipe implements IRecipe<IInventory> {

    public static final RockGeneratorRecipe.Serializer SERIALIZER = new RockGeneratorRecipe.Serializer();
    protected RockGeneratorUtils.RockGenType genType;
    protected Ingredient ingredient1;
    protected Ingredient ingredient2;
    protected ItemStack result;
    protected final ResourceLocation id;

    public RockGeneratorRecipe(ResourceLocation id, RockGeneratorUtils.RockGenType genType, Ingredient input, Ingredient input2, ItemStack output) {
        this.id = id;
        this.genType = genType;
        this.ingredient1 = input;
        this.ingredient2 = input2;
        this.result = output;
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    public String getGroup() {
        return "";
    }

    public RockGeneratorUtils.RockGenType getGenType() {
        return genType;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if (this.getGenType().equals(RockGeneratorUtils.RockGenType.EXTRUSIVE_IGNEOUS) || this.getGenType().equals(RockGeneratorUtils.RockGenType.METAMORPHIC) || this.getGenType().equals(RockGeneratorUtils.RockGenType.VOLCANIC)) {
            boolean test;
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                test = this.ingredient1.test(inv.getStackInSlot(i));
                if (test) {
                    return true;
                }
            }
            return false;
        } else {
            boolean test1 = false;
            boolean test2 = false;
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                if (!test1) {
                    test1 = this.ingredient1.test(inv.getStackInSlot(i));
                }
                if (!test2) {
                    test2 = this.ingredient2.test(inv.getStackInSlot(i));
                }
                if (test1 && test2) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    public BlockPos getRandomInput(Map<BlockPos,Block> map) {
        for (Map.Entry<BlockPos,Block> b: map.entrySet()) {
            if (this.ingredient1.test(new ItemStack(b.getValue())) || this.ingredient2.test(new ItemStack(b.getValue()))) {
                return b.getKey();
            }
        }
        return null;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        if (this.getGenType().equals(RockGeneratorUtils.RockGenType.SEDIMENTARY)) {
            return NonNullList.from(Ingredient.EMPTY, ingredient1, ingredient2, Ingredient.fromStacks(new ItemStack(RankineItems.SEDIMENT_FAN.get())));
        } else if (this.getGenType().equals(RockGeneratorUtils.RockGenType.EXTRUSIVE_IGNEOUS))
        {
            return NonNullList.from(Ingredient.EMPTY, ingredient1, Ingredient.fromStacks(new ItemStack(Items.SOUL_SOIL)),Ingredient.fromStacks(new ItemStack(Items.BLUE_ICE)));
        } else if (this.getGenType().equals(RockGeneratorUtils.RockGenType.METAMORPHIC) || this.getGenType().equals(RockGeneratorUtils.RockGenType.VOLCANIC)) {
            return NonNullList.from(Ingredient.EMPTY, ingredient1);
        } else {
            return NonNullList.from(Ingredient.EMPTY, ingredient1, ingredient2);
        }

    }

    public Ingredient getFirstIngredient() {
        return ingredient1;
    }

    public Ingredient getSecondIngredient() {
        return ingredient2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return RankineRecipeTypes.ROCK_GENERATOR;
    }

    public static ItemStack deserializeBlock(JsonObject object) {
        String s = JSONUtils.getString(object, "block");

        Block block = Registry.BLOCK.getOptional(new ResourceLocation(s)).orElseThrow(() -> {
            return new JsonParseException("Unknown block '" + s + "'");
        });

        if (object.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        } else {
            return BlockRecipeHelper.getBlockItemStack(object);
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RockGeneratorRecipe> {

        @Override
        public RockGeneratorRecipe read(ResourceLocation recipeId, JsonObject json) {
            RockGeneratorUtils.RockGenType t = json.has("genType") ? RockGeneratorUtils.RockGenType.valueOf(json.get("genType").getAsString().toUpperCase(Locale.ROOT)) : RockGeneratorUtils.RockGenType.INTRUSIVE_IGNEOUS;
            Ingredient ingredient1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input1"));
            Ingredient ingredient2;
            if (t.equals(RockGeneratorUtils.RockGenType.EXTRUSIVE_IGNEOUS) || t.equals(RockGeneratorUtils.RockGenType.METAMORPHIC) || t.equals(RockGeneratorUtils.RockGenType.VOLCANIC)) {
                ingredient2 = Ingredient.EMPTY;
            } else {
                ingredient2 = json.has("input2") ? Ingredient.deserialize(JSONUtils.getJsonObject(json, "input2")) : Ingredient.EMPTY;
            }

            ItemStack result = deserializeBlock(JSONUtils.getJsonObject(json, "result"));
            return new RockGeneratorRecipe(recipeId,t,ingredient1,ingredient2,result);
        }

        @Nullable
        @Override
        public RockGeneratorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            RockGeneratorUtils.RockGenType t = RockGeneratorUtils.RockGenType.valueOf(buffer.readString().toUpperCase(Locale.ROOT));
            Ingredient input1 = Ingredient.read(buffer);
            Ingredient input2 = Ingredient.read(buffer);
            ItemStack output = buffer.readItemStack();

            return new RockGeneratorRecipe(recipeId,t,input1,input2,output);
        }

        @Override
        public void write(PacketBuffer buffer, RockGeneratorRecipe recipe) {
            buffer.writeString(recipe.getGenType().toString());
            recipe.getFirstIngredient().write(buffer);
            recipe.getSecondIngredient().write(buffer);
            buffer.writeItemStack(recipe.getRecipeOutput());
        }
    }

}
