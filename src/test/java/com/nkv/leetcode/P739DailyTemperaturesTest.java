package com.nkv.leetcode;

import com.nkv.util.Stringify;

public class P739DailyTemperaturesTest {

    public static void main (String[] args) {

        int [] temps = {73, 71, 73, 76, 74, 75, 70, 76};
        // int [] temps = {73, 74, 75, 71, 69, 72, 76, 73};

        P739DailyTemperatures solution = new P739DailyTemperatures();
        int [] res = solution.dailyTemperatures(temps);
        System.out.println(Stringify.toString(res));
    }


}
