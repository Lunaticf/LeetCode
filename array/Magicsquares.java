package leetCode.array;

public class Magicsquares {
    /** magic square
         就是遍历grid的每个3*3的矩阵
         看是否满足只有1-9的元素 并且每行每列和对角线的和都相同
         主要的优化点在于
         a1 a2 a3
         a4 a5 a6
         a7 a8 a9
         每行相同，三行的和=1+..+9 每一行就是15啦
         a1 + a5 + a9 + a2 + a5 + a8 + a3 + a5 + a7 + a4 +a5 + a6 = 60
         a1 + a2 + a4 + a4 + a5 + a6 + a7 + a8 + a9 = 45
         可以看到3*a5 =15 a5必然等于5 可以预先check这个条件了
     */
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // check if have 3 * 3 grid
                if (i + 2 < m && j + 2 < n) {
                    if (check (i, j, grid)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int i, int j, int[][] grid) {
        if (grid[i + 1][j + 1] != 5) {
            return false;
        }

        // check if contains 1-9
        boolean[] record = new boolean[10];
        for (int p = i; p <= i + 2; p++) {
            for (int q = j; q <= j + 2; q++) {
                if (grid[p][q] > 9) {
                    return false;
                } else if (record[grid[p][q]]) {
                    return false;
                } else {
                    record[grid[p][q]] = true;
                }
            }
        }

        // check every line and diagonals
        return grid[i][j] + grid[i + 1][j] + grid[i+2][j] == 15
                && grid[i][j + 1] + grid[i + 1][j + 1] + grid[i+2][j + 1] == 15
                && grid[i][j + 2] + grid[i + 1][j + 2] + grid[i+2][j + 2] == 15
                && grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15
                && grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15
                && grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15
                && grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15
                && grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == 15;
    }
}
