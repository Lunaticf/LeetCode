package leetCode.math.reverseInteger;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int oldRes = 0;
        while (x != 0) {
            res = oldRes * 10 + x%10;
            // check是否溢出
            if ((res - x % 10)/10 != oldRes) {
                return 0;
            }
            oldRes = res;
            x/=10;
        }
        return res;
    }

    public int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x%10;
            x/=10;
        }
        return (int)res == res? (int)res : 0;
    }
}
