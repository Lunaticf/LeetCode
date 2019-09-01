package leetCode.dynamicProgramming.minimumPathSum;

public class MinimumPathSum {
    private int res = Integer.MAX_VALUE;
    // 会超时
    public int minPathSum(int[][] grid) {
        recur(grid, 0, 0, 0);
        return res;
    }
    private void recur(int[][] grid, int x, int y, int sum) {
        sum += grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.min(sum, res);
        }
        if (x + 1 < grid.length) {
            recur(grid, x+1, y, sum);
        }
        if (y + 1 < grid[0].length) {
            recur(grid, x, y + 1, sum);
        }
    }

    // dp来做
    public int minPathSum1(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[M - 1][N - 1];
    }
}
