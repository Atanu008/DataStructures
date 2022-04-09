package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/
//LeetCode 802
//Exactly same idea as Cycle Detection in Directed Graph .
//Here we need to find nodes which are not part of the cycle
public class FindEventualSafeStates {

    enum Status {
        UNVISITED, INRECURSION, SAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        Status[] discovered = new Status[graph.length];
        Arrays.fill(discovered, Status.UNVISITED);
        List<Integer> safeNodes = new ArrayList<>();

        for(int node = 0; node < graph.length; node++){
            if(isSafeDFS(graph, node, discovered)){
                safeNodes.add(node);
            }
        }

        return safeNodes;
    }

    public  boolean isSafeDFS(int[][] graph, int v, Status[] discovered) {
        //Mark the node in Recursion
        discovered[v] = Status.INRECURSION;

        for (int neighbour : graph[v]) {
            //Return True if the neighbour is in recursion . i.e this neighbour is part of a cycle
            // So the node v will never be safe node as its neighbour is not safe. Return false
            if (discovered[neighbour] == Status.INRECURSION) {
                return false;
            }

            //Deep in recursion for non visited neighbours there may be cycle.
            //So the node v will never be safe node as its neighbour is not safe. Return false
            if (discovered[neighbour] == Status.UNVISITED && !isSafeDFS(graph, neighbour, discovered)) {
                return false;
            }
        }
        //after visting all the neighbours.
        //If we have reached here means , there is no cycle. this node is safe
        discovered[v] = Status.SAFE;
        return true;

    }


    //0:have not been visited
    //1:safe
    //2:unsafe
    public List<Integer> eventualSafeNodesV2(int[][] graph) {

        int[] color = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();

        for(int node = 0; node < graph.length; node++){
            if(isSafeDFSV2(graph, node, color)){
                safeNodes.add(node);
            }
        }

        return safeNodes;
    }

    public  boolean isSafeDFSV2(int[][] graph, int node, int[] color) {

        // already visited.
        if(color[node] != 0){
            return color[node] == 2;
        }

        color[node] = 1;
        for (int neighbour : graph[node]) {
            //has cycle
            //Not safe return false
            if(!isSafeDFSV2(graph, neighbour, color)){
                return false;
            }
        }
        //after visting all the neighbours there is no cycle
        //If we have reached here means , there is no cycle. this node is safe
        color[node] = 2;
        return true;

    }
    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> safeNodes = findEventualSafeStates.eventualSafeNodes(graph);
        System.out.println(safeNodes);

        safeNodes = findEventualSafeStates.eventualSafeNodesV2(graph);
        System.out.println(safeNodes);
    }
}
