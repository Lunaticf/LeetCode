package LeetCode.backtracking.restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

        public List<String> restoreIpAddresses (String s){
            List<String> res = new ArrayList<>();

            if (s.length() < 4 || s.length() > 12) return res;
            dfs(res, s, "", 0);
            return res;
        }

        // 递归定义
        // s 还剩下的字符串 cs 当前拼接的字符串 segment 已经组成了几个段
        private void dfs (List<String> res, String s, String cs,int segment){
            // 出口
            if (s.length() == 0 && segment == 4) {
                res.add(cs.substring(1));
            }
            if (s.length() == 0 || segment == 4) return;

            // go
            // 一位数的情况
            dfs(res, s.substring(1), cs + "." + s.charAt(0), segment + 1);
            if (s.charAt(0) != '0' && s.length() > 1) {
                dfs(res, s.substring(2), cs + "." + s.substring(0, 2), segment + 1);
                // 三位数的情况
                if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                    dfs(res, s.substring(3), cs + "." + s.substring(0, 3), segment + 1);
                }
            }
        }
}
