package org.atanu.java.ds.binarytree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RightView {

    public static void rightView(TreeNode root) {

        // return if tree is empty
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            // calculate number of nodes in current level
            int size = queue.size();

            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            for (int i = 1; i <= size; i++) {
                TreeNode curr = queue.poll();

                // if this is first node of current level, print it
                if (i == size) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }


    // traverse nodes in reverse pre-order
    //For every node encountered, we insert the node and level information into the map.
    //Finally when all nodes are processed, we traverse the map and print the right view

    public static void rightView(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // insert the current node and level information into the map
        map.put(level, root.data);

        // recur for right subtree before right subtree
        rightView(root.left, level + 1, map);
        rightView(root.right, level + 1, map);
    }

    // Function to print right view of given binary tree
    public static void rightViewRecursion(TreeNode root) {
        // create an empty map to store last node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill map
        rightView(root, 1, map);

        // iterate through the map in sorted order of its keys and print right view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }


    public static void main(String[] args) {

		/* Construct below tree
        1
      /   \
     /     \
    2       3
     \      / \
      \    /   \
       4  5     6
         / \
        /   \
       7     8 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        rightView(root);

    }

}
