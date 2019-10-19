package leetCode.hashTable.longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        // 和谐数组定义为最大数和最小数正好相差1
        // 找到最长的和谐子序列 (subsequence是可以不连续的子序列)
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int num : map.keySet()) {
            int temp = map.get(num);
            // 不用同时检查 num + 1 和 num - 1
            res = Math.max(res, map.getOrDefault(num + 1, -temp) + temp);
        }
        return res;
    }

}
