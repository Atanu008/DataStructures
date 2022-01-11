package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//LeetCode 863
public class AllNodesDistanceKInBinaryTree {
    //We first do a depth first search where we annotate every node with information about it's parent.
    //After, we do a breadth first search to find all nodes a distance K from the target.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty()){

            if(distance == k){
                queue.forEach(a -> result.add(a.val));
                return result;
            }
            int size = queue.size();
            while(size -->0){

                TreeNode current = queue.poll();
                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }

            distance++;
        }

        return result;
    }

    private void buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }

        parentMap.put(root, parent);
        buildParentMap(root.left, root, parentMap);
        buildParentMap(root.right, root, parentMap);

    }
}
