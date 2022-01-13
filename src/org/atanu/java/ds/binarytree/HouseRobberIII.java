package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber-iii/
//LeetCode 337
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return root.val;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }

        int left = 0;
        if(root.left != null){
            left = rob(root.left.left, map) + rob(root.left.right, map);
        }

        int right = 0;
        if(root.right != null){
            right = rob(root.right.left, map) + rob(root.right.right, map);
        }

        int robbed = Math.max(root.val + left + right, rob(root.left, map) + rob(root.right, map));

        map.put(root, robbed);

        return robbed;

    }
}
