package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/10/31
 */
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        // 每一行最多100个单元
        // width代表每个字符的宽度
        // 每一行最多100个单元
        // width代表每个字符的宽度
        // 注意 每个字符写不下就不能写了
        // 每一行最多100个单元
        // width代表每个字符的宽度
        // 注意 每个字符写不下就不能写了
        int line = 1;
        int lineEmpty = 100;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            if (width <= lineEmpty) {
                lineEmpty -= width;
            } else {
                line++;
                lineEmpty = 100 - width;
            }
        }
        return new int[]{line, 100 - lineEmpty};
    }
}
