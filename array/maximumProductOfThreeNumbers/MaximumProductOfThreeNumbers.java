package leetCode.array.maximumProductOfThreeNumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        new MaximumProductOfThreeNumbers().maximumProduct(new int[]{-4,-3,-2,-1,60});
    }

    /**
     * O(NLogN)
     * 要记录最大的3个和最小的2个
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> poheap = new PriorityQueue<>();
        PriorityQueue<Integer> neheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            poheap.offer(num);
            neheap.offer(num);
            if (poheap.size() > 3) {
                poheap.poll();
            }
            if (neheap.size() > 2) {
                neheap.poll();
            }
        }
        int c1 = 1;
        int max = 0;
        while (!poheap.isEmpty()) {
            max = poheap.poll();
            c1 *= max;
        }
        while (!neheap.isEmpty()) {
            max *= neheap.poll();
        }
        return Math.max(c1, max);
    }

    /**
     * O(NlogN)
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums) {
        // 找到最大的三个数相乘的结果
        // 有负数...
        // 题目保证不会超过int范围

        Arrays.sort(nums);
        int n = nums.length - 1;

        return Math.max(nums[0] * nums[1] * nums[n], nums[n] * nums[n - 1] * nums[n - 2]);
    }

    /**
     * brute force O(n^3)
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, nums[i] * nums[j] * nums[k]);
                }
            }
        }
        return max;
    }
}
