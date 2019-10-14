package leetCode.math.base7;

/**
 * @Author Lunaticf
 * @Date 2019/10/14
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        // 转化为7进制
        // 负数只需要加-
        StringBuilder s = new StringBuilder();
        int absNum = Math.abs(num);

        // 不停的除以7
        while (absNum != 0) {
            s.insert(0, absNum % 7);
            absNum /= 7;
        }

        return num < 0 ? "-" + s.toString() : s.toString();
    }

    public String convertToBase71(int num) {
        return Integer.toString(num, 7);
    }

    /**
     * 写个递归练练手
     * @param num
     * @return
     */
    public String convertToBase72(int num) {

        if (num < 0) {
            return "-" + convertToBase72(-num);
        }
        if (num < 7) {
            return num + "";
        }

        return convertToBase72(num / 7) + num % 7;
    }
}
