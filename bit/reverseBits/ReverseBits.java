package leetCode.bit.reverseBits;

/**
 * @Author Lunaticf
 * @Date 2019/9/5
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(-3));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 把n转换为字符串
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        while (s.length() < 32) {
            s.insert(0, 0);
        }
//        return Integer.parseInt(s.reverse().toString(), 2); error
        return Integer.parseUnsignedInt(s.reverse().toString(), 2);
//        return (int)Long.parseLong(s.reverse().toString(),2); 也可
    }

    /**
     * 移位操作 正解
     */
    public int reverseBits1(int n) {
        int res = 0;
        // while (n != 0) {
        // 注意这里不能用while 因为假如n前面都是0 如0000101，res只移位了几次，后面的0没补上。
        for (int i = 0; i < 32; i++) {
            // 保存最后一位
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }

}
