package org.atanu.java.ds.graph;

//https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
//Leetcode 1061

// Explanation : https://leetcode.com/problems/lexicographically-smallest-equivalent-string/solutions/3047517/python3-union-find-template-explanations/?orderBy=most_votes

//Intuition
//
//The rules for the "equivalent characters" introduced in the problem simply means the two characters belong to the same group.
//And our job is that for each character in baseStr, we need to find its belonging group and find the smallest character from that group.
//So we have two tasks:
//Create all the groups with equivalent characters from s1 and s2.
//Find the group for each character in baseStr, and find the smallest character in that group
//Grouping connected elements can be done  Union-find

public class LexicographicallySmallestEquivalentString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        UnionFind unionFind = new UnionFind(26);

        for(int i = 0; i < s1.length(); i++){
            int nodeS1 = s1.charAt(i) - 'a';
            int nodeS2 = s2.charAt(i) - 'a';
            unionFind.union(nodeS1, nodeS2);
        }

        String ans = "";
        for(int i = 0; i < baseStr.length(); i++){
            int ch = baseStr.charAt(i) - 'a';
            ans += (char) (unionFind.find(ch) + 'a');
        }

        return ans;
    }

    private static class UnionFind{

        int[] root;

        public UnionFind(int size){
            root = new int[size];
            for(int i = 0; i < size; i++){
                root[i] = i;
            }
        }

        public int find(int x){
            if(root[x] == x){
                return x;
            }

            return root[x] = find(root[x]);
        }

        public void union(int x, int y){

            int rootX = find(x);
            int rootY = find(y);
            // System.out.println("x "+ x + " y " + y + " rootX "+rootX +" rootY "+ rootY);

            // The main issue we need to take care of in this problem is
            // that we want the root of a group to be
            // the smallest element in the group
            // So every time we add an element in a group, we check if it is the smallest one,
            // If it is, we set it as the root.
            if(rootX > rootY){
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
            }
        }
    }
}
