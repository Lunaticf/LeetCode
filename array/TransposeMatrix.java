package leetCode.array;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        // 这题有个坑就是这里得调换一下 2*3 变成 3*2的矩阵
        int[][] res = new int[A[0].length][A.length];

        // 返回矩阵的转置
        for (int i = 0; i < A.length; i++) {
            for (int j =0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
