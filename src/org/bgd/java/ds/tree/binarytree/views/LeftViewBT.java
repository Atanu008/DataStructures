package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * <a href="https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1">...</a>
 *
 * This can be reused by RightView As well
 */
public class LeftViewBT {

    /**
     * With Level Order Traversal
     */
    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int s = q.size();
            boolean flag = false;
            for (int i = 0; i < s; i++) {

                TreeNode top = q.poll();

                if (!flag) {
                    list.add(top.val);
                    flag = true;
                }

                if (top.left != null) {
                    q.offer(top.left);
                }

                if (top.right != null) {
                    q.offer(top.right);
                }
            }
        }

        return list;
    }

    /**
     * Recursive DFS Traversal
     */
    List<Integer> leftViewRec(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        leftViewDFS(root, 0, res);

        return res;

    }

    private void leftViewDFS(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }

        leftViewDFS(root.left, level + 1, res);
        leftViewDFS(root.right, level + 1, res);

    }

}
