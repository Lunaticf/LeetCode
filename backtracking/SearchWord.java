package leetCode.backtracking;

public class SearchWord {
    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) {
            return false;
        }


        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visit[i][j] = true;

        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1);
        visit[i][j] = false;
        return res;
    }
}
