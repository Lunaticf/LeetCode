package leetCode.hashTable.happyNumber;

import java.util.HashSet;

public class HappyNumber {
    // 求各位数平方之和
    private int fun(int n) {
        int res = 0;
        while (n != 0) {
           res += (n % 10) * (n % 10);
           n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            n = fun(n);
            if (n == 1) {
                return true;
            }
            if (hashSet.contains(n)) {
                return false;
            } else {
                hashSet.add(n);
            }
        }
    }

    public boolean isHappy1(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = fun(slow);
            fast = fun(fast);
            fast = fun(fast);
        } while (slow != fast);
        return slow == 1;
    }


    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(18));
    }
}
