package LeetCode.dynamicProgramming.wordBreak;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    // TLE
    public boolean wordBreak(String s, List<String> wordDict) {
        // corner case
        if (wordDict.size() == 0 || s.length() == 0) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        return dfs(s, wordDict,set);
    }

    // 递归定义
    private boolean dfs(String remainS,  List<String> wordDict, HashSet<String> set) {
        // 出口
        if (remainS.length() == 0) return true;

        // go
        // 去拿wordDict里面的字符串长度来切分
        boolean res = false;
        for (String word : wordDict) {
            // 同时要判断子串是否在wordDict中
            if (remainS.length() >= word.length() && set.contains(remainS.substring(0, word.length()))) {
                res = res || dfs(remainS.substring(word.length()), wordDict,set);
            }

        }
        return res;
    }

    // dfs
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        boolean[] computed = new boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);

        return recur(s, dp, set, s.length() - 1,computed, wordDict);
    }

    // 自顶向下递推
    private boolean recur(String s, boolean[] dp, HashSet<String> set, int i, boolean[] computed, List<String> wordDict) {
        if (i == -1) {
            return true;
        }

        // if computed before
        if (computed[i]) {
            return dp[i];
        }

        // 递推
        boolean res = false;
        for (String word : wordDict) {
            if (i - word.length() >= -1 && set.contains(s.substring(i - word.length() + 1, i + 1)) ) {
                res = res || recur(s, dp, set, i - word.length(), computed, wordDict);
            }
        }

        dp[i] = res;
        computed[i] = true;
        return res;
    }

    // dp1
    public boolean wordBreak2(String s, List<String> wordDict) {
        // 假设dp[i]代表到i-1位置能否wordBreak比较方便
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            // 对于每个位置来说 后退一个单词看看
            for (String word : wordDict) {
                if (i >= word.length()) {
                    if (word.equals(s.substring(i - word.length(), i))) {
                        if (dp[i - word.length()]) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[s.length()];

    }

    // dp2
    public boolean wordBreak3(String s, List<String> wordDict) {
        // dp[i]表示到i-1位置的是否能break
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet set = new HashSet(wordDict);
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
