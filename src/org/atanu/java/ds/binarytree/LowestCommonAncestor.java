package org.atanu.java.ds.binarytree;

public class LowestCommonAncestor {

    static boolean v1, v2;
    //The basic idea behind the algorithm is to call recursively at each node lowestCommonAncestor function in left and right subtree of node untill we encounter either p or q and return that node. If we dont find it we return null

    //if both subtree (left and right) return non-null value then it is the common ancestor otherwise return the p and q value repectively

    //if both are null that means p and q doesn't exist in the subtree so return null

    // This solution assumes all the keys are present in the Tree

    public static TreeNode findLCA(TreeNode root, int x, int y) {

        // Base Case
        if (root == null) {
            return null;
        }

        //If either x or y matches with root's key,
        if (root.data == x || root.data == y) {
            return root;
        }

        TreeNode left_LCA = findLCA(root.left, x, y);

        TreeNode right_LCA = findLCA(root.right, x, y);

        if (left_LCA != null && right_LCA != null) {
            return root;
        } else if (left_LCA != null) {
            return left_LCA;
        } else if (right_LCA != null) {
            return right_LCA;
        } else
            return null;
    }


    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    public static TreeNode findLCASol2(TreeNode root, int n1, int n2) {
        // Initialize n1 and n2 as not visited 
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above 
        TreeNode lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree 
        if (v1 && v2)
            return lca;

        // Else return NULL 
        return null;
    }

    private static TreeNode findLCAUtil(TreeNode root, int x, int y) {
        // Base Case
        if (root == null) {
            return null;
        }

        TreeNode temp = null;
        //If either x or y matches with root's key,
        if (root.data == x) {

            temp = root;
            v1 = true;
        }

        if (root.data == y) {

            temp = root;
            v2 = true;
        }

        if (temp != null) {

            return temp;
        }
        TreeNode left_LCA = findLCAUtil(root.left, x, y);

        TreeNode right_LCA = findLCAUtil(root.right, x, y);

        if (left_LCA != null && right_LCA != null) {
            return root;
        } else if (left_LCA != null) {
            return left_LCA;
        } else if (right_LCA != null) {
            return right_LCA;
        } else
            return null;
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

        System.out.println("LCA of 3 and 7 is " + findLCA(root, 3, 7).data);

        System.out.println("LCA of 5 and 9 is " + findLCA(root, 5, 9).data);

        System.out.println("LCA of 5 and 4 is " + findLCA(root, 5, 4).data);

        System.out.println("LCA of 8 and 7 is " + findLCA(root, 7, 8).data);

        System.out.println("\n");

        // This line will get null .
        //System.out.println("LCA of 3 and 7 is "+ findLCASol2(root,3,7).data);

        System.out.println("LCA of 5 and 9 is " + findLCASol2(root, 5, 9).data);

        System.out.println("LCA of 5 and 4 is " + findLCASol2(root, 5, 4).data);

        System.out.println("LCA of 8 and 7 is " + findLCASol2(root, 7, 8).data);


    }

}
