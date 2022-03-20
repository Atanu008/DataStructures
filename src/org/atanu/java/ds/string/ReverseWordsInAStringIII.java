package org.atanu.java.ds.string;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
//LeetCode 557
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        int start = 0;
        int end = 0;
        while(start < ca.length) {
            end = start;
            while (end < ca.length && ca[end] != ' ') {
                end++;
            }
            //Now end either points to Blank Or End of array
            //So the end of the word would be pointed by (end -1)
            //Reverse strat , end - 1;
            reverse(ca, start, end-1);
            start = end+1;  // Move Start to the next word
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverseWords = new ReverseWordsInAStringIII();
        String s = "Let's take LeetCode contest";
        String result = reverseWords.reverseWords(s);
        System.out.println(result);
    }
}
