package leetCode.string.repeatedSubStringPattern;

/**
 * @Author Lunaticf
 * @Date 2019/10/11
 */
public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        new RepeatedSubStringPattern().repeatedSubstringPattern("abab");
    }

    public boolean repeatedSubstringPattern(String s) {
        // 从1到一半字符串的长度 check是否符合
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                if (check(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String s, int i) {
        String prev = s.substring(0, i);
        for (int j = i; j < s.length(); j += i) {
            if (!s.substring(j, j + i).equals(prev)) {
                return false;
            }
        }
        return true;
    }
}
