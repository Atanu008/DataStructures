package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightNode {

    // The idea is to do level order traversal and return immediate next right element
    public static TreeNode findNextRightNode(TreeNode root, int key) {

        // return if tree is empty
        if (root == null) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                if (curr.val == key) {

                    if (queue.isEmpty()) {
                        return null;
                    }

                    return queue.peek();
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

		/* Construct below tree
        1
     /     \
    2       3
   / \     / \
  4   5   6   7
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int key = 6;

        TreeNode result = findNextRightNode(root, key);

        if (result != null)
            System.out.println("Next element " + key + " is  " + result.val);

    }

}
