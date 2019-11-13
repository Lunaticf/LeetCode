package leetCode.string;

import java.util.Stack;

/**
 * @Author Lunaticf
 * @Date 2019/11/7
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;

        char[] ca = S.toCharArray();
        while (i < j) {
            while (i < ca.length && !Character.isLetter(ca[i])) {
                i++;
            }
            while (j >=0 && !Character.isLetter(ca[j])) {
                j--;
            }

            if (i < j) {
                char c = ca[i];
                ca[i] = ca[j];
                ca[j] = c;
                i++;j--;
            }

        }
        return String.valueOf(ca);
    }

    /**
     * 栈的做法也蛮不错的 我喜欢
     * @param S
     * @return
     */
    public String reverseOnlyLetters1(String S) {
        Stack<Character> s = new Stack<>();

        char[] ca = S.toCharArray();

        for (char c : ca) {
            if (Character.isLetter(c)) {
                s.push(c);
            }
        }

        for (int i = 0; i < ca.length; i++) {
            if (Character.isLetter(ca[i])) {
                ca[i] = s.pop();
            }
        }

        return String.valueOf(ca);
    }
}
