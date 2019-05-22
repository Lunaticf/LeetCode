package LeetCode.hashTable.intersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums1) {
            hashSet.add(num);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (hashSet.contains(num)) {
                res.add(num);
                hashSet.remove(num);
            }
        }
        return res.stream().mapToInt(number -> number).toArray();
    }
}
