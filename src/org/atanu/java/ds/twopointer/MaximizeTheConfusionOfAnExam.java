package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
//LeetCode 2024
//Same as https://leetcode.com/problems/max-consecutive-ones-iii/
//Need with K T and then K F . and return the maximum
public class MaximizeTheConfusionOfAnExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxConsecutiveWithkF = longestConsecutiveAnswers(answerKey, 'F', k);
        int maxConsecutiveWithkT = longestConsecutiveAnswers(answerKey, 'T', k);
        return Math.max(maxConsecutiveWithkF, maxConsecutiveWithkT);
    }

    public int longestConsecutiveAnswers(String answerKey, char answer, int k) {

        int longestOnes = 0;
        int zeros = 0;
        int windowEnd = 0;
        int windowStart = 0;

        // while our window is in bounds
        while(windowEnd < answerKey.length()){

            // add the right most element into our window
            if(answerKey.charAt(windowEnd) == answer){
                zeros++;
            }

            // if our window is invalid, contract our window
            while(zeros > k){
                if(answerKey.charAt(windowStart) == answer){
                    zeros--;
                }
                windowStart++;
            }

            // update our longest sequence answer
            longestOnes = Math.max(longestOnes, windowEnd - windowStart +1);
            // expand our window
            windowEnd++;
        }

        return longestOnes;
    }

    public static void main(String[] args) {
        MaximizeTheConfusionOfAnExam maximizeTheConfusionOfAnExam = new MaximizeTheConfusionOfAnExam();
        String answerKey = "TTFF";
        int k = 2;
        //Output: 4
        //Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
        //There are four consecutive 'T's.
        System.out.println(maximizeTheConfusionOfAnExam.maxConsecutiveAnswers(answerKey, k));
    }
}
