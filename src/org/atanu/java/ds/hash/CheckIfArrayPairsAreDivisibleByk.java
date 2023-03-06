package org.atanu.java.ds.hash;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
//Leetcode 1497

/*Approach:
2 nums are divisible by k if both of their remainders(when divided by k) add up to k.

Example: 10, 22 are nums and k = 8. Now, 10 % 8 = 2 and 22 % 8 = 6.
10 + 22 = 32 which is divisible by 8. It happened only because 2 + 6 was equal to 8.

Check with any two nums and k. It will hold true.
3 cases of remainders:
1. remainder is 0. (divisible already)
2. remainder is k/2 (in case of even k)
3. remainder lies in (0, k). (excluding above 2 options).

From above information, a pair can be created if we can find 2 remainders x and y, for which
x + y = k OR x = y = 0 OR x = y = k/2;

Steps:
1. We will create a HashMap with remainder as key and count of numbers with that remainder as value.
2. Traverse the hashmap, for every rem (x) if rem (k-x) exists in hashmap and their values are same, then
we have a pair, if not return false.

Special Cases:
if rem is 0 or k/2 then pair has to be made with the same rem only. Therefore, count of nums with that rem should be even else return false.
*/

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByk {
    public boolean canArrange(int[] arr, int k) {

        Map<Integer, Integer> remFreq = new HashMap<>();
        for(int a : arr){
            int rem = a % k;
            // Handle negative remainders, suppose if k = 7, and num1 = 10, num2 = -10.
            // Now, 10 and -10 sum up to 0 which is divisible by 7.
            // 10 % 7 == 3, and -10 % 7 = -3, Since we cant store -3(in array), we can add k to it.
            // Therefore, -3 + 7 = 4. We will increment count in 4 for num2.
            if(rem < 0){
                rem += k;
            }
            remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
        }

        for(int reminder : remFreq.keySet()){
            if(reminder == 0){ // eg k = 5 nums = [5, 10, 15, 20] then (5, 10) (15,20) can pair up with each other
                if(remFreq.get(reminder) % 2 != 0) return false; // when freq is odd, 1 element is unpaired  eg (10, 20) (30)
            }
            else if(reminder * 2 == k){// eg k = 10 nums = [15, 25,35,45] then (15, 25) (35,45) can pair up with each other
                if(remFreq.get(reminder) % 2 != 0) return false;// when freq is odd, 1 element is unpaired eg (15, 25) (35)
            }
            else{
                int count1 = remFreq.get(reminder); //num whose remainder = r can pair up with num whose remainder = k-r
                int count2 = remFreq.getOrDefault(k-reminder, 0); // count must be equal so that they can pair up with each other
                if(count1!=count2) return false;
            }
        }
        return true;
    }

    public boolean canArrange_v2(int[] arr, int k) {

        Map<Integer, Integer> remFreq = new HashMap<>();
        for(int a : arr){
            int rem = a % k;
            if(rem < 0){
                rem += k;
            }
            remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
        }

        for(int reminder : remFreq.keySet()){
            if(reminder == 0){ // eg k = 5 nums = [5, 10, 15, 20] then (5, 10) (15,20) can pair up with each other
                if(remFreq.get(reminder) % 2 != 0) return false; // when freq is odd, 1 element is unpaired  eg (10, 20) (30)
            }
            //Below condition will be covered in else case only
           /* else if(reminder * 2 == k){// eg k = 10 nums = [15, 25,35,45] then (15, 25) (35,45) can pair up with each other
                if(remFreq.get(reminder) % 2 != 0) return false;// when freq is odd, 1 element is unpaired eg (15, 25) (35)
            */
            else{
                int count1 = remFreq.get(reminder); //num whose remainder = r can pair up with num whose remainder = k-r
                int count2 = remFreq.getOrDefault(k-reminder, 0); // count must be equal so that they can pair up with each other
                if(count1!=count2) return false;
            }
        }
        return true;
    }

}
