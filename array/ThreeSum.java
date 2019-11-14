package leetCode.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Leetcode超经典的题呀
        // 找到所有的三个元素的组合 相加为0
        // 下面方法应该是O(N^2)

        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            int p = i + 1;
            int q = nums.length - 1;

            int target = -nums[i];
            while (p < q) {
                int sum = nums[p] + nums[q];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    p++;q--;
                } else if (sum > target) {
                    q--;
                } else {
                    p++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
