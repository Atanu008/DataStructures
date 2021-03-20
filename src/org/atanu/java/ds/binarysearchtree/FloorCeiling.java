package org.atanu.java.ds.binarysearchtree;

public class FloorCeiling {

    static class FloorCeilingValue {

        int floor;
        int ceiling;
    }


    public static void findFloorCeiling(TreeNode root, FloorCeilingValue fcv, int key) {

        if (root == null) {
            return;
        }

        // if node with key's value is found, both floor and ceil is equal
        // to the current node
        if (root.data == key) {

            fcv.ceiling = root.data;
            fcv.floor = root.data;
            return;
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {

            fcv.ceiling = root.data;

            findFloorCeiling(root.left, fcv, key);

        }
        // if given key is more than the root node, recur for right subtree
        else {

            fcv.floor = root.data;

            findFloorCeiling(root.right, fcv, key);
        }
    }

    public static void main(String[] args) {


        TreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = TreeNode.insertRecursive(root, key);
        }

        for (int i = 0; i < 18; i++) {
            FloorCeilingValue fcv = new FloorCeilingValue();

            findFloorCeiling(root, fcv, i);
            System.out.println(i + " -> Floor is " + fcv.floor + ", Ceil is "
                    + fcv.ceiling);
        }
    }


}
