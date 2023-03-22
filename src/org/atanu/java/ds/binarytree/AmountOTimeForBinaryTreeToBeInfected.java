package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
//Leetcode 2385

// Algo :
// Step 1:
// Build the graph from the Tree
// While building the tree store the starting node
// Step 2:
// Start BFS from the startNode
// For each layer increment the level(i.e injecting all nodes in the same level at time T(level))
// Return level
public class AmountOTimeForBinaryTreeToBeInfected {

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        TreeNode startNode = buildGraph(root, adjList, start);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);

        int level = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            while(size --> 0){
                TreeNode current = queue.poll();
                for(TreeNode neighbour : adjList.get(current)){
                    if(!visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }
        return level - 1; // -1 because in the loop it counted for the last nodes as well(9, 2 in this case)
    }

    private TreeNode buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> adjList, int start){

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode startNode = null;
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();
            if(start == current.val){
                startNode = current;
            }
            adjList.putIfAbsent(current, new ArrayList<>());
            if(current.left != null){
                adjList.putIfAbsent(current.left, new ArrayList<>());
                adjList.get(current.left).add(current);
                adjList.get(current).add(current.left);
                queue.offer(current.left);
            }
            if(current.right != null){
                adjList.putIfAbsent(current.right, new ArrayList<>());
                adjList.get(current.right).add(current);
                adjList.get(current).add(current.right);
                queue.offer(current.right);
            }
        }

        return startNode;
    }
}
