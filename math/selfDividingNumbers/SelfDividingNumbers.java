package leetCode.math.selfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/10/23
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String s = String.valueOf(i);
            boolean valid = true;
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (digit == 0 || i % digit != 0) {
                    valid = false;
                    break;
                }

            }
            if (valid) {
                res.add(i);
            }

        }
        return res;

    }

    /**
     * 另一种写法 可能要快一点
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            while (j != 0) {
                if (j % 10 == 0 || i % (j % 10) != 0) {
                    break;
                } else {
                    j /= 10;
                }
            }
            if (j == 0) {
                res.add(i);
            }
        }
        return res;

    }
}
