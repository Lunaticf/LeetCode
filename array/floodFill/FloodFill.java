package leetCode.array.floodFill;

/**
 * @Author Lunaticf
 * @Date 2019/10/23
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 如果不加这个判断会stackoverflow
        if (image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length) {
            if (image[sr][sc] == color) {
                image[sr][sc] = newColor;
                dfs(image, sr + 1, sc, color, newColor);
                dfs(image, sr - 1, sc, color, newColor);
                dfs(image, sr, sc + 1, color, newColor);
                dfs(image, sr, sc - 1, color, newColor);
            }
        }

    }
}
