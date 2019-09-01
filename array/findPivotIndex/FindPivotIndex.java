package leetCode.array.findPivotIndex;

public class FindPivotIndex {

    // brute force
    public int pivotIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int p = 0; p < i; p++) {
                leftSum += nums[p];
            }
            int rightSum = 0;
            for (int q = i + 1; q < nums.length; q++) {
                rightSum += nums[q];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    // optimization
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
