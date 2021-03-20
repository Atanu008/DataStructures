package org.atanu.java.ds.binarytree;

public class CheckCousins {

    private static int getLevel(TreeNode root, TreeNode node, int level) {

        if (root == null) {
            return 0;
        }

        if (root == node) {
            return level;
        }

        // Recur for left Sub Tree
        int increasedLevel = getLevel(root.left, node, level + 1);

        if (increasedLevel != 0) {
            return increasedLevel;
        }

        // Recurr right sub tree if not found in left subtree
        return getLevel(root.right, node, level + 1);
    }

    public static boolean isSiblings(TreeNode root, TreeNode a, TreeNode b) {


        if (root == null) {
            return false;
        }

        // for same node

        if (a == b) {
            return true;
        }
        return (root.left == a && root.right == b) || (root.left == b && root.right == a)
                || isSiblings(root.left, a, b) || isSiblings(root.right, a, b);

    }

    private static boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null) {
            return false;
        }

        return getLevel(root, a, 1) == getLevel(root, b, 1) && !isSiblings(root, a, b);

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

        boolean result = isCousins(root, root.left.left, root.right.left);

        //System.out.println(isSiblings(root, root.left.left, root.left.left));

        System.out.println("They are cousins " + result);

    }


}
