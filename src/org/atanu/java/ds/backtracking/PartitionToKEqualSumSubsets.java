package org.atanu.java.ds.backtracking;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
//Leetcode 698
//Awesome Explanation : https://medium.com/trick-the-interviwer/partition-to-k-equal-sum-subsets-ebf49c7ae2fc
//Video Can refer : https://www.youtube.com/watch?v=2Ak-W9ZkEHE
public class PartitionToKEqualSumSubsets {

    //https://medium.com/trick-the-interviwer/partition-to-k-equal-sum-subsets-ebf49c7ae2fc
    public boolean canPartitionKSubsets(int[] nums, int k) {

        //If the length of the array is less than the partitions required, then we can’t partition it and return false.
        if(nums.length < k){
            return false;
        }

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        // If this sum/k is not an integer, the task is impossible . not be able to break
        if(sum % k != 0){
            return false;
        }

        //Now we need to check if it is possible to divide the array in K subset with targetSum
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return partition(nums, 0, target, visited, k, 0);
    }

    private boolean partition(int[] nums, int currentSum, int target, boolean[] visited, int k , int index){
        /** base condition, All buckets are filled, therefore no need to recurse further **/
        if(k == 0){
            return true;
        }
        //Not possible to form in this sub set setting
        if(currentSum > target){
            return false;
        }
        /** if the sum of elements of current bucket is equal to required sum then current bucket is considered to be filled, and then we try to fill the next bucket. In this case, we reduce number of remaining buckets by one and we initialise current sum for next bucket to be zero **/
        if(currentSum == target){
            return partition(nums, 0, target, visited, k - 1, 0);
        }
        /** Loop for filling the current bucket **/
        for(int i = index; i < nums.length; i++){
            if(!visited[i]){ //if(!used[i] && currentSum+nums[i]<=target)  currentSum+nums[i]<=target will optimize as we dont not to recurse if adding this current would make it greater than target
                //include the current unused element and mark it as used
                visited[i] = true;
                /** recurse for the remaining array to fill the current bucket, bucket sum will increase to cs+nums[i] including the current elements and start index for next iteration will be current index+1 **/
                if(partition(nums, nums[i] + currentSum, target, visited, k, i + 1)){
                    return true;
                }
                //exclude the current element and mark it as unused, backtracking. We will do backtracking if on considering the current item in the bucket, we can’t fill the current bucket or the remaining buckets. Then we move on adding the next element in the current bucket and remove this one.
                visited[i] = false;
            }
        }

        return false;//if partitions are not found, return false
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets kEqualSumSubsets = new PartitionToKEqualSumSubsets();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean result = kEqualSumSubsets.canPartitionKSubsets(nums, k);
        //Output: true
        //Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
        System.out.println(result);

        nums = new int[]{1,2,3,4};
        k = 3;
        result = kEqualSumSubsets.canPartitionKSubsets(nums, k);
        //Output: false
        System.out.println(result);
    }
}
