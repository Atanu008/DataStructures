package org.atanu.java.ds.binarytree;
//LeetCode 951
//https://leetcode.com/problems/flip-equivalent-binary-trees/
public class IsoMorphic {
    public boolean flipEquiv(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }

        return (a.data == b.data)
                && ((flipEquiv(a.left, b.left) && flipEquiv(a.right, b.right))
                || (flipEquiv(a.left, b.right) && flipEquiv(a.right, b.left))
        );
    }

    public static void main(String[] args) {
        IsoMorphic isoMorphic = new IsoMorphic();
        // Let us create trees shown in above diagram
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.left.right = new TreeNode(6);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        if (isoMorphic.flipEquiv(root1, root2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
