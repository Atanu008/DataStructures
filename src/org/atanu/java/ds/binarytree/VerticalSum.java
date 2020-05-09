package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {

	public static void verticalSum(TreeNode root , int dist , Map<Integer, Integer> map) {

		if(root == null) {

			return;
		}

		if(!map.containsKey(dist)) {

			map.put(dist,root.data);
		}
		else {
			map.put(dist, map.get(dist) + root.data);
		}


		// recur for left subtree by decreasing horizontal distance by 1
		verticalSum(root.left, dist - 1, map);

		// recur for right subtree by increasing horizontal distance by 1
		verticalSum(root.right, dist + 1, map);
	}

	public static void printVerticalSum(TreeNode root) {


		Map<Integer,Integer> map = new TreeMap<>();

		verticalSum(root, 0, map);

		map.forEach((k,v) -> System.out.println(v));
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
		
		printVerticalSum(root);

	}

}
