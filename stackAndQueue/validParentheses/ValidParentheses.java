package leetCode.stackAndQueue.validParentheses;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        int i = 0;
        HashMap map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
            i++;
        }
        return stack.empty();
    }

    // 评论区一个牛的写法
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
