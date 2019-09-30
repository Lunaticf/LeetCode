package leetCode.string.isSubsequence;

/**
 * @Author Lunaticf
 * @Date 2019/9/30
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = t.indexOf(s.charAt(i), pos);
            if ( temp == -1) {
                return false;
            }
            pos = temp + 1;
        }
        return true;
    }

    // two pointer
    public boolean isSubsequence1(String s, String t) {
        if (s.equals("")) {
            return true;
        }

        int target = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(target)) {
                if (target == s.length() - 1) return true;
                target++;
            }
        }
        return false;
    }
}
