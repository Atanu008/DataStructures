package org.atanu.java.ds.backtracking;

import java.util.Arrays;

public class MColoringGraph {

    private boolean graphColoring(int[][] graph, int[] colors, int node, int m, int V) {
        if(node == V) {
            return true;
        }
        for(int c = 1; c <= m; c++){
            if(isSafeToColor(graph, colors, node, c)){
                colors[node] = c;
                if(graphColoring(graph, colors, node+1, m , V))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafeToColor(int[][] graph, int[] colors, int node, int c) {
        for (int i = 0; i < graph.length; i++){
            //If any adjacent node has the same color(colors[i] == c)then we can not make that color to the node
            if(graph[node][i] == 1 && colors[i] == c){
                return false;
            }
        }
        return true; // No adjacent has same color. coloring Possible
    }

    public static void main(String[] args) {
        MColoringGraph Coloring = new MColoringGraph();
        /* Create following graph and
           test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int[][] graph = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };

        int V = graph.length; //No Of Nodes
        int[] colors = new int[V];
        int m = 3; // Number of colors
        //Starting from Zero node. can be started from any node
        boolean reslut = Coloring.graphColoring(graph, colors, 0, m , V);
        System.out.println("Coloring Possible "+ reslut +" with colors "+ Arrays.toString(colors) );
    }


}
