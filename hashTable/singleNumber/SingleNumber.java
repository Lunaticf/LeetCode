package LeetCode.hashTable.singleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }

    public int singleNumber1(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.remove(num);
            } else {
                hashMap.put(num, true);
            }
        }
        Integer[] res = hashMap.keySet().toArray(new Integer[0]);
        return res[0];
    }

    public int singleNumber2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int setSum = hashSet.stream().mapToInt(Integer::intValue).sum();
        return setSum * 2 - Arrays.stream(nums).sum();
    }
}
