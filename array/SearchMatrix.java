package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/15
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 直接当成一维的序列查找即可 二分搜索
        // O(Log(MN))
        // 关键就是处理索引的映射关系

        int n = matrix.length;
        if (n == 0) {return false;}
        int m = matrix[0].length;

        int i = 0, j = n * m - 1;

        while (i <= j) {
            int mid = i + (j - i)/2;
            int midX = mid / m;
            int midY = mid % m;

            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }
}
