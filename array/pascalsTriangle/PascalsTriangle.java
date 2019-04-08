package LeetCode.array.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate0(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        // 直接判断前面两列
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        res.add(a1);

        if (numRows == 1) {
            return res;
        }

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);a2.add(1);
        res.add(a2);

        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 0; j < last.size() - 1; j++) {
                a.add(last.get(j) + last.get(j+1));
            }
            a.add(1);
            res.add(a);
        }

        return res;
    }

    // more concise solution
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            // add 1 in the head
            row.add(0, 1);

            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }

            res.add(new ArrayList<Integer>(row));
        }

        return res;
    }
}
