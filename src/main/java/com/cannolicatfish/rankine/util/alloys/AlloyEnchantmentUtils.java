package com.cannolicatfish.rankine.util.alloys;

import com.cannolicatfish.rankine.items.alloys.IAlloyTool;
import com.cannolicatfish.rankine.items.tools.CrowbarItem;
import com.cannolicatfish.rankine.items.tools.HammerItem;
import com.cannolicatfish.rankine.items.tools.KnifeItem;
import com.cannolicatfish.rankine.items.tools.SpearItem;
import com.cannolicatfish.rankine.recipe.ElementRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class AlloyEnchantmentUtils {


    public static List<Enchantment> getElementEnchantments(List<ElementRecipe> elements, List<Integer> percents, ItemStack stack) {
        List<Enchantment> enchantments = new ArrayList<>();
        List<Float> enchantmentTotals = new ArrayList<>();
        for (int e = 0; e < elements.size(); e++) {
            ElementRecipe element = elements.get(e);
            int percent = percents.get(e);
            List<String> elementEnchants = element.getEnchantments();
            List<String> elementEnchantTypes = element.getEnchantmentTypes();
            List<Float> elementEnchantFactors = element.getEnchantmentFactors();

            for (int i = 0; i < elementEnchants.size(); i++) {
                Enchantment en = ForgeRegistries.ENCHANTMENTS.getValue(new ResourceLocation(elementEnchants.get(i)));
                if (en != null && matchesEnchantmentType(en,stack,EnchantmentTypes.valueOf(elementEnchantTypes.get(i)))) {
                    if (!enchantments.contains(en)) {
                        enchantments.add(en);
                        enchantmentTotals.add(0f);
                    }
                    int index = enchantments.indexOf(en);
                    enchantmentTotals.set(index,enchantmentTotals.get(index) + elementEnchantFactors.get(i)*percent); // bound -1 to 1 in recipe class
                }
            }
        }

        List<Enchantment> finalEnchantments = new ArrayList<>();
        for (int i = 0; i < enchantments.size(); i++) {
            if (enchantmentTotals.get(i) >= 1) {
                finalEnchantments.add(enchantments.get(i));
            }
        }

        return finalEnchantments;
    }

    public static boolean matchesEnchantmentType(Enchantment enchantment, ItemStack stack, EnchantmentTypes type) {
        switch (type) {
            case ALL:
                return enchantment.canApply(stack);
            case TOOLS:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ToolItem || stack.getItem() instanceof SwordItem);
            case ARMOR:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ArmorItem);
            case PICKAXE:
                return enchantment.canApply(stack) && (stack.getItem() instanceof PickaxeItem);
            case AXE:
                return enchantment.canApply(stack) && (stack.getItem() instanceof AxeItem);
            case SPEAR:
                return enchantment.canApply(stack) && (stack.getItem() instanceof SpearItem);
            case SHOVEL:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ShovelItem);
            case HOE:
                return enchantment.canApply(stack) && (stack.getItem() instanceof HoeItem);
            case SWORD:
                return enchantment.canApply(stack) && (stack.getItem() instanceof SwordItem);
            case HAMMER:
                return enchantment.canApply(stack) && (stack.getItem() instanceof HammerItem);
            case KNIFE:
                return enchantment.canApply(stack) && (stack.getItem() instanceof KnifeItem);
            case CROWBAR:
                return enchantment.canApply(stack) && (stack.getItem() instanceof CrowbarItem);
            case HELMET:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ArmorItem) && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.HEAD;
            case CHESTPLATE:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ArmorItem) && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.CHEST;
            case LEGGINGS:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ArmorItem) && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.LEGS;
            case BOOTS:
                return enchantment.canApply(stack) && (stack.getItem() instanceof ArmorItem) && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.FEET;
            default:
                return enchantment.canApply(stack);
        }
    }

    public enum EnchantmentTypes {
        ALL,
        TOOLS,
        ARMOR,
        PICKAXE,
        AXE,
        SPEAR,
        SHOVEL,
        HOE,
        SWORD,
        HAMMER,
        KNIFE,
        CROWBAR,
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        SHIELD

    }
}
