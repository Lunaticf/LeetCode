package leetCode.math.powerOfFour;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        int count = 0;
        // 判断0, 2, 4 index是否有一个1
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0 && ((num & 1) == 1)) {
                count += 1;
            } else {
                if ((num & 1) == 1) {
                    return false;
                }
            }
            num = num >> 1;
        }
        return count == 1;
    }

    public boolean isPowerOfFour1(int num) {
        // 前面判断只有一个1 后面判断1的位置
        // 4的次方跟1010101010101010101010101010101与一定不是0
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;

        // 很多种方法
//        return (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
        // 或者判断1后面跟的0是不是偶数个
//        return Integer.bitCount(num) == 1 && Integer.toBinaryString(num).length() % 2 == 1;
    }
}
