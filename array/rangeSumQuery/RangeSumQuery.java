package leetCode.array.rangeSumQuery;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @Author Lunaticf
 * @Date 2019/9/27
 */
public class RangeSumQuery {
    class NumArray {
        private int[][] cache;

        public NumArray(int[] nums) {
            cache = new int[nums.length + 1][nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    cache[i][j] = sum;
                }

            }
        }

        public int sumRange(int i, int j) {
            return cache[i][j];
        }

    }

    class NumArray1 {
        private HashMap<Pair<Integer, Integer>, Integer> map;

        public NumArray1(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    map.put(pair, sum);
                }

            }
        }

        public int sumRange(int i, int j) {
            return map.get(new Pair<>(i, j));
        }

    }

    // 最佳做法
    class NumArray2 {
        private int[] sum;
        private int[] data;

        public NumArray2(int[] nums) {
            data = nums;

            sum = new int[nums.length];
            if (nums.length != 0) {
                sum[0] = nums[0];
            }

            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }


        public int sumRange(int i, int j) {
            return sum[j] - sum[i] + data[i];
        }

    }
}
