package org.atanu.java.ds.graph;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/largest-component-size-by-common-factor/description/
// Leetcoe 952
// The problem statement can be stated in simpler terms as - two element belong to same group if they share a common factor. We need to find largest of such groups.
//
// For eg. If we have numbers [2,3,5,6,25], then we can see 2 & 6 share a common factor.
// So lets say they belong to group A. 3 & 6 also share a common factor,
// so 3 belongs to group A as well. 5 and 25 is another pair sharing a common factor so they belong to one group,
// lets say B. So, out of all these groups, A is the largest and it will be our answer.

public class LargestComponentSizeByCommonFactor {

    public int largestComponentSize(int[] nums) {

        int maxElement = nums[0];
        for(int num : nums){
            maxElement = Math.max(maxElement, num);
        }

        //Need to take size as maxElement because these input numbers and their factors are represting nodes
        //Number of nodes can not go beyond maxElement + 1
        UnionFindPathCompressionUnionBySize unionFind = new UnionFindPathCompressionUnionBySize(maxElement + 1);

        // finding factors of each element
        // if i divides num, then i & num/i are its factor. So union them
        for(int num : nums){
            // i*i <= num is same as i <= Math.sqrt(num). i can not go beyond Math.sqrt(num) for factor
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    //Eg : If num = 63 ; factorA = 7 factorB = 9 , connect them( 63, 7) and (63, 9)

                    int factorA = i;
                    int factorB = num / i;
                    unionFind.union(num, factorA);
                    unionFind.union(num, factorB);
                }
            }
        }
        int largestComponent = 0;
        // Count number of nodes in each component
        // We will get that by traversing the nums and incrementing their parent frequencies
        Map<Integer, Integer> componentFreq = new HashMap<>();
        // iterate and find parent that is seen most. It'll give the largest group
        for(int num : nums){
            int root = unionFind.find(num);
            componentFreq.put(root, componentFreq.getOrDefault(root, 0) + 1);
            largestComponent = Math.max(largestComponent, componentFreq.get(root));
        }
        return largestComponent;
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

    }
}
