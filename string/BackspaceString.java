package leetCode.string;

import java.util.Stack;

public class BackspaceString {
    /**
         模拟字符串中有backspace字符，看最后的字符串是否一样
         感觉用栈比较方便

        学到了另一个StringBuilder是没有覆盖equals方法的

     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c: S.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }

        for (char c: T.toCharArray()) {
            if (c == '#') {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }

        StringBuilder s1 = new StringBuilder();
        while (!stack1.empty()) {
            s1.append(stack1.pop());
        }

        StringBuilder s2 = new StringBuilder();
        while (!stack2.empty()) {
            s2.append(stack2.pop());
        }

        return s1.toString().equals(s2.toString());
    }

    /**
     * 或者双指针 写起来麻烦点 但是空间复杂度降到O(1)
     * 注意这里正着写很难写 应该倒着遍历就很舒服
     * 因为正着的时候你不知道未来会有几个backspace 当前字符是否有效
     * 这个方法很巧妙 genius
     * When writing a character, it may or may not be part of the final string
     * depending on how many backspace keystrokes occur in the future.
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        int back1 = 0;
        int back2 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    back1++;
                    i--;
                } else {
                    if (back1 > 0) {
                        back1--;
                        i--;
                    } else {
                        break;
                    }
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    back2++;
                    j--;
                } else {
                    if (back2 > 0) {
                        back2--;
                        j--;
                    } else {
                        break;
                    }
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            if (i >= 0 && j < 0) {
                return false;
            }

            if (i < 0 && j >= 0) {
                return false;
            }

            i--;j--;
        }

        return true;
    }

    public static void main(String[] args) {
        new BackspaceString().backspaceCompare1("bbbextm",
                "bbb#extm");
    }
}
