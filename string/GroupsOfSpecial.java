package leetCode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lunaticf
 * @Date 2019/11/6
 */
public class GroupsOfSpecial {
    public int numSpecialEquivGroups(String[] A) {
        // 两个字符串是sp-相等 等价于
        // 交换偶数位置两个字符，交换奇数位置两个字符可以得到另一个
        // 那么跟前面一题很像，这题就是所有偶数位置上的字符可以有一个全排列的，奇数位置同理
        // 那么如果两个字符串sp，我们只需要要看它们偶数位置上的字符是否一样
        Set<String> set = new HashSet<>();
        for (String a : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    even[a.charAt(i) - 'a']++;
                } else {
                    odd[a.charAt(i) - 'a']++;
                }
            }
            set.add(Arrays.toString(odd) + Arrays.toString(even));
        }
        return set.size();

    }
}
