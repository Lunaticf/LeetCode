package leetCode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Lunaticf
 * @Date 2019/11/1
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 还是要掌握一点正则的哦
        String[] words = paragraph.toLowerCase().split("[ ?',.;!]+");

        Set<String> set = new HashSet<>();
        for (String ban : banned) {
            set.add(ban);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int max = 0;
        String res = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }

        return res;
    }
}
