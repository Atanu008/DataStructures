package org.atanu.java.ds.binarytree;

public class Cousins {

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

    private static void printlevel(TreeNode root, TreeNode node, int level) {

        // either root is null or root the key
        if (root == null || level < 2) {
            return;
        }

        if (level == 2) {

            // return void for siblings
            if (root.left == node || root.right == node) {
                return;
            }
            if (root.left != null) {
                System.out.print(root.left.val + " ");
            }

            if (root.right != null) {
                System.out.print(root.right.val + " ");
            }
        }

        //Recurr for left and right if level is greater than 2
        else if (level > 2) {

            printlevel(root.left, node, level - 1);
            printlevel(root.right, node, level - 1);

        }
    }


    public static void printCousins(TreeNode root, TreeNode node) {

        if (root == null) {

            return;
        }

        int level = getLevel(root, node, 1);

        printlevel(root, node, level);
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

        printCousins(root, root.left.left);

    }

}
