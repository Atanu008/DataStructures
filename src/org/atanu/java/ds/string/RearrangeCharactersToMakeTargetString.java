package org.atanu.java.ds.string;

//https://leetcode.com/problems/rearrange-characters-to-make-target-string/description/
//Leetcode 2287

public class RearrangeCharactersToMakeTargetString {

    public int rearrangeCharacters(String s, String target) {
        int[] freqSource = new int[26];
        int[] freqTarget = new int[26];
        for(int ch : s.toCharArray()){
            freqSource[ch - 'a']++;
        }
        for(int ch : target.toCharArray()){
            freqTarget[ch - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for(int ch : target.toCharArray()){
            min = Math.min(min, freqSource[ch - 'a']/freqTarget[ch - 'a']);
        }
        return min;
    }

    public static void main(String[] args) {
        RearrangeCharactersToMakeTargetString makeTargetString = new RearrangeCharactersToMakeTargetString();
        String s = "ilovecodingonleetcode";
        String target = "code";
        int result = makeTargetString.rearrangeCharacters(s, target);
        //Output: 2
        //Explanation:
        //For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
        //For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
        //The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
        //We can make at most two copies of "code", so we return 2.
        System.out.println(result);

        s = "abbaccaddaeea";
        target = "aaaaa";
        result = makeTargetString.rearrangeCharacters(s, target);
        //Output: 1
        //Explanation:
        //We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
        //We can make at most one copy of "aaaaa", so we return 1.
        System.out.println(result);
    }
}
