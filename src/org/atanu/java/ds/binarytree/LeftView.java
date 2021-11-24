package org.atanu.java.ds.binarytree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LeftView {

    // Use Level Order Traversal
    //Maintain nodes in current level
    //If the current node is first node print it
    public static void printLeftView(TreeNode root) {

        // return if tree is empty
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            // calculate number of nodes in current level
            int i = 0;
            int size = queue.size();

            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (i++ < size) {
                TreeNode curr = queue.poll();

                // if this is first node of current level, print it
                if (i == 1) {
                    System.out.print(curr.val + " ");
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


    // The idea is to traverse the tree in preorder fashion and pass level information in function arguments.
    //If the level is visited for the first time, then we insert the current node and level information into the map.
    //Finally when all nodes are processed, we traverse the map and print the left view.

    public static void leftView(TreeNode root, int level, Map<Integer, Integer> map) {

        // base case
        if (root == null) {
            return;
        }

        // if level is visited for the first time, insert the current node
        // and level information into the map
        if (!map.containsKey(level)) {
            map.put(level, root.val);
        }

        leftView(root.left, level + 1, map);

        leftView(root.right, level + 1, map);
    }

    public static void leftView(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // traverse the tree and fill map
        leftView(root, 1, map);

        // iterate through the HashMap in sorted order of its keys
        // and print the left view
        map.forEach((k, v) -> System.out.print((v + " ")));
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

        printLeftView(root);

        System.out.println();

        leftView(root);
    }

}
