package org.atanu.java.ds.binarytree;

public class HasPathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {

        // this will only execute for empty tree
        if (root == null) {
            return false;
        }

        sum = sum - root.val;

        // Base Case . For leaf Node
        if (root.left == null && root.right == null && sum == 0) {

            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);


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

        int sum = 7;

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        if (hasPathSum(root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is NO root to leaf path with sum " + sum);
    }

}
