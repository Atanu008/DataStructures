package org.atanu.java.ds.array;

public class ThreeDArray {

    public static void main(String[] args) {

        int[][][] threeDAarry = new int[3][4][5];
        int val = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    threeDAarry[i][j][k] = val;
                    val++;
                }
            }
        }

        System.out.println("\n Normal For loop");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print("arr[" + i + "][" + j + "][" + k + "] = " + threeDAarry[i][j][k] + "\t");
                }
            }
        }

        System.out.println("\nEnhanced For loop");
        for (int[][] twoDArray : threeDAarry) {
            for (int[] oneDArray : twoDArray) {
                for (int value : oneDArray) {
                    System.out.print(value + " ");
                }
            }
        }

    }

}
