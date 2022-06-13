package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/delete-nodes-and-return-forest/
//LeetCode 1110
//Vodeo : https://www.youtube.com/watch?v=aaSFzFfOQ0o
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> includeForest = new ArrayList<>();
        Set<Integer> toBeDeleted = new HashSet<>();
        for(int a : to_delete){
            toBeDeleted.add(a);
        }

        deletePostOrder(root, toBeDeleted, includeForest);

        if(!toBeDeleted.contains(root.val)) { //For root checking . as the recursion is not handeling(adding) root case
            includeForest.add(root); //Recursion only tries to add children
        }

        return includeForest;
    }

    private TreeNode deletePostOrder(TreeNode root, Set<Integer> toBeDeleted, List<TreeNode> includeForest) {

        if(root == null){
            return null;
        }

        root.left = deletePostOrder(root.left, toBeDeleted, includeForest);
        root.right = deletePostOrder(root.right, toBeDeleted, includeForest);

        if(toBeDeleted.contains(root.val)){
            if(root.left != null){ //Check line 50 comment. we are coming from bottom  if this NOT null means we can include
                includeForest.add(root.left);
            }
            if(root.right != null){ //Check line 50 comment. we are coming from bottom  if this NOT null means we can include
                includeForest.add(root.right);
            }

            return null; //This the trick . we will return null to parent if this node to be deleted
        }

        return root;
    }
}
