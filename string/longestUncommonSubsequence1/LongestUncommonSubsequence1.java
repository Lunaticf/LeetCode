package LeetCode.string.longestUncommonSubsequence1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LongestUncommonSubsequence1 {
    public int findLUSlength(String a, String b) {
        // a == b
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

    public int findLUSlength1(String a, String b) {
        // 生成两个2^n的序列
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();


        for (int i = 0; i < (1 << a.length()); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < a.length(); j++) {
                if (((i >> j) & 1) != 0) {
                    sb.append(a.charAt(j));
                }
            }
            set1.add(sb.toString());
        }

        for (int i = 0; i < (1 << b.length()); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b.length(); j++) {
                if (((i >> j) & 1) != 0) {
                    sb.append(b.charAt(j));
                }
            }
            set2.add(sb.toString());
        }

        Iterator it = set1.iterator();
        int res = -1;
        while (it.hasNext()) {
            String s = (String)it.next();
            if (!set2.contains(s)) {
                res = Math.max(res, s.length());
            }
        }

        it = set2.iterator();
        while (it.hasNext()) {
            String s = (String)it.next();
            if (!set1.contains(s)) {
                res = Math.max(res, s.length());
            }
        }

        return res;
    }

}
