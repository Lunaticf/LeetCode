package leetCode.bit.powerOfTwo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Lunaticf
 * @Date 2019/9/16
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while ((n & 1) != 1) {
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
       return n > 0 && (n & n - 1) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo3(int n) {
        return new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824)).contains(n);
    }

    public boolean isPowerOfTwo4(int n) {
        if (n == 0) {return  false;}
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
