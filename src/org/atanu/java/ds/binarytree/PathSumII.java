package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
//LeetCode 113
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result){

        if(root == null){
            return;
        }

        path.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            result.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum, path, result);
        dfs(root.right, targetSum, path, result);

        //We need to pop the node once we are done processing ALL of it's subtrees.
        //backtrack
        path.remove(path.size()-1);

    }
}
