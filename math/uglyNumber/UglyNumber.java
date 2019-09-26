package leetCode.math.uglyNumber;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num/=2;
                continue;
            }
            if (num % 3 == 0) {
                num/=3;
                continue;
            }
            if (num % 5 == 0) {
                num/=5;
                continue;
            }
            return false;
        }
        return true;
    }


    /**
     * more elegent way
     * @param num
     * @return
     */
    public boolean isUgly1(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
