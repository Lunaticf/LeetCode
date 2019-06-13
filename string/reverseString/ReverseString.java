package LeetCode.string.reverseString;

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;j--;
        }
    }

    // recursion
    public void reverseString1(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int i, int j, char[] s) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        helper(++i, --j, s);
    }
}
