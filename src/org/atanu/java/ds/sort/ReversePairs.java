package org.atanu.java.ds.sort;

//https://leetcode.com/problems/reverse-pairs/
//LeetCode 493
//Idea : https://www.youtube.com/watch?v=owZhw-A0yWE&t=619s
public class ReversePairs {

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int low, int high){
        //Base Case
        if(low >= high){
            return 0;
        }

        int mid = low + (high - low)/2;
        //count the inversion cout of Two half
        int invCount = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

        invCount += merge(nums, low, mid, high);

        return invCount;
    }

    //Sort in ascending
    private int merge(int[] nums, int low, int mid, int high){

        int j = mid + 1;
        int count = 0;
        //This the algo to Count
        //We have two sorted half here in ascending order(low To mid) and (mid + 1 to high)
        // 10 20 30   and 2 3 4 8
        // i will tarverse the first half and j will tarverse second for each i
        //Now if i is mums[i] = 10
        // if(2 * nums[j] > nums[i]) we can increment j right
        //so 2 , 3 , 4 they will satishfy but not 8
        // Now j will point to indedx of 8
        // So for nums[10] how many pair - [10,2] [10, 3] [10 ,4]
        // suppose index of 2 starts with 10 i.e (mid + 1) .
        //after the while loop j will pint to 13
        // pair for 2 3 4 so that has to be 13 - 10 = j - (mid + 1)
        for(int i = low ; i <= mid; i++){

            while(j <= high && nums[i] > (long) 2 * nums[j]){
                j++;
            }

            count += j - (mid + 1);
        }

        // create a temp array
        int[] temp = new int[high - low + 1];
        // crawlers for both intervals and for temp
        int left = low, right = mid + 1, index = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(left <= mid && right <= high){

            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }
            else{
                temp[index++] = nums[right++];
            }
        }
        // add elements left in the first interval
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        // add elements left in the second interval
        while(right <= high){
            temp[index++] = nums[right++];
        }
        // copy temp to original interval
        for(int i = low; i <= high; i++){
            nums[i] = temp[i - low];
        }

        return count;
    }
}
