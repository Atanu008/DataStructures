package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()) {
            leftToRight = !leftToRight;
            int s = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< s; i++) {
                TreeNode top =queue.poll();
                if(leftToRight) {
                    list.addFirst(top.val);
                } else {
                    list.addLast(top.val);
                }
                if(top.left != null) {
                    queue.offer(top.left);
                }
                if(top.right != null) {
                    queue.offer(top.right);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}
