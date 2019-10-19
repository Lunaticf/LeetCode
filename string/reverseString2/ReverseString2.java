package leetCode.string.reverseString2;

/**
 * @Author Lunaticf
 * @Date 2019/10/16
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int p = i;
            int q = i + k < s.length()? i + k - 1: s.length() - 1;
            while (p < q) {
                char temp = ca[p];
                ca[p] = ca[q];
                ca[q] = temp;
                p++;q--;
            }
        }
        return new String(ca);
    }
}
