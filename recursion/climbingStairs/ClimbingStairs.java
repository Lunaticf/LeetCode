package LeetCode.recursion.climbingStairs;

public class ClimbingStairs {
    // TLE
    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }



    public int climbStairs1(int n) {
        if (n <= 2) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return recur(n, cache);
    }

    private int recur(int n, int[] cache) {
        if (cache[n] != 0) return cache[n];
        return cache[n] = recur(n - 1, cache) + recur(n - 2, cache);
    }

    // 迭代
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        while (n-- > 2) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
