package org.atanu.java.ds.binarytree;

public class CountUnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode root){

        if(root == null){
            return true;
        }


        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if(left && right){

            if(root.left != null && root.val != root.left.val){
                return false;
            }

            if(root.right != null && root.val != root.right.val){
                return false;
            }
            count++;
            return true;
        }

        return false;
    }

    //Without Global Variable
    public int countUnivalSubtreesV2(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    private boolean dfs(TreeNode root, int[] count){

        if(root == null){
            return true;
        }


        boolean left = dfs(root.left, count);
        boolean right = dfs(root.right, count);

        if(left && right){

            if(root.left != null && root.val != root.left.val){
                return false;
            }

            if(root.right != null && root.val != root.right.val){
                return false;
            }
            count[0]++;
            return true;
        }

        return false;
    }
}
