package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
//LeetCode 1644
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
public class LowestCommonAncestorOfABinaryTreeII {

    //We need a way to record if we've seen both p and q
    //We need to traverse the entire tree even after we've found one of them.
    //Use either boolean or integers as flags
    //Do Post Order Traversal to visit all the nodes and mark if found - Main Difference from LeetCode 236
    //Keep traversing down the entire tree. If you return early, the above example would be null, because the code stops when it finds 5 and does not keep searching for 4.
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }
        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else if(right != null){
            return right;
        }
        else return null;
        //return left == null ? right : right == null ? left : root;
    }


    //Using integers as flags
    int count = 0;
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCAV2(root, p, q);
        return count == 2 ? LCA : null;
    }

    public TreeNode LCAV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCAV2(root.left, p, q);
        TreeNode right = LCAV2(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }
}
