package LeetCode.recursion.fibonacciNumber;

import java.util.HashMap;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib3(4));
    }

    // iteration
    public int fib(int N) {
        if (N <= 1) return N;

        int a = 0;
        int b = 1;
        int temp = a;

        while (N-- > 1) {
            temp = a;
            a = b;
            b += temp;
        }
        return b;
    }

    // recursion 测试数据很小 没超时
    public int fib1(int N) {
        if (N <= 1) return N;
        return fib1(N - 1) + fib1(N - 2);
    }

    // recusion with memory top down
    private int[] fibCache = new int[31];

    public int fib2(int N) {
       if (N <= 1) return N;
       if (fibCache[N] != 0) return fibCache[N];
       return fibCache[N] = fib2(N - 1) + fib2(N - 2);
    }

    // recusion with memory Bottom up
    public int fib3(int N) {
        if (N <= 1) return N;

        int[] fibCache = new int[N + 1];
        fibCache[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
        }

        return fibCache[N];
    }

    private static final int[] fibs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
    public int fib4(int N) {
        return fibs[N];
    }

}
