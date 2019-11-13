package leetCode.dynamicProgramming;

public class LongestPalindrome {
    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("babad");
    }

    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            expand(i, i, s);
            expand(i, i+1, s);
        }
        return s.substring(start, end + 1);
    }

    // 向两边expand
    private void expand(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        // 这里其实i,j已经不符合条件了

        if ((j - i) > (end - start)) {
            start = i;
            end = j;
        }
    }

    /**
     * dp
     * 想想暴力的时候，我们判断每个子串，其实有大量重复计算
     * abbca 判断abbca是否是子串 其实bbca我们已经计算过了可能
     * 如果正向计算，abbc的时候要看bb是否是回文，但是此时bb还没计算
     * 所以反向算，bbca的时候算bc已经算过了
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();

        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if ( i == j ) {
                    dp[i][j] = true;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    // 两个字符的case
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && (j-i) > (end - start)) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
