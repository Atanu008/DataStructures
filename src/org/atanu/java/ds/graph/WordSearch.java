package org.atanu.java.ds.graph;

public class WordSearch {

	public boolean exist(char[][] board, String word) {

		int row = board.length;
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];

		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){

				if(board[i][j] == word.charAt(0) ){
					if(dfs(board, word,0, visited,i , j)){
						return true;
					}
				}
			}
		}

		return false;
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
