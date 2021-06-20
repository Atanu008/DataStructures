package org.atanu.java.ds.backtracking;

import java.util.*;

public class WordBoggle {
    private static int M, N;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private  void searchWord(char[][] board, boolean[][] visited, Set<String> wordSet, int i, int j, String path) {

        visited[i][j] = true;
        path = board[i][j]+ path;
        wordSet.add(path);

        for(int[] dir : dirs) {
            int nextRow = i + dir[0];
            int nextColumn = j + dir[1];
            if(isSafe(nextRow, nextColumn, visited)){
                searchWord(board,visited, wordSet, nextRow, nextColumn, path);
            }
        }

        visited[i][j] = false;
    }

    private  void searchBoggle(char[][] board, List<String> words) {
        boolean[][] visited = new boolean[M][N];
        Set<String> wordSet = new HashSet<>();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                searchWord(board, visited, wordSet, i , j, "");
            }
        }

        // for each word in the input list, check whether it is present in the set
        for (String word: words)
        {
            if (wordSet.contains(word)) {
                System.out.println(word);
            }
        }
    }

    public static boolean isSafe(int x, int y, boolean[][] processed) {
        return (x >= 0 && x < M) && (y >= 0 && y < N) && !processed[x][y];
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        M = board.length;
        N = board[0].length;

        WordBoggle wordBoggle = new WordBoggle();
        List<String> words = Arrays.asList("oath","pea","eat","rain");
        wordBoggle.searchBoggle(board, words);
    }


}
