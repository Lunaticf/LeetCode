package LeetCode.array.pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        while (rowIndex-- >= 0) {
            // 在前面加一个1
            res.add(0, 1);

            for (int i = 1; i < res.size() - 1; i++) {
                res.set(i, res.get(i) + res.get(i + 1));
            }
        }

        return res;
    }
}
