package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/7
 */
public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] A) {
        // 就是要奇数位是奇数
        // 偶数位是偶数
        int i =0;
        int j = 1;
        while (i < A.length && j < A.length) {
            while (i < A.length && A[i] % 2 == 0) {
                i+=2;
            }
            while (j < A.length && A[j] % 2 == 1) {
                j+=2;
            }

            if (i < A.length && j < A.length) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i+=2;j+=2;
            }
        }
        return A;
    }
}
