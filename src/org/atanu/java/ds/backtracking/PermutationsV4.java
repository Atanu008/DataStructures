package org.atanu.java.ds.backtracking;

//https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/
public class PermutationsV4 {
    // Utility function to swap two characters in a character array
    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a string
    private static void permutations(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }

    // generate all permutations of a string in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s.toCharArray(), 0);
    }
}
