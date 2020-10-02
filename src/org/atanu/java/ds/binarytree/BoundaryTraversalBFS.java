package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversalBFS {
    
    static List<Integer> leftNodes = new ArrayList<>();
    static List<Integer> rightNodes = new ArrayList<>();
    static List<Integer> leafNodes = new ArrayList<>();

    public void leftRightNodes(TreeNode root){

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                if(i == 0){

                }
            }
        }
    }
}


