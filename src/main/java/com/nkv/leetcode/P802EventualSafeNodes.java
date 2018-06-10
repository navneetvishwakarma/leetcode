package com.nkv.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P802EventualSafeNodes {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return safeNodes;
        }
        // state 0 = 'not visited', 1 = 'visited', 2 = 'unsafe'
        int[] state = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, state) ==true){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean isSafe(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 1;
        }
        state[node] = 2;
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            if (isSafe(graph, nextNode, state) == false) {
                return false;
            }
        }
        state[node] = 1;
        return true;
    }


}
