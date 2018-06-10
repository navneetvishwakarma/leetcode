package com.nkv.leetcode;

import com.nkv.util.Stringify;

import java.util.List;

public class P802EventualSafeNodesTest {

    public static void main (String[] args) {
        P802EventualSafeNodes solution = new P802EventualSafeNodes();

        // Input
        // int [][]graph = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        int [][]graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        List<Integer> res = solution.eventualSafeNodes(graph);
        System.out.println(Stringify.toString(res));
    }

}
