package LeetCode.array.bestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
    // O(N^2)
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    // O(N)
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int res = 0;
        int minPirce = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(prices[i] - minPirce, res);
            minPirce = Math.min(minPirce, prices[i]);
        }
        return res;
    }

    // 转化为最大子数组
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] gain = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            gain[i - 1] = prices[i] - prices[i - 1];
        }
        return Math.max(0, maxSubArray(gain));
    }

    //  dp[i]表示以i结尾的最大子数组和
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp > 0 ? nums[i] + temp : nums[i];
            res = Math.max(res, temp);
        }
        return res;
    }
}