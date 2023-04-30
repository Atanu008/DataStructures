package org.atanu.java.ds.graph;

import org.atanu.java.ds.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://www.techiedelight.com/determine-nodes-lie-same-path-binary-tree/
// https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/ (Using Graph)
// https://tutorialcup.com/interview/graph/check-if-two-nodes-are-on-the-same-path-in-a-tree.htm (Using Grap)
// https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree-set-2/ (Another way to check via LCA
// The idea is to use Lowest Common Ancestor. Find the LCA of the given vertices v1 and v2. If the LCA is equal to any of the given two vertices, print Yes. Otherwise, print No.)


public class CheckIfTwoNodesAreOnSamePath {

    //Intition:

    // Intime – intime of a node is the time at which it is visited first
    // while performing DFS traversal starting from root node, it’s the entry time of a node during DFS traversal.
    //
    // Outtime – outtime of a node is the time at which it is visited after all it’s children have been visited,
    // this happens while returning along the path towards root node, it’s exit time of a node during DFS traversal.
    //
    //If nodes u & v lie along the same path:
    //
    // assuming u is parent of v then, intime of u < intime of v & outtime of u > outtime of v.
    // Or assuming v is parent of u then, intime of v < intime of u & outtime of v > outtime of u.
    // Generally, when two nodes lie along the same path, one is parent and other is child. In that case after DFS traversal:
    // intime of parent < intime of child
    // outtime of parent > outtime of child

    private void dfs(TreeNode node, Map<TreeNode, Integer> inTime, Map<TreeNode, Integer> outTime, int[] time) {

        if(node == null){
            return;
        }
        // Increment Time
        time[0]++;
        // Record Intime
        inTime.put(node, time[0]);

        dfs(node.left,inTime, outTime, time);
        dfs(node.right,inTime, outTime, time);

        time[0]++; // Increment Time
        outTime.put(node, time[0]);
    }

    public boolean isInsamePath(TreeNode root, TreeNode nodeA, TreeNode nodeB){

        Map<TreeNode, Integer> inTime = new HashMap<>();
        Map<TreeNode, Integer> outTime = new HashMap<>();
        int[] time = new int[1];
        dfs(root, inTime, outTime, time);

        boolean nodeAParent = inTime.get(nodeA) < inTime.get(nodeB) && outTime.get(nodeA) > outTime.get(nodeB);
        boolean nodeBParent = inTime.get(nodeB) < inTime.get(nodeA) && outTime.get(nodeB) > outTime.get(nodeA);

        if (nodeAParent) {
            System.out.println("Node " + nodeA.val + " is an ancestor of Node " + nodeB.val);
        }
        else if (nodeBParent) {
            System.out.println("Node " + nodeA.val + " is a direct descendant of Node " +
                    nodeB.val);
        }
        else {
            System.out.println("Node " + nodeA.val + " is a neither an ancestor nor a " +
                    "descendant of Node " + nodeB.val);
        }

        boolean isInSamePath = nodeAParent || nodeBParent;
        return isInSamePath;
    }

    public static void main(String[] args) {
        // construct a binary tree as per the above diagram
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.left.left.right.left = new TreeNode(12);
        root.left.left.right.right = new TreeNode(13);
        root.right.right.left.left = new TreeNode(14);

        CheckIfTwoNodesAreOnSamePath checkIfTwoNodesAreOnSamePath = new CheckIfTwoNodesAreOnSamePath();

        checkIfTwoNodesAreOnSamePath.isInsamePath(root, root.right, root.right.right.left.left);

        checkIfTwoNodesAreOnSamePath.isInsamePath(root, root.left.left.right.left, root.left);

        checkIfTwoNodesAreOnSamePath.isInsamePath(root, root.left.left, root.left.right);
    }

}
