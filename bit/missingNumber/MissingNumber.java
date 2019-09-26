package leetCode.bit.missingNumber;

import java.util.Arrays;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class MissingNumber {

    // gauss
    public int missingNumber(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }

    // gauss 防止溢出
    public int missingNumber2(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += i + 1 - nums[i];
        }

        return res;
    }

    // bit
    public int missingNumber3(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }

        return res;
    }



    // sort
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                return nums[i] - 1;
            }
        }
        return -1;
    }
}
