package leetCode.math;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap1(int[] A, int[] B) {
        // 每个人有不同大小的糖果
        // 返回ans[0] alice必须交换的糖果大小 B交换的糖果大小
        // 交换之后 每个人的糖果大小总和相等
        // 先来个brute force 没有超时 O(N^2)
        int sumA = 0;
        int sumB = 0;
        for (int num : A) {
            sumA += num;
        }
        for (int num : B) {
            sumB += num;
        }

        for (int a : A) {
            for (int b : B) {
                if (2 * a + sumB == 2 * b + sumA) {
                    return new int[]{a, b};
                }
            }
        }

        return new int[]{};
    }


    public int[] fairCandySwap(int[] A, int[] B) {
        // 在暴力的基础上我们可以想到一种优化方法
        // 对于一个a我们其实有公式知道需要怎样的b才可以交换成功
        // 那么把所有b放到set里 时间复杂度优化到O(N)了
        int sumA = 0;
        int sumB = 0;
        for (int num : A) {
            sumA += num;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : B) {
            sumB += num;
            set.add(num);
        }

        for (int a : A) {
            int b = a + (sumB - sumA) / 2;
            if (set.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[]{};


    }
}
