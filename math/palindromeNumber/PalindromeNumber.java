package LeetCode.math.palindromeNumber;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        for (int i = 0, j = s.length() - 1; i < j;i++, j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 有可能溢出
    // 但是如果溢出就肯定不是回文数了。
    // 回文数必然不会溢出
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;

        int reverseX = 0;
        int rawX = x;
        while (x > 0) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return rawX == reverseX;
    }

    public boolean isPalindrome2(int x) {
        // special case
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverseX = 0;
        while (x > reverseX) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return x == reverseX || x == reverseX / 10;
    }



}
