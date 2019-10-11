package leetCode.greedy.assignCookies;

import java.util.Arrays;

/**
 * @Author Lunaticf
 * @Date 2019/10/11
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        // 每个孩子只能不超过1个cookie
        // g为孩子 s为cookie
        // 贪心 对于每一个cookie
        Arrays.sort(g);
        Arrays.sort(s);

        int childPos = 0;

        for (int i = 0; i < s.length && childPos < g.length; i++) {
             if (s[i] >= g[childPos]) {
                 childPos++;
             }
        }
        return childPos;
    }
}
