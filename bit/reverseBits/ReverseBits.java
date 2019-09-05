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
        return (int)Long.parseLong(s.reverse().toString(),2);
    }

}
