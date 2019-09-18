package leetCode.string.reverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Lunaticf
 * @Date 2019/9/18
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'o', 'i', 'u'));

        int i = 0;
        int j = s.length() - 1;

        char[] cs = s.toCharArray();

        while (i < j) {
            while (i < j && !set.contains(Character.toLowerCase(cs[i]))) {
                i++;
            }

            while (i < j && !set.contains(Character.toLowerCase(cs[j]))) {
                j--;
            }

            if (i < j) {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
            }
            i++;
            j--;
        }

        return new String(cs);

    }
}
