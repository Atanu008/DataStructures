package org.atanu.java.ds.string;

import java.util.Arrays;

//https://leetcode.com/problems/di-string-match/description/
//LeetCode 942
public class DIStringMatch {
    //problem wordings are horrible
    public int[] diStringMatch(String s) {

        int low = 0;
        int high = s.length();
        int n = s.length();
        int[] result = new int[n + 1];
        //if 'I' the increment low as result[i] < result[i+1]
        //if 'I' the decrement high as result[i] > result[i+1]
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'I'){
                result[i] = low++;
            }else if(s.charAt(i) == 'D'){
                result[i] = high--;
            }
        }

        result[n] = low; //result[n] = high; is also same

        return result;
    }

    public static void main(String[] args) {
        DIStringMatch diStringMatch = new DIStringMatch();
        String s = "IDID";
        int[] result = diStringMatch.diStringMatch(s);
        System.out.println(Arrays.toString(result));
        s = "III";
        result = diStringMatch.diStringMatch(s);
        System.out.println(Arrays.toString(result));
        s = "DDI";
        result = diStringMatch.diStringMatch(s);
        System.out.println(Arrays.toString(result));
    }
}
