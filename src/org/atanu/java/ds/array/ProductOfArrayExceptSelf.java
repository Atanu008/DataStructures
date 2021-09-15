package org.atanu.java.ds.array;

import java.util.Arrays;

//
public class ProductOfArrayExceptSelf {

    //product of array except nums[i] = product of numbers to the left of nums[i] * product of numbers to the right of nums[i]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] productExceptSelf = new int[n];

        leftProduct[0] = 1;// As No numbers to its left.
        rightProduct[n-1] = 1;// As No numbers to its Right.

        for(int i =1; i<n;i++){
            //leftProduct[i-1] will give the previuos multiplication
            //nums[i-1] will give previous element
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }
        for(int i =n-2; i>=0;i--){
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }

        for(int i = 0; i<n; i++){
            productExceptSelf[i] = leftProduct[i]*rightProduct[i];
        }

        return productExceptSelf;
    }

    //Optimized O(n) , No Extra space . not considering the output
    public int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int[] productExceptSelf = new int[n];

        productExceptSelf[0] = 1;// As No numbers to its left.
        for(int i = 1; i<n; i++){
            productExceptSelf[i] = productExceptSelf[i-1]*nums[i-1];
        }

        int right = 1;//This will carryout the right multiplication part
        for(int i = n-1; i >=0; i--){
            productExceptSelf[i] = productExceptSelf[i]*right;
            right = right*nums[i]; //Keeping the right product
        }
        return productExceptSelf;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(output));
        output = new ProductOfArrayExceptSelf().productExceptSelfV2(nums);
        System.out.println(Arrays.toString(output));
    }
}
