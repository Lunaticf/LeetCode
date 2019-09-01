package leetCode.hashTable.validSudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // 最蠢的版本
    public boolean isValidSudoku(char[][] board) {
        int[] hash = new int[9];

        // detect each row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(hash, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (hash[board[i][j] - '1'] == 1) return false;
                hash[board[i][j] - '1'] = 1;
            }
        }


        // detect each column
        for (int i = 0; i < 9; i++) {
            Arrays.fill(hash, 0);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (hash[board[j][i] - '1'] == 1) return false;
                hash[board[j][i] - '1'] = 1;
            }
        }

        // detect each sub-box
        for (int i = 0; i < 9; i+= 3) {
            for (int j = 0; j < 9; j+= 3) {
                Arrays.fill(hash, 0);
                for (int p = i; p < i + 3; p++) {
                    for (int q = j; q < j + 3; q++) {
                        if (board[p][q] == '.') continue;
                        if (hash[board[p][q] - '1'] == 1) return false;
                        hash[board[p][q] - '1'] = 1;
                    }
                }
            }
        }

        return true;
    }


    // 个人觉得还可以的解法 兼顾可读性
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] box = new boolean[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    if (row[i][c] || column[j][c] || box[i / 3 * 3 + j / 3][c]) return false;
                    row[i][c] =  column[j][c] = box[i / 3 * 3 + j / 3][c] = true;
                }
            }
        }

        return true;
    }


    // 对位置和数字进行编码
    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!seen.add(s + i) || !seen.add(j + s) || !seen.add(i/3 + s + j/3))
                        return false;
                }
            }
        }
        return true;
    }

}
