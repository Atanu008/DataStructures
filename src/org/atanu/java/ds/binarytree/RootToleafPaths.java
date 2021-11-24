package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class RootToleafPaths {

    public static void printRootToleafPaths(TreeNode root, Deque<Integer> path) {

        if (root == null) {
            return;
        }


        // include current node to the path
        path.addLast(root.val);

        // if leaf node is found, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }

        // recur for left and right subtree
        printRootToleafPaths(root.left, path);

        printRootToleafPaths(root.right, path);

        // remove current node after left and right subtree are done
        path.removeLast();

    }

    public static void printRootToleafPaths(TreeNode root) {
        // list to store root to leaf path
        Deque<Integer> path = new ArrayDeque<>();
        printRootToleafPaths(root, path);
    }

    public static void main(String[] args) {
		
		/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \      / \
  /   \    /   \
 4     5  6     7
         / \
        /   \
       8     9
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        printRootToleafPaths(root);

    }

}
