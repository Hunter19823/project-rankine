package com.cannolicatfish.rankine.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CrushingHeadItem extends Item {
    private final int tier;
    public CrushingHeadItem(int tierIn, Properties properties) {
        super(properties);
        this.tier = tierIn;
    }

    private int getTier() {
        return this.tier;
    }

    public static int getTier(ItemStack stack) {
        if (stack.getItem() instanceof CrushingHeadItem) {
            return ((CrushingHeadItem) stack.getItem()).getTier();
        } else {
            return -1;
        }
    }
}
