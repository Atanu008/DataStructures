package org.atanu.java.ds.graph;

import java.util.*;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
// Leetcode 2115
// Video(Great Explanation) : https://www.youtube.com/watch?v=JrH724YE07g

// This is one of my favourite Problem

// Intuition
// Map ingredients To Recipe
// Suppose
// 1. Wheat, Mild and Sugar are the ingredient to Bread
// 2. Bread and Egg are the ingredient sandwich
// Now lets Map ingredients To Recipe
// A1. Create a edge from Wheat To Bread
// A2. Create a edge from Milk To Bread
// A3. Create a edge from Sugar To Bread
// InDegree of Bread would be Three

// B1. Create a edge from Bread To Sandwich
// B2. Create a edge from Egg To Sandwich
// InDegree of Sandwich would be Two

// Now To create sandwich we first need to create Bread
// If we observer the initial supplies has to be some ingredients
// What we will try to do is from supplies try to make the recipe
// for each supply we if is ingredient then we will decrement the inDegree of that recipe
// If inDegree is zero that means we are able to form the recipe , add it the supply as we can use it to build the next recepie
// Now if the supply is in recipe list then add it to the result.

public class FindAllPossibleRecipesFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        // Suppose
        // 1. Wheat, Mild and Sugar are the ingredient to Bread
        // 2. Bread and Egg are the ingredient sandwich
        // Now lets Map ingredients To Recipe
        // A1. Create a edge from Wheat To Bread
        // A2. Create a edge from Milk To Bread
        // A3. Create a edge from Sugar To Bread
        // InDegree of Bread would be Three

        // B1. Create a edge from Bread To Sandwich
        // B2. Create a edge from Egg To Sandwich
        // InDegree of Sandwich would be Two
        for(int i = 0; i < recipes.length; i++){
            String recepie = recipes[i];
            List<String> recepieIngredients = ingredients.get(i);
            inDegree.put(recepie, recepieIngredients.size());
            for(String ingredient : recepieIngredients){
                adjList.putIfAbsent(ingredient, new ArrayList<>());
                adjList.get(ingredient).add(recepie);
            }
        }
        List<String> ans = new ArrayList<>();
        // Recipe Set for easy look up
        Set<String> recipeSet = new HashSet<>(Arrays.asList(recipes));
        // Put all the supplies in Queue
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));

        while(!queue.isEmpty()){

            String supply = queue.poll();
            // If the supply(mostly derived) is in recipe add it to result
            if(recipeSet.contains(supply)){
                ans.add(supply);
            }

            for(String recp : adjList.getOrDefault(supply, new ArrayList<>())){
                // Decrement inDegree of recipe for each ingredient encountered
                inDegree.put(recp, inDegree.get(recp) - 1);
                // inDegree of recipe is zero , means we have all the ingredient to make it , add it to supply
                if(inDegree.get(recp) == 0){
                    queue.offer(recp);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAllPossibleRecipesFromGivenSupplies findAllPossibleRecipesFromGivenSupplies = new FindAllPossibleRecipesFromGivenSupplies();
        String[] recipes = new String[]{"bread","sandwich","burger"};
        //String[] supplies = new String[]{"yeast","flour","meat"}; // will be able to make all three recipes
        String[] supplies = new String[]{"yeast","flour"}; // Meat not there , So only Bread can be made
        List<List<String>> ingredients  = new ArrayList<>();
        for(int i=0;i<3;i++){
            ingredients.add(new ArrayList<>());
        }
        ingredients.get(0).add("yeast");
        ingredients.get(0).add("flour");
        ingredients.get(1).add("bread");
        ingredients.get(1).add("meat");
        ingredients.get(2).add("sandwich");
        ingredients.get(2).add("bread");
        ingredients.get(2).add("meat");

        System.out.println(findAllPossibleRecipesFromGivenSupplies.findAllRecipes(recipes,ingredients,supplies));

    }
}
