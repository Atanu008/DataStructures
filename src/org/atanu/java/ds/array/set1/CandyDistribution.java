package org.atanu.java.ds.array.set1;

import java.util.Arrays;

//Leetcode 1103
//https://leetcode.com/problems/distribute-candies-to-people/
public class CandyDistribution {

public static int[] distributeCandies(int candies, int num_people) {
        
        int[] distribute = new int[num_people];
        int index = 0;
        int i = 1;
        
        while(candies > 0){
            distribute[index] += Math.min(candies, i);
            index = (index+ 1)%num_people;
            candies = candies - i;
            i++;
        }
        
        return distribute;
    }

	public static void main(String[] args) {
		
		int[] result = distributeCandies(7, 4);
		int[] result1 = distributeCandies(10, 3);
		
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result1));

	}

}
