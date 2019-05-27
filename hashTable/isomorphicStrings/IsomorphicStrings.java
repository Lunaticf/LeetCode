package LeetCode.hashTable.isomorphicStrings;

import java.util.HashMap;

public class IsomorphicStrings {

    // 两个哈希表
    public boolean isIsomorphic(String s, String t) {
        HashMap m1 = new HashMap();
        HashMap m2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }


    // 时间复杂度高一点的写法
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (hashMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                // 判断该字符对应替换的字符是否已经被用过了
                if (hashMap.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    hashMap.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "titll"));
    }
}
