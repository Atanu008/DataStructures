package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/
//Leetcode 1519

//Explanation : https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/solutions/2864718/number-of-nodes-in-the-sub-tree-with-the-same-label/?orderBy=newest_to_oldest

import java.util.*;

//Create an adjacency list where adj[X] contains all the neighbors of node X.
//Initialize an array ans, storing the answer of each node. Initialize it with 0 for every node.
//Start a DFS traversal.
//We use a dfs function to perform the traversal. For each call, pass node, parent, adj, labels and ans as the parameters. It returns an array which stores the count of each label in the node's subtree. We start with node 0. We also keep track of the parent node of the current node so that we don’t visit the node’s parent as it has already been visited.
//Initialize an array nodeCounts to store the count of each label in the node's subtree. Initialize it with 0 except for the node label, which should be 1.
//Iterate over all the children of the node (nodes that share an edge) and check if any child is equal to the parent. If the child is equal to the parent, we will not visit it again.
//If the child is not equal to the parent, recursively call the dfs function with the node as child and the parent as node. Store the count of all labels in its subtree in childCounts.
//Add childCounts to nodeCounts.
//After looping through all the children, set the ans[node] to ans[node] = nodeCounts[labels[node]].
//Return nodeCounts.
//Return ans.
public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        //Extreme Bad use case, if only one node , with no edges.
        if(n == 1){
            return new int[]{1};
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            adjList.computeIfAbsent(nodeA, value -> new ArrayList<>()).add(nodeB);
            adjList.computeIfAbsent(nodeB, value -> new ArrayList<>()).add(nodeA);
        }

        char[] label = labels.toCharArray();
        int[] ans = new int[n];

        dfs(0, -1, label, ans, adjList);

        return ans;
    }

    private int[] dfs(int node, int parent, char[] label, int[] ans, Map<Integer, List<Integer>> adjList){

        int[] freq = new int[26];//For evey character wil store the freq
        freq[label[node] - 'a'] = 1;

        if(!adjList.containsKey(node)){
            return freq;
        }

        for(int child : adjList.get(node)){
            if(child == parent){
                continue;
            }
            int[] childFreq = dfs(child, node, label, ans, adjList);

            for(int i = 0; i < 26; i++){
                freq[i] += childFreq[i];
            }
        }

        ans[node] = freq[label[node] - 'a'];
        return freq;

    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][]{
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        };
        String labels = "abaedcd";
        int[] res = new NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(n,edges,labels);
        Arrays.stream(res).forEach(e -> System.out.print(e+" "));
    }
}
