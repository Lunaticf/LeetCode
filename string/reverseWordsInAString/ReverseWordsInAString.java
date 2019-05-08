package LeetCode.string.reverseWordsInAString;


import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.print("\"");
        System.out.print(new ReverseWordsInAString().reverseWords1("the sky is blue"));
        System.out.print("\"");
    }

    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            // 如果是空格
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            while (i < s.length() && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i++;
            }

            if (temp.length() != 0) {
                res.insert(0, " ").insert(0, temp);
                temp = new StringBuilder();
            }
        }

        if (res.length() > 0) {
            res.setLength(res.length() - 1);
        }

        return res.toString();
    }

    // refine 更加简洁更加好的写法
    public String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;
            int wordEnd = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, wordEnd + 1)).append(" ");
        }
        return res.toString().trim();
    }

    // 用正则
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
