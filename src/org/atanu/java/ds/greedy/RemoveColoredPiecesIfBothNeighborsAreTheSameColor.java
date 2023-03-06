package org.atanu.java.ds.greedy;

//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
//Leetcode 2038
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    //Alice will only win if number of triplet of "A" is more than number of triplet of "B"
    //Case 1 : is case of small its any way loose
    //Case 2: In case of equal Alice will still loose as she made the first move
    //As Alice has to make a move first so if she wants to win there should be atleast 1 more triplets of A than B
    //In all teh above cases Bob will win, if number of "A" triplet is more then Alice will win
    public boolean winnerOfGame(String colors) {

        int piecesCanBeRemovedByAlice = 0;
        int piecesCanBeRemovedByBob = 0;

        for(int i = 1; i < colors.length() - 1; i++){
            if(colors.charAt(i-1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A'){
                piecesCanBeRemovedByAlice++;
            }
            if(colors.charAt(i-1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B'){
                piecesCanBeRemovedByBob++;
            }
        }

        return piecesCanBeRemovedByAlice > piecesCanBeRemovedByBob;
    }
}
