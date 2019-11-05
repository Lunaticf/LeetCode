package leetCode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        // 给两个串 都是单词组合的串 空格分隔
        // 一个单词是uncommon的如果它正好在其中一个串中出现
        Map<String, Integer> map = new HashMap<>();

        for (String a : (A + " " + B).split(" ")) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                res.add(key);}
        }
        return res.toArray(new String[res.size()]);
    }
}
