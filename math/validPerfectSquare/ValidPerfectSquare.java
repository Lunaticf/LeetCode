package leetCode.math.validPerfectSquare;

/**
 * @Author Lunaticf
 * @Date 2019/9/19
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        new ValidPerfectSquare().isPerfectSquare1(36*36);
    }

    /**
     * 9 = 1 + 3 + 5
     * 复杂度O(sqrt(N))
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    /**
     * binary search
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int left = 1;
        int right = num / 2;

        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = (int) mid + 1;
            } else {
                right = (int)mid - 1;
            }
        }
        return false;
    }

}
