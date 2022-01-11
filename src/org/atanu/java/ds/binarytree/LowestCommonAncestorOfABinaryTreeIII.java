package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
//LeetCode 1650
//Same as LeetCode 160 . https://leetcode.com/problems/intersection-of-two-linked-lists/
public class LowestCommonAncestorOfABinaryTreeIII {

    public Node lowestCommonAncestor(Node p, Node q) {
        Node ptA = p;
        Node ptB = q;

        while(ptA != ptB){

            ptA = ptA == null ? q : ptA.parent;
            ptB = ptB == null ? p : ptB.parent;
        }

        return ptA;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
