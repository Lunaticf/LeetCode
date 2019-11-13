package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/9
 */
public class MoutainOfArray {

    /**
     * one pass 很有意思
     * 两个人从两边爬到最高峰
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int i = 0, j = A.length - 1;
        while (i + 1 < A.length && A[i] < A[i + 1]) {
            i++;
        }
        while (j >= 1 && A[j] < A[j - 1]) {
            j--;
        }
        return i > 0 && i == j && j < A.length - 1;

    }
    public boolean validMountainArray1(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int top = -1;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                top = i;
            }
        }

        if (top == -1) {
            return false;
        }

        for (int i = 1; i < top; i++) {
            if (A[i] <= A[i - 1]) {
                return false;
            }
        }

        for (int i = top + 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
