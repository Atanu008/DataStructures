package org.bgd.java.ds.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/">...</a>
 *
 * 1707. Maximum XOR With an Element From Array
 *
 * You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].
 *
 * The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.
 *
 * Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * Output: [3,3,7]
 * Explanation:
 * 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * Example 2:
 *
 * Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * Output: [15,-1,5]
 */
public class MaxXorQueries {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        List<List<Integer>> offlineQueries = new ArrayList<>();
        Trie trie = new Trie();

        Arrays.sort(nums);
        int v = 0;
        for (int[] q : queries) {
            List<Integer> t = new ArrayList<>();
            t.add(q[1]); // max value = Ai
            t.add(q[0]);
            t.add(v++);
            offlineQueries.add(t);
        }

        Collections.sort(offlineQueries, Comparator.comparingInt(a -> a.get(0)));
        int i = 0;

        for (List<Integer> query : offlineQueries) {
            while (i < queries.length && nums[i] <= query.get(0)) {
                trie.insert(nums[i]);
                i++;
            }

            if (i != 0) {
                answer[query.get(2)] = trie.findMaxXor(query.get(1));
            } else {
                answer[query.get(2)] = -1;
            }
        }
        return answer;
    }
}

class TrieNodeBit {
    TrieNodeBit[] links;

    TrieNodeBit() {
        links = new TrieNodeBit[2];
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public TrieNodeBit get(int bit) {
        return links[bit];
    }

    void put(int bit, TrieNodeBit node) {
        links[bit] = node;
    }
}

class Trie {
    TrieNodeBit root;

    Trie() {
        root = new TrieNodeBit();
    }

    void insert(int number) {
        TrieNodeBit head = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if (head.containsKey(bit)) {
                head = head.get(bit);
            } else {
                head.put(bit, new TrieNodeBit());
                head = head.get(bit);
            }
        }
    }

    int findMaxXor(int number) {
        TrieNodeBit head = root;
        int max = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            int comp = 1 - bit;
            if (head.containsKey(comp)) {
                max = max | (1 << i);
                head = head.get(comp);
            } else {
                head = head.get(bit);
            }
        }
        return max;
    }
}
