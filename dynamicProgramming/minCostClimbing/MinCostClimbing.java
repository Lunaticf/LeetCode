package leetCode.dynamicProgramming.minCostClimbing;

/**
 * @Author Lunaticf
 * @Date 2019/10/23
 */
public class MinCostClimbing {
    public int minCostClimbingStairs(int[] cost) {
        // dp
        // f[i] = Math.min(f[i - 1], f[i - 2]) + cost[i]
        // 注意 这里指的是要到达最后一个元素的后一个位置才叫top of the floor
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length -2]);
    }

}
