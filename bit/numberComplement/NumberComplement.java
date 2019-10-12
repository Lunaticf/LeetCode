package leetCode.bit.numberComplement;

public class NumberComplement {
    public int findComplement(int num) {
        char[] c = Integer.toBinaryString(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') {
                c[i] = '1';
            } else {
                c[i] = '0';
            }
        }

        return Integer.valueOf(new String(c), 2);
    }

    /**
     * one line
     * 都不知道还有highestOneBit
     * @param num
     * @return
     */
    public int findComplement1(int num) {
        return (Integer.highestOneBit(num) << 1) - 1 ^ num;
    }

    /**
     * 自己做mask 不用highestOneBit
     * 注意num是正数
     * @param num
     * @return
     */
    public int findComplement2(int num) {
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) + 1;
        }
        return mask ^ num;
    }
}
