package com.cannolicatfish.rankine.entities;

import com.cannolicatfish.rankine.init.RankineEntityTypes;
import com.cannolicatfish.rankine.init.RankineItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class ThoriumArrowEntity extends AbstractArrowEntity {
    protected ThoriumArrowEntity(EntityType<? extends ArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ThoriumArrowEntity(World worldIn, LivingEntity shooter) {
        super(RankineEntityTypes.THORIUM_ARROW, shooter, worldIn);
    }

    @OnlyIn(Dist.CLIENT)
    public ThoriumArrowEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world, EntityType<ThoriumArrowEntity> e) {
        super(e, world);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(RankineItems.THORIUM_ARROW.get());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            LightningBoltEntity ent = new LightningBoltEntity(EntityType.LIGHTNING_BOLT,this.level);
            ent.setPos(this.getX(),this.getY(),this.getZ());
            this.level.addFreshEntity(ent);
            this.remove();
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        super.doPostHurtEffects(living);

        LightningBoltEntity ent = new LightningBoltEntity(EntityType.LIGHTNING_BOLT,this.level);
        ent.setPos(living.getX(),living.getY(),living.getZ());
        this.level.addFreshEntity(ent);

    }
}
