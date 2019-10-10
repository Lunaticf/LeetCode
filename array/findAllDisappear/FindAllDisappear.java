package leetCode.array.findAllDisappear;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDisappear {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // 不停地试图调换到正确的位置

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                // 如果该位置已经正确 不调换
                if (nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;

    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {

        // 可以用set判断已经存在的元素
        // O(N) 空间O(N)
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
