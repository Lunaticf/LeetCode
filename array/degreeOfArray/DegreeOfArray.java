package leetCode.array.degreeOfArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lunaticf
 * @Date 2019/10/22
 */
public class DegreeOfArray {
    /**
     * 大概是O(N^2)
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
                list.clear();
                list.add(key);
            } else if (value == max)  {
                list.add(key);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int num : list) {

            int i =0;
            int j = nums.length - 1;
            while (i < nums.length && nums[i] != num) {
                i++;
            }
            while (j > 0 && nums[j] != num) {
                j--;
            }
            res = Math.min(res, j - i + 1);
        }
        return res;
    }

    /**
     * 简化版
     * @param nums
     * @return
     */
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        // 保存第一次出现的索引
        Map<Integer, Integer> first = new HashMap<>();

        int res = 0;
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
