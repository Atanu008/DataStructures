package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
//LeetCode 1743

/*Logic
*  --------
*  we can consider this as a graph problem. we build the graph using adjacency list concept but in a Map.
*  where Map.key = vertex
*  	  Map.value = List of vertices of which is it adjacent to.
*
*  Once it is built , we need to get the vertex which has which has only one adjacency list size.
*  This is because, if it is one, then it is possible that it is a starting point in the resultant array.
*  if it is more than 1( i.2), then this key is in between two elements.
*
*  Insight is it can't be more than 2 as we need to create the resultant array from it and any array element
*  can be at a position below:
*   0 th
*   n-1 th
*   j th s.t. i<j<k
*   Hence, max, size() of the adjacency list for a particular vertex can be maximum 2.
 *
 *  Coming back to the problem, once we get the starting vertex, we can do a DFS to create the list.
 *  Once done, we can transform it to array.
 *
 *
 *  TC : O(N)
 *  SC : O(N)
*/
public class RestoreTheArrayFromAdjacentPairs {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {

        for(int[] adjacentPair : adjacentPairs){
            buildGraph(adjacentPair);
        }
        //Node with One InDegree will be starting point of the array
        //There may be few . but lets take the first one
        int nodeWithOneIndgree = 0;

        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size() == 1){
                nodeWithOneIndgree = entry.getKey();
            }
        }

        List<Integer> resultList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(nodeWithOneIndgree, visited, resultList);

        int[] result = new int[graph.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    private void dfs(int node, Set<Integer> visited, List<Integer> resultList){

        resultList.add(node);
        visited.add(node);

        for(int neighbour : graph.get(node)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, visited, resultList);
            }
        }

    }

    //Create a Undirected Graph
    private void buildGraph(int[] adjacentPair){

        int nodeA = adjacentPair[0];
        int nodeB = adjacentPair[1];

        graph.putIfAbsent(nodeA, new ArrayList<>());
        graph.get(nodeA).add(nodeB);

        graph.putIfAbsent(nodeB, new ArrayList<>());
        graph.get(nodeB).add(nodeA);
    }

    public static void main(String[] args) {

        RestoreTheArrayFromAdjacentPairs restoreTheArrayFromAdjacentPairs = new RestoreTheArrayFromAdjacentPairs();
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        int[] result = restoreTheArrayFromAdjacentPairs.restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(result));
    }
}
