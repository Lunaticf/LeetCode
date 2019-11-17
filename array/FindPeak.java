package leetCode.array;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        // 找到山峰元素 (存在多个)
        // 难点在于要对数复杂度
        // 注意nums[-1]和nums[n]也算
        // 问题就在于左右两边是一个深渊
        // 仔细想想 沿着较大的元素走一定有峰值
        // 神奇的一题
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // 我们往右边走
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                // 往左边走
                r = mid;
            }
            // 注意不需要处理相等的情况 因为没有重复元素
        }
        return l;
    }
}
