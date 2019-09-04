package leetCode.math.excelSheetColumnNumber;

/**
 * @Author Lunaticf
 * @Date 2019/9/4
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        int weight = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * weight;
            weight *= 26;
        }
        return res;
    }

    public int titleToNumber1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    /**
     * recur
     * @param s
     * @return
     */
    public int titleToNumber2(String s) {
        return "".equals(s) ? 0 : titleToNumber2(s.substring(0, s.length() - 1)) * 26 + (s.charAt(s.length() - 1) - 'A' + 1);
    }

    public int titleToNumber3(String s) {
        return s.chars().reduce(0, (r, ch) -> r * 26 + (ch - 'A' + 1));
    }
}
