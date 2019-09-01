package leetCode.hashTable.intersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resArr = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num1 : nums1) {
            if (hashMap.containsKey(num1)) {
                hashMap.put(num1, hashMap.get(num1) + 1);
            } else {
                hashMap.put(num1, 1);
            }
        }

        for (int num2 : nums2) {
            if (hashMap.containsKey(num2) && hashMap.get(num2) > 0) {
                resArr.add(num2);
                hashMap.put(num2, hashMap.get(num2) - 1);
            }
        }

        int[] res = new int[resArr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Integer)resArr.get(i);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> resArr = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resArr.add(nums1[i]);
                i++;j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[resArr.size()];
        for (int p = 0; p < res.length; p++) {
            res[p] = (Integer)resArr.get(p);
        }
        return res;

    }
}
