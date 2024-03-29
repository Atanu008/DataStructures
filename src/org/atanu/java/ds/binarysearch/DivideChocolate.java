package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/divide-chocolate/
//LeetCode 1231

//You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
//
//You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces using k cuts, each piece consists of some consecutive chunks.
//
//Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
//
//Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

//Same as Book Allocation Types. Here its to maximize i.e Go Right
public class DivideChocolate {

    public int maximizeSweetness(int[] sweetness, int k) {

        //int left = Arrays.stream(sweetness).min().getAsInt();
        //int right = Arrays.stream(sweetness).sum() / numberOfPeople;

        int totalNumberOfFrinds = k +1;//(k friends + 1 (self))
        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int sweet : sweetness) {
            low = Math.min(low, sweet);
            high +=  sweet;
        }

        // Check for maximum sweetness for which we can distribute to K
        // Maximize the sweetness
        // So We need to go right . and Low will play the role
        // Going right; mid = low + (high - low)/2 +1 . (Plus 1 to avoid Integer Division issue)
        while(low < high){

            int mid = low + (high - low)/2 +1;

            if(canDivide(sweetness, totalNumberOfFrinds, mid)){
                low = mid;
            }
            else{
                high = mid -1;
            }
        }

        return low;

    }

    private boolean canDivide(int[] sweetness, int totalNumberOfFrinds, int targetSweetness){

        int chunk = 0;
        int curSweetness = 0;
        for(int sweet: sweetness){

            curSweetness += sweet;
            // Cut a chunk when sweetness greater than equal to Target
            // Current sweetness can never be less than targetSweetness
            // as we are targeting chunk sweetness >= targetSweetness
            // as we can not divide one sweetness(sweetness[i]),
            // we need to take the whole sweetness
            if(curSweetness >= targetSweetness){
                chunk++;
                curSweetness = 0;
            }
        }

        //Return True if we can distribute i.e chunk greater than totalNumberOfFrinds
        return chunk >= totalNumberOfFrinds;
    }

    public static void main(String[] args) {
        DivideChocolate divideChocolate = new DivideChocolate();
        int[] sweetness = {1,2,3,4,5,6,7,8,9};
        int k = 5;
        //Output: 6
        //Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
        System.out.println("Maximum total sweetness of the piece you can get by cutting the " +
                "chocolate bar optimally is "+ divideChocolate.maximizeSweetness(sweetness,k));

        sweetness = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
        k = 8;
        //Output: 1
        //Explanation: There is only one way to cut the bar into 9 pieces.
        System.out.println("Maximum total sweetness of the piece you can get by cutting the " +
                "chocolate bar optimally is "+ divideChocolate.maximizeSweetness(sweetness,k));

        sweetness = new int[]{1,2,2,1,2,2,1,2,2};
        k = 2;
        //Output: 5
        //Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
        System.out.println("Maximum total sweetness of the piece you can get by cutting the " +
                "chocolate bar optimally is "+ divideChocolate.maximizeSweetness(sweetness,k));

    }
}
