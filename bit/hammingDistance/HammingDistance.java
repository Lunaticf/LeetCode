package leetCode.bit.hammingDistance;

/**
 * @Author Lunaticf
 * @Date 2019/10/12
 */
public class HammingDistance {
    // 计算两个数字对应的哪些位不同
    // 那不就是异或嘛
    public int hammingDistance(int x, int y) {
        // 计算两个数字对应的哪些位不同
        // 那不就是异或嘛
        int num = x ^ y;
        return Integer.bitCount(num);
    }

    // 不用bitCount
    // x y >= 0
    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
