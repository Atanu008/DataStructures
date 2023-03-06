package org.atanu.java.ds.string;

//https://leetcode.com/problems/camelcase-matching/description/
//Leetcode 1023

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    //For each string, macth it with the pattern and pass the result.

//The match process uses i for query pointer and j for pattern pointer, each iteration;

// 1. If current char query[i] matches pattern[j], increase both pointers;
// 2. if does not match and query[i] is lowercase,
//    keep going, we are good to increase query pointer as it would not break the pattern;
//.   For Example : FooBarTest and FB - in between o's and a,r is oaky
// 3. if does not match and query[i] is captalized, This would break teh camel case format as we have Capital in query String but not in Pattern. we should return false.
// If this pattern matches, j should equal length of pattern at the end as we need to be sure all the character from pattern is checked

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result = new ArrayList<>();
        char[] patternArray = pattern.toCharArray();

        for(String query : queries){
            if(isMatchingCamelCase(query.toCharArray(), patternArray)){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }

    private boolean isMatchingCamelCase(char[] query, char[] pattern){

        int i = 0; //Query String pointer
        int j = 0; //Pattern Pointer
        //Check while we have character in query
        while(i < query.length){
            //char query[i] matches pattern[j], increase both pointers
            if(j < pattern.length && query[i] == pattern[j]){
                i++;
                j++;
            }else if(query[i] >= 'A' && query[i] <= 'Z'){ //Problem query is Capital but patter is not
                return false;
            }else{ //query[i] is lowercase
                i++;
            }
        }
        return j == pattern.length; // If this pattern matches, j should equal length of pattern at the end as we need to be sure all the character from pattern is checked
    }

    public static void main(String[] args) {
        CamelcaseMatching camelcaseMatching = new CamelcaseMatching();
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> result = camelcaseMatching.camelMatch(queries, pattern);
        //Output: [true,false,true,true,false]
        //Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
        //"FootBall" can be generated like this "F" + "oot" + "B" + "all".
        //"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
        System.out.println(result);

        queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        pattern = "FoBa";
        result = camelcaseMatching.camelMatch(queries, pattern);
        //Output: [true,false,true,false,false]
        //Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
        //"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
        System.out.println(result);
    }
}
