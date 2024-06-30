package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator leftToRight = new BSTIterator(root, false);
        BSTIterator rightToLeft = new BSTIterator(root, true);

        int l = leftToRight.next();
        int r = rightToLeft.next();
        while (l < r) {
            if (l + r == k) {
                return true;
            } else if (l + r < k) {
                l = leftToRight.next();
            } else {
                r = rightToLeft.next();
            }
        }
        return false;

    }

    class BSTIterator {
        /**
         * This iterator provides methods for going forward and backward, but not at the same time.
         * Ideally, two separate instances of this iterator has to be initialised by passing isReverse = [true, false].
         */

        Deque<TreeNode> stack;
        boolean isReverse;

        public BSTIterator(TreeNode root, boolean isReverse) {
            stack = new ArrayDeque<>();
            this.isReverse = isReverse;
            if (isReverse) {
                pushAllRightNodes(root);
            } else {
                pushAllLeftNodes(root);
            }

        }

        public int next() {
            if (stack.isEmpty()) {
                return -1;
            }
            TreeNode top = stack.pop();
            int value = top.val;
            if (isReverse) {
                pushAllRightNodes(top.left);
            } else {
                pushAllLeftNodes(top.right);
            }

            return value;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        void pushAllLeftNodes(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        void pushAllRightNodes(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
        }
    }
}
