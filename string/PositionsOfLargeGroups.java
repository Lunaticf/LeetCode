package leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/11/1
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        // 找到多组连续的字符串 要求是最小长度为3
        // 返回他们的start 和 end index
        List<List<Integer>> res = new ArrayList<>();

        int count = 1;
        int i = 1;
        for (; i < S.length(); i++) {
            if (i == S.length() - 1 || S.charAt(i) != S.charAt(i - 1)){
                // check count > 3
                if (count >= 3) {
                    List<Integer> group = new ArrayList<>();
                    group.add(i - count);
                    group.add(i - 1);
                    res.add(group);
                }
                count = 1;
            } else {
                count++;
            }
        }
        return res;
    }
}
