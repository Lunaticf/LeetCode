package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/11/8
 */
public class LongPressedName {
    /**
     * 自己应该可以做出来的 明明想法都一样了 不要放弃
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        for (int j = 0; j < typed.length(); j++) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {
                i++;
            } else if (j ==0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
        }
        return i == name.length();
    }
}
