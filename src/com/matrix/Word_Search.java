package com.matrix;

public class Word_Search {

    public static void main(String[] args) {

        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        boolean result_exist = exist(board, "ABCCED");
        System.out.println(result_exist);
        
    }

    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {

        int row = board.length;
        int column = board[0].length;

        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (word.charAt(0) == board[i][j] && wordSearch(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordSearch(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || word.charAt(index) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (wordSearch(board, word, i + 1, j, index + 1) || wordSearch(board, word, i - 1, j, index + 1)
                || wordSearch(board, word, i, j + 1, index + 1) || wordSearch(board, word, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;

        return false;

    }

}
