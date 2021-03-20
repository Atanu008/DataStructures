package org.atanu.java.ds.array;

public class OneDArray {

    public static void main(String[] args) {

        int[] intArray = new int[5];
        double doubleArray[] = new double[3];
        int[] intArrayInitialized = {1, 2, 3, 4};
        int cloneArray[] = intArray.clone();

        intArray[0] = 2;
        intArray[1] = 4;
        intArray[2] = 6;
        intArray[3] = 8;

        //printing Array
        System.out.println("Printing intArray");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "  ");
        }

        // Initializing array using for loop
        for (int j = 0; j < doubleArray.length; j++) {
            doubleArray[j] = j * 2.7;
        }

        //printing Array
        System.out.println("\nPrinting doubleArray using enhanced for each loop");
        for (double d : doubleArray) {
            System.out.print(d + "  ");
        }


    }

}
