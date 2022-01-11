package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-subtrees/
//Leetcode 652
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();

        preOrder(root, map, result);
        return result;

    }

    private String preOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> result){

        if(root == null){
            return "X";
        }

        String left = preOrder(root.left, map, result);
        String right = preOrder(root.right, map, result);
        String key = root.val + ","+  left + ","+ right;

        map.put(key, map.getOrDefault(key,0) +1);

        if(map.get(key) == 2){
            result.add(root);
        }

        return key;
    }
}
