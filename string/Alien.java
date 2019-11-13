package leetCode.string;

import java.util.Arrays;
import java.util.Comparator;

public class Alien {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alien = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alien[order.charAt(i) - 'a'] = i;
        }

       for (int i = 1; i < words.length; i++) {
           if (!bigger(words[i], words[i - 1], alien)) {
               return false;
           }
       }
       return true;
    }

    private boolean bigger(String word, String word1, int[] alien) {
        for (int i = 0; i < word.length(); i++) {
            int idx1 = alien[word.charAt(i) - 'a'];
            int idx2 = alien[word1.charAt(i) - 'a'];
            if (idx1 > idx2) {
                return true;
            } else if (idx1 < idx2) {
                return false;
            }
        }

        return word.length() > word1.length();
    }
}
