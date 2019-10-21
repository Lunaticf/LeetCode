package leetCode.greedy.validPalindrome2;

/**
 * @Author Lunaticf
 * @Date 2019/10/21
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        // 是否删去一个字符能成为回文串
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;r--;
            } else {
                return helper(s, l, r - 1) || helper(s, l + 1, r);
            }
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;r--;
            }
        }
        return true;
    }
}
