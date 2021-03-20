package org.atanu.java.ds.binarysearchtree;

public class NoOfUniqueBinarySearchTree {

    public static int countNoOfUniqueBST(int n) {

        int[] T = new int[n + 1];

        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                T[i] += T[j] * T[i - j - 1];
            }
        }

        return T[n];

    }

    public static void main(String[] args) {

        int k = 4;
        int result = countNoOfUniqueBST(k);

        System.out.println("No of unique BST is possible with " + k + " nodes is " + result);


    }

}
