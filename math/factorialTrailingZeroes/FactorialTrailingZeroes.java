package leetCode.math.factorialTrailingZeroes;

/**
 * @Author Lunaticf
 * @Date 2019/9/4
 */
public class FactorialTrailingZeroes {
    /**
     * iterative
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    /**
     * recur
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
