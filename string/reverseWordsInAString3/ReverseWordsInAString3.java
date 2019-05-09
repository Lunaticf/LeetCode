package LeetCode.string.reverseWordsInAString3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString3 {
    private String reverseWord(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            i++;j--;
        }
        return new String(cs);
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }


    public String reverseWords1(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ' ') {
                int start = i;
                while (i < cs.length && cs[i] != ' ') {
                    i++;
                }
                int end = i - 1;
                while (start < end) {
                    char temp = cs[start];
                    cs[start] = cs[end];
                    cs[end] = temp;
                    start++;end--;
                }
            }
        }
        return new String(cs);
    }

    public String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.insert(0, c);
            } else {
                res.append(word);
                res.append(c);
                word.setLength(0);
            }
        }
        res.append(word);
        return res.toString();
    }
}
