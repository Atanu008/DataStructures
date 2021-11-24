package org.atanu.java.ds.binarytree;

import java.util.ArrayList;

public class BoundaryTraversalv2 {
    Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.val);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
    ArrayList <Integer> printBoundary(TreeNode node)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(isLeaf(node) == false) ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.left.right.left.left = new TreeNode(10);

        BoundaryTraversalv2 v2 = new BoundaryTraversalv2();
        ArrayList<Integer> ans = v2.printBoundary(root);
        ans.forEach(System.out::print);

    }
}
