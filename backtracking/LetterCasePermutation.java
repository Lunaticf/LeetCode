package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/10/30
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();

        dfs(S, res, 0, "");

        return res;
    }

    public void dfs(String s, List<String> res, int i, String cur) {
        if (i == s.length()) {
            res.add(cur);
            return;
        }

        // 学到了char^(1<<5)可以翻转大小写...就是把第6位翻转  + 32 - 32
        if (s.charAt(i) <= 'z' && s.charAt(i) >=
                'a') {
            dfs(s, res, i + 1, cur + Character.toUpperCase(s.charAt(i)));
        } else if (s.charAt(i) <= 'Z' && s.charAt(i) >=
                'A'){
            dfs(s, res, i + 1, cur + Character.toLowerCase(s.charAt(i)));
        }
        dfs(s, res, i + 1, cur + s.charAt(i));
    }
}
