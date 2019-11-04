package leetCode.string;

import java.util.HashSet;
import java.util.Set;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        // 暴力自然会超时
        // 仔细思考
        // 1. 首先两个串得长度相同
        // 2. 如果两个串相同，A得有两个字母相同，就可以替换得到B
        // 3. 如果两个串不相同，A与B必须是 abc acb的情况 只有两个字母不相同

        if (A.length() != B.length()) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        if (A.equals(B)) {
            for (char c : A.toCharArray()) {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
            return false;
        }

        // 两个串不相同
        char a1 = ' ', a2 = ' ';
        char b1 = ' ', b2 = ' ';
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    a1 = A.charAt(i);
                    b1 = B.charAt(i);
                } else if (count == 1) {
                    a2 = A.charAt(i);
                    b2 = B.charAt(i);
                } else {
                    return false;
                }
                count++;
            }
        }


        return a1 == b2 && a2 == b1;
    }
}
