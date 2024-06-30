package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator">...</a>
 *
 * 173. Binary Search Tree Iterator
 *
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 */

public class BSTIterator {
    /**
     * This iterator provides methods for going forward and backward, but not at the same time.
     * Ideally, two separate instances of this iterator has to be initialised by passing isReverse = [true, false].
     */

    Deque<TreeNode> stack;
    boolean isReverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        stack = new ArrayDeque<>();
        this.isReverse = isReverse;
        pushAllLeftNodes(root);
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
