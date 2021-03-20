package org.atanu.java.ds.array;

public class TwoDArray {

    public static void main(String[] args) {

        int intTwoD[][] = new int[4][3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                intTwoD[i][j] = i + j;
            }
        }

        //Printing in normal for loop
        System.out.println("Printing in normal for loop");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(intTwoD[i][j] + " ");
            }
            System.out.println();
        }

        //Printing in Enhanced for loop
        System.out.println("Printing in Enhanced for loop");
        for (int[] OnedArr : intTwoD) {
            for (int arrayVal : OnedArr) {
                System.out.print(arrayVal + " ");
            }
            System.out.println();
        }


    }
}
