package LeetCode.math.sqrtX;


public class SqrtX {

    //tle
    public int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            // i * i will overflow
            if (i < Integer.MAX_VALUE / i && i * i > x) {
                return i - 1;
            }
        }
        return x;
    }
}
