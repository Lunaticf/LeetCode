package leetCode.math.divisorGame;

public class DivisorGame {
    public boolean divisorGame(int N) {
        return (N % 2 == 0);
    }

    // dp
    public boolean divisorGame1(int N) {
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                // 如果有一个位置让下一个位置是false的话
                if (i % j == 0 && !dp[i-j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
}
