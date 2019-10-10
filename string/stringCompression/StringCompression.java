package leetCode.string.stringCompression;

public class StringCompression {
    public int compress(char[] chars) {

        // 那肯定双指针啊
        int prev = 0;
        int count = 1;
        for (int i = 1; i < chars.length + 1; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[prev++] = chars[i - 1];
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[prev++] = countStr.charAt(j);
                    }
                }
                count = 0;
            }
            count++;
        }
        return prev;
    }
}
