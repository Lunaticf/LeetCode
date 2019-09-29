package leetCode.bit.sumOfTwoIntegers;

/**
 * @Author Lunaticf
 * @Date 2019/9/29
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            // 左移一位得到正确位置的进位
            b = carry << 1;
        }

        return a;
    }
}
