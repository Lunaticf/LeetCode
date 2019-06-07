package LeetCode.hashTable.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("pwwkew");
        System.out.println(res);
    }

    // brute force beat 14%
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            HashSet hashSet = new HashSet();
            hashSet.add(s.charAt(i));
            while (j < s.length()) {
                if (hashSet.contains(s.charAt(j))) break;
                hashSet.add(s.charAt(j));
                res = j - i + 1 > res? j - i + 1: res;
                j++;
            }
        }
        return res;
    }

    // 优化 从下一次开头开始找的时候利用上一次遍历到的位置
    // 所以要记住上一次的位置 beat 50%
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        int res = 1;
        int j = 0;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (hashSet.contains(s.charAt(j))) {
                    hashSet.remove(s.charAt(i));
                    break;
                }
                hashSet.add(s.charAt(j));
                res = j - i + 1 > res? j - i + 1: res;
                j++;
            }

        }
        return res;
    }

    // two pointer 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int j = 0;
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (j < s.length()) {
            // 如果找到重复字符
            if (hashSet.contains(s.charAt(j))) {
                hashSet.remove(s.charAt(i));
                i++;
            } else {
                hashSet.add(s.charAt(j));
                res = j - i + 1 > res ? j - i + 1 : res;
                j++;
            }
        }
        return res;
    }

    // 用数组代替hashset 更快 beat 99%;
    public int lengthOfLongestSubstring3(String s) {
        int i = 0, j = 0, res =0;
        boolean[] hash = new boolean[128];
        char[] ca = s.toCharArray();
        int len = s.length();
        while (j < len) {
            // 如果找到重复字符
            if (hash[ca[j]]) {
                hash[ca[i++]] = false;
            } else {
                hash[ca[j++]] = true;
                res = j - i > res ? j - i : res;
            }
        }
        return res;
    }


    // 滑动窗口更优化的版本
    // 碰到j字符重复的时候,i不用只+1,而是可以移动到j重复的位置
    // 比如abcdeca j到c的时候,i不用移动到b,而是可以移动到d
    public int lengthOfLongestSubstring4(String s) {
        int i = 0, j = 0, res = 0;
        int[] record = new int[128];
        char[] ca = s.toCharArray();
        while (j < ca.length) {
            // 不用判断是否重复 若是重复字符 更新了i,若不重复,record[ca[j]]必然没有i大
            i = Math.max(record[ca[j]], i);
            res = Math.max(res, j - i + 1);
            // 更新当前碰到的字符的索引
            record[ca[j]] = j + 1;
            j++;
        }
        return res;
    }
}
