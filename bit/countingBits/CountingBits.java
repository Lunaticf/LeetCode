package LeetCode.bit.countingBits;

public class CountingBits {
    // 最优做法
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i/2] + (i & 1);
        }
        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = getOneBits(i);
        }
        return res;
    }

    private int getOneBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }

}
