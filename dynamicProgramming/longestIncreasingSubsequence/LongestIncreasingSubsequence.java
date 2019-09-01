package leetCode.dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // dp
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = maxVal + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 最优的O(NlogN)
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int len = 0;
        tails[len++] = nums[0];
        for (int num : nums) {
            if (num > tails[len - 1]) {
                tails[len++] = num;
            } else {
                int pos = Arrays.binarySearch(tails, 0, len, num);
                if (pos < 0 ) pos = -(pos + 1);
                tails[pos] = num;
            }
        }
        return len;
    }


}
