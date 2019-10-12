package leetCode.math.islandPerimeter;

/**
 * @Author Lunaticf
 * @Date 2019/10/12
 */
public class IslandPerimeter {


    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;

                    // 如果上面有岛
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    // 如果左边有岛
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }
            }
        }
        return res;

    }

    /**
     * DFS
     * @param grid
     * @return
     */
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }

            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 如果碰到边界 +1 看图更好理解
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }

        // 如果碰到water + 1
        if (grid[i][j] == 0) {
            return 1;
        }

        // 如果碰到已经走过的
        if (grid[i][j] == -1) {
            return 0;
        }
        int count = 0;
        grid[i][j] = -1;

        count += dfs(grid, i - 1, j);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i , j - 1);
        count += dfs(grid, i, j + 1);

        return count;
    }


}
