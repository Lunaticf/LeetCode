package LeetCode.array.largestNumberAtLeastTwiceofOthers;

public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1};
        System.out.println(new LargestNumberAtLeastTwiceofOthers().dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int maxNumIdx = 0;
        int secondLargestNumIdx = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxNumIdx]) {
                secondLargestNumIdx = maxNumIdx;
                maxNumIdx = i;
            } else if (secondLargestNumIdx == -1 || nums[i] > nums[secondLargestNumIdx]) {
                secondLargestNumIdx = i;
            }
        }

        return nums[maxNumIdx] >= nums[secondLargestNumIdx] * 2 ? maxNumIdx : -1;
    }
}
