package org.atanu.java.ds.binarysearchtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class TwoSumBST {

	public static boolean findTargetSol1(TreeNode root, int k) {

		Map<Integer,Boolean> result = new HashMap<Integer,Boolean>();

		searchInBSTSol1(root,k, new HashMap<Integer,Integer>(),  result);

		return result.containsKey(k);
	}

	// Do a PreOrder Traversal
	public static boolean searchInBSTSol1(TreeNode root, int k, Map<Integer,Integer> map, Map<Integer,Boolean> result){

		//Base Case
		if(root == null)
			return false;

		// Update the Result Map with true if the .
		// Result map is redundant . But still can be used to check for teh result
		if(map.containsKey(k - root.data)) {
			result.put(k, true);
			return true;
		}

		// the nodes value into map
		map.put(root.data,root.data);

		// Recursively traverse left sub Tree . If not fond in Left the Traverse in Right
		return searchInBSTSol1(root.left,k,map,result) || searchInBSTSol1(root.right,k,map,result);


	}


	public static boolean findTargetSol2(TreeNode root, int k) {

		return searchInBSTSol2(root,k, new HashSet<Integer>());
	}

	// InOrder Traversal
	private static boolean searchInBSTSol2(TreeNode root, int k, HashSet<Integer> set) {

		//Base Case
		if(root == null)
			return false;

		// If the sum is found in left Sub tree Return Tre
		if(searchInBSTSol2(root.left, k, set)) {
			return true;
		}

		// If the pair is found return true
		if(set.contains(k - root.data)) {
			System.out.print("Pair found (" + (k - root.data) + ", "
					+ root.data + ")");
			return true;
		}

		//Include the item in teh set.
		set.add(root.data);

		//// search in right subtree
		return searchInBSTSol2(root.right, k, set);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		int k = 9;

		System.out.println(k +" Found " + findTargetSol1(root, k));
		
		System.out.println(k +" Found " + findTargetSol2(root, k));

	}

}
