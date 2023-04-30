package org.atanu.java.ds.graph;

/*

1168. Optimize Water Distribution in a Village
https://leetcode.com/problems/optimize-water-distribution-in-a-village/description/

Video(Nice explanation , intuition in first couple of minutes only) :
https://www.youtube.com/watch?v=gc6ShDTldb4&t=667s

There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i - 1]
(note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses
are given by the array pipes where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j
and house2j together using a pipe. Connections are bidirectional, and there could be multiple valid connections
between the same two houses with different costs.

Return the minimum total cost to supply water to all houses.

Example 1:
Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with
cost 2 so the total cost is 3.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// if only the pipes would have been given then it would benn very easy just find the MST cost
// Now we have well as well in each house, Noe the challenge is how to build the graph
// We can dig a dummy well and connect each house from it with the same cost each house would take to build the well
// We we have the graph having both pipes and well info in it.
// Now just find the MST
public class OptimizeWaterDistributionInAVillage {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        List<int[]> edges = new ArrayList<>();

        // To dig a well in ith House would take wells[i] cost
        // Create a dummy House(House 0) and conenct the same house with that cost
        // Suppose in order to build well in 5th house cost is 19
        // Edge : new int[]{0, 5, 19}; //new int[]{0, i + 1, wells[i]} (Conenct 0th House to ith House with well[i] cost)

        for(int i = 0; i < n; i++){
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        // Conenct the pipes
        for(int[] pipe : pipes){
            edges.add(pipe);
        }

        UnionFind unionFind = new UnionFind(n + 1);
        // Sor the edges on basis of Cost

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int minCost = 0;
        //Apply Kruskal

        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            int cost = edge[2];

            int parentA = unionFind.find(nodeA);
            int parentB = unionFind.find(nodeB);

            if(parentA != parentB){
                unionFind.union(nodeA, nodeB);
                minCost += cost;
            }
        }

        return minCost;
    }

    private static class UnionFind {

        int[] root;
        int[] size;

        public UnionFind(int n){
            root = new int[n];
            size = new int[n];

            for(int i = 0; i < n ; i++){
                root[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }

        private void union(int x, int y){

            int rootX = find(x);
            int rootY = find(y);

            // x and y are already connected
            // they are in same component, No need to connect
            if(rootX == rootY){
                return ;
            }

            if(size[rootX] > size[rootY]){
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }

    public static void main(String[] args) {
        OptimizeWaterDistributionInAVillage optimizeWaterDistributionInAVillage = new OptimizeWaterDistributionInAVillage();
        int n =3;
        int[] wells = new int[]{1,2,2};
        int[][] edges = new int[][]{{1,2,1},{2,3,1}};
        //Output: 3
        //Explanation: The image shows the costs of connecting houses using pipes.
        //The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
        System.out.println(optimizeWaterDistributionInAVillage.minCostToSupplyWater(n,wells,edges));
    }
}
