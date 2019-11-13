package leetCode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Lunaticf
 * @Date 2019/11/6
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // looks like so easy?
        // double pointer
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < A.length && A[i] % 2 == 0) {
                i++;
            }
            while (j >= 0 && A[j] % 2 == 1) {
                j--;
            }

            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;j--;
            }

        }
        return A;
    }


    /**
     * 有个函数式的写法蛮不错
     * @param A
     * @return
     */
    public int[] sortArrayByParity1(int[] A) {
        return Arrays.stream(A).boxed().sorted(Comparator.comparingInt(a -> a % 2)).mapToInt(i -> i).toArray();
    }


}
