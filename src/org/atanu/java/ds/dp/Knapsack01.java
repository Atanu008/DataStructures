package org.atanu.java.ds.dp;

public class Knapsack01 {

    //Naive Recursion
    public int findKnapsack(int[] weights, int[] value, int capacity, int n){
        // Base case
        // 0 items left or knapsack is full
        if(n == 0 || capacity == 0){
            return 0;
        }

        // check if the weight of the nth item is less than capacity then
        // either
        // We include the item and reduce the weigth of item from the total weight
        // or
        // We don't include the item
        if(weights[n-1] <= capacity){
            int include = value[n-1] + findKnapsack(weights, value, capacity - weights[n-1], n-1);
            int exclude = findKnapsack(weights, value, capacity, n-1);
            return Math.max(include, exclude);
        }
        // Item can't be added in our knapsack
        // if it's weight is greater than the capacity
        return findKnapsack(weights, value, capacity, n-1);
    }

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int[] weights = {3, 6, 10, 7, 2};
        int[] values = {12, 10, 15, 17, 13};
        int maxEarn = knapsack01.findKnapsack(weights, values, 10, 5);
        System.out.println(maxEarn); //Taking 7+2 weight
    }
}
