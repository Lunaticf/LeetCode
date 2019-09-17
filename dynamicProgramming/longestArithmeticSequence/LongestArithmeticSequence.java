package leetCode.dynamicProgramming.longestArithmeticSequence;

import java.util.HashMap;

/**
 * @Author Lunaticf
 * @Date 2019/9/17
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int res = 2;

        HashMap<Integer, Integer>[] dp = new HashMap[A.length];

        // 初始化
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>(16);
        }

        // 从1开始
        for (int i = 1; i < A.length; i++) {
            // 必须从0到i 不能反过来 否则会覆盖值 或者用max
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }

        return res;
    }
}
