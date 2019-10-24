package leetCode.string.repeatedStringMatch;

/**
 * @Author Lunaticf
 * @Date 2019/10/24
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int times = 0;
        StringBuilder s = new StringBuilder();
        while (s.length() < B.length()) {
            s.append(A);
            times++;
        }
        if (s.indexOf(B) >= 0) {
            return times;
        }
        s.append(A);
        if (s.indexOf(B) >= 0) {
            return times + 1;
        }
        return -1;
    }
}
