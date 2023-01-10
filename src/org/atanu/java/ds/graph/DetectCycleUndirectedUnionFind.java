package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

//https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27109946#announcements
//Graph Valid Tree in Leetcode has similar solution
public class DetectCycleUndirectedUnionFind {

    public static boolean hasCycle(Graph graph){

        UnionFind unionFind = new UnionFind(graph.V);

        for(Edge edge : graph.edgeList){
            int nodeA = edge.source;
            int nodeB = edge.dest;

            int parentNodeA = unionFind.find(nodeA);
            int parentNodeB = unionFind.find(nodeB);

            if(parentNodeA == parentNodeB){
                return true;
            }else{
                unionFind.union(nodeA, nodeB);
            }
        }
        return false;
    }

    private static class UnionFind {
        private int[] root;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                root[rootY] = rootX;
            }
        }
    }
    //Edge List Representation of a Graph
    private static class Graph{
        int V;
        List<Edge> edgeList;

        public Graph(int V){
            this.V = V;
            edgeList = new ArrayList<>();
        }

        public void addEdge(int u, int v){
            edgeList.add(new Edge(u, v));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0); //This edge Forming a cycle

        if(hasCycle(g)){
            System.out.println("Graph contains a cycle");
        }
        else {
            System.out.println("No Cycle present in the Graph");
        }
    }
}
