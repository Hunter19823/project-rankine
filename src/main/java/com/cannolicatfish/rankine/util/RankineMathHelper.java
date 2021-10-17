package com.cannolicatfish.rankine.util;

import java.util.List;
import java.util.Random;

public class RankineMathHelper {

    public static float[] linspace(float min, float max, int steps) {
        float[] f = new float[steps];
        for (int i = 0; i < steps; i++){
            f[i] = min + i * (max - min) / (steps - 1);
        }
        return f;
    }

}
