package leetCode.dynamicProgramming.perfectSquares;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            int temp = 1;
            while (i - temp * temp >= 0) {
                dp[i] = Math.min(dp[i], dp[i - temp * temp] + 1);
                temp += 1;
            }
        }
        return dp[n];
    }
}
