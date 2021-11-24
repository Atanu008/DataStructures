package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    // relative Order is not maintained . 10 will come before 6
    public static void printVerticalView(TreeNode root, int dist, Map<Integer, LinkedList<Integer>> map) {

        if (root == null) {
            return;
        }

        // insert nodes present at current horizontal distance into the map

        if (!map.containsKey(dist)) {
            map.put(dist, new LinkedList<>());
        }

        map.get(dist).add(root.val);

        // recur for left subtree by decreasing horizontal distance by 1
        printVerticalView(root.left, dist - 1, map);

        // recur for right subtree by increasing horizontal distance by 1
        printVerticalView(root.right, dist + 1, map);
    }

    public static void printVertical(TreeNode root) {


        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();

        printVerticalView(root, 0, map);

        map.forEach((k, v) -> System.out.println(v));
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

        printVertical(root);
    }

}
