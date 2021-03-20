package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DiagonalView {


    private static void printDiagonal(TreeNode node, int diagonal, Map<Integer, List<Integer>> map) {

        if (node == null) {

            return;
        }

        if (!map.containsKey(diagonal)) {

            map.put(diagonal, new ArrayList<>());
        }

        // insert current node in current diagonal
        map.get(diagonal).add(node.data);

        // recur for left subtree by increasing diagonal by 1
        printDiagonal(node.left, diagonal - 1, map);

        // recur for right subtree with same diagonal
        printDiagonal(node.right, diagonal, map);


    }

    public static void printDiagonalRecursive(TreeNode root) {

        // create an empty multi-map to store diagonal element in every slope
        Map<Integer, List<Integer>> map = new HashMap<>();

        // do pre-order traversal of the tree and fill the map
        printDiagonal(root, 0, map);

        for (List<Integer> a : map.values()) {
            System.out.println(a);
        }
    }

    public static void printDiagonalIterative(TreeNode root) {

        // base case
        if (root == null)
            return;


        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        // Add root
        queue.add(root);

        // add delimiter
        queue.add(null);

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            if (curr == null) {

                // printed everything
                if (queue.isEmpty())
                    return;

                // new diagonal series.
                System.out.println();

                queue.add(null);
            } else {

                while (curr != null) {
                    System.out.print(curr.data);

                    if (curr.left != null) {
                        queue.add(curr.left);
                    }

                    curr = curr.right;
                }

            }
        }


    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        printDiagonalRecursive(root);

        System.out.println("Printing Iteratively");

        printDiagonalIterative(root);

    }

}
