package leetCode.bit.alternatingBits;

/**
 * @Author Lunaticf
 * @Date 2019/10/22
 */
public class AlternatingBits {
    /**
     * 复杂度O(1) 因为对于任意的输入 都是32位的遍历
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * bit有巨多种做法
     * 1 0 1 0 n
     * 0 1 0 1 n >> 1
     * 1 1 1 1 n ^ n >> 1
     * 0 0 0 0 (n ^ n >> 1) & (n + 1) == 0
     */
    public boolean hasAlternatingBits1(int n) {
        n =  n ^ (n >> 1);
        return (n & n + 1) == 0;
    }
}
