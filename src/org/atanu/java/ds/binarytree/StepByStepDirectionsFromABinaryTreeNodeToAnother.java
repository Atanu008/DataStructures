package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
//Leetcode 2096
//Explanation : https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/solutions/1613071/idea-explained-lca-tree-traversal-backtracking-c-clean-code/?orderBy=most_votes
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    //First of all find the LCA node of start and destination.
    //Then we need to get path from lca_to_start and from lca_to_destination.

//To get path from root -> node as a string, we will use traverse() function.

//In this we simply do a simple DFS ( kind of pre-order traversal)
////First explore left path, if node is found. Then return true
//Otherwise backtrack and explore right path.
//Now that we have both paths, we will convert all chars in lca_to_start to U, since we will move upward.

    //At last, concatenate both strings and return combined path.
    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder lcaToStart = new StringBuilder();
        findPath(lca, startValue, lcaToStart);

        StringBuilder lcaToDest = new StringBuilder();
        findPath(lca, destValue, lcaToDest);

        String startToLCA = "";
        for (int i = 0; i < lcaToStart.length(); i++) {
            startToLCA += 'U';
        }

        return startToLCA + lcaToDest.toString();
    }

    private boolean findPath(TreeNode root, int value, StringBuilder sb) {
        //Base Condition . if we reach end and no sign of
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }
        //Go Left
        sb.append("L");
        if (findPath(root.left, value, sb)) {
            return true;//Return if the path id found
        }
        sb.deleteCharAt(sb.length() - 1); // Imp: Path not Found in Left . Backtrack

        //Go Right
        sb.append("R");
        if (findPath(root.right, value, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1); // Imp: Path not Found in Right . Backtrack

        return false; // Np Path Found

    }

    private TreeNode findLCA(TreeNode root, int a, int b) {

        if (root == null) {
            return null;
        }

        if (root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
