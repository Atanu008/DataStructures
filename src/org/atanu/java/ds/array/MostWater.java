package org.atanu.java.ds.array;

public class MostWater {

    public static int mostWater(int[] height) {

        int low = 0;
        int high = height.length - 1;

        int maxArea = 0;

        while (low < high) {

            int currentHeight = Math.min(height[low], height[high]);
            int width = high - low;

            // Calculate MaxArea
            maxArea = Math.max(maxArea, currentHeight * width);

            //Icrement the lower index if there is a higher Bar at the RIGHT
            if (height[low] < height[high]) {
                low++;
            }

            //Decrement the lower index if there is a higher Bar at the LEFT
            else {
                high--;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 5, 4, 3};

        System.out.println("Most Water contns area " + mostWater(heights));

    }

}
