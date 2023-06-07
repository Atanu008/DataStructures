package org.atanu.java.ds.binarysearch;

public class CountNegativeNumbersInASortedMatrix {

    // Simple approach
    public int countNegatives(int[][] grid) {
        int count = 0;

        for(int[] nums : grid){

            int i = 0;
            while(i < nums.length && nums[i] >= 0){
                i++;
            }
            count += nums.length - i;
        }

        return count;
    }

    // Binary Search
    public int countNegatives_v2(int[][] grid) {

        int count = 0;
        int column = grid[0].length;

        for(int[] row : grid) {
            // Using binary search find the index
            // which has the first negative element.
            int low = 0;
            int high = column - 1;

            while(low <= high) {

                int mid = low + (high - low) / 2;
                if(row[mid] < 0){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            // 'low' points to the first negative element,
            // which means 'n - low' is the number of all negative elements.
            // In case all positive, low will point to row length
            count += column - low;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNegativeNumbersInASortedMatrix countNegativeNumbersInASortedMatrix = new CountNegativeNumbersInASortedMatrix();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        System.out.println(countNegativeNumbersInASortedMatrix.countNegatives(grid));
        System.out.println(countNegativeNumbersInASortedMatrix.countNegatives_v2(grid));

    }
}
