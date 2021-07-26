package com.cannolicatfish.rankine.init;

import com.cannolicatfish.rankine.ProjectRankine;
import com.cannolicatfish.rankine.blocks.alloyfurnace.AlloyFurnaceScreen;
import com.cannolicatfish.rankine.blocks.crucible.CrucibleScreen;
import com.cannolicatfish.rankine.blocks.evaporationtower.EvaporationTowerScreen;
import com.cannolicatfish.rankine.blocks.gyratorycrusher.GyratoryCrusherScreen;
import com.cannolicatfish.rankine.blocks.inductionfurnace.InductionFurnaceScreen;
import com.cannolicatfish.rankine.blocks.laserquarry.LaserQuarryScreen;
import com.cannolicatfish.rankine.blocks.pistoncrusher.PistonCrusherScreen;
import com.cannolicatfish.rankine.blocks.rankinebox.RankineBoxScreen;
import com.cannolicatfish.rankine.blocks.templatetable.TemplateTableScreen;
import com.cannolicatfish.rankine.items.indexer.ElementIndexerScreen;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class ClientProxy implements IProxy {

    public static void addCutout(List<Block> blockList) {
        for (Block block : blockList) {
            RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
        }
    }

    public static void addCutoutMipped(List<Block> blockList) {
        for (Block block : blockList) {
            RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
        }
    }

    public static void addTranslucent(List<Block> blockList) {
        for (Block block : blockList) {
            RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
        }
    }

    public static void registerItemProperties() {
        ItemModelsProperties.registerProperty(RankineItems.SHULKER_GAS_VACUUM.get(),
                new ResourceLocation(ProjectRankine.MODID, "gas_held"), (stack, world, living) ->
                        stack.getTag() != null && !stack.getTag().getString("gas").isEmpty() ? 1.0F : 0.0F);
    }
    @Override
    public void init() {
        ScreenManager.registerFactory(RankineBlocks.ALLOY_FURNACE_CONTAINER, AlloyFurnaceScreen::new);
        ScreenManager.registerFactory(RankineBlocks.PISTON_CRUSHER_CONTAINER, PistonCrusherScreen::new);
        ScreenManager.registerFactory(RankineBlocks.EVAPORATION_TOWER_CONTAINER, EvaporationTowerScreen::new);
        ScreenManager.registerFactory(RankineItems.ELEMENT_INDEXER_CONTAINER, ElementIndexerScreen::new);
        ScreenManager.registerFactory(RankineBlocks.TEMPLATE_TABLE_CONTAINER, TemplateTableScreen::new);
        ScreenManager.registerFactory(RankineBlocks.CRUCIBLE_CONTAINER, CrucibleScreen::new);
        ScreenManager.registerFactory(RankineBlocks.INDUCTION_FURNACE_CONTAINER, InductionFurnaceScreen::new);
        ScreenManager.registerFactory(RankineBlocks.GYRATORY_CRUSHER_CONTAINER, GyratoryCrusherScreen::new);
        ScreenManager.registerFactory(RankineBlocks.RANKINE_BOX_CONTAINER, RankineBoxScreen::new);
        ScreenManager.registerFactory(RankineBlocks.LASER_QUARRY_CONTAINER, LaserQuarryScreen::new);

        addCutout(Arrays.asList(
                RankineBlocks.ACANTHITE_ORE.get(),
                RankineBlocks.RHENIITE_ORE.get(),
                RankineBlocks.NATIVE_BISMUTH_ORE.get(),
                RankineBlocks.HALITE_ORE.get(),
                RankineBlocks.PINK_HALITE_ORE.get(),
                RankineBlocks.CRYOLITE_ORE.get(),
                RankineBlocks.PYRITE_ORE.get(),
                RankineBlocks.NATIVE_GALLIUM_ORE.get(),
                RankineBlocks.NATIVE_INDIUM_ORE.get(),
                RankineBlocks.NATIVE_SELENIUM_ORE.get(),
                RankineBlocks.NATIVE_ARSENIC_ORE.get(),
                RankineBlocks.NATIVE_SULFUR_ORE.get(),
                RankineBlocks.NATIVE_TELLURIUM_ORE.get(),
                RankineBlocks.ANTHRACITE_ORE.get(),
                RankineBlocks.BAUXITE_ORE.get(),
                RankineBlocks.BISMUTHINITE_ORE.get(),
                RankineBlocks.BITUMINOUS_ORE.get(),
                RankineBlocks.CASSITERITE_ORE.get(),
                RankineBlocks.CHROMITE_ORE.get(),
                RankineBlocks.CINNABAR_ORE.get(),
                RankineBlocks.OPAL_ORE.get(),
                RankineBlocks.COLUMBITE_ORE.get(),
                RankineBlocks.DIAMOND_ORE.get(),
                RankineBlocks.EMERALD_ORE.get(),
                RankineBlocks.GALENA_ORE.get(),
                RankineBlocks.ILMENITE_ORE.get(),
                RankineBlocks.LAZURITE_ORE.get(),
                RankineBlocks.LIGNITE_ORE.get(),
                RankineBlocks.MALACHITE_ORE.get(),
                RankineBlocks.MAGNESITE_ORE.get(),
                RankineBlocks.MAGNETITE_ORE.get(),
                RankineBlocks.MOLYBDENITE_ORE.get(),
                RankineBlocks.NATIVE_COPPER_ORE.get(),
                RankineBlocks.NATIVE_GOLD_ORE.get(),
                RankineBlocks.NATIVE_TIN_ORE.get(),
                RankineBlocks.NATIVE_ALUMINUM_ORE.get(),
                RankineBlocks.NATIVE_LEAD_ORE.get(),
                RankineBlocks.NATIVE_SILVER_ORE.get(),
                RankineBlocks.PENTLANDITE_ORE.get(),
                RankineBlocks.INTERSPINIFEX_ORE.get(),
                RankineBlocks.PLUMBAGO_ORE.get(),
                RankineBlocks.PYROLUSITE_ORE.get(),
                RankineBlocks.FLUORITE_ORE.get(),
                RankineBlocks.SPERRYLITE_ORE.get(),
                RankineBlocks.AQUAMARINE_ORE.get(),
                RankineBlocks.SPHALERITE_ORE.get(),
                RankineBlocks.MOISSANITE_ORE.get(),
                RankineBlocks.QUARTZ_ORE.get(),
                RankineBlocks.SUBBITUMINOUS_ORE.get(),
                RankineBlocks.TANTALITE_ORE.get(),
                RankineBlocks.WOLFRAMITE_ORE.get(),
                RankineBlocks.VANADINITE_ORE.get(),
                RankineBlocks.GREENOCKITE_ORE.get(),
                RankineBlocks.XENOTIME_ORE.get(),
                RankineBlocks.STIBNITE_ORE.get(),
                RankineBlocks.URANINITE_ORE.get(),
                RankineBlocks.PETALITE_ORE.get(),
                RankineBlocks.COBALTITE_ORE.get(),
                RankineBlocks.MAJORITE_ORE.get(),
                RankineBlocks.CELESTINE_ORE.get(),
                RankineBlocks.KAMACITE_ORE.get(),
                RankineBlocks.TAENITE_ORE.get(),
                RankineBlocks.ANTITAENITE_ORE.get(),
                RankineBlocks.TETRATAENITE_ORE.get(),
                RankineBlocks.LONSDALEITE_ORE.get(),
                RankineBlocks.MONAZITE_ORE.get(),

                RankineBlocks.LEAD_GLASS.get(),
                RankineBlocks.ETCHED_GLASS0.get(),
                RankineBlocks.ETCHED_GLASS1.get(),
                RankineBlocks.ETCHED_GLASS2.get(),

                RankineBlocks.CEDAR_SAPLING.get(),
                RankineBlocks.JUNIPER_SAPLING.get(),
                RankineBlocks.COCONUT_PALM_SAPLING.get(),
                RankineBlocks.PINYON_PINE_SAPLING.get(),
                RankineBlocks.BALSAM_FIR_SAPLING.get(),
                RankineBlocks.MAGNOLIA_SAPLING.get(),
                RankineBlocks.EASTERN_HEMLOCK_SAPLING.get(),
                RankineBlocks.YELLOW_BIRCH_SAPLING.get(),
                RankineBlocks.BLACK_BIRCH_SAPLING.get(),
                RankineBlocks.MAPLE_SAPLING.get(),
                RankineBlocks.SHARINGA_SAPLING.get(),
                RankineBlocks.BLACK_WALNUT_SAPLING.get(),
                RankineBlocks.CORK_OAK_SAPLING.get(),
                RankineBlocks.CINNAMON_SAPLING.get(),

                RankineBlocks.TREE_TAP.get(),
                RankineBlocks.TAP_LINE.get(),

                RankineBlocks.CEDAR_TRAPDOOR.get(),
                RankineBlocks.COCONUT_PALM_TRAPDOOR.get(),
                RankineBlocks.PINYON_PINE_TRAPDOOR.get(),
                RankineBlocks.JUNIPER_TRAPDOOR.get(),
                RankineBlocks.MAGNOLIA_TRAPDOOR.get(),
                RankineBlocks.BALSAM_FIR_TRAPDOOR.get(),
                RankineBlocks.BAMBOO_TRAPDOOR.get(),
                RankineBlocks.EASTERN_HEMLOCK_TRAPDOOR.get(),
                RankineBlocks.BAMBOO_CULMS_TRAPDOOR.get(),
                RankineBlocks.YELLOW_BIRCH_TRAPDOOR.get(),
                RankineBlocks.BLACK_BIRCH_TRAPDOOR.get(),
                RankineBlocks.SHARINGA_TRAPDOOR.get(),
                RankineBlocks.CORK_OAK_TRAPDOOR.get(),
                RankineBlocks.BLACK_WALNUT_TRAPDOOR.get(),
                RankineBlocks.MAPLE_TRAPDOOR.get(),
                RankineBlocks.CINNAMON_TRAPDOOR.get(),
                RankineBlocks.BRASS_TRAPDOOR.get(),
                RankineBlocks.CUPRONICKEL_TRAPDOOR.get(),
                RankineBlocks.BRONZE_TRAPDOOR.get(),
                RankineBlocks.STEEL_TRAPDOOR.get(),


                RankineBlocks.CEDAR_DOOR.get(),
                RankineBlocks.COCONUT_PALM_DOOR.get(),
                RankineBlocks.PINYON_PINE_DOOR.get(),
                RankineBlocks.JUNIPER_DOOR.get(),
                RankineBlocks.MAGNOLIA_DOOR.get(),
                RankineBlocks.BALSAM_FIR_DOOR.get(),
                RankineBlocks.EASTERN_HEMLOCK_DOOR.get(),
                RankineBlocks.BAMBOO_DOOR.get(),
                RankineBlocks.BAMBOO_CULMS_DOOR.get(),
                RankineBlocks.YELLOW_BIRCH_DOOR.get(),
                RankineBlocks.BLACK_BIRCH_DOOR.get(),
                RankineBlocks.SHARINGA_DOOR.get(),
                RankineBlocks.CORK_OAK_DOOR.get(),
                RankineBlocks.BLACK_WALNUT_DOOR.get(),
                RankineBlocks.MAPLE_DOOR.get(),
                RankineBlocks.CINNAMON_DOOR.get(),
                RankineBlocks.BRASS_DOOR.get(),
                RankineBlocks.CUPRONICKEL_DOOR.get(),
                RankineBlocks.BRONZE_DOOR.get(),
                RankineBlocks.STEEL_DOOR.get(),


                RankineBlocks.TRAMPOLINE.get(),
                RankineBlocks.ALUMINUM_LADDER.get(),
                RankineBlocks.BRASS_LADDER.get(),
                RankineBlocks.CAST_IRON_LADDER.get(),

                RankineBlocks.CEDAR_LEAVES.get(),
                RankineBlocks.PINYON_PINE_LEAVES.get(),
                RankineBlocks.JUNIPER_LEAVES.get(),
                RankineBlocks.BALSAM_FIR_LEAVES.get(),
                RankineBlocks.COCONUT_PALM_LEAVES.get(),
                RankineBlocks.MAGNOLIA_LEAVES.get(),
                RankineBlocks.YELLOW_BIRCH_LEAVES.get(),
                RankineBlocks.BLACK_BIRCH_LEAVES.get(),
                RankineBlocks.MAPLE_LEAVES.get(),
                RankineBlocks.EASTERN_HEMLOCK_LEAVES.get(),
                RankineBlocks.SHARINGA_LEAVES.get(),
                RankineBlocks.BLACK_WALNUT_LEAVES.get()

        ));

        addCutoutMipped(Arrays.asList(
                RankineBlocks.CAST_IRON_BARS.get(),
                RankineBlocks.CAST_IRON_SUPPORT.get(),
                RankineBlocks.CAST_IRON_SUPPORT_SLAB.get(),
                RankineBlocks.CAST_IRON_SUPPORT_STAIRS.get(),
                RankineBlocks.CAST_IRON_SUPPORT_VERTICAL_SLAB.get(),

                RankineBlocks.POTTED_CEDAR_SAPLING.get(),
                RankineBlocks.POTTED_JUNIPER_SAPLING.get(),
                RankineBlocks.POTTED_COCONUT_PALM_SAPLING.get(),
                RankineBlocks.POTTED_PINYON_PINE_SAPLING.get(),
                RankineBlocks.POTTED_BALSAM_FIR_SAPLING.get(),
                RankineBlocks.POTTED_MAGNOLIA_SAPLING.get(),
                RankineBlocks.POTTED_EASTERN_HEMLOCK_SAPLING.get(),
                RankineBlocks.POTTED_MAPLE_SAPLING.get(),
                RankineBlocks.POTTED_YELLOW_BIRCH_SAPLING.get(),
                RankineBlocks.POTTED_BLACK_BIRCH_SAPLING.get(),
                RankineBlocks.POTTED_BLACK_WALNUT_SAPLING.get(),
                RankineBlocks.POTTED_SHARINGA_SAPLING.get(),
                RankineBlocks.POTTED_CORK_OAK_SAPLING.get(),

                RankineBlocks.BANANA_YUCCA_BUSH.get(),
                RankineBlocks.ELDERBERRY_BUSH.get(),
                RankineBlocks.SNOWBERRY_BUSH.get(),
                RankineBlocks.BLUEBERRY_BUSH.get(),
                RankineBlocks.BLACKBERRY_BUSH.get(),
                RankineBlocks.RASPBERRY_BUSH.get(),
                RankineBlocks.BLACKBERRY_BUSH.get(),
                RankineBlocks.CRANBERRY_BUSH.get(),
                RankineBlocks.STRAWBERRY_BUSH.get(),
                RankineBlocks.PINEAPPLE_BUSH.get(),
                RankineBlocks.ALOE_PLANT.get(),
                RankineBlocks.CAMPHOR_BASIL_PLANT.get(),
                RankineBlocks.ASPARAGUS_PLANT.get(),
                RankineBlocks.CORN_STALK.get(),
                RankineBlocks.CORN_PLANT.get(),
                RankineBlocks.RICE_PLANT.get(),
                RankineBlocks.COTTON_PLANT.get(),
                RankineBlocks.JUTE_PLANT.get(),
                RankineBlocks.RED_LILY.get(),
                RankineBlocks.ORANGE_LILY.get(),
                RankineBlocks.WHITE_LILY.get(),
                RankineBlocks.BLUE_MORNING_GLORY.get(),
                RankineBlocks.PURPLE_MORNING_GLORY.get(),
                RankineBlocks.BLACK_MORNING_GLORY.get(),
                RankineBlocks.GOLDENROD.get(),



                RankineBlocks.CALCITE_BLOCK.get(),
                RankineBlocks.CALCIUM_SILICATE_BLOCK.get(),
                RankineBlocks.MICA_BLOCK.get(),
                RankineBlocks.SALT_BLOCK.get(),
                RankineBlocks.PINK_SALT_BLOCK.get()


        ));

        addTranslucent(Arrays.asList(
                RankineBlocks.HYDROGEN_GAS_BLOCK.get(),
                RankineBlocks.HELIUM_GAS_BLOCK.get(),
                RankineBlocks.NITROGEN_GAS_BLOCK.get(),
                RankineBlocks.OXYGEN_GAS_BLOCK.get(),
                RankineBlocks.FLUORINE_GAS_BLOCK.get(),
                RankineBlocks.NEON_GAS_BLOCK.get(),
                RankineBlocks.CHLORINE_GAS_BLOCK.get(),
                RankineBlocks.ARGON_GAS_BLOCK.get(),
                RankineBlocks.KRYPTON_GAS_BLOCK.get(),
                RankineBlocks.XENON_GAS_BLOCK.get(),
                RankineBlocks.RADON_GAS_BLOCK.get(),
                RankineBlocks.OGANESSON_GAS_BLOCK.get(),
                RankineBlocks.BLACK_TEKTITE.get(),
                RankineBlocks.GREEN_TEKTITE.get(),
                RankineBlocks.GRAY_TEKTITE.get(),
                RankineBlocks.BROWN_TEKTITE.get()
        ));
    }





    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

}
