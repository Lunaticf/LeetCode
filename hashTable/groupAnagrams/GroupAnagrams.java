package LeetCode.hashTable.groupAnagrams;

import java.util.*;

public class GroupAnagrams {

    // 时间复杂度 O(N*KLogK)
    // N为字符串个数，K为最长的字符串的长度
    // 空间复杂度：O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> res = new HashMap<>();

       for (String str : strs) {
           char[] ca = str.toCharArray();
           Arrays.sort(ca);
           String sortedStr = String.valueOf(ca);
           if (!res.containsKey(sortedStr)) {
               res.put(sortedStr, new ArrayList<>());
           }
           res.get(sortedStr).add(str);
       }

       return new ArrayList<>(res.values());
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        int counter[] = new int[26];

        for (String str : strs) {
            Arrays.fill(counter, 0);
            for (char c: str.toCharArray()) {
                counter[c - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counter.length; i++) {
                sb.append(counter[i]);
            }


            String key = sb.toString();
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
