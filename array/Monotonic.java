package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/6
 */
public class Monotonic {
    public boolean isMonotonic(int[] A) {
        // two pass很简单 就不写了
        // one pass还是比较有意思
        // 一开始判断出数组的走向
        boolean incur = false;
        boolean decur = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 0) {
                incur = true;
            }
            if (A[i] - A[i - 1] < 0) {
                decur = true;
            }
        }
        return !(incur && decur);
    }
}
