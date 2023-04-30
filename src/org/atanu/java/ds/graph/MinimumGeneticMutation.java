package org.atanu.java.ds.graph;

// https://leetcode.com/problems/minimum-genetic-mutation/description/
// Leetcode 433

// Basically Its the same problem as finding shortest path between nodes in unweigthed graph
// We need to do simple BFS , in each layer we increment the level
// Return the level when found

import java.util.*;

public class MinimumGeneticMutation {


    // 1) It is simple BFS question.
    //
    //    2) Since we have to find the minimum number of mutations,
    //    that's why BFS is used.
    //
    //    3) First thing first, I will insert all the valid gene (i.e bank array strings)
    //    into a unordered set name as dictionary. It helps me to search any particular
    //    word whether valid or not in O(1) operation.
    //
    //    4) Now, we check whether end word is present in our dictionary or not,
    //    if end word itself is not in present in the dictioanry then from there
    //    we return -1, as it will never possible to make end word.
    //
    //    5) Now, for BFS we declare queue, and simply insert start string into queue.
    //
    //    6) We required an anthor set name as visited (vis). vis will carry out whether
    //    we already encounter this in process curr word to make end string. If yes, then no need
    //    to insert into queue, but if it is not present in queue, we insert it.
    //
    //    7) Now, for every word, we will try to replace every indicies with available
    //    choice we have, i.e for every index of curr word we try to replace with
    //    'A','C', 'G', & 'T', and will see whether new form word is valid or not.
    //
    //    8) If it is valid we will then go to check vis, if not already visited,
    //    we insert into queue and move proceed.
    //
    //    9) For every operation we will increase our answer.
    //
    //    10) Whenever we find our curr word as end word we will return the number of
    //    steps taken at that point of time as answer.
    //
    //    11) If still we will not available to make our end word we will return -1,
    //    as told in the question.

    public int minMutation(String startGene, String endGene, String[] bank) {

        // Base Case
        // If Both Genes are same , No Mutation required
        if(startGene.equals(endGene)){
            return 0;
        }
        // Create a Bank set of valid mutation to look up in O(1)
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] geneChoices = new char[]{'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int minMutationRequired = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size --> 0){
                String currentGene = queue.poll();
                if(currentGene.equals(endGene)){
                    return minMutationRequired;
                }
                char[] currentGeneArray = currentGene.toCharArray();
                for(int i = 0; i < currentGeneArray.length; i++) {
                    char ch = currentGeneArray[i];
                    for(char geneChoice : geneChoices){
                        currentGeneArray[i] = geneChoice;
                        String mutation = new String(currentGeneArray);
                        if(!visited.contains(mutation) && bankSet.contains(mutation)){
                            queue.offer(mutation);
                            visited.add(mutation);
                        }
                    }
                    currentGeneArray[i] = ch;
                }
            }
            minMutationRequired++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int minMutation = minimumGeneticMutation.minMutation(startGene, endGene, bank);
        System.out.println(minMutation);

    }
}
