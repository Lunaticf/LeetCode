package LeetCode.array.majorityElement;

import java.util.Arrays;

public class MajorityElement {
    // sort
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement(int[] nums) {
          int count = 0;
          Integer candidate = null;
          for (int num : nums) {
              if (count == 0) {
                  candidate = num;
              }
              count += (num == candidate) ? 1 : -1;
          }
          return candidate;
    }
}
