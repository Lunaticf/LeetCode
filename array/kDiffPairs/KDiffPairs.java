package leetCode.array.kDiffPairs;

import java.util.HashMap;

/**
 * @Author Lunaticf
 * @Date 2019/10/15
 */
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        // 记录频度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;

        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
