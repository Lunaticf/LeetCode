package leetCode.string.numberOfSegmentsInAString;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        return s.split("\\s+").length;
    }

    // 不用正则
    public int countSegments1(String s) {
        int count = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            count++;

        }
        return count;
    }

    // best smart
    public int countSegments2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 仅当该字母非空格 并且前一个是空格的时候才可以 或者是第一个字符也可
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
