package leetCode.math.powerOfThree;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class PowerOfThree {
    public static void main(String[] args) {
        new PowerOfThree().isPowerOfThree3(19);
    }

    // 常规做法
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n/=3;
        }
        return n == 1;
    }

    // 转换成三进制
    public boolean isPowerOfThree1(int n) {
        // 字符串用1开头，并跟着任意多个0 不包含其他$
        return Integer.toString(n, 3).matches("^10*$");
    }


    public boolean isPowerOfThree2(int n) {
        // 判断double是不是整数 可能有精度问题
        return (Math.log10(n)/Math.log10(3)) % 1 == 0;
    }


    // int能表示的最大的3次方的数为3^log3maxInt = 3^19 = 1162261467
    public boolean isPowerOfThree3(int n) {
        int maxPow = (int)Math.floor(Math.log(Integer.MAX_VALUE)/Math.log(3));
//        System.out.println(maxPow);
//        System.out.println((int)Math.pow(3, maxPow));

        return n > 0 && Math.pow(3, maxPow) % n == 0;
    }
}
