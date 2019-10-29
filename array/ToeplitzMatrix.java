package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/10/28
 */
public class ToeplitzMatrix {

    /**
     * 呜呜呜我太蠢了
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    /**
     * 判断一个矩阵是否每个从左上到右下的对角线都是相同的元素
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        // 从第一行开始为起点
        int N = matrix.length;
        int M = matrix[0].length;

        if (N == 1 || M == 1) {
            return true;
        }

        int i = 0, j = 0;

        for (; j < M - 1; j++) {
            if (!diagonal(matrix, i, j)) {
                return false;
            }
        }


        // 以第一列为起点
        j = 0;
        for (i = 1; i < N - 1; i++) {
            if (!diagonal(matrix, i, j)) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonal(int[][] matrix, int i, int j) {
        int num = matrix[i++][j++];
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != num) {
                return false;
            }
            i++;j++;
        }
        return true;
    }
}
