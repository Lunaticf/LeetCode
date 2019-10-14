package leetCode.math.perfectNumber;

/**
 * @Author Lunaticf
 * @Date 2019/10/14
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                // 这里评论区有人说不用判断
                // 但是其实是因为如果是完美平方数，是不可能存在一个正整数根的，所以才说不用判断
                if ((num / i) != i) {
                    sum += (num / i);
                }
                sum += i;
            }

            // 提前结束
            if (sum > num) {
                return false;
            }
        }
        return sum == num;
    }

    public boolean checkPerfectNumber1(int num) {
        return num==6 || num==28 || num==496 || num==8128 || num==33550336;
    }
}
