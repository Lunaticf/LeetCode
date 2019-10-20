package leetCode.math.sumOfSquareNumbers;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i * i <= c; i++) {
            for (int j = 0; j * j <= c; j++) {
                if (i * i + j * j == c) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * just check the remain is a integer
      * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        for (int i = 0; i * i <= c; i++) {
            double remain = Math.sqrt(c - i * i);
            if (remain == (int)remain) {
                return true;
            }
        }
        return false;
    }

    /**
     * two pointer
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        int a = 0;
        int b = (int)Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur == c) {
                return true;
            }
            if (cur > c) {
                b--;
            }
            if (cur < c) {
                a++;
            }
        }
        return false;
    }
}
