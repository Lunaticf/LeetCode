package leetCode.hashTable.findTheDifference;

/**
 * @Author Lunaticf
 * @Date 2019/9/29
 */
public class FindTheDifference {
    public static void main(String[] args) {
        new FindTheDifference().findTheDifference1("abc", "abce");
    }

    public char findTheDifference(String s, String t) {
        int[] ss = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i)-'a']++;

        }
        for (int i = 0; i < t.length(); i++) {
            ss[t.charAt(i)-'a']--;
        }
        for (int i = 0; i<ss.length; i++) {
            if (ss[i] == -1) {
                return (char)((int)'a' + i);
            }
        }
        return ' ';
    }

    public char findTheDifference3(String s, String t) {
        // 都不需要数组 直接用一个int
        int code = 0;
        for (int i = 0; i < s.length(); i++) {
            code -= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            code += t.charAt(i);
        }
        return (char)code;
    }

    public char findTheDifference1(String s, String t) {
        char c = 0;
        s = s + t;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        return c;
    }
    public char findTheDifference2(String s, String t) {
        return (char)(s + t).chars().reduce(0, (c, d) -> c ^ d);
    }

}
