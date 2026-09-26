package arrays_hashing.p0036_valid_sudoku;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character>[] square = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            square[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int k = (i / 3) * 3 + (j / 3);

                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) return false;
                    if (!square[k].add(board[i][j])) return false;
                }

                if (board[j][i] != '.') {
                    if (!col.add(board[j][i])) return false;
                }
            }

            row.clear();
            col.clear();
        }

        return true;
    }
}
