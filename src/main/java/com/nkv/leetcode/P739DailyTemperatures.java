package com.nkv.leetcode;

import sun.jvm.hotspot.utilities.Assert;

public class P739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        Assert.that(len > 0 && len <= 30000, "Length of temp list should lie between 1 and 30000");

        int[] waitDays = new int[len];
        waitDays[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            Assert.that(temperatures[i] >= 30 && temperatures[i] <= 100, "Temperature value must be between 30 and 100");

            int seek = i + 1;
            while (waitDays[seek] != 0 &&  temperatures[i] >= temperatures[seek] ) {
                seek = seek + waitDays[seek];
            }

            if (temperatures[i] < temperatures[seek]) {
                waitDays[i] = seek - i;
            }
        }

        return waitDays;
    }
}
