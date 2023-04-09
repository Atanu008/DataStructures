package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
//Leetcode 958
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/solutions/205768/java-easy-level-order-traversal-one-while-loop/?orderBy=most_votes
public class CheckCompletenessOfABinaryTree {

    //When level-order traversal in a complete tree, after the last node, all nodes in the queue should be null.
    //Otherwise, the tree is not complete.
    public boolean isCompleteTree(TreeNode root) {

        boolean end = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();
            if(current == null){
                end = true; // Found the last Node
            }
            else{
                if(end){
                    return false; // We still have node after the last node , return false
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }
}
