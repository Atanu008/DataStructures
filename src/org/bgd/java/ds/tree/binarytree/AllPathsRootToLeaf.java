package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
 *
 * Given a Binary Tree of nodes, you need to
 * find all the possible paths from the root node to all the leaf nodes of the binary tree.
 *
 */
public class AllPathsRootToLeaf {
    /**
     *
     * This can be used to find any path from root to a node.
     * This is a backtracking solution.
     *
     */
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        dfs(root, paths, new ArrayList<>());

        return paths;
    }

    private static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));

        }

        dfs(root.left, paths, path);
        dfs(root.right, paths, path);

        path.remove(path.size() - 1);

    }
}
