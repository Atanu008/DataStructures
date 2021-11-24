package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {

    public static void bottomView(TreeNode root) {

        if (root == null) {
            return;
        }

        Map<Integer, Integer> map = new TreeMap<>();

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

            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node 
            // having same horizontal distance we need to replace 
            // the data in the map. 

            map.put(dist, curr.val);


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
        map.forEach((k, v) -> System.out.print(v + " "));


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

        bottomView(root);

    }

}
