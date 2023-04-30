package org.atanu.java.ds.graph;

// https://leetcode.com/problems/validate-binary-tree-nodes/description/
// Leetcode 1361

public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        UnionFind unionFind = new UnionFind(n);

        for(int i = 0; i < n; i++){

            int root = unionFind.find(i); // root of current Node
            if(leftChild[i] != -1){
                int rootOfLeftChildNode = unionFind.find(leftChild[i]);
                // if root anf child belongs to same component
                // that means there is already a edge betwwen them by parrallel path or some other path
                // in that case return false;
                if(root == rootOfLeftChildNode) {
                    return false;
                }

                // else unite them in one component
                unionFind.union(i, leftChild[i]);
            }

            if(rightChild[i] != -1){
                int rootOfRightChildNode = unionFind.find(rightChild[i]);
                // if root anf child belongs to same component
                // that means there is already a edge betwwen them by parrallel path or some other path
                // in that case return false;
                if(root == rootOfRightChildNode) {
                    return false;
                }

                // else unite them in one component
                unionFind.union(i, rightChild[i]);
            }
        }
        // At the end there has to be only one componenet
        return unionFind.getNumberOfComponent() == 1;
    }

    public static class UnionFind {

        int[] root;
        int[] size;

        public UnionFind(int n){
            root = new int[n];

            for(int i = 0; i < n; i++){
                root[i] = i;
            }
        }

        public int find(int x){

            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        // This the main trick of the problem
        // just record root the child node to be parent
        // This way we woild be able to record the direction and no biderectional edges would be connected
        // If we do union by rank or size the parent information would be lost
        // just keep the parent record
        public void union(int parent, int child) {
            root[child] = parent;
        }

        public int getNumberOfComponent() {
            //System.out.println(Arrays.toString(root));
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if (root[i] == i) { //If the same element is root i.e it belengs to its same set , if its diffeent that means this element have differner root
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes validateBinaryTreeNodes = new ValidateBinaryTreeNodes();
        int n = 4;
        int[] leftChild = {1,-1,3,-1}, rightChild = {2,-1,-1,-1};
        boolean isValid = validateBinaryTreeNodes.validateBinaryTreeNodes(n, leftChild, rightChild);
        System.out.println(isValid);

        n = 4;
        leftChild = new int[]{1,-1,3,-1};
        rightChild = new int[]{2,3,-1,-1};
        isValid = validateBinaryTreeNodes.validateBinaryTreeNodes(n, leftChild, rightChild);
        System.out.println(isValid);
    }
}
