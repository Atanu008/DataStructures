package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

	public List<String> findWords(char[][] board, String[] words) {

		List<String> retVal ;
        Set<String> interMedRes = new HashSet<>();

		int row = board.length;
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];

		for(String word : words){

			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){

					if(board[i][j] == word.charAt(0) && dfs(board, word,0, visited,i , j)){

						interMedRes.add(word);
					}
				}
			}
		}
        
       return new ArrayList<>(interMedRes);

        
		//return retVal;

	}

	public boolean dfs(char[][] board, String word, int index, boolean[][] visited, int i , int j){

		if(index == word.length()){
			return true;
		}

		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)  || visited[i][j]){
			return false;
		}

		visited[i][j] = true;

		boolean exist =  dfs(board, word, index + 1, visited , i + 1 , j)
				|| dfs(board, word, index + 1, visited , i - 1 , j)
				|| dfs(board, word, index + 1, visited , i , j + 1)
				|| dfs(board, word, index + 1, visited , i , j - 1);

		// Back Tracking
		visited[i][j] = false;

		return exist;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
