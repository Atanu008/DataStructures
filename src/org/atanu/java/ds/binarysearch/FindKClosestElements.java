package org.atanu.java.ds.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-closest-elements/
//LeetCode 658
public class FindKClosestElements {

    private class Node {
        int index;
        int difference;

        public Node(int index, int difference) {
            this.index = index;
            this.difference = difference;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.difference == b.difference) {
                        return b.index - a.index;
                    } else {
                        return b.difference - a.difference;
                    }

                });

        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(i, Math.abs(arr[i] - x));

            pq.offer(newNode);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(arr[pq.poll().index]);
        }

        Collections.sort(result);
        return result;
    }


    //Find the right Index
    //Collect elements from Left and Right
    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {

        int rightIndexforX = binarySearch(arr, x);

        int left = rightIndexforX -1;
        int right = rightIndexforX;
        List<Integer> result = new ArrayList<>();
        while(left >= 0 && right <= arr.length -1 && k --> 0){

            if(Math.abs(arr[left] -x) <= Math.abs(arr[right] -x)){
                result.add(arr[left]);
                left--;
            }
            else{
                result.add(arr[right]);
                right++;
            }
        }

        while(left >= 0 && k -->0){
            result.add(arr[left]);
            left--;
        }

        while(right >= 0 && k -->0){
            result.add(arr[right]);
            right++;
        }

        Collections.sort(result);
        return result;
    }

    public int binarySearch(int[] arr, int x){

        int low = 0;
        int high = arr.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                return mid;
            }

            if(arr[mid] < x){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }

        return low;
    }

    //Check Premium Explanation
    public List<Integer> findClosestElementsV3(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    //Video : https://www.youtube.com/watch?v=C_kHKUJuK0Y&t=616s
    // TC - O(N)
    public List<Integer> findClosestElementsV4(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (high - low >= k) {
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)){
                low++;
            }
            else{
                high--;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
