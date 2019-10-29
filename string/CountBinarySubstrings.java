package leetCode.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Lunaticf
 * @Date 2019/10/28
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                arr.add(count);
                count = 1;
            }
        }
        arr.add(count);
        int res = 0;
        for (int i = 1; i < arr.size(); i++) {
            res += Math.min(arr.get(i) , arr.get(i - 1));
        }

        return res;
    }
}
