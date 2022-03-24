package com.cannolicatfish.rankine.events.handlers.common;

import com.cannolicatfish.rankine.enchantment.RankineEnchantmentHelper;
import com.cannolicatfish.rankine.init.Config;
import com.cannolicatfish.rankine.init.RankineAttributes;
import com.cannolicatfish.rankine.init.RankineEnchantments;
import com.cannolicatfish.rankine.init.RankineItems;
import com.cannolicatfish.rankine.init.RankineTags;
import com.cannolicatfish.rankine.init.VanillaIntegration;
import com.cannolicatfish.rankine.items.InformationItem;
import com.cannolicatfish.rankine.items.totems.InvigoratingTotemItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FrostedIceBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PlayerTickHandler {
    public static void onPlayerTick( TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World worldIn = player.world;
        BlockPos pos = player.isSneaking() ? player.getPosition() : player.getPosition().up();

        // Tools
        if (worldIn.getGameTime()%5==0 && !worldIn.isRemote()) {
            if (!Config.TOOLS.DISABLE_COMPASS.get() && (player.getHeldItemOffhand().getItem() == Items.COMPASS || player.getHeldItemMainhand().getItem() == Items.COMPASS)) {
                switch (player.getHorizontalFacing()) {
                    case NORTH:
                        player.sendStatusMessage(new StringTextComponent("Facing North with coordinates: X =" + new DecimalFormat("###,###").format(pos.getX()) + " Z =" + new DecimalFormat("###,###").format(pos.getZ())).mergeStyle(TextFormatting.GOLD), true);
                        break;
                    case EAST:
                        player.sendStatusMessage(new StringTextComponent("Facing East with coordinates: X =" + new DecimalFormat("###,###").format(pos.getX()) + " Z =" + new DecimalFormat("###,###").format(pos.getZ())).mergeStyle(TextFormatting.GOLD), true);
                        break;
                    case SOUTH:
                        player.sendStatusMessage(new StringTextComponent("Facing South with coordinates: X =" + new DecimalFormat("###,###").format(pos.getX()) + " Z =" + new DecimalFormat("###,###").format(pos.getZ())).mergeStyle(TextFormatting.GOLD), true);
                        break;
                    case WEST:
                        player.sendStatusMessage(new StringTextComponent("Facing West with coordinates: X =" + new DecimalFormat("###,###").format(pos.getX()) + " Z =" + new DecimalFormat("###,###").format(pos.getZ())).mergeStyle(TextFormatting.GOLD), true);
                        break;
                }
            } else if (!Config.TOOLS.DISABLE_CLOCK.get() && (player.getHeldItemOffhand().getItem() == Items.CLOCK || player.getHeldItemMainhand().getItem() == Items.CLOCK)) {
                double hours = ((Math.floor(worldIn.getDayTime() / 1000f)) + 6) % 24;
                double minutes = ((worldIn.getDayTime() / 1000f) % 1) * 60;
                player.sendStatusMessage(new StringTextComponent("Time = " + new DecimalFormat("00").format(hours) + ":" + new DecimalFormat("00").format(minutes) + " (" + worldIn.getDayTime() % 24000 + ")").mergeStyle(TextFormatting.GOLD), true);
            } else if (!Config.TOOLS.DISABLE_THERMOMETER.get() && (player.getHeldItemOffhand().getItem() == RankineItems.THERMOMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.THERMOMETER.get())) {
                float temp = worldIn.getBiome(pos).getTemperature(pos);
                if (temp < 0.0) {
                    player.sendStatusMessage(new StringTextComponent("Temperature = " + new DecimalFormat("#.###").format(temp)).mergeStyle(TextFormatting.LIGHT_PURPLE, TextFormatting.BOLD), true);
                } else if (temp < 0.15) {
                    player.sendStatusMessage(new StringTextComponent("Temperature = " + new DecimalFormat("#.###").format(temp)).mergeStyle(TextFormatting.AQUA, TextFormatting.BOLD), true);
                } else if (temp < 0.8) {
                    player.sendStatusMessage(new StringTextComponent("Temperature = " + new DecimalFormat("#.###").format(temp)).mergeStyle(TextFormatting.GREEN, TextFormatting.BOLD), true);
                } else if (temp < 0.95) {
                    player.sendStatusMessage(new StringTextComponent("Temperature = " + new DecimalFormat("#.###").format(temp)).mergeStyle(TextFormatting.YELLOW, TextFormatting.BOLD), true);
                } else {
                    player.sendStatusMessage(new StringTextComponent("Temperature = " + new DecimalFormat("#.###").format(temp)).mergeStyle(TextFormatting.RED, TextFormatting.BOLD), true);
                }
            } else if (!Config.TOOLS.DISABLE_ALTIMETER.get() && (player.getHeldItemOffhand().getItem() == RankineItems.ALTIMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.ALTIMETER.get())) {
                int y = pos.getY();
                if (y < 0) {
                    player.sendStatusMessage(new StringTextComponent("Altitude: Y = " + new DecimalFormat("###,###").format(y)).mergeStyle(TextFormatting.WHITE, TextFormatting.BOLD), true);
                } else if (y < 64) {
                    player.sendStatusMessage(new StringTextComponent("Altitude: Y = " + new DecimalFormat("###,###").format(y)).mergeStyle(TextFormatting.DARK_PURPLE, TextFormatting.BOLD), true);
                } else if (y < 128) {
                    player.sendStatusMessage(new StringTextComponent("Altitude: Y = " + new DecimalFormat("###,###").format(y)).mergeStyle(TextFormatting.DARK_AQUA, TextFormatting.BOLD), true);
                } else {
                    player.sendStatusMessage(new StringTextComponent("Altitude: Y = " + new DecimalFormat("###,###").format(y)).mergeStyle(TextFormatting.AQUA, TextFormatting.BOLD), true);
                }
            } else if (!Config.TOOLS.DISABLE_PHOTOMETER.get() && (player.getHeldItemOffhand().getItem() == RankineItems.PHOTOMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.PHOTOMETER.get())) {
                int SLL = worldIn.getLightFor(LightType.SKY, pos);
                int BLL = worldIn.getLightFor(LightType.BLOCK,pos);

                if (worldIn.getBlockState(player.getPosition()).getBlock().canCreatureSpawn(worldIn.getBlockState(player.getPosition()), worldIn, player.getPosition(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, EntityType.ZOMBIE)) {
                    player.sendStatusMessage(new StringTextComponent("Light Levels: Sky = " + new DecimalFormat("##").format(SLL) + " Block = " + new DecimalFormat("##").format(BLL)).mergeStyle(TextFormatting.RED, TextFormatting.BOLD), true);
                } else {
                    player.sendStatusMessage(new StringTextComponent("Light Levels: Sky = " + new DecimalFormat("##").format(SLL) + " Block = " + new DecimalFormat("##").format(BLL)).mergeStyle(TextFormatting.GREEN, TextFormatting.BOLD), true);
                }
            } else if (!Config.TOOLS.DISABLE_BIOMETER.get() && (player.getHeldItemOffhand().getItem() == RankineItems.BIOMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.BIOMETER.get())) {
                player.sendStatusMessage(new StringTextComponent("Biome = " + new TranslationTextComponent(Util.makeTranslationKey("biome", worldIn.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(worldIn.getBiome(pos)))).getString()).mergeStyle(TextFormatting.GOLD), true);
            } else if (!Config.TOOLS.DISABLE_BIOMETER.get() && (player.getHeldItemOffhand().getItem() == RankineItems.MAGNETOMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.MAGNETOMETER.get())) {
                double strength = 0.05D;
                if (BlockPos.getClosestMatchingPosition(player.getPosition(), 5, 4, (p) -> worldIn.getBlockState(p).isIn(RankineTags.Blocks.ELECTROMAGNETS)).isPresent()) {
                    strength = 3.00D;
                } else if (BlockPos.getClosestMatchingPosition(player.getPosition(), 5, 4, (p) -> worldIn.getBlockState(p).matchesBlock(Blocks.OBSERVER)).isPresent()) {
                    strength = 1.00D;
                } else {
                    Optional<BlockPos> b = BlockPos.getClosestMatchingPosition(player.getPosition(), Config.TOOLS.MAGNETOMETER_RANGE.get(), Config.TOOLS.MAGNETOMETER_RANGE.get(), ( p) -> worldIn.getBlockState(p).isIn(Tags.Blocks.ORES));
                    if (b.isPresent()) {
                        strength = 0.5D/(player.getPosition().distanceSq(b.get())-1);
                    }
                }
                player.sendStatusMessage(new TranslationTextComponent("item.rankine.magnetometer.message1", new DecimalFormat("#.##").format(strength)).mergeStyle(TextFormatting.GOLD, TextFormatting.BOLD), true);

            }
        }
        if (!Config.TOOLS.DISABLE_SPEEDOMETER.get() && worldIn.isRemote() && worldIn.getGameTime()%5==0 && (player.getHeldItemOffhand().getItem() == RankineItems.SPEEDOMETER.get() || player.getHeldItemMainhand().getItem() == RankineItems.SPEEDOMETER.get())) {
            Entity ent = player;
            if (player.getRidingEntity() != null) {
                ent = player.getRidingEntity();
            }

            double d0 = Math.abs(ent.getPosX() - player.lastTickPosX);
            double d1 = Math.abs(ent.getPosZ() - player.lastTickPosZ);
            //double d2 = Math.abs(player.getPosY() - player.lastTickPosY);
            double speed = Math.sqrt(Math.pow(d0, 2) + Math.pow(d1, 2));
            Item mainhand = player.getHeldItemMainhand().getItem();
            Item offhand = player.getHeldItemOffhand().getItem();
            if ((offhand == RankineItems.SPEEDOMETER.get() && !(mainhand.getItem() instanceof InformationItem || mainhand.getItem() == Items.COMPASS || mainhand.getItem() == Items.CLOCK)) ||
                    (mainhand == RankineItems.SPEEDOMETER.get() && !(offhand instanceof InformationItem || offhand.getItem() == Items.COMPASS || offhand.getItem() == Items.CLOCK)))
                player.sendStatusMessage(new StringTextComponent("Speed = " + new DecimalFormat("#.##").format(speed * 20) + " blocks per second").mergeStyle(TextFormatting.GOLD), true);

        }


        // Armor
        if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RankineItems.DIVING_HELMET.get()) {
            int headSlot = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RankineItems.DIVING_HELMET.get() ? 1 : 0;
            int chestSlot = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == RankineItems.DIVING_CHESTPLATE.get() ? 1 : 0;
            int legsSlot = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == RankineItems.DIVING_LEGGINGS.get() ? 1 : 0;
            int feetSlot = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == RankineItems.DIVING_BOOTS.get() ? 1 : 0;

            if (!player.isInWater()) {
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200 * (headSlot+chestSlot+legsSlot+feetSlot), 0, false, false, true));
            }
        } else if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RankineItems.CONDUIT_DIVING_HELMET.get() && !player.areEyesInFluid(FluidTags.WATER) && player.isInWater()) {
            int headSlot = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RankineItems.CONDUIT_DIVING_HELMET.get() ? 1 : 0;
            int chestSlot = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == RankineItems.CONDUIT_DIVING_CHESTPLATE.get() ? 1 : 0;
            int legsSlot = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == RankineItems.CONDUIT_DIVING_LEGGINGS.get() ? 1 : 0;
            int feetSlot = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == RankineItems.CONDUIT_DIVING_BOOTS.get() ? 1 : 0;

            player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 400 * (headSlot+chestSlot+legsSlot+feetSlot), 0, false, false, true));
        }


        if (player.getEntityWorld().getGameTime() % 1200L == 0) {
            int count = 0;
            for (ItemStack s : player.getArmorInventoryList()) {
                if (s.isEnchanted() && EnchantmentHelper.getEnchantmentLevel(RankineEnchantments.GUARD, s) > 0) {
                    count+=2;
                }
            }
            if (player.getAbsorptionAmount() < count) {
                player.setAbsorptionAmount(count);
            }
        }

        ItemStack ghast = ItemStack.EMPTY;
        for(int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);
            if (!itemstack.isEmpty() && itemstack.getDamage() != 0 && (player.getHeldItemMainhand().getItem() instanceof InvigoratingTotemItem || player.getHeldItemOffhand().getItem() instanceof InvigoratingTotemItem)) {
                ghast = itemstack;
                break;
            }
        }

        EffectInstance eff = player.getActivePotionEffect(Effects.REGENERATION);
        if (ghast != ItemStack.EMPTY && eff != null) {
            int k = 50 >> eff.getAmplifier();
            if (eff.getDuration() % k == 0) {
                ghast.setDamage(Math.max(0,ghast.getDamage() - 1));
            }
        }

        ModifiableAttributeInstance att = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (player.getHeldItemOffhand().getItem() == RankineItems.TOTEM_OF_TIMESAVING.get() && att != null && !att.hasModifier(RankineAttributes.SWIFTNESS_TOTEM)) {
            att.applyNonPersistentModifier(RankineAttributes.SWIFTNESS_TOTEM);
        }

        ModifiableAttributeInstance att2 = player.getAttribute(Attributes.MAX_HEALTH);
        if (player.getHeldItemOffhand().getItem() == RankineItems.TOTEM_OF_ENDURING.get() && att2 != null && !att2.hasModifier(RankineAttributes.ENDURING_TOTEM)) {
            att2.applyNonPersistentModifier(RankineAttributes.ENDURING_TOTEM);
        }
    }
    public static void movementModifier(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World world = event.player.world;
        BlockPos pos;
        if (player.getPosY() % 1 < 0.5) {
            pos = player.getPosition().down();
        } else {
            pos = player.getPosition();
        }
        Block ground = world.getBlockState(pos).getBlock();


        // Path Creation
        if (Config.GENERAL.PATH_CREATION.get() && !player.isCreative() && player.ticksExisted%(Config.GENERAL.PATH_CREATION_TIME.get()*20)==0 && !world.isRemote) {
            if (VanillaIntegration.pathBlocks_map.get(ground.getBlock()) != null && world.getBlockState(pos.up()).matchesBlock(Blocks.AIR) && world.getBlockState(pos.up()).getBlock() instanceof BushBlock) {
                world.setBlockState(pos, VanillaIntegration.pathBlocks_map.get(ground).getDefaultState(),2);
            }

        }


        Item feetEquipment = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
        Item headEquipment = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();
        if (player.areEyesInFluid(FluidTags.WATER) && headEquipment == RankineItems.GOGGLES.get()) {
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,400,0,false,false));
        }


        ModifiableAttributeInstance movementSpeed = player.getAttribute(Attributes.MOVEMENT_SPEED);
        ModifiableAttributeInstance swimSpeed = player.getAttribute(ForgeMod.SWIM_SPEED.get());

        //movementSpeed.applyNonPersistentModifier(new AttributeModifier(UUID.fromString("3c4a1c57-ed5a-482e-946e-eb0b00fe5fb5"), "rankine:block_ms", 0.0D, AttributeModifier.Operation.ADDITION));


        // Movement Modifiersa
        if (Config.GENERAL.MOVEMENT_MODIFIERS.get()) {
            List<AttributeModifier> mods = Arrays.asList(RankineAttributes.BRICKS_MS, RankineAttributes.CONCRETE_MS, RankineAttributes.GRASS_PATH_MS, RankineAttributes.ROMAN_CONCRETE_MS, RankineAttributes.DIRT_MS, RankineAttributes.MUD_MS, RankineAttributes.POLISHED_STONE_MS, RankineAttributes.SAND_MS, RankineAttributes.SNOW_MS, RankineAttributes.WOODEN_MS);
            if (player.isCreative() || player.isElytraFlying()) {
                for (AttributeModifier m : mods) {
                    movementSpeed.removeModifier(m);
                }
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_PATHS.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.GRASS_PATH_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.GRASS_PATH_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_PATHS.contains(ground) && movementSpeed.hasModifier(RankineAttributes.GRASS_PATH_MS)) {
                movementSpeed.removeModifier(RankineAttributes.GRASS_PATH_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_SAND.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.SAND_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.SAND_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_SAND.contains(ground) && movementSpeed.hasModifier(RankineAttributes.SAND_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.SAND_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_MUD.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.MUD_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.MUD_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_MUD.contains(ground) && movementSpeed.hasModifier(RankineAttributes.MUD_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.MUD_MS);
            } else if ((world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow")) || world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow"))) && !movementSpeed.hasModifier(RankineAttributes.SNOW_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.SNOW_MS);
                }
            } else if ((!world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow")) || !world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow"))) && movementSpeed.hasModifier(RankineAttributes.SNOW_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.SNOW_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_DIRT.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.DIRT_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.DIRT_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_DIRT.contains(ground) && movementSpeed.hasModifier(RankineAttributes.DIRT_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.DIRT_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_WOOD.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.WOODEN_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.WOODEN_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_WOOD.contains(ground) && movementSpeed.hasModifier(RankineAttributes.WOODEN_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.WOODEN_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_POLISHED.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.POLISHED_STONE_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.POLISHED_STONE_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_POLISHED.contains(ground) && movementSpeed.hasModifier(RankineAttributes.POLISHED_STONE_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.POLISHED_STONE_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_BRICKS.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.BRICKS_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.BRICKS_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_BRICKS.contains(ground) && movementSpeed.hasModifier(RankineAttributes.BRICKS_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.BRICKS_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_ROMAN.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.ROMAN_CONCRETE_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.ROMAN_CONCRETE_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_ROMAN.contains(ground) && movementSpeed.hasModifier(RankineAttributes.ROMAN_CONCRETE_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.ROMAN_CONCRETE_MS);
            } else if (RankineTags.Blocks.MOVEMENT_MODIFIERS_CONCRETE.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.CONCRETE_MS)) {
                if (!player.isCreative() && !player.isElytraFlying()) {
                    movementSpeed.applyNonPersistentModifier(RankineAttributes.CONCRETE_MS);
                }
            } else if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_CONCRETE.contains(ground) && movementSpeed.hasModifier(RankineAttributes.CONCRETE_MS) && ground != Blocks.AIR) {
                movementSpeed.removeModifier(RankineAttributes.CONCRETE_MS);
            }
        }
        if (ground == Blocks.ICE) {
            if (world.rand.nextFloat() < Config.GENERAL.ICE_BREAK.get() && !(RankineEnchantmentHelper.hasSpeedSkater(player))) {
                for (BlockPos B : BlockPos.getAllInBoxMutable(pos.add(-2, -1, -2), pos.add(2, -1, 2))) {
                    if (world.getBlockState(B).getBlock() == Blocks.ICE) {
                        world.setBlockState(B, Blocks.FROSTED_ICE.getDefaultState().with(FrostedIceBlock.AGE, 2));
                    }
                }
            }
        }
        if (RankineEnchantmentHelper.hasDuneWalker(player) || feetEquipment == RankineItems.SANDALS.get()) {
            if (RankineTags.Blocks.MOVEMENT_MODIFIERS_SAND.contains(ground) && !movementSpeed.hasModifier(RankineAttributes.DUNE_WALKER)) {
                movementSpeed.applyNonPersistentModifier(RankineAttributes.DUNE_WALKER);
                player.stepHeight = 1.0f;
            }
        } else if (!RankineEnchantmentHelper.hasDuneWalker(player) && feetEquipment != RankineItems.SANDALS.get() && movementSpeed.hasModifier(RankineAttributes.DUNE_WALKER)) {
            movementSpeed.removeModifier(RankineAttributes.DUNE_WALKER);
            player.stepHeight = 0.5f;
        }
        if (!RankineTags.Blocks.MOVEMENT_MODIFIERS_SAND.contains(ground) && ground != Blocks.AIR && movementSpeed.hasModifier(RankineAttributes.DUNE_WALKER)) {
            movementSpeed.removeModifier(RankineAttributes.DUNE_WALKER);
            player.stepHeight = 0.5f;
        }
        if (RankineEnchantmentHelper.hasSnowDrifter(player) || feetEquipment == RankineItems.SNOWSHOES.get()) {
            if ((world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow")) || world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow"))) && !movementSpeed.hasModifier(RankineAttributes.SNOW_DRIFTER)) {
                movementSpeed.applyNonPersistentModifier(RankineAttributes.SNOW_DRIFTER);
                player.stepHeight = 1.0f;
            }
        } else if (!RankineEnchantmentHelper.hasSnowDrifter(player) && feetEquipment != RankineItems.SNOWSHOES.get() && movementSpeed.hasModifier(RankineAttributes.SNOW_DRIFTER)) {
            movementSpeed.removeModifier(RankineAttributes.SNOW_DRIFTER);
            player.stepHeight = 0.5f;
        }
        if ((!world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow")) && !world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/snow"))) && ground != Blocks.AIR && movementSpeed.hasModifier(RankineAttributes.SNOW_DRIFTER)) {
            movementSpeed.removeModifier(RankineAttributes.SNOW_DRIFTER);
            player.stepHeight = 0.5f;
        }
        if (RankineEnchantmentHelper.hasSpeedSkater(player) || feetEquipment == RankineItems.ICE_SKATES.get()) {
            if ((world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/ice")) || world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/ice"))) && !movementSpeed.hasModifier(RankineAttributes.SPEED_SKATER)) {
                movementSpeed.applyNonPersistentModifier(RankineAttributes.SPEED_SKATER);
                player.stepHeight = 1.0f;
            }
        } else if (!RankineEnchantmentHelper.hasSpeedSkater(player) && feetEquipment != RankineItems.ICE_SKATES.get() && movementSpeed.hasModifier(RankineAttributes.SPEED_SKATER)) {
            movementSpeed.removeModifier(RankineAttributes.SPEED_SKATER);
            player.stepHeight = 0.5f;
        }
        if ((!world.getBlockState(player.getPosition()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/ice")) && !world.getBlockState(player.getPosition().down()).getBlock().getTags().contains(new ResourceLocation("rankine:movement_modifiers/ice"))) && ground != Blocks.AIR && movementSpeed.hasModifier(RankineAttributes.SPEED_SKATER)) {
            movementSpeed.removeModifier(RankineAttributes.SPEED_SKATER);
            player.stepHeight = 0.5f;
        }
        if (RankineEnchantmentHelper.hasFlippers(player) || feetEquipment == RankineItems.FINS.get()) {
            if (player.isSwimming() && !swimSpeed.hasModifier(RankineAttributes.FLIPPERS)) {
                swimSpeed.applyNonPersistentModifier(RankineAttributes.FLIPPERS);
            }
        } else if (!RankineEnchantmentHelper.hasFlippers(player) && feetEquipment != RankineItems.FINS.get() && swimSpeed.hasModifier(RankineAttributes.FLIPPERS)) {
            swimSpeed.removeModifier(RankineAttributes.FLIPPERS);
        }
        if (!player.isSwimming() && swimSpeed.hasModifier(RankineAttributes.FLIPPERS)) {
            swimSpeed.removeModifier(RankineAttributes.FLIPPERS);
        }
        if (headEquipment == RankineItems.GOGGLES.get() && player.areEyesInFluid(FluidTags.WATER) && !swimSpeed.hasModifier(RankineAttributes.WATER_VISION)) {
            swimSpeed.applyNonPersistentModifier(RankineAttributes.WATER_VISION);
        } else if ((headEquipment != RankineItems.GOGGLES.get() || !player.areEyesInFluid(FluidTags.WATER)) && swimSpeed.hasModifier(RankineAttributes.WATER_VISION)) {
            swimSpeed.removeModifier(RankineAttributes.WATER_VISION);
        }
    }
}
