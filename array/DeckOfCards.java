package leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author Lunaticf
 * @Date 2019/11/6
 */
public class DeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        // 其实是求n个数的最大公约数 这个数不能为1
        // hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int d : deck) {
            int x = map.getOrDefault(d, 0) + 1;
            map.put(d, x);
        }

        int res = 0;
        for (int count : map.values()) {
            res = gcd(count, res);
        }


        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
