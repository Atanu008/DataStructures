package org.atanu.java.ds.array;

public class RemoveElement {

    public static int removeElementSol1(int[] arr, int key) {

        //we will store other elements in the ith Index
        int i = 0;

        for (int j = 0; j < arr.length; j++) {

            //forward if the element is not equal to Key
            if (arr[j] != key) {
                arr[i++] = arr[j];
            }
        }

        return i;
    }

    public static int removeElementSol2(int[] arr, int key) {

        int i = 0;
        int n = arr.length;

        while (i < n) {

            if (arr[i] == key) {
                // MOve the Nth elemnt to Ith element if the key matches
                arr[i] = arr[n - 1];
                n--;
            }
            //Otherwise forward i
            else {

                i++;
            }

        }

        return i;
    }

    public static void main(String[] args) {


        int[] arr = {1, 2, 5, 3, 4, 7, 3, 2, 1, 5, 6, 1};

        //System.out.println(removeElementSol1(arr,2));

        System.out.println(removeElementSol2(arr, 2));
    }

}
