package org.atanu.java.ds.graph;

import java.util.*;

// https://leetcode.com/problems/find-all-people-with-secret/description/
// Leetcode 2092


// Intuition A:

// Visit the meetings happening at the same time together . Lets Use TreeMap
// We can connect the two persons in the same meeting using a UnionFind.

// Tricky point here: After traversing this batch of meetings,
// we reset the persons who don't know the secret by checking if he/she is connected to person 0.
// With UnionFind, reseting means setting id[x] = x.
//In the end, we add all the persons who are connected to person 0 into the answer array.

// Intuition B:
// If someone from current time knows the secret, the next times these people can tell the secret to others.
// Also if someone from current time knows the secret, people who they contacted previously can't know the secret.
// We reset the connections of people who talked to each other but don't know the secret -
// these connections shouldn't affect future meetings.

public class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Map<Integer, List<int[]>> adjList = new TreeMap<>();
        for(int[] meeting : meetings){
            int nodeA = meeting[0];
            int nodeB = meeting[1];
            int time = meeting[2];
            adjList.computeIfAbsent(time, val -> new ArrayList<>()).add(new int[]{nodeA, nodeB});
        }

        UnionFindPathCompressionUnionBySize unionFind = new UnionFindPathCompressionUnionBySize(n);
        // Connect zero and firstPerson
        unionFind.union(0, firstPerson);

        // for every time we have a pool of people that talk to each other
        // if someone knows a secret proir to this meeting - all pool will too
        // if not - reset unions from this pool
        for(int time : adjList.keySet()){

            Set<Integer> pool = new HashSet<>();
            for(int[] peoples : adjList.get(time)){
                int personA = peoples[0];
                int personB = peoples[1];
                unionFind.union(personA, personB);
                pool.add(personA);
                pool.add(personB);
            }

            // The Crux of this problem
            // meeting that took place now should't affect future
            // meetings if people don't know the secret
            // For eg Now Person4 and Person7 is had meeting , but they dont know the secret
            // For in future in Person7 knows the secret then Person4 will also know the secret if we make them connected
            // So if someone does not know , disconnect them
            for(int person : pool){ // For each person in the pool, check if he/she's connected with person 0.
                if(!unionFind.connected(0, person)){
                    unionFind.reset(person); // If not, this person doesn't have secret, reset it.
                }
            }
        }

        List<Integer> peopleWhoKnowSecret = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(unionFind.connected(0, i)){
                peopleWhoKnowSecret.add(i); // Push all the persons who are connected with person 0 into answer array
            }
        }
        return peopleWhoKnowSecret;
    }

    private static class UnionFindPathCompressionUnionBySize {
        int[] root;
        int[] size;

        public UnionFindPathCompressionUnionBySize(int n){
            root = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                root[i] = i;
                size[i] = 1; // The initial "size" of each vertex is 1, because each of them is having one size initially
            }
        }

        public int find(int x){

            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if(size[rootX] > size[rootY]){
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public int getNumberOfComponent() {
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if (root[i] == i) { //If the same element is root i.e it belengs to its same set , if its diffeent that means this element have differner root
                    count++;
                }
            }

            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        //Reset
        public void reset(int node) {
            root[node] = node;
            size[node] = 1;
        }

    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret findAllPeopleWithSecret = new FindAllPeopleWithSecret();
        int n = 6;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 1;
        List<Integer> allPeopleWithSecret = findAllPeopleWithSecret.findAllPeople(n, meetings, firstPerson);
        //Output: [0,1,2,3,5]
        //Explanation:
        //At time 0, person 0 shares the secret with person 1.
        //At time 5, person 1 shares the secret with person 2.
        //At time 8, person 2 shares the secret with person 3.
        //At time 10, person 1 shares the secret with person 5.
        //Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
        System.out.println(allPeopleWithSecret);

        n = 6;
        meetings = new int[][]{{3,1,3},{1,2,2},{0,3,3}};
        firstPerson = 3;
        allPeopleWithSecret = findAllPeopleWithSecret.findAllPeople(n, meetings, firstPerson);
        //Output: [0,1,3]
        //Explanation:
        //At time 0, person 0 shares the secret with person 3.
        //At time 2, neither person 1 nor person 2 know the secret.
        //At time 3, person 3 shares the secret with person 0 and person 1.
        //Thus, people 0, 1, and 3 know the secret after all the meetings.
        System.out.println(allPeopleWithSecret);
    }
}
