package com.cannolicatfish.rankine.enchantment;

import com.cannolicatfish.rankine.init.Config;
import com.cannolicatfish.rankine.init.RankineEnchantmentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class PryingEnchantment extends Enchantment {
    public PryingEnchantment(Enchantment.Rarity p_i46721_1_, EquipmentSlotType... p_i46721_2_) {
        super(p_i46721_1_, RankineEnchantmentTypes.CROWBAR, p_i46721_2_);
    }

    public int getMinCost(int p_77321_1_) {
        return 1 + 10 * (p_77321_1_ - 1);
    }

    public int getMaxCost(int p_223551_1_) {
        return super.getMinCost(p_223551_1_) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && (!(target instanceof PlayerEntity) || Config.GENERAL.PLAYER_PRYING_ENCHANTMENT.get()))
        {
            int player = target instanceof PlayerEntity ? 1 : 0;
            LivingEntity ent = (LivingEntity) target;
            if (ent.hasItemInSlot(EquipmentSlotType.MAINHAND) && ent.getCommandSenderWorld().getRandom().nextFloat() <= Math.pow(2f,level + 2 - ent.getItemBySlot(EquipmentSlotType.MAINHAND).getRarity().ordinal() - player)/100) {

                ent.spawnAtLocation(ent.getItemBySlot(EquipmentSlotType.MAINHAND));
                ent.setItemSlot(EquipmentSlotType.MAINHAND,ItemStack.EMPTY);
            }
        }
    }
}
