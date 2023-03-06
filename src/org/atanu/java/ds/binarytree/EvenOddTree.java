package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/even-odd-tree/description/
//Leetcode 1609
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;
        while(!queue.isEmpty()){

            int size = queue.size();
            //based on level even or odd .
            //In case of even it will be increasing so the initial/value should start from Integer.MIN_VALUE
            // For Odd is its decreasing the prev value should star from Integer.MAX_VALUE
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size --> 0){
                TreeNode currentNode = queue.poll();
                int current = currentNode.val;
                // invalid case on even level
                if(evenLevel && (current % 2 == 0 || current <= prev)){
                    return false;
                }else if(!evenLevel && (current % 2 != 0 || current >= prev)){// invalid case on odd level
                    return false;
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }

                prev = current; //Update Prev
            }

            evenLevel = !evenLevel; //Flip Level
        }

        return true;
    }
}
