package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/13
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
