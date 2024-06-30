package org.bgd.java.ds.tree.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 */

public class SerialiseDeserialiseBT {
    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            return serialiseHelper(root, sb).toString();
        }

        private StringBuilder serialiseHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("NULL ");
            } else {
                sb.append(root.val + " ");
                sb = serialiseHelper(root.left, sb);
                sb = serialiseHelper(root.right, sb);
            }
            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(" ");
            List<String> list = new LinkedList<>(Arrays.asList(dataArray));
            return deserialiseHelper(list);
        }

        private TreeNode deserialiseHelper(List<String> list) {
            if (list.get(0)
              .equals("NULL")) {
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            root.left = deserialiseHelper(list);
            root.right = deserialiseHelper(list);
            return root;
        }
    }
}
