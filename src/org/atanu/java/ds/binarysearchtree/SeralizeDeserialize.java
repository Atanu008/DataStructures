package org.atanu.java.ds.binarysearchtree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SeralizeDeserialize {

    //PreOrder Traversal And concaticate
    public static String serialize(TreeNode root) {

        if (root == null) {

            return "X,";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.data + "," + left + right;

    }

    public static TreeNode deSerialize(String str) {

        Deque<String> queue = new LinkedList<>();

        queue.addAll(Arrays.asList(str.split(",")));

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

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializeString = serialize(root);

        System.out.println(serializeString);

        TreeNode restoredRoot = deSerialize(serializeString);

        TreeNode.inOrder(restoredRoot);
    }

}
