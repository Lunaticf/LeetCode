package leetCode.hashTable.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>(nums.length);
        for (int num : nums) {
            if (s.contains(num)) {
                return true;
            }
            s.add(num);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        return nums.length > s.size();

        /// we have java8!
        // return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
