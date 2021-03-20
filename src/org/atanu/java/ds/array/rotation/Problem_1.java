package org.atanu.java.ds.array.rotation;

/*
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * 1. https://www.geeksforgeeks.org/array-rotation/
 *
 */
public class Problem_1 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Original Array");
        printArray(arr);

        leftRotateMethod_1(arr, 3);
        System.out.println("\nPrinting Array Method 1");
        printArray(arr);

        leftRotateMethod_2(arr, 3);
        System.out.println("\nPrinting Array Method 2");
        printArray(arr);


        leftRotateMethod_3(arr, 1);
        System.out.println("\nPrinting Array Method 3 : Back to the Original Array");
        printArray(arr);


    }

    public static void leftRotateMethod_1(int[] arr, int shiftingElements) {
	 /*Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
				1) Store d elements in a temp array
				   temp[] = [1, 2]
				2) Shift rest of the arr[]
				   arr[] = [3, 4, 5, 6, 7, 6, 7]
				3) Store back the d elements
				   arr[] = [3, 4, 5, 6, 7, 1, 2] 
				   
				   Time complexity : O(n)
                   Auxiliary Space : O(d)
				   
      *
	  *
	  *
	  */

        int[] temp = new int[shiftingElements];
        for (int i = 0; i < shiftingElements; i++) {
            temp[i] = arr[i];
        }
        for (int j = 0; j < arr.length - shiftingElements; j++) {
            arr[j] = arr[j + shiftingElements];
        }

        int temp_count = 0;
        for (int k = shiftingElements; k > 0; k--) {
            arr[arr.length - k] = temp[temp_count];
            temp_count++;
        }

    }


    public static void leftRotateMethod_2(int[] arr, int shiftingElements) {
		/*
		 * start
           For i = 0 to i < d
           Left rotate all elements of arr[] by one end.
		 * 
		 * 
		 * Time complexity : O(n * d)
         *  Auxiliary Space : O(1)
		 * 
		 */
        for (int i = 0; i < shiftingElements; i++) {
            leftRotateByOne(arr);
        }
    }

    public static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int j = 0;
        for (; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[j] = temp;
    }

    public static void leftRotateMethod_3(int[] arr, int shiftingElements) {
		/*
		 * A Juggling Algorithm
		 * Ref : https://codewhoop.com/tutorial/array-rotation-in-place
		 * Time complexity : O(n)
           Auxiliary Space : O(1)
		 */
        int gcd = getGCD(arr.length, shiftingElements);

        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int d;
            int j = i;
            while (true) {
                d = (j + shiftingElements) % arr.length;
                if (d == i)
                    break;
                arr[j] = arr[d];
                j = d;
            }
            arr[j] = temp;
        }
    }

    public static int getGCD(int a, int b) {

        if (b == 0)
            return a;
        else return getGCD(b, a % b);

    }

    public static void printArray(int arr[]) {
        for (int d : arr) {
            System.out.print(d + "  ");
        }
    }

}
