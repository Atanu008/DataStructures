package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class DiagonalSum {

    private static void diagonalSum(TreeNode root, int diagonal, Map<Integer, Integer> map) {

        if (root == null) {

            return;
        }

        if (!map.containsKey(diagonal)) {

            map.put(diagonal, root.val);
        } else {
            map.put(diagonal, map.get(diagonal) + root.val);
        }

        diagonalSum(root.left, diagonal - 1, map);

        diagonalSum(root.right, diagonal, map);


    }

    private static void printDiagonalSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        // do pre-order traversal of the tree and fill the map
        diagonalSum(root, 0, map);

        // traverse the map and print diagonal sum

        for (int a : map.values()) {
            System.out.println(a);
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


        printDiagonalSum(root);
    }


}


