package org.atanu.java.ds.tree;

//https://leetcode.com/problems/construct-quad-tree/description/
//Leetcode 427

// Video : https://www.youtube.com/watch?v=UQ-1sBMV0v4
public class ConstructQuadTree {

    public Node construct(int[][] grid) {

        return dfs(grid, 0, 0, grid.length);

    }

    private Node dfs(int[][] grid, int row, int col, int width){

        if(allSame(grid, row, col, width)){
            return new Node(grid[row][col] == 1 ? true : false, true);
        }

        int newWidth = width / 2;

        Node node = new Node(true, false);

        node.topLeft = dfs(grid, row, col, newWidth);
        node.topRight = dfs(grid, row, col + newWidth, newWidth);
        node.bottomLeft = dfs(grid, row + newWidth, col, newWidth);
        node.bottomRight = dfs(grid, row + newWidth, col + newWidth, newWidth);

        return node;
    }

    private boolean allSame(int[][] grid, int row, int col, int width){

        for(int i = row; i < row + width; i++){
            for(int j = col; j < col + width; j++){
                if(grid[i][j] != grid[row][col]){
                    return false;
                }
            }
        }
        return true;
    }



    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
