package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        mapParentPointers(root, parents);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        List<Integer> answer = new ArrayList<>();

        int curr = 0;

        while (!queue.isEmpty()) {
            int s = queue.size();
            if (curr == k) {
                break;
            }
            curr++;
            for (int i = 0; i < s; i++) {
                TreeNode top = queue.poll();

                if (top.left != null && !visited.containsKey(top.left)) {
                    visited.put(top.left, true);
                    queue.offer(top.left);
                }

                if (top.right != null && !visited.containsKey(top.right)) {
                    visited.put(top.right, true);
                    queue.offer(top.right);
                }
                if (parents.get(top) != null && !visited.containsKey(parents.get(top))) {
                    visited.put(parents.get(top), true);
                    queue.offer(parents.get(top));
                }

            }
        }
        while (!queue.isEmpty()) {
            answer.add(queue.poll().val);
        }
        return answer;
    }

    private void mapParentPointers(TreeNode root, Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                parents.put(top.left, top);
                queue.offer(top.left);
            }
            if (top.right != null) {
                parents.put(top.right, top);
                queue.offer(top.right);
            }
        }
    }
}
