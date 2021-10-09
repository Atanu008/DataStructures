package org.atanu.java.ds.array;

//https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
//Leetcode 1567
public class MaximumLengthSubarrayWithPositiveProduct {
    /*
  First, starting to think about how can we have a subarray with a positive product. In order to have a positive product of an array, we have three scenarios.
scenario 1: All numbers in the array are positive. Ex: [1,2,3,4,5], product = 120
scenario 2: Have only an even number of negative integers in the array. Ex: [1,-2,-3,-4,-5], product = 120
scenario 3: No zeros appears in the array.

Those three scenarios above can guarantee the production of the array is positive. In case we have an odd number of integers in the sub-array, then we need to make the number of negative integers to be even. We can either add a negative integer into the sub-array or exclude a negative integer out of the sub-array. Since we cannot change the array, we exclude a negative integer out of the sub-array to make the total number of negative integers in the sub-array to be even.

Based on the condition above, we are applying the sliding window technique to find the maximum length of the sub-array with a positive product. Using i - left for the sub-array length calculation (Note: start at index -1). First, we need to count the number of negative integers, it will help us to decide this sub-array is qualified or not. So,

sub-array [ All positive integers ] -> Qualified
sub-array [ Even number of negative integers ] -> Qualified
sub-array [ Odd number of negative integers ] -> Not Qualified ===> sub-array [ Odd number of negative integers - 1 = Even ] -> Qualified
sub-array [ Has zeros ] -> Not Qualified
when even number of negative or all positive integers length = i - zeroPosition.
when odd number of negative integers or contains zeros length = i - firstNegative.
Keep looping the array until the end, we got the answer.*/
    public int getMaxLen(int[] nums) {
        int negativeCount = 0, firstNegativeIndex = -1, zeroIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                negativeCount++;
                // we only need to know index of first negative number
                if (firstNegativeIndex == -1) {
                    firstNegativeIndex = i;
                }
            }
            //if current number is 0, we can't use any element from index 0 to i anymore,
            //so update zeroPosition, and reset sum and firstNegative.
            //If it is a game, we should refresh the game when we meet 0.
            if (nums[i] == 0) {
                zeroIndex = i;
                negativeCount = 0;
                firstNegativeIndex = -1;
            } else {
                // When EVEN number of Negative ,consider index of zero
                if (negativeCount % 2 == 0) {
                    maxLength = Math.max(maxLength, i - zeroIndex);
                }
                // When ODD number of Negative ,consider index of first negative number
                else {
                    maxLength = Math.max(maxLength, i - firstNegativeIndex);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,-2,-3,-4};
        MaximumLengthSubarrayWithPositiveProduct product = new MaximumLengthSubarrayWithPositiveProduct();
        System.out.println("Maximum Length of Subarray With Positive Product "+ product.getMaxLen(nums));
    }
}
