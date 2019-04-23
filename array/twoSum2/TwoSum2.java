package LeetCode.array.twoSum2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    // map method
    public int[] twoSum(int[] numbers, int target) {
        Map m = new HashMap();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if ( m.get(target - numbers[i]) != null ) {
                res[0] = (int)m.get(target - numbers[i]) + 1;
                res[1] = i + 1;
            } else {
                m.put(numbers[i], i);
            }
        }
        return res;
    }

    // two pointer
    public int[] twoSum1(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{i + 1,j + 1};
    }
}
