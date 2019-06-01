package LeetCode.hashTable.containsDuplicate2;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (i - hashMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    // a little optimize
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i - hashMap.getOrDefault(nums[i], -k - 1) <= k) {
                return true;
            }

            hashMap.put(nums[i], i);
        }
        return false;
    }

    // a little more optimize beat 90%
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer temp = hashMap.put(nums[i], i);
            if (temp != null && i - temp <= k) {
                return true;
            }
        }
        return false;
    }

    // use set as a slide window
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hashSet.remove(nums[i - k - 1]);
            }

            if (!hashSet.add(nums[i])) return true;

        }
        return false;
    }




}
