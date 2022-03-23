package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/accounts-merge/
//LeetCode 721
//Video Explanation Awesome : https://www.youtube.com/watch?v=yaSpBVoe964&t=733s
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind unionFind = new UnionFind(accounts.size());

        // prepare a hash with unique email address as key and index in accouts as value
        Map<String, Integer> mailToIndex = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++) {
            List<String> accountList = accounts.get(i);
            // j starts with 1 because we want to skip the Name in 0th index
            for(int j = 1; j < accountList.size(); j++) {

                String email = accountList.get(j);
                //If not seen add it to hash
                if(!mailToIndex.containsKey(email)) {
                    mailToIndex.put(email, i);
                }
                else {// if we have already seen this email before, merge the account  "i" with previous account
                    unionFind.union(i, mailToIndex.get(email));
                }
            }
        }

        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        Map<Integer, List<String>> indexToEmailMap = new HashMap<>();

        for(String email : mailToIndex.keySet()) {

            int root = unionFind.find(mailToIndex.get(email));
            if(!indexToEmailMap.containsKey(root)) {
                indexToEmailMap.put(root, new ArrayList<>());
            }

            indexToEmailMap.get(root).add(email);
        }

        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> result = new ArrayList<>();

        for(int index : indexToEmailMap.keySet()){
            List<String> emailList = indexToEmailMap.get(index);
            Collections.sort(emailList);
            emailList.add(0, accounts.get(index).get(0));
            result.add(emailList);
        }

        return result;

    }

    static class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i;
            }
        }

        public int find(int x) {
            if(root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootX;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }
}
