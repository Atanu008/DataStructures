package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
//LeetCode 987
public class VerticalOrderTraversalOfABinaryTree {
    private static class Pair implements Comparable<Pair>{

        TreeNode node;
        int dist;
        int row;
        int column;

        public Pair(TreeNode node, int dist, int row, int column) {
            super();
            this.node = node;
            this.dist = dist;
            this.row = row;
            this.column = column;
        }

        public int compareTo(Pair o){
            //If same row and same column sort ascending
            if(this.row == o.row && this.column == o.column){
                return this.node.val - o.node.val;
            }
            //Otherwise take from lower row values i.e from above level first
            else{
                return this.row - o.row;
            }
        }


    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Create a TreeMap to store vertical order of binary tree nodes
        Map<Integer, PriorityQueue<Pair>> map = new TreeMap<>();

        // create an empty queue for level order traversal
        // It stores binary tree nodes and their horizontal distance from root
        Deque<Pair> queue = new ArrayDeque<>();

        // enqueue root node with horizontal distance as 0
        queue.add(new Pair(root, 0,0,0));

        // run till queue is not empty
        while (!queue.isEmpty()) {
            // pop front node from the queue
            Pair pair = queue.poll();

            TreeNode curr = pair.node;
            int dist = pair.dist;
            int row = pair.row;
            int column = pair.column;

            // insert front node value to the map using its horizontal distance
            // as the key
            if (!map.containsKey(dist)) {
                map.put(dist, new PriorityQueue<>());
            }

            map.get(dist).offer(pair);

            // enqueue non-empty left and right child of front node
            // with their corresponding horizontal distance
            if (curr.left != null) {
                queue.add(new Pair(curr.left, dist - 1, row+1, column -1));
            }

            if (curr.right != null) {
                queue.add(new Pair(curr.right, dist + 1, row+1, column +1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        map.forEach((k, v) -> {
            List<Integer> verticalElements = new ArrayList<>();
            //Pop from PriorityQueue and create list
            while(!v.isEmpty()){
                verticalElements.add(v.poll().node.val);
            }
            result.add(verticalElements);
        });

        return result;
    }
}
