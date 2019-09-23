package leetCode.math.nimGame;

/**
 * @Author Lunaticf
 * @Date 2019/9/23
 */
public class NimGame {
    public static void main(String[] args) {
        new NimGame().canWinNim(80);
    }

    /**
     * 惨遭TLE
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        //dp[i]表示先手的结果
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
        }
//        for (int i = 1;i <=n; i++) {
//            System.out.print(i+" " +dp[i] + "-");
//        }
        return dp[n];
    }

    /**
     * trick %4==0
     * @param n
     * @return
     */
    public boolean canWinNim1(int n) {
        return n % 4 != 0;
//        return (n & 3) != 0;  // 或者位运算
    }

}
