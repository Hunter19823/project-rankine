package com.cannolicatfish.rankine.world.trees;

import com.cannolicatfish.rankine.init.RankineFeatures;
import com.cannolicatfish.rankine.world.gen.RankineBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BalsamFirTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return RankineFeatures.BALSAM_FIR_TREE.get().withConfiguration(RankineBiomeFeatures.BALSAM_FIR_TREE_CONFIG);
    }
}
