package org.atanu.java.ds.array.set1;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = 0;
		int start = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			char rightchar = str.charAt(windowEnd);
			
			map.put(rightchar, map.getOrDefault(rightchar, 0) + 1);
			
			while(map.size() > k) {
				
				char leftChar = str.charAt(windowStart);
				
				map.put(leftChar, map.get(leftChar) - 1);
				
				if(map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				windowStart++;
				
			}
			
			
			//maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
			
			if(windowEnd - windowStart + 1 > maxLength) {
				maxLength = windowEnd - windowStart + 1;
				start = windowStart;
				end = windowEnd;
			}
		}
		
		System.out.print("Longest Substring with K Distinct "+ str.substring(start, end + 1) + "   ");
		
		return maxLength;
	}
	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));

	}

}
