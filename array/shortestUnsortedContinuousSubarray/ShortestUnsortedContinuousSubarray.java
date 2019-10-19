package leetCode.array.shortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray1(nums));
    }

    /**
     * O(NlogN)
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int i = 0;
        while (i < nums.length && nums[i] == newNums[i]) {
            i++;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] == newNums[j]) {
            j--;
        }

        return j > i ? j - i + 1 : 0;
    }

    /**
     * O(N) I am so dumb...绝妙的做法
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
}
