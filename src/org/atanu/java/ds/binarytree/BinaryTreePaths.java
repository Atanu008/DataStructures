package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
//LeetCode 257

//Same as RootToleafPaths, Here are are just storing the path in String instead of Queue/List
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();
        printRootToleafPaths(root, "", paths);
        return paths;
    }

    public void printRootToleafPaths(TreeNode root, String path, List<String> paths) {

        if (root == null) {
            return;
        }

        // include current node to the path
        path += Integer.toString(root.val);

        // if leaf node is found, Add current Path to the Paths list
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        //Extend Path
        path += "->";

        // recur for left and right subtree
        printRootToleafPaths(root.left, path, paths);
        printRootToleafPaths(root.right, path, paths);

    }
}
