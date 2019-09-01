package leetCode.array.bestTimeToBuyAndSellStock2;

public class BestTimeToBuyAndSellStock2 {
    // 找到波峰波谷图每一次的上升段
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int i = 0;
        int n = prices.length;
        int total = 0;
        while (i < n - 1) {
            // 找到波谷
            while (i < n - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int low = prices[i];

            // 找到波峰
            while (i < n - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            int high = prices[i];
            //
            total += high - low;
        }
        return total;
    }

    // 其实与第一种写法是等价的
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;

        // 最差是0
        int total = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
