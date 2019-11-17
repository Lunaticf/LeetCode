package leetCode.recursion;

public class Island {
    /**
     * 如果愿意改变原数组  可以不用visit 直接把走过的设置成1就行了
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        // happy题
        boolean[][] visit = new boolean[n][m];
        int count = 0;
        for (int i = 0;i < n;i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(grid, visit, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,boolean[][] visit,int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visit[i][j]) {
            return;
        }

        visit[i][j] = true;
        dfs(grid, visit, i+1, j);
        dfs(grid, visit, i, j+1);
        dfs(grid, visit, i, j-1);
        dfs(grid, visit, i-1, j);
    }
}
