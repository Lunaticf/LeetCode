package leetCode.hashTable.setMismatch;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    /**
     * O(N)
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        // 最初包含1-n
        // 有一个数字重复了
        int[] res = new int[2];

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            if (set.contains(num)) {
                res[0] = num;
                continue;
            }
            set.add(num);
            sum += num;
        }

        res[1] = (1 + nums.length) * nums.length / 2 - sum;
        return res;
    }

    public int[] findErrorNums1(int[] nums) {
        int[] res = new int[2];

        // 1,2,2,4
        // 1,
        for (int num : nums) {
            // 因为碰到的数有可能已经被标成负数了
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            } else {
                // 如果已经碰到过
                res[0] = Math.abs(num);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                res[1] = i;
            }
        }

        return res;
    }
}
