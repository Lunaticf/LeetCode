package leetCode.math.arrangeCoins;

public class ArrangeCoins{
    /**
     * 模拟
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        while (true) {
            n -= i;
            i += 1;
            if (n >= 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * (x + 1) * x / 2 = n
     * x = (-1 + sqrt(8 * n + 1)) / 2
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
