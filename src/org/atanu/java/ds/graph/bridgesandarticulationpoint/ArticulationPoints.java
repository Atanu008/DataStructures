package org.atanu.java.ds.graph.bridgesandarticulationpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Articulation Point : In an undirected graph G, a vertex V is an articulation point if removing it increases the number of connected components in the graph.

// Amazing Udemy Graph Theory :
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934108#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934112#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934116#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934118#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934122#overview

// https://codeforces.com/blog/entry/71146
// https://www.codingninjas.com/codestudio/library/articulation-points-in-a-graph

public class ArticulationPoints {

    public static void main(String[] args) {

        ArticulationPoints articulationPoints = new ArticulationPoints();
        List<List<Integer>> edges =  new ArrayList<>();
        // Eg : https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
        int n = 5;
        edges.add(Arrays.asList(1,0));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(0,3));
        edges.add(Arrays.asList(3,4));
        articulationPoints.findArticulationPoints(n, edges);
        edges.clear();
        System.out.println("+++++++");

        n = 7;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 0));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(1, 6));
        edges.add(Arrays.asList(3, 5));
        edges.add(Arrays.asList(4, 5));
        articulationPoints.findArticulationPoints(n, edges);


    }

    public void findArticulationPoints(int n, List<List<Integer>> edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        // Build the Graph from Connection
        buildGraph(n, edges, adjList);

        boolean[] visited = new boolean[n];
        // Discovered Time : Time at which current node was discovered during DFS
        int[] discovered = new int[n];
        // Lowest Time : it is the discovered time of a node which can be traversed by at most one back-edge in current subtree
        int[] low = new int[n];

        boolean[] isArticulationPoints = new boolean[n];


        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, -1, 1, adjList, visited, discovered, low, isArticulationPoints);
            }
        }

        System.out.println("Articulation Point ");
        for(int i = 0; i < n; i++){
            if(isArticulationPoints[i]){
                System.out.println(i);
            }
        }
    }

    private void dfs(int currentNode, int parent, int time, List<List<Integer>> adjList, boolean[] visited, int[] discovered, int[] low, boolean[] isArticulationPoints) {

        visited[currentNode] = true;
        // set discovery time and low of current currentNode as time.
        discovered[currentNode] = time;
        low[currentNode] = time;
        time++; //increment the time variable

        int numberOfChild = 0;
        for(int child : adjList.get(currentNode)){

            // the child_node has been not been visited before
            // Forward edge in the tree
            // Do DFS
            if(!visited[child]){
                numberOfChild++; // increment the child in DFS Tree
                dfs(child, currentNode, time, adjList, visited, discovered, low, isArticulationPoints);
                // Check if the subtree rooted with child has a connection to one of the ancestors of currentNode
                // low[child] may point to ancestors of currentNode via any back-edge
                // i.e currentNode also can connect to that ancestors via this child and via the back-edge of the child
                // So once dfs is completed, we take the min low of neighbour and it own self
                // i.e low[child] might be an ancestor of currentNode
                low[currentNode] = Math.min(low[currentNode], low[child]);
                // When currentNode is not root
                // in case the lowest reach time is greater than current node's inTime
                // that means we can't reach from neighbour to this current node if this current->next
                // edge is removed , so its a bridge edge
                // if  low[child] >= discovered[currentNode] that means from child
                // then we can not reach to the currentNode and its ancestor if we delete this currentNode.
                // So currentNode is articulation points
                // The only difference between bridges and articulation points is >=
                // here >= as even if we reach the currentNode from child via a back-edge
                // but if that node is deleted that connection will go away,
                // in case of bridge if there is is another back-edge then its fine so > ok

                // Another point is , one node can be ArticulationPoint many times , counting will have the double effect
                // Like if one node has three children , that node can be ArticulationPoints for all childeren
                // So just set it
                if(low[child] >= discovered[currentNode] && parent != -1){
                    isArticulationPoints[currentNode] = true;
                }
            }

            // if child node has been visited before it is not parent , means that we found an ancestor
            // then its a back-edge
            else if(child != parent){
                // As there can be many back-edges, finds the ancestor with the least discovery time
                low[currentNode] = Math.min(low[currentNode], discovered[child]);
            }
        }

        // This for root,
        // if there are more than one children in DFS tree for root, then this root node will be articulation point
        if(parent == -1 && numberOfChild > 1){
            isArticulationPoints[currentNode] = true;
        }
    }

    private void buildGraph(int n, List<List<Integer>> connections, List<List<Integer>> adjList) {

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int nodeA = connections.get(i).get(0);
            int nodeB = connections.get(i).get(1);

            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }
    }
}
