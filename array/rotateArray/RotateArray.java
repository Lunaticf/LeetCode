package leetCode.array.rotateArray;

import java.util.Arrays;

public class RotateArray {
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }

    // 1. 转置法
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    // 2. 赋值法
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int copy[] = new int[len];
        copy = Arrays.copyOf(nums, len);

        for (int i = 0; i < len; i++) {
            nums[(i + k) % len] = copy[i];
        }
    }
}
