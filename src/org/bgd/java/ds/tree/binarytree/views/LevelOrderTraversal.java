package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">...</a>
 *
 * Both Iterative and Recursive Solutions are added below
 */

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int s = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            answer.add(list);
        }
        return answer;
    }

    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        level(root, answer, 0);
        return answer;

    }

    private void level(TreeNode root, List<List<Integer>> answer, int level) {
        if (root == null) {
            return;
        }

        if (level == answer.size()) {
            answer.add(new ArrayList<>());
        }

        answer.get(level)
          .add(root.val);
        level(root.left, answer, level + 1);
        level(root.right, answer, level + 1);
    }

}
