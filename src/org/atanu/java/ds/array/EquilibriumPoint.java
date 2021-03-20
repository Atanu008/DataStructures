package org.atanu.java.ds.array;

public class EquilibriumPoint {

    public static int findEquilibriumPointSol1(int[] arr) {
		
        /* Check for indexes one by one until  
           an equilibrium index is found */
        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            /* get left sum */
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            /* get right sum */
            for (int k = i + 1; k < arr.length; k++) {

                rightSum += arr[k];
            }
			
			 /* if leftsum and rightsum are same,  
            then we are done */
            if (leftSum == rightSum)
                return i;
        }

        /* return -1 if no equilibrium index is found */
        return -1;
    }

    public static int findEquilibriumPointSol2(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {

            // sum is now right sum for index i
            sum = sum - arr[i];

            if (sum == leftSum) {
                return i;
            }

            // LeftSum for index i
            leftSum += arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        return -1;

    }

    public static void main(String[] args) {

        int arr[] = {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(findEquilibriumPointSol1(arr));

        System.out.println(findEquilibriumPointSol2(arr));
    }

}
