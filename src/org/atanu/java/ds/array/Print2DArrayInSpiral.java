package org.atanu.java.ds.array;

public class Print2DArrayInSpiral {

    public static void print2DInSpiral(int[][] arr) {

        int top = 0;
        int bottom = arr.length - 1;// No Of Rows. M
        int left = 0;
        int right = arr[0].length - 1; // No of Column . N

        int dir = 0;
        while (top <= bottom) {

            // Left To Right Print Top Row
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(arr[top][i] + " ");
                }
                top++;
            }
            // Top to Bottom Print right column
            else if (dir == 1) {

                for (int i = top; i <= bottom; i++) {
                    System.out.print(arr[i][right] + " ");
                }
                right--;
            }

            // Right To Left Print Bottom Row
            else if (dir == 2) {

                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            // Bottom to Top Print left column
            else if (dir == 3) {

                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

            System.out.println();//

            dir = (dir + 1) % 4; // To set the direction
        }

    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};

        print2DInSpiral(a);


    }

}
