package LeetCode.hashTable.minimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] s1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2 =  new String[]{"KFC","Shogun","Burger King"};
        new MinimumIndexSumOfTwoLists().findRestaurant(s1, s2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])) {
                if (minIndexSum > i + hashMap.get(list2[i])) {
                    res.clear();
                    res.add(list2[i]);
                    minIndexSum = i + hashMap.get(list2[i]);
                } else if (minIndexSum == i + hashMap.get(list2[i])) {
                    res.add(list2[i]);
                }
            }
        }


        return res.toArray(new String[0]);
    }

}
