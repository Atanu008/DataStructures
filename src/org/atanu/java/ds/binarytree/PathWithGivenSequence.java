package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
//LeetCode 1430
//https://www.educative.io/courses/grokking-the-coding-interview/m280XNlPOkn
public class PathWithGivenSequence {

    public boolean isValidSequence(TreeNode root, int[] sequence) {
        if (root == null)
            return sequence.length == 0;

        return findPathRecursive(root, sequence, 0);
    }

    private boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {

        if (currentNode == null)
            return false;

        if (sequenceIndex >= sequence.length || currentNode.val != sequence[sequenceIndex])
            return false;

        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        //currentNode.val == sequence[sequenceIndex] is not necessary as we are checking non equality check before
        if (currentNode.left == null && currentNode.right == null && currentNode.val == sequence[sequenceIndex] && sequenceIndex == sequence.length - 1)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
                || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
    }
}
