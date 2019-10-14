package leetCode.hashTable.keyboardRow;

import java.util.*;
import java.util.stream.Stream;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));

        List<String> res = new ArrayList<>();
        for (String word : words) {
            int s1 = 0, s2 = 0, s3 = 0;
            for (char c : word.toCharArray()) {
                c = Character.toLowerCase(c);
                if (set1.contains(c)) {
                    s1++;
                }
                if (set2.contains(c)) {
                    s2++;
                }
                if (set3.contains(c)) {
                    s3++;
                }
            }
            if (s1 == word.length() || s2 == word.length() || s3 == word.length())              {
                res.add(word);
            }
        }


        return res.toArray(new String[res.size()]);

    }

    public String[] findWords1(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
