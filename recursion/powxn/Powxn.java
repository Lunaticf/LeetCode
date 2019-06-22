package LeetCode.recursion.powxn;

public class Powxn {

    // java builtin
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }


    // iteration TLE
    public double myPow1(double x, int n) {
        int offset = n > 0 ? -1 : 1;
        double res = 1;
        while (n != 0) {
            res *= x;
            n += offset;
        }
        return offset == -1 ? res : 1 / res;
    }

    // recursion
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x *= x;
            } else {
                n = -n;
            }
            x = 1/x;
        }

        double y = myPow2(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }


    // iteration
    public double myPow3(double x, int n) {
        if (n == 0) return 1;
        double res = 1;

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x *= x;
            } else {
                n = -n;
            }
            x = 1/x;
        }

        while (n != 0) {
            if ((n & 1) == 1) res *= x;
            n >>= 1;
            x *= x;
        }

        return res;
    }
}
