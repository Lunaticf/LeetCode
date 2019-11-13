package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestTime {
    public String largestTimeFromDigits(int[] A) {
        List<String> res = new ArrayList<>();
        permute(A, 0, res);

        if (res.size() == 0) {
            return "";
        }

        Collections.sort(res);

        String s = res.get(res.size() - 1);
        return s.substring(0, 2) + ":" + s.substring(2);
    }

    private void permute(int[] A, int cur, List<String> res) {
        if (cur == A.length - 1) {
            String temp = "";
            for (int num : A) {
                temp += num;
            }
            int hour = Integer.valueOf(temp.substring(0, 2));
            int minute = Integer.valueOf(temp.substring(2));
            if (hour < 24 && minute < 60) {
                res.add(temp);
            }

            return;
        }

        for (int i = cur; i < A.length; i++) {
            swap(A, cur, i);
            permute(A, cur + 1, res);
            swap(A, cur, i);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
