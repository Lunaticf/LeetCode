package leetCode.bit.numberOf1Bits;

/**
 * @Author Lunaticf
 * @Date 2019/9/4
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    /**
     * >>> 是为了最左边只补0 我们也可以用32次循环来替代
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }

    /**
     * n & n-1 其实每次会消除一个1 这是一个trick
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
