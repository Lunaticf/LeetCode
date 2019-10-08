package leetCode.hashTable.longestPalindrome;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // 大小写敏感
        // 用给定的字符构造一个最长的回文串
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }

        int res = 0;
        int odd = 0;
        for (int num : arr) {
            res += num;
            if (num % 2 == 1) {
                odd++;
            }
        }
        return odd == 0?res:res - odd + 1;
    }

    // 从反面计算
    public int longestPalindrome1(String s) {
        // 大小写敏感
        // 用给定的字符构造一个最长的回文串
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }

        int odd = 0;
        // 计算有多少个单的字母
        for (int num : arr) {
            if (num % 2 == 1) {
                odd++;
            }
        }
        // 如果有超过2个的单字母
        return odd > 1 ? s.length() - odd + 1 : s.length();
    }
}
