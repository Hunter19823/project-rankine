package com.cannolicatfish.rankine.recipe.helper;

import com.cannolicatfish.rankine.items.alloys.IAlloyItem;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class FluidHelper {
    private static final UUID SLOW_FALLING_ID = UUID.fromString("A5B6CF2A-2F7C-31EF-9022-7C3E7D5E6ABA");
    private static final AttributeModifier SLOW_FALLING = new AttributeModifier(SLOW_FALLING_ID, "Slow falling acceleration reduction", -0.07, AttributeModifier.Operation.ADDITION); // Add -0.07 to 0.08 so we get the vanilla default of 0.01

    public static Vector3d handleFluidAcceleration(Entity ent, double motionScale) {
        AxisAlignedBB axisalignedbb = ent.getBoundingBox().shrink(0.001D);
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.maxY);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        if (!ent.world.isAreaLoaded(i, k, i1, j, l, j1)) {
            return Vector3d.ZERO;
        } else {
            double d0 = 0.0D;
            boolean flag = ent.isPushedByWater();
            boolean flag1 = false;
            Vector3d vector3d = Vector3d.ZERO;
            int k1 = 0;
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(int l1 = i; l1 < j; ++l1) {
                for(int i2 = k; i2 < l; ++i2) {
                    for(int j2 = i1; j2 < j1; ++j2) {
                        blockpos$mutable.setPos(l1, i2, j2);
                        FluidState fluidstate = ent.world.getFluidState(blockpos$mutable);
                        double d1 = (double)((float)i2 + fluidstate.getActualHeight(ent.world, blockpos$mutable));
                        if (d1 >= axisalignedbb.minY) {
                            flag1 = true;
                            d0 = Math.max(d1 - axisalignedbb.minY, d0);
                            if (flag) {
                                Vector3d vector3d1 = fluidstate.getFlow(ent.world, blockpos$mutable);
                                if (d0 < 0.4D) {
                                    vector3d1 = vector3d1.scale(d0);
                                }

                                vector3d = vector3d.add(vector3d1);
                                ++k1;
                            }
                        }
                    }
                }
            }

            if (vector3d.length() > 0.0D) {
                if (k1 > 0) {
                    vector3d = vector3d.scale(1.0D / (double)k1);
                }

                if (!(ent instanceof PlayerEntity)) {
                    vector3d = vector3d.normalize();
                }

                Vector3d vector3d2 = ent.getMotion();
                vector3d = vector3d.scale(motionScale);
                double d2 = 0.003D;
                if (Math.abs(vector3d2.x) < 0.003D && Math.abs(vector3d2.z) < 0.003D && vector3d.length() < 0.0045000000000000005D) {
                    vector3d = vector3d.normalize().scale(0.0045000000000000005D);
                }

                ent.setMotion(ent.getMotion().add(vector3d));
            }
            return vector3d;
        }
    }

    public static void travel(Vector3d travelVector, LivingEntity ent, boolean inLiquid) {
        if (ent.isServerWorld() || ent.canPassengerSteer()) {
            double d0 = 0.08D;
            ModifiableAttributeInstance gravity = ent.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
            boolean flag = ent.getMotion().y <= 0.0D;
            if (flag && ent.isPotionActive(Effects.SLOW_FALLING)) {
                if (!gravity.hasModifier(SLOW_FALLING)) gravity.applyNonPersistentModifier(SLOW_FALLING);
                ent.fallDistance = 0.0F;
            } else if (gravity.hasModifier(SLOW_FALLING)) {
                gravity.removeModifier(SLOW_FALLING);
            }
            d0 = gravity.getValue();

            FluidState fluidstate = ent.world.getFluidState(ent.getPosition());
            if (inLiquid && !ent.func_230285_a_(fluidstate.getFluid())) {
                double d7 = ent.getPosY();
                ent.moveRelative(0.02F, travelVector);
                ent.move(MoverType.SELF, ent.getMotion());
                if (ent.func_233571_b_(FluidTags.LAVA) <= ent.getFluidJumpHeight()) {
                    ent.setMotion(ent.getMotion().mul(0.5D, (double)0.8F, 0.5D));
                    Vector3d vector3d3 = ent.func_233626_a_(d0, flag, ent.getMotion());
                    ent.setMotion(vector3d3);
                } else {
                    ent.setMotion(ent.getMotion().scale(0.5D));
                }

                if (!ent.hasNoGravity()) {
                    ent.setMotion(ent.getMotion().add(0.0D, -d0 / 4.0D, 0.0D));
                }

                Vector3d vector3d4 = ent.getMotion();
                if (ent.collidedHorizontally && ent.isOffsetPositionInLiquid(vector3d4.x, vector3d4.y + (double)0.6F - ent.getPosY() + d7, vector3d4.z)) {
                    ent.setMotion(vector3d4.x, (double)0.3F, vector3d4.z);
                }
            }
        }

        ent.func_233629_a_(ent, ent instanceof IFlyingAnimal);
    }

    public static double horizontalMag(Vector3d vec) {
        return vec.x * vec.x + vec.z * vec.z;
    }

    protected static BlockPos getPositionUnderneath(Entity ent) {
        return new BlockPos(ent.getPositionVec().x, ent.getBoundingBox().minY - 0.5000001D, ent.getPositionVec().z);
    }

    protected static void setFlag(Entity ent, int flag, boolean set) {
        final DataParameter<Byte> FLAGS = EntityDataManager.createKey(Entity.class, DataSerializers.BYTE);
        byte b0 = ent.getDataManager().get(FLAGS);
        if (set) {
            ent.getDataManager().set(FLAGS, (byte)(b0 | 1 << flag));
        } else {
            ent.getDataManager().set(FLAGS, (byte)(b0 & ~(1 << flag)));
        }

    }

    public static int decreaseAirSupply(LivingEntity ent, World world, int air, int amount) {
        int i = EnchantmentHelper.getRespirationModifier(ent);
        return i > 0 && world.getRandom().nextInt(i + 1) > 0 ? air : air - amount;
    }


    public static FluidStack getFluidStack(JsonObject json)
    {
        String fluidName = JSONUtils.getString(json, "fluid");

        Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(fluidName));

        if (fluid == null) {
            throw new JsonSyntaxException("Unknown fluid '" + fluidName + "'");
        }

        return new FluidStack(fluid, JSONUtils.getInt(json, "amount", 1000));
    }

}

