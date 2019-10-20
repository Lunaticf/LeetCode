package leetCode.array.maximumAverageSubarrayI;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        new MaximumAverageSubarrayI().findMaxAverage1(new int[]{1,12,-5,-6,50,3}, 4);
    }

    /**
     * brute force 超时了
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        // 找到具有最大平均值的子数组 长度为k
        // 等价于找具有最大和的子数组

        // brute force
        double max = -Double.MAX_VALUE;
        for (int i = 0; i + k <= nums.length; i+=1) {
            double temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += nums[j];
            }
            max = Math.max(temp/k, max);
        }
        return max;
    }

    /**
     * 累加和 每次不用重新遍历相加
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage1(int[] nums, int k) {
        double sum = 0;

        if (nums.length < k) {
            return 0;
        }

        int i;
        // 定位到第一个k段的最后一个元素
        for (i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;

        for (; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max / k;
    }

    // 事先算好累加和
    public double findMaxAverage2(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        double res = sums[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sums[i] - sums[i - k]) * 1.0 / k);
        }
        return res;
    }
}
