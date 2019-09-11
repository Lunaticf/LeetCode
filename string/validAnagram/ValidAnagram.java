package leetCode.string.validAnagram;

import java.util.Arrays;

/**
 * @Author Lunaticf
 * @Date 2019/9/11
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
          count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 稍微优化一下 会提高效率 提前判断不满足
    public boolean isAnagram1(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // 如果count中存在>0的项，那么肯定t的长度要大于s的长度
        return s.length() == t.length();
    }

    // sort也可以 但是时间复杂度O(nlogn)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
