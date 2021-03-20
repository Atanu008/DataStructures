package org.atanu.java.ds.array.rotation;

/**
 * @author atanu
 * https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 */
public class Problem_7 {
    /*
     * https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
     *
     * Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want. Return the maximum possbile of summation of i*arr[i].
     *
     *
     */

    public static void main(String[] args) {


        int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //calculateSumMethod_1(arr);
        calculateSumMethod_2(arr);

    }

    public static void calculateSumMethod_1(int arr[]) {
        int maxVal = 0, currentVal;
        for (int j = 0; j < arr.length; j++) {
            leftRotate(arr, j);
            currentVal = calculateSum(arr);
            if (currentVal > maxVal)
                maxVal = currentVal;
        }
        System.out.println("Maximum Sum   " + maxVal);
    }

    public static int calculateSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + i * arr[i];
            System.out.println(sum);
        }
        return sum;
    }

    public static void leftRotate(int[] arr, int d) {
        int gcd = getGCD(arr.length, d);
        for (int i = 0; i < gcd; i++) {
            int k, j = i;
            int temp = arr[i];
            while (true) {
                k = (j + d) % arr.length;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;

            }
            arr[j] = temp;
        }
    }

    public static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return getGCD(b, a % b);
    }

    public static void calculateSumMethod_2(int arr[]) {
		/*1) Compute sum of all array elements. Let this sum be 'arrSum'.

		  2) Compute R0 by doing i*arr[i] for given array. 
             Let this value be currVal.

          3) Initialize result: maxVal = currVal // maxVal is result.

             // This loop computes Rj from  Rj-1 
          4) Do following for j = 1 to n-1
             a) currVal = currVal + arrSum-n*arr[n-j];
             b) If (currVal > maxVal)
                maxVal = currVal   

          5) Return maxVal
		 * 
		 * 
		 * 
		 */

        int arrSum = 0;
        int currVal = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum = arrSum + arr[i];
            currVal = currVal + (i * arr[i]);
        }
        System.out.println(arrSum);
        System.out.println(currVal);
        int maxVal = currVal;

        for (int j = 1; j < arr.length; j++) {
            currVal = currVal + arrSum - arr.length * arr[arr.length - j];
            if (currVal > maxVal)
                maxVal = currVal;

        }
        System.out.println("Maximum Sum   " + maxVal);
    }


}
