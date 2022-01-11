package org.atanu.java.ds.binarysearchtree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/serialize-and-deserialize-bst/
//LeetCode 449
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {

            return "X";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Deque<String> queue = new LinkedList<>();

        queue.addAll(Arrays.asList(data.split(",")));

        return deSerializeHelper(queue);

    }

    private static TreeNode deSerializeHelper(Deque<String> queue) {

        String valueOfNode = queue.poll();

        if (valueOfNode.equals("X")) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(valueOfNode));

        newNode.left = deSerializeHelper(queue);
        newNode.right = deSerializeHelper(queue);

        return newNode;

    }
}
