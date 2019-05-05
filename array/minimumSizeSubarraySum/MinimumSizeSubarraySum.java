package LeetCode.array.minimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen1(s, nums));
    }

    // 暴力解法 only beat 12% but not TLE
    public int minSubArrayLen(int s, int[] nums) {
        // 如果整个数组的和都不大于等于s, 无解
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < s) {
            return 0;
        } else {
            int res = nums.length;
            for(int i = 0; i < nums.length; i++) {
                int subArraySum = 0;
                for (int j = i; j < nums.length; j++) {
                    subArraySum += nums[j];
                    if (subArraySum >= s) {
                        res = (j - i + 1) < res ? j - i + 1: res;
                        break;
                    }
                }

            }
            return res;
        }
    }

    // 二分查找方法
    public int minSubArrayLen1(int s, int[] nums) {
        // 先记录子数组和
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int end = lowerBound(i + 1, sums.length, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < res) res = end - i;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int lowerBound(int low, int high, int s, int[] sums) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (sums[mid] < s) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // 滑动窗口法
    public int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
