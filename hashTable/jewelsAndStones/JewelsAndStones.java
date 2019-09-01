package leetCode.hashTable.jewelsAndStones;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int res  = 0;
        HashSet hashSet = new HashSet();
        for (char j: J.toCharArray()) hashSet.add(j);
        for (char s: S.toCharArray()) if (hashSet.contains(s)) res++;
        return res;
    }

    // use array beat 100%
    public int numJewelsInStones1(String J, String S) {
        boolean[] hash = new boolean[58];
        for (int i = 0; i < J.length(); i++) {
            hash[J.charAt(i) - 'A'] = true;
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (hash[S.charAt(i) -'A']) res++;
        }
        return res;
    }

    // 正则
    public int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

}
