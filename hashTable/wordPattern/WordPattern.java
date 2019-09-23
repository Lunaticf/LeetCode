package leetCode.hashTable.wordPattern;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author Lunaticf
 * @Date 2019/9/23
 */
public class WordPattern {

    public static void main(String[] args) {
        String s1 = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s2 = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(new WordPattern().wordPattern1(s1, s2));
    }



    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Object, Integer> map = new HashMap();
        // 注意这里会自动转为key是object，而object的话-128-127是被缓存的 128没缓存！所以用==会判断不相等
        for (int i = 0; i < words.length; i++) {

            if (!Objects.equals(map.putIfAbsent(pattern.charAt(i), i), map.putIfAbsent(words[i], i))) {
                return false;
            }
        }
        return true;
    }

}
