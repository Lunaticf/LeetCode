package leetCode.string.toLowerCase;

/**
 * @Author Lunaticf
 * @Date 2019/10/22
 */
public class ToLowerCase {
    public String toLowerCase1(String str) {
        return str.toLowerCase();

    }

    public String toLowerCase(String str) {
        char[] ca = str.toCharArray();
        for (int i = 0;i < ca.length; i++) {
            if (ca[i] <= 'Z' && ca[i] >= 'A') {
                ca[i] += 32;
//                ca[i] = (char) (ca[i] - 'A' + 'a');
            }
        }
        return String.valueOf(ca);
    }
}
