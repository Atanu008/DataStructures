package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-frequent-subtree-sum/
//LeetCode 508

//Use a hashMap count to count the subtree sum occurrence.
//A sub function dfs(TreeNode node) will
//travel through a tree, recursively calculate the sum of subtree,
//increment the count, and finally return the sum of the sub tree.
public class MostFrequentSubtreeSum {

    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i->i).toArray();

    }

    private int dfs(TreeNode root, Map<Integer, Integer> map){

        if(root == null){
            return 0;
        }

        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum,0) +1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
