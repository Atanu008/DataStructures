package org.atanu.java.ds.graph;

// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
// Leetcode 2492

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumScoreOfAPathBetweenTwoCities_DFS {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++) adjList.add(new ArrayList<>());
        for(int k[]:roads) {
            adjList.get(k[0]).add(new int[]{k[1],k[2]});
            adjList.get(k[1]).add(new int[]{k[0],k[2]});
        }
        Set<Integer> seen = new HashSet<>();
        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        seen.add(1);
        dfs(adjList, 1, seen, result);
        return result[0];
    }

    private void dfs(List<List<int[]>> adjList, int node, Set<Integer> seen, int[] result) {

        for(int[] neighbour : adjList.get(node)) {
            result[0] = Math.min(result[0], neighbour[1]);
            if (seen.add(neighbour[0]))
                dfs(adjList, neighbour[0], seen, result);
        }

    }
}
