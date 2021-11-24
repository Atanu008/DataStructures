package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class TopView {


    public static void topView(TreeNode root) {

        if (root == null) {
            return;
        }

        // Create a TreeMap to store vertical order of binary tree nodes
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();

        // create an empty queue for level order traversal
        // It stores binary tree nodes and their horizontal distance from root
        Deque<Pair> queue = new ArrayDeque<>();

        // enqueue root node with horizontal distance as 0
        queue.add(new Pair(root, 0));

        // run till queue is not empty
        while (!queue.isEmpty()) {
            // pop front node from the queue
            Pair pair = queue.poll();

            TreeNode curr = pair.node;
            int dist = pair.dist;

            // insert front node value to the map using its horizontal distance
            // as the key
            if (!map.containsKey(dist)) {
                map.put(dist, new LinkedList<>());
            }

            map.get(dist).add(curr.val);

            // enqueue non-empty left and right child of front node
            // with their corresponding horizontal distance
            if (curr.left != null) {
                queue.add(new Pair(curr.left, dist - 1));
            }

            if (curr.right != null) {
                queue.add(new Pair(curr.right, dist + 1));
            }
        }

        // print the TreeMap
        map.forEach((k, v) -> System.out.print(v.getFirst()));
    }

    public static void main(String[] args) {
		
		/* Construct below tree
        1
      /   \
     /     \
    2       3
          /   \
         /     \
        5       6
      /   \
     /     \
    7       8
          /   \
         /     \
        9      10
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(9);
        root.right.left.right.right = new TreeNode(10);

        topView(root);

    }

}
