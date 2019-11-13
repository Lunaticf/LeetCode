package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/2
 */
public class FlipAndInvertImage {
    /**
     * 暴力
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int p = 0;
            int q = A[0].length - 1;
            while (p < q) {
                int temp = A[i][p];
                A[i][p] = A[i][q];
                A[i][q] = temp;
                p++;q--;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] ^= 1;
            }
        }

        return A;
    }

    /**
     * 想一下 其实如果一行为[0, 1, 1, 0 , 1]
     * 0和1不相等，0和1 调换得到1 和 0，1又变成0 0又变成1
     * 等于必须两个数相等的时候0 0 直接翻转就行了
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage1(int[][] A) {
        int n = A[0].length;

        for (int[] row : A){
            // 囊括了中间的数
            for (int i = 0; i * 2 < n; i++){
                if (row[i] == row[n - i - 1]) {
                    row[n - i - 1] ^= 1;
                    row[i] = row[n - i - 1];
                }
            }
        }


        return A;
    }


}
