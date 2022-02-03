package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-right-side-view/
//LeetCode 199
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // if it is the last node of this level, add it to the result
                if (i == levelSize - 1)
                    result.add(currentNode.val);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }

        return result;
    }

    //The idea is to traverse the tree in a preorder fashion and pass level information in function arguments.
    //For every node encountered, insert the node and level information into the map.
    //Finally, when all nodes are processed, traverse the map and print the right view.
    public List<Integer> rightSideViewV2(TreeNode root) {

        List<Integer> rightViewList = new ArrayList<>();
        // create an empty map to store last node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill map
        rightView(root, 1, map);

        // iterate through the map in sorted order of its keys and print right view
        for (int i = 1; i <= map.size(); i++) {
            rightViewList.add(map.get(i));
        }

        return rightViewList;
    }

    public void rightView(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // insert the current node and level information into the map
        map.put(level, root.val);

        // recur for left and  subtree before right subtree
        rightView(root.left, level + 1, map);
        rightView(root.right, level + 1, map);
    }
}
