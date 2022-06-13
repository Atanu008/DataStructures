package org.atanu.java.ds.string;

//https://leetcode.com/problems/shortest-word-distance/
//LeetCode 243
public class ShortestWordDistance {

    //Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
    //Output: 3
    //Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
    //Output: 1

    //Sol: Each time we find a new occurrence of one of the words,
    //we do not need to search the entire array for the other word,
    //since we already have the index of its most recent occurrence.
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int index1 = -1;
        int index2 = -1;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){

            if(wordsDict[i].equals(word1)){
                index1 = i;
            }
            else if(wordsDict[i].equals(word2)){
                index2 = i;
            }

            if(index1 != -1 && index2 != -1){
                result = Math.min(result, Math.abs(index2 - index1));
            }
        }

        return result;
    }
}
