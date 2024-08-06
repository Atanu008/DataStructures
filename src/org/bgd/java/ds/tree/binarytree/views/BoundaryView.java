package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/boundary-of-binary-tree/description/">...</a>
 *
 * The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.
 *
 * The left boundary is the set of nodes defined by the following:
 *
 * The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
 * If a node in the left boundary and has a left child, then the left child is in the left boundary.
 * If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
 * The leftmost leaf is not in the left boundary.
 * The right boundary is similar to the left boundary, except it is the right side of the root's right subtree.
 * Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a right child.
 *
 * The leaves are nodes that do not have any children. For this problem, the root is not a leaf.
 *
 * Given the root of a binary tree, return the values of its boundary.
 *
 * Input: root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
 * Output: [1,2,4,7,8,9,10,6,3]
 * Explanation:
 * - The left boundary follows the path starting from the root's left child 2 -> 4.
 *   4 is a leaf, so the left boundary is [2].
 * - The right boundary follows the path starting from the root's right child 3 -> 6 -> 10.
 *   10 is a leaf, so the right boundary is [3,6], and in reverse order is [6,3].
 * - The leaves from left to right are [4,7,8,9,10].
 * Concatenating everything results in [1] + [2] + [4,7,8,9,10] + [6,3] = [1,2,4,7,8,9,10,6,3].
 */

public class BoundaryView {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (!isLeaf(root)) {
            nodes.add(root.val);
        }

        nodes.addAll(addLeftBoundary(root.left));
        addLeaves(root, nodes);
        nodes.addAll(addRightBoundary(root.right));

        return nodes;
    }

    private List<Integer> addRightBoundary(TreeNode root) {
        TreeNode t = root;
        Deque<Integer> stack = new ArrayDeque<>();
        while (t != null) {
            if (!isLeaf(t))
                stack.add(t.val);

            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.addFirst(stack.pop());
        }

        return res;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }

        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    private List<Integer> addLeftBoundary(TreeNode root) {
        TreeNode t = root;
        List<Integer> res = new ArrayList<>();
        while (t != null) {
            if (!isLeaf(t))
                res.add(t.val);
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return res;
    }
}
