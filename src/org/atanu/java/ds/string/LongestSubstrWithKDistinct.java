package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstrWithKDistinct {

    // Function to find longest substring of given string containing
    // k distinct characters using sliding window
    public static String longestSubstrWithKDistinct(String str, int k) {

        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();

        //store frequency of characters present in
        Map<Character, Integer> map = new HashMap<>();

        // stores longest substring boundaries
        int end = 0;
        int begin = 0;

        // [low..high] maintain sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++) {

            window.add(str.charAt(high));
            map.put(str.charAt(high), map.getOrDefault(str.charAt(high), 0) + 1);

            // if window size is more than k, remove characters from the left
            while (window.size() > k) {

                // if the frequency of leftmost character becomes 0 after
                // removing it in the window, remove it from set as well
                if (map.containsKey(str.charAt(low))) {
                    map.put(str.charAt(low), map.get(str.charAt(low)) - 1);

                    if (map.get(str.charAt(low)) == 0) {
                        window.remove(str.charAt(low));
                    }
                }

                low++;
            }

            // update maximum window size if necessary
            if (end - begin < high - low) {
                end = high;
                begin = low;
            }
        }

        // return longest substring found at str[begin..end]
        return str.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        String str = "abcbdbdbbdcdabd";
        int k = 3;

        System.out.print(longestSubstrWithKDistinct(str, k));

    }

}
