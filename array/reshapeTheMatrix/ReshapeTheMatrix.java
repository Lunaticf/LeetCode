package leetCode.array.reshapeTheMatrix;

/**
 * @Author Lunaticf
 * @Date 2019/10/16
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // reshape 很生动
        // 关键就是坐标的转换

        // 先要判断能不能转换
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int index = i * nums[0].length + j;
                res[index / c][index % c] = nums[i][j];
            }
        }
        return res;
    }
}
