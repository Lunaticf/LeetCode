package LeetCode.dynamicProgramming.maximumSubarray;

public class MaximumSubarray {
    // brute force
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                res = Math.max(temp, res);
            }
        }
        return res;
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
