package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/flip-equivalent-binary-trees/
//LeetCode 951
// Video : https://www.youtube.com/watch?v=QrHTec92270
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //If Two nodes are equal return True
        if(root1 == null && root2 == null){
            return true;
        }

        //If either of them is null Or values dont match return False
        if(root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }

        //Now if we have came this far means values are equal . Now just check the sub trees

        //Check if Two SubTrees are equal
        boolean firstCheck = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        //Check if Two SubTrees are equal after FLIPPING
        boolean secondCheck = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return firstCheck || secondCheck;
    }

    public static void main(String[] args) {

    }

}
