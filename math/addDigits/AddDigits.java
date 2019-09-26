package leetCode.math.addDigits;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class AddDigits {
    public int addDigits(int num) {
        String s = String.valueOf(num);
        while (s.length() != 1) {
            int temp = 0;
            for (int i = 0; i < s.length();i++) {
                temp += s.charAt(i) - '0';
            }
            s = String.valueOf(temp);
        }
        return Integer.valueOf(s);
    }


    /**
     * 比如4569 = 4*1000 + 5*100 + 6*10 + 9 = 4 + 5 + 6 + 9 + 4*999 + 5*99 + 6*9 = 24 + 9*num = 6 + 9*num
     * 4569 % 9即可
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
