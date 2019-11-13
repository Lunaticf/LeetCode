package leetCode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lunaticf
 * @Date 2019/10/31
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        // 国际摩斯电码

        String[] morse = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> s = new HashSet<>();
        for (String word : words) {
            StringBuilder wordMorse = new StringBuilder();
            for (char c : word.toCharArray()) {
                wordMorse.append(morse[c - 'a']);
            }
            s.add(wordMorse.toString());
        }
        return s.size();
    }
}
