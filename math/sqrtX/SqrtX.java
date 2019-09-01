package leetCode.math.sqrtX;


public class SqrtX {
    // brute force 用long解决溢出 15ms
    public int mySqrt(int x) {
        if (x < 2) return x;
        for (long s = 1; s <= x; s++) {
            if (s * s > x) {
                return (int)s - 1;
            }
        }
        return -1;
    }

    // brute force 用除法解决溢出 69ms
    public int mySqrt1(int x) {
        if (x < 2) return x;
        for (int s = 1; s <= x; s++) {
            if (s > x / s) {
                return s - 1;
            }
        }
        return -1;
    }

    // binary search
    public int mySqrt2(int x) {
        if (x < 2) return x;
        int l = 1, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    // 牛顿迭代法
    public int mySqrt3(int x) {
        long p = x;
        while (p * p > x)
            p = (x + p / x) / 2;
        return (int)x;
    }

}
