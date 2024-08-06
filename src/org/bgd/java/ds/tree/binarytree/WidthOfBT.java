package org.bgd.java.ds.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/description/">...</a>
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 *
 *
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 */
public class WidthOfBT {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int max = 0;

        while (!q.isEmpty()) {
            int s = q.size();
            int first = -1;
            int last = -1;
            for (int i = 0; i < s; i++) {

                Pair top = q.poll();
                int currlevel = top.level;

                if (i == 0) {
                    first = currlevel;
                }
                if (i == s - 1) {
                    last = currlevel;
                }

                if (top.node.left != null) {
                    q.offer(new Pair(top.node.left, 2 * currlevel + 1));
                }

                if (top.node.right != null) {
                    q.offer(new Pair(top.node.right, 2 * currlevel + 2));
                }
            }

            max = Math.max(max, last - first + 1);
        }
        return max;
    }

    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
