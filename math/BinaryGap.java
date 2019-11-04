package leetCode.math;

public class BinaryGap {
    public static void main(String[] args) {
        new BinaryGap().binaryGap(12);
    }

    public int binaryGap(int N) {
        int res = 0;
        // count设置这样可以处理碰到第一个1的操作
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < 32; i++) {
            // 判断最后一位是1
            if ((N & 1) == 1) {
                res = Math.max(count, res);
                count = 0;
            }
            count++;
            N >>= 1;
        }
        return res;
    }

    public int binaryGap1(int N) {
        // check只有一个1的情况
        if ((N & (N - 1)) == 0) {
            return 0;
        }

        // 算1和1之间的最大距离
        String s = Integer.toBinaryString(N);
        int res = -1;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                if (prev != -1) {
                    res = Math.max(res, i - prev);
                }
                prev = i;
            }
        }
        return res;
    }
}
