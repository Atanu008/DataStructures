package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIIV2 {

    private static int M, N;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        M = board.length;
        N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                searchWord(board, visited, wordSet, i, j, "");
            }
        }

        // for each word in the input list, check whether it is present in the set
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (wordSet.contains(word)) {
                result.add(word);
            }
        }
        return result;

    }

    private void searchWord(char[][] board, boolean[][] visited, Set<String> wordSet, int i, int j, String path) {

        visited[i][j] = true;
        path = board[i][j] + path;
        wordSet.add(path);

        for (int[] dir : dirs) {
            int nextRow = i + dir[0];
            int nextColumn = j + dir[1];
            if (isSafe(nextRow, nextColumn, visited)) {
                searchWord(board, visited, wordSet, nextRow, nextColumn, path);
            }
        }

        visited[i][j] = false;
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

        WordSearchIIV2 wordSearchIIV2 = new WordSearchIIV2();
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = wordSearchIIV2.findWords(board, words);
        result.forEach(System.out::println);
    }
}
