package org.atanu.java.ds.dp;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
//Leetcode 926

//Greedy Solution
//Video : https://www.youtube.com/watch?v=-vZ7LjWSWzY
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int flipCount = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                oneCount++;
            }
            else if(oneCount > 0){
                flipCount++;
                oneCount--;
            }
        }

        return flipCount;
    }

    //Its DP
    //Video : https://www.youtube.com/watch?v=tMq9z5k3umQ
    public int minFlipsMonoIncr_v2(String s) {
        int count_one = 0;
        int minFliCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count_one++;
            } else {
                minFliCount++;
                minFliCount = Math.min(minFliCount, count_one);
            }
        }
        return minFliCount;
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing flipStringToMonotoneIncreasing = new FlipStringToMonotoneIncreasing();
        String s = "00110";
        int minFlip = flipStringToMonotoneIncreasing.minFlipsMonoIncr_v2(s);
        //Output: 1
        //Explanation: We flip the last digit to get 00111.
        System.out.println(minFlip);

        s = "010110";
        minFlip = flipStringToMonotoneIncreasing.minFlipsMonoIncr_v2(s);
        //Output: 2
        //Explanation: We flip to get 011111, or alternatively 000111.
        System.out.println(minFlip);


    }
}
