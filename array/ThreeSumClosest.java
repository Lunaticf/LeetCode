package leetCode.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i + 1;
            int q = nums.length - 1;

            while (p < q) {
                int temp = nums[p] + nums[q] + nums[i];
                if (temp == target) {
                    return target;
                } else if (temp > target) {
                    q--;
                } else {
                    p++;
                }
                if (Math.abs(temp - target) < Math.abs(target - res)) {
                    res = temp;
                }
            }
        }
        return res;
    }

}
