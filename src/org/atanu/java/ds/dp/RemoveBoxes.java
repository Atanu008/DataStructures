package org.atanu.java.ds.dp;

public class RemoveBoxes {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        Integer[][][] dp = new Integer[n][n][n];
        return dp(boxes, 0, boxes.length - 1, 0, dp);
    }

    private int dp(int[] boxes, int left, int right, int count, Integer[][][] dp){

        if(left > right){
            return 0;
        }

        if(dp[left][right][count] != null){
            return dp[left][right][count];
        }
        //Record the variables to store in dp state as they would change
        int l = left;
        int r = right;
        int k = count;
        // if adjacent elements are same, then we count the occurence and increment index also
        while(left + 1 <= right && boxes[left] == boxes[left+1]){
            count++;
            left++;
        }
        // till this point, we get total ans as count+1^2 and also,
        // we need to consider the rest of the array through recursion from next index i.e. l+1
        int ans = (count + 1) * (count + 1) + dp(boxes, left + 1, right, 0, dp);

        // also another way we can choose is to choose the inner elements first then the outer
        // similar elements can be combined to get even
        // larger value
        for(int middle = left + 1; middle <= right; middle++){
            // we traverse from m (l has moved from 0 to just before the beginning of different elements) and
            // keep searching for same value as in l.
            //after that the middle elements (between l+1 and m-1) are sent to differnt partition and
            // from m to r(ending) we send the updated streak
            if(boxes[middle] == boxes[left]){
                ans = Math.max(ans, dp(boxes, middle, right, count + 1, dp) + dp(boxes, left + 1, middle -1, 0, dp));
            }
        }
        // finally assign and return
        return dp[l][r][k] = ans;
    }
}
