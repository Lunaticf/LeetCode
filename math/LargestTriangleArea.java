package leetCode.math;

/**
 * @Author Lunaticf
 * @Date 2019/10/31
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double max = 0.0;
        // 因为后面必须还要有2个
        for (int i = 0; i < points.length - 2; i++)
            for (int j = i + 1; j < points.length - 1; j++)
                for (int k = j + 1; k < points.length; k++)
                    max = Math.max(max, areaCal(points[i], points[j], points[k]));
        return max;
    }

    public double areaCal(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0;
    }
}
